package org.opengamestudio

import android.content.Context
import android.content.SharedPreferences

object SaveManager {
    private const val PREFS_NAME = "todo_app_prefs"
    private const val KEY_TASKS = "tasks"
    private const val KEY_IS_VISIBLE = "is_visible"

    private lateinit var prefs: SharedPreferences

    fun init(context: Context) {
        prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun saveTasks(tasks: Map<String, Boolean>) {
        val tasksStr = tasks.entries.joinToString(";") { "${it.key}:${it.value}" }
        prefs.edit().putString(KEY_TASKS, tasksStr).apply()
    }

    fun loadTasks(): Map<String, Boolean> {
        val tasksStr = prefs.getString(KEY_TASKS, "") ?: ""
        if (tasksStr.isEmpty()) return emptyMap()

        return tasksStr.split(";")
            .mapNotNull { part ->
                val split = part.split(":")
                if (split.size == 2) split[0] to split[1].toBoolean() else null
            }
            .toMap()
    }

    fun saveIsVisible(isVisible: Boolean) {
        prefs.edit().putBoolean(KEY_IS_VISIBLE, isVisible).apply()
    }

    fun loadIsVisible(): Boolean {
        return prefs.getBoolean(KEY_IS_VISIBLE, false)
    }
}