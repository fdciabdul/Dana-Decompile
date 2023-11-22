package com.alipay.iap.android.aplog.core.filter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.alipay.iap.android.aplog.core.LoggerFactory;

/* loaded from: classes6.dex */
public class DateChangeBroadCastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        LoggerFactory.getTraceLogger().info("DateChangeBroadCastReceiver", "onReceive");
    }
}
