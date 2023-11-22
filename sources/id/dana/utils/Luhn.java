package id.dana.utils;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.utils.foundation.logger.log.DanaLog;

/* loaded from: classes5.dex */
public class Luhn {
    public static boolean getAuthRequestContext(String str) {
        try {
            return str.isEmpty() || Double.parseDouble(str) < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory("Luhn Algorithm", e.getMessage(), e);
            return true;
        }
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        int parseInt = Integer.parseInt(String.valueOf(i).substring(r1.length() - 1));
        return parseInt == 0 ? "0" : String.valueOf(10 - parseInt);
    }

    public static int getAuthRequestContext(String str, int i) {
        return Integer.parseInt(str.substring(i, i + 1));
    }
}
