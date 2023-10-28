package qinomed.oganesson.mixin;

import net.minecraft.util.Mth;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import qinomed.oganesson.OganessonNative;

@Mixin(Mth.class)
public class GreatestMthMixinEver {

    /**
     * @author QinomeD
     * @reason shit and giggles
     */
    @Overwrite
    public static double lerp(double pDelta, double pStart, double pEnd) {
        return OganessonNative.lerp(pDelta, pStart, pEnd);
    }

    /**
     * @author QinomeD
     * @reason also shit and giggles
     */
    @Overwrite
    public static float fastInvSqrt(float number) {
        return OganessonNative.fastInvSqrt(number);
    }
}
