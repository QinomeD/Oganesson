use jni::JNIEnv;
use jni::objects::{JClass};
use jni::sys::{jdouble, jfloat};


// Mth.sin(float) -> float
#[no_mangle]
pub extern "C" fn Java_qinomed_oganesson_OganessonNative_sin<'local>(
    mut env: JNIEnv<'local>,
    class: JClass<'local>,
    number: jfloat) -> jfloat {

    return number.sin();
}

// Mth.cos(float) -> float
#[no_mangle]
pub extern "C" fn Java_qinomed_oganesson_OganessonNative_cos<'local>(
    mut env: JNIEnv<'local>,
    class: JClass<'local>,
    number: jfloat) -> jfloat {

    return number.cos();
}

// Mth.sqrt(float) -> float
#[no_mangle]
pub extern "C" fn Java_qinomed_oganesson_OganessonNative_sqrt<'local>(
    mut env: JNIEnv<'local>,
    class: JClass<'local>,
    number: jfloat) -> jfloat {

    return number.sqrt();
}

// Mth.lerp(double, double, double) -> double
#[no_mangle]
pub extern "C" fn Java_qinomed_oganesson_OganessonNative_lerp<'local>(
    mut env: JNIEnv<'local>,
    class: JClass<'local>,
    delta: jdouble,
    start: jdouble,
    end: jdouble) -> jdouble {

    let output = start + delta * (end - start);
    output.into()
}

// Mth.fastInvSqrt(float) -> float
#[no_mangle]
pub extern "C" fn Java_qinomed_oganesson_OganessonNative_fastInvSqrt<'local>(
    mut env: JNIEnv<'local>,
    class: JClass<'local>,
    number: jfloat) -> jfloat {

    let half: f32 = 0.5 * number;
    let mut i: u32 = half.to_bits();
    i = 1597463007 - (i >> 1);
    let res_number: f32 = f32::from_bits(i);
    return res_number * (1.5 - half * res_number * res_number);
}

// Mth.atan2(double, double) -> double
#[no_mangle]
pub extern "C" fn Java_qinomed_oganesson_OganessonNative_atan2<'local>(
    mut env: JNIEnv<'local>,
    class: JClass<'local>,
    y: jdouble,
    x: jdouble) -> jdouble {

    return y.atan2(x);
}