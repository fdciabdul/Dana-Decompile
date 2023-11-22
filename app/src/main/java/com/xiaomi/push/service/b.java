package com.xiaomi.push.service;

import com.xiaomi.push.cz;
import com.xiaomi.push.dt;
import com.xiaomi.push.ee;
import com.xiaomi.push.o;
import java.lang.ref.WeakReference;

/* loaded from: classes8.dex */
public class b extends o.a {
    private boolean BuiltInFictitiousFunctionClassFactory;
    private dt KClassImpl$Data$declaredNonStaticMembers$2;
    private WeakReference<XMPushService> PlaceComponentResult;

    public b(dt dtVar, WeakReference<XMPushService> weakReference, boolean z) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = dtVar;
        this.PlaceComponentResult = weakReference;
        this.BuiltInFictitiousFunctionClassFactory = z;
    }

    @Override // com.xiaomi.push.o.a
    public final String PlaceComponentResult() {
        return "22";
    }

    @Override // java.lang.Runnable
    public void run() {
        XMPushService xMPushService;
        WeakReference<XMPushService> weakReference = this.PlaceComponentResult;
        if (weakReference == null || this.KClassImpl$Data$declaredNonStaticMembers$2 == null || (xMPushService = weakReference.get()) == null) {
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.a(aw.MyBillsEntityDataFactory());
        this.KClassImpl$Data$declaredNonStaticMembers$2.a(false);
        StringBuilder sb = new StringBuilder();
        sb.append("MoleInfo aw_ping : send aw_Ping msg ");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2.m323a());
        com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory(sb.toString());
        try {
            String c = this.KClassImpl$Data$declaredNonStaticMembers$2.c();
            xMPushService.a(c, ee.PlaceComponentResult(ad.BuiltInFictitiousFunctionClassFactory(c, this.KClassImpl$Data$declaredNonStaticMembers$2.b(), this.KClassImpl$Data$declaredNonStaticMembers$2, cz.Notification)), this.BuiltInFictitiousFunctionClassFactory);
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("MoleInfo aw_ping : send help app ping error");
            sb2.append(e.toString());
            com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2(sb2.toString());
        }
    }
}
