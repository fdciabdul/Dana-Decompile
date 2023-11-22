package com.alibaba.griver.beehive.lottie.player;

import java.io.Serializable;

/* loaded from: classes6.dex */
public class TimerLayerModel implements Serializable {
    public long countDownLeftMs;
    public String richLabelText;
    public String timeUpRichLabalText;

    public TimerLayerModel(String str, long j, String str2) {
        this.richLabelText = str;
        this.countDownLeftMs = j;
        this.timeUpRichLabalText = str2;
    }

    public String getRichLabelText() {
        return this.richLabelText;
    }

    public void setRichLabelText(String str) {
        this.richLabelText = str;
    }

    public long getCountDownLeftMs() {
        return this.countDownLeftMs;
    }

    public void setCountDownLeftMs(long j) {
        this.countDownLeftMs = j;
    }

    public String getTimeUpRichLabalText() {
        return this.timeUpRichLabalText;
    }

    public void setTimeUpRichLabalText(String str) {
        this.timeUpRichLabalText = str;
    }
}
