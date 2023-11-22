package com.alibaba.griver.lottie.animation.keyframe;

import com.alibaba.griver.lottie.model.content.GradientColor;
import com.alibaba.griver.lottie.value.Keyframe;
import java.util.List;

/* loaded from: classes6.dex */
public class GradientColorKeyframeAnimation extends KeyframeAnimation<GradientColor> {
    private final GradientColor gradientColor;

    @Override // com.alibaba.griver.lottie.animation.keyframe.BaseKeyframeAnimation
    /* bridge */ /* synthetic */ Object getValue(Keyframe keyframe, float f) {
        return getValue((Keyframe<GradientColor>) keyframe, f);
    }

    public GradientColorKeyframeAnimation(List<Keyframe<GradientColor>> list) {
        super(list);
        GradientColor gradientColor = list.get(0).startValue;
        int size = gradientColor != null ? gradientColor.getSize() : 0;
        this.gradientColor = new GradientColor(new float[size], new int[size]);
    }

    @Override // com.alibaba.griver.lottie.animation.keyframe.BaseKeyframeAnimation
    GradientColor getValue(Keyframe<GradientColor> keyframe, float f) {
        this.gradientColor.lerp(keyframe.startValue, keyframe.endValue, f);
        return this.gradientColor;
    }
}
