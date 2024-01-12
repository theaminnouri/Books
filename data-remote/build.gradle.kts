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
    namespace = "com.theaminnouri.data_remote"
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

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data-repository"))
    implementation(libs.hiltAndroid)
    ksp(libs.hiltAndroidCompiler)
    implementation(libs.core.ktx)
    api(libs.okhttp)
    api(libs.okhttpLoggingInterceptor)
    api(libs.retrofit)
    api(libs.retrofit.gson.convertor)
    implementation(libs.gson)

    testImplementation(libs.junitPlatformLauncher)
    testImplementation(libs.junitJupiterEngine)
    testImplementation(libs.junitVintageEngine)
    testImplementation(libs.mockitoKotlin)

    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}