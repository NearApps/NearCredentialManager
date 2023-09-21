@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.application)
    alias(libs.plugins.org.jetbrains.kotlin.android)

    // Google Services
    alias(libs.plugins.gms.google.services)

    // Dagger Hilt
    alias(libs.plugins.dagger.hilt)

    kotlin("kapt")
}

android {
    namespace = rootProject.extra["package_name"] as String
    compileSdk = rootProject.extra["compile_sdk"] as Int

    defaultConfig {
        applicationId = rootProject.extra["package_name"] as String
        minSdk = rootProject.extra["min_sdk"] as Int
        targetSdk = rootProject.extra["compile_sdk"] as Int
        versionCode = rootProject.extra["version_code"] as Int
        versionName = rootProject.extra["version_name"] as String

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        resourceConfigurations.addAll(listOf("es", "en"))
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // Modules
    implementation(project(":modules:framework"))
    implementation(project(":modules:domain"))

    // Kotlin
    implementation(libs.core.ktx)

    // Lifecycle
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)

    // Compose
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)

    // Material 3
    implementation(libs.material3)

    // Dagger Hilt
    implementation(libs.dagger.hilt)
    kapt(libs.dagger.hilt.compiler)
    kapt(libs.dagger.hilt.androidx.compiler)
    implementation(libs.dagger.hilt.androidx.compose)

    // Vitamin Compose
    implementation(libs.vitamin.foundation)
    implementation(libs.vitamin.buttons)
    implementation(libs.vitamin.text.inputs)
    implementation(libs.vitamin.badges)
    implementation(libs.vitamin.progressbars)
    implementation(libs.vitamin.ratings)
    implementation(libs.vitamin.tags)
    implementation(libs.vitamin.appbars)
    implementation(libs.vitamin.modals)
    implementation(libs.vitamin.cards)
    implementation(libs.vitamin.dividers)

    // Firebase
    implementation("com.google.firebase:firebase-analytics-ktx:21.3.0")

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
    // Testing Room
    testImplementation(libs.room.testing)
}