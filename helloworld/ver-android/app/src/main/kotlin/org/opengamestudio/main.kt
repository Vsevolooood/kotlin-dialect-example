package org.opengamestudio

//<!-- Component -->

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
    }

    fun setup() {
        mainSet(F.didLaunch, true)
    }
}