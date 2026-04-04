package org.opengamestudio

//<!-- Component -->

typealias MC = MainContext

object MainComponent {
    init {
    }

    fun setup() {
        mainSet(F.didLaunch, true)
    }
}
