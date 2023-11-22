package com.alibaba.griver.lottie.model.animatable;

import com.alibaba.griver.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.alibaba.griver.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.alibaba.griver.lottie.value.Keyframe;
import java.util.List;

/* loaded from: classes6.dex */
public class AnimatableFloatValue extends BaseAnimatableValue<Float, Float> {
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

    AnimatableFloatValue() {
        super(Float.valueOf(0.0f));
    }

    public AnimatableFloatValue(List<Keyframe<Float>> list) {
        super((List) list);
    }

    @Override // com.alibaba.griver.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<Float, Float> createAnimation() {
        return new FloatKeyframeAnimation(this.keyframes);
    }
}
