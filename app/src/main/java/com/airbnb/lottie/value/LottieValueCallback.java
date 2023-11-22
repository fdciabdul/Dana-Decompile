package com.airbnb.lottie.value;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;

/* loaded from: classes3.dex */
public class LottieValueCallback<T> {
    public BaseKeyframeAnimation<?, ?> lookAheadTest;
    protected T moveToNextValue;
    public final LottieFrameInfo<T> scheduleImpl;

    public LottieValueCallback() {
        this.scheduleImpl = new LottieFrameInfo<>();
        this.moveToNextValue = null;
    }

    public LottieValueCallback(T t) {
        this.scheduleImpl = new LottieFrameInfo<>();
        this.moveToNextValue = t;
    }

    public T BuiltInFictitiousFunctionClassFactory(LottieFrameInfo<T> lottieFrameInfo) {
        return this.moveToNextValue;
    }
}
