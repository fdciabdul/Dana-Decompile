package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bc;
import com.xiaomi.push.service.ServiceClient;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bd;

/* loaded from: classes8.dex */
public class PingReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        StringBuilder sb = new StringBuilder();
        sb.append(intent.getPackage());
        sb.append(" is the package name");
        b.BuiltInFictitiousFunctionClassFactory(sb.toString());
        if (XMPushService.m381f()) {
            return;
        }
        if (!bd.readMicros.equals(intent.getAction())) {
            b.getAuthRequestContext("cancel the old ping timer");
            bc.MyBillsEntityDataFactory();
        } else if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
            b.BuiltInFictitiousFunctionClassFactory("Ping XMChannelService on timer");
            try {
                Intent intent2 = new Intent(context, XMPushService.class);
                intent2.putExtra("time_stamp", System.currentTimeMillis());
                intent2.setAction("com.xiaomi.push.timer");
                ServiceClient.BuiltInFictitiousFunctionClassFactory(context).getAuthRequestContext(intent2);
            } catch (Exception e) {
                b.getAuthRequestContext(e);
            }
        }
    }
}
