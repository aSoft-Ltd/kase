plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("tz.co.asoft.library")
    id("org.jetbrains.dokka")
    signing
}

kotlin {
    jvm { library() }
    js(IR) { library() }
    val nativeTargets = linuxTargets(true)

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(projects.actionsApi)
                api(projects.kollectionsInteroperable)
            }
        }

        val commonTest by getting {
            dependencies {
                api(projects.expectCoroutines)
            }
        }
    }
}

aSoftOSSLibrary(
    version = asoft.versions.root.get(),
    description = "A kotlin multiplatform library to present common UI states"
)