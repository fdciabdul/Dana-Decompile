package com.alibaba.griver.base.common.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.LruCache;
import androidx.core.content.ContextCompat;
import com.alibaba.fastjson.JSONObject;
import id.dana.utils.permission.ManifestPermission;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class CommonUtils {

    /* renamed from: a  reason: collision with root package name */
    private static float f6307a;
    private static LruCache<String, Uri> b = new LruCache<>(20);

    public static long getLong(JSONObject jSONObject, String str) {
        return getLong(jSONObject, str, 0L);
    }

    public static long getLong(JSONObject jSONObject, String str, long j) {
        return ((Long) getValue(jSONObject, str, Long.valueOf(j))).longValue();
    }

    public static long getLong(Bundle bundle, String str) {
        return getLong(bundle, str, 0L);
    }

    public static long getLong(Bundle bundle, String str, long j) {
        return ((Long) getValue(bundle, str, Long.valueOf(j))).longValue();
    }

    public static <T> T getValue(Bundle bundle, String str, T t) {
        T t2;
        if (bundle != null) {
            try {
                return (TextUtils.isEmpty(str) || t == null || !bundle.containsKey(str) || (t2 = (T) bundle.get(str)) == null) ? t : t.getClass().isAssignableFrom(t2.getClass()) ? t2 : t;
            } catch (Exception unused) {
                return t;
            }
        }
        return t;
    }

    public static <T> T getValue(JSONObject jSONObject, String str, T t) {
        T t2;
        return (jSONObject == null || jSONObject.isEmpty() || t == null || !jSONObject.containsKey(str) || (t2 = (T) jSONObject.get(str)) == null || !t.getClass().isAssignableFrom(t2.getClass())) ? t : t2;
    }

    public static int dip2px(Context context, float f) {
        a(context);
        return (int) ((f * f6307a) + 0.5f);
    }

    private static void a(Context context) {
        try {
            if (f6307a == 0.0f) {
                f6307a = context.getResources().getDisplayMetrics().density;
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean contains(JSONObject jSONObject, String str) {
        return (jSONObject == null || jSONObject.isEmpty() || !jSONObject.containsKey(str)) ? false : true;
    }

    public static float getFloat(JSONObject jSONObject, String str, float f) {
        return ((Float) getValue(jSONObject, str, Float.valueOf(f))).floatValue();
    }

    public static int getInt(JSONObject jSONObject, String str) {
        return getInt(jSONObject, str, 0);
    }

    public static int getInt(JSONObject jSONObject, String str, int i) {
        return ((Integer) getValue(jSONObject, str, Integer.valueOf(i))).intValue();
    }

    public static boolean isAppPermissionOPen(Context context) {
        if (context == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            return b(context);
        }
        return ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(context, ManifestPermission.ACCESS_COARSE_LOCATION) == 0;
    }

    private static boolean b(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return a(context, 0);
        }
        return true;
    }

    private static boolean a(Context context, int i) {
        Method method;
        try {
            Object systemService = context.getSystemService("appops");
            if (systemService == null || (method = systemService.getClass().getMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class)) == null) {
                return false;
            }
            return ((Integer) method.invoke(systemService, Integer.valueOf(i), Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String getString(JSONObject jSONObject, String str) {
        return getString(jSONObject, str, "");
    }

    public static String getString(JSONObject jSONObject, String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        return (String) getValue(jSONObject, str, str2);
    }

    public static Uri parseUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri uri = b.get(str);
        if (uri != null) {
            return uri;
        }
        try {
            uri = Uri.parse(str);
            b.put(str, uri);
            return uri;
        } catch (Exception unused) {
            return uri;
        }
    }
}
