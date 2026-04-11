package org.opengamestudio
import android.content.Context
import androidx.compose.runtime.mutableStateOf

object VM {
    var androidContext: Context? = null
    var mainTaskTitle = mutableStateOf("")
    var mainIsVisible = mutableStateOf(false)
    var tasks = mutableStateOf(emptyMap<String, Boolean>())  // одна мапа
}