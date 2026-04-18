package org.opengamestudio

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainView(vm: VM) {
    AnimatedVisibility(
        enter = fadeIn(),
        exit = fadeOut(),
        modifier = Modifier,
        visible = vm.mainIsVisible.value,
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(vm.mainGreetingText.value)
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedButton(
                    onClick = { mainSet("didClickChangeText", true) },
                ) {
                    Text("Change text")
                }
            }
        }
    }
}
