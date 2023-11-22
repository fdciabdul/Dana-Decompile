package com.xiaomi.push.service;

import com.xiaomi.push.dq;
import java.util.Map;

/* loaded from: classes8.dex */
public class ac {
    private static a KClassImpl$Data$declaredNonStaticMembers$2;
    private static b PlaceComponentResult;

    /* loaded from: classes8.dex */
    public interface a {
        boolean BuiltInFictitiousFunctionClassFactory();

        Map<String, String> MyBillsEntityDataFactory();
    }

    /* loaded from: classes8.dex */
    public interface b {
        boolean KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static Map<String, String> BuiltInFictitiousFunctionClassFactory(dq dqVar) {
        a aVar = KClassImpl$Data$declaredNonStaticMembers$2;
        if (aVar == null || dqVar == null) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("pepa listener or container is null");
            return null;
        }
        return aVar.MyBillsEntityDataFactory();
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(dq dqVar) {
        if (PlaceComponentResult == null || dqVar == null) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("pepa clearMessage is null");
        }
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        if (PlaceComponentResult == null || str == null) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("pepa clearMessage is null");
        }
    }

    public static boolean MyBillsEntityDataFactory(dq dqVar) {
        b bVar = PlaceComponentResult;
        if (bVar == null || dqVar == null) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("pepa handleReceiveMessage is null");
            return false;
        }
        return bVar.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static void PlaceComponentResult(dq dqVar) {
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null || dqVar == null) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("handle msg wrong");
        }
    }

    public static boolean getAuthRequestContext(dq dqVar) {
        a aVar = KClassImpl$Data$declaredNonStaticMembers$2;
        if (aVar == null || dqVar == null) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("pepa judement listener or container is null");
            return false;
        }
        return aVar.BuiltInFictitiousFunctionClassFactory();
    }
}
