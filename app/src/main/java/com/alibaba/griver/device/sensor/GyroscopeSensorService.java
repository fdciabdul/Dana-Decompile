package com.alibaba.griver.device.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.utils.CommonUtils;
import com.alibaba.griver.device.adapter.Callback;

/* loaded from: classes6.dex */
public class GyroscopeSensorService extends SensorService {

    /* renamed from: a  reason: collision with root package name */
    private SensorEventListener f6531a;
    private SensorEventListener b;
    private SensorEventListener c;
    private float[] d;
    private float[] e;
    private float[] f;
    private volatile int g = 50;
    private long h = System.currentTimeMillis();
    private Callback i;
    private Context j;
    private float k;
    private boolean l;

    public GyroscopeSensorService() {
        this.f6531a = new SensorChangedListener();
        this.b = new SensorChangedListener();
        this.c = new SensorChangedListener();
    }

    @Override // com.alibaba.griver.device.adapter.LifeCycle
    public void onCreate(Context context, JSONObject jSONObject) {
        this.j = context;
        this.k = CommonUtils.getFloat(jSONObject, "interval", 0.5f);
    }

    @Override // com.alibaba.griver.device.sensor.SensorService
    public void register(Callback callback) {
        if (this.l) {
            return;
        }
        int i = 1;
        this.l = true;
        SensorManager sensorManager = (SensorManager) this.j.getSystemService("sensor");
        if (sensorManager == null) {
            return;
        }
        Sensor defaultSensor = sensorManager.getDefaultSensor(4);
        Sensor defaultSensor2 = sensorManager.getDefaultSensor(1);
        Sensor defaultSensor3 = sensorManager.getDefaultSensor(2);
        this.i = callback;
        this.g = 50;
        float f = this.k;
        if (f != 0.0f) {
            this.g = (int) (f * 1000.0f);
        }
        if ((this.g < 0 || this.g >= 20) && (this.g < 20 || this.g >= 60)) {
            i = (this.g < 60 || this.g >= 200) ? 3 : 2;
        }
        sensorManager.registerListener(this.f6531a, defaultSensor, i);
        sensorManager.registerListener(this.b, defaultSensor2, i);
        sensorManager.registerListener(this.c, defaultSensor3, i);
    }

    @Override // com.alibaba.griver.device.sensor.SensorService
    public void unregister() {
        if (this.l) {
            this.l = false;
            SensorManager sensorManager = (SensorManager) this.j.getSystemService("sensor");
            if (sensorManager == null) {
                return;
            }
            sensorManager.unregisterListener(this.f6531a);
            sensorManager.unregisterListener(this.b);
            sensorManager.unregisterListener(this.c);
        }
    }

    @Override // com.alibaba.griver.device.adapter.LifeCycle
    public void onDestroy() {
        this.j = null;
        this.i = null;
        this.d = null;
        this.e = null;
        this.f = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.d == null || this.e == null || this.f == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.h < this.g) {
            return;
        }
        this.h = currentTimeMillis;
        float[] fArr = this.f;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        if (this.i == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("x", (Object) Float.valueOf(f));
        jSONObject.put("y", (Object) Float.valueOf(f2));
        jSONObject.put("z", (Object) Float.valueOf(f3));
        this.i.onTrigger(jSONObject, 4);
    }

    /* loaded from: classes6.dex */
    class SensorChangedListener implements SensorEventListener {
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        private SensorChangedListener() {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent == null || sensorEvent.values == null || sensorEvent.sensor == null) {
                return;
            }
            int type = sensorEvent.sensor.getType();
            if (type == 1) {
                GyroscopeSensorService.this.d = sensorEvent.values;
            } else if (type == 2) {
                GyroscopeSensorService.this.e = sensorEvent.values;
            } else if (type == 4) {
                GyroscopeSensorService.this.f = sensorEvent.values;
            }
            GyroscopeSensorService.this.a();
        }
    }
}
