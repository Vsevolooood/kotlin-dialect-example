package org.opengamestudio
import android.content.Context
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf

object VM {
    var androidContext: Context? = null

    var mainGreetingText = mutableStateOf("TODO-Text")
    var mainIsVisible = mutableStateOf(false)
}
