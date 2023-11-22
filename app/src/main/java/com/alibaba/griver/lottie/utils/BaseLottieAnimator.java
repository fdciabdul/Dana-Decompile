package com.alibaba.griver.lottie.utils;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.beehive.lottie.constants.LottieConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes6.dex */
public abstract class BaseLottieAnimator extends ValueAnimator {
    private final Set<ValueAnimator.AnimatorUpdateListener> updateListeners = new CopyOnWriteArraySet();
    private final Set<Animator.AnimatorListener> listeners = new CopyOnWriteArraySet();
    private boolean needLog = true;

    public abstract float getAnimatedValueAbsolute();

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setStartDelay(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public ValueAnimator setDuration(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    @Override // android.animation.ValueAnimator
    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.updateListeners.add(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.updateListeners.remove(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        this.updateListeners.clear();
    }

    @Override // android.animation.Animator
    public void addListener(Animator.AnimatorListener animatorListener) {
        this.listeners.add(animatorListener);
    }

    @Override // android.animation.Animator
    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.listeners.remove(animatorListener);
    }

    @Override // android.animation.Animator
    public void removeAllListeners() {
        this.listeners.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyStart(boolean z) {
        for (Animator.AnimatorListener animatorListener : this.listeners) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationStart(this, z);
            } else {
                animatorListener.onAnimationStart(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyRepeat() {
        Iterator<Animator.AnimatorListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onAnimationRepeat(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyEnd(boolean z) {
        for (Animator.AnimatorListener animatorListener : this.listeners) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationEnd(this, z);
            } else {
                animatorListener.onAnimationEnd(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyCancel() {
        Iterator<Animator.AnimatorListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onAnimationCancel(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyUpdate() {
        Object animatedValue = getAnimatedValue();
        if (animatedValue == null) {
            if (this.needLog) {
                StringBuilder sb = new StringBuilder();
                sb.append("onAnimationUpdate状态异常，getAnimatedValue()=");
                sb.append(animatedValue);
                sb.append(", getAnimatedValueAbsolute()=");
                sb.append(getAnimatedValueAbsolute());
                GriverLogger.w("BaseLottieAnimator", sb.toString());
                HashMap hashMap = new HashMap(4);
                hashMap.put("biz_name", LottieConstants.RENDER_TYPE_LOTTIE);
                hashMap.put("sub_name", LottieConstants.RENDER_TYPE_LOTTIE);
                hashMap.put("fail_code", "getAnimatedValue");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("getAnimatedValue结果为空：");
                sb2.append(this);
                hashMap.put("fail_reason", sb2.toString());
            }
            this.needLog = false;
            return;
        }
        Iterator<ValueAnimator.AnimatorUpdateListener> it = this.updateListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().onAnimationUpdate(this);
            } catch (Throwable unused) {
                if (this.needLog) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("onAnimationUpdate回调运行异常：animatedValue=");
                    sb3.append(animatedValue);
                    sb3.append(", ");
                    sb3.append(this);
                    GriverLogger.w("BaseLottieAnimator", sb3.toString());
                }
            }
        }
        this.needLog = false;
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(getAnimatedValueAbsolute());
    }
}
