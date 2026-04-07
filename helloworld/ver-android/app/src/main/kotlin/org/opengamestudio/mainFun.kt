package org.opengamestudio

//<!-- Shoulds -->

// Specify greeting text
//
// Conditions:
// 1. Did launch
// 2. Did click `Change text` button

fun mainShouldIncrementCounter(c: MainContext): MainContext {
    if (c.recentField == F.didClickChangeText) {
        c.counter += 1
        c.recentField = F.counter
        return c
    }

    c.recentField = F.none
    return c
}
fun mainShouldResetGreetingText(c: MainContext): MainContext {
    if (c.recentField == F.didLaunch) {
        c.greetingText = "Hello, World!"
        c.recentField = F.greetingText
        return c
    }

    if (c.recentField == F.didClickChangeText) {
        c.greetingText = "Умом Россию не понять!"
        c.recentField = F.greetingText
        return c
    }

    c.recentField = F.none
    return c
}

// Set `main` window visible
//
// Conditions:
// 1. Did launch
fun mainShouldResetVisibility(c: MainContext): MainContext {
    if (c.recentField == F.didLaunch) {
        c.isVisible = true
        c.recentField = F.isVisible
        return c
    }

    c.recentField = F.none
    return c
}

//<!-- Other functions -->

fun mainCtrl(): KDController {
    return MainProto.ctrl
}

fun mainSet(k: String, v: Any) {
    MainProto.ctrl.set(k, v)
}