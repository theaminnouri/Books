@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id(libs.plugins.kotlinKapt.get().pluginId)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.theaminnouri.data_remote"
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
    // Allow references to generated code
    kapt {
        correctErrorTypes = true
    }
    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data-repository"))
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.core.ktx)
    implementation(libs.okhttp)
    implementation(libs.retrofit)
    implementation(libs.retrofit.moshi.convertor)
    implementation(libs.moshi)
    implementation(libs.moshi.kotlin)

    testImplementation(libs.junitPlatformLauncher)
    testImplementation(libs.junitJupiterEngine)
    testImplementation(libs.junitVintageEngine)
    testImplementation(libs.mockitoKotlin)

    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}