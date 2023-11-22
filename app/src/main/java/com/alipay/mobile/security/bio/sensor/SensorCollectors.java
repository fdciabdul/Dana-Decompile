package com.alipay.mobile.security.bio.sensor;

import android.content.Context;
import android.hardware.SensorManager;
import id.dana.analytics.tracker.TrackerKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class SensorCollectors {
    private static final int MAX_SENSOR_ITEM_CNT = 100;
    SensorType[] allSensors = {SensorType.ACCELEROMETER, SensorType.MAGNETIC, SensorType.GYROSCOPE};
    private List<SensorCollectWorker> sensorCollectWorkers = new ArrayList();

    /* loaded from: classes7.dex */
    public enum SensorType {
        ACCELEROMETER(1, "Acceleration"),
        GYROSCOPE(4, TrackerKey.PassiveBioProperties.GYROSCOPE),
        MAGNETIC(2, "Magnetic");

        private String mSensorName;
        private int mSensorType;

        SensorType(int i, String str) {
            this.mSensorName = str;
            this.mSensorType = i;
        }

        public final String getSensorName() {
            return this.mSensorName;
        }

        public final int getmSensorType() {
            return this.mSensorType;
        }
    }

    public SensorCollectors(Context context) {
        reset(context);
    }

    public void reset(Context context) {
        if (context == null) {
            return;
        }
        try {
            this.sensorCollectWorkers.clear();
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            for (SensorType sensorType : this.allSensors) {
                this.sensorCollectWorkers.add(new SensorCollectWorker(sensorManager, sensorType, 100));
            }
        } catch (Exception unused) {
        }
    }

    public void startListening() {
        Iterator<SensorCollectWorker> it = this.sensorCollectWorkers.iterator();
        while (it.hasNext()) {
            it.next().start();
        }
    }

    public void destroy() {
        Iterator<SensorCollectWorker> it = this.sensorCollectWorkers.iterator();
        while (it.hasNext()) {
            it.next().destory();
        }
    }

    public SensorData getData() {
        SensorData sensorData = new SensorData();
        List<SensorCollectWorker> list = this.sensorCollectWorkers;
        if (list != null) {
            for (SensorCollectWorker sensorCollectWorker : list) {
                if (sensorCollectWorker != null) {
                    String resultData = sensorCollectWorker.getResultData();
                    if (sensorCollectWorker.getType() == 1) {
                        sensorData.accelermeter = resultData;
                    }
                    if (sensorCollectWorker.getType() == 2) {
                        sensorData.magmetic = resultData;
                    }
                    if (sensorCollectWorker.getType() == 4) {
                        sensorData.gyrometer = resultData;
                    }
                }
            }
        }
        return sensorData;
    }
}
