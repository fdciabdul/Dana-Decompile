package com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.alibaba.griver.bluetooth.altbeacon.beacon.logging.LogManager;
import com.alibaba.griver.bluetooth.altbeacon.beacon.startup.StartupBroadcastReceiver;
import com.alibaba.griver.bluetooth.altbeacon.bluetooth.BluetoothCrashResolver;
import com.alibaba.griver.ui.popmenu.TinyAppActionState;
import id.dana.utils.permission.ManifestPermission;
import java.util.Date;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes6.dex */
public abstract class CycledLeScanner {
    public static final long ANDROID_N_MAX_SCAN_DURATION_MILLIS = 1800000;
    private static final long ANDROID_N_MIN_SCAN_CYCLE_MILLIS = 6000;
    private static final String TAG = "CycledLeScanner";
    protected boolean mBackgroundFlag;
    protected long mBetweenScanPeriod;
    private BluetoothAdapter mBluetoothAdapter;
    protected final BluetoothCrashResolver mBluetoothCrashResolver;
    protected final Context mContext;
    protected final CycledLeScanCallback mCycledLeScanCallback;
    protected final Handler mScanHandler;
    private long mScanPeriod;
    private final HandlerThread mScanThread;
    private boolean mScanning;
    protected boolean mScanningPaused;
    protected final Handler mHandler = new Handler(Looper.getMainLooper());
    protected long mNextScanCycleStartTime = 0;
    protected boolean mRestartNeeded = false;
    private long mLastScanCycleStartTime = 0;
    private long mLastScanCycleEndTime = 0;
    private long mScanCycleStopTime = 0;
    private long mCurrentScanStartTime = 0;
    private boolean mLongScanForcingEnabled = false;
    private boolean mScanCyclerStarted = false;
    private boolean mScanningEnabled = false;
    private boolean mScanningLeftOn = false;
    private volatile boolean mDistinctPacketsDetectedPerScan = false;
    private PendingIntent mWakeUpOperation = null;

    protected abstract boolean deferScanIfNeeded();

    protected abstract void finishScan();

    protected abstract void startScan();

    protected abstract void stopScan();

    /* JADX INFO: Access modifiers changed from: protected */
    public CycledLeScanner(Context context, long j, long j2, boolean z, CycledLeScanCallback cycledLeScanCallback, BluetoothCrashResolver bluetoothCrashResolver) {
        this.mBackgroundFlag = false;
        this.mScanPeriod = j;
        this.mBetweenScanPeriod = j2;
        this.mContext = context;
        this.mCycledLeScanCallback = cycledLeScanCallback;
        this.mBluetoothCrashResolver = bluetoothCrashResolver;
        this.mBackgroundFlag = z;
        HandlerThread handlerThread = new HandlerThread("CycledLeScannerThread");
        this.mScanThread = handlerThread;
        handlerThread.start();
        this.mScanHandler = new Handler(handlerThread.getLooper());
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner.CycledLeScanner createScanner(android.content.Context r14, long r15, long r17, boolean r19, com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner.CycledLeScanCallback r20, com.alibaba.griver.bluetooth.altbeacon.bluetooth.BluetoothCrashResolver r21) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.String r1 = "CycledLeScanner"
            r2 = 0
            r3 = 18
            if (r0 >= r3) goto L12
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r2 = "Not supported prior to API 18."
            com.alibaba.griver.bluetooth.altbeacon.beacon.logging.LogManager.w(r1, r2, r0)
            r0 = 0
            return r0
        L12:
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 21
            r4 = 1
            if (r0 >= r3) goto L21
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r3 = "This is pre Android 5.0.  We are using old scanning APIs"
            com.alibaba.griver.bluetooth.altbeacon.beacon.logging.LogManager.i(r1, r3, r0)
            goto L34
        L21:
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 26
            if (r0 >= r3) goto L3e
            boolean r0 = com.alibaba.griver.bluetooth.altbeacon.beacon.BeaconManager.isAndroidLScanningDisabled()
            if (r0 == 0) goto L36
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r3 = "This is Android 5.0, but L scanning is disabled. We are using old scanning APIs"
            com.alibaba.griver.bluetooth.altbeacon.beacon.logging.LogManager.i(r1, r3, r0)
        L34:
            r4 = 0
            goto L45
        L36:
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r3 = "This is Android 5.0.  We are using new scanning APIs"
            com.alibaba.griver.bluetooth.altbeacon.beacon.logging.LogManager.i(r1, r3, r0)
            goto L47
        L3e:
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r3 = "Using Android O scanner"
            com.alibaba.griver.bluetooth.altbeacon.beacon.logging.LogManager.i(r1, r3, r0)
        L45:
            r2 = r4
            r4 = 0
        L47:
            if (r2 == 0) goto L5a
            com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner.CycledLeScannerForAndroidO r0 = new com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner.CycledLeScannerForAndroidO
            r5 = r0
            r6 = r14
            r7 = r15
            r9 = r17
            r11 = r19
            r12 = r20
            r13 = r21
            r5.<init>(r6, r7, r9, r11, r12, r13)
            return r0
        L5a:
            if (r4 == 0) goto L6d
            com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner.CycledLeScannerForLollipop r0 = new com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner.CycledLeScannerForLollipop
            r1 = r0
            r2 = r14
            r3 = r15
            r5 = r17
            r7 = r19
            r8 = r20
            r9 = r21
            r1.<init>(r2, r3, r5, r7, r8, r9)
            return r0
        L6d:
            com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner.CycledLeScannerForJellyBeanMr2 r0 = new com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner.CycledLeScannerForJellyBeanMr2
            r1 = r0
            r2 = r14
            r3 = r15
            r5 = r17
            r7 = r19
            r8 = r20
            r9 = r21
            r1.<init>(r2, r3, r5, r7, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner.CycledLeScanner.createScanner(android.content.Context, long, long, boolean, com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner.CycledLeScanCallback, com.alibaba.griver.bluetooth.altbeacon.bluetooth.BluetoothCrashResolver):com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner.CycledLeScanner");
    }

    public void setLongScanForcingEnabled(boolean z) {
        this.mLongScanForcingEnabled = z;
    }

    public void setScanPeriods(long j, long j2, boolean z) {
        LogManager.d(TAG, "Set scan periods called with %s, %s Background mode must have changed.", Long.valueOf(j), Long.valueOf(j2));
        if (this.mBackgroundFlag != z) {
            this.mRestartNeeded = true;
        }
        this.mBackgroundFlag = z;
        this.mScanPeriod = j;
        this.mBetweenScanPeriod = j2;
        if (z) {
            LogManager.d(TAG, "We are in the background.  Setting wakeup alarm", new Object[0]);
            setWakeUpAlarm();
        } else {
            LogManager.d(TAG, "We are not in the background.  Cancelling wakeup alarm", new Object[0]);
            cancelWakeUpAlarm();
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = this.mNextScanCycleStartTime;
        if (j3 > elapsedRealtime) {
            long j4 = this.mLastScanCycleEndTime + j2;
            if (j4 < j3) {
                this.mNextScanCycleStartTime = j4;
                LogManager.i(TAG, "Adjusted nextScanStartTime to be %s", new Date((j4 - SystemClock.elapsedRealtime()) + System.currentTimeMillis()));
            }
        }
        long j5 = this.mScanCycleStopTime;
        if (j5 > elapsedRealtime) {
            long j6 = this.mLastScanCycleStartTime + j;
            if (j6 < j5) {
                this.mScanCycleStopTime = j6;
                LogManager.i(TAG, "Adjusted scanStopTime to be %s", Long.valueOf(j6));
            }
        }
    }

    public void start() {
        LogManager.d(TAG, "start called", new Object[0]);
        this.mScanningEnabled = true;
        if (!this.mScanCyclerStarted) {
            scanLeDevice(Boolean.TRUE);
        } else {
            LogManager.d(TAG, "scanning already started", new Object[0]);
        }
    }

    public void stop() {
        LogManager.d(TAG, "stop called", new Object[0]);
        this.mScanningEnabled = false;
        if (this.mScanCyclerStarted) {
            scanLeDevice(Boolean.FALSE);
            if (this.mScanningLeftOn) {
                LogManager.d(TAG, "Stopping scanning previously left on.", new Object[0]);
                this.mScanningLeftOn = false;
                try {
                    LogManager.d(TAG, "stopping bluetooth le scan", new Object[0]);
                    finishScan();
                    return;
                } catch (Exception e) {
                    LogManager.w(e, TAG, "Internal Android exception scanning for beacons", new Object[0]);
                    return;
                }
            }
            return;
        }
        LogManager.d(TAG, "scanning already stopped", new Object[0]);
    }

    public boolean getDistinctPacketsDetectedPerScan() {
        return this.mDistinctPacketsDetectedPerScan;
    }

    public void setDistinctPacketsDetectedPerScan(boolean z) {
        this.mDistinctPacketsDetectedPerScan = z;
    }

    public void destroy() {
        LogManager.d(TAG, "Destroying", new Object[0]);
        this.mHandler.removeCallbacksAndMessages(null);
        this.mScanHandler.post(new Runnable() { // from class: com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner.CycledLeScanner.1
            @Override // java.lang.Runnable
            public void run() {
                LogManager.d(CycledLeScanner.TAG, "Quitting scan thread", new Object[0]);
                CycledLeScanner.this.mScanThread.quit();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(8:14|(3:21|22|23)|24|25|26|(2:28|(3:30|(2:36|(5:38|(1:40)(1:50)|41|42|(1:46))(1:51))(1:34)|35)(1:52))|22|23) */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00d2, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d3, code lost:
    
        com.alibaba.griver.bluetooth.altbeacon.beacon.logging.LogManager.e(r8, com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner.CycledLeScanner.TAG, "Exception starting Bluetooth scan.  Perhaps Bluetooth is disabled or unavailable?", new java.lang.Object[0]);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void scanLeDevice(java.lang.Boolean r8) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner.CycledLeScanner.scanLeDevice(java.lang.Boolean):void");
    }

    protected void scheduleScanCycleStop() {
        long elapsedRealtime = this.mScanCycleStopTime - SystemClock.elapsedRealtime();
        if (this.mScanningEnabled && elapsedRealtime > 0) {
            LogManager.d(TAG, "Waiting to stop scan cycle for another %s milliseconds", Long.valueOf(elapsedRealtime));
            if (this.mBackgroundFlag) {
                setWakeUpAlarm();
            }
            Handler handler = this.mHandler;
            Runnable runnable = new Runnable() { // from class: com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner.CycledLeScanner.2
                @Override // java.lang.Runnable
                public void run() {
                    CycledLeScanner.this.scheduleScanCycleStop();
                }
            };
            if (elapsedRealtime > 1000) {
                elapsedRealtime = 1000;
            }
            handler.postDelayed(runnable, elapsedRealtime);
            return;
        }
        finishScanCycle();
    }

    private void finishScanCycle() {
        LogManager.d(TAG, "Done with scan cycle", new Object[0]);
        try {
            this.mCycledLeScanCallback.onCycleEnd();
            if (this.mScanning) {
                if (getBluetoothAdapter() != null) {
                    if (getBluetoothAdapter().isEnabled()) {
                        if (this.mDistinctPacketsDetectedPerScan && this.mBetweenScanPeriod == 0 && !mustStopScanToPreventAndroidNScanTimeout()) {
                            LogManager.d(TAG, "Not stopping scanning.  Device capable of multiple indistinct detections per scan.", new Object[0]);
                            this.mScanningLeftOn = true;
                            this.mLastScanCycleEndTime = SystemClock.elapsedRealtime();
                        }
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (Build.VERSION.SDK_INT >= 24 && this.mBetweenScanPeriod + this.mScanPeriod < ANDROID_N_MIN_SCAN_CYCLE_MILLIS && elapsedRealtime - this.mLastScanCycleStartTime < ANDROID_N_MIN_SCAN_CYCLE_MILLIS) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Not stopping scan because this is Android N and we keep scanning for a minimum of 6 seconds at a time. We will stop in ");
                            sb.append(ANDROID_N_MIN_SCAN_CYCLE_MILLIS - (elapsedRealtime - this.mLastScanCycleStartTime));
                            sb.append(" millisconds.");
                            LogManager.d(TAG, sb.toString(), new Object[0]);
                            this.mScanningLeftOn = true;
                        } else {
                            try {
                                LogManager.d(TAG, "stopping bluetooth le scan", new Object[0]);
                                finishScan();
                                this.mScanningLeftOn = false;
                            } catch (Exception e) {
                                LogManager.w(e, TAG, "Internal Android exception scanning for beacons", new Object[0]);
                            }
                        }
                        this.mLastScanCycleEndTime = SystemClock.elapsedRealtime();
                    } else {
                        LogManager.d(TAG, "Bluetooth is disabled.  Cannot scan for beacons.", new Object[0]);
                        this.mRestartNeeded = true;
                    }
                }
                this.mNextScanCycleStartTime = getNextScanStartTime();
                if (this.mScanningEnabled) {
                    scanLeDevice(Boolean.TRUE);
                }
            }
            if (this.mScanningEnabled) {
                return;
            }
            LogManager.d(TAG, "Scanning disabled. ", new Object[0]);
            this.mScanCyclerStarted = false;
            cancelWakeUpAlarm();
        } catch (SecurityException unused) {
            LogManager.w(TAG, "SecurityException working accessing bluetooth.", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BluetoothAdapter getBluetoothAdapter() {
        try {
            if (this.mBluetoothAdapter == null) {
                BluetoothAdapter adapter = ((BluetoothManager) this.mContext.getApplicationContext().getSystemService(TinyAppActionState.ACTION_BLUE_TOOTH)).getAdapter();
                this.mBluetoothAdapter = adapter;
                if (adapter == null) {
                    LogManager.w(TAG, "Failed to construct a BluetoothAdapter", new Object[0]);
                }
            }
        } catch (SecurityException unused) {
            LogManager.e(TAG, "Cannot consruct bluetooth adapter.  Security Exception", new Object[0]);
        }
        return this.mBluetoothAdapter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setWakeUpAlarm() {
        long j = this.mBetweenScanPeriod;
        if (300000 >= j) {
            j = 300000;
        }
        long j2 = this.mScanPeriod;
        if (j < j2) {
            j = j2;
        }
        ((AlarmManager) this.mContext.getSystemService("alarm")).set(2, SystemClock.elapsedRealtime() + j, getWakeUpOperation());
        LogManager.d(TAG, "Set a wakeup alarm to go off in %s ms: %s", Long.valueOf(j), getWakeUpOperation());
    }

    protected PendingIntent getWakeUpOperation() {
        if (this.mWakeUpOperation == null) {
            Intent intent = new Intent(this.mContext, StartupBroadcastReceiver.class);
            intent.putExtra("wakeup", true);
            this.mWakeUpOperation = PendingIntent.getBroadcast(this.mContext, 0, intent, 134217728);
        }
        return this.mWakeUpOperation;
    }

    protected void cancelWakeUpAlarm() {
        LogManager.d(TAG, "cancel wakeup alarm: %s", this.mWakeUpOperation);
        ((AlarmManager) this.mContext.getSystemService("alarm")).set(2, LongCompanionObject.MAX_VALUE, getWakeUpOperation());
        LogManager.d(TAG, "Set a wakeup alarm to go off in %s ms: %s", Long.valueOf(LongCompanionObject.MAX_VALUE - SystemClock.elapsedRealtime()), getWakeUpOperation());
    }

    private long getNextScanStartTime() {
        long j = this.mBetweenScanPeriod;
        if (j == 0) {
            return SystemClock.elapsedRealtime();
        }
        long elapsedRealtime = j - (SystemClock.elapsedRealtime() % (this.mScanPeriod + j));
        LogManager.d(TAG, "Normalizing between scan period from %s to %s", Long.valueOf(this.mBetweenScanPeriod), Long.valueOf(elapsedRealtime));
        return SystemClock.elapsedRealtime() + elapsedRealtime;
    }

    private boolean checkLocationPermission() {
        return checkPermission(ManifestPermission.ACCESS_COARSE_LOCATION) || checkPermission("android.permission.ACCESS_FINE_LOCATION");
    }

    private boolean checkPermission(String str) {
        return this.mContext.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean mustStopScanToPreventAndroidNScanTimeout() {
        /*
            r13 = this;
            long r0 = android.os.SystemClock.elapsedRealtime()
            long r2 = r13.mBetweenScanPeriod
            long r4 = r13.mScanPeriod
            int r6 = android.os.Build.VERSION.SDK_INT
            r7 = 1
            r8 = 0
            r9 = 24
            if (r6 < r9) goto L24
            long r9 = r13.mCurrentScanStartTime
            r11 = 0
            int r6 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r6 <= 0) goto L24
            long r0 = r0 + r2
            long r0 = r0 + r4
            long r0 = r0 - r9
            r2 = 1800000(0x1b7740, double:8.89318E-318)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L24
            r0 = 1
            goto L25
        L24:
            r0 = 0
        L25:
            if (r0 == 0) goto L43
            java.lang.Object[] r0 = new java.lang.Object[r8]
            java.lang.String r1 = "CycledLeScanner"
            java.lang.String r2 = "The next scan cycle would go over the Android N max duration."
            com.alibaba.griver.bluetooth.altbeacon.beacon.logging.LogManager.d(r1, r2, r0)
            boolean r0 = r13.mLongScanForcingEnabled
            if (r0 == 0) goto L3c
            java.lang.Object[] r0 = new java.lang.Object[r8]
            java.lang.String r2 = "Stopping scan to prevent Android N scan timeout."
            com.alibaba.griver.bluetooth.altbeacon.beacon.logging.LogManager.d(r1, r2, r0)
            return r7
        L3c:
            java.lang.Object[] r0 = new java.lang.Object[r8]
            java.lang.String r2 = "Allowing a long running scan to be stopped by the OS.  To prevent this, set longScanForcingEnabled in the AndroidBeaconLibrary."
            com.alibaba.griver.bluetooth.altbeacon.beacon.logging.LogManager.w(r1, r2, r0)
        L43:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner.CycledLeScanner.mustStopScanToPreventAndroidNScanTimeout():boolean");
    }
}
