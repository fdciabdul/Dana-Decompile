package com.alibaba.griver.bluetooth.altbeacon.beacon.service;

import com.alibaba.griver.bluetooth.altbeacon.beacon.logging.LogManager;

/* loaded from: classes6.dex */
public class ArmaRssiFilter implements RssiFilter {
    private static double DEFAULT_ARMA_SPEED = 0.1d;
    private static final String TAG = "ArmaRssiFilter";
    private int armaMeasurement;
    private boolean isInitialized = false;
    private double armaSpeed = DEFAULT_ARMA_SPEED;

    @Override // com.alibaba.griver.bluetooth.altbeacon.beacon.service.RssiFilter
    public boolean noMeasurementsAvailable() {
        return false;
    }

    public static void setDEFAULT_ARMA_SPEED(double d) {
        DEFAULT_ARMA_SPEED = d;
    }

    @Override // com.alibaba.griver.bluetooth.altbeacon.beacon.service.RssiFilter
    public void addMeasurement(Integer num) {
        LogManager.d(TAG, "adding rssi: %s", num);
        if (!this.isInitialized) {
            this.armaMeasurement = num.intValue();
            this.isInitialized = true;
        }
        int i = this.armaMeasurement;
        double d = i;
        double d2 = this.armaSpeed;
        double intValue = i - num.intValue();
        Double.isNaN(intValue);
        Double.isNaN(d);
        int intValue2 = Double.valueOf(d - (d2 * intValue)).intValue();
        this.armaMeasurement = intValue2;
        LogManager.d(TAG, "armaMeasurement: %s", Integer.valueOf(intValue2));
    }

    @Override // com.alibaba.griver.bluetooth.altbeacon.beacon.service.RssiFilter
    public double calculateRssi() {
        return this.armaMeasurement;
    }
}
