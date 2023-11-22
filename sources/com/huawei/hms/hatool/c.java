package com.huawei.hms.hatool;

import java.util.Map;

/* loaded from: classes8.dex */
public abstract class c {
    public static boolean BuiltInFictitiousFunctionClassFactory(String str, String str2) {
        k DatabaseTableConfigUtil = DatabaseTableConfigUtil(str, str2);
        if (DatabaseTableConfigUtil != null) {
            return DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory();
        }
        return false;
    }

    private static k DatabaseTableConfigUtil(String str, String str2) {
        i.KClassImpl$Data$declaredNonStaticMembers$2();
        m PlaceComponentResult = i.PlaceComponentResult(str);
        if (PlaceComponentResult != null) {
            if ("alltype".equals(str2)) {
                k MyBillsEntityDataFactory = PlaceComponentResult.MyBillsEntityDataFactory("oper");
                return MyBillsEntityDataFactory == null ? PlaceComponentResult.MyBillsEntityDataFactory("maint") : MyBillsEntityDataFactory;
            }
            return PlaceComponentResult.MyBillsEntityDataFactory(str2);
        }
        return null;
    }

    public static boolean PlaceComponentResult(String str, String str2) {
        k DatabaseTableConfigUtil = DatabaseTableConfigUtil(str, str2);
        if (DatabaseTableConfigUtil != null) {
            return DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        return true;
    }

    public static boolean getAuthRequestContext(String str, String str2) {
        k DatabaseTableConfigUtil = DatabaseTableConfigUtil(str, str2);
        if (DatabaseTableConfigUtil != null) {
            return DatabaseTableConfigUtil.PlaceComponentResult();
        }
        return true;
    }

    public static void MyBillsEntityDataFactory(String str, String str2, long j) {
        k DatabaseTableConfigUtil = DatabaseTableConfigUtil(str, str2);
        if (DatabaseTableConfigUtil != null) {
            DatabaseTableConfigUtil.NetworkUserEntityData$$ExternalSyntheticLambda7 = j;
        }
    }

    public static int MyBillsEntityDataFactory(String str, String str2) {
        k DatabaseTableConfigUtil = DatabaseTableConfigUtil(str, str2);
        if (DatabaseTableConfigUtil != null) {
            return DatabaseTableConfigUtil.DatabaseTableConfigUtil;
        }
        return 7;
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2) {
        k DatabaseTableConfigUtil = DatabaseTableConfigUtil(str, str2);
        return DatabaseTableConfigUtil != null ? DatabaseTableConfigUtil.getAuthRequestContext : "";
    }

    public static String scheduleImpl(String str, String str2) {
        k DatabaseTableConfigUtil = DatabaseTableConfigUtil(str, str2);
        return DatabaseTableConfigUtil != null ? DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2 : "";
    }

    public static String getErrorConfigVersion(String str, String str2) {
        k DatabaseTableConfigUtil = DatabaseTableConfigUtil(str, str2);
        return DatabaseTableConfigUtil != null ? DatabaseTableConfigUtil.lookAheadTest : "";
    }

    public static Map<String, String> moveToNextValue(String str, String str2) {
        k DatabaseTableConfigUtil = DatabaseTableConfigUtil(str, str2);
        if (DatabaseTableConfigUtil != null) {
            return DatabaseTableConfigUtil.moveToNextValue;
        }
        return null;
    }

    public static long lookAheadTest(String str, String str2) {
        k DatabaseTableConfigUtil = DatabaseTableConfigUtil(str, str2);
        if (DatabaseTableConfigUtil != null) {
            return DatabaseTableConfigUtil.NetworkUserEntityData$$ExternalSyntheticLambda7;
        }
        return 0L;
    }

    public static int NetworkUserEntityData$$ExternalSyntheticLambda0(String str, String str2) {
        k DatabaseTableConfigUtil = DatabaseTableConfigUtil(str, str2);
        if (DatabaseTableConfigUtil != null) {
            return DatabaseTableConfigUtil.GetContactSyncConfig;
        }
        return 10;
    }

    public static String NetworkUserEntityData$$ExternalSyntheticLambda2(String str, String str2) {
        k DatabaseTableConfigUtil = DatabaseTableConfigUtil(str, str2);
        return DatabaseTableConfigUtil != null ? DatabaseTableConfigUtil.MyBillsEntityDataFactory : "";
    }

    public static String NetworkUserEntityData$$ExternalSyntheticLambda1(String str, String str2) {
        k DatabaseTableConfigUtil = DatabaseTableConfigUtil(str, str2);
        return DatabaseTableConfigUtil != null ? DatabaseTableConfigUtil.NetworkUserEntityData$$ExternalSyntheticLambda0 : "";
    }

    public static String initRecordTimeStamp(String str, String str2) {
        k DatabaseTableConfigUtil = DatabaseTableConfigUtil(str, str2);
        return DatabaseTableConfigUtil != null ? DatabaseTableConfigUtil.newProxyInstance : "";
    }

    public static String GetContactSyncConfig(String str, String str2) {
        k DatabaseTableConfigUtil = DatabaseTableConfigUtil(str, str2);
        return DatabaseTableConfigUtil != null ? DatabaseTableConfigUtil.getErrorConfigVersion : "";
    }
}
