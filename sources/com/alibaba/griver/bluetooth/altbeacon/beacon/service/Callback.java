package com.alibaba.griver.bluetooth.altbeacon.beacon.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.griver.bluetooth.altbeacon.beacon.BeaconIntentProcessor;
import com.alibaba.griver.bluetooth.altbeacon.beacon.BeaconLocalBroadcastProcessor;
import com.alibaba.griver.bluetooth.altbeacon.beacon.BeaconManager;
import com.alibaba.griver.bluetooth.altbeacon.beacon.logging.LogManager;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class Callback implements Serializable {
    private static final String TAG = "Callback";
    private BeaconIntentProcessor beaconIntentProcessor = new BeaconIntentProcessor();

    public Callback(String str) {
    }

    public boolean call(Context context, String str, Bundle bundle) {
        if (BeaconManager.getInstanceForApplication(context).getScheduledScanJobsEnabled()) {
            String str2 = "rangingData".equals(str) ? BeaconLocalBroadcastProcessor.RANGE_NOTIFICATION : BeaconLocalBroadcastProcessor.MONITOR_NOTIFICATION;
            Intent intent = new Intent(str2);
            intent.putExtra(str, bundle);
            LogManager.d(TAG, "attempting callback via local broadcast intent: %s", str2);
            return LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        }
        Intent intent2 = new Intent();
        intent2.setComponent(new ComponentName(context.getPackageName(), "org.com.alibaba.griver.bluetooth.altbeacon.beacon.BeaconIntentProcessor"));
        intent2.putExtra(str, bundle);
        LogManager.d(TAG, "attempting callback via global broadcast intent: %s", intent2.getComponent());
        try {
            this.beaconIntentProcessor.handleIntent(context, intent2);
            return true;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed attempting to start service: ");
            sb.append(intent2.getComponent().flattenToString());
            LogManager.e(TAG, sb.toString(), e);
            return false;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
    }
}
