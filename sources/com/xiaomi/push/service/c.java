package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class c extends XMPushService.j {
    private XMPushService MyBillsEntityDataFactory;
    private com.xiaomi.push.bi[] getAuthRequestContext;

    public c(XMPushService xMPushService, com.xiaomi.push.bi[] biVarArr) {
        super(4);
        this.MyBillsEntityDataFactory = xMPushService;
        this.getAuthRequestContext = biVarArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        try {
            com.xiaomi.push.bi[] biVarArr = this.getAuthRequestContext;
            if (biVarArr != null) {
                this.MyBillsEntityDataFactory.a(biVarArr);
            }
        } catch (com.xiaomi.push.cd e) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
            this.MyBillsEntityDataFactory.a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public final String getAuthRequestContext() {
        return "batch send message.";
    }
}
