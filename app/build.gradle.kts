plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-parcelize")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = AppConfig.buildConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.buildConfig.applicationId
        minSdk = AppConfig.buildConfig.minSdk
        targetSdk = AppConfig.buildConfig.targetSdk
        versionCode = AppConfig.buildConfig.versionCode
        versionName = AppConfig.buildConfig.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // 开启 Dex 分包
        multiDexEnabled = true
    }

    signingConfigs {
        // 签名配置
        getByName("debug") {
            keyAlias = AppConfig.signingConfig.key_alias
            keyPassword = AppConfig.signingConfig.key_password
            storeFile = file(AppConfig.signingConfig.store_file)
            storePassword = AppConfig.signingConfig.store_password
            enableV1Signing = true
            enableV2Signing = true
        }
        create("release") {
            keyAlias = AppConfig.signingConfig.key_alias
            keyPassword = AppConfig.signingConfig.key_password
            storeFile = file(AppConfig.signingConfig.store_file)
            storePassword = AppConfig.signingConfig.store_password
            enableV1Signing = true
            enableV2Signing = true
        }
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isZipAlignEnabled = false
            isShrinkResources = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.findByName("debug")
        }
        getByName("release") {
            isMinifyEnabled = true
            isZipAlignEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.findByName("release")
        }
    }

    // 维度
    flavorDimensions.add("version")

    productFlavors {
        // 正式线上版本
        create("online") {
            //dimension = "version"
            // 版本名后缀
            versionNameSuffix = "_online"
            // 是否使用线上环境
            buildConfigField("boolean", "IS_ONLINE_ENV", "true")
        }

        // 测试版本
        create("offline") {
            //dimension = "version"
            // 应用包名后缀
            applicationIdSuffix = ".offline"
            // 版本名后缀
            versionNameSuffix = "_offline"
            // 是否使用线上环境
            buildConfigField("boolean", "IS_ONLINE_ENV", "false")
        }

        // 开发版本
        create("dev") {
            //dimension = "version"
            // 应用包名后缀
            applicationIdSuffix = ".dev"
            // 版本名后缀
            versionNameSuffix = "_dev"
            // 是否使用线上环境
            buildConfigField("boolean", "IS_ONLINE_ENV", "false")
        }
    }

    // 源文件路径设置
    sourceSets {
        named("main") {
            java.srcDirs("src/main/java", "src/main/kotlin")
            jni.srcDirs("libs", "jniLibs")
        }
    }

    buildFeatures {
        viewBinding = true
    }

    kapt {
        arguments {
            arg("AROUTER_MODULE_NAME", project.getName())
        }
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    compileOptions {
        targetCompatibility(JavaVersion.VERSION_11)
        sourceCompatibility(JavaVersion.VERSION_11)
    }

    // 配置 APK 输出路径
    applicationVariants.all {
        outputs.all {
            (this as? com.android.build.gradle.internal.api.ApkVariantOutputImpl)?.outputFileName =
                "WanAndroid-${flavorName}-${buildType.name}_v${versionName}" + ".apk"
        }
    }
}

dependencies {
    //implementation(project(mapOf("path" to ":multitype")))
    implementation(project(":lib-base"))
    //Arouter
    implementation(AppConfig.deps.arouter_api)
    kapt(AppConfig.deps.arouter_compiler)

    //数据存储
    implementation(AppConfig.deps.tencent_mmkv)
    //implementation(AppConfig.deps.androidx_datastore)
    //implementation(AppConfig.deps.androidx_preference)

    //依赖注入
    implementation(AppConfig.deps.hilt_android)
    kapt(AppConfig.deps.hilt_android_compiler)
    kapt(AppConfig.deps.hilt_compiler)

    //网络
    implementation(AppConfig.deps.okhttp)
    implementation(AppConfig.deps.logging_interceptor)
    implementation(AppConfig.deps.retrofit)
    implementation(AppConfig.deps.retrofit_converter_gson)
    implementation(AppConfig.deps.gson)
    implementation(AppConfig.deps.kotlin_serialization)

    //UI
    //implementation(AppConfig.deps.fresco)
    //implementation(AppConfig.deps.glide)
    implementation(AppConfig.deps.banner)
    implementation(AppConfig.deps.flexbox)
    implementation(AppConfig.deps.tablayout)

    //下拉刷新
    implementation(AppConfig.deps.swiperefreshlayout)

    implementation(AppConfig.deps.smart_refresh)
    implementation(AppConfig.deps.smart_refresh_header_classics)
    implementation(AppConfig.deps.smart_refresh_footer_classics)

    //webview
    implementation(AppConfig.deps.agentweb_core)
    //内存泄漏检测
    debugImplementation(AppConfig.deps.leakcanary)

    //测试
    testImplementation(AppConfig.deps.test_junit)
    androidTestImplementation(AppConfig.deps.androidx_test_runner)
    androidTestImplementation(AppConfig.deps.androidx_test_espresso_core)
    androidTestImplementation(AppConfig.deps.androidx_test_ext_junit)
}