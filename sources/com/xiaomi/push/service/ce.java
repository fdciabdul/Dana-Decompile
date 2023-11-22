package com.xiaomi.push.service;

import com.xiaomi.push.au;

/* loaded from: classes8.dex */
class ce extends com.xiaomi.push.bu {
    final /* synthetic */ XMPushService lookAheadTest;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ce(XMPushService xMPushService, String str) {
        super(str);
        this.lookAheadTest = xMPushService;
    }

    @Override // com.xiaomi.push.bu
    public final byte[] BuiltInFictitiousFunctionClassFactory() {
        bn bnVar;
        try {
            au.b bVar = new au.b();
            bnVar = bn.BuiltInFictitiousFunctionClassFactory;
            int PlaceComponentResult = bnVar.PlaceComponentResult();
            bVar.getAuthRequestContext = true;
            bVar.PlaceComponentResult = PlaceComponentResult;
            return bVar.moveToNextValue();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("getOBBString err: ");
            sb.append(e.toString());
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
            return null;
        }
    }
}
