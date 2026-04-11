package org.opengamestudio

object MainProto {
    val ctrl: KDController

    init {
        ctrl = KDController(MainContext())
        setupComponentDebugging(ctrl, "Main")
        arrayOf(
            ::mainSaveTaskInArray,
            ::mainShouldResetVisibility,
            ::mainClearTaskTitle
        ).forEach { f ->
            ctrl.registerFunction { c -> f(c as MainContext) }
        }
    }
}