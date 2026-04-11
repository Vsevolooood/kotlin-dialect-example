package org.opengamestudio

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp

@Composable
fun MainView(
    modifier: Modifier = Modifier,
    vm: VM
) {
    AnimatedVisibility(
        enter = fadeIn(),
        exit = fadeOut(),
        modifier = modifier,
        visible = vm.mainIsVisible.value,
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {
                OutlinedTextField(
                    label = { Text("Задача") },
                    value = vm.mainTaskTitle.value,
                    onValueChange = { vm.mainTaskTitle.value = it },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(
                        imeAction = androidx.compose.ui.text.input.ImeAction.Done
                    ),
                    keyboardActions = androidx.compose.foundation.text.KeyboardActions(
                        onDone = {
                            if (vm.mainTaskTitle.value.isNotBlank()) {
                                mainSet(F.TaskTitle, vm.mainTaskTitle.value)
                                mainSet(F.didClickSaveText, true)
                            }
                        }
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Task list
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f, fill = false)
                        .background(Color.LightGray),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(vm.tasks.value.toList()) { task ->
                        val isCompleted = vm.completedTasks.value.contains(task)

                        Text(
                            text = task,
                            modifier = Modifier
                                .padding(8.dp)
                                .clickable {
                                    val currentSet = vm.completedTasks.value.toMutableSet()
                                    if (isCompleted) {
                                        currentSet.remove(task)
                                    } else {
                                        currentSet.add(task)
                                    }
                                    mainSet(F.completedTasks, currentSet)
                                },
                            textDecoration = if (isCompleted)
                                TextDecoration.LineThrough
                            else
                                TextDecoration.None,
                            color = if (isCompleted) Color.Gray else Color.Black
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        if (vm.mainTaskTitle.value.isNotBlank()) {
                            mainSet(F.TaskTitle, vm.mainTaskTitle.value)
                            mainSet(F.didClickSaveText, true)
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Задать задачу")
                }
            }
        }
    }
}