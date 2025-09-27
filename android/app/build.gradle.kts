plugins {
    id("com.android.application")
    id("kotlin-android")
    // A Flutter Gradle Plugin-t az Android és Kotlin után kell alkalmazni
    id("dev.flutter.flutter-gradle-plugin")
}

android {
    namespace = "com.domedav.neptun2"
    compileSdk = flutter.compileSdkVersion
    ndkVersion = flutter.ndkVersion

    compileOptions {
        // 🔹 Java 11 + desugaring bekapcsolva
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
        isCoreLibraryDesugaringEnabled = true
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    defaultConfig {
        applicationId = "com.domedav.neptun2"
        minSdk = flutter.minSdkVersion
        targetSdk = flutter.targetSdkVersion
        versionCode = flutter.versionCode
        versionName = flutter.versionName
        multiDexEnabled = true
    }

    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

flutter {
    source = "../.."
}

dependencies {
    // 🔹 Ez kell a desugaringhoz
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.4")
}
