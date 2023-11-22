package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.pm.PackageManager;

/* loaded from: classes8.dex */
class cc implements Runnable {
    final /* synthetic */ XMPushService PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(XMPushService xMPushService) {
        this.PlaceComponentResult = xMPushService;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            PackageManager packageManager = this.PlaceComponentResult.getApplicationContext().getPackageManager();
            ComponentName componentName = new ComponentName(this.PlaceComponentResult.getApplicationContext(), "com.xiaomi.push.service.receivers.PingReceiver");
            if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                packageManager.setComponentEnabledSetting(componentName, 2, 1);
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("[Alarm] disable ping receiver may be failure. ");
            sb.append(th);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
        }
    }
}
