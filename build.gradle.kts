// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath (libs.gradle) // Latest stable Gradle Plugin
        classpath (libs.kotlin.gradle.plugin)
        classpath (libs.hilt.android.gradle.plugin) // Ensure Hilt Gradle Plugin matches other Hilt dependencies
        classpath(libs.androidx.navigation.safe.args.gradle.plugin)

    }
}
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    id("com.google.dagger.hilt.android") version "2.48" apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false

}
