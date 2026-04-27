plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    mingwX64("native") {
        binaries {
            sharedLib {
                baseName = "libhw"
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
