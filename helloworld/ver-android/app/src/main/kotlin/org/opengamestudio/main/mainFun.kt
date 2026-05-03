package org.opengamestudio

// функции загрузки

fun mainSouldLoadTasksFromPreferences(c: MainContext): MainContext {
    if (c.recentField == F.didLaunch) {
        c.loadTasks = true
        c.recentField = F.loadTasks
        return c
    }
    c.recentField = F.none
    return c
}



// ФУНКЦИИ СОХРАНЕНИЯ
fun mainSouldSaveTasksToPreferences(c: MainContext): MainContext {
    if (c.recentField == F.tasks) {
        c.shouldSavaTasks = true
        c.recentField = F.shouldSavaTasks
        return c
    }
    c.recentField = F.none
    return c
}
// ВСПОМОГАТЕЛЬНЫЕ ФУНКЦИИ

fun formatTasksToString(tasks: Array<MainItem>): String {
    return tasks.joinToString("|") { "${it.id}&${it.title}&${it.isDone}" }
}

fun parseTasksString(tasksString: String): Array<MainItem> {
    if (tasksString.isEmpty()) return emptyArray()

    return tasksString.split("|")
        .mapNotNull { part ->
            val split = part.split("&")
            if (split.size == 3) {
                MainItem(
                    id = split[0],
                    title = split[1],
                    isDone = split[2].toBoolean()
                )
            } else null
        }.toTypedArray()
}

//  ФУНКЦИИ РАБОТЫ С UI

fun shouldResetTasks(c: MainContext): MainContext {
    if (c.recentField == F.didClickSaveText && c.taskTitle.isNotBlank()) {
        c.tasks = c.tasks + MainItem( id = java.util.UUID.randomUUID().toString(), title = c.taskTitle, isDone = false)
        c.recentField = F.tasks
        return c
    }
    if (c.recentField == F.didClickRemoveTasks){
        c.tasks =  c.tasks.filter { !it.isDone }.toTypedArray()
        c.recentField = F.tasks
        return c
    }
    if (c.recentField == F.didSelectTask && c.didSelectTask.isNotBlank()) {
        c.tasks = c.tasks.map { task ->
            if (task.id == c.didSelectTask) {
                MainItem(id = task.id, title = task.title, isDone = !task.isDone)
            } else {
                task
            }
        }.toTypedArray()
        c.recentField = F.tasks
        return c
    }
    c.recentField = F.none
    return c
}

fun mainShouldClearTaskTitle(c: MainContext): MainContext {
    if (c.recentField == F.didClickSaveText && c.taskTitle.isNotBlank()) {
            c.taskTitle = ""
            c.recentField = F.taskTitle  // Сообщаем, что изменилось поле taskTitle
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
