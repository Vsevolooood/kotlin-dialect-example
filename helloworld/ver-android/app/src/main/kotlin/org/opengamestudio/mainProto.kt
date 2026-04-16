package org.opengamestudio

object MainProto {
    val ctrl: KDController

    init {
        val savedTasks = SaveManager.loadTasks()
        val savedIsVisible = SaveManager.loadIsVisible()

        val initialContext = MainContext(
            taskTitle = "",
            didClickSaveText = false,
            didLaunch = false,
            isVisible = savedIsVisible,
            tasks = savedTasks,
            didClickResetTasks = false,
            recentField = ""
        )

        ctrl = KDController(initialContext)
        VM.tasks.clear()
        VM.tasks.addAll(savedTasks.toList())
        VM.mainIsVisible.value = savedIsVisible

        arrayOf(
            ::mainShouldResetTasks,
            ::mainShouldResetVisibility,
            ::mainShouldResetTaskTitle,
            ::mainShouldUpdateTaskList
        ).forEach { f ->
            ctrl.registerFunction { c -> f(c as MainContext) }
        }
    }
}