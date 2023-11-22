package com.huawei.hms.framework.common;

import android.text.TextUtils;

/* loaded from: classes7.dex */
public class SystemPropUtils {
    private static final String getAuthRequestContext = "SystemPropUtils";

    public static String getProperty(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            Logger.w(getAuthRequestContext, "reflect class for method has exception.");
            return str4;
        }
        try {
            Class<?> cls = Class.forName(str3);
            String str5 = (String) cls.getMethod(str, String.class, String.class).invoke(cls, str2, str4);
            String str6 = str5;
            return str5;
        } catch (Exception e) {
            Logger.e(getAuthRequestContext, "getProperty catch exception: ", e);
            return str4;
        }
    }
}
