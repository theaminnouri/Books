@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}
kotlin {
    jvmToolchain(libs.versions.jdkVersion.get().toInt())
}
android {
    namespace = "com.theaminnouri.presentation_search"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.kotlinCompilerExtensionVersion.get()
    }
}

dependencies {
    implementation(project(":presentation-common"))
    implementation(project(":domain"))

    implementation(libs.hiltAndroid)
    ksp(libs.hiltAndroidCompiler)
    implementation(libs.hiltNavigationCompose)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.test.ext.junit)
}
