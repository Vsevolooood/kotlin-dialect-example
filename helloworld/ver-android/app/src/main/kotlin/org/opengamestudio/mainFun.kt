package org.opengamestudio

fun mainSaveTaskInArray(c: MainContext): MainContext {
    if (c.recentField == F.didClickSaveText) {
        if (c.TaskTitle.isNotBlank()) {
            // Добавляем задачу
            val newList = c.tasksList.toMutableList()
            newList.add(c.TaskTitle)
            c.tasksList = newList.toTypedArray()
            c.TaskTitle = ""
            c.recentField = F.tasksList
            return c
        }
    }
    c.recentField = F.none
    return c
}
fun mainToggleTaskCompletion(c: MainContext): MainContext {
    if (c.recentField == F.completedTasksIndices) {

        c.recentField = F.completedTasksIndices
        return c
    }
    c.recentField = F.none
    return c
}
fun mainClearTaskTitle(c: MainContext): MainContext {
    if (c.recentField == F.didClickSaveText) {
        c.TaskTitle = ""
        c.recentField = F.TaskTitle
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

//<!-- Other functions -->

fun mainCtrl(): KDController {
    return MainProto.ctrl
}

fun mainSet(k: String, v: Any) {
    MainProto.ctrl.set(k, v)
}