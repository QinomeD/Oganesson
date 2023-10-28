// This is the interface to the JVM that we'll call the majority of our
// methods on.
use jni::JNIEnv;

// These objects are what you should use as arguments to your native
// function. They carry extra lifetime information to prevent them escaping
// this context and getting used after being GC'd.
use jni::objects::{JClass};

// This is just a pointer. We'll be returning it from our function. We
// can't return one of the objects with lifetime information because the
// lifetime checker won't let us.
use jni::sys::{jdouble, jfloat};

#[no_mangle]
extern "system" fn Java_qinomed_oganesson_OganessonNative_lerp<'local>(
    mut env: JNIEnv<'local>,
    class: JClass<'local>,
    delta: jdouble,
    start: jdouble,
    end: jdouble) -> jdouble {

    let output = start + delta * (end - start);
    output.into()
}

#[no_mangle]
extern "system" fn Java_qinomed_Main_fastInvSqrt<'local>(
    mut env: JNIEnv<'local>,
    class: JClass<'local>,
    number: jfloat) -> jfloat {

    let half: f32 = 0.5 * number;
    let mut i: u32 = half.to_bits();
    i = 1597463007 - (i >> 1);
    let res_number: f32 = f32::from_bits(i);
    return res_number * (1.5 - half * res_number * res_number);
}

#[no_mangle]
extern "system" fn Java_qinomed_oganesson_OganessonNative_fastInvSqrt<'local>(
    mut env: JNIEnv<'local>,
    class: JClass<'local>,
    number: jfloat) -> jfloat {

    let half: f32 = 0.5 * number;
    let mut i: u32 = half.to_bits();
    i = 1597463007 - (i >> 1);
    let res_number: f32 = f32::from_bits(i);
    return res_number * (1.5 - half * res_number * res_number);
}
