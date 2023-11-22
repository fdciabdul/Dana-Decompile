package com.alibaba.griver.lottie.model.animatable;

import android.graphics.Path;
import com.alibaba.griver.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.alibaba.griver.lottie.animation.keyframe.ShapeKeyframeAnimation;
import com.alibaba.griver.lottie.model.content.ShapeData;
import com.alibaba.griver.lottie.value.Keyframe;
import java.util.List;

/* loaded from: classes6.dex */
public class AnimatableShapeValue extends BaseAnimatableValue<ShapeData, Path> {
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

    public AnimatableShapeValue(List<Keyframe<ShapeData>> list) {
        super((List) list);
    }

    @Override // com.alibaba.griver.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<ShapeData, Path> createAnimation() {
        return new ShapeKeyframeAnimation(this.keyframes);
    }
}
