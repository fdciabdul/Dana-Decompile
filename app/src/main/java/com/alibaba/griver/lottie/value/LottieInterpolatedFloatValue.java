package com.alibaba.griver.lottie.value;

import android.view.animation.Interpolator;
import com.alibaba.griver.lottie.utils.MiscUtils;

/* loaded from: classes6.dex */
public class LottieInterpolatedFloatValue extends LottieInterpolatedValue<Float> {
    public LottieInterpolatedFloatValue(Float f, Float f2) {
        super(f, f2);
    }

    public LottieInterpolatedFloatValue(Float f, Float f2, Interpolator interpolator) {
        super(f, f2, interpolator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.alibaba.griver.lottie.value.LottieInterpolatedValue
    public Float interpolateValue(Float f, Float f2, float f3) {
        return Float.valueOf(MiscUtils.lerp(f.floatValue(), f2.floatValue(), f3));
    }
}
