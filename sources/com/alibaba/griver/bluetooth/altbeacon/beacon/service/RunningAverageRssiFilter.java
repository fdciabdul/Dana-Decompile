package com.alibaba.griver.bluetooth.altbeacon.beacon.service;

import android.os.SystemClock;
import com.alibaba.griver.bluetooth.altbeacon.beacon.logging.LogManager;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class RunningAverageRssiFilter implements RssiFilter {
    public static final long DEFAULT_SAMPLE_EXPIRATION_MILLISECONDS = 20000;
    private static final String TAG = "RunningAverageRssiFilter";
    private static long sampleExpirationMilliseconds = 20000;
    private ArrayList<Measurement> mMeasurements = new ArrayList<>();

    public static void setSampleExpirationMilliseconds(long j) {
        sampleExpirationMilliseconds = j;
    }

    @Override // com.alibaba.griver.bluetooth.altbeacon.beacon.service.RssiFilter
    public void addMeasurement(Integer num) {
        Measurement measurement = new Measurement();
        measurement.rssi = num;
        measurement.timestamp = SystemClock.elapsedRealtime();
        this.mMeasurements.add(measurement);
    }

    @Override // com.alibaba.griver.bluetooth.altbeacon.beacon.service.RssiFilter
    public boolean noMeasurementsAvailable() {
        return this.mMeasurements.size() == 0;
    }

    @Override // com.alibaba.griver.bluetooth.altbeacon.beacon.service.RssiFilter
    public double calculateRssi() {
        int i;
        refreshMeasurements();
        int size = this.mMeasurements.size();
        int i2 = size - 1;
        if (size > 2) {
            int i3 = size / 10;
            i = i3 + 1;
            i2 = (size - i3) - 2;
        } else {
            i = 0;
        }
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i4 = i; i4 <= i2; i4++) {
            double intValue = this.mMeasurements.get(i4).rssi.intValue();
            Double.isNaN(intValue);
            d += intValue;
        }
        double d2 = (i2 - i) + 1;
        Double.isNaN(d2);
        double d3 = d / d2;
        LogManager.d(TAG, "Running average mRssi based on %s measurements: %s", Integer.valueOf(size), Double.valueOf(d3));
        return d3;
    }

    private void refreshMeasurements() {
        synchronized (this) {
            ArrayList<Measurement> arrayList = new ArrayList<>();
            Iterator<Measurement> it = this.mMeasurements.iterator();
            while (it.hasNext()) {
                Measurement next = it.next();
                if (SystemClock.elapsedRealtime() - next.timestamp < sampleExpirationMilliseconds) {
                    arrayList.add(next);
                }
            }
            this.mMeasurements = arrayList;
            Collections.sort(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class Measurement implements Comparable<Measurement> {
        Integer rssi;
        long timestamp;

        private Measurement() {
        }

        @Override // java.lang.Comparable
        public int compareTo(Measurement measurement) {
            return this.rssi.compareTo(measurement.rssi);
        }
    }
}
