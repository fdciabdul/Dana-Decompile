package com.xiaomi.push.service;

import android.os.Messenger;
import android.text.TextUtils;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.xiaomi.push.au;
import com.xiaomi.push.cz;
import com.xiaomi.push.df;
import com.xiaomi.push.dk;
import com.xiaomi.push.dq;
import com.xiaomi.push.dt;
import com.xiaomi.push.ee;
import com.xiaomi.push.ef;
import com.xiaomi.push.ej;
import com.xiaomi.push.service.az;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
public final class ad {
    public static <T extends ef<T, ?>> dq BuiltInFictitiousFunctionClassFactory(String str, String str2, T t, cz czVar) {
        return PlaceComponentResult(str, str2, t, czVar, true);
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(XMPushService xMPushService, dq dqVar) {
        com.xiaomi.push.bt m385a = xMPushService.m385a();
        if (m385a == null) {
            throw new com.xiaomi.push.cd("try send msg while connection is null.");
        }
        if (!m385a.KClassImpl$Data$declaredNonStaticMembers$2()) {
            throw new com.xiaomi.push.cd("Don't support XMPP connection.");
        }
        com.xiaomi.push.bi MyBillsEntityDataFactory = MyBillsEntityDataFactory(r.KClassImpl$Data$declaredNonStaticMembers$2(xMPushService), dqVar);
        if (MyBillsEntityDataFactory != null) {
            m385a.PlaceComponentResult(MyBillsEntityDataFactory);
        }
    }

    public static <T extends ef<T, ?>> dq MyBillsEntityDataFactory(String str, String str2, T t, cz czVar) {
        return PlaceComponentResult(str, str2, t, czVar, false);
    }

    private static com.xiaomi.push.bi PlaceComponentResult(XMPushService xMPushService, byte[] bArr) {
        dq dqVar = new dq();
        try {
            ee.BuiltInFictitiousFunctionClassFactory(dqVar, bArr);
            return MyBillsEntityDataFactory(r.KClassImpl$Data$declaredNonStaticMembers$2(xMPushService), dqVar);
        } catch (ej e) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
            return null;
        }
    }

    private static <T extends ef<T, ?>> dq PlaceComponentResult(String str, String str2, T t, cz czVar, boolean z) {
        byte[] PlaceComponentResult = ee.PlaceComponentResult(t);
        dq dqVar = new dq();
        dk dkVar = new dk();
        dkVar.f152a = 5L;
        dkVar.f153a = "fakeid";
        dqVar.a(dkVar);
        dqVar.a(ByteBuffer.wrap(PlaceComponentResult));
        dqVar.a(czVar);
        dqVar.b(z);
        dqVar.b(str);
        dqVar.a(false);
        dqVar.a(str2);
        return dqVar;
    }

    public static String getAuthRequestContext(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(".permission.MIPUSH_RECEIVE");
        return sb.toString();
    }

    public static void getAuthRequestContext(XMPushService xMPushService, String str, byte[] bArr) {
        com.xiaomi.push.bt m385a = xMPushService.m385a();
        if (m385a == null) {
            throw new com.xiaomi.push.cd("try send msg while connection is null.");
        }
        if (!m385a.KClassImpl$Data$declaredNonStaticMembers$2()) {
            throw new com.xiaomi.push.cd("Don't support XMPP connection.");
        }
        com.xiaomi.push.bi PlaceComponentResult = PlaceComponentResult(xMPushService, bArr);
        if (PlaceComponentResult != null) {
            m385a.PlaceComponentResult(PlaceComponentResult);
        } else {
            u.BuiltInFictitiousFunctionClassFactory(xMPushService, str, bArr, 70000003, "not a valid message");
        }
    }

    private static com.xiaomi.push.bi MyBillsEntityDataFactory(q qVar, dq dqVar) {
        String str;
        try {
            com.xiaomi.push.bi biVar = new com.xiaomi.push.bi();
            au.a aVar = biVar.PlaceComponentResult;
            aVar.getAuthRequestContext = true;
            aVar.PlaceComponentResult = 5;
            biVar.BuiltInFictitiousFunctionClassFactory(qVar.BuiltInFictitiousFunctionClassFactory);
            if (dqVar.f223a != null && dqVar.f223a.f143b != null) {
                str = dqVar.f223a.f143b.get("ext_traffic_source_pkg");
                if (!TextUtils.isEmpty(str)) {
                    biVar.getAuthRequestContext = str;
                    biVar.getAuthRequestContext("SECMSG", "message");
                    String str2 = qVar.BuiltInFictitiousFunctionClassFactory;
                    dqVar.f224a.f153a = str2.substring(0, str2.indexOf(AUScreenAdaptTool.PREFIX_ID));
                    dqVar.f224a.f157c = str2.substring(str2.indexOf("/") + 1);
                    biVar.BuiltInFictitiousFunctionClassFactory(ee.PlaceComponentResult(dqVar), qVar.KClassImpl$Data$declaredNonStaticMembers$2);
                    biVar.MyBillsEntityDataFactory = (short) 1;
                    StringBuilder sb = new StringBuilder();
                    sb.append("try send mi push message. packagename:");
                    sb.append(dqVar.f229b);
                    sb.append(" action:");
                    sb.append(dqVar.f222a);
                    com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
                    return biVar;
                }
            }
            str = dqVar.f229b;
            biVar.getAuthRequestContext = str;
            biVar.getAuthRequestContext("SECMSG", "message");
            String str22 = qVar.BuiltInFictitiousFunctionClassFactory;
            dqVar.f224a.f153a = str22.substring(0, str22.indexOf(AUScreenAdaptTool.PREFIX_ID));
            dqVar.f224a.f157c = str22.substring(str22.indexOf("/") + 1);
            biVar.BuiltInFictitiousFunctionClassFactory(ee.PlaceComponentResult(dqVar), qVar.KClassImpl$Data$declaredNonStaticMembers$2);
            biVar.MyBillsEntityDataFactory = (short) 1;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("try send mi push message. packagename:");
            sb2.append(dqVar.f229b);
            sb2.append(" action:");
            sb2.append(dqVar.f222a);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
            return biVar;
        } catch (NullPointerException e) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
            return null;
        }
    }

    public static dq PlaceComponentResult(String str, String str2) {
        dt dtVar = new dt();
        dtVar.b(str2);
        dtVar.c("package uninstalled");
        dtVar.a(com.xiaomi.push.cj.BuiltInFictitiousFunctionClassFactory());
        dtVar.a(false);
        return PlaceComponentResult(str, str2, dtVar, cz.Notification, true);
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(XMPushService xMPushService) {
        q KClassImpl$Data$declaredNonStaticMembers$2 = r.KClassImpl$Data$declaredNonStaticMembers$2(xMPushService.getApplicationContext());
        if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            q KClassImpl$Data$declaredNonStaticMembers$22 = r.KClassImpl$Data$declaredNonStaticMembers$2(xMPushService.getApplicationContext());
            az.b bVar = new az.b(xMPushService);
            KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory(bVar, xMPushService, xMPushService.m390b(), "c");
            StringBuilder sb = new StringBuilder();
            sb.append("prepare account. ");
            sb.append(bVar.NetworkUserEntityData$$ExternalSyntheticLambda0);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
            bVar.BuiltInFictitiousFunctionClassFactory((Messenger) null);
            bVar.moveToNextValue.add(new af(xMPushService));
            az.BuiltInFictitiousFunctionClassFactory().getAuthRequestContext(bVar);
            bp authRequestContext = bp.getAuthRequestContext(xMPushService);
            ae aeVar = new ae("GAID", xMPushService, KClassImpl$Data$declaredNonStaticMembers$2);
            if (authRequestContext.PlaceComponentResult.putIfAbsent(aeVar.BuiltInFictitiousFunctionClassFactory, aeVar) == null) {
                com.xiaomi.push.o.PlaceComponentResult(authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2).BuiltInFictitiousFunctionClassFactory.schedule(aeVar, ((int) (Math.random() * 30.0d)) + 10, TimeUnit.SECONDS);
            }
        }
    }

    public static void PlaceComponentResult(XMPushService xMPushService, az.b bVar) {
        bVar.BuiltInFictitiousFunctionClassFactory((Messenger) null);
        bVar.moveToNextValue.add(new af(xMPushService));
    }

    public static dq getAuthRequestContext(String str, String str2) {
        dt dtVar = new dt();
        dtVar.b(str2);
        dtVar.c(df.AppDataCleared.f104a);
        dtVar.a(aw.MyBillsEntityDataFactory());
        dtVar.a(false);
        return PlaceComponentResult(str, str2, dtVar, cz.Notification, true);
    }
}
