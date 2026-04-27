plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    macosX64("native") {
        binaries {
            sharedLib {
                baseName = "hw"
            }
        }
    }
    sourceSets {
        nativeMain.dependencies {
        }
    }
}

tasks.withType<Wrapper> {
    distributionType = Wrapper.DistributionType.ALL
}
