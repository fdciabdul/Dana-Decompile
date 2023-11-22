package at.wirecube.additiveanimations.helper.evaluators;

import android.animation.TypeEvaluator;

/* loaded from: classes6.dex */
public class ColorEvaluator implements TypeEvaluator<Float> {
    @Override // android.animation.TypeEvaluator
    public /* synthetic */ Float evaluate(float f, Float f2, Float f3) {
        int intValue = f2.intValue();
        int i = (intValue >> 24) & 255;
        int i2 = (intValue >> 16) & 255;
        int i3 = (intValue >> 8) & 255;
        int i4 = intValue & 255;
        int intValue2 = f3.intValue();
        return Float.valueOf(((i + ((int) ((((intValue2 >> 24) & 255) - i) * f))) << 24) | ((i2 + ((int) ((((intValue2 >> 16) & 255) - i2) * f))) << 16) | ((i3 + ((int) ((((intValue2 >> 8) & 255) - i3) * f))) << 8) | (i4 + ((int) (f * ((intValue2 & 255) - i4)))));
    }
}
