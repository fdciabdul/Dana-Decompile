package com.alibaba.griver.beehive.lottie.player;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.view.View;

/* loaded from: classes6.dex */
public interface ICorePlayer<V extends View, S> {
    void addAnimatorListener(Animator.AnimatorListener animatorListener);

    void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener);

    void destroy();

    long getDuration();

    String getLottieSource();

    float getProgress();

    Bitmap getSnapshot();

    V getView();

    void goToAndPlay(float f);

    void goToAndStop(float f);

    boolean hasPlayController();

    void hide();

    void initCorePlayer(LottieParams lottieParams, String str);

    boolean isPlaying();

    void pause();

    void play();

    void play(float f, float f2);

    void play(int i, int i2);

    void playByDynamicSpeed(long j);

    void receiveParams(LottieParams lottieParams);

    void removeAnimatorListener(Animator.AnimatorListener animatorListener);

    void resume();

    void sendEvent(String str, String str2);

    void setPlayController(FramePlayController framePlayController);

    void setPlayerParams(LottieParams lottieParams);

    void setProgress(float f);

    void setProgressWithFrame(int i);

    void setRepeatCount(int i);

    void setSpeed(float f);

    void stop();
}
