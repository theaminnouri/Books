@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id(libs.plugins.kotlinKapt.get().pluginId)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.theaminnouri.presentation_common"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
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
    kapt(libs.hiltAndroidCompiler)
    api(libs.hiltNavigationCompose)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.composeUiTestJunit4)
    debugImplementation(libs.composeUiTooling)
    debugImplementation(libs.composeUiTestManifest)
}
