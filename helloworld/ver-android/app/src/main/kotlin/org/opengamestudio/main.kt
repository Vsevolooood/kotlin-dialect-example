package org.opengamestudio

//<!-- Component -->

typealias MC = MainContext

object MainComponent {
    init {
        val vm = VM
        val oneliners = arrayOf(
            "isVisible", { c: MC -> vm.mainIsVisible.value = c.isVisible },
        )
        registerOneliners(mainCtrl(), oneliners)
    }

    fun setup() {
        mainSet("didLaunch", true)
    }
}
