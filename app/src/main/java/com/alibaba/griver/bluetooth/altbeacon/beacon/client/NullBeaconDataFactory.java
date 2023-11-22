package com.alibaba.griver.bluetooth.altbeacon.beacon.client;

import android.os.Handler;
import com.alibaba.griver.bluetooth.altbeacon.beacon.Beacon;
import com.alibaba.griver.bluetooth.altbeacon.beacon.BeaconDataNotifier;

/* loaded from: classes6.dex */
public class NullBeaconDataFactory implements BeaconDataFactory {
    @Override // com.alibaba.griver.bluetooth.altbeacon.beacon.client.BeaconDataFactory
    public void requestBeaconData(Beacon beacon, final BeaconDataNotifier beaconDataNotifier) {
        new Handler().post(new Runnable() { // from class: com.alibaba.griver.bluetooth.altbeacon.beacon.client.NullBeaconDataFactory.1
            @Override // java.lang.Runnable
            public void run() {
                beaconDataNotifier.beaconDataUpdate(null, null, new DataProviderException("You need to configure a beacon data service to use this feature."));
            }
        });
    }
}
