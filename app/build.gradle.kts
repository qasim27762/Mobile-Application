plugins {
    alias(libs.plugins.android.application)
<<<<<<< HEAD
}

android {
    namespace = "com.example.assignment1"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.assignment1"
=======
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.firebase"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.firebase"
>>>>>>> cb1f0d3cbe7cf1ee086907e3042ed4aad664435f
        minSdk = 24
        targetSdk = 35
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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
<<<<<<< HEAD
=======
    implementation(libs.firebase.database)
    implementation(libs.firebase.auth)
>>>>>>> cb1f0d3cbe7cf1ee086907e3042ed4aad664435f
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}