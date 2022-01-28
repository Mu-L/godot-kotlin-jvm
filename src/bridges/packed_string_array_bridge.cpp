#include <modules/kotlin_jvm/src/gd_kotlin.h>
#include <modules/kotlin_jvm/src/bridges/constants.h>
#include <modules/kotlin_jvm/src/bridges/bridges_utils.h>
#include "packed_string_array_bridge.h"

using namespace bridges;

JNI_INIT_STATICS_FOR_CLASS(PackedStringArrayBridge)

PackedStringArrayBridge::PackedStringArrayBridge(jni::JObject p_wrapped, jni::JObject p_class_loader)
        : JavaInstanceWrapper(PACKED_STRING_ARRAY_BRIDGE_CLASS_NAME, p_wrapped, p_class_loader) {
    jni::JNativeMethod engine_call_constructor_method{
            "engine_call_constructor",
            "()J",
            (void*) PackedStringArrayBridge::engine_call_constructor
    };
    jni::JNativeMethod engine_call_append_method{
            "engine_call_append",
            "(J)V",
            (void*) PackedStringArrayBridge::engine_call_append
    };
    jni::JNativeMethod engine_call_appendArray_method{
            "engine_call_appendArray",
            "(J)V",
            (void*) PackedStringArrayBridge::engine_call_appendArray
    };
    jni::JNativeMethod engine_call_is_empty_method{
            "engine_call_is_empty",
            "(J)V",
            (void*) PackedStringArrayBridge::engine_call_is_empty
    };
    jni::JNativeMethod engine_call_get_method{
            "engine_call_get",
            "(J)V",
            (void*) PackedStringArrayBridge::engine_call_get
    };
    jni::JNativeMethod engine_call_insert_method{
            "engine_call_insert",
            "(J)V",
            (void*) PackedStringArrayBridge::engine_call_insert
    };
    jni::JNativeMethod engine_call_reverse_method{
            "engine_call_reverse",
            "(J)V",
            (void*) PackedStringArrayBridge::engine_call_reverse
    };
//    jni::JNativeMethod engine_call_join_method{
//            "engine_call_join",
//            "(J)V",
//            (void*) PackedStringArrayBridge::engine_call_join
//    };
    jni::JNativeMethod engine_call_pushback_method{
            "engine_call_pushback",
            "(J)V",
            (void*) PackedStringArrayBridge::engine_call_pushback
    };
    jni::JNativeMethod engine_call_remove_at_method{
            "engine_call_remove_at",
            "(J)V",
            (void*) PackedStringArrayBridge::engine_call_remove_at
    };
    jni::JNativeMethod engine_call_resize_method{
            "engine_call_resize",
            "(J)V",
            (void*) PackedStringArrayBridge::engine_call_resize
    };
    jni::JNativeMethod engine_call_set_method{
            "engine_call_set",
            "(J)V",
            (void*) PackedStringArrayBridge::engine_call_set
    };
    jni::JNativeMethod engine_call_size_method{
            "engine_call_size",
            "(J)V",
            (void*) PackedStringArrayBridge::engine_call_size
    };

    Vector<jni::JNativeMethod> methods;
    methods.push_back(engine_call_constructor_method);
    methods.push_back(engine_call_append_method);
    methods.push_back(engine_call_appendArray_method);
    methods.push_back(engine_call_is_empty_method);
    methods.push_back(engine_call_get_method);
    methods.push_back(engine_call_insert_method);
    methods.push_back(engine_call_reverse_method);
//    methods.push_back(engine_call_join_method);
    methods.push_back(engine_call_pushback_method);
    methods.push_back(engine_call_remove_at_method);
    methods.push_back(engine_call_resize_method);
    methods.push_back(engine_call_set_method);
    methods.push_back(engine_call_size_method);

    jni::Env env{jni::Jvm::current_env()};
    j_class.register_natives(env, methods);
    p_wrapped.delete_local_ref(env);
}

uintptr_t PackedStringArrayBridge::engine_call_constructor(JNIEnv* p_raw_env, jobject p_instance) {
    return reinterpret_cast<uintptr_t>(memnew(PackedStringArray));
}

void PackedStringArrayBridge::engine_call_append(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env{p_raw_env};
    Variant args[1] = {};
    TransferContext* transfer_context{GDKotlin::get_instance().transfer_context};
    transfer_context->read_args(env, args);
    from_uint_to_ptr<PackedStringArray>(p_raw_ptr)->append(args[0].operator String());
}

void PackedStringArrayBridge::engine_call_appendArray(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env{p_raw_env};
    Variant args[1] = {};
    TransferContext* transfer_context{GDKotlin::get_instance().transfer_context};
    transfer_context->read_args(env, args);
    from_uint_to_ptr<PackedStringArray>(p_raw_ptr)->append_array(args[0].operator PackedStringArray());
}

//TODO/4.0: modify naming in jvm code
void PackedStringArrayBridge::engine_call_is_empty(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env{p_raw_env};
    TransferContext* transfer_context{GDKotlin::get_instance().transfer_context};
    Variant variant{from_uint_to_ptr<PackedStringArray>(p_raw_ptr)->is_empty()};
    transfer_context->write_return_value(env, variant);
}

void PackedStringArrayBridge::engine_call_get(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env{p_raw_env};
    Variant args[1] = {};
    TransferContext* transfer_context{GDKotlin::get_instance().transfer_context};
    transfer_context->read_args(env, args);
    Variant variant{from_uint_to_ptr<PackedStringArray>(p_raw_ptr)->operator[](args[0].operator unsigned int())};
    transfer_context->write_return_value(env, variant);
}

void PackedStringArrayBridge::engine_call_insert(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env{p_raw_env};
    Variant args[2] = {};
    TransferContext* transfer_context{GDKotlin::get_instance().transfer_context};
    transfer_context->read_args(env, args);
    from_uint_to_ptr<PackedStringArray>(p_raw_ptr)->insert(args[0].operator unsigned int(), args[1].operator String());
}

//TODO/4.0: modify naming in jvm code
void PackedStringArrayBridge::engine_call_reverse(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env{p_raw_env};
    from_uint_to_ptr<PackedStringArray>(p_raw_ptr)->reverse();
}

//TODO/4.0: Find if there is a way to reimplement, or delete
//void PackedStringArrayBridge::engine_call_join(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
//    jni::Env env{p_raw_env};
//    Variant args[1] = {};
//    TransferContext* transfer_context{GDKotlin::get_instance().transfer_context};
//    transfer_context->read_args(env, args);
//    Variant variant{from_uint_to_ptr<PackedStringArray>(p_raw_ptr)->join(args[0].operator String())};
//    transfer_context->write_return_value(env, variant);
//}

void PackedStringArrayBridge::engine_call_pushback(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env{p_raw_env};
    Variant args[1] = {};
    TransferContext* transfer_context{GDKotlin::get_instance().transfer_context};
    transfer_context->read_args(env, args);
    from_uint_to_ptr<PackedStringArray>(p_raw_ptr)->push_back(args[0].operator String());
}

//TODO/4.0: modify naming in jvm code
void PackedStringArrayBridge::engine_call_remove_at(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env{p_raw_env};
    Variant args[1] = {};
    TransferContext* transfer_context{GDKotlin::get_instance().transfer_context};
    transfer_context->read_args(env, args);
    from_uint_to_ptr<PackedStringArray>(p_raw_ptr)->remove_at(args[0].operator unsigned int());
}

void PackedStringArrayBridge::engine_call_resize(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env{p_raw_env};
    Variant args[1] = {};
    TransferContext* transfer_context{GDKotlin::get_instance().transfer_context};
    transfer_context->read_args(env, args);
    from_uint_to_ptr<PackedStringArray>(p_raw_ptr)->resize(args[0].operator unsigned int());
}

void PackedStringArrayBridge::engine_call_set(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env{p_raw_env};
    Variant args[2] = {};
    TransferContext* transfer_context{GDKotlin::get_instance().transfer_context};
    transfer_context->read_args(env, args);
    from_uint_to_ptr<PackedStringArray>(p_raw_ptr)->set(args[0].operator unsigned int(), args[1].operator String());
}

void PackedStringArrayBridge::engine_call_size(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    jni::Env env{p_raw_env};
    Variant variant{from_uint_to_ptr<PackedStringArray>(p_raw_ptr)->size()};
    GDKotlin::get_instance().transfer_context->write_return_value(env, variant);
}