package com.alibaba.griver.bluetooth.altbeacon.beacon;

/* loaded from: classes6.dex */
public interface MonitorNotifier {
    public static final int INSIDE = 1;
    public static final int OUTSIDE = 0;

    void didDetermineStateForRegion(int i, Region region);

    void didEnterRegion(Region region);

    void didExitRegion(Region region);
}
