package com.ta.audid.g;

/* loaded from: classes.dex */
public class i {
    public static String get(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls.newInstance(), str);
        } catch (Exception e) {
            m.e("", "get() ERROR!!! Exception!", e);
            return "";
        }
    }

    public static String get(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls.newInstance(), str, str2);
        } catch (Exception e) {
            m.e("", "get() ERROR!!! Exception!", e);
            return "";
        }
    }
}
