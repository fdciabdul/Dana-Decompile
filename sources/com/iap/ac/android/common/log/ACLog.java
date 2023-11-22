package com.iap.ac.android.common.log;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.iap.ac.android.common.log.log.ILogPrinter;
import com.iap.ac.android.common.log.log.LogPrinter;

/* loaded from: classes2.dex */
public final class ACLog {
    public static boolean DEBUG;
    public static ILogPrinter sLogPrinter = new LogPrinter();

    public static int d(String str, String str2) {
        if (DEBUG) {
            return sLogPrinter.doPrint(3, str, str2);
        }
        return 0;
    }

    public static int e(String str, String str2) {
        if (DEBUG) {
            return sLogPrinter.doPrint(6, str, str2);
        }
        return 0;
    }

    public static int i(String str, String str2) {
        if (DEBUG) {
            return sLogPrinter.doPrint(4, str, str2);
        }
        return 0;
    }

    public static void setDebuggable(boolean z) {
        DEBUG = z;
    }

    public static void setDebuggableByContext(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (applicationInfo.flags & 2) == 0) {
                return;
            }
            DEBUG = true;
        } catch (PackageManager.NameNotFoundException e) {
            e("TAG", "setDebuggableByContext error: ", e);
        } catch (Exception e2) {
            e("TAG", "setDebuggableByContext error: ", e2);
        }
    }

    public static void setLogPrinter(ILogPrinter iLogPrinter) {
        if (iLogPrinter == null) {
            return;
        }
        sLogPrinter = iLogPrinter;
    }

    public static int v(String str, String str2) {
        if (DEBUG) {
            return sLogPrinter.doPrint(2, str, str2);
        }
        return 0;
    }

    public static int w(String str, String str2) {
        if (DEBUG) {
            return sLogPrinter.doPrint(5, str, str2);
        }
        return 0;
    }

    public static int d(String str, String str2, Throwable th) {
        if (DEBUG) {
            return sLogPrinter.doPrint(3, str, str2, th);
        }
        return 0;
    }

    public static int e(String str, String str2, Throwable th) {
        if (DEBUG) {
            return sLogPrinter.doPrint(6, str, str2, th);
        }
        return 0;
    }

    public static int i(String str, String str2, Throwable th) {
        if (DEBUG) {
            return sLogPrinter.doPrint(4, str, str2, th);
        }
        return 0;
    }

    public static int v(String str, String str2, Throwable th) {
        if (DEBUG) {
            return sLogPrinter.doPrint(2, str, str2, th);
        }
        return 0;
    }

    public static int w(String str, String str2, Throwable th) {
        if (DEBUG) {
            return sLogPrinter.doPrint(5, str, str2, th);
        }
        return 0;
    }

    public static int w(String str, Throwable th) {
        if (DEBUG) {
            return sLogPrinter.doPrint(5, str, null, th);
        }
        return 0;
    }
}
