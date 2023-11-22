package com.alipay.mobile.embedview.mapbiz.core;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.WindowManager;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.apmap.model.AdapterMarker;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;

/* loaded from: classes6.dex */
public class SensorEventHelper implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    private SensorManager f7146a;
    private Sensor b;
    private long c = 0;
    private final int d = 100;
    private float e = 0.0f;
    private Context f;
    private AdapterMarker g;

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public SensorEventHelper(Context context) {
        this.f = context;
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.f7146a = sensorManager;
        this.b = sensorManager.getDefaultSensor(3);
    }

    public void registerSensorListener() {
        SensorManager sensorManager = this.f7146a;
        if (sensorManager != null) {
            try {
                sensorManager.registerListener(this, this.b, 3);
            } catch (Throwable th) {
                RVLogger.e(H5MapContainer.TAG, th);
            }
        }
    }

    public void unRegisterSensorListener() {
        SensorManager sensorManager = this.f7146a;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this, this.b);
        }
    }

    public void setCurrentMarker(AdapterMarker adapterMarker) {
        this.g = adapterMarker;
        float f = this.e;
        if (f != 0.0f) {
            adapterMarker.setRotateAngle(360.0f - f);
        }
    }

    public AdapterMarker getCurrentMarker() {
        return this.g;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (System.currentTimeMillis() - this.c >= 100 && sensorEvent.sensor.getType() == 3) {
            float screenRotationOnPhone = (sensorEvent.values[0] + getScreenRotationOnPhone(this.f)) % 360.0f;
            if (screenRotationOnPhone > 180.0f) {
                screenRotationOnPhone -= 360.0f;
            } else if (screenRotationOnPhone < -180.0f) {
                screenRotationOnPhone += 360.0f;
            }
            if (Math.abs(this.e - screenRotationOnPhone) >= 3.0f) {
                if (Float.isNaN(screenRotationOnPhone)) {
                    screenRotationOnPhone = 0.0f;
                }
                this.e = screenRotationOnPhone;
                AdapterMarker adapterMarker = this.g;
                if (adapterMarker != null) {
                    adapterMarker.setRotateAngle(360.0f - screenRotationOnPhone);
                }
                this.c = System.currentTimeMillis();
            }
        }
    }

    public static int getScreenRotationOnPhone(Context context) {
        int i;
        try {
            i = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        } catch (Throwable unused) {
            i = 0;
        }
        if (i != 1) {
            if (i != 2) {
                return i != 3 ? 0 : -90;
            }
            return 180;
        }
        return 90;
    }
}
