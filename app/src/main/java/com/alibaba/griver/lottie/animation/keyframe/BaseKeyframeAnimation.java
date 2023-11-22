package com.alibaba.griver.lottie.animation.keyframe;

import com.alibaba.griver.lottie.value.Keyframe;
import com.alibaba.griver.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public abstract class BaseKeyframeAnimation<K, A> {
    private Keyframe<K> cachedGetValueKeyframe;
    private Keyframe<K> cachedKeyframe;
    private final List<? extends Keyframe<K>> keyframes;
    protected LottieValueCallback<A> valueCallback;
    final List<AnimationListener> listeners = new ArrayList(1);
    private boolean isDiscrete = false;
    private float progress = 0.0f;
    private float cachedGetValueProgress = -1.0f;
    private A cachedGetValue = null;
    private float cachedStartDelayProgress = -1.0f;
    private float cachedEndProgress = -1.0f;

    /* loaded from: classes6.dex */
    public interface AnimationListener {
        void onValueChanged();
    }

    abstract A getValue(Keyframe<K> keyframe, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseKeyframeAnimation(List<? extends Keyframe<K>> list) {
        this.keyframes = list;
    }

    public void setIsDiscrete() {
        this.isDiscrete = true;
    }

    public void addUpdateListener(AnimationListener animationListener) {
        this.listeners.add(animationListener);
    }

    public void setProgress(float f) {
        if (this.keyframes.isEmpty()) {
            return;
        }
        Keyframe<K> currentKeyframe = getCurrentKeyframe();
        if (f < getStartDelayProgress()) {
            f = getStartDelayProgress();
        } else if (f > getEndProgress()) {
            f = getEndProgress();
        }
        if (f == this.progress) {
            return;
        }
        this.progress = f;
        Keyframe<K> currentKeyframe2 = getCurrentKeyframe();
        if (currentKeyframe == currentKeyframe2 && currentKeyframe2.isStatic()) {
            return;
        }
        notifyListeners();
    }

    public void notifyListeners() {
        for (int i = 0; i < this.listeners.size(); i++) {
            this.listeners.get(i).onValueChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Keyframe<K> getCurrentKeyframe() {
        Keyframe<K> keyframe = this.cachedKeyframe;
        if (keyframe != null && keyframe.containsProgress(this.progress)) {
            return this.cachedKeyframe;
        }
        Keyframe<K> keyframe2 = this.keyframes.get(r0.size() - 1);
        if (this.progress < keyframe2.getStartProgress()) {
            for (int size = this.keyframes.size() - 1; size >= 0; size--) {
                keyframe2 = this.keyframes.get(size);
                if (keyframe2.containsProgress(this.progress)) {
                    break;
                }
            }
        }
        this.cachedKeyframe = keyframe2;
        return keyframe2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getLinearCurrentKeyframeProgress() {
        if (this.isDiscrete) {
            return 0.0f;
        }
        Keyframe<K> currentKeyframe = getCurrentKeyframe();
        if (currentKeyframe.isStatic()) {
            return 0.0f;
        }
        return (this.progress - currentKeyframe.getStartProgress()) / (currentKeyframe.getEndProgress() - currentKeyframe.getStartProgress());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getInterpolatedCurrentKeyframeProgress() {
        Keyframe<K> currentKeyframe = getCurrentKeyframe();
        if (currentKeyframe.isStatic()) {
            return 0.0f;
        }
        return currentKeyframe.interpolator.getInterpolation(getLinearCurrentKeyframeProgress());
    }

    private float getStartDelayProgress() {
        if (this.cachedStartDelayProgress == -1.0f) {
            this.cachedStartDelayProgress = this.keyframes.isEmpty() ? 0.0f : this.keyframes.get(0).getStartProgress();
        }
        return this.cachedStartDelayProgress;
    }

    float getEndProgress() {
        float endProgress;
        if (this.cachedEndProgress == -1.0f) {
            if (this.keyframes.isEmpty()) {
                endProgress = 1.0f;
            } else {
                endProgress = this.keyframes.get(r0.size() - 1).getEndProgress();
            }
            this.cachedEndProgress = endProgress;
        }
        return this.cachedEndProgress;
    }

    public A getValue() {
        Keyframe<K> currentKeyframe = getCurrentKeyframe();
        float interpolatedCurrentKeyframeProgress = getInterpolatedCurrentKeyframeProgress();
        if (this.valueCallback == null && currentKeyframe == this.cachedGetValueKeyframe && this.cachedGetValueProgress == interpolatedCurrentKeyframeProgress) {
            return this.cachedGetValue;
        }
        this.cachedGetValueKeyframe = currentKeyframe;
        this.cachedGetValueProgress = interpolatedCurrentKeyframeProgress;
        A value = getValue(currentKeyframe, interpolatedCurrentKeyframeProgress);
        this.cachedGetValue = value;
        return value;
    }

    public float getProgress() {
        return this.progress;
    }

    public void setValueCallback(LottieValueCallback<A> lottieValueCallback) {
        LottieValueCallback<A> lottieValueCallback2 = this.valueCallback;
        if (lottieValueCallback2 != null) {
            lottieValueCallback2.setAnimation(null);
        }
        this.valueCallback = lottieValueCallback;
        if (lottieValueCallback != null) {
            lottieValueCallback.setAnimation(this);
        }
    }
}
