package org.opengamestudio

//<!-- Shoulds -->

// Launch only once
//
// Purpose: Work around Android's activity restart
//
// Conditions:
// 1. UI has been created the first time
fun mainShouldLaunch(c: MainContext): MainContext {
    if (
        c.recentField == F.didSetup &&
        !c.didLaunch
    ) {
        c.didLaunch = true
        c.recentField = F.didLaunch
        return c
    }

    c.recentField = F.none
    return c
}

// Specify greeting text
//
// Conditions:
// 1. Did launch
// 2. Did click `Change text` button
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

fun mainCtrlCtx(): MainContext {
    return MainProto.ctrl.context as MainContext
}

fun mainCtrlCtxField(): String {
    return MainProto.ctrl.context.recentField
}

fun mainSet(k: String, v: Any) {
    MainProto.ctrl.set(k, v)
}
