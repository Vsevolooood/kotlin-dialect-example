package org.opengamestudio

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import org.opengamestudio.ui.theme.MyApplicationTheme

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val vm = VM
        vm.androidContext = this
        SaveManager.init(this)
        MainComponent.setup()
        setContent {
            MyApplicationTheme {
                MainView(vm = vm)
            }
        }
    }
}