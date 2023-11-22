package com.alibaba.griver.bluetooth.altbeacon.beacon.service;

import android.os.Bundle;
import com.alibaba.griver.bluetooth.altbeacon.beacon.Region;

/* loaded from: classes6.dex */
public class MonitoringData {
    private static final String INSIDE_KEY = "inside";
    private static final String REGION_KEY = "region";
    private static final String TAG = "MonitoringData";
    private final boolean mInside;
    private final Region mRegion;

    public MonitoringData(boolean z, Region region) {
        this.mInside = z;
        this.mRegion = region;
    }

    public static MonitoringData fromBundle(Bundle bundle) {
        bundle.setClassLoader(Region.class.getClassLoader());
        return new MonitoringData(bundle.getBoolean(INSIDE_KEY), bundle.get("region") != null ? (Region) bundle.getSerializable("region") : null);
    }

    public boolean isInside() {
        return this.mInside;
    }

    public Region getRegion() {
        return this.mRegion;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("region", this.mRegion);
        bundle.putBoolean(INSIDE_KEY, this.mInside);
        return bundle;
    }
}
