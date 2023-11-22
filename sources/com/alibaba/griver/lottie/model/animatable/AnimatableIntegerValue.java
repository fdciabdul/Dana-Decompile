package com.alibaba.griver.lottie.model.animatable;

import com.alibaba.griver.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.alibaba.griver.lottie.animation.keyframe.IntegerKeyframeAnimation;
import com.alibaba.griver.lottie.value.Keyframe;
import java.util.List;

/* loaded from: classes6.dex */
public class AnimatableIntegerValue extends BaseAnimatableValue<Integer, Integer> {
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

    public AnimatableIntegerValue() {
        super(100);
    }

    public AnimatableIntegerValue(List<Keyframe<Integer>> list) {
        super((List) list);
    }

    @Override // com.alibaba.griver.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<Integer, Integer> createAnimation() {
        return new IntegerKeyframeAnimation(this.keyframes);
    }
}
