package org.opengamestudio

import android.content.Context
import android.content.SharedPreferences

object SaveManager {
    private const val PREFS_NAME = "todo_app_prefs"
    private const val KEY_TASKS = "tasks"

    private lateinit var prefs: SharedPreferences

    fun init(context: Context) {
        prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }
    fun saveTasksRaw(tasksString: String) {
        prefs.edit().putString(KEY_TASKS, tasksString).apply()
    }
    fun loadTasksRaw(): String {
        return prefs.getString(KEY_TASKS, "") ?: ""
    }
}