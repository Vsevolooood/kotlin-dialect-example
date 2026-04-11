package org.opengamestudio

fun mainSaveTaskInArray(c: MainContext): MainContext {
    if (c.recentField == F.didClickSaveText) {
        if (c.TaskTitle.isNotBlank()) {
            c.tasks = c.tasks + (c.TaskTitle to false)
            c.TaskTitle = ""
            c.recentField = F.tasks
            return c
        }
    }
    c.recentField = F.none
    return c
}

fun mainToggleTaskCompletion(c: MainContext): MainContext {
    if (c.recentField == F.tasks) {
        c.recentField = F.tasks
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