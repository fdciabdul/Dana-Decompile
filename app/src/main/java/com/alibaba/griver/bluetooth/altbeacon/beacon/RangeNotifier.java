package com.alibaba.griver.bluetooth.altbeacon.beacon;

import java.util.Collection;

/* loaded from: classes6.dex */
public interface RangeNotifier {
    void didRangeBeaconsInRegion(Collection<Beacon> collection, Region region);
}
