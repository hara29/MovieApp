plugins {
    alias(libs.plugins.androidDynamicFeature)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

apply(from = "../shared_dependencies.gradle")

android {
    namespace = "com.cindy.movieapp.favorite"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":app"))
    implementation(project(":core"))
    implementation(libs.kotlin.stdlib.jdk7)
}