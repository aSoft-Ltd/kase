pluginManagement {
    enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
    dependencyResolutionManagement {
        versionCatalogs {
            file("../versions/gradle/versions").listFiles().map {
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

rootProject.name = "kase"

includeBuild("../able")

includeSubs("kommander", "../kommander", "core")
includeSubs("kollections", "../kollections", "interoperable")
includeSubs("kevlar", "../kevlar", "core")

includeSubs("kase", ".", "core")