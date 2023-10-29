package qinomed.oganesson.mixin;

import net.minecraft.util.Mth;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import qinomed.oganesson.OganessonNative;

@Mixin(Mth.class)
public class GreatestMthMixinEver {

    /**
     * @author QinomeD
     * @reason I wonder
     */
    @Overwrite
    public static float sin(float number) {
        return OganessonNative.sin(number);
    }

    /**
     * @author QinomeD
     * @reason I wonder 2
     */
    @Overwrite
    public static float cos(float number) {
        return OganessonNative.cos(number);
    }

    /**
     * @author QinomeD
     * @reason I wonder squared
     */
    @Overwrite
    public static float sqrt(float number) {
        try {
            return OganessonNative.sqrt(number);
        } catch (UnsatisfiedLinkError error) {
            return (float) Math.sqrt(number);
        }
    }

    /**
     * @author QinomeD
     * @reason lerp lerp
     */
    @Overwrite
    public static double lerp(double pDelta, double pStart, double pEnd) {
        return OganessonNative.lerp(pDelta, pStart, pEnd);
    }

    /**
     * @author QinomeD
     * @reason fasterInvSqrt haha
     */
    @Overwrite
    public static float fastInvSqrt(float number) {
        return OganessonNative.fastInvSqrt(number);
    }

    /**
     * @author QinomeD
     * @reason atan of thai tan
     */
    @Overwrite
    public static double atan2(double y, double x) {
        return OganessonNative.atan2(y, x);
    }
}
