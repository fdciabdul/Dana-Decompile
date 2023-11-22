package com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.os.Handler;
import android.os.ParcelUuid;
import android.os.SystemClock;
import com.alibaba.griver.bluetooth.altbeacon.beacon.BeaconManager;
import com.alibaba.griver.bluetooth.altbeacon.beacon.logging.LogManager;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.DetectionTracker;
import com.alibaba.griver.bluetooth.altbeacon.bluetooth.BluetoothCrashResolver;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class CycledLeScannerForLollipop extends CycledLeScanner {
    private static final long BACKGROUND_L_SCAN_DETECTION_PERIOD_MILLIS = 10000;
    private static final String TAG = "CycledLeScannerForLollipop";
    private ScanCallback leScanCallback;
    private long mBackgroundLScanFirstDetectionTime;
    private long mBackgroundLScanStartTime;
    private final BeaconManager mBeaconManager;
    private boolean mMainScanCycleActive;
    private BluetoothLeScanner mScanner;

    public CycledLeScannerForLollipop(Context context, long j, long j2, boolean z, CycledLeScanCallback cycledLeScanCallback, BluetoothCrashResolver bluetoothCrashResolver) {
        super(context, j, j2, z, cycledLeScanCallback, bluetoothCrashResolver);
        this.mBackgroundLScanStartTime = 0L;
        this.mBackgroundLScanFirstDetectionTime = 0L;
        this.mMainScanCycleActive = false;
        this.mBeaconManager = BeaconManager.getInstanceForApplication(this.mContext);
    }

    @Override // com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner.CycledLeScanner
    protected void stopScan() {
        postStopLeScan();
    }

    @Override // com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner.CycledLeScanner
    protected boolean deferScanIfNeeded() {
        long elapsedRealtime = this.mNextScanCycleStartTime - SystemClock.elapsedRealtime();
        boolean z = elapsedRealtime > 0;
        boolean z2 = this.mMainScanCycleActive;
        this.mMainScanCycleActive = !z;
        if (z) {
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - DetectionTracker.getInstance().getLastDetectionTime();
            if (z2) {
                if (elapsedRealtime2 > 10000) {
                    this.mBackgroundLScanStartTime = SystemClock.elapsedRealtime();
                    this.mBackgroundLScanFirstDetectionTime = 0L;
                    LogManager.d(TAG, "This is Android L. Preparing to do a filtered scan for the background.", new Object[0]);
                    if (this.mBetweenScanPeriod > 6000) {
                        startScan();
                    } else {
                        LogManager.d(TAG, "Suppressing scan between cycles because the between scan cycle is too short.", new Object[0]);
                    }
                } else {
                    LogManager.d(TAG, "This is Android L, but we last saw a beacon only %s ago, so we will not keep scanning in background.", Long.valueOf(elapsedRealtime2));
                }
            }
            if (this.mBackgroundLScanStartTime > 0 && DetectionTracker.getInstance().getLastDetectionTime() > this.mBackgroundLScanStartTime) {
                if (this.mBackgroundLScanFirstDetectionTime == 0) {
                    this.mBackgroundLScanFirstDetectionTime = DetectionTracker.getInstance().getLastDetectionTime();
                }
                if (SystemClock.elapsedRealtime() - this.mBackgroundLScanFirstDetectionTime >= 10000) {
                    LogManager.d(TAG, "We've been detecting for a bit.  Stopping Android L background scanning", new Object[0]);
                    stopScan();
                    this.mBackgroundLScanStartTime = 0L;
                } else {
                    LogManager.d(TAG, "Delivering Android L background scanning results", new Object[0]);
                    this.mCycledLeScanCallback.onCycleEnd();
                }
            }
            LogManager.d(TAG, "Waiting to start full Bluetooth scan for another %s milliseconds", Long.valueOf(elapsedRealtime));
            if (z2 && this.mBackgroundFlag) {
                setWakeUpAlarm();
            }
            Handler handler = this.mHandler;
            Runnable runnable = new Runnable() { // from class: com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner.CycledLeScannerForLollipop.1
                @Override // java.lang.Runnable
                public void run() {
                    CycledLeScannerForLollipop.this.scanLeDevice(Boolean.TRUE);
                }
            };
            if (elapsedRealtime > 1000) {
                elapsedRealtime = 1000;
            }
            handler.postDelayed(runnable, elapsedRealtime);
        } else if (this.mBackgroundLScanStartTime > 0) {
            stopScan();
            this.mBackgroundLScanStartTime = 0L;
        }
        return z;
    }

    @Override // com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner.CycledLeScanner
    protected void startScan() {
        List<ScanFilter> list;
        ScanSettings build;
        if (!isBluetoothOn()) {
            LogManager.d(TAG, "Not starting scan because bluetooth is off", new Object[0]);
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (!this.mMainScanCycleActive) {
            LogManager.d(TAG, "starting filtered scan in SCAN_MODE_LOW_POWER", new Object[0]);
            build = new ScanSettings.Builder().setScanMode(0).build();
            list = new ScanFilterUtils().createScanFiltersForBeaconParsers(this.mBeaconManager.getBeaconParsers());
        } else {
            LogManager.d(TAG, "starting non-filtered scan in SCAN_MODE_LOW_LATENCY", new Object[0]);
            list = arrayList;
            build = new ScanSettings.Builder().setScanMode(2).build();
        }
        if (build != null) {
            postStartLeScan(list, build);
        }
    }

    @Override // com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner.CycledLeScanner
    protected void finishScan() {
        LogManager.d(TAG, "Stopping scan", new Object[0]);
        stopScan();
        this.mScanningPaused = true;
    }

    private void postStartLeScan(final List<ScanFilter> list, final ScanSettings scanSettings) {
        final BluetoothLeScanner scanner = getScanner();
        if (scanner == null) {
            return;
        }
        final ScanCallback newLeScanCallback = getNewLeScanCallback();
        this.mScanHandler.removeCallbacksAndMessages(null);
        this.mScanHandler.post(new Runnable() { // from class: com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner.CycledLeScannerForLollipop.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    scanner.startScan(list, scanSettings, newLeScanCallback);
                } catch (IllegalStateException unused) {
                    LogManager.w(CycledLeScannerForLollipop.TAG, "Cannot start scan. Bluetooth may be turned off.", new Object[0]);
                } catch (NullPointerException e) {
                    LogManager.e(e, CycledLeScannerForLollipop.TAG, "Cannot start scan. Unexpected NPE.", new Object[0]);
                } catch (SecurityException unused2) {
                    LogManager.e(CycledLeScannerForLollipop.TAG, "Cannot start scan.  Security Exception", new Object[0]);
                }
            }
        });
    }

    private void postStopLeScan() {
        if (!isBluetoothOn()) {
            LogManager.d(TAG, "Not stopping scan because bluetooth is off", new Object[0]);
            return;
        }
        final BluetoothLeScanner scanner = getScanner();
        if (scanner == null) {
            return;
        }
        final ScanCallback newLeScanCallback = getNewLeScanCallback();
        this.mScanHandler.removeCallbacksAndMessages(null);
        this.mScanHandler.post(new Runnable() { // from class: com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner.CycledLeScannerForLollipop.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    LogManager.d(CycledLeScannerForLollipop.TAG, "Stopping LE scan on scan handler", new Object[0]);
                    scanner.stopScan(newLeScanCallback);
                } catch (IllegalStateException unused) {
                    LogManager.w(CycledLeScannerForLollipop.TAG, "Cannot stop scan. Bluetooth may be turned off.", new Object[0]);
                } catch (NullPointerException e) {
                    LogManager.e(e, CycledLeScannerForLollipop.TAG, "Cannot stop scan. Unexpected NPE.", new Object[0]);
                } catch (SecurityException unused2) {
                    LogManager.e(CycledLeScannerForLollipop.TAG, "Cannot stop scan.  Security Exception", new Object[0]);
                }
            }
        });
    }

    private boolean isBluetoothOn() {
        BluetoothAdapter bluetoothAdapter;
        try {
            bluetoothAdapter = getBluetoothAdapter();
        } catch (SecurityException unused) {
            LogManager.w(TAG, "SecurityException checking if bluetooth is on", new Object[0]);
        }
        if (bluetoothAdapter != null) {
            return bluetoothAdapter.getState() == 12;
        }
        LogManager.w(TAG, "Cannot get bluetooth adapter", new Object[0]);
        return false;
    }

    private BluetoothLeScanner getScanner() {
        try {
            if (this.mScanner == null) {
                LogManager.d(TAG, "Making new Android L scanner", new Object[0]);
                if (getBluetoothAdapter() != null) {
                    this.mScanner = getBluetoothAdapter().getBluetoothLeScanner();
                }
                if (this.mScanner == null) {
                    LogManager.w(TAG, "Failed to make new Android L scanner", new Object[0]);
                }
            }
        } catch (SecurityException unused) {
            LogManager.w(TAG, "SecurityException making new Android L scanner", new Object[0]);
        }
        return this.mScanner;
    }

    private ScanCallback getNewLeScanCallback() {
        if (this.leScanCallback == null) {
            this.leScanCallback = new ScanCallback() { // from class: com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner.CycledLeScannerForLollipop.4
                @Override // android.bluetooth.le.ScanCallback
                public void onScanResult(int i, ScanResult scanResult) {
                    if (LogManager.isVerboseLoggingEnabled()) {
                        LogManager.d(CycledLeScannerForLollipop.TAG, "got record", new Object[0]);
                        List<ParcelUuid> serviceUuids = scanResult.getScanRecord().getServiceUuids();
                        if (serviceUuids != null) {
                            for (ParcelUuid parcelUuid : serviceUuids) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("with service uuid: ");
                                sb.append(parcelUuid);
                                LogManager.d(CycledLeScannerForLollipop.TAG, sb.toString(), new Object[0]);
                            }
                        }
                    }
                    CycledLeScannerForLollipop.this.mCycledLeScanCallback.onLeScan(scanResult.getDevice(), scanResult.getRssi(), scanResult.getScanRecord().getBytes());
                    if (CycledLeScannerForLollipop.this.mBackgroundLScanStartTime > 0) {
                        LogManager.d(CycledLeScannerForLollipop.TAG, "got a filtered scan result in the background.", new Object[0]);
                    }
                }

                @Override // android.bluetooth.le.ScanCallback
                public void onBatchScanResults(List<ScanResult> list) {
                    LogManager.d(CycledLeScannerForLollipop.TAG, "got batch records", new Object[0]);
                    for (ScanResult scanResult : list) {
                        CycledLeScannerForLollipop.this.mCycledLeScanCallback.onLeScan(scanResult.getDevice(), scanResult.getRssi(), scanResult.getScanRecord().getBytes());
                    }
                    if (CycledLeScannerForLollipop.this.mBackgroundLScanStartTime > 0) {
                        LogManager.d(CycledLeScannerForLollipop.TAG, "got a filtered batch scan result in the background.", new Object[0]);
                    }
                }

                @Override // android.bluetooth.le.ScanCallback
                public void onScanFailed(int i) {
                    if (i == 1) {
                        LogManager.e(CycledLeScannerForLollipop.TAG, "Scan failed: a BLE scan with the same settings is already started by the app", new Object[0]);
                    } else if (i == 2) {
                        LogManager.e(CycledLeScannerForLollipop.TAG, "Scan failed: app cannot be registered", new Object[0]);
                    } else if (i == 3) {
                        LogManager.e(CycledLeScannerForLollipop.TAG, "Scan failed: internal error", new Object[0]);
                    } else if (i == 4) {
                        LogManager.e(CycledLeScannerForLollipop.TAG, "Scan failed: power optimized scan feature is not supported", new Object[0]);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Scan failed with unknown error (errorCode=");
                        sb.append(i);
                        sb.append(")");
                        LogManager.e(CycledLeScannerForLollipop.TAG, sb.toString(), new Object[0]);
                    }
                }
            };
        }
        return this.leScanCallback;
    }
}
