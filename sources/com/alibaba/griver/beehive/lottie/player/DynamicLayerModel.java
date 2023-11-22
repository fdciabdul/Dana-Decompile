package com.alibaba.griver.beehive.lottie.player;

import android.graphics.RectF;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class DynamicLayerModel implements Serializable {
    public static final String FOR_ANIMATION = "animation";
    public static final String FOR_IMAGE = "image";
    public static final String TYPE_CLICK = "click";
    public static final String TYPE_TIMER = "timer";
    public static final String TYPE_VIDEO = "video";
    public DynamicLayerAction dynamicLayerAction;
    public String forAim;
    public String layerId;
    public RectF rect;
    public TimerLayerModel timerParams;
    public String type;

    public DynamicLayerModel() {
    }

    public DynamicLayerModel(String str, String str2, RectF rectF, String str3, TimerLayerModel timerLayerModel, DynamicLayerAction dynamicLayerAction) {
        this.layerId = str;
        this.forAim = str2;
        this.rect = rectF;
        this.type = str3;
        this.timerParams = timerLayerModel;
        this.dynamicLayerAction = dynamicLayerAction;
    }

    public String getLayerId() {
        return this.layerId;
    }

    public void setLayerId(String str) {
        this.layerId = str;
    }

    public String getForAim() {
        return this.forAim;
    }

    public void setForAim(String str) {
        this.forAim = str;
    }

    public RectF getRect() {
        return this.rect;
    }

    public void setRect(RectF rectF) {
        this.rect = rectF;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public TimerLayerModel getTimerParams() {
        return this.timerParams;
    }

    public void setTimerParams(TimerLayerModel timerLayerModel) {
        this.timerParams = timerLayerModel;
    }

    public DynamicLayerAction getDynamicLayerAction() {
        return this.dynamicLayerAction;
    }

    public void setDynamicLayerAction(DynamicLayerAction dynamicLayerAction) {
        this.dynamicLayerAction = dynamicLayerAction;
    }
}
