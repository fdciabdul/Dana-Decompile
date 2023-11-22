package com.uc.crashsdk.a;

/* loaded from: classes8.dex */
public final class h {
    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean a(StringBuffer stringBuffer) {
        return stringBuffer == null || stringBuffer.length() == 0;
    }

    public static boolean b(String str) {
        return !a(str);
    }

    public static long c(String str) {
        if (a(str)) {
            return 0L;
        }
        try {
            long parseLong = Long.parseLong(str.trim());
            if (parseLong < 0) {
                return 0L;
            }
            return parseLong;
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }
}
