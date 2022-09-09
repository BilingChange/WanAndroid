plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = AppConfig.buildConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.buildConfig.minSdk
        targetSdk = AppConfig.buildConfig.targetSdk
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    compileOptions {
        targetCompatibility(JavaVersion.VERSION_11)
        sourceCompatibility(JavaVersion.VERSION_11)
    }
}

dependencies {
    implementation(AppConfig.deps.androidx_recyclerview)
    implementation(AppConfig.deps.androidx_paging_runtime)
    implementation(AppConfig.deps.androidx_paging_runtime_ktx)

    testImplementation(AppConfig.deps.test_junit)
    androidTestImplementation(AppConfig.deps.androidx_test_ext_junit)
    androidTestImplementation(AppConfig.deps.androidx_test_espresso_core)
}