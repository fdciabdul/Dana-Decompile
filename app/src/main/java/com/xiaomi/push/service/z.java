package com.xiaomi.push.service;

import com.xiaomi.push.dq;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes8.dex */
public final class z extends XMPushService.j {
    final /* synthetic */ dq MyBillsEntityDataFactory;
    final /* synthetic */ XMPushService PlaceComponentResult;
    final /* synthetic */ String getAuthRequestContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(XMPushService xMPushService, dq dqVar, String str) {
        super(4);
        this.PlaceComponentResult = xMPushService;
        this.MyBillsEntityDataFactory = dqVar;
        this.getAuthRequestContext = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        try {
            dq MyBillsEntityDataFactory = v.MyBillsEntityDataFactory(this.PlaceComponentResult, this.MyBillsEntityDataFactory);
            MyBillsEntityDataFactory.m308a().a("absent_target_package", this.getAuthRequestContext);
            ad.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, MyBillsEntityDataFactory);
        } catch (com.xiaomi.push.cd e) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
            this.PlaceComponentResult.a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public final String getAuthRequestContext() {
        return "send app absent ack message for message.";
    }
}
