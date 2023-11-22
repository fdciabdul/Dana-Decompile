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
public class CompassSensorService extends SensorService {

    /* renamed from: a  reason: collision with root package name */
    private volatile float f6530a;
    private float[] c;
    private float[] d;
    private Callback e;
    private Context f;
    private boolean g;
    private Long b = Long.valueOf(System.currentTimeMillis());
    private SensorEventListener h = new SensorEventListener() { // from class: com.alibaba.griver.device.sensor.CompassSensorService.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent == null || sensorEvent.values == null || sensorEvent.sensor == null) {
                return;
            }
            int type = sensorEvent.sensor.getType();
            if ((type == 2 || type == 1) && ((float) (System.currentTimeMillis() - CompassSensorService.this.b.longValue())) > CompassSensorService.this.f6530a) {
                CompassSensorService.this.b = Long.valueOf(System.currentTimeMillis());
                if (type == 2) {
                    try {
                        CompassSensorService.this.c = sensorEvent.values;
                    } catch (Exception unused) {
                        return;
                    }
                }
                if (type == 1) {
                    CompassSensorService.this.d = sensorEvent.values;
                }
                if (CompassSensorService.this.e == null || CompassSensorService.this.c == null || CompassSensorService.this.d == null) {
                    return;
                }
                CompassSensorService compassSensorService = CompassSensorService.this;
                compassSensorService.sendSensorResult(compassSensorService.e, CompassSensorService.this.c, CompassSensorService.this.d);
            }
        }
    };

    @Override // com.alibaba.griver.device.adapter.LifeCycle
    public void onCreate(Context context, JSONObject jSONObject) {
        this.f = context;
        this.f6530a = CommonUtils.getFloat(jSONObject, "interval", 100.0f);
    }

    @Override // com.alibaba.griver.device.sensor.SensorService
    public void register(Callback callback) {
        if (this.g) {
            return;
        }
        this.g = true;
        this.e = callback;
        SensorManager sensorManager = (SensorManager) this.f.getSystemService("sensor");
        Sensor defaultSensor = sensorManager.getDefaultSensor(2);
        Sensor defaultSensor2 = sensorManager.getDefaultSensor(1);
        sensorManager.registerListener(this.h, defaultSensor, 3);
        sensorManager.registerListener(this.h, defaultSensor2, 3);
    }

    @Override // com.alibaba.griver.device.sensor.SensorService
    public void unregister() {
        if (this.g) {
            this.g = false;
            ((SensorManager) this.f.getSystemService("sensor")).unregisterListener(this.h);
        }
    }

    @Override // com.alibaba.griver.device.adapter.LifeCycle
    public void onDestroy() {
        this.h = null;
        this.e = null;
        this.f = null;
    }

    protected void sendSensorResult(Callback callback, float[] fArr, float[] fArr2) {
        JSONObject jSONObject = new JSONObject();
        float[] fArr3 = new float[9];
        SensorManager.getRotationMatrix(fArr3, null, fArr2, fArr);
        SensorManager.getOrientation(fArr3, r1);
        float degrees = (float) Math.toDegrees(r1[0]);
        float[] fArr4 = {degrees};
        jSONObject.put("direction", (Object) Integer.valueOf((int) ((degrees + 360.0f) % 360.0f)));
        callback.onTrigger(jSONObject, 2);
    }
}
