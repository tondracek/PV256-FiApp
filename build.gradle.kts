// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
    dependencies {

        classpath(Versions.gradlePlugin)
        classpath(kotlin("gradle-plugin", version = Versions.kotlinVersion))
        classpath("com.google.protobuf:protobuf-gradle-plugin:0.9.4")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}



allprojects {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
//        maven {
//            setUrl("https://dl.bintray.com/gigamole/maven/")
//        }
        maven { setUrl("https://jitpack.io") }
//        maven { setUrl("https://raw.githubusercontent.com/guardianproject/gpmaven/master") }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

