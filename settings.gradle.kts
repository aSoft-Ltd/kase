pluginManagement {
    enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
    dependencyResolutionManagement {
        versionCatalogs {
            file("gradle/versions").listFiles().map {
                it.nameWithoutExtension to it.absolutePath
            }.forEach { (name, path) ->
                create(name) { from(files(path)) }
            }
        }
    }
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
        mavenLocal()
    }

}

fun includeRoot(name: String, path: String) {
    include(":$name")
    project(":$name").projectDir = File(path)
}

fun includeSubs(base: String, path: String = base, vararg subs: String) {
    subs.forEach {
        include(":$base-$it")
        project(":$base-$it").projectDir = File("$path/$it")
    }
}

val tmp = 1

rootProject.name = "presenters"

includeSubs("functions", "../functions", "core")
includeSubs("expect", "../expect", "core", "coroutines")
includeSubs("koncurrent-primitives", "../koncurrent/primitives", "core", "coroutines", "mock")
includeSubs("koncurrent-later", "../koncurrent/later", "core", "coroutines", "test")
includeSubs("kollections", "../kollections", "interoperable")
includeSubs("live", "../live", "core", "coroutines", "test")
includeSubs("cache", "../cache", "api", "file", "test", "mock")
includeSubs("viewmodel", "../viewmodel", "core")
includeSubs("identifier", "../identifier", "core")
includeSubs("formatter", "../formatter", "core")

includeBuild("../geo/geo-generator")
includeSubs("geo", "../geo", "core", "countries")

includeBuild("../kash/kash-generator")
includeSubs("kash", "../kash", "currency", "money")
// dependencies

includeSubs("krono", "../krono", "api")

includeSubs("presenters", ".", "states", "actions", "misc")
includeSubs("presenters-collections", "collections", "core")
includeSubs("presenters-collections-renderers", "collections/renderers", "string", "console")
includeSubs("presenters-inputs", "inputs", "core", "identifier", "geo", "kash", "krono")