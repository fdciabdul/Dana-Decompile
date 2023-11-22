package com.alibaba.griver.bluetooth.altbeacon.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.SystemClock;
import com.alibaba.griver.bluetooth.altbeacon.beacon.logging.LogManager;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RangedBeacon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes6.dex */
public class BluetoothCrashResolver {
    private static final int BLUEDROID_MAX_BLUETOOTH_MAC_COUNT = 1990;
    private static final int BLUEDROID_POST_DISCOVERY_ESTIMATED_BLUETOOTH_MAC_COUNT = 400;
    private static final String DISTINCT_BLUETOOTH_ADDRESSES_FILE = "BluetoothCrashResolverState.txt";
    private static final long MIN_TIME_BETWEEN_STATE_SAVES_MILLIS = 60000;
    private static final boolean PREEMPTIVE_ACTION_ENABLED = true;
    private static final long SUSPICIOUSLY_SHORT_BLUETOOTH_OFF_INTERVAL_MILLIS = 600;
    private static final String TAG = "BluetoothCrashResolver";
    private static final int TIME_TO_LET_DISCOVERY_RUN_MILLIS = 5000;
    private Context context;
    private UpdateNotifier updateNotifier;
    private final Set<String> distinctBluetoothAddresses = new HashSet();
    private boolean recoveryInProgress = false;
    private boolean discoveryStartConfirmed = false;
    private long lastBluetoothOffTime = 0;
    private long lastBluetoothTurningOnTime = 0;
    private long lastBluetoothCrashDetectionTime = 0;
    private int detectedCrashCount = 0;
    private int recoveryAttemptCount = 0;
    private boolean lastRecoverySucceeded = false;
    private long lastStateSaveTime = 0;
    private final BroadcastReceiver receiver = new BroadcastReceiver() { // from class: com.alibaba.griver.bluetooth.altbeacon.bluetooth.BluetoothCrashResolver.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("android.bluetooth.adapter.action.DISCOVERY_FINISHED")) {
                if (BluetoothCrashResolver.this.recoveryInProgress) {
                    LogManager.d(BluetoothCrashResolver.TAG, "Bluetooth discovery finished", new Object[0]);
                    BluetoothCrashResolver.this.finishRecovery();
                } else {
                    LogManager.d(BluetoothCrashResolver.TAG, "Bluetooth discovery finished (external)", new Object[0]);
                }
            }
            if (action.equals("android.bluetooth.adapter.action.DISCOVERY_STARTED")) {
                if (BluetoothCrashResolver.this.recoveryInProgress) {
                    BluetoothCrashResolver.this.discoveryStartConfirmed = true;
                    LogManager.d(BluetoothCrashResolver.TAG, "Bluetooth discovery started", new Object[0]);
                } else {
                    LogManager.d(BluetoothCrashResolver.TAG, "Bluetooth discovery started (external)", new Object[0]);
                }
            }
            if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
                if (intExtra == Integer.MIN_VALUE) {
                    LogManager.d(BluetoothCrashResolver.TAG, "Bluetooth state is ERROR", new Object[0]);
                    return;
                }
                switch (intExtra) {
                    case 10:
                        LogManager.d(BluetoothCrashResolver.TAG, "Bluetooth state is OFF", new Object[0]);
                        BluetoothCrashResolver.this.lastBluetoothOffTime = SystemClock.elapsedRealtime();
                        return;
                    case 11:
                        BluetoothCrashResolver.this.lastBluetoothTurningOnTime = SystemClock.elapsedRealtime();
                        LogManager.d(BluetoothCrashResolver.TAG, "Bluetooth state is TURNING_ON", new Object[0]);
                        return;
                    case 12:
                        LogManager.d(BluetoothCrashResolver.TAG, "Bluetooth state is ON", new Object[0]);
                        LogManager.d(BluetoothCrashResolver.TAG, "Bluetooth was turned off for %s milliseconds", Long.valueOf(BluetoothCrashResolver.this.lastBluetoothTurningOnTime - BluetoothCrashResolver.this.lastBluetoothOffTime));
                        if (BluetoothCrashResolver.this.lastBluetoothTurningOnTime - BluetoothCrashResolver.this.lastBluetoothOffTime < BluetoothCrashResolver.SUSPICIOUSLY_SHORT_BLUETOOTH_OFF_INTERVAL_MILLIS) {
                            BluetoothCrashResolver.this.crashDetected();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface UpdateNotifier {
        void dataUpdated();
    }

    private int getCrashRiskDeviceCount() {
        return 1590;
    }

    @Deprecated
    public void disableDebug() {
    }

    @Deprecated
    public void enableDebug() {
    }

    public BluetoothCrashResolver(Context context) {
        this.context = null;
        this.context = context.getApplicationContext();
        LogManager.d(TAG, "constructed", new Object[0]);
        loadState();
    }

    public void start() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_STARTED");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        this.context.registerReceiver(this.receiver, intentFilter);
        LogManager.d(TAG, "started listening for BluetoothAdapter events", new Object[0]);
    }

    public void stop() {
        this.context.unregisterReceiver(this.receiver);
        LogManager.d(TAG, "stopped listening for BluetoothAdapter events", new Object[0]);
        saveState();
    }

    public void notifyScannedDevice(BluetoothDevice bluetoothDevice, BluetoothAdapter.LeScanCallback leScanCallback) {
        int size = this.distinctBluetoothAddresses.size();
        synchronized (this.distinctBluetoothAddresses) {
            this.distinctBluetoothAddresses.add(bluetoothDevice.getAddress());
        }
        int size2 = this.distinctBluetoothAddresses.size();
        if (size != size2 && size2 % 100 == 0) {
            LogManager.d(TAG, "Distinct Bluetooth devices seen: %s", Integer.valueOf(this.distinctBluetoothAddresses.size()));
        }
        if (this.distinctBluetoothAddresses.size() <= getCrashRiskDeviceCount() || this.recoveryInProgress) {
            return;
        }
        LogManager.w(TAG, "Large number of Bluetooth devices detected: %s Proactively attempting to clear out address list to prevent a crash", Integer.valueOf(this.distinctBluetoothAddresses.size()));
        LogManager.w(TAG, "Stopping LE Scan", new Object[0]);
        BluetoothAdapter.getDefaultAdapter().stopLeScan(leScanCallback);
        startRecovery();
        processStateChange();
    }

    public void crashDetected() {
        if (Build.VERSION.SDK_INT < 18) {
            LogManager.d(TAG, "Ignoring crashes before API 18, because BLE is unsupported.", new Object[0]);
            return;
        }
        LogManager.w(TAG, "BluetoothService crash detected", new Object[0]);
        if (this.distinctBluetoothAddresses.size() > 0) {
            LogManager.d(TAG, "Distinct Bluetooth devices seen at crash: %s", Integer.valueOf(this.distinctBluetoothAddresses.size()));
        }
        this.lastBluetoothCrashDetectionTime = SystemClock.elapsedRealtime();
        this.detectedCrashCount++;
        if (this.recoveryInProgress) {
            LogManager.d(TAG, "Ignoring Bluetooth crash because recovery is already in progress.", new Object[0]);
        } else {
            startRecovery();
        }
        processStateChange();
    }

    public long getLastBluetoothCrashDetectionTime() {
        return this.lastBluetoothCrashDetectionTime;
    }

    public int getDetectedCrashCount() {
        return this.detectedCrashCount;
    }

    public int getRecoveryAttemptCount() {
        return this.recoveryAttemptCount;
    }

    public boolean isLastRecoverySucceeded() {
        return this.lastRecoverySucceeded;
    }

    public boolean isRecoveryInProgress() {
        return this.recoveryInProgress;
    }

    public void setUpdateNotifier(UpdateNotifier updateNotifier) {
        this.updateNotifier = updateNotifier;
    }

    public void forceFlush() {
        startRecovery();
        processStateChange();
    }

    private void processStateChange() {
        UpdateNotifier updateNotifier = this.updateNotifier;
        if (updateNotifier != null) {
            updateNotifier.dataUpdated();
        }
        if (SystemClock.elapsedRealtime() - this.lastStateSaveTime > 60000) {
            saveState();
        }
    }

    private void startRecovery() {
        this.recoveryAttemptCount++;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        LogManager.d(TAG, "about to check if discovery is active", new Object[0]);
        if (!defaultAdapter.isDiscovering()) {
            LogManager.w(TAG, "Recovery attempt started", new Object[0]);
            this.recoveryInProgress = true;
            this.discoveryStartConfirmed = false;
            LogManager.d(TAG, "about to command discovery", new Object[0]);
            if (!defaultAdapter.startDiscovery()) {
                LogManager.w(TAG, "Can't start discovery.  Is Bluetooth turned on?", new Object[0]);
            }
            LogManager.d(TAG, "startDiscovery commanded.  isDiscovering()=%s", Boolean.valueOf(defaultAdapter.isDiscovering()));
            LogManager.d(TAG, "We will be cancelling this discovery in %s milliseconds.", 5000);
            cancelDiscovery();
            return;
        }
        LogManager.w(TAG, "Already discovering.  Recovery attempt abandoned.", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishRecovery() {
        LogManager.w(TAG, "Recovery attempt finished", new Object[0]);
        synchronized (this.distinctBluetoothAddresses) {
            this.distinctBluetoothAddresses.clear();
        }
        this.recoveryInProgress = false;
    }

    private void saveState() {
        OutputStreamWriter outputStreamWriter;
        this.lastStateSaveTime = SystemClock.elapsedRealtime();
        OutputStreamWriter outputStreamWriter2 = null;
        try {
            try {
                outputStreamWriter = new OutputStreamWriter(this.context.openFileOutput(DISTINCT_BLUETOOTH_ADDRESSES_FILE, 0));
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.lastBluetoothCrashDetectionTime);
                    sb.append("\n");
                    outputStreamWriter.write(sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.detectedCrashCount);
                    sb2.append("\n");
                    outputStreamWriter.write(sb2.toString());
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(this.recoveryAttemptCount);
                    sb3.append("\n");
                    outputStreamWriter.write(sb3.toString());
                    outputStreamWriter.write(this.lastRecoverySucceeded ? "1\n" : "0\n");
                    synchronized (this.distinctBluetoothAddresses) {
                        Iterator<String> it = this.distinctBluetoothAddresses.iterator();
                        while (it.hasNext()) {
                            outputStreamWriter.write(it.next());
                            outputStreamWriter.write("\n");
                        }
                    }
                    try {
                        outputStreamWriter.close();
                    } catch (IOException unused) {
                        LogManager.e(TAG, "close writer exception", new Object[0]);
                    }
                } catch (IOException unused2) {
                    outputStreamWriter2 = outputStreamWriter;
                    LogManager.w(TAG, "Can't write macs to %s", DISTINCT_BLUETOOTH_ADDRESSES_FILE);
                    if (outputStreamWriter2 != null) {
                        try {
                            outputStreamWriter2.close();
                        } catch (IOException unused3) {
                            LogManager.e(TAG, "close writer exception", new Object[0]);
                        }
                    }
                    LogManager.d(TAG, "Wrote %s Bluetooth addresses", Integer.valueOf(this.distinctBluetoothAddresses.size()));
                } catch (Throwable th) {
                    th = th;
                    if (outputStreamWriter != null) {
                        try {
                            outputStreamWriter.close();
                        } catch (IOException unused4) {
                            LogManager.e(TAG, "close writer exception", new Object[0]);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                outputStreamWriter = outputStreamWriter2;
            }
        } catch (IOException unused5) {
        }
        LogManager.d(TAG, "Wrote %s Bluetooth addresses", Integer.valueOf(this.distinctBluetoothAddresses.size()));
    }

    private void loadState() {
        BufferedReader bufferedReader;
        String readLine;
        String str = "close reader exception";
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(this.context.openFileInput(DISTINCT_BLUETOOTH_ADDRESSES_FILE)));
            } catch (IOException unused) {
            } catch (NumberFormatException unused2) {
            }
            try {
                String readLine2 = bufferedReader.readLine();
                if (readLine2 != null) {
                    this.lastBluetoothCrashDetectionTime = Long.parseLong(readLine2);
                }
                String readLine3 = bufferedReader.readLine();
                if (readLine3 != null) {
                    this.detectedCrashCount = Integer.parseInt(readLine3);
                }
                String readLine4 = bufferedReader.readLine();
                if (readLine4 != null) {
                    this.recoveryAttemptCount = Integer.parseInt(readLine4);
                }
                String readLine5 = bufferedReader.readLine();
                if (readLine5 != null) {
                    this.lastRecoverySucceeded = false;
                    if (readLine5.equals("1")) {
                        this.lastRecoverySucceeded = true;
                    }
                }
                while (true) {
                    readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        this.distinctBluetoothAddresses.add(readLine);
                    } else {
                        try {
                            break;
                        } catch (IOException unused3) {
                            LogManager.e(TAG, "close reader exception", new Object[0]);
                            bufferedReader2 = readLine;
                        }
                    }
                }
                bufferedReader.close();
                bufferedReader2 = readLine;
            } catch (IOException unused4) {
                bufferedReader2 = bufferedReader;
                LogManager.w(TAG, "Can't read macs from %s", DISTINCT_BLUETOOTH_ADDRESSES_FILE);
                bufferedReader2 = bufferedReader2;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                        bufferedReader2 = bufferedReader2;
                    } catch (IOException unused5) {
                        LogManager.e(TAG, "close reader exception", new Object[0]);
                        bufferedReader2 = bufferedReader2;
                    }
                }
                str = "Read %s Bluetooth addresses";
                LogManager.d(TAG, "Read %s Bluetooth addresses", Integer.valueOf(this.distinctBluetoothAddresses.size()));
            } catch (NumberFormatException unused6) {
                bufferedReader2 = bufferedReader;
                LogManager.w(TAG, "Can't parse file %s", DISTINCT_BLUETOOTH_ADDRESSES_FILE);
                bufferedReader2 = bufferedReader2;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                        bufferedReader2 = bufferedReader2;
                    } catch (IOException unused7) {
                        LogManager.e(TAG, "close reader exception", new Object[0]);
                        bufferedReader2 = bufferedReader2;
                    }
                }
                str = "Read %s Bluetooth addresses";
                LogManager.d(TAG, "Read %s Bluetooth addresses", Integer.valueOf(this.distinctBluetoothAddresses.size()));
            } catch (Throwable th) {
                th = th;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused8) {
                        LogManager.e(TAG, str, new Object[0]);
                    }
                }
                throw th;
            }
            str = "Read %s Bluetooth addresses";
            LogManager.d(TAG, "Read %s Bluetooth addresses", Integer.valueOf(this.distinctBluetoothAddresses.size()));
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = bufferedReader2;
        }
    }

    private void cancelDiscovery() {
        try {
            Thread.sleep(RangedBeacon.DEFAULT_MAX_TRACKING_AGE);
            if (!this.discoveryStartConfirmed) {
                LogManager.w(TAG, "BluetoothAdapter.ACTION_DISCOVERY_STARTED never received.  Recovery may fail.", new Object[0]);
            }
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter.isDiscovering()) {
                LogManager.d(TAG, "Cancelling discovery", new Object[0]);
                defaultAdapter.cancelDiscovery();
                return;
            }
            LogManager.d(TAG, "Discovery not running.  Won't cancel it", new Object[0]);
        } catch (InterruptedException unused) {
            LogManager.d(TAG, "DiscoveryCanceller sleep interrupted.", new Object[0]);
        }
    }
}
