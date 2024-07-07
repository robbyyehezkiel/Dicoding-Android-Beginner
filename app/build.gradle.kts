plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
}

android {
    namespace = "com.robbyyehezkiel.androidbeginner"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.robbyyehezkiel.androidbeginner"
        minSdk = 26
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
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // Define version numbers
    val coreKtxVersion = "1.13.1"
    val appCompatVersion = "1.7.0"
    val materialVersion = "1.12.0"
    val constraintLayoutVersion = "2.1.4"
    val junitVersion = "4.13.2"
    val testExtJUnitVersion = "1.2.1"
    val espressoCoreVersion = "3.6.1"
    val glideVersion = "4.16.0"
    val lifecycleVersion = "2.8.3"

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    // AndroidX`
    implementation("androidx.core:core-ktx:$coreKtxVersion")
    implementation("androidx.appcompat:appcompat:$appCompatVersion")
    implementation("com.google.android.material:material:$materialVersion")
    implementation("androidx.constraintlayout:constraintlayout:$constraintLayoutVersion")

    // Testing
    testImplementation("junit:junit:$junitVersion")
    androidTestImplementation("androidx.test.ext:junit:$testExtJUnitVersion")
    androidTestImplementation("androidx.test.espresso:espresso-core:$espressoCoreVersion")

    implementation("androidx.core:core-splashscreen:1.0.1")

    // Image loading
    implementation("com.github.bumptech.glide:glide:$glideVersion")
}