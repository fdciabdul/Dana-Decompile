package io.split.android.client.utils.logger;

/* loaded from: classes6.dex */
public class Logger {
    private static final String TAG = "SplitSDK";
    private static volatile Logger instance;
    private int mLevel = -100;
    private LogPrinter mLogPrinter = new LogPrinterImpl();

    private Logger() {
    }

    public static Logger instance() {
        Logger logger;
        synchronized (Logger.class) {
            if (instance == null) {
                synchronized (Logger.class) {
                    if (instance == null) {
                        instance = new Logger();
                    }
                }
            }
            logger = instance;
        }
        return logger;
    }

    public void setLevel(int i) {
        this.mLevel = i;
    }

    public void setPrinter(LogPrinter logPrinter) {
        this.mLogPrinter = logPrinter;
    }

    private void log(int i, String str, Throwable th) {
        int i2 = this.mLevel;
        if (i2 == -100 || i < 2 || i2 > i) {
            return;
        }
        switch (i) {
            case 2:
                this.mLogPrinter.v(TAG, str, th);
                return;
            case 3:
                this.mLogPrinter.d(TAG, str, th);
                return;
            case 4:
                this.mLogPrinter.i(TAG, str, th);
                return;
            case 5:
                this.mLogPrinter.w(TAG, str, th);
                return;
            case 6:
                this.mLogPrinter.e(TAG, str, th);
                return;
            case 7:
                this.mLogPrinter.wtf(TAG, str, th);
                return;
            default:
                return;
        }
    }

    private static String formatMessage(String str, Object[] objArr) {
        return (objArr == null || objArr.length <= 0) ? str : String.format(str, objArr);
    }

    public static void v(String str, Object... objArr) {
        v(formatMessage(str, objArr));
    }

    public static void v(String str) {
        instance().log(2, str, null);
    }

    public static void v(String str, Throwable th) {
        instance().log(2, str, th);
    }

    public static void d(String str, Object... objArr) {
        d(formatMessage(str, objArr));
    }

    public static void d(String str) {
        instance().log(3, str, null);
    }

    public static void d(String str, Throwable th) {
        instance().log(3, str, th);
    }

    public static void i(String str, Object... objArr) {
        i(formatMessage(str, objArr));
    }

    public static void i(String str) {
        instance().log(4, str, null);
    }

    public static void i(String str, Throwable th) {
        instance().log(4, str, th);
    }

    public static void w(String str, Object... objArr) {
        w(formatMessage(str, objArr));
    }

    public static void w(Throwable th, String str, Object... objArr) {
        w(formatMessage(str, objArr), th);
    }

    public static void w(String str) {
        instance().log(5, str, null);
    }

    public static void w(String str, Throwable th) {
        instance().log(5, str, th);
    }

    public static void e(String str, Object... objArr) {
        e(formatMessage(str, objArr));
    }

    public static void e(Throwable th, String str, Object... objArr) {
        e(formatMessage(str, objArr), th);
    }

    public static void e(String str) {
        instance().log(6, str, null);
    }

    public static void e(String str, Throwable th) {
        instance().log(6, str, th);
    }

    public static void e(Throwable th) {
        instance().log(6, "", th);
    }

    public static void wtf(String str, Object... objArr) {
        wtf(formatMessage(str, objArr));
    }

    public static void wtf(String str) {
        instance().log(7, str, null);
    }

    public static void wtf(String str, Throwable th) {
        instance().log(7, str, th);
    }
}
