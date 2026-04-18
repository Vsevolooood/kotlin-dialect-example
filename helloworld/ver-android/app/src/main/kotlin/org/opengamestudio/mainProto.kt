package org.opengamestudio

object MainProto {
    val ctrl: KDController

    init {
        ctrl = KDController(MainContext())

        arrayOf(
            ::mainSouldLoadTasksFromPreferences,
            ::mainShouldAddTask,
            ::mainShouldClearTaskTitle,
            ::mainShouldResetVisibility,
            ::mainShouldUpdateTaskList,
            ::mainSouldSaveTasksToPreferences,

        ).forEach { f ->
            ctrl.registerFunction { c -> f(c as MainContext) }
        }
    }
}