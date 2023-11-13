pluginManagement {
    includeBuild("../build-logic")
}

plugins {
    id("multimodule")
}

fun includeSubs(base: String, path: String = base, vararg subs: String) {
    subs.forEach {
        include(":$base-$it")
        project(":$base-$it").projectDir = File("$path/$it")
    }
}

listOf(
    "kommander", "kollections", "lexi"
).forEach { includeBuild("../$it") }

rootProject.name = "kase"

includeSubs("kase", ".", "possible", "optional", "core", "response")
includeSubs("kase-response", "response", "core")
includeSubs("kase-response-ktor", "response/ktor", "client", "server")
