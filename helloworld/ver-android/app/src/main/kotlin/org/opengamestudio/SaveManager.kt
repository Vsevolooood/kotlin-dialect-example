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

        fun saveTasks(tasks: Array<MainItem>) {
            val tasksStr = tasks.joinToString(";") { "${it.title}:${it.isDone}" }
            prefs.edit().putString(KEY_TASKS, tasksStr).apply()
        }

        fun loadTasks(): Array<MainItem> {
            val tasksStr = prefs.getString(KEY_TASKS, "") ?: ""
            if (tasksStr.isEmpty()) return emptyArray()

            return tasksStr.split(";")
                .mapNotNull { part ->
                    val split = part.split(":")
                    if (split.size == 2) {
                        MainItem(title = split[0], isDone = split[1].toBoolean())
                    } else null
                }.toTypedArray()
        }

    fun saveIsVisible(isVisible: Boolean) {
        prefs.edit().putBoolean(KEY_IS_VISIBLE, isVisible).apply()
    }

    fun loadIsVisible(): Boolean {
        return prefs.getBoolean(KEY_IS_VISIBLE, false)
    }
}