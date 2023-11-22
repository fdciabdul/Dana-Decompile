package com.alibaba.griver.lottie.animation.keyframe;

import com.alibaba.griver.lottie.value.Keyframe;
import java.util.List;

/* loaded from: classes6.dex */
abstract class KeyframeAnimation<T> extends BaseKeyframeAnimation<T, T> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public KeyframeAnimation(List<? extends Keyframe<T>> list) {
        super(list);
    }
}
