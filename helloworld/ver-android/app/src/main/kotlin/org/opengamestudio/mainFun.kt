package org.opengamestudio

//<!-- Shoulds -->

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

