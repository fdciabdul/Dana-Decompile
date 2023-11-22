package com.alibaba.griver.bluetooth.altbeacon.beacon.service;

import android.content.Context;
import com.alibaba.griver.bluetooth.altbeacon.beacon.BeaconManager;
import com.alibaba.griver.bluetooth.altbeacon.beacon.BeaconParser;
import com.alibaba.griver.bluetooth.altbeacon.beacon.Region;
import com.alibaba.griver.bluetooth.altbeacon.beacon.logging.LogManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public class ScanState implements Serializable {
    public static int MIN_SCAN_JOB_INTERVAL_MILLIS = 300000;
    private static final String STATUS_PRESERVATION_FILE_NAME = "android-beacon-library-scan-state";
    private static final String TAG = "ScanState";
    private static final String TEMP_STATUS_PRESERVATION_FILE_NAME = "android-beacon-library-scan-state-temp";
    private long mBackgroundBetweenScanPeriod;
    private boolean mBackgroundMode;
    private long mBackgroundScanPeriod;
    private transient Context mContext;
    private long mForegroundBetweenScanPeriod;
    private long mForegroundScanPeriod;
    private transient MonitoringStatus mMonitoringStatus;
    private Map<Region, RangeState> mRangedRegionState = new HashMap();
    private Set<BeaconParser> mBeaconParsers = new HashSet();
    private ExtraDataBeaconTracker mExtraBeaconDataTracker = new ExtraDataBeaconTracker();
    private long mLastScanStartTimeMillis = 0;

    public ScanState(Context context) {
        this.mContext = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0127 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0138 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:? A[Catch: all -> 0x012b, SYNTHETIC, TRY_LEAVE, TryCatch #5 {, blocks: (B:10:0x001a, B:13:0x0027, B:15:0x002c, B:77:0x00d4, B:78:0x00d9, B:80:0x00dd, B:81:0x00e4, B:12:0x001e, B:55:0x0087, B:59:0x0096, B:61:0x009a, B:57:0x008b, B:69:0x00b6, B:73:0x00c5, B:75:0x00c9, B:71:0x00ba, B:86:0x0127, B:92:0x0138, B:95:0x0145, B:94:0x013c, B:90:0x012d), top: B:106:0x0005, inners: #0, #7, #8, #9, #16, #17, #22, #27 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x006d A[Catch: all -> 0x00a4, TRY_ENTER, TryCatch #2 {all -> 0x00a4, blocks: (B:7:0x0010, B:8:0x0016, B:52:0x006d, B:53:0x0077), top: B:105:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0077 A[Catch: all -> 0x00a4, TRY_LEAVE, TryCatch #2 {all -> 0x00a4, blocks: (B:7:0x0010, B:8:0x0016, B:52:0x006d, B:53:0x0077), top: B:105:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d4 A[Catch: all -> 0x012b, TryCatch #5 {, blocks: (B:10:0x001a, B:13:0x0027, B:15:0x002c, B:77:0x00d4, B:78:0x00d9, B:80:0x00dd, B:81:0x00e4, B:12:0x001e, B:55:0x0087, B:59:0x0096, B:61:0x009a, B:57:0x008b, B:69:0x00b6, B:73:0x00c5, B:75:0x00c9, B:71:0x00ba, B:86:0x0127, B:92:0x0138, B:95:0x0145, B:94:0x013c, B:90:0x012d), top: B:106:0x0005, inners: #0, #7, #8, #9, #16, #17, #22, #27 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dd A[Catch: all -> 0x012b, TryCatch #5 {, blocks: (B:10:0x001a, B:13:0x0027, B:15:0x002c, B:77:0x00d4, B:78:0x00d9, B:80:0x00dd, B:81:0x00e4, B:12:0x001e, B:55:0x0087, B:59:0x0096, B:61:0x009a, B:57:0x008b, B:69:0x00b6, B:73:0x00c5, B:75:0x00c9, B:71:0x00ba, B:86:0x0127, B:92:0x0138, B:95:0x0145, B:94:0x013c, B:90:0x012d), top: B:106:0x0005, inners: #0, #7, #8, #9, #16, #17, #22, #27 }] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v14, types: [java.io.ObjectInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.alibaba.griver.bluetooth.altbeacon.beacon.service.ScanState restore(android.content.Context r10) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.bluetooth.altbeacon.beacon.service.ScanState.restore(android.content.Context):com.alibaba.griver.bluetooth.altbeacon.beacon.service.ScanState");
    }

    public Boolean getBackgroundMode() {
        return Boolean.valueOf(this.mBackgroundMode);
    }

    public void setBackgroundMode(Boolean bool) {
        this.mBackgroundMode = bool.booleanValue();
    }

    public Long getBackgroundBetweenScanPeriod() {
        return Long.valueOf(this.mBackgroundBetweenScanPeriod);
    }

    public void setBackgroundBetweenScanPeriod(Long l) {
        this.mBackgroundBetweenScanPeriod = l.longValue();
    }

    public Long getBackgroundScanPeriod() {
        return Long.valueOf(this.mBackgroundScanPeriod);
    }

    public void setBackgroundScanPeriod(Long l) {
        this.mBackgroundScanPeriod = l.longValue();
    }

    public Long getForegroundBetweenScanPeriod() {
        return Long.valueOf(this.mForegroundBetweenScanPeriod);
    }

    public void setForegroundBetweenScanPeriod(Long l) {
        this.mForegroundBetweenScanPeriod = l.longValue();
    }

    public Long getForegroundScanPeriod() {
        return Long.valueOf(this.mForegroundScanPeriod);
    }

    public void setForegroundScanPeriod(Long l) {
        this.mForegroundScanPeriod = l.longValue();
    }

    public MonitoringStatus getMonitoringStatus() {
        return this.mMonitoringStatus;
    }

    public void setMonitoringStatus(MonitoringStatus monitoringStatus) {
        this.mMonitoringStatus = monitoringStatus;
    }

    public Map<Region, RangeState> getRangedRegionState() {
        return this.mRangedRegionState;
    }

    public void setRangedRegionState(Map<Region, RangeState> map) {
        this.mRangedRegionState = map;
    }

    public ExtraDataBeaconTracker getExtraBeaconDataTracker() {
        return this.mExtraBeaconDataTracker;
    }

    public void setExtraBeaconDataTracker(ExtraDataBeaconTracker extraDataBeaconTracker) {
        this.mExtraBeaconDataTracker = extraDataBeaconTracker;
    }

    public Set<BeaconParser> getBeaconParsers() {
        return this.mBeaconParsers;
    }

    public void setBeaconParsers(Set<BeaconParser> set) {
        this.mBeaconParsers = set;
    }

    public long getLastScanStartTimeMillis() {
        return this.mLastScanStartTimeMillis;
    }

    public void setLastScanStartTimeMillis(long j) {
        this.mLastScanStartTimeMillis = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0107 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[Catch: all -> 0x00fa, SYNTHETIC, TRY_LEAVE, TryCatch #9 {, blocks: (B:14:0x0081, B:17:0x008e, B:19:0x0093, B:42:0x00e6, B:16:0x0085, B:49:0x00f6, B:55:0x0107, B:58:0x0114, B:57:0x010b, B:53:0x00fc, B:35:0x00ca, B:39:0x00d9, B:41:0x00dd, B:37:0x00ce), top: B:71:0x0005, inners: #2, #3, #5, #8, #11, #13 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void save() {
        /*
            Method dump skipped, instructions count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.bluetooth.altbeacon.beacon.service.ScanState.save():void");
    }

    public int getScanJobIntervalMillis() {
        long longValue;
        long longValue2;
        if (getBackgroundMode().booleanValue()) {
            longValue = getBackgroundScanPeriod().longValue();
            longValue2 = getBackgroundBetweenScanPeriod().longValue();
        } else {
            longValue = getForegroundScanPeriod().longValue();
            longValue2 = getForegroundBetweenScanPeriod().longValue();
        }
        long j = longValue + longValue2;
        int i = MIN_SCAN_JOB_INTERVAL_MILLIS;
        return j > ((long) i) ? (int) j : i;
    }

    public int getScanJobRuntimeMillis() {
        long longValue;
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("ScanState says background mode for ScanJob is ");
        sb.append(getBackgroundMode());
        LogManager.d(str, sb.toString(), new Object[0]);
        if (getBackgroundMode().booleanValue()) {
            longValue = getBackgroundScanPeriod().longValue();
        } else {
            longValue = getForegroundScanPeriod().longValue();
        }
        if (!getBackgroundMode().booleanValue()) {
            int i = MIN_SCAN_JOB_INTERVAL_MILLIS;
            if (longValue < i) {
                return i;
            }
        }
        return (int) longValue;
    }

    public void applyChanges(BeaconManager beaconManager) {
        this.mBeaconParsers = new HashSet(beaconManager.getBeaconParsers());
        this.mForegroundScanPeriod = beaconManager.getForegroundScanPeriod();
        this.mForegroundBetweenScanPeriod = beaconManager.getForegroundBetweenScanPeriod();
        this.mBackgroundScanPeriod = beaconManager.getBackgroundScanPeriod();
        this.mBackgroundBetweenScanPeriod = beaconManager.getBackgroundBetweenScanPeriod();
        this.mBackgroundMode = beaconManager.getBackgroundMode();
        ArrayList arrayList = new ArrayList(this.mMonitoringStatus.regions());
        ArrayList arrayList2 = new ArrayList(this.mRangedRegionState.keySet());
        ArrayList arrayList3 = new ArrayList(beaconManager.getMonitoredRegions());
        ArrayList arrayList4 = new ArrayList(beaconManager.getRangedRegions());
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("ranged regions: old=");
        sb.append(arrayList2.size());
        sb.append(" new=");
        sb.append(arrayList4.size());
        LogManager.d(str, sb.toString(), new Object[0]);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("monitored regions: old=");
        sb2.append(arrayList.size());
        sb2.append(" new=");
        sb2.append(arrayList3.size());
        LogManager.d(str, sb2.toString(), new Object[0]);
        Iterator it = arrayList4.iterator();
        while (it.hasNext()) {
            Region region = (Region) it.next();
            if (!arrayList2.contains(region)) {
                String str2 = TAG;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Starting ranging region: ");
                sb3.append(region);
                LogManager.d(str2, sb3.toString(), new Object[0]);
                this.mRangedRegionState.put(region, new RangeState(new Callback(this.mContext.getPackageName())));
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            Region region2 = (Region) it2.next();
            if (!arrayList4.contains(region2)) {
                String str3 = TAG;
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Stopping ranging region: ");
                sb4.append(region2);
                LogManager.d(str3, sb4.toString(), new Object[0]);
                this.mRangedRegionState.remove(region2);
            }
        }
        String str4 = TAG;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Updated state with ");
        sb5.append(arrayList4.size());
        sb5.append(" ranging regions and ");
        sb5.append(arrayList3.size());
        sb5.append(" monitoring regions.");
        LogManager.d(str4, sb5.toString(), new Object[0]);
        save();
    }
}
