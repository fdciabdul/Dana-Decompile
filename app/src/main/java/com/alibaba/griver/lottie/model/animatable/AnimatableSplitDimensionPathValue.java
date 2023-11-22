package com.alibaba.griver.lottie.model.animatable;

import android.graphics.PointF;
import com.alibaba.griver.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.alibaba.griver.lottie.animation.keyframe.SplitDimensionPathKeyframeAnimation;
import com.alibaba.griver.lottie.value.Keyframe;
import java.util.List;

/* loaded from: classes6.dex */
public class AnimatableSplitDimensionPathValue implements AnimatableValue<PointF, PointF> {
    private final AnimatableFloatValue animatableXDimension;
    private final AnimatableFloatValue animatableYDimension;

    public AnimatableSplitDimensionPathValue(AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2) {
        this.animatableXDimension = animatableFloatValue;
        this.animatableYDimension = animatableFloatValue2;
    }

    @Override // com.alibaba.griver.lottie.model.animatable.AnimatableValue
    public List<Keyframe<PointF>> getKeyframes() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // com.alibaba.griver.lottie.model.animatable.AnimatableValue
    public boolean isStatic() {
        return this.animatableXDimension.isStatic() && this.animatableYDimension.isStatic();
    }

    @Override // com.alibaba.griver.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<PointF, PointF> createAnimation() {
        return new SplitDimensionPathKeyframeAnimation(this.animatableXDimension.createAnimation(), this.animatableYDimension.createAnimation());
    }
}
