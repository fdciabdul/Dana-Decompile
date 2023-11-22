package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.az;

/* loaded from: classes8.dex */
class bb extends XMPushService.j {
    final /* synthetic */ az.b.c BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bb(az.b.c cVar) {
        super(0);
        this.BuiltInFictitiousFunctionClassFactory = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory == this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory) {
            StringBuilder sb = new StringBuilder();
            sb.append("clean peer, chid = ");
            sb.append(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.newProxyInstance);
            com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory(sb.toString());
            this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = null;
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public final String getAuthRequestContext() {
        return "clear peer job";
    }
}
