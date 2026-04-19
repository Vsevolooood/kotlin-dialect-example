package org.opengamestudio

// функции загрузки

fun mainSouldLoadTasksFromPreferences(c: MainContext): MainContext {
    if (c.recentField == F.didLaunch) {
        try {
            val tasksString = SaveManager.loadTasksRaw()
            if (tasksString.isNotEmpty()) {
                c.tasks = parseTasksString(tasksString)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        c.recentField = F.tasks
        return c
    }
    c.recentField = F.none
    return c
}



// ФУНКЦИИ СОХРАНЕНИЯ

fun mainSouldSaveTasksToPreferences(c: MainContext): MainContext {
    if (c.recentField == F.tasks) {
        try {
            val tasksString = formatTasksToString(c.tasks)
            SaveManager.saveTasksRaw(tasksString)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        c.recentField = F.none
        return c
    }
    c.recentField = F.none
    return c
}

// ВСПОМОГАТЕЛЬНЫЕ ФУНКЦИИ

fun formatTasksToString(tasks: Array<MainItem>): String {
    return tasks.joinToString("|") { "${it.title}&${it.isDone}" }
}

fun parseTasksString(tasksString: String): Array<MainItem> {
    if (tasksString.isEmpty()) return emptyArray()

    return tasksString.split("|")
        .mapNotNull { part ->
            val split = part.split("&")
            if (split.size == 2) {
                MainItem(title = split[0], isDone = split[1].toBoolean())
            } else null
        }.toTypedArray()
}

//  ФУНКЦИИ РАБОТЫ С UI

fun mainShouldAddTask(c: MainContext): MainContext {
    if (c.recentField == F.didClickSaveText) {
        if (c.taskTitle.isNotBlank()) {
            c.tasks = c.tasks + MainItem(title = c.taskTitle, isDone = false)
            c.recentField = F.tasks  // Сообщаем, что изменилось поле tasks
            return c
        }
    }
    c.recentField = F.none
    return c
}

fun mainShouldClearTaskTitle(c: MainContext): MainContext {
    if (c.recentField == F.didClickSaveText) {
        if (c.taskTitle.isNotBlank()) {  // Проверяем то же условие
            c.taskTitle = ""
            c.recentField = F.taskTitle  // Сообщаем, что изменилось поле taskTitle
            return c
        }
    }
    c.recentField = F.none
    return c
}

fun mainShouldUpdateTaskList(c: MainContext): MainContext {
    if (c.recentField == F.toggledTaskTitle) {
        val updatedTasks = c.tasks.map { task ->
            if (task.title == c.toggledTaskTitle) {
                MainItem(title = task.title, isDone = !task.isDone)
            } else {
                task
            }
        }.toTypedArray()
        c.tasks = updatedTasks
        c.recentField = F.tasks
        c.toggledTaskTitle = ""
        return c
    }
    c.recentField = F.none
    return c
}

fun mainShouldResetTaskTitle(c: MainContext): MainContext {
    if (c.recentField == F.didClickSaveText) {
        c.taskTitle = ""
        c.recentField = F.taskTitle
        return c
    }
    c.recentField = F.none
    return c
}

fun mainShouldResetVisibility(c: MainContext): MainContext {
    if (c.recentField == F.didLaunch) {
        c.isVisible = true
        c.recentField = F.isVisible
        return c
    }
    c.recentField = F.none
    return c
}

fun mainCtrl(): KDController {
    return MainProto.ctrl
}

fun mainSet(k: String, v: Any) {
    MainProto.ctrl.set(k, v)
}