package com.xiaomi.push.service;

/* loaded from: classes8.dex */
class cb implements Runnable {
    final /* synthetic */ XMPushService getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(XMPushService xMPushService) {
        this.getAuthRequestContext = xMPushService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.getAuthRequestContext.f412a = true;
        try {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("try to trigger the wifi digest broadcast.");
            Object systemService = this.getAuthRequestContext.getApplicationContext().getSystemService("MiuiWifiService");
            if (systemService != null) {
                com.xiaomi.push.z.MyBillsEntityDataFactory(systemService, "sendCurrentWifiDigestInfo", new Object[0]);
            }
        } catch (Throwable unused) {
        }
    }
}
