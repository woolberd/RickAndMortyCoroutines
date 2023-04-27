plugins {
    id("com.android.application")
    kotlin("android")

    //Kapt
    kotlin("kapt")

    //Hilt
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.rickandmortycorutines"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.rickandmortycorutines"
        minSdk = 26
        targetSdk = 33
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

    buildFeatures {
        //ViewBinding
        viewBinding = true
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    // Core
    implementation("androidx.core:core-ktx:1.10.0")

    // AppCompat
    implementation("androidx.appcompat:appcompat:1.6.1")

    // Material Desing
    implementation("com.google.android.material:material:1.8.0")

    // UI Companents
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    //Livedata
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")

    //ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")

    // Retrofit 2
    val retrofitVersion = "2.9.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    //Gson
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")

    // OkHttp
    implementation(platform("com.squareup.okhttp3:okhttp-bom:5.0.0-alpha.6"))
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")

    // Navigation
    val navVersion = "2.5.3"
    //   implementation
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

    // Glide
    implementation("com.github.bumptech.glide:glide:4.15.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.15.0")

    // ViewBindingPropertyDelegate
    val view_binding_property_delegate = "1.5.3"

    //noinspection GradleDependency
    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:$view_binding_property_delegate")

    //Hilt
    val hilt_version = "2.45"
    implementation("com.google.dagger:hilt-android:$hilt_version")
    kapt("com.google.dagger:hilt-compiler:$hilt_version")

    // paging 3
    val paging_version = "3.1.1"
    //noinspection GradleDependency
    implementation("androidx.paging:paging-runtime:$paging_version")

    //material components
    implementation("com.google.android.material:material:<version>")

    //coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
}