package com.xiaomi.push.service;

import com.xiaomi.push.dq;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes8.dex */
public final class y extends XMPushService.j {
    final /* synthetic */ dq BuiltInFictitiousFunctionClassFactory;
    final /* synthetic */ XMPushService KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(XMPushService xMPushService, dq dqVar) {
        super(4);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = xMPushService;
        this.BuiltInFictitiousFunctionClassFactory = dqVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        try {
            dq MyBillsEntityDataFactory = v.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory);
            MyBillsEntityDataFactory.m308a().a("miui_message_unrecognized", "1");
            ad.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory);
        } catch (com.xiaomi.push.cd e) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
            this.KClassImpl$Data$declaredNonStaticMembers$2.a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public final String getAuthRequestContext() {
        return "send ack message for unrecognized new miui message.";
    }
}
