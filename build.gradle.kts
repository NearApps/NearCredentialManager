buildscript {
    extra.apply{
        set("package_name", "io.github.nearapps.credential_manager")
        set("compile_sdk", 33)
        set("min_sdk", 24)

        // App version
        set("version_code", 1)
        set("version_name", "0.1.0")
    }

    dependencies {
        //classpath("com.google.gms:google-services:4.3.15")
        //classpath("com.google.dagger:hilt-android-gradle-plugin:2.46.1")
        //classpath("com.google.firebase:firebase-crashlytics-gradle:2.9.5")
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.application) apply false
    alias(libs.plugins.org.jetbrains.kotlin.android) apply false
    alias(libs.plugins.com.android.library) apply false

    // Google Services
    alias(libs.plugins.gms.google.services) apply false

    // Dagger Hilt
    alias(libs.plugins.dagger.hilt) apply false
}
true // Needed to make the Suppress annotation work for the plugins block