package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;

/* loaded from: classes8.dex */
class bz extends XMPushService.j {
    final /* synthetic */ XMPushService BuiltInFictitiousFunctionClassFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bz(XMPushService xMPushService) {
        super(2);
        this.BuiltInFictitiousFunctionClassFactory = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.BuiltInFictitiousFunctionClassFactory.f397a != null) {
            this.BuiltInFictitiousFunctionClassFactory.f397a.getAuthRequestContext(15, null);
            this.BuiltInFictitiousFunctionClassFactory.f397a = null;
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public final String getAuthRequestContext() {
        return "disconnect for service destroy.";
    }
}
