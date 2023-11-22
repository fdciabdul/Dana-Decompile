package com.alibaba.griver.bluetooth.altbeacon.beacon.startup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.alibaba.griver.bluetooth.altbeacon.beacon.BeaconManager;
import com.alibaba.griver.bluetooth.altbeacon.beacon.logging.LogManager;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.ScanJobScheduler;

/* loaded from: classes6.dex */
public class StartupBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "StartupBroadcastReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        LogManager.d(TAG, "onReceive called in startup broadcast receiver", new Object[0]);
        if (Build.VERSION.SDK_INT < 18) {
            LogManager.w(TAG, "Not starting up beacon service because we do not have API version 18 (Android 4.3).  We have: %s", Integer.valueOf(Build.VERSION.SDK_INT));
            return;
        }
        BeaconManager instanceForApplication = BeaconManager.getInstanceForApplication(context.getApplicationContext());
        if (instanceForApplication.isAnyConsumerBound() || instanceForApplication.getScheduledScanJobsEnabled()) {
            int intExtra = intent.getIntExtra("android.bluetooth.le.extra.CALLBACK_TYPE", -1);
            if (intExtra != -1) {
                StringBuilder sb = new StringBuilder();
                sb.append("Passive background scan callback type: ");
                sb.append(intExtra);
                LogManager.d(TAG, sb.toString(), new Object[0]);
                LogManager.d(TAG, "got Android O background scan via intent", new Object[0]);
                int intExtra2 = intent.getIntExtra("android.bluetooth.le.extra.ERROR_CODE", -1);
                if (intExtra2 != -1) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Passive background scan failed.  Code; ");
                    sb2.append(intExtra2);
                    LogManager.w(TAG, sb2.toString(), new Object[0]);
                }
                ScanJobScheduler.getInstance().scheduleAfterBackgroundWakeup(context, intent.getParcelableArrayListExtra("android.bluetooth.le.extra.LIST_SCAN_RESULT"));
                return;
            } else if (intent.getBooleanExtra("wakeup", false)) {
                LogManager.d(TAG, "got wake up intent", new Object[0]);
                return;
            } else {
                LogManager.d(TAG, "Already started.  Ignoring intent: %s of type: %s", intent, intent.getStringExtra("wakeup"));
                return;
            }
        }
        LogManager.d(TAG, "No consumers are bound.  Ignoring broadcast receiver.", new Object[0]);
    }
}
