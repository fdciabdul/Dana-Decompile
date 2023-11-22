package com.xiaomi.push.service;

import com.xiaomi.push.dq;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes8.dex */
public final class x extends XMPushService.j {
    final /* synthetic */ XMPushService BuiltInFictitiousFunctionClassFactory;
    final /* synthetic */ dq PlaceComponentResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(XMPushService xMPushService, dq dqVar) {
        super(4);
        this.BuiltInFictitiousFunctionClassFactory = xMPushService;
        this.PlaceComponentResult = dqVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        try {
            dq MyBillsEntityDataFactory = v.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult);
            MyBillsEntityDataFactory.m308a().a("message_obsleted", "1");
            ad.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory);
        } catch (com.xiaomi.push.cd e) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
            this.BuiltInFictitiousFunctionClassFactory.a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public final String getAuthRequestContext() {
        return "send ack message for obsleted message.";
    }
}
