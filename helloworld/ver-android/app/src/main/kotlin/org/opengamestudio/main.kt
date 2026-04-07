package org.opengamestudio

//<!-- Component -->

typealias MC = MainContext

object MainComponent {
    init {
        val vm = VM
        val oneliners = arrayOf(
            F.isVisible, { c: MC -> vm.mainIsVisible.value = c.isVisible },
            F.greetingText, { c: MC ->
                vm.mainGreetingText.value = c.greetingText
                vm.mainCounter.value = c.counter},
            F.counter, {c: MC -> vm.mainCounter.value = c.counter }
        )
        registerOneliners(mainCtrl(), oneliners)
    }

    fun setup() {
        mainSet(F.didLaunch, true)
    }
}