package com.alibaba.griver.bluetooth.ibeacon;

/* loaded from: classes2.dex */
public interface MyBeaconService {
    BeaconResult getBeacons();

    void onCreate();

    void onDestroy();

    void setMyBeaconListener(MyBeaconListener myBeaconListener);

    BeaconResult startBeaconDiscovery(String[] strArr);

    BeaconResult stopBeaconDiscovery();
}
