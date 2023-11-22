package com.alibaba.ariver.kernel.common.system;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.ReflectUtils;
import java.lang.reflect.Method;

/* loaded from: classes6.dex */
public class SystemPropertiesCompat {

    /* renamed from: a  reason: collision with root package name */
    private static Method f6157a;
    private static Method b;
    private static Method c;

    static {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            f6157a = ReflectUtils.getMethod(cls, "get", String.class);
            b = ReflectUtils.getMethod(cls, "get", String.class, String.class);
            c = ReflectUtils.getMethod(cls, "getBoolean", String.class, Boolean.TYPE);
        } catch (Throwable th) {
            RVLogger.e("SystemPropertiesWrapper", th);
        }
    }

    public static String get(String str) {
        Method method = f6157a;
        if (method != null) {
            try {
                return (String) method.invoke(null, str);
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("fail get ");
                sb.append(str);
                RVLogger.e("SystemPropertiesWrapper", sb.toString(), th);
            }
        }
        return null;
    }

    public static String get(String str, String str2) {
        Method method = b;
        if (method != null) {
            try {
                return (String) method.invoke(null, str, str2);
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("fail get ");
                sb.append(str);
                sb.append(", return default: ");
                sb.append(str2);
                RVLogger.e("SystemPropertiesWrapper", sb.toString(), th);
            }
        }
        return str2;
    }

    public static boolean getBoolean(String str, boolean z) {
        Method method = c;
        if (method != null) {
            try {
                return ((Boolean) method.invoke(null, str, Boolean.valueOf(z))).booleanValue();
            } catch (Throwable unused) {
            }
        }
        return z;
    }
}
