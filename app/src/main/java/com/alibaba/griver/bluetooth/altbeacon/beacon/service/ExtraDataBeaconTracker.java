package com.alibaba.griver.bluetooth.altbeacon.beacon.service;

import com.alibaba.griver.bluetooth.altbeacon.beacon.Beacon;
import java.io.Serializable;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class ExtraDataBeaconTracker implements Serializable {
    private static final String TAG = "BeaconTracker";
    private HashMap<String, HashMap<Integer, Beacon>> mBeaconsByKey;
    private boolean matchBeaconsByServiceUUID;

    public ExtraDataBeaconTracker() {
        this.mBeaconsByKey = new HashMap<>();
        this.matchBeaconsByServiceUUID = true;
    }

    public ExtraDataBeaconTracker(boolean z) {
        this.mBeaconsByKey = new HashMap<>();
        this.matchBeaconsByServiceUUID = z;
    }

    public Beacon track(Beacon beacon) {
        synchronized (this) {
            if (beacon.isMultiFrameBeacon() || beacon.getServiceUuid() != -1) {
                beacon = trackGattBeacon(beacon);
            }
        }
        return beacon;
    }

    private Beacon trackGattBeacon(Beacon beacon) {
        HashMap<Integer, Beacon> hashMap = this.mBeaconsByKey.get(getBeaconKey(beacon));
        Beacon beacon2 = null;
        if (hashMap != null) {
            for (Beacon beacon3 : hashMap.values()) {
                if (beacon.isExtraBeaconData()) {
                    beacon3.setRssi(beacon.getRssi());
                    beacon3.setExtraDataFields(beacon.getDataFields());
                } else {
                    beacon.setExtraDataFields(beacon3.getExtraDataFields());
                    beacon2 = beacon;
                }
            }
        }
        if (!beacon.isExtraBeaconData()) {
            updateTrackingHashes(beacon, hashMap);
        }
        return (beacon2 != null || beacon.isExtraBeaconData()) ? beacon2 : beacon;
    }

    private void updateTrackingHashes(Beacon beacon, HashMap<Integer, Beacon> hashMap) {
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        hashMap.put(Integer.valueOf(beacon.hashCode()), beacon);
        this.mBeaconsByKey.put(getBeaconKey(beacon), hashMap);
    }

    private String getBeaconKey(Beacon beacon) {
        if (this.matchBeaconsByServiceUUID) {
            StringBuilder sb = new StringBuilder();
            sb.append(beacon.getBluetoothAddress());
            sb.append(beacon.getServiceUuid());
            return sb.toString();
        }
        return beacon.getBluetoothAddress();
    }
}
