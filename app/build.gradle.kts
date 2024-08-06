plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    //KAPT
    kotlin("kapt")
    //Dagger Hilt
    id("com.google.dagger.hilt.android")

    kotlin("plugin.serialization") version "2.0.0"
}

android {
    namespace = "gemini.julian.myapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "gemini.julian.myapplication"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("com.google.ai.client.generativeai:generativeai:0.7.0")

    //Gson
    implementation ("com.google.code.gson:gson:2.11.0")

    //Dagger hilt
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-android-compiler:2.48")


    //Navigation
    val navVersion = "2.8.0-alpha08"
    implementation("androidx.navigation:navigation-compose:$navVersion")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")


    //serializable
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")


    //DataStore
    implementation("androidx.datastore:datastore-preferences:1.0.0")


    //ConstraintLayout
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")


    //LiveData
    implementation("androidx.compose.runtime:runtime-livedata:1.6.2")


    //Coil
    implementation("io.coil-kt:coil-compose:2.6.0")


    //Gson
    implementation("com.google.code.gson:gson:2.10.1")


    //Responsive
    implementation("androidx.compose.material3:material3-window-size-class:1.2.1")


    //Animation Android
    implementation("androidx.compose.animation:animation-graphics-android:1.6.6")


    //Animation Transition
    implementation("androidx.compose.animation:animation:1.7.0-beta04")


    //Animation with Lottie
    val lottieVersion = "6.4.0"
    implementation("com.airbnb.android:lottie-compose:$lottieVersion")


    //Room
    val roomVersion = "2.6.1"
    implementation("androidx.room:room-runtime:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")


    //Retrofit
    val retrofitVersion = "2.9.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")


    //OkHttp
    val okhttp_version = "4.3.1"
    implementation("com.squareup.okhttp3:okhttp:$okhttp_version")
    implementation("com.squareup.okhttp3:logging-interceptor:$okhttp_version")


    //ExoPlayer  -> para reproducir video con url
    implementation("androidx.media3:media3-exoplayer:1.3.1")
    implementation("androidx.media3:media3-ui:1.3.1")
    implementation("androidx.media3:media3-common:1.3.1")


    //Icons
    implementation("androidx.compose.material:material-icons-extended:1.6.8")


    //Camera
    val cameraxVersion = "1.3.4"
    implementation("androidx.camera:camera-core:$cameraxVersion")
    implementation("androidx.camera:camera-camera2:$cameraxVersion")
    implementation("androidx.camera:camera-lifecycle:$cameraxVersion")
    implementation("androidx.camera:camera-video:$cameraxVersion")

    implementation("androidx.camera:camera-view:$cameraxVersion")
    implementation("androidx.camera:camera-extensions:$cameraxVersion")


    //Location
    implementation("com.google.android.gms:play-services-location:21.2.0")


    //Permissions
    implementation("com.google.accompanist:accompanist-permissions:0.28.0")



    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}