package com.xiaomi.push;

/* loaded from: classes8.dex */
public class j {
    public static final boolean BuiltInFictitiousFunctionClassFactory;
    public static final boolean KClassImpl$Data$declaredNonStaticMembers$2;
    public static final String MyBillsEntityDataFactory;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0;
    public static final boolean PlaceComponentResult;
    public static final boolean getAuthRequestContext;
    public static final boolean getErrorConfigVersion;
    public static boolean lookAheadTest;
    public static final boolean scheduleImpl;

    static {
        int i;
        String str = l.MyBillsEntityDataFactory ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        MyBillsEntityDataFactory = str;
        boolean contains = str.contains("2A2FE0D7");
        KClassImpl$Data$declaredNonStaticMembers$2 = contains;
        getAuthRequestContext = contains || "DEBUG".equalsIgnoreCase(str);
        BuiltInFictitiousFunctionClassFactory = "LOGABLE".equalsIgnoreCase(str);
        PlaceComponentResult = str.contains("YY");
        lookAheadTest = str.equalsIgnoreCase("TEST");
        getErrorConfigVersion = "BETA".equalsIgnoreCase(str);
        scheduleImpl = str.startsWith("RC");
        NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
        if (str.equalsIgnoreCase("SANDBOX")) {
            i = 2;
        } else if (!str.equalsIgnoreCase("ONEBOX")) {
            NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
            return;
        } else {
            i = 3;
        }
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
    }

    public static boolean BuiltInFictitiousFunctionClassFactory() {
        return NetworkUserEntityData$$ExternalSyntheticLambda0 == 3;
    }

    public static int MyBillsEntityDataFactory() {
        return NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    public static void PlaceComponentResult(int i) {
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
    }

    public static boolean getAuthRequestContext() {
        return NetworkUserEntityData$$ExternalSyntheticLambda0 == 2;
    }
}
