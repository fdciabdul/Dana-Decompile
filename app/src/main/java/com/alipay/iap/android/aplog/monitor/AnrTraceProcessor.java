package com.alipay.iap.android.aplog.monitor;

import android.text.TextUtils;

/* loaded from: classes6.dex */
public class AnrTraceProcessor {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String[] split = str.split("\n");
        boolean z = false;
        int a2 = a(split, "\"main\"", null, null, 0);
        if (a2 >= 0) {
            for (int i = a2 + 5; i < split.length; i++) {
                String str2 = split[i];
                if (str2.startsWith("  at ")) {
                    sb.append(str2.trim());
                    sb.append("\n");
                    z = true;
                } else if ((z && !str2.startsWith("  - waiting on ") && !str2.startsWith("  - locked ") && !str2.startsWith("  - sleeping on ") && !str2.startsWith("  - waiting to lock ") && !str2.startsWith("  ... repeated ")) || TextUtils.isEmpty(str2) || str2.contains("sysTid") || str2.contains("(no managed stack frames)") || str2.contains("--- --- --- --- ---")) {
                    break;
                }
            }
        }
        return sb.toString();
    }

    private static int a(String[] strArr, String str, String str2, String str3, int i) {
        if (strArr == null || i > strArr.length - 1) {
            return -1;
        }
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        boolean isEmpty3 = TextUtils.isEmpty(str3);
        while (i < strArr.length) {
            String str4 = strArr[i];
            if (str4 != null) {
                boolean z = !(isEmpty ^ true) || str4.startsWith(str);
                if ((!isEmpty2) != false && !strArr[i].endsWith(str2)) {
                    z = false;
                }
                if ((!(isEmpty3 ^ true) || strArr[i].contains(str3)) ? z : false) {
                    return i;
                }
            }
            i++;
        }
        return -1;
    }
}
