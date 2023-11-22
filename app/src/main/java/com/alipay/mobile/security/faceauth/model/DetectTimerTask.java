package com.alipay.mobile.security.faceauth.model;

import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes7.dex */
public class DetectTimerTask {
    int mDelay;
    private int mInitTime;
    int mInternal;
    int mTimeout;
    TimerListener mTimerTaskListener;
    Timer myTime;

    /* loaded from: classes7.dex */
    public interface TimerListener {
        void countdown(int i);
    }

    public DetectTimerTask(int i) {
        this.myTime = null;
        this.mDelay = 1000;
        this.mInternal = 1000;
        this.mInitTime = i;
        this.mTimeout = i;
    }

    public DetectTimerTask(int i, int i2, int i3) {
        this.myTime = null;
        this.mInitTime = i;
        this.mTimeout = i;
        this.mDelay = i2;
        this.mInternal = i3;
    }

    public void setTimerTaskListener(TimerListener timerListener) {
        this.mTimerTaskListener = timerListener;
    }

    public int getLeftTime() {
        return this.mTimeout;
    }

    public boolean isTimeOut() {
        return this.mTimeout == 0;
    }

    public void reset() {
        this.mTimeout = this.mInitTime;
    }

    public void start() {
        int i = this.mInitTime;
        this.mTimeout = i;
        TimerListener timerListener = this.mTimerTaskListener;
        if (timerListener != null) {
            timerListener.countdown(i);
        }
        stop();
        Timer timer = new Timer();
        this.myTime = timer;
        timer.schedule(new TimerTask() { // from class: com.alipay.mobile.security.faceauth.model.DetectTimerTask.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                DetectTimerTask.this.mTimeout -= DetectTimerTask.this.mInternal;
                if (DetectTimerTask.this.mTimeout <= 0) {
                    DetectTimerTask.this.mTimeout = 0;
                    DetectTimerTask.this.myTime.cancel();
                }
                if (DetectTimerTask.this.mTimerTaskListener != null) {
                    DetectTimerTask.this.mTimerTaskListener.countdown(DetectTimerTask.this.mTimeout);
                }
            }
        }, this.mDelay, this.mInternal);
    }

    public void stop() {
        this.mTimeout = this.mInitTime;
        Timer timer = this.myTime;
        if (timer != null) {
            timer.cancel();
            this.myTime = null;
        }
    }
}
