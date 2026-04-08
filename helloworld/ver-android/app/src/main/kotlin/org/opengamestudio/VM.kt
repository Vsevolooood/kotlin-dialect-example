package org.opengamestudio
import android.content.Context
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf

object VM {
    var androidContext: Context? = null
    var mainCounter = mutableStateOf(0)

    var mainTaskTitle = mutableStateOf("TODO-Text")
    var mainIsVisible = mutableStateOf(false)
    var  tasks = mutableStateListOf<String>()
}