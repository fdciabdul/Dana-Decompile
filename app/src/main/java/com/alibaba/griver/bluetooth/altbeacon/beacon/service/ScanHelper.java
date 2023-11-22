package com.alibaba.griver.bluetooth.altbeacon.beacon.service;

import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.AsyncTask;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.bluetooth.altbeacon.beacon.Beacon;
import com.alibaba.griver.bluetooth.altbeacon.beacon.BeaconManager;
import com.alibaba.griver.bluetooth.altbeacon.beacon.BeaconParser;
import com.alibaba.griver.bluetooth.altbeacon.beacon.Region;
import com.alibaba.griver.bluetooth.altbeacon.beacon.logging.LogManager;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner.CycledLeScanCallback;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner.CycledLeScanner;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner.DistinctPacketDetector;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner.NonBeaconLeScanCallback;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner.ScanFilterUtils;
import com.alibaba.griver.bluetooth.altbeacon.beacon.startup.StartupBroadcastReceiver;
import com.alibaba.griver.bluetooth.altbeacon.bluetooth.BluetoothCrashResolver;
import com.alibaba.griver.ui.popmenu.TinyAppActionState;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class ScanHelper {
    private static final String TAG = "ScanHelper";
    private BeaconManager mBeaconManager;
    private Context mContext;
    private CycledLeScanner mCycledScanner;
    private ExtraDataBeaconTracker mExtraDataBeaconTracker;
    private MonitoringStatus mMonitoringStatus;
    private final Map<Region, RangeState> mRangedRegionState = new HashMap();
    private DistinctPacketDetector mDistinctPacketDetector = new DistinctPacketDetector();
    private Set<BeaconParser> mBeaconParsers = new HashSet();
    private List<Beacon> mSimulatedScanData = null;
    private final CycledLeScanCallback mCycledLeScanCallback = new CycledLeScanCallback() { // from class: com.alibaba.griver.bluetooth.altbeacon.beacon.service.ScanHelper.1
        public static final byte[] BuiltInFictitiousFunctionClassFactory = {18, -87, -121, -123, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4, 6, Ascii.ETB, -43, TarHeader.LF_CONTIG, 8, 4, 5, 2, 6, Ascii.ESC, -3, 14, 7, -29, 45, 0, 17};
        public static final int getAuthRequestContext = 49;

        /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x0037). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(int r7, byte r8, int r9, java.lang.Object[] r10) {
            /*
                int r8 = r8 * 6
                int r8 = 103 - r8
                int r7 = r7 * 22
                int r7 = 25 - r7
                int r9 = r9 * 5
                int r9 = 23 - r9
                byte[] r0 = com.alibaba.griver.bluetooth.altbeacon.beacon.service.ScanHelper.AnonymousClass1.BuiltInFictitiousFunctionClassFactory
                byte[] r1 = new byte[r9]
                r2 = 0
                if (r0 != 0) goto L1b
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r10
                r10 = r9
                r9 = r8
                r8 = r7
                goto L37
            L1b:
                r3 = 0
            L1c:
                int r4 = r3 + 1
                byte r5 = (byte) r8
                r1[r3] = r5
                int r7 = r7 + 1
                if (r4 != r9) goto L2d
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L2d:
                r3 = r0[r7]
                r6 = r8
                r8 = r7
                r7 = r3
                r3 = r1
                r1 = r0
                r0 = r10
                r10 = r9
                r9 = r6
            L37:
                int r9 = r9 + r7
                int r7 = r9 + (-8)
                r9 = r10
                r10 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                r6 = r8
                r8 = r7
                r7 = r6
                goto L1c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.bluetooth.altbeacon.beacon.service.ScanHelper.AnonymousClass1.a(int, byte, int, java.lang.Object[]):void");
        }

        @Override // com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner.CycledLeScanCallback
        public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            ScanHelper.this.processScanResult(bluetoothDevice, i, bArr);
        }

        @Override // com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner.CycledLeScanCallback
        public void onCycleEnd() {
            ScanHelper.this.mDistinctPacketDetector.clearDetections();
            ScanHelper.this.mMonitoringStatus.updateNewlyOutside();
            ScanHelper.this.processRangeData();
            if (ScanHelper.this.mSimulatedScanData != null) {
                LogManager.w(ScanHelper.TAG, "Simulated scan data is deprecated and will be removed in a future release. Please use the new BeaconSimulator interface instead.", new Object[0]);
                Context context = ScanHelper.this.mContext;
                try {
                    byte b = (byte) (getAuthRequestContext & 7);
                    Object[] objArr = new Object[1];
                    a(b, b, BuiltInFictitiousFunctionClassFactory[41], objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    byte b2 = BuiltInFictitiousFunctionClassFactory[41];
                    byte b3 = b2;
                    Object[] objArr2 = new Object[1];
                    a(b2, b3, (byte) (b3 + 1), objArr2);
                    ApplicationInfo applicationInfo = (ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null);
                    int i = applicationInfo.flags & 2;
                    applicationInfo.flags = i;
                    if (i != 0) {
                        Iterator it = ScanHelper.this.mSimulatedScanData.iterator();
                        while (it.hasNext()) {
                            ScanHelper.this.processBeaconFromScan((Beacon) it.next());
                        }
                    } else {
                        LogManager.w(ScanHelper.TAG, "Simulated scan data provided, but ignored because we are not running in debug mode.  Please remove simulated scan data for production.", new Object[0]);
                    }
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            if (BeaconManager.getBeaconSimulator() != null) {
                if (BeaconManager.getBeaconSimulator().getBeacons() != null) {
                    Context context2 = ScanHelper.this.mContext;
                    try {
                        byte b4 = (byte) (getAuthRequestContext & 7);
                        Object[] objArr3 = new Object[1];
                        a(b4, b4, BuiltInFictitiousFunctionClassFactory[41], objArr3);
                        Class<?> cls2 = Class.forName((String) objArr3[0]);
                        byte b5 = BuiltInFictitiousFunctionClassFactory[41];
                        byte b6 = b5;
                        Object[] objArr4 = new Object[1];
                        a(b5, b6, (byte) (b6 + 1), objArr4);
                        ApplicationInfo applicationInfo2 = (ApplicationInfo) cls2.getMethod((String) objArr4[0], null).invoke(context2, null);
                        int i2 = applicationInfo2.flags & 2;
                        applicationInfo2.flags = i2;
                        if (i2 == 0) {
                            LogManager.w(ScanHelper.TAG, "Beacon simulations provided, but ignored because we are not running in debug mode.  Please remove beacon simulations for production.", new Object[0]);
                            return;
                        }
                        Iterator<Beacon> it2 = BeaconManager.getBeaconSimulator().getBeacons().iterator();
                        while (it2.hasNext()) {
                            ScanHelper.this.processBeaconFromScan(it2.next());
                        }
                        return;
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                }
                LogManager.w(ScanHelper.TAG, "getBeacons is returning null. No simulated beacons to report.", new Object[0]);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public ScanHelper(Context context) {
        this.mContext = context;
        this.mBeaconManager = BeaconManager.getInstanceForApplication(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CycledLeScanner getCycledScanner() {
        return this.mCycledScanner;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MonitoringStatus getMonitoringStatus() {
        return this.mMonitoringStatus;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMonitoringStatus(MonitoringStatus monitoringStatus) {
        this.mMonitoringStatus = monitoringStatus;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<Region, RangeState> getRangedRegionState() {
        return this.mRangedRegionState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRangedRegionState(Map<Region, RangeState> map) {
        synchronized (this.mRangedRegionState) {
            this.mRangedRegionState.clear();
            this.mRangedRegionState.putAll(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setExtraDataBeaconTracker(ExtraDataBeaconTracker extraDataBeaconTracker) {
        this.mExtraDataBeaconTracker = extraDataBeaconTracker;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBeaconParsers(Set<BeaconParser> set) {
        this.mBeaconParsers = set;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSimulatedScanData(List<Beacon> list) {
        this.mSimulatedScanData = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void createCycledLeScanner(boolean z, BluetoothCrashResolver bluetoothCrashResolver) {
        this.mCycledScanner = CycledLeScanner.createScanner(this.mContext, BeaconManager.DEFAULT_FOREGROUND_SCAN_PERIOD, 0L, z, this.mCycledLeScanCallback, bluetoothCrashResolver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void processScanResult(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        NonBeaconLeScanCallback nonBeaconLeScanCallback = this.mBeaconManager.getNonBeaconLeScanCallback();
        RVExecutorService rVExecutorService = (RVExecutorService) RVProxy.get(RVExecutorService.class);
        if (rVExecutorService != null) {
            try {
                new ScanProcessor(nonBeaconLeScanCallback).executeOnExecutor(rVExecutorService.getScheduledExecutor(), new ScanData(bluetoothDevice, i, bArr));
            } catch (RejectedExecutionException unused) {
                LogManager.w(TAG, "Ignoring scan result because we cannot keep up.", new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reloadParsers() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.mBeaconManager.getBeaconParsers());
        boolean z = true;
        for (BeaconParser beaconParser : this.mBeaconManager.getBeaconParsers()) {
            if (beaconParser.getExtraDataParsers().size() > 0) {
                z = false;
                hashSet.addAll(beaconParser.getExtraDataParsers());
            }
        }
        this.mBeaconParsers = hashSet;
        this.mExtraDataBeaconTracker = new ExtraDataBeaconTracker(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startAndroidOBackgroundScan(Set<BeaconParser> set) {
        ScanSettings build = new ScanSettings.Builder().setScanMode(0).build();
        List<ScanFilter> createScanFiltersForBeaconParsers = new ScanFilterUtils().createScanFiltersForBeaconParsers(new ArrayList(set));
        try {
            BluetoothAdapter adapter = ((BluetoothManager) this.mContext.getApplicationContext().getSystemService(TinyAppActionState.ACTION_BLUE_TOOTH)).getAdapter();
            if (adapter == null) {
                LogManager.w(TAG, "Failed to construct a BluetoothAdapter", new Object[0]);
            } else if (!adapter.isEnabled()) {
                LogManager.w(TAG, "Failed to start background scan on Android O: BluetoothAdapter is not enabled", new Object[0]);
            } else {
                int startScan = adapter.getBluetoothLeScanner().startScan(createScanFiltersForBeaconParsers, build, getScanCallbackIntent());
                if (startScan != 0) {
                    String str = TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to start background scan on Android O.  Code: ");
                    sb.append(startScan);
                    LogManager.e(str, sb.toString(), new Object[0]);
                    return;
                }
                LogManager.d(TAG, "Started passive beacon scan", new Object[0]);
            }
        } catch (SecurityException unused) {
            LogManager.e(TAG, "SecurityException making Android O background scanner", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopAndroidOBackgroundScan() {
        try {
            BluetoothAdapter adapter = ((BluetoothManager) this.mContext.getApplicationContext().getSystemService(TinyAppActionState.ACTION_BLUE_TOOTH)).getAdapter();
            if (adapter == null) {
                LogManager.w(TAG, "Failed to construct a BluetoothAdapter", new Object[0]);
            } else if (!adapter.isEnabled()) {
                LogManager.w(TAG, "BluetoothAdapter is not enabled", new Object[0]);
            } else {
                adapter.getBluetoothLeScanner().stopScan(getScanCallbackIntent());
            }
        } catch (SecurityException unused) {
            LogManager.e(TAG, "SecurityException stopping Android O background scanner", new Object[0]);
        }
    }

    PendingIntent getScanCallbackIntent() {
        Intent intent = new Intent(this.mContext, StartupBroadcastReceiver.class);
        intent.putExtra("o-scan", true);
        return PendingIntent.getBroadcast(this.mContext, 0, intent, 134217728);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processRangeData() {
        synchronized (this.mRangedRegionState) {
            for (Region region : this.mRangedRegionState.keySet()) {
                RangeState rangeState = this.mRangedRegionState.get(region);
                LogManager.d(TAG, "Calling ranging callback", new Object[0]);
                rangeState.getCallback().call(this.mContext, "rangingData", new RangingData(rangeState.finalizeBeacons(), region).toBundle());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processBeaconFromScan(Beacon beacon) {
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
        LogManager.d(TAG, "looking for ranging region matches for this beacon", new Object[0]);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ScanData {
        BluetoothDevice device;
        final int rssi;
        byte[] scanRecord;

        ScanData(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            this.device = bluetoothDevice;
            this.rssi = i;
            this.scanRecord = bArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ScanProcessor extends AsyncTask<ScanData, Void, Void> {
        final DetectionTracker mDetectionTracker = DetectionTracker.getInstance();
        private final NonBeaconLeScanCallback mNonBeaconLeScanCallback;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Void r1) {
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onProgressUpdate(Void... voidArr) {
        }

        ScanProcessor(NonBeaconLeScanCallback nonBeaconLeScanCallback) {
            this.mNonBeaconLeScanCallback = nonBeaconLeScanCallback;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(ScanData... scanDataArr) {
            ScanData scanData = scanDataArr[0];
            Iterator it = ScanHelper.this.mBeaconParsers.iterator();
            Beacon beacon = null;
            while (it.hasNext() && (beacon = ((BeaconParser) it.next()).fromScanData(scanData.scanRecord, scanData.rssi, scanData.device)) == null) {
            }
            if (beacon != null) {
                if (LogManager.isVerboseLoggingEnabled()) {
                    String str = ScanHelper.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Beacon packet detected for: ");
                    sb.append(beacon);
                    sb.append(" with rssi ");
                    sb.append(beacon.getRssi());
                    LogManager.d(str, sb.toString(), new Object[0]);
                }
                this.mDetectionTracker.recordDetection();
                if (ScanHelper.this.mCycledScanner != null && !ScanHelper.this.mCycledScanner.getDistinctPacketsDetectedPerScan() && !ScanHelper.this.mDistinctPacketDetector.isPacketDistinct(scanData.device.getAddress(), scanData.scanRecord)) {
                    LogManager.i(ScanHelper.TAG, "Non-distinct packets detected in a single scan.  Restarting scans unecessary.", new Object[0]);
                    ScanHelper.this.mCycledScanner.setDistinctPacketsDetectedPerScan(true);
                }
                ScanHelper.this.processBeaconFromScan(beacon);
            } else {
                NonBeaconLeScanCallback nonBeaconLeScanCallback = this.mNonBeaconLeScanCallback;
                if (nonBeaconLeScanCallback != null) {
                    nonBeaconLeScanCallback.onNonBeaconLeScan(scanData.device, scanData.rssi, scanData.scanRecord);
                }
            }
            return null;
        }
    }
}
