package com.alibaba.griver.lottie.animation.keyframe;

import com.alibaba.griver.lottie.value.Keyframe;
import com.alibaba.griver.lottie.value.LottieValueCallback;
import java.util.Collections;

/* loaded from: classes6.dex */
public class ValueCallbackKeyframeAnimation<K, A> extends BaseKeyframeAnimation<K, A> {
    private final A valueCallbackValue;

    @Override // com.alibaba.griver.lottie.animation.keyframe.BaseKeyframeAnimation
    float getEndProgress() {
        return 1.0f;
    }

    public ValueCallbackKeyframeAnimation(LottieValueCallback<A> lottieValueCallback) {
        this(lottieValueCallback, null);
    }

    public ValueCallbackKeyframeAnimation(LottieValueCallback<A> lottieValueCallback, A a2) {
        super(Collections.emptyList());
        setValueCallback(lottieValueCallback);
        this.valueCallbackValue = a2;
    }

    @Override // com.alibaba.griver.lottie.animation.keyframe.BaseKeyframeAnimation
    public void notifyListeners() {
        if (this.valueCallback != null) {
            super.notifyListeners();
        }
    }

    @Override // com.alibaba.griver.lottie.animation.keyframe.BaseKeyframeAnimation
    public A getValue() {
        LottieValueCallback<A> lottieValueCallback = this.valueCallback;
        A a2 = this.valueCallbackValue;
        return lottieValueCallback.getValueInternal(0.0f, 0.0f, a2, a2, getProgress(), getProgress(), getProgress());
    }

    @Override // com.alibaba.griver.lottie.animation.keyframe.BaseKeyframeAnimation
    A getValue(Keyframe<K> keyframe, float f) {
        return getValue();
    }
}
