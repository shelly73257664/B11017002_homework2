// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    //kotlin("android")
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false

}