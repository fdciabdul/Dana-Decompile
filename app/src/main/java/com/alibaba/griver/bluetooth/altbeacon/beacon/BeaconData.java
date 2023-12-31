package com.alibaba.griver.bluetooth.altbeacon.beacon;

/* loaded from: classes6.dex */
public interface BeaconData {
    String get(String str);

    Double getLatitude();

    Double getLongitude();

    boolean isDirty();

    void set(String str, String str2);

    void setLatitude(Double d);

    void setLongitude(Double d);

    void sync(BeaconDataNotifier beaconDataNotifier);
}
