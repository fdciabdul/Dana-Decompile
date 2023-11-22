package com.google.zxing.client.android;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.journeyapps.barcodescanner.camera.CameraManager;
import com.journeyapps.barcodescanner.camera.CameraSettings;

/* loaded from: classes3.dex */
public final class AmbientLightManager implements SensorEventListener {
    private static final float BRIGHT_ENOUGH_LUX = 450.0f;
    private static final float TOO_DARK_LUX = 45.0f;
    private CameraManager cameraManager;
    private CameraSettings cameraSettings;
    private Context context;
    private Handler handler = new Handler();
    private Sensor lightSensor;

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public AmbientLightManager(Context context, CameraManager cameraManager, CameraSettings cameraSettings) {
        this.context = context;
        this.cameraManager = cameraManager;
        this.cameraSettings = cameraSettings;
    }

    public final void start() {
        if (this.cameraSettings.KClassImpl$Data$declaredNonStaticMembers$2()) {
            SensorManager sensorManager = (SensorManager) this.context.getSystemService("sensor");
            Sensor defaultSensor = sensorManager.getDefaultSensor(5);
            this.lightSensor = defaultSensor;
            if (defaultSensor != null) {
                sensorManager.registerListener(this, defaultSensor, 3);
            }
        }
    }

    public final void stop() {
        if (this.lightSensor != null) {
            ((SensorManager) this.context.getSystemService("sensor")).unregisterListener(this);
            this.lightSensor = null;
        }
    }

    private void setTorch(final boolean z) {
        this.handler.post(new Runnable() { // from class: com.google.zxing.client.android.AmbientLightManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AmbientLightManager.this.m225x2388a1df(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setTorch$0$com-google-zxing-client-android-AmbientLightManager  reason: not valid java name */
    public final /* synthetic */ void m225x2388a1df(boolean z) {
        this.cameraManager.PlaceComponentResult(z);
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        if (this.cameraManager != null) {
            if (f <= TOO_DARK_LUX) {
                setTorch(true);
            } else if (f >= BRIGHT_ENOUGH_LUX) {
                setTorch(false);
            }
        }
    }
}
