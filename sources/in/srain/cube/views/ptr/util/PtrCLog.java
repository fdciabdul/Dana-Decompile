package in.srain.cube.views.ptr.util;

import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes6.dex */
public class PtrCLog {
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_FATAL = 5;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_WARNING = 3;
    private static int sLevel;

    public static void setLogLevel(int i) {
        sLevel = i;
    }

    public static void v(String str, String str2) {
        if (sLevel > 0) {
            return;
        }
        InstrumentInjector.log_v(str, str2);
    }

    public static void v(String str, String str2, Throwable th) {
        if (sLevel > 0) {
            return;
        }
        InstrumentInjector.log_v(str, str2, th);
    }

    public static void v(String str, String str2, Object... objArr) {
        if (sLevel > 0) {
            return;
        }
        if (objArr.length > 0) {
            str2 = String.format(str2, objArr);
        }
        InstrumentInjector.log_v(str, str2);
    }

    public static void d(String str, String str2) {
        if (sLevel > 1) {
            return;
        }
        InstrumentInjector.log_d(str, str2);
    }

    public static void d(String str, String str2, Object... objArr) {
        if (sLevel > 1) {
            return;
        }
        if (objArr.length > 0) {
            str2 = String.format(str2, objArr);
        }
        InstrumentInjector.log_d(str, str2);
    }

    public static void d(String str, String str2, Throwable th) {
        if (sLevel > 1) {
            return;
        }
        InstrumentInjector.log_d(str, str2, th);
    }

    public static void i(String str, String str2) {
        if (sLevel > 2) {
            return;
        }
        InstrumentInjector.log_i(str, str2);
    }

    public static void i(String str, String str2, Object... objArr) {
        if (sLevel > 2) {
            return;
        }
        if (objArr.length > 0) {
            str2 = String.format(str2, objArr);
        }
        InstrumentInjector.log_i(str, str2);
    }

    public static void i(String str, String str2, Throwable th) {
        if (sLevel > 2) {
            return;
        }
        InstrumentInjector.log_i(str, str2, th);
    }

    public static void w(String str, String str2) {
        if (sLevel > 3) {
            return;
        }
        InstrumentInjector.log_w(str, str2);
    }

    public static void w(String str, String str2, Object... objArr) {
        if (sLevel > 3) {
            return;
        }
        if (objArr.length > 0) {
            str2 = String.format(str2, objArr);
        }
        InstrumentInjector.log_w(str, str2);
    }

    public static void w(String str, String str2, Throwable th) {
        if (sLevel > 3) {
            return;
        }
        InstrumentInjector.log_w(str, str2, th);
    }

    public static void e(String str, String str2) {
        if (sLevel > 4) {
            return;
        }
        InstrumentInjector.log_e(str, str2);
    }

    public static void e(String str, String str2, Object... objArr) {
        if (sLevel > 4) {
            return;
        }
        if (objArr.length > 0) {
            str2 = String.format(str2, objArr);
        }
        InstrumentInjector.log_e(str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        if (sLevel > 4) {
            return;
        }
        InstrumentInjector.log_e(str, str2, th);
    }

    public static void f(String str, String str2) {
        if (sLevel > 5) {
        }
    }

    public static void f(String str, String str2, Object... objArr) {
        if (sLevel > 5) {
            return;
        }
        int length = objArr.length;
    }

    public static void f(String str, String str2, Throwable th) {
        if (sLevel > 5) {
        }
    }
}
