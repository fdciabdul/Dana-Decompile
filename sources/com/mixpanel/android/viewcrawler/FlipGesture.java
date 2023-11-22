package com.mixpanel.android.viewcrawler;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.mixpanel.android.util.MPLog;

/* loaded from: classes.dex */
class FlipGesture implements SensorEventListener {
    private final OnFlipGestureListener KClassImpl$Data$declaredNonStaticMembers$2;
    private int getAuthRequestContext = -1;
    private int MyBillsEntityDataFactory = 0;
    private long PlaceComponentResult = -1;
    private final float[] BuiltInFictitiousFunctionClassFactory = new float[3];

    /* loaded from: classes.dex */
    public interface OnFlipGestureListener {
        void BuiltInFictitiousFunctionClassFactory();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public FlipGesture(OnFlipGestureListener onFlipGestureListener) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = onFlipGestureListener;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        int i = 0;
        while (i < 3) {
            float[] fArr2 = this.BuiltInFictitiousFunctionClassFactory;
            float f = i < fArr2.length ? fArr2[i] : 0.0f;
            fArr2[i] = f + ((fArr[i] - f) * 0.7f);
            i++;
        }
        float[] fArr3 = this.BuiltInFictitiousFunctionClassFactory;
        int i2 = this.MyBillsEntityDataFactory;
        float f2 = fArr3[0];
        float f3 = fArr3[1];
        float f4 = fArr3[2];
        float f5 = (f2 * f2) + (f3 * f3) + (f4 * f4);
        this.MyBillsEntityDataFactory = 0;
        if (f4 > 7.8f && f4 < 11.8f) {
            this.MyBillsEntityDataFactory = -1;
        }
        if (f4 < -7.8f && f4 > -11.8f) {
            this.MyBillsEntityDataFactory = 1;
        }
        if (f5 < 60.840004f || f5 > 139.24f) {
            this.MyBillsEntityDataFactory = 0;
        }
        if (i2 != this.MyBillsEntityDataFactory) {
            this.PlaceComponentResult = sensorEvent.timestamp;
        }
        long j = sensorEvent.timestamp - this.PlaceComponentResult;
        int i3 = this.MyBillsEntityDataFactory;
        if (i3 == -1) {
            if (j <= 250000000 || this.getAuthRequestContext != 1) {
                return;
            }
            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.FlipGesture", "Flip gesture completed");
            this.getAuthRequestContext = 0;
            this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
        } else if (i3 != 0) {
            if (i3 == 1 && j > 250000000 && this.getAuthRequestContext == 0) {
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.FlipGesture", "Flip gesture begun");
                this.getAuthRequestContext = 1;
            }
        } else if (j <= 1000000000 || this.getAuthRequestContext == 0) {
        } else {
            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.FlipGesture", "Flip gesture abandoned");
            this.getAuthRequestContext = 0;
        }
    }
}
