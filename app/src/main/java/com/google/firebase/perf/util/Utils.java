package com.google.firebase.perf.util;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.firebase.perf.logging.AndroidLogger;
import okhttp3.HttpUrl;

/* loaded from: classes.dex */
public class Utils {
    private static Boolean isDebugLoggingEnabled;

    public static int saturatedIntCast(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }

    public static String stripSensitiveInfo(String str) {
        HttpUrl parse = HttpUrl.parse(str);
        return parse != null ? parse.newBuilder().username("").password("").query(null).fragment(null).toString() : str;
    }

    public static String truncateURL(String str, int i) {
        int lastIndexOf;
        if (str.length() <= i) {
            return str;
        }
        if (str.charAt(i) == '/') {
            return str.substring(0, i);
        }
        HttpUrl parse = HttpUrl.parse(str);
        if (parse == null) {
            return str.substring(0, i);
        }
        if (parse.encodedPath().lastIndexOf(47) >= 0 && (lastIndexOf = str.lastIndexOf(47, i - 1)) >= 0) {
            return str.substring(0, lastIndexOf);
        }
        return str.substring(0, i);
    }

    public static int bufferToInt(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < 4 && i2 < bArr.length; i2++) {
            i |= (bArr[i2] & 255) << (i2 * 8);
        }
        return i;
    }

    public static boolean isDebugLoggingEnabled(Context context) {
        Boolean bool = isDebugLoggingEnabled;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Boolean valueOf = Boolean.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("firebase_performance_logcat_enabled", false));
            isDebugLoggingEnabled = valueOf;
            return valueOf.booleanValue();
        } catch (PackageManager.NameNotFoundException | NullPointerException e) {
            AndroidLogger androidLogger = AndroidLogger.getInstance();
            StringBuilder sb = new StringBuilder();
            sb.append("No perf logcat meta data found ");
            sb.append(e.getMessage());
            androidLogger.debug(sb.toString());
            return false;
        }
    }

    public static void checkArgument(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }
}
