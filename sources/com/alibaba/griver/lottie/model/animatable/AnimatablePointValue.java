package com.alibaba.griver.lottie.model.animatable;

import android.graphics.PointF;
import com.alibaba.griver.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.alibaba.griver.lottie.animation.keyframe.PointKeyframeAnimation;
import com.alibaba.griver.lottie.value.Keyframe;
import java.util.List;

/* loaded from: classes6.dex */
public class AnimatablePointValue extends BaseAnimatableValue<PointF, PointF> {
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

    public AnimatablePointValue(List<Keyframe<PointF>> list) {
        super((List) list);
    }

    @Override // com.alibaba.griver.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<PointF, PointF> createAnimation() {
        return new PointKeyframeAnimation(this.keyframes);
    }
}
