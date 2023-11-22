package com.alibaba.griver.ui.ant.utils;

import android.content.Context;
import android.content.res.Resources;
import android.provider.Settings;
import android.text.TextUtils;
import com.alibaba.griver.base.common.logger.GriverLogger;

/* loaded from: classes6.dex */
public class ConcaveUtils {
    public static boolean checkOppoConcave(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static boolean checkVivoConcave() {
        try {
            Class<?> cls = Class.forName("android.util.FtFeature");
            return ((Boolean) cls.getDeclaredMethod("isFeatureSupport", Integer.TYPE).invoke(cls.newInstance(), 32)).booleanValue();
        } catch (Throwable th) {
            GriverLogger.e("checkVivoConcave", th.getMessage());
            return false;
        }
    }

    public static boolean checkHuaweiConcave(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue() && a(context);
        } catch (Throwable th) {
            GriverLogger.e("checkHuaweiConcave", th.getMessage());
            return false;
        }
    }

    private static boolean a(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "display_notch_status", 0) == 0;
    }

    public static boolean checkXiaomiConcave() {
        String str = "0";
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str2 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.miui.notch", "0");
            String str3 = str2;
            str = str2;
        } catch (Exception e) {
            GriverLogger.e("checkXiaomiConcave", e.getMessage());
        }
        return TextUtils.equals(str, "1");
    }

    public static boolean checkSamsungConcave(Context context) {
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_mainBuiltInDisplayCutout", "string", "android");
            String string = identifier > 0 ? resources.getString(identifier) : null;
            if (string != null) {
                return !TextUtils.isEmpty(string);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
