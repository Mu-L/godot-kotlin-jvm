
#include <core/project_settings.h>
#include <core/os/dir_access.h>
#include "path_provider.h"
#include "gd_kotlin.h"

#ifdef __APPLE__
#include <TargetConditionals.h>
#endif

String PathProvider::provide_runtime_usercode_path() {
#ifdef TOOLS_ENABLED
    RandomPCG rng;
    rng.randomize();
    static const String usercode_jar_path{
            vformat("%s/%s_%s", provide_build_lock_dir_path(), rng.rand(), get_usercode_name())
    };
#else
    static const String usercode_jar_path{
            ProjectSettings::get_singleton()->globalize_path("user://" + get_usercode_name())
    };
#endif
    return usercode_jar_path;
}

String PathProvider::get_usercode_name() {
#ifdef __ANDROID__
    return String{usercode_name} + jar_extension_android;
#else
    String name;
    if (GDKotlin::get_instance().get_configuration().get_vm_type() == jni::Jvm::GRAAL_NATIVE_IMAGE) {
        name = String{usercode_name} + get_host_dependent_dynamics_lib_extension();
    } else {
        name = String{usercode_name} + jar_extension;
    }
    return name;
#endif
}


String PathProvider::provide_build_usercode_path() {
    return "res://build/libs/" + get_usercode_name();
}

#ifdef TOOLS_ENABLED
String PathProvider::provide_build_lock_dir_path() {
    static const String tmp_dir{
#if defined(__linux__) || defined(__APPLE__)
        "/tmp"
#elif defined _WIN32 || defined _WIN64
        OS::get_singleton()->get_environment("TMP").replace("\\", "/")
#endif
    };
    static const Vector<String> project_dir_path_splitted{ProjectSettings::get_singleton()->globalize_path("res://").split("/")};
    static const String& project_dir_name{project_dir_path_splitted[project_dir_path_splitted.size() - 2]};
    static const String build_lock_dir{tmp_dir + "/" + project_dir_name + "_buildLockDir"};
    return build_lock_dir;
}

String PathProvider::provide_build_lock_file_path() {
    static const String build_lock_file_path{provide_build_lock_dir_path() + "/buildLock.lock"};
    return build_lock_file_path;
}
#endif //TOOLS_ENABLED

String PathProvider::get_host_dependent_dynamics_lib_extension() {
#ifdef __linux__
    return dynamic_library_extension_linux;
#elif __APPLE__
#if TARGET_OS_MAC
    return dynamic_library_extension_osx;
#endif
#elif defined _WIN32 || defined _WIN64
return dynamic_library_extension_win;
#endif
}

String PathProvider::get_usercode_extension_for_vm_type(jni::Jvm::Type vm_type) {
    switch (vm_type) {
        case jni::Jvm::JVM:
            return jar_extension;
        case jni::Jvm::ART:
            return jar_extension_android;
        case jni::Jvm::GRAAL_NATIVE_IMAGE:
#ifdef __linux__
            return dynamic_library_extension_linux;
#elif __APPLE__
#if TARGET_OS_MAC
            return dynamic_library_extension_osx;
#endif
#elif defined _WIN32 || defined _WIN64
            return dynamic_library_extension_win;
#endif
        default:
            LOG_ERROR("Unknown VM type, returning jar extension.");
            return jar_extension;
    }
}
