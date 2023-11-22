package com.xiaomi.push.service;

import com.xiaomi.push.dq;
import com.xiaomi.push.service.XMPushService;
import java.util.Map;

/* loaded from: classes8.dex */
public final class w extends XMPushService.j {
    final /* synthetic */ XMPushService PlaceComponentResult;
    final /* synthetic */ dq getAuthRequestContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(XMPushService xMPushService, dq dqVar) {
        super(4);
        this.PlaceComponentResult = xMPushService;
        this.getAuthRequestContext = dqVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        try {
            Map<String, String> map = null;
            if (com.xiaomi.channel.commonutils.android.f.PlaceComponentResult(this.PlaceComponentResult)) {
                try {
                    map = ac.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext);
                } catch (Throwable unused) {
                }
            }
            ad.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, v.getAuthRequestContext(this.PlaceComponentResult, this.getAuthRequestContext, map));
        } catch (com.xiaomi.push.cd e) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
            this.PlaceComponentResult.a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public final String getAuthRequestContext() {
        return "send ack message for message.";
    }
}
