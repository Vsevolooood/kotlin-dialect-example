package org.opengamestudio

object MainProto {
    val ctrl: KDController

    init {
        val savedTasks = SaveManager.loadTasks()
        val savedIsVisible = SaveManager.loadIsVisible()

        val initialContext = MainContext(
            TaskTitle = "",
            didClickSaveText = false,
            didLaunch = false,
            isVisible = savedIsVisible,
            tasks = savedTasks
        )

        ctrl = KDController(initialContext)
        VM.tasks.value = savedTasks
        VM.mainIsVisible.value = savedIsVisible
        setupComponentDebugging(ctrl, "Main")
        arrayOf(
            ::mainShouldResetTasks,
            ::mainShouldResetVisibility,
            ::mainShouldResetTaskTitle,
        ).forEach { f ->
            ctrl.registerFunction { c -> f(c as MainContext) }
        }
    }
}