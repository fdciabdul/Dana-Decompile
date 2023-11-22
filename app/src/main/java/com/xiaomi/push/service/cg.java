package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes8.dex */
class cg extends ContentObserver {
    final /* synthetic */ XMPushService KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cg(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        boolean m383h;
        super.onChange(z);
        m383h = this.KClassImpl$Data$declaredNonStaticMembers$2.m383h();
        StringBuilder sb = new StringBuilder();
        sb.append("SuperPowerMode:");
        sb.append(m383h);
        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
        this.KClassImpl$Data$declaredNonStaticMembers$2.e();
        if (!m383h) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.a(true);
            return;
        }
        XMPushService xMPushService = this.KClassImpl$Data$declaredNonStaticMembers$2;
        xMPushService.a(new XMPushService.g(24));
    }
}
