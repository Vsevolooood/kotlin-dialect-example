package org.opengamestudio

//<!-- Shoulds -->

// Specify greeting text
//
// Conditions:
// 1. Did launch
// 2. Did click `Change text` button
fun mainShouldResetGreetingText(c: MainContext): MainContext {
    if (c.recentField == "didLaunch") {
        c.greetingText = "Hello, World!"
        c.recentField = "greetingText"
        return c
    }

    if (c.recentField == "didClickChangeText") {
        c.greetingText = "Умом Россию не понять!"
        c.recentField = "greetingText"
        return c
    }

    c.recentField = "none"
    return c
}

// Set `main` window visible
//
// Conditions:
// 1. Did launch
fun mainShouldResetVisibility(c: MainContext): MainContext {
    if (c.recentField == "didLaunch") {
        c.isVisible = true
        c.recentField = "isVisible"
        return c
    }

    c.recentField = "none"
    return c
}

//<!-- Other functions -->

fun mainCtrl(): KDController {
    return MainProto.ctrl
}

fun mainSet(k: String, v: Any) {
    MainProto.ctrl.set(k, v)
}

