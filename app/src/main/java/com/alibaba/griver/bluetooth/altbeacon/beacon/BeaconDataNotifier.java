package com.alibaba.griver.bluetooth.altbeacon.beacon;

import com.alibaba.griver.bluetooth.altbeacon.beacon.client.DataProviderException;

/* loaded from: classes6.dex */
public interface BeaconDataNotifier {
    void beaconDataUpdate(Beacon beacon, BeaconData beaconData, DataProviderException dataProviderException);
}
