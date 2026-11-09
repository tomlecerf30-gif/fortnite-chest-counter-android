plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.tomlecerf.chestcounter"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.tomlecerf.chestcounter"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }
}
