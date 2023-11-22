package com.alibaba.griver.bluetooth.altbeacon.beacon.service;

import android.content.Context;
import com.alibaba.griver.bluetooth.altbeacon.beacon.Beacon;
import com.alibaba.griver.bluetooth.altbeacon.beacon.Region;
import com.alibaba.griver.bluetooth.altbeacon.beacon.logging.LogManager;
import id.dana.data.deeplink.DeepLinkPayloadManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public class MonitoringStatus {
    private static final int MAX_REGIONS_FOR_STATUS_PRESERVATION = 50;
    private static final int MAX_STATUS_PRESERVATION_FILE_AGE_TO_RESTORE_SECS = 900;
    private static final Object SINGLETON_LOCK = new Object();
    public static final String STATUS_PRESERVATION_FILE_NAME = "org.com.alibaba.griver.bluetooth.altbeacon.beacon.service.monitoring_status_state";
    private static final String TAG = "MonitoringStatus";
    private static volatile MonitoringStatus sInstance;
    private Context mContext;
    private Map<Region, RegionMonitoringState> mRegionsStatesMap;
    private boolean mStatePreservationIsOn = true;

    public MonitoringStatus(Context context) {
        this.mContext = context;
    }

    public static MonitoringStatus getInstanceForApplication(Context context) {
        MonitoringStatus monitoringStatus;
        MonitoringStatus monitoringStatus2 = sInstance;
        if (monitoringStatus2 == null) {
            synchronized (SINGLETON_LOCK) {
                monitoringStatus = sInstance;
                if (monitoringStatus == null) {
                    monitoringStatus = new MonitoringStatus(context.getApplicationContext());
                    sInstance = monitoringStatus;
                }
            }
            return monitoringStatus;
        }
        return monitoringStatus2;
    }

    public void addRegion(Region region, Callback callback) {
        synchronized (this) {
            addLocalRegion(region, callback);
            saveMonitoringStatusIfOn();
        }
    }

    public void removeRegion(Region region) {
        synchronized (this) {
            removeLocalRegion(region);
            saveMonitoringStatusIfOn();
        }
    }

    public Set<Region> regions() {
        Set<Region> keySet;
        synchronized (this) {
            keySet = getRegionsStateMap().keySet();
        }
        return keySet;
    }

    public int regionsCount() {
        int size;
        synchronized (this) {
            size = regions().size();
        }
        return size;
    }

    public RegionMonitoringState stateOf(Region region) {
        RegionMonitoringState regionMonitoringState;
        synchronized (this) {
            regionMonitoringState = getRegionsStateMap().get(region);
        }
        return regionMonitoringState;
    }

    public void updateNewlyOutside() {
        synchronized (this) {
            boolean z = false;
            for (Region region : regions()) {
                RegionMonitoringState stateOf = stateOf(region);
                if (stateOf.markOutsideIfExpired()) {
                    LogManager.d(TAG, "found a monitor that expired: %s", region);
                    stateOf.getCallback().call(this.mContext, "monitoringData", new MonitoringData(stateOf.getInside(), region).toBundle());
                    z = true;
                }
            }
            if (z) {
                saveMonitoringStatusIfOn();
            } else {
                updateMonitoringStatusTime(System.currentTimeMillis());
            }
        }
    }

    public void updateNewlyInsideInRegionsContaining(Beacon beacon) {
        synchronized (this) {
            boolean z = false;
            for (Region region : regionsMatchingTo(beacon)) {
                RegionMonitoringState regionMonitoringState = getRegionsStateMap().get(region);
                if (regionMonitoringState != null && regionMonitoringState.markInside()) {
                    z = true;
                    regionMonitoringState.getCallback().call(this.mContext, "monitoringData", new MonitoringData(regionMonitoringState.getInside(), region).toBundle());
                }
            }
            if (z) {
                saveMonitoringStatusIfOn();
            } else {
                updateMonitoringStatusTime(System.currentTimeMillis());
            }
        }
    }

    private Map<Region, RegionMonitoringState> getRegionsStateMap() {
        if (this.mRegionsStatesMap == null) {
            restoreOrInitializeMonitoringStatus();
        }
        return this.mRegionsStatesMap;
    }

    private void restoreOrInitializeMonitoringStatus() {
        long currentTimeMillis = System.currentTimeMillis() - getLastMonitoringStatusUpdateTime();
        this.mRegionsStatesMap = new HashMap();
        if (!this.mStatePreservationIsOn) {
            LogManager.d(TAG, "Not restoring monitoring state because persistence is disabled", new Object[0]);
        } else if (currentTimeMillis > DeepLinkPayloadManager.RESET_PAYLOAD_BACKUP_DELAY) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Not restoring monitoring state because it was recorded too many milliseconds ago: ");
            sb.append(currentTimeMillis);
            LogManager.d(str, sb.toString(), new Object[0]);
        } else {
            restoreMonitoringStatus();
            LogManager.d(TAG, "Done restoring monitoring status", new Object[0]);
        }
    }

    private List<Region> regionsMatchingTo(Beacon beacon) {
        ArrayList arrayList = new ArrayList();
        for (Region region : regions()) {
            if (region.matchesBeacon(beacon)) {
                arrayList.add(region);
            } else {
                LogManager.d(TAG, "This region (%s) does not match beacon: %s", region, beacon);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void saveMonitoringStatusIfOn() {
        /*
            Method dump skipped, instructions count: 193
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.bluetooth.altbeacon.beacon.service.MonitoringStatus.saveMonitoringStatusIfOn():void");
    }

    protected void updateMonitoringStatusTime(long j) {
        this.mContext.getFileStreamPath(STATUS_PRESERVATION_FILE_NAME).setLastModified(j);
    }

    protected long getLastMonitoringStatusUpdateTime() {
        return this.mContext.getFileStreamPath(STATUS_PRESERVATION_FILE_NAME).lastModified();
    }

    /*  JADX ERROR: Type inference failed with exception
        java.lang.NullPointerException
        */
    /* JADX WARN: Failed to calculate best type for var: r2v0 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v13 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v3 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v4 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r4v10 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r4v12 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r4v13 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r4v5 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0118: MOVE (r11 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:60:0x0118 */
    protected void restoreMonitoringStatus() {
        /*
            Method dump skipped, instructions count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.bluetooth.altbeacon.beacon.service.MonitoringStatus.restoreMonitoringStatus():void");
    }

    public void stopStatusPreservation() {
        synchronized (this) {
            this.mContext.deleteFile(STATUS_PRESERVATION_FILE_NAME);
            this.mStatePreservationIsOn = false;
        }
    }

    public void startStatusPreservation() {
        synchronized (this) {
            if (!this.mStatePreservationIsOn) {
                this.mStatePreservationIsOn = true;
                saveMonitoringStatusIfOn();
            }
        }
    }

    public boolean isStatePreservationOn() {
        return this.mStatePreservationIsOn;
    }

    public void clear() {
        synchronized (this) {
            this.mContext.deleteFile(STATUS_PRESERVATION_FILE_NAME);
            getRegionsStateMap().clear();
        }
    }

    public void updateLocalState(Region region, Integer num) {
        RegionMonitoringState regionMonitoringState = getRegionsStateMap().get(region);
        if (regionMonitoringState == null) {
            regionMonitoringState = addLocalRegion(region);
        }
        if (num != null) {
            if (num.intValue() == 0) {
                regionMonitoringState.markOutside();
            }
            if (num.intValue() == 1) {
                regionMonitoringState.markInside();
            }
        }
    }

    public void removeLocalRegion(Region region) {
        getRegionsStateMap().remove(region);
    }

    public RegionMonitoringState addLocalRegion(Region region) {
        return addLocalRegion(region, new Callback(null));
    }

    private RegionMonitoringState addLocalRegion(Region region, Callback callback) {
        if (getRegionsStateMap().containsKey(region)) {
            Iterator<Region> it = getRegionsStateMap().keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Region next = it.next();
                if (next.equals(region)) {
                    if (next.hasSameIdentifiers(region)) {
                        return getRegionsStateMap().get(next);
                    }
                    String str = TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Replacing region with unique identifier ");
                    sb.append(region.getUniqueId());
                    LogManager.d(str, sb.toString(), new Object[0]);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Old definition: ");
                    sb2.append(next);
                    LogManager.d(str, sb2.toString(), new Object[0]);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("New definition: ");
                    sb3.append(region);
                    LogManager.d(str, sb3.toString(), new Object[0]);
                    LogManager.d(str, "clearing state", new Object[0]);
                    getRegionsStateMap().remove(region);
                }
            }
        }
        RegionMonitoringState regionMonitoringState = new RegionMonitoringState(callback);
        getRegionsStateMap().put(region, regionMonitoringState);
        return regionMonitoringState;
    }
}
