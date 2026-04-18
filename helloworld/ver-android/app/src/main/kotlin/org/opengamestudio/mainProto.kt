package org.opengamestudio

object MainProto {
    val ctrl: KDController

    init {
            // Пустой начальный контекст (данные загрузятся через редюсеры)
            val initialContext = MainContext(
                taskTitle = "",
                didClickSaveText = false,
                didLaunch = false,
                isVisible = false,  // Временное значение
                tasks = emptyArray(),  // Временное значение
                didClickResetTasks = false,
                recentField = ""
            )


        ctrl = KDController(initialContext)

        arrayOf(
            ::mainSouldLoadTasksFromPreferences,
            ::mainShouldResetTasks,
            ::mainShouldResetVisibility,
            ::mainShouldResetTaskTitle,
            ::mainShouldUpdateTaskList,
            ::mainSouldSaveTasksToPreferences,

        ).forEach { f ->
            ctrl.registerFunction { c -> f(c as MainContext) }
        }
    }
}