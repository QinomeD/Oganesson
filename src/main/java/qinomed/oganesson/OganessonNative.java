package qinomed.oganesson;

public class OganessonNative {

    public static native float sin(float value);

    public static native float cos(float value);

    public static native float sqrt(float value);

    public static native double lerp(double delta, double start, double end);

    public static native float fastInvSqrt(float number);

    public static native double atan2(double y, double x);
}
