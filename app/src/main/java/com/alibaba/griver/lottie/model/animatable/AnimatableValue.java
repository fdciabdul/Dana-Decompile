package com.alibaba.griver.lottie.model.animatable;

import com.alibaba.griver.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.alibaba.griver.lottie.value.Keyframe;
import java.util.List;

/* loaded from: classes6.dex */
public interface AnimatableValue<K, A> {
    BaseKeyframeAnimation<K, A> createAnimation();

    List<Keyframe<K>> getKeyframes();

    boolean isStatic();
}
