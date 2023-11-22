package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class cb extends XMPushService.j {
    final /* synthetic */ int BuiltInFictitiousFunctionClassFactory;
    final /* synthetic */ bz KClassImpl$Data$declaredNonStaticMembers$2;
    final /* synthetic */ Exception getAuthRequestContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cb(bz bzVar, int i, Exception exc) {
        super(2);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = bzVar;
        this.BuiltInFictitiousFunctionClassFactory = i;
        this.getAuthRequestContext = exc;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.PrepareContext.a(this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext);
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public final String getAuthRequestContext() {
        StringBuilder sb = new StringBuilder();
        sb.append("shutdown the connection. ");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", ");
        sb.append(this.getAuthRequestContext);
        return sb.toString();
    }
}
