package com.appsflyer.internal;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x implements SensorEventListener {
    double AFKeystoreWrapper;
    private final String AFLogger$LogLevel;
    private final Executor AFVersionDeclaration;
    private final String getLevel;
    private final int init;
    long valueOf;
    private final int values;
    final float[][] AFInAppEventType = new float[2];
    final long[] AFInAppEventParameterName = new long[2];

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(Sensor sensor, Executor executor) {
        this.AFVersionDeclaration = executor;
        int type = sensor.getType();
        this.values = type;
        String name = sensor.getName();
        name = name == null ? "" : name;
        this.getLevel = name;
        String vendor = sensor.getVendor();
        String str = vendor != null ? vendor : "";
        this.AFLogger$LogLevel = str;
        this.init = ((((type + 31) * 31) + name.hashCode()) * 31) + str.hashCode();
    }

    private static List<Float> valueOf(float[] fArr) {
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f : fArr) {
            arrayList.add(Float.valueOf(f));
        }
        return arrayList;
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        final long j = sensorEvent.timestamp;
        final float[] fArr = sensorEvent.values;
        this.AFVersionDeclaration.execute(new Runnable() { // from class: com.appsflyer.internal.x.5
            @Override // java.lang.Runnable
            public final void run() {
                long currentTimeMillis = System.currentTimeMillis();
                float[] fArr2 = x.this.AFInAppEventType[0];
                if (fArr2 != null) {
                    float[] fArr3 = x.this.AFInAppEventType[1];
                    if (fArr3 == null) {
                        float[] fArr4 = fArr;
                        float[] copyOf = Arrays.copyOf(fArr4, fArr4.length);
                        x.this.AFInAppEventType[1] = copyOf;
                        x.this.AFInAppEventParameterName[1] = currentTimeMillis;
                        x.this.AFKeystoreWrapper = x.AFInAppEventParameterName(fArr2, copyOf);
                        return;
                    } else if (50000000 <= j - x.this.valueOf) {
                        x.this.valueOf = j;
                        if (Arrays.equals(fArr3, fArr)) {
                            x.this.AFInAppEventParameterName[1] = currentTimeMillis;
                            return;
                        }
                        double AFInAppEventParameterName = x.AFInAppEventParameterName(fArr2, fArr);
                        if (AFInAppEventParameterName > x.this.AFKeystoreWrapper) {
                            float[][] fArr5 = x.this.AFInAppEventType;
                            float[] fArr6 = fArr;
                            fArr5[1] = Arrays.copyOf(fArr6, fArr6.length);
                            x.this.AFInAppEventParameterName[1] = currentTimeMillis;
                            x.this.AFKeystoreWrapper = AFInAppEventParameterName;
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
                float[][] fArr7 = x.this.AFInAppEventType;
                float[] fArr8 = fArr;
                fArr7[0] = Arrays.copyOf(fArr8, fArr8.length);
                x.this.AFInAppEventParameterName[0] = currentTimeMillis;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void values(Map<x, Map<String, Object>> map, boolean z) {
        if (AFInAppEventType()) {
            map.put(this, AFKeystoreWrapper());
            if (z) {
                int length = this.AFInAppEventType.length;
                for (int i = 0; i < length; i++) {
                    this.AFInAppEventType[i] = null;
                }
                int length2 = this.AFInAppEventParameterName.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    this.AFInAppEventParameterName[i2] = 0;
                }
                this.AFKeystoreWrapper = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                this.valueOf = 0L;
            }
        } else if (!map.containsKey(this)) {
            map.put(this, AFKeystoreWrapper());
        }
    }

    private boolean AFInAppEventParameterName(int i, String str, String str2) {
        return this.values == i && this.getLevel.equals(str) && this.AFLogger$LogLevel.equals(str2);
    }

    private Map<String, Object> AFKeystoreWrapper() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(7);
        concurrentHashMap.put("sT", Integer.valueOf(this.values));
        concurrentHashMap.put("sN", this.getLevel);
        concurrentHashMap.put("sV", this.AFLogger$LogLevel);
        float[] fArr = this.AFInAppEventType[0];
        if (fArr != null) {
            concurrentHashMap.put("sVS", valueOf(fArr));
        }
        float[] fArr2 = this.AFInAppEventType[1];
        if (fArr2 != null) {
            concurrentHashMap.put("sVE", valueOf(fArr2));
        }
        return concurrentHashMap;
    }

    private boolean AFInAppEventType() {
        return this.AFInAppEventType[0] != null;
    }

    public final int hashCode() {
        return this.init;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof x) {
            x xVar = (x) obj;
            return AFInAppEventParameterName(xVar.values, xVar.getLevel, xVar.AFLogger$LogLevel);
        }
        return false;
    }

    static /* synthetic */ double AFInAppEventParameterName(float[] fArr, float[] fArr2) {
        int min = Math.min(fArr.length, fArr2.length);
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < min; i++) {
            d += StrictMath.pow(fArr[i] - fArr2[i], 2.0d);
        }
        return Math.sqrt(d);
    }
}
