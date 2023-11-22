package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;

/* loaded from: classes.dex */
public final class am {
    private static String AFInAppEventParameterName;
    private static String values;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void valueOf(String str) {
        AFInAppEventParameterName = str;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 || i == str.length() - 1) {
                sb.append(str.charAt(i));
            } else {
                sb.append("*");
            }
        }
        values = sb.toString();
    }

    public static void AFKeystoreWrapper(String str) {
        if (AFInAppEventParameterName == null) {
            valueOf(AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY));
        }
        String str2 = AFInAppEventParameterName;
        if (str2 != null) {
            AFLogger.AFKeystoreWrapper(str.replace(str2, values));
        }
    }
}
