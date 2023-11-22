package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class ch extends XMPushService.j {
    final /* synthetic */ XMPushService KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ch(XMPushService xMPushService) {
        super(11);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        ad.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2);
        if (com.xiaomi.push.y.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2)) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.a(true);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public final String getAuthRequestContext() {
        return "prepare the mi push account.";
    }
}
