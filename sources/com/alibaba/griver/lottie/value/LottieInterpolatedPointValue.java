package com.alibaba.griver.lottie.value;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.alibaba.griver.lottie.utils.MiscUtils;

/* loaded from: classes6.dex */
public class LottieInterpolatedPointValue extends LottieInterpolatedValue<PointF> {
    private final PointF point;

    public LottieInterpolatedPointValue(PointF pointF, PointF pointF2) {
        super(pointF, pointF2);
        this.point = new PointF();
    }

    public LottieInterpolatedPointValue(PointF pointF, PointF pointF2, Interpolator interpolator) {
        super(pointF, pointF2, interpolator);
        this.point = new PointF();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.alibaba.griver.lottie.value.LottieInterpolatedValue
    public PointF interpolateValue(PointF pointF, PointF pointF2, float f) {
        this.point.set(MiscUtils.lerp(pointF.x, pointF2.x, f), MiscUtils.lerp(pointF.y, pointF2.y, f));
        return this.point;
    }
}
