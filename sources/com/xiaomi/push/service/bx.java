package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;

/* loaded from: classes8.dex */
class bx implements com.xiaomi.push.bx {
    final /* synthetic */ XMPushService MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(XMPushService xMPushService) {
        this.MyBillsEntityDataFactory = xMPushService;
    }

    @Override // com.xiaomi.push.bx
    public final void MyBillsEntityDataFactory(com.xiaomi.push.bi biVar) {
        XMPushService xMPushService = this.MyBillsEntityDataFactory;
        xMPushService.a(new XMPushService.d(biVar));
    }

    @Override // com.xiaomi.push.bx
    public final void MyBillsEntityDataFactory(com.xiaomi.push.cj cjVar) {
        XMPushService xMPushService = this.MyBillsEntityDataFactory;
        xMPushService.a(new XMPushService.m(cjVar));
    }
}
