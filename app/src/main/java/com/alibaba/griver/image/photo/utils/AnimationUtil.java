package com.alibaba.griver.image.photo.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* loaded from: classes6.dex */
public class AnimationUtil implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    private Animation f6615a;
    private OnAnimationEndListener b;
    private OnAnimationStartListener c;
    private OnAnimationRepeatListener d;

    /* loaded from: classes6.dex */
    public interface OnAnimationEndListener {
        void onAnimationEnd(Animation animation);
    }

    /* loaded from: classes6.dex */
    public interface OnAnimationRepeatListener {
        void onAnimationRepeat(Animation animation);
    }

    /* loaded from: classes6.dex */
    public interface OnAnimationStartListener {
        void onAnimationStart(Animation animation);
    }

    public AnimationUtil(Context context, int i) {
        Animation loadAnimation = AnimationUtils.loadAnimation(context, i);
        this.f6615a = loadAnimation;
        loadAnimation.setAnimationListener(this);
    }

    public AnimationUtil setInterpolator(Interpolator interpolator) {
        this.f6615a.setInterpolator(interpolator);
        return this;
    }

    public void startAnimation(View view) {
        if (view.getAnimation() != null) {
            view.getAnimation().cancel();
        }
        view.startAnimation(this.f6615a);
    }

    public AnimationUtil setDuration(long j) {
        this.f6615a.setDuration(j);
        return this;
    }

    public AnimationUtil setFillAfter(boolean z) {
        this.f6615a.setFillAfter(z);
        return this;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        OnAnimationStartListener onAnimationStartListener = this.c;
        if (onAnimationStartListener != null) {
            onAnimationStartListener.onAnimationStart(animation);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        OnAnimationEndListener onAnimationEndListener = this.b;
        if (onAnimationEndListener != null) {
            onAnimationEndListener.onAnimationEnd(animation);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
        OnAnimationRepeatListener onAnimationRepeatListener = this.d;
        if (onAnimationRepeatListener != null) {
            onAnimationRepeatListener.onAnimationRepeat(animation);
        }
    }

    public static void fadeInFadeOut(Activity activity) {
        if (activity != null) {
            activity.overridePendingTransition(17432576, 17432577);
        }
    }
}
