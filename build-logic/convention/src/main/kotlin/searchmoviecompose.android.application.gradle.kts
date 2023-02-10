import com.example.searchmoviecompose.configureKotlinAndroidCompose
plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    configureKotlinAndroidCompose(this)

    defaultConfig {
        targetSdk = 33
    }
}