package com.alibaba.griver.bluetooth.altbeacon.beacon.service;

import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.alibaba.griver.bluetooth.altbeacon.beacon.Beacon;
import com.alibaba.griver.bluetooth.altbeacon.beacon.BeaconManager;
import com.alibaba.griver.bluetooth.altbeacon.beacon.Region;
import com.alibaba.griver.bluetooth.altbeacon.beacon.distance.ModelSpecificDistanceCalculator;
import com.alibaba.griver.bluetooth.altbeacon.beacon.logging.LogManager;
import com.alibaba.griver.bluetooth.altbeacon.beacon.utils.ProcessUtils;
import com.alibaba.griver.bluetooth.altbeacon.bluetooth.BluetoothCrashResolver;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes6.dex */
public class BeaconService {
    public static final int MSG_SET_SCAN_PERIODS = 6;
    public static final int MSG_START_MONITORING = 4;
    public static final int MSG_START_RANGING = 2;
    public static final int MSG_STOP_MONITORING = 5;
    public static final int MSG_STOP_RANGING = 3;
    public static final int MSG_SYNC_SETTINGS = 7;
    public static final String TAG = "BeaconService";
    private BluetoothCrashResolver bluetoothCrashResolver;
    Context context;
    private ScanHelper mScanHelper;
    final Messenger mMessenger = new Messenger(new IncomingHandler(this));
    private final Handler handler = new Handler();

    public BeaconService(Context context) {
        this.context = context;
        onCreate(context);
    }

    public Context getContext() {
        return this.context;
    }

    public Messenger getmMessenger() {
        return this.mMessenger;
    }

    public void onCreate(Context context) {
        BluetoothCrashResolver bluetoothCrashResolver = new BluetoothCrashResolver(context);
        this.bluetoothCrashResolver = bluetoothCrashResolver;
        bluetoothCrashResolver.start();
        ScanHelper scanHelper = new ScanHelper(context);
        this.mScanHelper = scanHelper;
        if (scanHelper.getCycledScanner() == null) {
            this.mScanHelper.createCycledLeScanner(false, this.bluetoothCrashResolver);
        }
        this.mScanHelper.setMonitoringStatus(MonitoringStatus.getInstanceForApplication(context));
        this.mScanHelper.setRangedRegionState(new HashMap());
        this.mScanHelper.setBeaconParsers(new HashSet());
        this.mScanHelper.setExtraDataBeaconTracker(new ExtraDataBeaconTracker());
        BeaconManager instanceForApplication = BeaconManager.getInstanceForApplication(context);
        instanceForApplication.setScannerInSameProcess(false);
        if (instanceForApplication.isMainProcess()) {
            LogManager.i(TAG, "beaconService version %s is starting up on the main process", "1.0");
        } else {
            LogManager.i(TAG, "beaconService version %s is starting up on a separate process", "1.0");
            ProcessUtils processUtils = new ProcessUtils(context);
            StringBuilder sb = new StringBuilder();
            sb.append("beaconService PID is ");
            sb.append(processUtils.getPid());
            sb.append(" with process name ");
            sb.append(processUtils.getProcessName());
            LogManager.i(TAG, sb.toString(), new Object[0]);
        }
        this.mScanHelper.reloadParsers();
        Beacon.setDistanceCalculator(new ModelSpecificDistanceCalculator(context, BeaconManager.getDistanceModelUpdateUrl()));
        try {
            this.mScanHelper.setSimulatedScanData((List) Class.forName("org.com.alibaba.griver.bluetooth.altbeacon.beacon.SimulatedScanData").getField("beacons").get(null));
        } catch (ClassNotFoundException unused) {
            LogManager.d(TAG, "No org.com.alibaba.griver.bluetooth.altbeacon.beacon.SimulatedScanData class exists.", new Object[0]);
        } catch (Exception e) {
            LogManager.e(e, TAG, "Cannot get simulated Scan data.  Make sure your org.com.alibaba.griver.bluetooth.altbeacon.beacon.SimulatedScanData class defines a field with the signature 'public static List<Beacon> beacons'", new Object[0]);
        }
    }

    public void destroy() {
        LogManager.e(TAG, "destroy()", new Object[0]);
        if (Build.VERSION.SDK_INT < 18) {
            LogManager.w(TAG, "Not supported prior to API 18.", new Object[0]);
            return;
        }
        this.bluetoothCrashResolver.stop();
        LogManager.i(TAG, "destroy called.  stopping scanning", new Object[0]);
        this.handler.removeCallbacksAndMessages(null);
        this.mScanHelper.getCycledScanner().stop();
        this.mScanHelper.getCycledScanner().destroy();
        this.mScanHelper.getMonitoringStatus().stopStatusPreservation();
    }

    public void startRangingBeaconsInRegion(Region region, Callback callback) {
        synchronized (this.mScanHelper.getRangedRegionState()) {
            if (this.mScanHelper.getRangedRegionState().containsKey(region)) {
                LogManager.i(TAG, "Already ranging that region -- will replace existing region.", new Object[0]);
                this.mScanHelper.getRangedRegionState().remove(region);
            }
            this.mScanHelper.getRangedRegionState().put(region, new RangeState(callback));
            LogManager.d(TAG, "Currently ranging %s regions.", Integer.valueOf(this.mScanHelper.getRangedRegionState().size()));
        }
        this.mScanHelper.getCycledScanner().start();
    }

    public void stopRangingBeaconsInRegion(Region region) {
        int size;
        synchronized (this.mScanHelper.getRangedRegionState()) {
            this.mScanHelper.getRangedRegionState().remove(region);
            size = this.mScanHelper.getRangedRegionState().size();
            LogManager.d(TAG, "Currently ranging %s regions.", Integer.valueOf(this.mScanHelper.getRangedRegionState().size()));
        }
        if (size == 0 && this.mScanHelper.getMonitoringStatus().regionsCount() == 0) {
            this.mScanHelper.getCycledScanner().stop();
        }
    }

    public void startMonitoringBeaconsInRegion(Region region, Callback callback) {
        LogManager.d(TAG, "startMonitoring called", new Object[0]);
        this.mScanHelper.getMonitoringStatus().addRegion(region, callback);
        LogManager.d(TAG, "Currently monitoring %s regions.", Integer.valueOf(this.mScanHelper.getMonitoringStatus().regionsCount()));
        this.mScanHelper.getCycledScanner().start();
    }

    public void stopMonitoringBeaconsInRegion(Region region) {
        LogManager.d(TAG, "stopMonitoring called", new Object[0]);
        this.mScanHelper.getMonitoringStatus().removeRegion(region);
        LogManager.d(TAG, "Currently monitoring %s regions.", Integer.valueOf(this.mScanHelper.getMonitoringStatus().regionsCount()));
        if (this.mScanHelper.getMonitoringStatus().regionsCount() == 0 && this.mScanHelper.getRangedRegionState().size() == 0) {
            this.mScanHelper.getCycledScanner().stop();
        }
    }

    public void setScanPeriods(long j, long j2, boolean z) {
        this.mScanHelper.getCycledScanner().setScanPeriods(j, j2, z);
    }

    public void reloadParsers() {
        this.mScanHelper.reloadParsers();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class IncomingHandler extends Handler {
        private final WeakReference<BeaconService> mService;

        IncomingHandler(BeaconService beaconService) {
            super(Looper.getMainLooper());
            this.mService = new WeakReference<>(beaconService);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            BeaconService beaconService = this.mService.get();
            if (beaconService != null) {
                StartRMData fromBundle = StartRMData.fromBundle(message.getData());
                if (fromBundle != null) {
                    int i = message.what;
                    if (i == 2) {
                        LogManager.i(BeaconService.TAG, "start ranging received", new Object[0]);
                        beaconService.startRangingBeaconsInRegion(fromBundle.getRegionData(), new Callback(fromBundle.getCallbackPackageName()));
                        beaconService.setScanPeriods(fromBundle.getScanPeriod(), fromBundle.getBetweenScanPeriod(), fromBundle.getBackgroundFlag());
                    } else if (i == 3) {
                        LogManager.i(BeaconService.TAG, "stop ranging received", new Object[0]);
                        beaconService.stopRangingBeaconsInRegion(fromBundle.getRegionData());
                        beaconService.setScanPeriods(fromBundle.getScanPeriod(), fromBundle.getBetweenScanPeriod(), fromBundle.getBackgroundFlag());
                    } else if (i == 4) {
                        LogManager.i(BeaconService.TAG, "start monitoring received", new Object[0]);
                        beaconService.startMonitoringBeaconsInRegion(fromBundle.getRegionData(), new Callback(fromBundle.getCallbackPackageName()));
                        beaconService.setScanPeriods(fromBundle.getScanPeriod(), fromBundle.getBetweenScanPeriod(), fromBundle.getBackgroundFlag());
                    } else if (i == 5) {
                        LogManager.i(BeaconService.TAG, "stop monitoring received", new Object[0]);
                        beaconService.stopMonitoringBeaconsInRegion(fromBundle.getRegionData());
                        beaconService.setScanPeriods(fromBundle.getScanPeriod(), fromBundle.getBetweenScanPeriod(), fromBundle.getBackgroundFlag());
                    } else if (i == 6) {
                        LogManager.i(BeaconService.TAG, "set scan intervals received", new Object[0]);
                        beaconService.setScanPeriods(fromBundle.getScanPeriod(), fromBundle.getBetweenScanPeriod(), fromBundle.getBackgroundFlag());
                    } else {
                        super.handleMessage(message);
                    }
                } else if (message.what == 7) {
                    LogManager.i(BeaconService.TAG, "Received settings update from other process", new Object[0]);
                    SettingsData fromBundle2 = SettingsData.fromBundle(message.getData());
                    if (fromBundle2 != null) {
                        fromBundle2.apply(beaconService);
                    } else {
                        LogManager.w(BeaconService.TAG, "Settings data missing", new Object[0]);
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Received unknown message from other process : ");
                    sb.append(message.what);
                    LogManager.i(BeaconService.TAG, sb.toString(), new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class BeaconBinder extends Binder {
        public BeaconBinder() {
            BeaconService.this = r1;
        }

        public BeaconService getService() {
            LogManager.i(BeaconService.TAG, "getService of BeaconBinder called", new Object[0]);
            return BeaconService.this;
        }
    }
}
