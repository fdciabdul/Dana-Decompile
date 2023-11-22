package com.alibaba.griver.bluetooth.altbeacon.beacon.service;

/* loaded from: classes6.dex */
public interface RssiFilter {
    void addMeasurement(Integer num);

    double calculateRssi();

    boolean noMeasurementsAvailable();
}
