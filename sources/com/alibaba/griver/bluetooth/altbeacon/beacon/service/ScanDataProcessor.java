package com.alibaba.griver.bluetooth.altbeacon.beacon.service;

import android.app.Service;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.bluetooth.altbeacon.beacon.Beacon;
import com.alibaba.griver.bluetooth.altbeacon.beacon.BeaconManager;
import com.alibaba.griver.bluetooth.altbeacon.beacon.BeaconParser;
import com.alibaba.griver.bluetooth.altbeacon.beacon.Region;
import com.alibaba.griver.bluetooth.altbeacon.beacon.logging.LogManager;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner.NonBeaconLeScanCallback;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public class ScanDataProcessor {
    private static final String TAG = "ScanDataProcessor";
    private Set<BeaconParser> mBeaconParsers;
    private DetectionTracker mDetectionTracker = DetectionTracker.getInstance();
    private ExtraDataBeaconTracker mExtraDataBeaconTracker;
    private MonitoringStatus mMonitoringStatus;
    private NonBeaconLeScanCallback mNonBeaconLeScanCallback;
    private Map<Region, RangeState> mRangedRegionState;
    private Service mService;
    int trackedBeaconsPacketCount;
    public static final byte[] getAuthRequestContext = {107, 3, 14, 112, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4, 6, Ascii.ETB, -43, TarHeader.LF_CONTIG, 8, 4, 5, 2, 6, Ascii.ESC, -3, 14, 7, -29, 45, 0, 17};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 41;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 6
            int r8 = 103 - r8
            int r7 = r7 + 4
            byte[] r0 = com.alibaba.griver.bluetooth.altbeacon.beacon.service.ScanDataProcessor.getAuthRequestContext
            int r6 = r6 * 5
            int r6 = 23 - r6
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L19
            r8 = r7
            r3 = r1
            r4 = 0
            r7 = r6
            r1 = r0
            r0 = r9
            r9 = r8
            goto L35
        L19:
            r3 = 0
        L1a:
            int r7 = r7 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r6) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L35:
            int r8 = r8 + r6
            int r8 = r8 + (-8)
            r6 = r7
            r7 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.bluetooth.altbeacon.beacon.service.ScanDataProcessor.a(int, byte, short, java.lang.Object[]):void");
    }

    public ScanDataProcessor(Service service, ScanState scanState) {
        this.mRangedRegionState = new HashMap();
        this.mBeaconParsers = new HashSet();
        this.mService = service;
        this.mMonitoringStatus = scanState.getMonitoringStatus();
        this.mRangedRegionState = scanState.getRangedRegionState();
        this.mMonitoringStatus = scanState.getMonitoringStatus();
        this.mExtraDataBeaconTracker = scanState.getExtraBeaconDataTracker();
        this.mBeaconParsers = scanState.getBeaconParsers();
    }

    public void process(ScanResult scanResult) {
        process(new ScanData(scanResult.getDevice(), scanResult.getRssi(), scanResult.getScanRecord().getBytes()));
    }

    public void process(ScanData scanData) {
        Iterator<BeaconParser> it = this.mBeaconParsers.iterator();
        Beacon beacon = null;
        while (it.hasNext() && (beacon = it.next().fromScanData(scanData.scanRecord, scanData.rssi, scanData.device)) == null) {
        }
        if (beacon != null) {
            this.mDetectionTracker.recordDetection();
            this.trackedBeaconsPacketCount++;
            processBeaconFromScan(beacon);
            return;
        }
        NonBeaconLeScanCallback nonBeaconLeScanCallback = this.mNonBeaconLeScanCallback;
        if (nonBeaconLeScanCallback != null) {
            nonBeaconLeScanCallback.onNonBeaconLeScan(scanData.device, scanData.rssi, scanData.scanRecord);
        }
    }

    private void processBeaconFromScan(Beacon beacon) {
        if (Stats.getInstance().isEnabled()) {
            Stats.getInstance().log(beacon);
        }
        if (LogManager.isVerboseLoggingEnabled()) {
            LogManager.d(TAG, "beacon detected : %s", beacon.toString());
        }
        Beacon track = this.mExtraDataBeaconTracker.track(beacon);
        if (track == null) {
            if (LogManager.isVerboseLoggingEnabled()) {
                LogManager.d(TAG, "not processing detections for GATT extra data beacon", new Object[0]);
                return;
            }
            return;
        }
        this.mMonitoringStatus.updateNewlyInsideInRegionsContaining(track);
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("looking for ranging region matches for this beacon out of ");
        sb.append(this.mRangedRegionState.keySet().size());
        sb.append(" regions.");
        LogManager.d(str, sb.toString(), new Object[0]);
        synchronized (this.mRangedRegionState) {
            for (Region region : matchingRegions(track, this.mRangedRegionState.keySet())) {
                LogManager.d(TAG, "matches ranging region: %s", region);
                RangeState rangeState = this.mRangedRegionState.get(region);
                if (rangeState != null) {
                    rangeState.addBeacon(track);
                }
            }
        }
    }

    private List<Region> matchingRegions(Beacon beacon, Collection<Region> collection) {
        ArrayList arrayList = new ArrayList();
        for (Region region : collection) {
            if (region.matchesBeacon(beacon)) {
                arrayList.add(region);
            } else {
                LogManager.d(TAG, "This region (%s) does not match beacon: %s", region, beacon);
            }
        }
        return arrayList;
    }

    public void onCycleEnd() {
        this.mMonitoringStatus.updateNewlyOutside();
        processRangeData();
        if (BeaconManager.getBeaconSimulator() != null) {
            if (BeaconManager.getBeaconSimulator().getBeacons() != null) {
                Context applicationContext = this.mService.getApplicationContext();
                try {
                    byte b = getAuthRequestContext[41];
                    byte b2 = (byte) (b - 1);
                    Object[] objArr = new Object[1];
                    a(b, b2, (byte) (-b2), objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    Object[] objArr2 = new Object[1];
                    a((byte) (KClassImpl$Data$declaredNonStaticMembers$2 & 7), getAuthRequestContext[4], getAuthRequestContext[41], objArr2);
                    ApplicationInfo applicationInfo = (ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(applicationContext, null);
                    int i = applicationInfo.flags & 2;
                    applicationInfo.flags = i;
                    if (i != 0) {
                        Iterator<Beacon> it = BeaconManager.getBeaconSimulator().getBeacons().iterator();
                        while (it.hasNext()) {
                            processBeaconFromScan(it.next());
                        }
                        return;
                    }
                    LogManager.w(TAG, "Beacon simulations provided, but ignored because we are not running in debug mode.  Please remove beacon simulations for production.", new Object[0]);
                    return;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            LogManager.w(TAG, "getBeacons is returning null. No simulated beacons to report.", new Object[0]);
        }
    }

    private void processRangeData() {
        synchronized (this.mRangedRegionState) {
            for (Region region : this.mRangedRegionState.keySet()) {
                RangeState rangeState = this.mRangedRegionState.get(region);
                LogManager.d(TAG, "Calling ranging callback", new Object[0]);
                new Callback(this.mService.getPackageName()).call(this.mService, "rangingData", new RangingData(rangeState.finalizeBeacons(), region).toBundle());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ScanData {
        BluetoothDevice device;
        int rssi;
        byte[] scanRecord;

        public ScanData(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            this.device = bluetoothDevice;
            this.rssi = i;
            this.scanRecord = bArr;
        }
    }
}
