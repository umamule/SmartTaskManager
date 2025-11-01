plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    // The 'kotlin.compose' alias might be incorrect. The standard way is using the Compose compiler plugin ID.
    // Replace 'alias(libs.plugins.kotlin.compose)' with the line below if you face further issues.
    // id("org.jetbrains.kotlin.plugin.compose")
    alias(libs.plugins.kotlin.compose)

    // Add the kotlin-kapt plugin here
    alias(libs.plugins.kotlin.kapt) // Or use id("org.jetbrains.kotlin.kapt") if you don't have a version catalog alias
}

android {
    namespace = "com.example.smarttaskmanager"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.smarttaskmanager"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    // It's a good practice to specify the Compose compiler version
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14" // Use a version compatible with your Kotlin plugin
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    // Jetpack Compose
    implementation("androidx.compose.ui:ui:1.7.0")
    implementation("androidx.compose.material3:material3:1.3.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.7.0")
    debugImplementation("androidx.compose.ui:ui-tooling:1.7.0")

    // Lifecycle (ViewModel, LiveData, etc.)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.0")

    // Room Database
    implementation("androidx.room:room-runtime:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1") // This will now be resolved
    implementation("androidx.room:room-ktx:2.6.1")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")

    // Navigation for Compose
    implementation("androidx.navigation:navigation-compose:2.8.0")

    // WorkManager (for notifications / alarms)
    implementation("androidx.work:work-runtime-ktx:2.9.0")

    // Other essentials
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.activity:activity-compose:1.9.3")
}

