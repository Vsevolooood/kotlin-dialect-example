package org.opengamestudio

object MainProto {
    val ctrl: KDController

    init {
        ctrl = KDController(MainContext())

        arrayOf(
            ::mainSouldLoadTasksFromPreferences,
            ::mainShouldClearTaskTitle,
            ::mainShouldResetVisibility,
            ::mainSouldSaveTasksToPreferences,
            ::shouldResetTasks


        ).forEach { f ->
            ctrl.registerFunction { c -> f(c as MainContext) }
        }
    }
}