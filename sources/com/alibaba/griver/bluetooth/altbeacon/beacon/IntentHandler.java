package com.alibaba.griver.bluetooth.altbeacon.beacon;

import android.content.Context;
import android.content.Intent;
import com.alibaba.griver.bluetooth.altbeacon.beacon.logging.LogManager;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.MonitoringData;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.MonitoringStatus;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RangingData;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes6.dex */
class IntentHandler {
    private static final String TAG = "IntentHandler";

    public void convertIntentsToCallbacks(Context context, Intent intent) {
        MonitoringData monitoringData;
        RangingData rangingData = null;
        if (intent == null || intent.getExtras() == null) {
            monitoringData = null;
        } else {
            monitoringData = intent.getExtras().getBundle("monitoringData") != null ? MonitoringData.fromBundle(intent.getExtras().getBundle("monitoringData")) : null;
            if (intent.getExtras().getBundle("rangingData") != null) {
                rangingData = RangingData.fromBundle(intent.getExtras().getBundle("rangingData"));
            }
        }
        if (rangingData != null) {
            String str = TAG;
            LogManager.d(str, "got ranging data", new Object[0]);
            if (rangingData.getBeacons() == null) {
                LogManager.w(str, "Ranging data has a null beacons collection", new Object[0]);
            }
            Set<RangeNotifier> rangingNotifiers = BeaconManager.getInstanceForApplication(context).getRangingNotifiers();
            Collection<Beacon> beacons = rangingData.getBeacons();
            if (rangingNotifiers != null) {
                Iterator<RangeNotifier> it = rangingNotifiers.iterator();
                while (it.hasNext()) {
                    it.next().didRangeBeaconsInRegion(beacons, rangingData.getRegion());
                }
            } else {
                LogManager.d(str, "but ranging notifier is null, so we're dropping it.", new Object[0]);
            }
            RangeNotifier dataRequestNotifier = BeaconManager.getInstanceForApplication(context).getDataRequestNotifier();
            if (dataRequestNotifier != null) {
                dataRequestNotifier.didRangeBeaconsInRegion(beacons, rangingData.getRegion());
            }
        }
        if (monitoringData != null) {
            LogManager.d(TAG, "got monitoring data", new Object[0]);
            Set<MonitorNotifier> monitoringNotifiers = BeaconManager.getInstanceForApplication(context).getMonitoringNotifiers();
            if (monitoringNotifiers != null) {
                for (MonitorNotifier monitorNotifier : monitoringNotifiers) {
                    LogManager.d(TAG, "Calling monitoring notifier: %s", monitorNotifier);
                    Region region = monitoringData.getRegion();
                    Integer valueOf = Integer.valueOf(monitoringData.isInside() ? 1 : 0);
                    monitorNotifier.didDetermineStateForRegion(valueOf.intValue(), region);
                    MonitoringStatus.getInstanceForApplication(context).updateLocalState(region, valueOf);
                    if (monitoringData.isInside()) {
                        monitorNotifier.didEnterRegion(monitoringData.getRegion());
                    } else {
                        monitorNotifier.didExitRegion(monitoringData.getRegion());
                    }
                }
            }
        }
    }
}
