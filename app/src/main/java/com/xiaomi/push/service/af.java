package com.xiaomi.push.service;

import com.xiaomi.push.service.az;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class af implements az.b.a {
    final /* synthetic */ XMPushService KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(XMPushService xMPushService) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = xMPushService;
    }

    @Override // com.xiaomi.push.service.az.b.a
    public final void PlaceComponentResult(az.c cVar) {
        if (cVar == az.c.binded) {
            u.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2);
            u.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2);
        } else if (cVar == az.c.unbind) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("onChange unbind");
            u.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, 70000001, " the push is not connected.");
        }
    }
}
