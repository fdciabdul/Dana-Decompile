package com.huawei.hms.framework.common;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.IOException;
import java.util.Arrays;
import java.util.IllegalFormatException;
import org.json.JSONException;

/* loaded from: classes7.dex */
public class Logger {
    private static ExtLogger KClassImpl$Data$declaredNonStaticMembers$2 = null;
    public static final byte[] MyBillsEntityDataFactory = {114, -124, TarHeader.LF_CONTIG, 72, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 4, -13, 35, -31, Ascii.NAK, 0, -6, Ascii.EM, -28, 19, 0, 0, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -31, Ascii.NAK, 0, -6, Ascii.EM, -28, 19, 0, 0, 34, -37, 9, -6, 10, -7, -4, 4, -13, TarHeader.LF_CHR, -39, 13, -16, 2, 39, -17, -10, 10};
    public static final int PlaceComponentResult = 18;
    private static boolean getAuthRequestContext = true;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.huawei.hms.framework.common.Logger.MyBillsEntityDataFactory
            int r6 = 68 - r6
            int r8 = r8 + 99
            int r7 = 27 - r7
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r8 = r7
            r3 = r1
            r4 = 0
            r7 = r6
            r1 = r0
            r0 = r9
            r9 = r8
            goto L33
        L17:
            r3 = 0
        L18:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r6 = r6 + 1
            if (r3 != r7) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L33:
            int r6 = -r6
            int r8 = r8 + r6
            int r8 = r8 + 2
            r6 = r7
            r7 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.common.Logger.a(short, int, byte, java.lang.Object[]):void");
    }

    public static void setExtLogger(ExtLogger extLogger, boolean z) {
        KClassImpl$Data$declaredNonStaticMembers$2 = extLogger;
        getAuthRequestContext = z;
        StringBuilder sb = new StringBuilder();
        sb.append("logger = ");
        sb.append(extLogger);
        sb.append(z);
        i("NetworkKit_Logger", sb.toString());
    }

    public static void v(String str, String str2, Object... objArr) {
        println(2, str, str2, objArr);
    }

    public static void v(String str, Object obj) {
        println(2, str, obj);
    }

    public static void d(String str, Object obj) {
        println(3, str, obj);
    }

    public static void d(String str, String str2, Object... objArr) {
        println(3, str, str2, objArr);
    }

    public static void i(String str, Object obj) {
        println(4, str, obj);
    }

    public static void i(String str, String str2, Object... objArr) {
        println(4, str, str2, objArr);
    }

    public static void w(String str, Object obj) {
        println(5, str, obj);
    }

    public static void w(String str, String str2, Object... objArr) {
        println(5, str, str2, objArr);
    }

    public static void w(String str, String str2, Throwable th) {
        if (KClassImpl$Data$declaredNonStaticMembers$2(5)) {
            ExtLogger extLogger = KClassImpl$Data$declaredNonStaticMembers$2;
            StringBuilder sb = new StringBuilder();
            sb.append("NetworkSdk_");
            sb.append(str);
            extLogger.w(sb.toString(), BuiltInFictitiousFunctionClassFactory(str2, 5), getAuthRequestContext(th));
        }
        if (getAuthRequestContext) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("NetworkKit_");
            sb2.append(str);
            InstrumentInjector.log_w(sb2.toString(), BuiltInFictitiousFunctionClassFactory(str2, 5), getAuthRequestContext(th));
        }
    }

    public static void e(String str, Object obj) {
        println(6, str, obj);
    }

    public static void e(String str, String str2, Object... objArr) {
        println(6, str, str2, objArr);
    }

    public static void e(String str, String str2, Throwable th) {
        if (KClassImpl$Data$declaredNonStaticMembers$2(6)) {
            ExtLogger extLogger = KClassImpl$Data$declaredNonStaticMembers$2;
            StringBuilder sb = new StringBuilder();
            sb.append("NetworkSdk_");
            sb.append(str);
            extLogger.e(sb.toString(), BuiltInFictitiousFunctionClassFactory(str2, 5), getAuthRequestContext(th));
        }
        if (getAuthRequestContext) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("NetworkKit_");
            sb2.append(str);
            InstrumentInjector.log_e(sb2.toString(), BuiltInFictitiousFunctionClassFactory(str2, 5), getAuthRequestContext(th));
        }
    }

    private static boolean MyBillsEntityDataFactory(int i) {
        return getAuthRequestContext && isLoggable(i);
    }

    private static Throwable getAuthRequestContext(Throwable th) {
        if (isLoggable(3)) {
            return th;
        }
        if (th == null) {
            return null;
        }
        ThrowableWrapper throwableWrapper = new ThrowableWrapper(th);
        Throwable cause = th.getCause();
        ThrowableWrapper throwableWrapper2 = throwableWrapper;
        while (cause != null) {
            ThrowableWrapper throwableWrapper3 = new ThrowableWrapper(cause);
            throwableWrapper2.setCause(throwableWrapper3);
            cause = cause.getCause();
            throwableWrapper2 = throwableWrapper3;
        }
        return throwableWrapper;
    }

    private static String BuiltInFictitiousFunctionClassFactory(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append(PlaceComponentResult(i));
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(str);
            return sb.toString();
        }
        return PlaceComponentResult(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class ThrowableWrapper extends Throwable {
        private static final long serialVersionUID = 7129050843360571879L;
        private String message;
        private Throwable ownerThrowable;
        private Throwable thisCause;

        private ThrowableWrapper(Throwable th) {
            this.ownerThrowable = th;
            StackTraceElement[] stackTrace = th.getStackTrace();
            int i = ((th instanceof IOException) || (th instanceof JSONException)) ? 8 : 20;
            if (stackTrace.length > i) {
                setStackTrace((StackTraceElement[]) Arrays.copyOf(stackTrace, i));
            } else {
                setStackTrace(stackTrace);
            }
            setMessage(StringUtils.anonymizeMessage(th.getMessage()));
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            Throwable th = this.thisCause;
            if (th == this) {
                return null;
            }
            return th;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCause(Throwable th) {
            this.thisCause = th;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }

        public void setMessage(String str) {
            this.message = str;
        }

        @Override // java.lang.Throwable
        public String toString() {
            Throwable th = this.ownerThrowable;
            if (th == null) {
                return "";
            }
            String name = th.getClass().getName();
            if (this.message != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(name);
                sb.append(": ");
                String obj = sb.toString();
                if (this.message.startsWith(obj)) {
                    return this.message;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(obj);
                sb2.append(this.message);
                return sb2.toString();
            }
            return name;
        }
    }

    public static boolean isLoggable(int i) {
        return Log.isLoggable("NetworkKit_", i);
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        return KClassImpl$Data$declaredNonStaticMembers$2 != null && i >= 3;
    }

    private static String PlaceComponentResult(int i) {
        try {
            Object[] objArr = new Object[1];
            a((short) 41, MyBillsEntityDataFactory[28], (byte) (-MyBillsEntityDataFactory[8]), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a((short) 65, (byte) (PlaceComponentResult - 4), MyBillsEntityDataFactory[21], objArr2);
            Object invoke = cls.getMethod((String) objArr2[0], null).invoke(null, null);
            try {
                Object[] objArr3 = new Object[1];
                a((short) 41, MyBillsEntityDataFactory[28], (byte) (-MyBillsEntityDataFactory[8]), objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                a(MyBillsEntityDataFactory[31], (byte) (PlaceComponentResult - 4), MyBillsEntityDataFactory[16], objArr4);
                StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) cls2.getMethod((String) objArr4[0], null).invoke(invoke, null);
                if (stackTraceElementArr.length > i) {
                    StackTraceElement stackTraceElement = stackTraceElementArr[i];
                    StringBuilder sb = new StringBuilder();
                    try {
                        Object[] objArr5 = new Object[1];
                        a((short) 41, MyBillsEntityDataFactory[28], (byte) (-MyBillsEntityDataFactory[8]), objArr5);
                        Class<?> cls3 = Class.forName((String) objArr5[0]);
                        Object[] objArr6 = new Object[1];
                        a((short) 65, (byte) (PlaceComponentResult - 4), MyBillsEntityDataFactory[21], objArr6);
                        sb.append(((Thread) cls3.getMethod((String) objArr6[0], null).invoke(null, null)).getName());
                        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                        sb.append(stackTraceElement.getFileName());
                        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                        try {
                            Object[] objArr7 = new Object[1];
                            a((byte) (PlaceComponentResult | 8), MyBillsEntityDataFactory[21], (byte) (-MyBillsEntityDataFactory[8]), objArr7);
                            Class<?> cls4 = Class.forName((String) objArr7[0]);
                            Object[] objArr8 = new Object[1];
                            a(MyBillsEntityDataFactory[21], MyBillsEntityDataFactory[7], MyBillsEntityDataFactory[16], objArr8);
                            sb.append((String) cls4.getMethod((String) objArr8[0], null).invoke(stackTraceElement, null));
                            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                            sb.append(stackTraceElement.getMethodName());
                            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                            sb.append(stackTraceElement.getLineNumber());
                            return sb.toString();
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause != null) {
                                throw cause;
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 != null) {
                            throw cause2;
                        }
                        throw th2;
                    }
                }
                return "";
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 != null) {
                    throw cause3;
                }
                throw th3;
            }
        } catch (Throwable th4) {
            Throwable cause4 = th4.getCause();
            if (cause4 != null) {
                throw cause4;
            }
            throw th4;
        }
    }

    private static int MyBillsEntityDataFactory(int i, String str, String str2) {
        if (KClassImpl$Data$declaredNonStaticMembers$2(i)) {
            StringBuilder sb = new StringBuilder();
            sb.append("NetworkSdk_");
            sb.append(str);
            String obj = sb.toString();
            String BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(str2, 7);
            if (i == 2) {
                KClassImpl$Data$declaredNonStaticMembers$2.v(obj, BuiltInFictitiousFunctionClassFactory);
            } else if (i == 3) {
                KClassImpl$Data$declaredNonStaticMembers$2.d(obj, BuiltInFictitiousFunctionClassFactory);
            } else if (i == 4) {
                KClassImpl$Data$declaredNonStaticMembers$2.i(obj, BuiltInFictitiousFunctionClassFactory);
            } else if (i == 5) {
                KClassImpl$Data$declaredNonStaticMembers$2.w(obj, BuiltInFictitiousFunctionClassFactory);
            } else if (i == 6) {
                KClassImpl$Data$declaredNonStaticMembers$2.e(obj, BuiltInFictitiousFunctionClassFactory);
            }
        }
        if (MyBillsEntityDataFactory(i)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("NetworkKit_");
            sb2.append(str);
            return Log.println(i, sb2.toString(), BuiltInFictitiousFunctionClassFactory(str2, 7));
        }
        return 1;
    }

    public static void println(int i, String str, Object obj) {
        if (i < 3) {
            return;
        }
        MyBillsEntityDataFactory(i, str, obj == null ? "null" : obj.toString());
    }

    public static void println(int i, String str, String str2, Object... objArr) {
        if (i < 3) {
            return;
        }
        if (str2 == null) {
            InstrumentInjector.log_w("NetworkKit_Logger", "format is null, not log");
            return;
        }
        try {
            MyBillsEntityDataFactory(i, str, StringUtils.format(str2, objArr));
        } catch (IllegalFormatException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("log format error");
            sb.append(str2);
            w("NetworkKit_Logger", sb.toString(), e);
        }
    }
}
