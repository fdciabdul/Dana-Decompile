package com.alibaba.griver.bluetooth.altbeacon.beacon.distance;

import com.alibaba.griver.bluetooth.altbeacon.beacon.logging.LogManager;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class CurveFittedDistanceCalculator implements DistanceCalculator {
    public static final String TAG = "CurveFittedDistanceCalculator";
    private double mCoefficient1;
    private double mCoefficient2;
    private double mCoefficient3;

    public CurveFittedDistanceCalculator(double d, double d2, double d3) {
        this.mCoefficient1 = d;
        this.mCoefficient2 = d2;
        this.mCoefficient3 = d3;
    }

    @Override // com.alibaba.griver.bluetooth.altbeacon.beacon.distance.DistanceCalculator
    public double calculateDistance(int i, double d) {
        double pow;
        if (d == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return -1.0d;
        }
        LogManager.d(TAG, "calculating distance based on mRssi of %s and txPower of %s", Double.valueOf(d), Integer.valueOf(i));
        double d2 = i;
        Double.isNaN(d2);
        double d3 = (d * 1.0d) / d2;
        if (d3 < 1.0d) {
            pow = Math.pow(d3, 10.0d);
        } else {
            pow = (this.mCoefficient1 * Math.pow(d3, this.mCoefficient2)) + this.mCoefficient3;
        }
        LogManager.d(TAG, "avg mRssi: %s distance: %s", Double.valueOf(d), Double.valueOf(pow));
        return pow;
    }
}
