package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.n;

/* loaded from: classes8.dex */
class ca extends XMPushService.j {
    final /* synthetic */ long KClassImpl$Data$declaredNonStaticMembers$2;
    final /* synthetic */ bz PlaceComponentResult;
    final /* synthetic */ long getAuthRequestContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ca(bz bzVar, long j, long j2) {
        super(13);
        this.PlaceComponentResult = bzVar;
        this.getAuthRequestContext = j;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j2;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public final String getAuthRequestContext() {
        StringBuilder sb = new StringBuilder();
        sb.append("check the ping-pong.");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        return sb.toString();
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        Thread.yield();
        if (!this.PlaceComponentResult.moveToNextValue() || this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext)) {
            return;
        }
        com.xiaomi.push.service.n KClassImpl$Data$declaredNonStaticMembers$2 = com.xiaomi.push.service.n.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult.PrepareContext);
        if (KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext()) {
            int i = KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
            String KClassImpl$Data$declaredNonStaticMembers$22 = i != 0 ? i != 1 ? null : n.a.KClassImpl$Data$declaredNonStaticMembers$2() : n.a.getAuthRequestContext();
            if (!TextUtils.isEmpty(KClassImpl$Data$declaredNonStaticMembers$22)) {
                if (KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.getLong(n.a.PlaceComponentResult(), -1L) == -1) {
                    KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = System.currentTimeMillis();
                    KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.edit().putLong(n.a.PlaceComponentResult(), KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory).apply();
                }
                KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.edit().putInt(KClassImpl$Data$declaredNonStaticMembers$22, KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.getInt(KClassImpl$Data$declaredNonStaticMembers$22, 0) + 1).apply();
            }
            if (KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl && !TextUtils.isEmpty(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult) && KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.equals(KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue)) {
                KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0.getAndIncrement();
                StringBuilder sb = new StringBuilder();
                sb.append("[HB] ping timeout count:");
                sb.append(KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0);
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
                if (KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("[HB] change hb interval for net:");
                    sb2.append(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult);
                    com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
                    String str = KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult;
                    if (com.xiaomi.push.service.n.KClassImpl$Data$declaredNonStaticMembers$2(str)) {
                        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.edit().putInt(n.a.getAuthRequestContext(str), 235000).apply();
                        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.edit().putLong(n.a.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult), System.currentTimeMillis() + 777600000).apply();
                    }
                    KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl = false;
                    KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0.getAndSet(0);
                    String str2 = KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult;
                }
            }
        }
        this.PlaceComponentResult.PrepareContext.a(22, (Exception) null);
    }
}
