package com.alipay.iap.android.common.log;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: classes2.dex */
public class LoggerWrapper {
    public static String TAG = "LoggerWrapper";
    private static boolean sIsloggable;
    private static boolean sUseCustomLogger;
    public static final byte[] MyBillsEntityDataFactory = {116, -27, -60, 115, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, Ascii.US, -21, 0, 6, -25, Ascii.FS, -19, 0, 0, -34, 37, -9, 6, -10, 7, 4, -4, 13, -51, 39, -13, 16, -2, -39, 17, 10, -10};
    public static final int getAuthRequestContext = 121;
    private static ILogger sLogger = new ILogger() { // from class: com.alipay.iap.android.common.log.LoggerWrapper.1
        @Override // com.alipay.iap.android.common.log.ILogger
        public final boolean isLoggable() {
            return Log.isLoggable(LoggerWrapper.TAG, 2);
        }

        @Override // com.alipay.iap.android.common.log.ILogger
        public final void v(String str, String str2) {
            InstrumentInjector.log_v(str, str2);
        }

        @Override // com.alipay.iap.android.common.log.ILogger
        public final void v(String str, String str2, Throwable th) {
            InstrumentInjector.log_v(str, str2);
        }

        @Override // com.alipay.iap.android.common.log.ILogger
        public final void i(String str, String str2) {
            InstrumentInjector.log_i(str, str2);
        }

        @Override // com.alipay.iap.android.common.log.ILogger
        public final void i(String str, String str2, Throwable th) {
            InstrumentInjector.log_i(str, str2, th);
        }

        @Override // com.alipay.iap.android.common.log.ILogger
        public final void d(String str, String str2) {
            InstrumentInjector.log_d(str, str2);
        }

        @Override // com.alipay.iap.android.common.log.ILogger
        public final void d(String str, String str2, Throwable th) {
            InstrumentInjector.log_d(str, str2, th);
        }

        @Override // com.alipay.iap.android.common.log.ILogger
        public final void w(String str, String str2) {
            InstrumentInjector.log_w(str, str2);
        }

        @Override // com.alipay.iap.android.common.log.ILogger
        public final void w(String str, String str2, Throwable th) {
            InstrumentInjector.log_w(str, str2, th);
        }

        @Override // com.alipay.iap.android.common.log.ILogger
        public final void w(String str, Throwable th) {
            InstrumentInjector.log_w(str, th);
        }

        @Override // com.alipay.iap.android.common.log.ILogger
        public final void e(String str, String str2) {
            InstrumentInjector.log_e(str, str2);
        }

        @Override // com.alipay.iap.android.common.log.ILogger
        public final void e(String str, String str2, Throwable th) {
            InstrumentInjector.log_e(str, str2, th);
        }
    };

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0028). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 + 99
            int r6 = r6 + 12
            int r8 = 57 - r8
            byte[] r0 = com.alipay.iap.android.common.log.LoggerWrapper.MyBillsEntityDataFactory
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L13
            r7 = r6
            r4 = r8
            r3 = 0
            goto L28
        L13:
            r3 = 0
        L14:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L21
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L21:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r5
        L28:
            int r8 = r8 + 1
            int r6 = r6 + r4
            int r6 = r6 + 2
            r5 = r7
            r7 = r6
            r6 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.common.log.LoggerWrapper.a(byte, byte, int, java.lang.Object[]):void");
    }

    private LoggerWrapper() {
    }

    public static void init(Context context) {
        sIsloggable = isDebuggable(context) | sIsloggable;
    }

    private static boolean isDebuggable(Context context) {
        if (sUseCustomLogger) {
            return sLogger.isLoggable();
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                return (applicationInfo.flags & 2) != 0;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            e(TAG, "", e);
            return false;
        }
    }

    public static boolean isDebuggable() {
        return sIsloggable;
    }

    public static void activateDebug(boolean z) {
        sIsloggable = z;
    }

    public static void customizeLogger(ILogger iLogger) {
        if (iLogger != null) {
            sLogger = iLogger;
            sUseCustomLogger = true;
            sIsloggable = iLogger.isLoggable();
        }
    }

    public static void v(String str, String str2) {
        if (sIsloggable) {
            sLogger.v(str, str2);
        }
    }

    public static void v(String str, String str2, Throwable th) {
        if (sIsloggable) {
            sLogger.v(str, str2, th);
        }
    }

    public static void i(String str, String str2) {
        if (sIsloggable) {
            sLogger.i(str, str2);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (sIsloggable) {
            sLogger.i(str, str2, th);
        }
    }

    public static void d(String str, String str2) {
        if (sIsloggable) {
            sLogger.d(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (sIsloggable) {
            sLogger.d(str, str2, th);
        }
    }

    public static void w(String str, String str2) {
        if (sIsloggable) {
            sLogger.w(str, str2);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (sIsloggable) {
            sLogger.w(str, str2, th);
        }
    }

    public static void w(String str, Throwable th) {
        if (sIsloggable) {
            sLogger.w(str, th);
        }
    }

    public static void e(String str, String str2) {
        if (sIsloggable) {
            sLogger.e(str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (sIsloggable) {
            sLogger.e(str, str2, th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b0, code lost:
    
        r1 = java.util.Locale.US;
        r2 = new java.lang.Object[3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b5, code lost:
    
        r10 = new java.lang.Object[1];
        a(com.alipay.iap.android.common.log.LoggerWrapper.MyBillsEntityDataFactory[9], com.alipay.iap.android.common.log.LoggerWrapper.MyBillsEntityDataFactory[8], (byte) (com.alipay.iap.android.common.log.LoggerWrapper.getAuthRequestContext & 175), r10);
        r3 = java.lang.Class.forName((java.lang.String) r10[0]);
        r10 = new java.lang.Object[1];
        a(com.alipay.iap.android.common.log.LoggerWrapper.MyBillsEntityDataFactory[15], com.alipay.iap.android.common.log.LoggerWrapper.MyBillsEntityDataFactory[43], (byte) (-com.alipay.iap.android.common.log.LoggerWrapper.MyBillsEntityDataFactory[19]), r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00f8, code lost:
    
        r2[0] = java.lang.Long.valueOf(((java.lang.Thread) r3.getMethod((java.lang.String) r10[0], null).invoke(null, null)).getId());
        r2[1] = r15;
        r2[2] = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x010c, code lost:
    
        return java.lang.String.format(r1, "[%d] %s: %s", r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x010d, code lost:
    
        r14 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x010e, code lost:
    
        r15 = r14.getCause();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0112, code lost:
    
        if (r15 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0114, code lost:
    
        throw r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0116, code lost:
    
        throw r14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String buildMessage(java.lang.String r14, java.lang.Object... r15) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.common.log.LoggerWrapper.buildMessage(java.lang.String, java.lang.Object[]):java.lang.String");
    }

    public static String throwableToString(Throwable th) {
        PrintWriter printWriter;
        StringWriter stringWriter;
        if (th == null) {
            return "";
        }
        String message = th.getMessage();
        try {
            stringWriter = new StringWriter();
            printWriter = new PrintWriter(stringWriter);
        } catch (Throwable unused) {
            printWriter = null;
        }
        try {
            Throwable cause = th.getCause();
            if (cause == null) {
                th.printStackTrace(printWriter);
            } else {
                while (cause != null) {
                    cause.printStackTrace(printWriter);
                    cause = cause.getCause();
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(message);
            sb.append("\r\n");
            sb.append(stringWriter.toString());
            String obj = sb.toString();
            try {
                printWriter.close();
            } catch (Throwable unused2) {
            }
            return obj;
        } catch (Throwable unused3) {
            if (printWriter != null) {
                try {
                    printWriter.close();
                } catch (Throwable unused4) {
                }
            }
            return message;
        }
    }
}
