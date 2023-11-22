package com.alibaba.griver.bluetooth.ibeacon;

import java.util.List;

/* loaded from: classes2.dex */
public interface MyBeaconListener {
    void onBeaconServiceChange(boolean z, boolean z2);

    void onBeaconUpdate(List<MyBeacon> list);
}
