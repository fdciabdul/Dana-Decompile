package com.alibaba.griver.bluetooth.altbeacon.beacon.service;

import android.content.Context;
import android.os.Bundle;
import com.alibaba.griver.bluetooth.altbeacon.beacon.Beacon;
import com.alibaba.griver.bluetooth.altbeacon.beacon.BeaconManager;
import com.alibaba.griver.bluetooth.altbeacon.beacon.BeaconParser;
import com.alibaba.griver.bluetooth.altbeacon.beacon.Region;
import com.alibaba.griver.bluetooth.altbeacon.beacon.logging.LogManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class SettingsData implements Serializable {
    private static final String SETTINGS_DATA_KEY = "SettingsData";
    private static final String TAG = "SettingsData";
    Boolean mAndroidLScanningDisabled;
    ArrayList<BeaconParser> mBeaconParsers;
    Boolean mHardwareEqualityEnforced;
    Long mRegionExitPeriod;
    Boolean mRegionStatePersistenceEnabled;
    Boolean mUseTrackingCache;

    public static SettingsData fromBundle(Bundle bundle) {
        bundle.setClassLoader(Region.class.getClassLoader());
        if (bundle.get("SettingsData") != null) {
            return (SettingsData) bundle.getSerializable("SettingsData");
        }
        return null;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("SettingsData", this);
        return bundle;
    }

    public void apply(BeaconService beaconService) {
        String str = TAG;
        LogManager.d(str, "Applying settings changes to scanner in other process", new Object[0]);
        BeaconManager instanceForApplication = BeaconManager.getInstanceForApplication(beaconService.getContext());
        List<BeaconParser> beaconParsers = instanceForApplication.getBeaconParsers();
        boolean z = true;
        if (beaconParsers.size() == this.mBeaconParsers.size()) {
            int i = 0;
            while (true) {
                if (i >= beaconParsers.size()) {
                    z = false;
                    break;
                } else if (!beaconParsers.get(i).equals(this.mBeaconParsers.get(i))) {
                    String str2 = TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Beacon parsers have changed to: ");
                    sb.append(this.mBeaconParsers.get(i).getLayout());
                    LogManager.d(str2, sb.toString(), new Object[0]);
                    break;
                } else {
                    i++;
                }
            }
        } else {
            LogManager.d(str, "Beacon parsers have been added or removed.", new Object[0]);
        }
        if (z) {
            LogManager.d(TAG, "Updating beacon parsers", new Object[0]);
            instanceForApplication.getBeaconParsers().clear();
            instanceForApplication.getBeaconParsers().addAll(this.mBeaconParsers);
            beaconService.reloadParsers();
        } else {
            LogManager.d(TAG, "Beacon parsers unchanged.", new Object[0]);
        }
        MonitoringStatus instanceForApplication2 = MonitoringStatus.getInstanceForApplication(beaconService.getContext());
        if (instanceForApplication2.isStatePreservationOn() && !this.mRegionStatePersistenceEnabled.booleanValue()) {
            instanceForApplication2.stopStatusPreservation();
        } else if (!instanceForApplication2.isStatePreservationOn() && this.mRegionStatePersistenceEnabled.booleanValue()) {
            instanceForApplication2.startStatusPreservation();
        }
        BeaconManager.setAndroidLScanningDisabled(this.mAndroidLScanningDisabled.booleanValue());
        BeaconManager.setRegionExitPeriod(this.mRegionExitPeriod.longValue());
        RangeState.setUseTrackingCache(this.mUseTrackingCache.booleanValue());
        Beacon.setHardwareEqualityEnforced(this.mHardwareEqualityEnforced.booleanValue());
    }

    public SettingsData collect(Context context) {
        BeaconManager instanceForApplication = BeaconManager.getInstanceForApplication(context);
        this.mBeaconParsers = new ArrayList<>(instanceForApplication.getBeaconParsers());
        this.mRegionStatePersistenceEnabled = Boolean.valueOf(instanceForApplication.isRegionStatePersistenceEnabled());
        this.mAndroidLScanningDisabled = Boolean.valueOf(BeaconManager.isAndroidLScanningDisabled());
        this.mRegionExitPeriod = Long.valueOf(BeaconManager.getRegionExitPeriod());
        this.mUseTrackingCache = Boolean.valueOf(RangeState.getUseTrackingCache());
        this.mHardwareEqualityEnforced = Boolean.valueOf(Beacon.getHardwareEqualityEnforced());
        return this;
    }
}
