package org.opengamestudio

//<!-- Component -->

typealias MC = MainContext

object MainComponent {
    init {
        val vm = VM
        val oneliners = arrayOf(
            F.isVisible, { c: MC -> vm.mainIsVisible.value = c.isVisible },
            F.TaskTitle, { c: MC -> vm.mainTaskTitle.value = c.TaskTitle},
            F.tasksList, { c: MC -> vm.tasks.value = c.tasksList },
            F.completedTasks, { c: MC -> vm.completedTasks.value = c.completedTasks}
        )
        registerOneliners(mainCtrl(), oneliners)
    }

    fun setup() {
        mainSet(F.didLaunch, true)
    }
}