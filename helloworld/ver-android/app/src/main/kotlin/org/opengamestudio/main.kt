package org.opengamestudio

typealias MC = MainContext

object MainComponent {
    init {
        val vm = VM
        val oneliners = arrayOf(
            F.isVisible, { c: MC -> vm.mainIsVisible.value = c.isVisible },
            F.TaskTitle, { c: MC -> vm.mainTaskTitle.value = c.TaskTitle},
            F.tasks, { c: MC -> vm.tasks.value = c.tasks }
        )
        registerOneliners(mainCtrl(), oneliners)
        mainCtrl().registerFieldCallback(F.tasks) { c ->
            SaveManager.saveTasks((c as MC).tasks)
        }

        mainCtrl().registerFieldCallback(F.isVisible) { c ->
            SaveManager.saveIsVisible((c as MC).isVisible)
        }
    }

    fun setup() {
        mainSet(F.didLaunch, true)
    }
}