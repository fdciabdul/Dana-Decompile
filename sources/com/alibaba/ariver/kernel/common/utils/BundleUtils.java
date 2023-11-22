package com.alibaba.ariver.kernel.common.utils;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes2.dex */
public class BundleUtils {
    public static void tryUnparcel(Bundle bundle) {
        if (bundle != null) {
            try {
                bundle.get("aaa");
            } catch (Throwable th) {
                RVLogger.e("AriverKernel:BundleUtils", "unparcel exception!", th);
            }
        }
    }

    public static Bundle clone(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        return (Bundle) bundle.clone();
    }

    public static boolean contains(Bundle bundle, String str) {
        if (bundle == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return bundle.containsKey(str);
    }

    public static byte[] getByteArray(Bundle bundle, String str) {
        if (bundle == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return bundle.getByteArray(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static <T extends Parcelable> T getParcelable(Bundle bundle, String str) {
        if (bundle == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (T) bundle.getParcelable(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Object getSerializable(Bundle bundle, String str) {
        if (bundle == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return bundle.getSerializable(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getString(Bundle bundle, String str) {
        return getString(bundle, str, "");
    }

    public static String getString(Bundle bundle, String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        if (bundle != null) {
            try {
                if (TextUtils.isEmpty(str) || !bundle.containsKey(str)) {
                    return str2;
                }
                String castToString = com.alibaba.fastjson.util.TypeUtils.castToString(bundle.get(str));
                if (castToString != null) {
                    return castToString;
                }
            } catch (Exception e) {
                RVLogger.e("get json value exception", e);
            }
        }
        return str2;
    }

    public static String getStringOnly(Bundle bundle, String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        return (String) getValue(bundle, str, str2);
    }

    public static boolean getBoolean(Bundle bundle, String str, boolean z) {
        Boolean castToBoolean;
        if (bundle != null) {
            try {
                return (TextUtils.isEmpty(str) || !bundle.containsKey(str) || (castToBoolean = com.alibaba.fastjson.util.TypeUtils.castToBoolean(bundle.get(str))) == null) ? z : castToBoolean.booleanValue();
            } catch (Exception e) {
                RVLogger.e("get json value exception", e);
            }
        }
        return z;
    }

    public static int getInt(Bundle bundle, String str) {
        return getInt(bundle, str, 0);
    }

    public static int getInt(Bundle bundle, String str, int i) {
        Integer castToInt;
        if (bundle != null) {
            try {
                return (TextUtils.isEmpty(str) || !bundle.containsKey(str) || (castToInt = com.alibaba.fastjson.util.TypeUtils.castToInt(bundle.get(str))) == null) ? i : castToInt.intValue();
            } catch (Exception e) {
                RVLogger.e("get json value exception", e);
            }
        }
        return i;
    }

    public static long getLong(Bundle bundle, String str) {
        return getLong(bundle, str, 0L);
    }

    public static long getLong(Bundle bundle, String str, long j) {
        Long castToLong;
        if (bundle != null) {
            try {
                return (TextUtils.isEmpty(str) || !bundle.containsKey(str) || (castToLong = com.alibaba.fastjson.util.TypeUtils.castToLong(bundle.get(str))) == null) ? j : castToLong.longValue();
            } catch (Exception e) {
                RVLogger.e("get json value exception", e);
            }
        }
        return j;
    }

    public static double getDouble(Bundle bundle, String str) {
        return getDouble(bundle, str, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    public static double getDouble(Bundle bundle, String str, double d) {
        Double castToDouble;
        if (bundle != null) {
            try {
                return (TextUtils.isEmpty(str) || !bundle.containsKey(str) || (castToDouble = com.alibaba.fastjson.util.TypeUtils.castToDouble(bundle.get(str))) == null) ? d : castToDouble.doubleValue();
            } catch (Exception e) {
                RVLogger.e("get json value exception", e);
            }
        }
        return d;
    }

    public static <T> T getValue(Bundle bundle, String str, T t) {
        T t2;
        if (bundle != null) {
            try {
                return (TextUtils.isEmpty(str) || t == null || !bundle.containsKey(str) || (t2 = (T) bundle.get(str)) == null) ? t : t.getClass().isAssignableFrom(t2.getClass()) ? t2 : t;
            } catch (Exception e) {
                RVLogger.e("get json value exception", e);
            }
        }
        return t;
    }

    public static JSONObject toJSONObject(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        if (bundle == null) {
            return jSONObject;
        }
        for (String str : bundle.keySet()) {
            jSONObject.put(str, bundle.get(str));
        }
        return jSONObject;
    }
}
