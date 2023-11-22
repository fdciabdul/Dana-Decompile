package com.alipay.zoloz.zface.utils;

import com.alipay.mobile.security.faceauth.model.DetectTimerTask;

/* loaded from: classes7.dex */
public class TimerUtil {
    private TimerManagerListener listener;
    private DetectTimerTask mDetectTimerTask;
    private int time;

    /* loaded from: classes7.dex */
    public interface TimerManagerListener {
        void timeOut();

        void update(int i);
    }

    public TimerUtil(int i) {
        this.time = i;
        DetectTimerTask detectTimerTask = new DetectTimerTask(i * 1000);
        this.mDetectTimerTask = detectTimerTask;
        detectTimerTask.setTimerTaskListener(new DetectTimerTask.TimerListener() { // from class: com.alipay.zoloz.zface.utils.TimerUtil.1
            @Override // com.alipay.mobile.security.faceauth.model.DetectTimerTask.TimerListener
            public void countdown(int i2) {
                if (TimerUtil.this.mDetectTimerTask == null || !TimerUtil.this.mDetectTimerTask.isTimeOut()) {
                    TimerUtil.this.listener.update(i2 / 1000);
                } else if (TimerUtil.this.listener != null) {
                    TimerUtil.this.listener.timeOut();
                    TimerUtil.this.mDetectTimerTask.stop();
                }
            }
        });
    }

    public void setTimerListener(TimerManagerListener timerManagerListener) {
        this.listener = timerManagerListener;
    }

    public void startTimer() {
        this.mDetectTimerTask.start();
    }

    public void stopTimer() {
        DetectTimerTask detectTimerTask = this.mDetectTimerTask;
        if (detectTimerTask != null) {
            detectTimerTask.stop();
        }
    }

    public void release() {
        DetectTimerTask detectTimerTask = this.mDetectTimerTask;
        if (detectTimerTask != null) {
            detectTimerTask.stop();
            this.mDetectTimerTask.setTimerTaskListener(null);
            this.mDetectTimerTask = null;
        }
    }

    public void resetTimer() {
        this.mDetectTimerTask.reset();
    }
}
