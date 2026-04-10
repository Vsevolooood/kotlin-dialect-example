package org.opengamestudio

object MainProto {
    val ctrl: KDController

    init {
        ctrl = KDController(MainContext())
        setupComponentDebugging(ctrl, "Main")
        arrayOf(
            ::mainSaveTaskInArray,
            ::mainShouldResetVisibility,
            ::mainClearTaskTitle,
            ::mainToggleTaskCompletion
        ).forEach { f ->
            ctrl.registerFunction { c -> f(c as MainContext) }
        }
    }
}