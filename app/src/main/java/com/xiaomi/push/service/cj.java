package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class cj extends XMPushService.j {
    final /* synthetic */ XMPushService BuiltInFictitiousFunctionClassFactory;
    final /* synthetic */ byte[] KClassImpl$Data$declaredNonStaticMembers$2;
    final /* synthetic */ int MyBillsEntityDataFactory;
    final /* synthetic */ boolean PlaceComponentResult;
    final /* synthetic */ String getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cj(XMPushService xMPushService, int i, boolean z, String str, byte[] bArr) {
        super(14);
        this.BuiltInFictitiousFunctionClassFactory = xMPushService;
        this.MyBillsEntityDataFactory = i;
        this.PlaceComponentResult = z;
        this.getAuthRequestContext = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = bArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public final String getAuthRequestContext() {
        return "clear account cache.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        com.xiaomi.push.bu buVar;
        r.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory);
        az.BuiltInFictitiousFunctionClassFactory().PlaceComponentResult("5");
        com.xiaomi.push.j.PlaceComponentResult(this.MyBillsEntityDataFactory);
        if (this.PlaceComponentResult) {
            this.BuiltInFictitiousFunctionClassFactory.m388a();
        }
        buVar = this.BuiltInFictitiousFunctionClassFactory.f398a;
        buVar.MyBillsEntityDataFactory = com.xiaomi.push.bu.PlaceComponentResult();
        StringBuilder sb = new StringBuilder();
        sb.append("clear account and start registration. ");
        sb.append(this.getAuthRequestContext);
        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
        this.BuiltInFictitiousFunctionClassFactory.a(this.KClassImpl$Data$declaredNonStaticMembers$2, this.getAuthRequestContext);
    }
}
