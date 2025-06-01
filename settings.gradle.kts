pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
    plugins {
        id("org.jetbrains.kotlin.plugin.compose") version "2.0.0"
        id("com.android.application") version "8.3.0"
        id("org.jetbrains.kotlin.android") version "2.0.0"
        id("kotlin-kapt") version "2.0.0"
        id("dagger.hilt.android.plugin") version "2.48"
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MySeriesApplication"
include(":app")
