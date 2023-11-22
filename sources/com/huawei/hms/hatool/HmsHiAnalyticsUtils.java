package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import java.util.LinkedHashMap;

/* loaded from: classes8.dex */
public class HmsHiAnalyticsUtils {
    public static void BuiltInFictitiousFunctionClassFactory() {
        l1.getAuthRequestContext();
    }

    public static void BuiltInFictitiousFunctionClassFactory(Context context, String str, String str2) {
        String str3;
        m1 m1Var = new m1(context);
        y.BuiltInFictitiousFunctionClassFactory("hmsSdk", "Builder.setEnableImei(boolean isReportAndroidImei) is execute.");
        m1Var.getAuthRequestContext.scheduleImpl.BuiltInFictitiousFunctionClassFactory = false;
        m1Var.MyBillsEntityDataFactory.scheduleImpl.BuiltInFictitiousFunctionClassFactory = false;
        y.BuiltInFictitiousFunctionClassFactory("hmsSdk", "Builder.setEnableUDID(boolean isReportUDID) is execute.");
        m1Var.getAuthRequestContext.scheduleImpl.PlaceComponentResult = false;
        m1Var.MyBillsEntityDataFactory.scheduleImpl.PlaceComponentResult = false;
        y.BuiltInFictitiousFunctionClassFactory("hmsSdk", "Builder.setEnableSN(boolean isReportSN) is execute.");
        m1Var.getAuthRequestContext.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        m1Var.MyBillsEntityDataFactory.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        m1 KClassImpl$Data$declaredNonStaticMembers$2 = m1Var.KClassImpl$Data$declaredNonStaticMembers$2(0, str).KClassImpl$Data$declaredNonStaticMembers$2(1, str);
        y.BuiltInFictitiousFunctionClassFactory("hmsSdk", "Builder.setAppID is execute");
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = str2;
        if (KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            y.getAuthRequestContext("hmsSdk", "analyticsConf create(): context is null,create failed!");
            return;
        }
        y.BuiltInFictitiousFunctionClassFactory("hmsSdk", "Builder.create() is execute.");
        j1 j1Var = new j1("_hms_config_tag");
        k kVar = new k(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext);
        StringBuilder sb = new StringBuilder();
        sb.append("HiAnalyticsInstanceImpl.setOperConf() is executed.TAG: ");
        sb.append(j1Var.getAuthRequestContext);
        y.BuiltInFictitiousFunctionClassFactory("hmsSdk", sb.toString());
        j1Var.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = kVar;
        k kVar2 = new k(KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("HiAnalyticsInstanceImpl.setMaintConf() is executed.TAG : ");
        sb2.append(j1Var.getAuthRequestContext);
        y.BuiltInFictitiousFunctionClassFactory("hmsSdk", sb2.toString());
        j1Var.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = kVar2;
        h1 PlaceComponentResult = h1.PlaceComponentResult();
        Context context2 = KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2;
        synchronized (h1.BuiltInFictitiousFunctionClassFactory) {
            if (PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                y.moveToNextValue("hmsSdk", "DataManager already initialized.");
            } else {
                PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = context2;
                i.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory.initRecordTimeStamp = PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
                i.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = context2.getPackageName();
                z0 authRequestContext = z0.getAuthRequestContext();
                if (authRequestContext.MyBillsEntityDataFactory == null) {
                    authRequestContext.MyBillsEntityDataFactory = context2;
                }
            }
        }
        i1 MyBillsEntityDataFactory = i1.MyBillsEntityDataFactory();
        Context context3 = KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2;
        synchronized (MyBillsEntityDataFactory.PlaceComponentResult) {
            if (MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = context3;
                h0.BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory = context3;
                String PlaceComponentResult2 = f.PlaceComponentResult(context3);
                b.MyBillsEntityDataFactory(PlaceComponentResult2);
                if (w0.BuiltInFictitiousFunctionClassFactory().PlaceComponentResult()) {
                    String MyBillsEntityDataFactory2 = g0.MyBillsEntityDataFactory(context3, "global_v2", "app_ver", "");
                    g0.getAuthRequestContext(context3, "global_v2", "app_ver", PlaceComponentResult2);
                    b.PlaceComponentResult();
                    if (TextUtils.isEmpty(MyBillsEntityDataFactory2)) {
                        str3 = "app ver is first save!";
                    } else {
                        if (!MyBillsEntityDataFactory2.equals(PlaceComponentResult2)) {
                            y.BuiltInFictitiousFunctionClassFactory("hmsSdk", "the appVers are different!");
                            h0.BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory("", "alltype", MyBillsEntityDataFactory2);
                        }
                        i.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory.getAuthRequestContext = f.KClassImpl$Data$declaredNonStaticMembers$2();
                    }
                } else {
                    str3 = "userManager.isUserUnlocked() == false";
                }
                y.BuiltInFictitiousFunctionClassFactory("hmsSdk", str3);
                i.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory.getAuthRequestContext = f.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }
        o1.BuiltInFictitiousFunctionClassFactory().getAuthRequestContext = j1Var;
        h1 PlaceComponentResult3 = h1.PlaceComponentResult();
        String str4 = KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
        y.BuiltInFictitiousFunctionClassFactory("hmsSdk", "HiAnalyticsDataManager.setAppid(String appid) is execute.");
        Context context4 = PlaceComponentResult3.KClassImpl$Data$declaredNonStaticMembers$2;
        if (context4 == null) {
            y.PlaceComponentResult("hmsSdk", "sdk is not init");
        } else {
            i.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory.MyBillsEntityDataFactory = s0.KClassImpl$Data$declaredNonStaticMembers$2("appID", str4, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}", context4.getPackageName());
        }
    }

    public static void MyBillsEntityDataFactory(Context context, String str, String str2) {
        l1.MyBillsEntityDataFactory(context, str, str2);
    }

    public static boolean MyBillsEntityDataFactory() {
        return l1.MyBillsEntityDataFactory();
    }

    public static void getAuthRequestContext() {
        n1.BuiltInFictitiousFunctionClassFactory();
    }

    public static void PlaceComponentResult(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        l1.getAuthRequestContext(i, str, linkedHashMap);
    }
}
