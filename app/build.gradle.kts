plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("androidx.navigation.safeargs")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id ("dagger.hilt.android.plugin")


}
android {
    namespace = "com.example.kotlinappfood"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.kotlinappfood"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        // Add this if not already present
        freeCompilerArgs += "-Xmetadata-version=1.4.2"
    }

    buildFeatures {
        viewBinding = true
    }


}


dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation (libs.material.v190)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.coordinatorlayout)
    implementation(libs.androidx.databinding.runtime)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    // ViewModel
    implementation (libs.androidx.lifecycle.viewmodel.ktx.v251)
    implementation (libs.androidx.lifecycle.livedata.ktx.v251)
    implementation (libs.androidx.lifecycle.viewmodel.savedstate.v251)
    implementation (libs.androidx.lifecycle.service.v251)
    implementation (libs.androidx.lifecycle.process.v251)

    // Hilt
    implementation (libs.hilt.android)
    kapt (libs.hilt.compiler)
    kapt (libs.androidx.hilt.compiler)

    // Retrofit
    implementation (libs.retrofit)
    implementation (libs.converter.gson)
    implementation (libs.adapter.rxjava3)
    implementation (libs.logging.interceptor.v4110)

    // RXJava
    implementation (libs.rxjava.v316)
    implementation (libs.rxandroid.v302)

    //DotsIndicator
    implementation(libs.dotsindicator)

    //Glide
    implementation (libs.glide)
    annotationProcessor (libs.compiler)

    //Navigation
    implementation(libs.androidx.navigation.dynamic.features.fragment)
    implementation(libs.androidx.navigation.compose)

    //CCP
    implementation(libs.ccp)

    //OTP
    implementation (libs.otp.view)

    //Lottie
    implementation (libs.lottie)

    implementation (project(":data"))
    implementation (project(":domain"))




}
kapt {   correctErrorTypes = true }