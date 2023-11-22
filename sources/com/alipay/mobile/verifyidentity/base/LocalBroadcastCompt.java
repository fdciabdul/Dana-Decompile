package com.alipay.mobile.verifyidentity.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

/* loaded from: classes7.dex */
public class LocalBroadcastCompt {
    public static void sendBroadcast(Context context, Intent intent) {
        try {
            Class.forName("androidx.localbroadcastmanager.content.LocalBroadcastManager");
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        } catch (Throwable unused) {
        }
    }

    public static void registerBroadcast(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        try {
            Class.forName("androidx.localbroadcastmanager.content.LocalBroadcastManager");
            LocalBroadcastManager.getInstance(context).registerReceiver(broadcastReceiver, intentFilter);
        } catch (Throwable unused) {
        }
    }

    public static void unregisterBroadcast(Context context, BroadcastReceiver broadcastReceiver) {
        try {
            Class.forName("androidx.localbroadcastmanager.content.LocalBroadcastManager");
            LocalBroadcastManager.getInstance(context).unregisterReceiver(broadcastReceiver);
        } catch (Throwable unused) {
        }
    }
}
