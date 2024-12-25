plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.android.libraries.mapsplatform.secrets.gradle.plugin)
}

android {
    namespace = "com.clerami.intermediate"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.clerami.intermediate"
        minSdk = 25
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            buildConfigField ("String", "BASE_URL", "\"https://story-api.dicoding.dev/v1/\"") // Development environment
        }
        release {
            buildConfigField ("String", "BASE_URL", "\"https://story-api.dicoding.dev/v1/\"") // Production environment
            isMinifyEnabled = true
            proguardFiles (
                getDefaultProguardFile("proguard-android-optimize.txt"),
                ("proguard-rules.pro")
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
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.ui.test.android)
    implementation(libs.play.services.maps)
    implementation(libs.play.services.location)
    implementation(libs.androidx.espresso.idling.resource)
    testImplementation(libs.junit)
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.junit.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.logging.interceptor)
    implementation (libs.androidx.lifecycle.livedata.ktx)
    implementation (libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.paging.runtime.ktx)
    implementation (libs.github.glide)
    implementation( libs.androidx.recyclerview)

    androidTestImplementation(libs.androidx.core.testing)
    androidTestImplementation(libs.kotlinx.coroutines.test)

    testImplementation(libs.androidx.core.testing)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation (libs.androidx.paging.common)
    testImplementation(libs.mockito.core)
    testImplementation(libs.mockito.inline)
    testImplementation (libs.androidx.rules)
    testImplementation (libs.androidx.idling.concurrent)

    androidTestImplementation (libs.androidx.runner)


    androidTestImplementation (libs.androidx.rules)
    androidTestImplementation (libs.androidx.espresso.intents)

    testImplementation ("io.mockk:mockk:1.13.2")

    implementation ("net.bytebuddy:byte-buddy:1.14.10")

    androidTestImplementation (libs.mockito.android)
    implementation ("androidx.paging:paging-runtime:3.1.0")
    implementation ("androidx.paging:paging-common:3.1.0")

    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.0")

    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
}