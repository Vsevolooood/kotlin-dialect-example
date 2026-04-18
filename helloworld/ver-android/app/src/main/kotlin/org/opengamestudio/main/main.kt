package org.opengamestudio

//<!-- Component -->

typealias MC = MainContext

object MainComponent {
    init {
        val vm = VM
        val oneliners = arrayOf(
            F.greetingText, { c: MC -> vm.mainGreetingText.value = c.greetingText },
            F.isVisible, { c: MC -> vm.mainIsVisible.value = c.isVisible },
        )
        registerOneliners(mainCtrl(), oneliners)
    }

    fun setup() {
        mainSet(F.didSetup, true)
    }
}
