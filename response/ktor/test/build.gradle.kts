import org.jetbrains.kotlin.gradle.targets.js.ir.KotlinJsIrLink
import types.purifyTypescriptDefinitions

plugins {
    kotlin("multiplatform")
    id("tz.co.asoft.library")
    id("dev.petuska.npm.publish")
}

kotlin {
    js(IR) {
        val main by compilations
        main.outputModuleName = "response-ktor-react"
        browserLib {
            commonWebpackConfig {
                sourceMaps = false
            }
        }
//        useEsModules()
        generateTypeScriptDefinitions()
        binaries.library()
    }

    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(projects.kaseResponseKtorClient)
                implementation(projects.kaseCore)
            }
        }

        val jsTest by getting {
            dependencies {
                implementation(libs.kommander.coroutines)
            }
        }
    }
}

npmPublish {
    organization.set("kase")
    registries {
        register("andylamax") {
            uri.set("http://localhost:1040")
            authToken.set("andylamax")
        }
    }

    packages {
        val js by getting {
            version.set("${project.version}")
            packageName.set("response-ktor-react")
            files {
                builtBy("splitTypescriptDefinition")
                from(layout.buildDirectory.dir("typescript"))
            }
            packageJson {
                types.set("types/kase.d.ts")

                repository {
                    type.set("git")
                    url.set("https://github.com/picortex/picapital.git")
                }

                devDependencies {
                    set("@types/react", kotlinw.versions.react.types.get())
                }
            }
        }
    }
}

val compileSync = tasks.withType<KotlinJsIrLink>().matching {
    it.name.contains("prod", ignoreCase = true)
}.first()

purifyTypescriptDefinitions {
    directory.set(compileSync.destinationDirectory)
    dependsOn(compileSync)
}