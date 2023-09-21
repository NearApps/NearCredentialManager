@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    kotlin("kapt")
}

android {
    namespace = "io.github.nearapps.data.local"
    compileSdk = rootProject.extra["compile_sdk"] as Int

    defaultConfig {
        minSdk = rootProject.extra["min_sdk"] as Int

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    // Modules
    implementation(project(":modules:framework"))

    // Kotlin
    implementation(libs.core.ktx)

    // Arrow
    implementation(libs.arrow.core)

    // Room
    implementation(libs.room.runtime)
    annotationProcessor(libs.room.compiler)
    kapt(libs.room.compiler)
    implementation(libs.room.ktx)
    implementation(libs.room.paginator)

    //implementation(libs.appcompat)
    //implementation(libs.material)
    //testImplementation(libs.junit)
    //androidTestImplementation(libs.androidx.test.ext.junit)
    //androidTestImplementation(libs.espresso.core)
}