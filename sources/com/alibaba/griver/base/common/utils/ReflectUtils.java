package com.alibaba.griver.base.common.utils;

import android.text.TextUtils;
import com.alibaba.griver.base.common.logger.GriverLogger;
import java.lang.reflect.Field;

/* loaded from: classes3.dex */
public class ReflectUtils {
    public static boolean classExist(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("check class, just print");
            sb.append(th);
            GriverLogger.w("ReflectUtils", sb.toString());
            return false;
        }
    }

    public static boolean methodExist(String str, String str2) {
        return methodExist(str, str2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004f A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean methodExist(java.lang.String r3, java.lang.String r4, java.lang.Class[] r5) {
        /*
            java.lang.String r0 = "ReflectUtils"
            boolean r1 = android.text.TextUtils.isEmpty(r3)
            r2 = 0
            if (r1 != 0) goto L66
            boolean r1 = android.text.TextUtils.isEmpty(r4)
            if (r1 != 0) goto L66
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.Throwable -> L51
            r1 = 0
            if (r5 != 0) goto L33
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L1d
            java.lang.reflect.Method r1 = r3.getDeclaredMethod(r4, r5)     // Catch: java.lang.Throwable -> L1d
            goto L4d
        L1d:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L51
            r4.<init>()     // Catch: java.lang.Throwable -> L51
            java.lang.String r5 = "check class cls is null, just print"
            r4.append(r5)     // Catch: java.lang.Throwable -> L51
            r4.append(r3)     // Catch: java.lang.Throwable -> L51
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L51
            com.alibaba.griver.base.common.logger.GriverLogger.d(r0, r3)     // Catch: java.lang.Throwable -> L51
            goto L4d
        L33:
            java.lang.reflect.Method r1 = r3.getDeclaredMethod(r4, r5)     // Catch: java.lang.Throwable -> L38
            goto L4d
        L38:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L51
            r4.<init>()     // Catch: java.lang.Throwable -> L51
            java.lang.String r5 = "check class cls not null, just print"
            r4.append(r5)     // Catch: java.lang.Throwable -> L51
            r4.append(r3)     // Catch: java.lang.Throwable -> L51
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L51
            com.alibaba.griver.base.common.logger.GriverLogger.w(r0, r3)     // Catch: java.lang.Throwable -> L51
        L4d:
            if (r1 == 0) goto L50
            r2 = 1
        L50:
            return r2
        L51:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "check class error, just print"
            r4.append(r5)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.alibaba.griver.base.common.logger.GriverLogger.d(r0, r3)
        L66:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.common.utils.ReflectUtils.methodExist(java.lang.String, java.lang.String, java.lang.Class[]):boolean");
    }

    public static <T> T getFieldValue(Field field, Object obj) {
        if (field != null) {
            try {
                field.setAccessible(true);
                return (T) field.get(obj);
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public static <T> T getFieldValue(Class cls, String str, Object obj) {
        Field field;
        if (TextUtils.isEmpty(str) || (field = getField(cls, str)) == null) {
            return null;
        }
        try {
            field.setAccessible(true);
            return (T) field.get(obj);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Field getField(Class cls, String str) {
        if (cls != null) {
            try {
                return cls.getDeclaredField(str);
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }
}
