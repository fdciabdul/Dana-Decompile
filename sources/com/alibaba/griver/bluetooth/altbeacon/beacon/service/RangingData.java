package com.alibaba.griver.bluetooth.altbeacon.beacon.service;

import android.os.Bundle;
import com.alibaba.griver.bluetooth.altbeacon.beacon.Beacon;
import com.alibaba.griver.bluetooth.altbeacon.beacon.Region;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class RangingData {
    private static final String BEACONS_KEY = "beacons";
    private static final String REGION_KEY = "region";
    private static final String TAG = "RangingData";
    private final Collection<Beacon> mBeacons;
    private final Region mRegion;

    public RangingData(Collection<Beacon> collection, Region region) {
        synchronized (collection) {
            this.mBeacons = collection;
        }
        this.mRegion = region;
    }

    public static RangingData fromBundle(Bundle bundle) {
        bundle.setClassLoader(Region.class.getClassLoader());
        return new RangingData(bundle.get(BEACONS_KEY) != null ? (Collection) bundle.getSerializable(BEACONS_KEY) : null, bundle.get("region") != null ? (Region) bundle.getSerializable("region") : null);
    }

    public Collection<Beacon> getBeacons() {
        return this.mBeacons;
    }

    public Region getRegion() {
        return this.mRegion;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("region", this.mRegion);
        ArrayList arrayList = new ArrayList();
        Iterator<Beacon> it = this.mBeacons.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        bundle.putSerializable(BEACONS_KEY, arrayList);
        return bundle;
    }
}
