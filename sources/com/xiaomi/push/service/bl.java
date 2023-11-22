package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class bl extends XMPushService.j {
    private XMPushService MyBillsEntityDataFactory;
    private com.xiaomi.push.bi PlaceComponentResult;

    public bl(XMPushService xMPushService, com.xiaomi.push.bi biVar) {
        super(4);
        this.MyBillsEntityDataFactory = xMPushService;
        this.PlaceComponentResult = biVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        try {
            com.xiaomi.push.bi biVar = this.PlaceComponentResult;
            if (biVar != null) {
                this.MyBillsEntityDataFactory.a(biVar);
            }
        } catch (com.xiaomi.push.cd e) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
            this.MyBillsEntityDataFactory.a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public final String getAuthRequestContext() {
        return "send a message.";
    }
}
