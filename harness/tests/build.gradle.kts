plugins {
    // no need to apply kotlin jvm plugin. Our plugin already applies the correct version for you
//    kotlin("jvm") version "1.7.10"
    id("com.utopia-rise.godot-kotlin-jvm")
}

repositories {
    mavenCentral()
}

godot {
    // pass `-PwithAndroid=true` to build with android support
    if (project.properties["withAndroid"]?.toString()?.toBoolean() == true) {
        isAndroidExportEnabled.set(true)
        d8ToolPath.set(File("${System.getenv("ANDROID_SDK_ROOT")}/build-tools/30.0.3/d8"))
        androidCompileSdkDir.set(File("${System.getenv("ANDROID_SDK_ROOT")}/platforms/android-30"))
    }

    //uncomment to test graal vm native image
//    isGraalNativeImageExportEnabled.set(true)
//    nativeImageToolPath.set(File("${System.getenv("GRAALVM_HOME")}/bin/native-image"))
//    windowsDeveloperVCVarsPath.set(System.getenv("VC_VARS_PATH"))
}

dependencies {
    implementation("joda-time:joda-time:2.10.6") //external dependency to test dependency inclusion in dummyCompilation
}


kotlin.sourceSets.main {
    kotlin.srcDirs("scripts")
}
