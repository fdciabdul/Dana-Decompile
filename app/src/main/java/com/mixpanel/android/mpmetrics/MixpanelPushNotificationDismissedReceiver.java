package com.mixpanel.android.mpmetrics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes3.dex */
public class MixpanelPushNotificationDismissedReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action == null || !action.equals("com.mixpanel.push_notification_dismissed")) {
            return;
        }
        MixpanelAPI.getAuthRequestContext(context, intent, "$push_notification_dismissed");
    }
}
