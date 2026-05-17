package org.opengamestudio

object SaveManager {
    private var tasks: String = ""

    fun init() {
    }

    fun saveTasksRaw(tasksString: String) {
        tasks = tasksString
    }

    fun loadTasksRaw(): String {
        return tasks
    }
}