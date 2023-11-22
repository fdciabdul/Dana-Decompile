package com.alibaba.griver.bluetooth.altbeacon.beacon.service;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.bluetooth.le.ScanResult;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import android.os.SystemClock;
import com.alibaba.griver.bluetooth.altbeacon.beacon.BeaconLocalBroadcastProcessor;
import com.alibaba.griver.bluetooth.altbeacon.beacon.BeaconManager;
import com.alibaba.griver.bluetooth.altbeacon.beacon.logging.LogManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class ScanJobScheduler {
    private static final long MIN_MILLIS_BETWEEN_SCAN_JOB_SCHEDULING = 10000;
    private static final Object SINGLETON_LOCK = new Object();
    private static final String TAG = "ScanJobScheduler";
    private static volatile ScanJobScheduler sInstance;
    private BeaconLocalBroadcastProcessor mBeaconNotificationProcessor;
    private Long mScanJobScheduleTime = 0L;
    private List<ScanResult> mBackgroundScanResultQueue = new ArrayList();

    private ScanJobScheduler() {
    }

    public static ScanJobScheduler getInstance() {
        ScanJobScheduler scanJobScheduler;
        ScanJobScheduler scanJobScheduler2 = sInstance;
        if (scanJobScheduler2 == null) {
            synchronized (SINGLETON_LOCK) {
                scanJobScheduler = sInstance;
                if (scanJobScheduler == null) {
                    scanJobScheduler = new ScanJobScheduler();
                    sInstance = scanJobScheduler;
                }
            }
            return scanJobScheduler;
        }
        return scanJobScheduler2;
    }

    private void ensureNotificationProcessorSetup(Context context) {
        if (this.mBeaconNotificationProcessor == null) {
            BeaconLocalBroadcastProcessor beaconLocalBroadcastProcessor = new BeaconLocalBroadcastProcessor(context);
            this.mBeaconNotificationProcessor = beaconLocalBroadcastProcessor;
            beaconLocalBroadcastProcessor.register();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ScanResult> dumpBackgroundScanResultQueue() {
        List<ScanResult> list = this.mBackgroundScanResultQueue;
        this.mBackgroundScanResultQueue = new ArrayList();
        return list;
    }

    private void applySettingsToScheduledJob(Context context, BeaconManager beaconManager, ScanState scanState) {
        scanState.applyChanges(beaconManager);
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Applying scan job settings with background mode ");
        sb.append(scanState.getBackgroundMode());
        LogManager.d(str, sb.toString(), new Object[0]);
        schedule(context, scanState, false);
    }

    public void applySettingsToScheduledJob(Context context, BeaconManager beaconManager) {
        LogManager.d(TAG, "Applying settings to ScanJob", new Object[0]);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        applySettingsToScheduledJob(context, beaconManager, ScanState.restore(context));
    }

    public void scheduleAfterBackgroundWakeup(Context context, List<ScanResult> list) {
        if (list != null) {
            this.mBackgroundScanResultQueue.addAll(list);
        }
        synchronized (this) {
            if (System.currentTimeMillis() - this.mScanJobScheduleTime.longValue() > 10000) {
                String str = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("scheduling an immediate scan job because last did ");
                sb.append(System.currentTimeMillis() - this.mScanJobScheduleTime.longValue());
                sb.append("seconds ago.");
                LogManager.d(str, sb.toString(), new Object[0]);
                this.mScanJobScheduleTime = Long.valueOf(System.currentTimeMillis());
                schedule(context, ScanState.restore(context), true);
                return;
            }
            LogManager.d(TAG, "Not scheduling an immediate scan job because we just did recently.", new Object[0]);
        }
    }

    private void schedule(Context context, ScanState scanState, boolean z) {
        ensureNotificationProcessorSetup(context);
        long scanJobIntervalMillis = scanState.getScanJobIntervalMillis() - scanState.getScanJobRuntimeMillis();
        long j = 50;
        if (z) {
            LogManager.d(TAG, "We just woke up in the background based on a new scan result.  Start scan job immediately.", new Object[0]);
            j = 0;
        } else {
            long elapsedRealtime = scanJobIntervalMillis > 0 ? SystemClock.elapsedRealtime() % scanState.getScanJobIntervalMillis() : 0L;
            if (elapsedRealtime >= 50) {
                j = elapsedRealtime;
            }
        }
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (!z && scanState.getBackgroundMode().booleanValue()) {
            LogManager.d(TAG, "Not scheduling an immediate scan because we are in background mode.   Cancelling existing immediate scan.", new Object[0]);
            jobScheduler.cancel(2);
        } else if (j < ((long) (scanState.getScanJobIntervalMillis() - 50))) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Scheduling immediate ScanJob to run in ");
            sb.append(j);
            sb.append(" millis");
            LogManager.d(str, sb.toString(), new Object[0]);
            int schedule = jobScheduler.schedule(new JobInfo.Builder(2, new ComponentName(context, ScanJob.class)).setPersisted(true).setExtras(new PersistableBundle()).setMinimumLatency(j).setOverrideDeadline(j).build());
            if (schedule < 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to schedule scan job.  Beacons will not be detected. Error: ");
                sb2.append(schedule);
                LogManager.e(str, sb2.toString(), new Object[0]);
            }
        }
        JobInfo.Builder extras = new JobInfo.Builder(1, new ComponentName(context, ScanJob.class)).setPersisted(true).setExtras(new PersistableBundle());
        if (Build.VERSION.SDK_INT >= 24) {
            extras.setPeriodic(scanState.getScanJobIntervalMillis(), 0L).build();
        } else {
            extras.setPeriodic(scanState.getScanJobIntervalMillis()).build();
        }
        String str2 = TAG;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Scheduling ScanJob to run every ");
        sb3.append(scanState.getScanJobIntervalMillis());
        sb3.append(" millis");
        LogManager.d(str2, sb3.toString(), new Object[0]);
        int schedule2 = jobScheduler.schedule(extras.build());
        if (schedule2 < 0) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Failed to schedule scan job.  Beacons will not be detected. Error: ");
            sb4.append(schedule2);
            LogManager.e(str2, sb4.toString(), new Object[0]);
        }
    }
}
