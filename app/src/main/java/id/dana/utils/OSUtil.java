package id.dana.utils;

import android.os.Build;

/* loaded from: classes.dex */
public class OSUtil {
    public static boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return Build.VERSION.SDK_INT >= 17;
    }

    public static boolean getAuthRequestContext() {
        return Build.VERSION.SDK_INT >= 18;
    }

    public static boolean PlaceComponentResult() {
        return Build.VERSION.SDK_INT <= 18;
    }

    public static boolean getErrorConfigVersion() {
        return Build.VERSION.SDK_INT >= 19;
    }

    public static boolean scheduleImpl() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static boolean lookAheadTest() {
        return Build.VERSION.SDK_INT >= 22;
    }

    public static boolean GetContactSyncConfig() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean moveToNextValue() {
        return Build.VERSION.SDK_INT > 23;
    }

    public static boolean NetworkUserEntityData$$ExternalSyntheticLambda2() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean NetworkUserEntityData$$ExternalSyntheticLambda1() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean initRecordTimeStamp() {
        return Build.VERSION.SDK_INT == 24 || Build.VERSION.SDK_INT == 25;
    }

    public static boolean DatabaseTableConfigUtil() {
        return Build.VERSION.SDK_INT == 26 || Build.VERSION.SDK_INT == 27;
    }

    public static boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return Build.VERSION.SDK_INT <= 22;
    }

    public static boolean PrepareContext() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public static boolean MyBillsEntityDataFactory() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static boolean BuiltInFictitiousFunctionClassFactory() {
        return Build.VERSION.SDK_INT >= 30;
    }
}
