package com.xiaomi.mipush.sdk;

/* loaded from: classes8.dex */
class u implements Runnable {
    final /* synthetic */ NotificationClickedActivity getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(NotificationClickedActivity notificationClickedActivity) {
        this.getAuthRequestContext = notificationClickedActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.xiaomi.channel.commonutils.logger.b.moveToNextValue("clicked activity finish by timeout.");
        this.getAuthRequestContext.finish();
    }
}
