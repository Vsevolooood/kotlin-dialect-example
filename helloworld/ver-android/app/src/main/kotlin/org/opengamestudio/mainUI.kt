package org.opengamestudio

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.opengamestudio.ui.theme.MyApplicationTheme

@Composable
fun MainView(
    modifier: Modifier = Modifier,
    vm: VM,
    //onAddTask: (String) -> Unit,  // Callback for adding task
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
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Task list
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .background(Color.LightGray),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(vm.tasks) { task ->
                        Text(
                            text = task,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        if (vm.mainTaskTitle.value.isNotBlank()) {
                            vm.tasks.add(vm.mainTaskTitle.value)
                           // onAddTask(vm.mainTaskTitle.value)
                            vm.mainTaskTitle.value = ""  // Clear input after adding
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