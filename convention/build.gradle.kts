plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
    alias(grunt.plugins.ksp)
    alias(grunt.plugins.jacoco)
}

dependencies {
    implementation(platform(grunt.koin.bom))
    implementation(grunt.bundles.koin.nonandroid)
    implementation(grunt.koin.annotation)
    implementation(platform(grunt.koin.annotation.bom))
    ksp(grunt.koin.annotation.compiler)
    compileOnly(grunt.plugin.agp)
    compileOnly(grunt.plugin.kgp)
    compileOnly(grunt.plugin.ksp)
    compileOnly(grunt.plugin.detekt)
    testImplementation(grunt.junit.jupiter)
    testImplementation(grunt.junit.jupiter.api)
    testImplementation(grunt.mockk)
    testRuntimeOnly(grunt.junit.jupiter.engine)
    testImplementation(kotlin("test"))
    testImplementation(gradleTestKit())
}

extensions.configure<JacocoPluginExtension> {
    toolVersion = grunt.versions.jacoco.get()
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<Test>().configureEach {
    if (name.startsWith("test") && name.endsWith("UnitTest")) {
        extensions.configure(JacocoTaskExtension::class) {
            isIncludeNoLocationClasses = true
            excludes = listOf("jdk.internal.*")
        }
    }
}

afterEvaluate {
    tasks.withType<JacocoReport> {
        group = "verification"
        val testTask = tasks.named("test")
        dependsOn(testTask)
        classDirectories.setFrom(
            fileTree(layout.buildDirectory.dir("classes/kotlin/main/com"))
        )
        val sources = listOf(
            layout.projectDirectory.file("src/main/kotlin")
        )
        sourceDirectories.setFrom(sources)
        executionData.setFrom(
            layout.buildDirectory.dir("jacoco").get()
                .asFileTree.matching { include("**/test.exec") }
        )
        reports {
            xml.required.set(true)
            html.required.set(true)
        }
    }
}

gradlePlugin {
    plugins {
        register("detekt") {
            id = "com.gruntsoftware.buildlogic.detekt"
            implementationClass = "com.gruntsoftware.buildlogic.common.plugins.DetektConventionPlugin"
        }
        register("androidTest") {
            id = "com.gruntsoftware.buildlogic.test"
            implementationClass = "com.gruntsoftware.buildlogic.android.plugins.TestConventionPlugin"
        }
    }
}
