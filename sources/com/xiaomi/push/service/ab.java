package com.xiaomi.push.service;

import com.xiaomi.push.cz;
import com.xiaomi.push.df;
import com.xiaomi.push.dm;
import com.xiaomi.push.dq;
import com.xiaomi.push.dt;
import com.xiaomi.push.service.XMPushService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class ab extends XMPushService.j {
    final /* synthetic */ dt MyBillsEntityDataFactory;
    final /* synthetic */ dq PlaceComponentResult;
    final /* synthetic */ XMPushService getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(dt dtVar, dq dqVar, XMPushService xMPushService) {
        super(4);
        this.MyBillsEntityDataFactory = dtVar;
        this.PlaceComponentResult = dqVar;
        this.getAuthRequestContext = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        try {
            dm dmVar = new dm();
            dmVar.c(df.CancelPushMessageACK.f104a);
            dmVar.a(this.MyBillsEntityDataFactory.m323a());
            dmVar.a(this.MyBillsEntityDataFactory.a());
            dmVar.b(this.MyBillsEntityDataFactory.b());
            dmVar.e(this.MyBillsEntityDataFactory.c());
            dmVar.a(0L);
            dmVar.d("success clear push message.");
            ad.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, ad.MyBillsEntityDataFactory(this.PlaceComponentResult.b(), this.PlaceComponentResult.m309a(), dmVar, cz.Notification));
        } catch (com.xiaomi.push.cd e) {
            StringBuilder sb = new StringBuilder();
            sb.append("clear push message. ");
            sb.append(e);
            com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2(sb.toString());
            this.getAuthRequestContext.a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public final String getAuthRequestContext() {
        return "send ack message for clear push message.";
    }
}
