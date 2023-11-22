package com.xiaomi.push.service;

import com.xiaomi.push.dq;
import com.xiaomi.push.service.XMPushService;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;

/* loaded from: classes8.dex */
public final class aa extends XMPushService.j {
    final /* synthetic */ String KClassImpl$Data$declaredNonStaticMembers$2;
    final /* synthetic */ dq MyBillsEntityDataFactory;
    final /* synthetic */ String PlaceComponentResult;
    final /* synthetic */ XMPushService getAuthRequestContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(XMPushService xMPushService, dq dqVar, String str, String str2) {
        super(4);
        this.getAuthRequestContext = xMPushService;
        this.MyBillsEntityDataFactory = dqVar;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.PlaceComponentResult = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        try {
            dq MyBillsEntityDataFactory = v.MyBillsEntityDataFactory(this.getAuthRequestContext, this.MyBillsEntityDataFactory);
            MyBillsEntityDataFactory.f223a.a("error", this.KClassImpl$Data$declaredNonStaticMembers$2);
            MyBillsEntityDataFactory.f223a.a(ZdocRecordService.REASON, this.PlaceComponentResult);
            ad.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, MyBillsEntityDataFactory);
        } catch (com.xiaomi.push.cd e) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
            this.getAuthRequestContext.a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public final String getAuthRequestContext() {
        return "send wrong message ack for message.";
    }
}
