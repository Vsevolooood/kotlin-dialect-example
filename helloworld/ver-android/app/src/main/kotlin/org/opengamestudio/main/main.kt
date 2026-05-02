// MainComponent.kt
package org.opengamestudio

typealias MC = MainContext

object MainComponent {
    init {
        val vm = VM
        val oneliners = arrayOf(
            F.isVisible, { c: MC -> vm.mainIsVisible.value = c.isVisible },
            F.taskTitle, { c: MC -> vm.mainTaskTitle.value = c.taskTitle },
            F.tasks, { c: MC ->
                vm.tasks.clear()
                vm.tasks.addAll(c.tasks)
            },
            F.loadTasks, { c: MC -> mainLoadTasks() },
            F.shouldSavaTasks, {c: MC -> mainSaveTasks(c) }
        )
        registerOneliners(mainCtrl(), oneliners)
    }

    fun setup() {
        mainSet(F.didLaunch, true)
    }

    fun mainSaveTasks(c: MainContext){
        try {
            val tasksString = formatTasksToString(c.tasks)
            SaveManager.saveTasksRaw(tasksString)
        } catch (e: Exception) {
          e.printStackTrace()
        }

    }
    fun mainLoadTasks() {
        try {
            val tasksString = SaveManager.loadTasksRaw()
            if (tasksString.isNotEmpty()) {
                val tasks = parseTasksString(tasksString)
                mainSet(F.tasks, tasks)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}