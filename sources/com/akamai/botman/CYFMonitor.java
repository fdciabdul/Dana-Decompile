package com.akamai.botman;

import android.app.Activity;
import android.app.Application;
import id.dana.R;

/* loaded from: classes.dex */
public class CYFMonitor {

    /* loaded from: classes.dex */
    public interface ChallengeActionCallback {
        void BuiltInFictitiousFunctionClassFactory(String str);

        void MyBillsEntityDataFactory();
    }

    public static void PlaceComponentResult(Application application, String str) {
        synchronized (CYFMonitor.class) {
            com.cyberfend.cyfsecurity.CYFMonitor.KClassImpl$Data$declaredNonStaticMembers$2(application, str);
        }
    }

    public static void getAuthRequestContext(Application application, String str) {
        synchronized (CYFMonitor.class) {
            if (str != null) {
                if (str.length() > 0) {
                    x KClassImpl$Data$declaredNonStaticMembers$2 = x.KClassImpl$Data$declaredNonStaticMembers$2();
                    KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = str;
                    KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest = r.KClassImpl$Data$declaredNonStaticMembers$2(application);
                }
            }
        }
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2() {
        String PlaceComponentResult;
        synchronized (CYFMonitor.class) {
            PlaceComponentResult = com.cyberfend.cyfsecurity.CYFMonitor.PlaceComponentResult();
        }
        return PlaceComponentResult;
    }

    public static boolean PlaceComponentResult(Activity activity, String str, ChallengeActionCallback challengeActionCallback) {
        return MyBillsEntityDataFactory(activity, str, activity.getString(R.string.akamai_verify_dialog_title), activity.getString(R.string.akamai_verify_dialog_desc), activity.getString(R.string.option_cancel), challengeActionCallback);
    }

    private static boolean MyBillsEntityDataFactory(Activity activity, String str, String str2, String str3, String str4, ChallengeActionCallback challengeActionCallback) {
        return a.getAuthRequestContext().PlaceComponentResult(activity, str2, str3, str4, challengeActionCallback, str);
    }
}
