package com.alipay.mobile.security.bio.sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.alipay.mobile.security.bio.sensor.SensorCollectors;

/* loaded from: classes7.dex */
class SensorCollectWorker implements SensorEventListener {
    private static final int SENSOR_RATEUS = 50000;
    private String mResultData;
    private Sensor mSensorEntity;
    private SensorManager mSensorManager;
    String mSensorName;
    int mSensorType;
    private Object objLock = new Object();

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public SensorCollectWorker(SensorManager sensorManager, SensorCollectors.SensorType sensorType, int i) {
        reset();
        if (sensorManager == null || sensorType == null) {
            return;
        }
        this.mSensorManager = sensorManager;
        this.mSensorEntity = sensorManager.getDefaultSensor(sensorType.getmSensorType());
        this.mSensorName = sensorType.getSensorName();
        this.mSensorType = sensorType.getmSensorType();
        if (this.mSensorEntity == null) {
            sensorType.getSensorName();
        } else {
            sensorType.getSensorName();
        }
    }

    public void start() {
        SensorManager sensorManager;
        Sensor sensor = this.mSensorEntity;
        if (sensor == null || (sensorManager = this.mSensorManager) == null) {
            return;
        }
        sensorManager.registerListener(this, sensor, 50000);
    }

    public void destory() {
        SensorManager sensorManager;
        Sensor sensor = this.mSensorEntity;
        if (sensor == null || (sensorManager = this.mSensorManager) == null) {
            return;
        }
        try {
            sensorManager.unregisterListener(this, sensor);
        } catch (Throwable unused) {
        }
        this.mSensorEntity = null;
    }

    public String getName() {
        return this.mSensorEntity == null ? "" : this.mSensorName;
    }

    public int getType() {
        if (this.mSensorEntity == null) {
            return -1;
        }
        return this.mSensorType;
    }

    public String getResultData() {
        String str;
        synchronized (this.objLock) {
            str = this.mResultData;
        }
        return str;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent == null || sensorEvent.values == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        try {
            int length = sensorEvent.values.length;
            sb.append("[");
            int i = 0;
            while (i < length) {
                sb.append((int) (sensorEvent.values[i] * 100.0f));
                i++;
                if (i < length) {
                    sb.append(",");
                }
            }
            sb.append("]");
        } catch (Throwable unused) {
        }
        synchronized (this.objLock) {
            this.mResultData = sb.toString();
        }
    }

    private void reset() {
        this.mResultData = "[,,]";
        this.mSensorEntity = null;
    }
}
