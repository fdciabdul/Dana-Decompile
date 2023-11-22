package com.alibaba.griver.lottie.model.animatable;

import com.alibaba.griver.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.alibaba.griver.lottie.animation.keyframe.GradientColorKeyframeAnimation;
import com.alibaba.griver.lottie.model.content.GradientColor;
import com.alibaba.griver.lottie.value.Keyframe;
import java.util.List;

/* loaded from: classes6.dex */
public class AnimatableGradientColorValue extends BaseAnimatableValue<GradientColor, GradientColor> {
    @Override // com.alibaba.griver.lottie.model.animatable.BaseAnimatableValue, com.alibaba.griver.lottie.model.animatable.AnimatableValue
    public /* bridge */ /* synthetic */ List getKeyframes() {
        return super.getKeyframes();
    }

    @Override // com.alibaba.griver.lottie.model.animatable.BaseAnimatableValue, com.alibaba.griver.lottie.model.animatable.AnimatableValue
    public /* bridge */ /* synthetic */ boolean isStatic() {
        return super.isStatic();
    }

    @Override // com.alibaba.griver.lottie.model.animatable.BaseAnimatableValue
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public AnimatableGradientColorValue(List<Keyframe<GradientColor>> list) {
        super((List) list);
    }

    @Override // com.alibaba.griver.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<GradientColor, GradientColor> createAnimation() {
        return new GradientColorKeyframeAnimation(this.keyframes);
    }
}
