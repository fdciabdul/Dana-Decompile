package com.alibaba.griver.beehive.lottie.player;

import android.graphics.RectF;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class PlaceholderZoneModel implements Serializable {
    public DynamicLayerAction dynamicLayerAction;
    public String layerId;
    public RectF mapRect;
    public TimerLayerModel timerLayerModel;

    public PlaceholderZoneModel(String str, RectF rectF, DynamicLayerAction dynamicLayerAction) {
        this.layerId = str;
        this.mapRect = rectF;
        this.dynamicLayerAction = dynamicLayerAction;
    }

    public PlaceholderZoneModel(String str, RectF rectF, TimerLayerModel timerLayerModel) {
        this.layerId = str;
        this.mapRect = rectF;
        this.timerLayerModel = timerLayerModel;
    }

    public TimerLayerModel getTimerLayerModel() {
        return this.timerLayerModel;
    }

    public void setTimerLayerModel(TimerLayerModel timerLayerModel) {
        this.timerLayerModel = timerLayerModel;
    }

    public String getLayerId() {
        return this.layerId;
    }

    public void setLayerId(String str) {
        this.layerId = str;
    }

    public RectF getMapRect() {
        return this.mapRect;
    }

    public void setMapRect(RectF rectF) {
        this.mapRect = rectF;
    }

    public DynamicLayerAction getDynamicLayerAction() {
        return this.dynamicLayerAction;
    }

    public void setDynamicLayerAction(DynamicLayerAction dynamicLayerAction) {
        this.dynamicLayerAction = dynamicLayerAction;
    }
}
