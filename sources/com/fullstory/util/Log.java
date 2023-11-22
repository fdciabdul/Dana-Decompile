package com.fullstory.util;

import com.alibaba.exthub.BuildConfig;
import com.fullstory.FS;

/* loaded from: classes.dex */
public class Log {
    public static boolean DISABLE_LOGGING = true;
    private static FS.LogLevel FS_LEVEL = null;
    private static final FS.LogLevel FS_LEVEL_DEFAULT = FS.LogLevel.INFO;
    private static FS.LogLevel LOGCAT_LEVEL = null;
    private static final FS.LogLevel LOGCAT_LEVEL_DEFAULT;
    private static final String TAG = "fullstory";

    static {
        FS.LogLevel logLevel = FS.LogLevel.OFF;
        LOGCAT_LEVEL_DEFAULT = logLevel;
        FS_LEVEL = FS_LEVEL_DEFAULT;
        LOGCAT_LEVEL = logLevel;
    }

    private Log() {
    }

    public static int alwaysWarn(String str) {
        return android.util.Log.w("fullstory", str);
    }

    public static int d(String str) {
        if (DISABLE_LOGGING) {
            return 0;
        }
        return android.util.Log.d("fullstory", str);
    }

    public static int d(String str, Throwable th) {
        if (DISABLE_LOGGING) {
            return 0;
        }
        return android.util.Log.d("fullstory", str, th);
    }

    public static int e(String str) {
        return android.util.Log.e("fullstory", str);
    }

    public static int e(String str, Throwable th) {
        return android.util.Log.e("fullstory", str, th);
    }

    public static FS.LogLevel getLevel() {
        return FS_LEVEL;
    }

    public static FS.LogLevel getLogcatLevel() {
        return LOGCAT_LEVEL;
    }

    public static int i(String str) {
        if (DISABLE_LOGGING) {
            return 0;
        }
        return android.util.Log.i("fullstory", str);
    }

    public static int i(String str, Throwable th) {
        if (DISABLE_LOGGING) {
            return 0;
        }
        return android.util.Log.i("fullstory", str, th);
    }

    private static boolean isLevelLoggable(FS.LogLevel logLevel, FS.LogLevel logLevel2) {
        int ordinal = logLevel.ordinal();
        return ordinal != 0 && logLevel2.ordinal() >= ordinal;
    }

    public static boolean isLogcatLoggable(FS.LogLevel logLevel) {
        return isLevelLoggable(LOGCAT_LEVEL, logLevel);
    }

    public static boolean isLoggable(FS.LogLevel logLevel) {
        return isLevelLoggable(FS_LEVEL, logLevel);
    }

    public static int logAlways(String str) {
        return android.util.Log.i("fullstory", str);
    }

    private static FS.LogLevel parseLevel(String str, FS.LogLevel logLevel) {
        if (str == null || str.isEmpty()) {
            return logLevel;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case 107332:
                if (str.equals("log")) {
                    c = 1;
                    break;
                }
                break;
            case 109935:
                if (str.equals("off")) {
                    c = 0;
                    break;
                }
                break;
            case 3237038:
                if (str.equals("info")) {
                    c = 5;
                    break;
                }
                break;
            case 3641990:
                if (str.equals("warn")) {
                    c = 3;
                    break;
                }
                break;
            case 95458899:
                if (str.equals(BuildConfig.BUILD_TYPE)) {
                    c = 2;
                    break;
                }
                break;
            case 96784904:
                if (str.equals("error")) {
                    c = 4;
                    break;
                }
                break;
        }
        return c != 0 ? c != 1 ? c != 2 ? c != 3 ? c != 4 ? c != 5 ? logLevel : FS.LogLevel.INFO : FS.LogLevel.ERROR : FS.LogLevel.WARN : FS.LogLevel.DEBUG : FS.LogLevel.LOG : FS.LogLevel.OFF;
    }

    public static void printStackTrace(Throwable th) {
    }

    public static void setLevel(String str) {
        FS_LEVEL = parseLevel(str, FS_LEVEL_DEFAULT);
    }

    public static void setLogcatLevel(String str) {
        LOGCAT_LEVEL = parseLevel(str, LOGCAT_LEVEL_DEFAULT);
    }

    public static int v(String str) {
        if (DISABLE_LOGGING) {
            return 0;
        }
        return android.util.Log.v("fullstory", str);
    }

    public static int v(String str, Throwable th) {
        if (DISABLE_LOGGING) {
            return 0;
        }
        return android.util.Log.v("fullstory", str, th);
    }

    public static int w(String str) {
        if (DISABLE_LOGGING) {
            return 0;
        }
        return android.util.Log.w("fullstory", str);
    }

    public static int w(String str, Throwable th) {
        if (DISABLE_LOGGING) {
            return 0;
        }
        return android.util.Log.w("fullstory", str, th);
    }

    public static int w(Throwable th) {
        if (DISABLE_LOGGING) {
            return 0;
        }
        return android.util.Log.w("fullstory", th);
    }
}
