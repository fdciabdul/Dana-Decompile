package com.alibaba.griver.bluetooth.altbeacon.beacon.simulator;

import com.alibaba.griver.bluetooth.altbeacon.beacon.Beacon;
import java.util.List;

/* loaded from: classes6.dex */
public class StaticBeaconSimulator implements BeaconSimulator {
    public List<Beacon> beacons = null;

    @Override // com.alibaba.griver.bluetooth.altbeacon.beacon.simulator.BeaconSimulator
    public List<Beacon> getBeacons() {
        return this.beacons;
    }

    public void setBeacons(List<Beacon> list) {
        this.beacons = list;
    }
}
