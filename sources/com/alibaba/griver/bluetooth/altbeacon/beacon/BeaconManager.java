package com.alibaba.griver.bluetooth.altbeacon.beacon;

import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Build;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.alibaba.griver.bluetooth.altbeacon.beacon.logging.LogManager;
import com.alibaba.griver.bluetooth.altbeacon.beacon.logging.Loggers;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.BeaconService;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.Callback;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.MonitoringStatus;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RangeState;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RangedBeacon;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RegionMonitoringState;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RunningAverageRssiFilter;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.ScanJobScheduler;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.SettingsData;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.StartRMData;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner.NonBeaconLeScanCallback;
import com.alibaba.griver.bluetooth.altbeacon.beacon.simulator.BeaconSimulator;
import com.alibaba.griver.bluetooth.altbeacon.beacon.utils.ProcessUtils;
import com.alibaba.griver.ui.popmenu.TinyAppActionState;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes6.dex */
public class BeaconManager {
    public static final long DEFAULT_BACKGROUND_BETWEEN_SCAN_PERIOD = 300000;
    public static final long DEFAULT_BACKGROUND_SCAN_PERIOD = 10000;
    public static final long DEFAULT_EXIT_PERIOD = 10000;
    public static final long DEFAULT_FOREGROUND_BETWEEN_SCAN_PERIOD = 0;
    public static final long DEFAULT_FOREGROUND_SCAN_PERIOD = 1100;
    private static final String TAG = "BeaconManager";
    protected static BeaconSimulator beaconSimulator = null;
    protected static String distanceModelUpdateUrl = "";
    protected static volatile BeaconManager sInstance;
    private long backgroundBetweenScanPeriod;
    private long backgroundScanPeriod;
    private final List<BeaconParser> beaconParsers;
    private BeaconService beaconService;
    protected RangeNotifier dataRequestNotifier;
    private long foregroundBetweenScanPeriod;
    private long foregroundScanPeriod;
    private boolean mBackgroundMode;
    private boolean mBackgroundModeUninitialized;
    private Context mContext;
    private boolean mMainProcess;
    private NonBeaconLeScanCallback mNonBeaconLeScanCallback;
    private boolean mRegionStatePersistenceEnabled;
    private Boolean mScannerInSameProcess;
    private boolean mScheduledScanJobsEnabled;
    private Messenger serviceMessenger;
    private static final Object SINGLETON_LOCK = new Object();
    protected static Class rssiFilterImplClass = RunningAverageRssiFilter.class;
    private static boolean sAndroidLScanningDisabled = false;
    private static boolean sManifestCheckingDisabled = false;
    private static long sExitRegionPeriod = 10000;
    protected final Set<RangeNotifier> rangeNotifiers = new CopyOnWriteArraySet();
    protected final Set<MonitorNotifier> monitorNotifiers = new CopyOnWriteArraySet();
    private final ConcurrentMap<BeaconConsumer, ConsumerInfo> consumers = new ConcurrentHashMap();
    private final ArrayList<Region> rangedRegions = new ArrayList<>();

    private void verifyServiceDeclaration() {
    }

    protected BeaconManager(Context context) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.beaconParsers = copyOnWriteArrayList;
        this.dataRequestNotifier = null;
        this.serviceMessenger = null;
        this.mRegionStatePersistenceEnabled = true;
        this.mBackgroundMode = false;
        this.mBackgroundModeUninitialized = true;
        this.mMainProcess = false;
        this.mScannerInSameProcess = null;
        this.mScheduledScanJobsEnabled = false;
        this.foregroundScanPeriod = DEFAULT_FOREGROUND_SCAN_PERIOD;
        this.foregroundBetweenScanPeriod = 0L;
        this.backgroundScanPeriod = 10000L;
        this.backgroundBetweenScanPeriod = 300000L;
        this.mContext = context.getApplicationContext();
        checkIfMainProcess();
        if (!sManifestCheckingDisabled) {
            verifyServiceDeclaration();
        }
        copyOnWriteArrayList.add(new AltBeaconParser());
    }

    @Deprecated
    public static void setDebug(boolean z) {
        if (z) {
            LogManager.setLogger(Loggers.verboseLogger());
            LogManager.setVerboseLoggingEnabled(true);
            return;
        }
        LogManager.setLogger(Loggers.empty());
        LogManager.setVerboseLoggingEnabled(false);
    }

    public static long getRegionExitPeriod() {
        return sExitRegionPeriod;
    }

    public static void setRegionExitPeriod(long j) {
        sExitRegionPeriod = j;
        BeaconManager beaconManager = sInstance;
        if (beaconManager != null) {
            beaconManager.applySettings();
        }
    }

    public static BeaconManager getInstanceForApplication(Context context) {
        BeaconManager beaconManager;
        BeaconManager beaconManager2 = sInstance;
        if (beaconManager2 == null) {
            synchronized (SINGLETON_LOCK) {
                beaconManager = sInstance;
                if (beaconManager == null) {
                    beaconManager = new BeaconManager(context);
                    sInstance = beaconManager;
                }
            }
            return beaconManager;
        }
        return beaconManager2;
    }

    @Deprecated
    public static void logDebug(String str, String str2) {
        LogManager.d(str, str2, new Object[0]);
    }

    @Deprecated
    public static void logDebug(String str, String str2, Throwable th) {
        LogManager.d(th, str, str2, new Object[0]);
    }

    public static String getDistanceModelUpdateUrl() {
        return distanceModelUpdateUrl;
    }

    public static void setDistanceModelUpdateUrl(String str) {
        warnIfScannerNotInSameProcess();
        distanceModelUpdateUrl = str;
    }

    public static Class getRssiFilterImplClass() {
        return rssiFilterImplClass;
    }

    public static void setRssiFilterImplClass(Class cls) {
        warnIfScannerNotInSameProcess();
        rssiFilterImplClass = cls;
    }

    public static void setUseTrackingCache(boolean z) {
        RangeState.setUseTrackingCache(z);
        if (sInstance != null) {
            sInstance.applySettings();
        }
    }

    public static BeaconSimulator getBeaconSimulator() {
        return beaconSimulator;
    }

    public static void setBeaconSimulator(BeaconSimulator beaconSimulator2) {
        warnIfScannerNotInSameProcess();
        beaconSimulator = beaconSimulator2;
    }

    public static boolean isAndroidLScanningDisabled() {
        return sAndroidLScanningDisabled;
    }

    public static void setAndroidLScanningDisabled(boolean z) {
        sAndroidLScanningDisabled = z;
        BeaconManager beaconManager = sInstance;
        if (beaconManager != null) {
            beaconManager.applySettings();
        }
    }

    @Deprecated
    public static void setsManifestCheckingDisabled(boolean z) {
        sManifestCheckingDisabled = z;
    }

    public static boolean getManifestCheckingDisabled() {
        return sManifestCheckingDisabled;
    }

    public static void setManifestCheckingDisabled(boolean z) {
        sManifestCheckingDisabled = z;
    }

    private static void warnIfScannerNotInSameProcess() {
        BeaconManager beaconManager = sInstance;
        if (beaconManager == null || !beaconManager.isScannerInDifferentProcess()) {
            return;
        }
        LogManager.w(TAG, "Unsupported configuration change made for BeaconScanner in separate process", new Object[0]);
    }

    public boolean isMainProcess() {
        return this.mMainProcess;
    }

    public boolean isScannerInDifferentProcess() {
        Boolean bool = this.mScannerInSameProcess;
        return (bool == null || bool.booleanValue()) ? false : true;
    }

    public void setScannerInSameProcess(boolean z) {
        this.mScannerInSameProcess = Boolean.valueOf(z);
    }

    protected void checkIfMainProcess() {
        ProcessUtils processUtils = new ProcessUtils(this.mContext);
        String processName = processUtils.getProcessName();
        String packageName = processUtils.getPackageName();
        int pid = processUtils.getPid();
        this.mMainProcess = processUtils.isMainProcess();
        StringBuilder sb = new StringBuilder();
        sb.append("BeaconManager started up on pid ");
        sb.append(pid);
        sb.append(" named '");
        sb.append(processName);
        sb.append("' for application package '");
        sb.append(packageName);
        sb.append("'.  isMainProcess=");
        sb.append(this.mMainProcess);
        LogManager.i(TAG, sb.toString(), new Object[0]);
    }

    public List<BeaconParser> getBeaconParsers() {
        return this.beaconParsers;
    }

    public boolean checkAvailability() throws BleNotAvailableException {
        if (!isBleAvailable()) {
            throw new BleNotAvailableException("Bluetooth LE not supported by this device");
        }
        return ((BluetoothManager) this.mContext.getSystemService(TinyAppActionState.ACTION_BLUE_TOOTH)).getAdapter().isEnabled();
    }

    public void bind(BeaconConsumer beaconConsumer) {
        if (!isBleAvailable()) {
            LogManager.w(TAG, "Method invocation will be ignored.", new Object[0]);
        } else if (!this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            LogManager.w(TAG, "This device does not support bluetooth LE.  Will not start beacon scanning.", new Object[0]);
        } else {
            synchronized (this.consumers) {
                ConsumerInfo consumerInfo = new ConsumerInfo();
                if (this.consumers.putIfAbsent(beaconConsumer, consumerInfo) != null) {
                    LogManager.d(TAG, "This consumer is already bound", new Object[0]);
                } else {
                    LogManager.d(TAG, "This consumer is not bound.  Binding now: %s", beaconConsumer);
                    if (this.mScheduledScanJobsEnabled) {
                        LogManager.d(TAG, "Not starting beacon scanning service. Using scheduled jobs", new Object[0]);
                        beaconConsumer.onBeaconServiceConnect();
                    } else {
                        LogManager.d(TAG, "Binding to service", new Object[0]);
                        this.beaconService = new BeaconService(this.mContext);
                        consumerInfo.beaconServiceConnection.onServiceConnected(this.beaconService);
                    }
                    LogManager.d(TAG, "consumer count is now: %s", Integer.valueOf(this.consumers.size()));
                }
            }
        }
    }

    public void unbind(BeaconConsumer beaconConsumer) {
        if (!isBleAvailable()) {
            LogManager.w(TAG, "Method invocation will be ignored.", new Object[0]);
            return;
        }
        synchronized (this.consumers) {
            if (this.consumers.containsKey(beaconConsumer)) {
                LogManager.d(TAG, "Unbinding", new Object[0]);
                if (this.mScheduledScanJobsEnabled) {
                    LogManager.d(TAG, "Not unbinding from scanning service as we are using scan jobs.", new Object[0]);
                } else {
                    this.beaconService.destroy();
                    this.beaconService = null;
                    this.consumers.get(beaconConsumer).beaconServiceConnection.onServiceDisconnected();
                }
                this.consumers.remove(beaconConsumer);
                if (this.consumers.size() == 0) {
                    this.serviceMessenger = null;
                    this.mBackgroundMode = false;
                }
            } else {
                LogManager.d(TAG, "This consumer is not bound to: %s", beaconConsumer);
                LogManager.d(TAG, "Bound consumers: ", new Object[0]);
                Iterator<Map.Entry<BeaconConsumer, ConsumerInfo>> it = this.consumers.entrySet().iterator();
                while (it.hasNext()) {
                    LogManager.d(TAG, String.valueOf(it.next().getValue()), new Object[0]);
                }
            }
        }
    }

    public boolean isBound(BeaconConsumer beaconConsumer) {
        boolean z;
        synchronized (this.consumers) {
            if (beaconConsumer != null) {
                if (this.consumers.get(beaconConsumer) != null) {
                    z = this.serviceMessenger != null;
                }
            }
        }
        return z;
    }

    public boolean isAnyConsumerBound() {
        boolean z;
        synchronized (this.consumers) {
            if (this.consumers.isEmpty()) {
                z = this.serviceMessenger != null;
            }
        }
        return z;
    }

    public void setEnableScheduledScanJobs(boolean z) {
        if (isAnyConsumerBound()) {
            LogManager.e(TAG, "ScanJob may not be configured because a consumer is already bound.", new Object[0]);
            throw new IllegalStateException("Method must be called before calling bind()");
        } else if (z && Build.VERSION.SDK_INT < 21) {
            LogManager.e(TAG, "ScanJob may not be configured because JobScheduler is not availble prior to Android 5.0", new Object[0]);
        } else {
            this.mScheduledScanJobsEnabled = z;
        }
    }

    public boolean getScheduledScanJobsEnabled() {
        return this.mScheduledScanJobsEnabled;
    }

    public boolean getBackgroundMode() {
        return this.mBackgroundMode;
    }

    public void setBackgroundMode(boolean z) {
        if (!isBleAvailable()) {
            LogManager.w(TAG, "Method invocation will be ignored.", new Object[0]);
            return;
        }
        this.mBackgroundModeUninitialized = false;
        if (z != this.mBackgroundMode) {
            this.mBackgroundMode = z;
            try {
                updateScanPeriods();
            } catch (RemoteException unused) {
                LogManager.e(TAG, "Cannot contact service to set scan periods", new Object[0]);
            }
        }
    }

    public long getBackgroundScanPeriod() {
        return this.backgroundScanPeriod;
    }

    public void setBackgroundScanPeriod(long j) {
        this.backgroundScanPeriod = j;
    }

    public long getBackgroundBetweenScanPeriod() {
        return this.backgroundBetweenScanPeriod;
    }

    public void setBackgroundBetweenScanPeriod(long j) {
        this.backgroundBetweenScanPeriod = j;
    }

    public long getForegroundScanPeriod() {
        return this.foregroundScanPeriod;
    }

    public void setForegroundScanPeriod(long j) {
        this.foregroundScanPeriod = j;
    }

    public long getForegroundBetweenScanPeriod() {
        return this.foregroundBetweenScanPeriod;
    }

    public void setForegroundBetweenScanPeriod(long j) {
        this.foregroundBetweenScanPeriod = j;
    }

    public boolean isBackgroundModeUninitialized() {
        return this.mBackgroundModeUninitialized;
    }

    @Deprecated
    public void setRangeNotifier(RangeNotifier rangeNotifier) {
        this.rangeNotifiers.clear();
        if (rangeNotifier != null) {
            addRangeNotifier(rangeNotifier);
        }
    }

    public void addRangeNotifier(RangeNotifier rangeNotifier) {
        if (rangeNotifier != null) {
            this.rangeNotifiers.add(rangeNotifier);
        }
    }

    public boolean removeRangeNotifier(RangeNotifier rangeNotifier) {
        return this.rangeNotifiers.remove(rangeNotifier);
    }

    public void removeAllRangeNotifiers() {
        this.rangeNotifiers.clear();
    }

    @Deprecated
    public void setMonitorNotifier(MonitorNotifier monitorNotifier) {
        if (determineIfCalledFromSeparateScannerProcess()) {
            return;
        }
        this.monitorNotifiers.clear();
        if (monitorNotifier != null) {
            addMonitorNotifier(monitorNotifier);
        }
    }

    public void addMonitorNotifier(MonitorNotifier monitorNotifier) {
        if (determineIfCalledFromSeparateScannerProcess() || monitorNotifier == null) {
            return;
        }
        this.monitorNotifiers.add(monitorNotifier);
    }

    @Deprecated
    public boolean removeMonitoreNotifier(MonitorNotifier monitorNotifier) {
        return removeMonitorNotifier(monitorNotifier);
    }

    public boolean removeMonitorNotifier(MonitorNotifier monitorNotifier) {
        if (determineIfCalledFromSeparateScannerProcess()) {
            return false;
        }
        return this.monitorNotifiers.remove(monitorNotifier);
    }

    public void removeAllMonitorNotifiers() {
        if (determineIfCalledFromSeparateScannerProcess()) {
            return;
        }
        this.monitorNotifiers.clear();
    }

    @Deprecated
    public void setRegionStatePeristenceEnabled(boolean z) {
        setRegionStatePersistenceEnabled(z);
    }

    public boolean isRegionStatePersistenceEnabled() {
        return this.mRegionStatePersistenceEnabled;
    }

    public void setRegionStatePersistenceEnabled(boolean z) {
        this.mRegionStatePersistenceEnabled = z;
        if (!isScannerInDifferentProcess()) {
            if (z) {
                MonitoringStatus.getInstanceForApplication(this.mContext).startStatusPreservation();
            } else {
                MonitoringStatus.getInstanceForApplication(this.mContext).stopStatusPreservation();
            }
        }
        applySettings();
    }

    public void requestStateForRegion(Region region) {
        if (determineIfCalledFromSeparateScannerProcess()) {
            return;
        }
        RegionMonitoringState stateOf = MonitoringStatus.getInstanceForApplication(this.mContext).stateOf(region);
        int i = 0;
        if (stateOf != null && stateOf.getInside()) {
            i = 1;
        }
        Iterator<MonitorNotifier> it = this.monitorNotifiers.iterator();
        while (it.hasNext()) {
            it.next().didDetermineStateForRegion(i, region);
        }
    }

    public void startRangingBeaconsInRegion(Region region) throws RemoteException {
        if (!isBleAvailable()) {
            LogManager.w(TAG, "Method invocation will be ignored.", new Object[0]);
        } else if (determineIfCalledFromSeparateScannerProcess()) {
        } else {
            synchronized (this.rangedRegions) {
                this.rangedRegions.add(region);
            }
            applyChangesToServices(2, region);
        }
    }

    public void stopRangingBeaconsInRegion(Region region) throws RemoteException {
        if (!isBleAvailable()) {
            LogManager.w(TAG, "Method invocation will be ignored.", new Object[0]);
        } else if (determineIfCalledFromSeparateScannerProcess()) {
        } else {
            synchronized (this.rangedRegions) {
                Region region2 = null;
                Iterator<Region> it = this.rangedRegions.iterator();
                while (it.hasNext()) {
                    Region next = it.next();
                    if (region.getUniqueId().equals(next.getUniqueId())) {
                        region2 = next;
                    }
                }
                this.rangedRegions.remove(region2);
            }
            applyChangesToServices(3, region);
        }
    }

    public void applySettings() {
        if (determineIfCalledFromSeparateScannerProcess()) {
            return;
        }
        if (!isAnyConsumerBound()) {
            LogManager.d(TAG, "Not synchronizing settings to service, as it has not started up yet", new Object[0]);
        } else if (isScannerInDifferentProcess()) {
            LogManager.d(TAG, "Synchronizing settings to service", new Object[0]);
            syncSettingsToService();
        } else {
            LogManager.d(TAG, "Not synchronizing settings to service, as it is in the same process", new Object[0]);
        }
    }

    protected void syncSettingsToService() {
        if (this.mScheduledScanJobsEnabled) {
            ScanJobScheduler.getInstance().applySettingsToScheduledJob(this.mContext, this);
            return;
        }
        try {
            applyChangesToServices(7, null);
        } catch (RemoteException e) {
            LogManager.e(TAG, "Failed to sync settings to service", e);
        }
    }

    public void startMonitoringBeaconsInRegion(Region region) throws RemoteException {
        if (!isBleAvailable()) {
            LogManager.w(TAG, "Method invocation will be ignored.", new Object[0]);
        } else if (determineIfCalledFromSeparateScannerProcess()) {
        } else {
            if (this.mScheduledScanJobsEnabled) {
                MonitoringStatus.getInstanceForApplication(this.mContext).addRegion(region, new Callback(callbackPackageName()));
            }
            applyChangesToServices(4, region);
            if (isScannerInDifferentProcess()) {
                MonitoringStatus.getInstanceForApplication(this.mContext).addLocalRegion(region);
            }
            requestStateForRegion(region);
        }
    }

    public void stopMonitoringBeaconsInRegion(Region region) throws RemoteException {
        if (!isBleAvailable()) {
            LogManager.w(TAG, "Method invocation will be ignored.", new Object[0]);
        } else if (determineIfCalledFromSeparateScannerProcess()) {
        } else {
            if (this.mScheduledScanJobsEnabled) {
                MonitoringStatus.getInstanceForApplication(this.mContext).removeRegion(region);
            }
            applyChangesToServices(5, region);
            if (isScannerInDifferentProcess()) {
                MonitoringStatus.getInstanceForApplication(this.mContext).removeLocalRegion(region);
            }
        }
    }

    public void updateScanPeriods() throws RemoteException {
        if (!isBleAvailable()) {
            LogManager.w(TAG, "Method invocation will be ignored.", new Object[0]);
        } else if (determineIfCalledFromSeparateScannerProcess()) {
        } else {
            LogManager.d(TAG, "updating background flag to %s", Boolean.valueOf(this.mBackgroundMode));
            LogManager.d(TAG, "updating scan period to %s, %s", Long.valueOf(getScanPeriod()), Long.valueOf(getBetweenScanPeriod()));
            applyChangesToServices(6, null);
        }
    }

    private void applyChangesToServices(int i, Region region) throws RemoteException {
        if (this.mScheduledScanJobsEnabled) {
            ScanJobScheduler.getInstance().applySettingsToScheduledJob(this.mContext, this);
        } else if (this.serviceMessenger == null) {
            throw new RemoteException("The BeaconManager is not bound to the service.  Call beaconManager.bind(BeaconConsumer consumer) and wait for a callback to onBeaconServiceConnect()");
        } else {
            Message obtain = Message.obtain(null, i, 0, 0);
            if (i == 6) {
                obtain.setData(new StartRMData(getScanPeriod(), getBetweenScanPeriod(), this.mBackgroundMode).toBundle());
            } else if (i == 7) {
                obtain.setData(new SettingsData().collect(this.mContext).toBundle());
            } else {
                obtain.setData(new StartRMData(region, callbackPackageName(), getScanPeriod(), getBetweenScanPeriod(), this.mBackgroundMode).toBundle());
            }
            this.serviceMessenger.send(obtain);
        }
    }

    private String callbackPackageName() {
        String packageName = this.mContext.getPackageName();
        LogManager.d(TAG, "callback packageName: %s", packageName);
        return packageName;
    }

    @Deprecated
    public MonitorNotifier getMonitoringNotifier() {
        Iterator<MonitorNotifier> it = this.monitorNotifiers.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public Set<MonitorNotifier> getMonitoringNotifiers() {
        return Collections.unmodifiableSet(this.monitorNotifiers);
    }

    @Deprecated
    public RangeNotifier getRangingNotifier() {
        Iterator<RangeNotifier> it = this.rangeNotifiers.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public Set<RangeNotifier> getRangingNotifiers() {
        return Collections.unmodifiableSet(this.rangeNotifiers);
    }

    public Collection<Region> getMonitoredRegions() {
        return MonitoringStatus.getInstanceForApplication(this.mContext).regions();
    }

    public Collection<Region> getRangedRegions() {
        ArrayList arrayList;
        synchronized (this.rangedRegions) {
            arrayList = new ArrayList(this.rangedRegions);
        }
        return arrayList;
    }

    public void setMaxTrackingAge(int i) {
        RangedBeacon.setMaxTrackinAge(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RangeNotifier getDataRequestNotifier() {
        return this.dataRequestNotifier;
    }

    protected void setDataRequestNotifier(RangeNotifier rangeNotifier) {
        this.dataRequestNotifier = rangeNotifier;
    }

    public NonBeaconLeScanCallback getNonBeaconLeScanCallback() {
        return this.mNonBeaconLeScanCallback;
    }

    public void setNonBeaconLeScanCallback(NonBeaconLeScanCallback nonBeaconLeScanCallback) {
        this.mNonBeaconLeScanCallback = nonBeaconLeScanCallback;
    }

    private boolean isBleAvailable() {
        if (Build.VERSION.SDK_INT < 18) {
            LogManager.w(TAG, "Bluetooth LE not supported prior to API 18.", new Object[0]);
            return false;
        } else if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            return true;
        } else {
            LogManager.w(TAG, "This device does not support bluetooth LE.", new Object[0]);
            return false;
        }
    }

    private long getScanPeriod() {
        if (this.mBackgroundMode) {
            return this.backgroundScanPeriod;
        }
        return this.foregroundScanPeriod;
    }

    private long getBetweenScanPeriod() {
        if (this.mBackgroundMode) {
            return this.backgroundBetweenScanPeriod;
        }
        return this.foregroundBetweenScanPeriod;
    }

    private boolean determineIfCalledFromSeparateScannerProcess() {
        if (isScannerInDifferentProcess() && !isMainProcess()) {
            LogManager.w(TAG, "Ranging/Monitoring may not be controlled from a separate BeaconScanner process.  To remove this warning, please wrap this call in: if (beaconManager.isMainProcess())", new Object[0]);
        }
        return false;
    }

    public void destroy() {
        this.mContext = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ConsumerInfo {
        public BeaconServiceConnection beaconServiceConnection;
        public boolean isConnected = false;

        public ConsumerInfo() {
            this.beaconServiceConnection = new BeaconServiceConnection();
        }
    }

    /* loaded from: classes6.dex */
    class BeaconServiceConnection {
        private BeaconServiceConnection() {
        }

        public void onServiceConnected(BeaconService beaconService) {
            LogManager.d(BeaconManager.TAG, "we have a connection to the service now", new Object[0]);
            if (BeaconManager.this.mScannerInSameProcess == null) {
                BeaconManager.this.mScannerInSameProcess = Boolean.FALSE;
            }
            BeaconManager.this.serviceMessenger = beaconService.getmMessenger();
            BeaconManager.this.applySettings();
            synchronized (BeaconManager.this.consumers) {
                for (Map.Entry entry : BeaconManager.this.consumers.entrySet()) {
                    if (!((ConsumerInfo) entry.getValue()).isConnected) {
                        ((BeaconConsumer) entry.getKey()).onBeaconServiceConnect();
                        ((ConsumerInfo) entry.getValue()).isConnected = true;
                    }
                }
            }
        }

        public void onServiceDisconnected() {
            LogManager.e(BeaconManager.TAG, "onServiceDisconnected", new Object[0]);
            BeaconManager.this.serviceMessenger = null;
        }
    }

    /* loaded from: classes6.dex */
    public class ServiceNotDeclaredException extends RuntimeException {
        public ServiceNotDeclaredException() {
            super("The BeaconService is not properly declared in AndroidManifest.xml.  If using Eclipse, please verify that your project.properties has manifestmerger.enabled=true");
        }
    }
}
