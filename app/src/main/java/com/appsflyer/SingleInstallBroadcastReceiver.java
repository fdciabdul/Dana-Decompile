package com.appsflyer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.appsflyer.internal.ae;

/* loaded from: classes7.dex */
public class SingleInstallBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        if (intent == null) {
            return;
        }
        try {
            str = intent.getStringExtra("referrer");
        } catch (Throwable th) {
            AFLogger.AFInAppEventType("error in BroadcastReceiver ", th);
            str = null;
        }
        if (str != null && ae.values(context).getString("referrer", null) != null) {
            ae.values().values(context, str);
            return;
        }
        String string = AppsFlyerProperties.getInstance().getString("referrer_timestamp");
        long currentTimeMillis = System.currentTimeMillis();
        if (string == null || currentTimeMillis - Long.valueOf(string).longValue() >= 2000) {
            AFLogger.AFKeystoreWrapper("SingleInstallBroadcastReceiver called");
            ae.values().AFInAppEventParameterName(context, intent);
            AppsFlyerProperties.getInstance().set("referrer_timestamp", String.valueOf(System.currentTimeMillis()));
        }
    }
}
