package com.ta.audid.g;

import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class n {
    public static boolean e() {
        return ((System.getProperty("java.vm.name") == null || !System.getProperty("java.vm.name").toLowerCase().contains("lemur")) && System.getProperty("ro.yunos.version") == null && TextUtils.isEmpty(i.get("ro.yunos.build.version"))) ? false : true;
    }

    public static boolean f() {
        return (TextUtils.isEmpty(i.get("ro.yunos.product.chip")) && TextUtils.isEmpty(i.get("ro.yunos.hardware"))) ? false : true;
    }

    public static String Y() {
        String str = i.get("ro.aliyun.clouduuid", "");
        if (TextUtils.isEmpty(str)) {
            str = i.get("ro.sys.aliyun.clouduuid", "");
        }
        return TextUtils.isEmpty(str) ? Z() : str;
    }

    private static String Z() {
        try {
            return (String) Class.forName("com.yunos.baseservice.clouduuid.CloudUUID").getMethod("getCloudUUID", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String aa() {
        String property = System.getProperty("ro.yunos.version", "");
        String ab = ab();
        return !com.ta.utdid2.a.a.e.isEmpty(ab) ? ab : property;
    }

    private static String ab() {
        try {
            Field declaredField = Build.class.getDeclaredField("YUNOS_BUILD_VERSION");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                return (String) declaredField.get(new String());
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }
}
