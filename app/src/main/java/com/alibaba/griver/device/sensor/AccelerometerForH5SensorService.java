package com.alibaba.griver.device.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.utils.CommonUtils;
import com.alibaba.griver.device.adapter.Callback;
import com.alibaba.wireless.security.SecExceptionCode;

/* loaded from: classes6.dex */
public class AccelerometerForH5SensorService extends SensorService {

    /* renamed from: a  reason: collision with root package name */
    private Context f6529a;
    private float b;
    private int c;
    private int d;
    private Callback e;
    private long f;
    private float h;
    private float i;
    private float j;
    private boolean k;
    private int g = 0;
    private SensorEventListener l = new SensorEventListener() { // from class: com.alibaba.griver.device.sensor.AccelerometerForH5SensorService.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - AccelerometerForH5SensorService.this.f;
            if (((float) j) < AccelerometerForH5SensorService.this.b) {
                return;
            }
            AccelerometerForH5SensorService.this.f = currentTimeMillis;
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            float f4 = f - AccelerometerForH5SensorService.this.h;
            float f5 = f2 - AccelerometerForH5SensorService.this.i;
            float f6 = f3 - AccelerometerForH5SensorService.this.j;
            AccelerometerForH5SensorService.this.h = f;
            AccelerometerForH5SensorService.this.i = f2;
            AccelerometerForH5SensorService.this.j = f3;
            double sqrt = Math.sqrt((f4 * f4) + (f5 * f5) + (f6 * f6));
            double d = j;
            Double.isNaN(d);
            if ((sqrt / d) * 10000.0d < AccelerometerForH5SensorService.this.c) {
                return;
            }
            if (AccelerometerForH5SensorService.this.g >= AccelerometerForH5SensorService.this.d) {
                AccelerometerForH5SensorService.this.g = 0;
                AccelerometerForH5SensorService.this.unregister();
                AccelerometerForH5SensorService.this.e.onTrigger(null, 0);
                return;
            }
            AccelerometerForH5SensorService.access$608(AccelerometerForH5SensorService.this);
        }
    };

    static /* synthetic */ int access$608(AccelerometerForH5SensorService accelerometerForH5SensorService) {
        int i = accelerometerForH5SensorService.g;
        accelerometerForH5SensorService.g = i + 1;
        return i;
    }

    @Override // com.alibaba.griver.device.adapter.LifeCycle
    public void onCreate(Context context, JSONObject jSONObject) {
        this.f6529a = context;
        this.b = CommonUtils.getFloat(jSONObject, "interval", 100.0f);
        this.c = CommonUtils.getInt(jSONObject, "speedThreshold", SecExceptionCode.SEC_ERROR_OPENSDK);
        this.d = CommonUtils.getInt(jSONObject, "countsLimited", 2);
    }

    @Override // com.alibaba.griver.device.sensor.SensorService
    public void register(Callback callback) {
        if (this.k) {
            return;
        }
        this.k = true;
        this.e = callback;
        SensorManager sensorManager = (SensorManager) this.f6529a.getSystemService("sensor");
        sensorManager.registerListener(this.l, sensorManager.getDefaultSensor(1), 3);
    }

    @Override // com.alibaba.griver.device.sensor.SensorService
    public void unregister() {
        if (this.k) {
            this.k = false;
            ((SensorManager) this.f6529a.getSystemService("sensor")).unregisterListener(this.l);
        }
    }

    @Override // com.alibaba.griver.device.adapter.LifeCycle
    public void onDestroy() {
        this.f6529a = null;
        this.e = null;
        this.l = null;
    }
}
