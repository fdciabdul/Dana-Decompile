package com.alibaba.griver.base.common.utils;

import java.io.File;

/* loaded from: classes2.dex */
public class AOMPDeviceUtils {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f6305a;

    public static boolean isRooted() {
        Boolean bool = f6305a;
        if (bool == null) {
            Object obj = null;
            boolean z = false;
            boolean z2 = true;
            try {
                obj = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, "ro.secure");
            } catch (Throwable unused) {
            }
            if ((obj == null || !"1".equals(obj)) && obj != null && "0".equals(obj)) {
                z = true;
            }
            if (z || (!new File("/system/bin/su").exists() && !new File("/system/xbin/su").exists())) {
                z2 = z;
            }
            Boolean valueOf = Boolean.valueOf(z2);
            f6305a = valueOf;
            return valueOf.booleanValue();
        }
        return bool.booleanValue();
    }

    public static String formatFileSize(long j) {
        String str;
        float f = (float) j;
        if (f > 900.0f) {
            f /= 1000.0f;
            str = " KB";
        } else {
            str = " B";
        }
        if (f > 900.0f) {
            f /= 1000.0f;
            str = " MB";
        }
        if (f > 900.0f) {
            f /= 1000.0f;
            str = " GB";
        }
        if (f > 900.0f) {
            f /= 1000.0f;
            str = " TB";
        }
        if (f > 900.0f) {
            f /= 1000.0f;
            str = " PB";
        }
        String str2 = (f < 1.0f || f < 10.0f || f < 100.0f) ? "%.2f" : "%.0f";
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(str2, Float.valueOf(f)));
        sb.append(str);
        return sb.toString();
    }
}
