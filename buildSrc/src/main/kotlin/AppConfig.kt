
/**
 * @description:
 *
 * @author: Y.F
 * @e-mail: yuanfan3@01zhuanche.com
 * @date: on 2021/9/6    18:48.
 **/
object AppConfig {


    val buildConfig = Configs
    /**
     * 应用配置
     */
    object Configs {

        /** 应用 id */
        const val application_id = "com.bili.wanandroid"

        /** 编译 SDK 版本 */
        const val compile_sdk_version = 31

        /** 编译工具版本 */
        const val build_tools_version = "30.0.2"

        /** 最小支持版本 */
        const val min_sdk_version = 19

        /** 目标支持版本 */
        const val target_sdk_version = 31

        /** 应用版本号 */
        const val version_code = 1

        /** 应用版本名 */
        const val version_name = "1.0.0"
    }

    val signingConfig = SigningConfigs
    /**
     * 签名配置
     */
    object SigningConfigs {

        /** 密钥别名 */
        const val key_alias = "android"

        /** 别名密码 */
        const val key_password = "123456"

        /** 密钥文件路径 */
        const val store_file = "keystore.jks"

        /** 密钥密码 */
        const val store_password = "123456"
    }

    val version = Versions
    /**
     * 版本号
     */
    object Versions {

        /** 测试 mokito 版本 */
        const val test_mokito_version = "3.3.3"

        /** Kotlin 版本 */
        const val kotlin_version = "1.5.31"

        /** core 版本 */
        const val core_version = "1.6.0"

        /** room 版本 */
        const val room_version = "2.2.5"

        /** paging 版本 */
        const val paging_version = "3.1.0"

        /** navigation 版本 */
        const val navigation_version = "2.3.5"

        /** lifecycle 版本 */
        const val lifecycle_version = "2.4.0"

        /** lifecycle 版本 */
        const val lifecycle_extensions = "2.2.0"

        /** activity 版本 */
        const val activity_version = "1.3.1"

        /** fragment 版本 */
        const val fragment_version = "1.3.1"

        /** startup-runtime 版本 */
        const val startup_runtime = "1.1.0"

        /** koin 版本 */
        const val koin_version = "2.2.1"

        /** glide 版本 */
        const val glide_version = "4.11.0"

        /** okhttp 版本 */
        const val okhttp_version = "4.9.0"

        /** retrofit 版本 */
        const val retrofit_version = "2.9.0"

        /** smart refresh 版本 */
        const val smart_refresh_version = "2.0.1"

        /** immersion bar 版本 */
        const val immersion_bar_version = "3.0.0"

        /** doraemon kit 版本 */
        const val doraemon_kit_version = "3.1.8"

        /** coil 版本 */
        const val coil_version = "1.1.0"

        /** 换肤支持版本 */
        const val skin_support_version = "4.0.5"

        /** moshi 版本 */
        const val moshi_version = "1.11.0"

        /** ARouter 版本 */
        const val arouter_version = "1.5.1"

        /** Logger 版本 */
        const val logger_version = "2.2.0"

        /** Gosn 版本 */
        const val gson_version = "2.8.6"

        /** Zxing 版本 */
        const val zxing_version = "3.4.0"

        /** Huawei scan kit 版本 */
        const val scan_kit = "1.1.3.301"

        /** BRVAH 版本 */
        const val base_rv_helper = "3.0.4"

        /** multitype 版本 */
        const val multitype = "4.2.0"

        /** mmkv 版本 */
        const val tencent_mmkv = "1.2.13"

        /** constraintlayout 版本 */
        const val constraintlayout_version = "2.1.1"
    }

    /**
     * 依賴對象
     */
    val deps = Dependencies

    object Dependencies {

        /** 测试 */
        const val test_junit = "junit:junit:4.13.2"
        const val test_mokito_inline = "org.mockito:mockito-inline:${version.test_mokito_version}"
        const val test_mokito_android = "org.mockito:mockito-android:${version.test_mokito_version}"
        const val test_uiautomator_v18 = "com.android.support.test.uiautomator:uiautomator-v18:2.1.3"
        const val androidx_test_ext_junit = "androidx.test.ext:junit:1.1.3"
        const val androidx_test_rules = "androidx.test:rules:1.2.0"
        const val androidx_test_runner = "androidx.test:runner:1.2.0"
        const val androidx_test_espresso_core = "androidx.test.espresso:espresso-core:3.4.0"

        /** Kotlin */
        const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${version.kotlin_version}"
        const val kotlin_jdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${version.kotlin_version}"
        const val kotlin_jdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${version.kotlin_version}"
        const val kotlin_reflect = "org.jetbrains.kotlin:kotlin-reflect:${version.kotlin_version}"

        /** Androidx startup */
        const val androidx_startup = "androidx.startup:startup-runtime:1.1.0"

        /** Findbugs Jsr */
        const val findbugs_jsr = "com.google.code.findbugs:jsr305:3.0.2"

        /** androidx - legacy */
        const val androidx_legacy = "androidx.legacy:legacy-support-v4:1.0.0"

        /** androidx - appcompat */
        const val androidx_appcompat = "androidx.appcompat:appcompat:1.3.1"

        /** androidx material */
        const val androidx_material = "com.google.android.material:material:1.4.0"

        /** androidx recyclerview */
        const val androidx_recyclerview = "androidx.recyclerview:recyclerview:1.2.1"

        /** androidx viewpager2 */
        const val androidx_viewpager2 = "androidx.viewpager2:viewpager2:1.0.0"

        /** androidx 约束性布局 */
        const val androidx_constraint = "androidx.constraintlayout:constraintlayout:${version.constraintlayout_version}"

        /** androidx multidex */
        const val androidx_multidex = "androidx.multidex:multidex:2.0.1"

        /** androidx core */
        const val androidx_core = "androidx.core:core:${version.core_version}"
        const val androidx_core_ktx = "androidx.core:core-ktx:${version.core_version}"

        /** androidx activity */
        const val androidx_activity = "androidx.activity:activity:${version.activity_version}"
        const val androidx_activity_ktx = "androidx.activity:activity-ktx:${version.activity_version}"

        /** androidx fragment */
        const val androidx_fragment = "androidx.fragment:fragment:${version.fragment_version}"
        const val androidx_fragment_ktx = "androidx.fragment:fragment-ktx:${version.fragment_version}"

        /** startup-runtime */
        const val startup_runtime = "androidx.startup:startup-runtime:${version.startup_runtime}"

        /** androidx lifecycle */
        const val androidx_lifecycle_extensions = "androidx.lifecycle:lifecycle-extensions:${version.lifecycle_extensions}"
        const val androidx_lifecycle_ktx = "androidx.lifecycle:lifecycle-runtime-ktx:${version.lifecycle_version}"
        const val androidx_lifecycle_viewmodel_ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${version.lifecycle_version}"
        const val androidx_lifecycle_livedata_ktx = "androidx.lifecycle:lifecycle-livedata-ktx:${version.lifecycle_version}"
        const val androidx_lifecycle_common_java8 = "androidx.lifecycle:lifecycle-common-java8:${version.lifecycle_version}"

        /** androidx room */
        const val androidx_room_runtime = "androidx.room:room-runtime:${version.room_version}"
        const val androidx_room_compiler = "androidx.room:room-compiler:${version.room_version}"
        const val androidx_room_ktx = "androidx.room:room-ktx:${version.room_version}"
        const val androidx_room_rxjava2 = "androidx.room:room-rxjava2:${version.room_version}"
        const val androidx_room_testing = "androidx.room:room-testing:${version.room_version}"

        /** androidx paging */
        const val androidx_paging_runtime = "androidx.paging:paging-runtime:${version.paging_version}"
        const val androidx_paging_runtime_ktx = "androidx.paging:paging-runtime-ktx:${version.paging_version}"
        const val androidx_paging_common = "androidx.paging:paging-common:${version.paging_version}"
        const val androidx_paging_common_ktx = "androidx.paging:paging-common-ktx:${version.paging_version}"
        const val androidx_paging_rxjava2 = "androidx.paging:paging-rxjava2:${version.paging_version}"
        const val androidx_paging_rxjava2_ktx = "androidx.paging:paging-rxjava2-ktx:${version.paging_version}"

        /** androidx navigation */
        const val androidx_navigation_fragment = "androidx.navigation:navigation-fragment:${version.navigation_version}"
        const val androidx_navigation_fragment_ktx = "androidx.navigation:navigation-fragment-ktx:${version.navigation_version}"
        const val androidx_navigation_ui = "androidx.navigation:navigation-ui:${version.navigation_version}"
        const val androidx_navigation_ui_ktx = "androidx.navigation:navigation-ui-ktx:${version.navigation_version}"
        const val androidx_navigation_common = "androidx.navigation:navigation-common:${version.navigation_version}"
        const val androidx_navigation_common_ktx = "androidx.navigation:navigation-common-ktx:${version.navigation_version}"
        const val androidx_navigation_runtime = "androidx.navigation:navigation-runtime:${version.navigation_version}"
        const val androidx_navigation_runtime_ktx = "androidx.navigation:navigation-runtime-ktx:${version.navigation_version}"

        /**
         * Logger 日志打印
         * - Github: [https://github.com/orhanobut/logger]
         */
        const val logger = "com.orhanobut:logger:${version.logger_version}"

        /**
         * kotlin 协程
         * - 指南：[https://www.kotlincn.net/docs/reference/coroutines/coroutines-guide.html]
         * - Github：[https://github.com/Kotlin/kotlinx.coroutines]
         */
        const val kotlin_coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2"

        /**
         * kotlin Json 序列化
         * - Github: [https://github.com/Kotlin/kotlinx.serialization]
         */
        const val kotlin_serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.1"

        /**
         * Gson
         * - Github：[https://github.com/google/gson]
         */
        const val gson = "com.google.code.gson:gson:${version.gson_version}"

        /**
         * Moshi
         * - Github: [https://github.com/square/moshi]
         */
        const val moshi = "com.squareup.moshi:moshi:${Versions.moshi_version}"
        const val moshi_kt = "com.squareup.moshi:moshi-kotlin:${Versions.moshi_version}"

        /**
         * Klaxon
         * - Github: [https://github.com/cbeust/klaxon]
         */
        const val klaxon = "com.beust:klaxon:5.0.1"

        /**
         * Zxing
         * - Github：[https://github.com/zxing/zxing]
         */
        const val zxing = "com.google.zxing:core:${Versions.zxing_version}"
        /**
         * Huawei scan kit
         * - Github：[https://github.com/zxing/zxing]
         */
        const val scan_kit = "com.huawei.hms:scan:${Versions.scan_kit}"

        /**
         * Koin
         * - Github：[https://github.com/InsertKoinIO/koin]
         */
        const val koin_scope = "org.koin:koin-androidx-scope:${Versions.koin_version}"
        const val koin_ext = "org.koin:koin-androidx-ext:${Versions.koin_version}"
        const val koin_compose = "org.koin:koin-androidx-compose:${Versions.koin_version}"
        const val koin_fragment = "org.koin:koin-androidx-fragment:${Versions.koin_version}"
        const val koin_viewmodel = "org.koin:koin-androidx-viewmodel:${Versions.koin_version}"
        const val koin_workmanager = "org.koin:koin-androidx-workmanager:${Versions.koin_version}"

        /**
         * 美团多渠道
         * - Github：[https://github.com/Meituan-Dianping/walle]
         */
        const val walle_channel = "com.meituan.android.walle:library:1.1.7"

        /**
         * Glide
         * - Github：[https://github.com/bumptech/glide]
         */
        const val glide = "com.github.bumptech.glide:glide:${Versions.glide_version}"
        const val glide_compiler = "com.github.bumptech.glide:compiler:${Versions.glide_version}"

        /**
         * okhttp
         * - Github：[https://github.com/square/okhttp]
         */
        const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp_version}"
        const val okhttp_urlconnection = "com.squareup.okhttp3:okhttp-urlconnection:${Versions.okhttp_version}"
        const val okhttp_logging = "com.squareup.okhttp:logging-interceptor:${Versions.okhttp_version}"

        /**
         * okio
         * - Github: [https://github.com/square/okio]
         */
        const val okio = "com.squareup.okio:okio:2.9.0"

        /**
         * Retrofit
         * - Github：[https://github.com/square/retrofit]
         */
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit_version}"
        const val retrofit_converter_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit_version}"
        const val retrofit_converter_moshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit_version}"
        const val retrofit_converter_kt = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0"

        /**
         * SmartRefreshLayout
         * - Github：[https://github.com/scwang90/SmartRefreshLayout]
         */
        const val smart_refresh = "com.scwang.smart:refresh-layout-kernel:${version.smart_refresh_version}"
        const val smart_refresh_header_classics = "com.scwang.smart:refresh-header-classics:${version.smart_refresh_version}"
        const val smart_refresh_footer_classics = "com.scwang.smart:refresh-footer-classics:${version.smart_refresh_version}"

        /**
         * LiveEventBus
         * - Github：[https://github.com/JeremyLiao/LiveEventBus]
         */
        const val live_event_bus = "com.jeremyliao:live-event-bus-x:1.7.2"

        /**
         * 状态栏工具
         * - Github: [https://github.com/gyf-dev/ImmersionBar]
         */
        const val immersion_bar = "com.gyf.immersionbar:immersionbar:${version.immersion_bar_version}"
        const val immersion_bar_ktx = "com.gyf.immersionbar:immersionbar-ktx:${version.immersion_bar_version}"

        /**
         * MMKV
         * - Github: [https://github.com/tencent/mmkv]
         */
        const val tencent_mmkv = "com.tencent:mmkv:${version.tencent_mmkv}"

        /**
         * TabLayout
         * - Github: [https://github.com/H07000223/FlycoTabLayout]
         */
        const val tablayout = "com.flyco.tablayout:FlycoTabLayout_Lib:2.1.2@aar"

        /**
         * Coil 图片加载
         * - Github: [https://github.com/coil-kt/coil]
         */
        const val coil = "io.coil-kt:coil:${version.coil_version}"
        const val coil_base = "io.coil-kt:coil-base:${version.coil_version}"
        const val coil_gif = "io.coil-kt:coil-gif:${version.coil_version}"
        const val coil_svg = "io.coil-kt:coil-svg:${version.coil_version}"
        const val coil_video = "io.coil-kt:coil-video:${version.coil_version}"

        /**
         * 换肤支持
         * - GitHub: [https://github.com/ximsfei/Android-skin-support]
         */
        const val skin_support = "skin.support:skin-support:${version.skin_support_version}"
        const val skin_support_appcompat = "skin.support:skin-support-appcompat:${version.skin_support_version}"
        const val skin_support_material = "skin.support:skin-support-design:${version.skin_support_version}"
        const val skin_support_cardview = "skin.support:skin-support-cardview:${version.skin_support_version}"
        const val skin_support_constraint = "skin.support:skin-support-constraint-layout:${version.skin_support_version}"

        /**
         * ARouter 路由
         * - Github: [https://github.com/alibaba/ARouter]
         */
        const val arouter_api = "com.alibaba:arouter-api:${version.arouter_version}"
        const val arouter_compiler = "com.alibaba:arouter-compiler:${version.arouter_version}"
        /**
         * BaseRecyclerViewAdapterHelper
         * - Github: [https://github.com/CymChad/BaseRecyclerViewAdapterHelper]
         */
        const val base_rv_helper = "com.github.CymChad:BaseRecyclerViewAdapterHelper:${version.base_rv_helper}"
        const val multitype = "com.drakeet.multitype:multitype:${version.multitype}"

        /**
         * AgentWeb
         * - Github: [https://github.com/Justson/AgentWeb]
         */
        const val agentweb_core = "com.github.Justson.AgentWeb:agentweb-core:v4.1.9-androidx"
        const val agentweb_filechooser = "com.github.Justson.AgentWeb:agentweb-filechooser:v4.1.9-androidx"
        const val agentweb_downloader = "com.github.Justson:Downloader:v4.1.9-androidx"

    }
}