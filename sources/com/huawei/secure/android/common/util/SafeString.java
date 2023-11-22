package com.huawei.secure.android.common.util;

import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes8.dex */
public class SafeString {
    private static final String BuiltInFictitiousFunctionClassFactory = "SafeString";

    public static String replace(String str, CharSequence charSequence, CharSequence charSequence2) {
        if (str != null && charSequence != null && charSequence2 != null) {
            try {
                return str.replace(charSequence, charSequence2);
            } catch (Exception e) {
                String str2 = BuiltInFictitiousFunctionClassFactory;
                StringBuilder sb = new StringBuilder();
                sb.append("replace: ");
                sb.append(e.getMessage());
                InstrumentInjector.log_e(str2, sb.toString());
            }
        }
        return str;
    }

    public static String substring(String str, int i) {
        if (str == null || str.length() < i || i < 0) {
            return "";
        }
        try {
            return str.substring(i);
        } catch (Exception e) {
            String str2 = BuiltInFictitiousFunctionClassFactory;
            StringBuilder sb = new StringBuilder();
            sb.append("substring exception: ");
            sb.append(e.getMessage());
            InstrumentInjector.log_e(str2, sb.toString());
            return "";
        }
    }

    public static String substring(String str, int i, int i2) {
        if (str == null || i < 0 || i2 > str.length() || i2 < i) {
            return "";
        }
        try {
            return str.substring(i, i2);
        } catch (Exception e) {
            String str2 = BuiltInFictitiousFunctionClassFactory;
            StringBuilder sb = new StringBuilder();
            sb.append("substring: ");
            sb.append(e.getMessage());
            InstrumentInjector.log_e(str2, sb.toString());
            return "";
        }
    }
}
