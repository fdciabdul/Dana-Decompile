package com.alibaba.griver.bluetooth.altbeacon.beacon;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.griver.bluetooth.altbeacon.beacon.logging.LogManager;

/* loaded from: classes6.dex */
public class BeaconLocalBroadcastProcessor {
    public static final String MONITOR_NOTIFICATION = "org.com.alibaba.griver.bluetooth.altbeacon.beacon.monitor_notification";
    public static final String RANGE_NOTIFICATION = "org.com.alibaba.griver.bluetooth.altbeacon.beacon.range_notification";
    private static final String TAG = "BeaconLocalBroadcastProcessor";
    static int registerCallCount;
    private Context mContext;
    int registerCallCountForInstnace = 0;
    private BroadcastReceiver mLocalBroadcastReceiver = new BroadcastReceiver() { // from class: com.alibaba.griver.bluetooth.altbeacon.beacon.BeaconLocalBroadcastProcessor.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            new IntentHandler().convertIntentsToCallbacks(context, intent);
        }
    };

    private BeaconLocalBroadcastProcessor() {
    }

    public BeaconLocalBroadcastProcessor(Context context) {
        this.mContext = context;
    }

    public void register() {
        registerCallCount++;
        this.registerCallCountForInstnace++;
        StringBuilder sb = new StringBuilder();
        sb.append("Register calls: global=");
        sb.append(registerCallCount);
        sb.append(" instance=");
        sb.append(this.registerCallCountForInstnace);
        LogManager.d(TAG, sb.toString(), new Object[0]);
        unregister();
        LocalBroadcastManager.getInstance(this.mContext).registerReceiver(this.mLocalBroadcastReceiver, new IntentFilter(RANGE_NOTIFICATION));
        LocalBroadcastManager.getInstance(this.mContext).registerReceiver(this.mLocalBroadcastReceiver, new IntentFilter(MONITOR_NOTIFICATION));
    }

    public void unregister() {
        LocalBroadcastManager.getInstance(this.mContext).unregisterReceiver(this.mLocalBroadcastReceiver);
    }
}
