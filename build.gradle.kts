// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        maven {
            setUrl( "https://jitpack.io")
        }
//        maven{
//            isAllowInsecureProtocol = true
//            setUrl( "https://maven.aliyun.com/repository/google")
//        }
//        maven{
//            isAllowInsecureProtocol = true
//            setUrl( "https://maven.aliyun.com/repository/central")
//        }
//        maven{
//            isAllowInsecureProtocol = true
//            setUrl( "https://maven.aliyun.com/repository/public")
//        }
//        maven{
//            isAllowInsecureProtocol = true
//            setUrl( "https://maven.aliyun.com/repository/gradle-plugin")
//        }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.2.2")
        classpath(kotlin("gradle-plugin", AppConfig.version.kotlin_version))
        classpath(kotlin("serialization", AppConfig.version.kotlin_version))
        classpath(AppConfig.classPath.hilt_plugin)
    }
}

task("clean", Delete::class) {
    delete = setOf(rootProject.buildDir)
}