package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class by extends XMPushService.j {
    final /* synthetic */ XMPushService BuiltInFictitiousFunctionClassFactory;
    final /* synthetic */ String KClassImpl$Data$declaredNonStaticMembers$2;
    final /* synthetic */ byte[] MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public by(XMPushService xMPushService, String str, byte[] bArr) {
        super(4);
        this.BuiltInFictitiousFunctionClassFactory = xMPushService;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.MyBillsEntityDataFactory = bArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        try {
            ad.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory);
        } catch (com.xiaomi.push.cd e) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
            this.BuiltInFictitiousFunctionClassFactory.a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public final String getAuthRequestContext() {
        return "send mi push message";
    }
}
