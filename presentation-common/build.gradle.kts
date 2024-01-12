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
    namespace = "com.theaminnouri.presentation_common"
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
    api(project(":domain"))
    api(libs.core.ktx)
    api(libs.appcompat)
    api(libs.lifecycleViewModelKtx)
    api(libs.lifecycleViewModelCompose)
    api(libs.lifecycleRuntimeKtx)
    api(libs.material)
    api(libs.material3)
    api(platform(libs.compose.bom))
    api(libs.composeUi)
    api(libs.composeUiGraphics)
    api(libs.composeUiToolingPreview)
    api(libs.navigationCompose)
    api(libs.navigationFragment)
    api(libs.navigationUi)
    api(libs.hiltAndroid)
    ksp(libs.hiltAndroidCompiler)
    api(libs.hiltNavigationCompose)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.composeUiTestJunit4)
    debugImplementation(libs.composeUiTooling)
    debugImplementation(libs.composeUiTestManifest)
}
