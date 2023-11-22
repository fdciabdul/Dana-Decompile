package com.alibaba.ariver.kernel.common.utils;

import android.text.TextUtils;
import com.alibaba.exthub.common.ExtHubLogger;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes2.dex */
public class TypeUtils {
    private static long a(long j) {
        return j <= 16777215 ? j | (-16777216) : j;
    }

    public static Integer parseColorInt(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
        } catch (Throwable th) {
            ExtHubLogger.e("parseColorException!", th);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (str.charAt(0) == '#') {
                return Integer.valueOf((int) a(Long.parseLong(str.substring(1), 16)));
            }
            return Integer.valueOf((int) a(Integer.parseInt(str)));
        }
        if (obj instanceof Integer) {
            return Integer.valueOf((int) a(((Integer) obj).intValue()));
        }
        return null;
    }

    public static Long parseColorLong(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
        } catch (Throwable th) {
            ExtHubLogger.e("parseColorException!", th);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (str.charAt(0) == '#') {
                return Long.valueOf(a(Long.parseLong(str.substring(1), 16)));
            }
            return Long.valueOf(a(Long.parseLong(str)));
        } else if (obj instanceof Integer) {
            return Long.valueOf(a(((Integer) obj).intValue()));
        } else {
            if (obj instanceof Long) {
                return (Long) obj;
            }
            return null;
        }
    }

    public static double parseDouble(String str) {
        if (TextUtils.isEmpty(str)) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        try {
            return Double.parseDouble(str);
        } catch (Throwable th) {
            ExtHubLogger.e("parse double exception.", th);
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
    }

    public static int parseInt(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Throwable th) {
            ExtHubLogger.e("parse int exception.", th);
            return 0;
        }
    }

    public static long parseLong(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            return Long.parseLong(str);
        } catch (Throwable th) {
            ExtHubLogger.e("parse long exception.", th);
            return 0L;
        }
    }

    public static float parseFloat(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0.0f;
        }
        try {
            return Float.parseFloat(str);
        } catch (Throwable th) {
            ExtHubLogger.e("parse long exception.", th);
            return 0.0f;
        }
    }
}
