package com.alibaba.griver.beehive.lottie.player;

import android.animation.Animator;
import android.view.View;
import com.alibaba.griver.lottie.LottieAnimationView;

/* loaded from: classes6.dex */
public interface ILottiePlayer {
    void addAnimatorListener(Animator.AnimatorListener animatorListener);

    void applyParams(LottieParams lottieParams);

    void attach();

    void destroy();

    void detach();

    void downgradeToPlaceholder();

    long getDuration();

    LottieAnimationView getLottie();

    float getProgress();

    View getView();

    void goToAndPlay(float f);

    void goToAndStop(float f);

    boolean isPlaying();

    void pause();

    void play();

    void play(float f, float f2);

    void play(int i, int i2);

    void playByDynamicSpeed(long j);

    void playByTotalDuration(long j, IPlayByTotalDurationListener iPlayByTotalDurationListener);

    void removeAnimatorListener(Animator.AnimatorListener animatorListener);

    void sendEvent(String str, String str2);

    void setProgress(float f);

    void setRepeatCount(int i);

    void setSpeed(float f);

    void stop();
}
