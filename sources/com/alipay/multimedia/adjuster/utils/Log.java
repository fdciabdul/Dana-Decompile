package com.alipay.multimedia.adjuster.utils;

import android.text.TextUtils;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;

/* loaded from: classes7.dex */
public class Log {
    public static final String COST_TIME_TAG = "CostTime";

    /* renamed from: a  reason: collision with root package name */
    private static Logger f7337a;
    private String b;
    private String c;
    private boolean d = false;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {11, Ascii.GS, 107, 8, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int PlaceComponentResult = 233;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void f(short r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 12
            int r8 = r8 + 4
            int r7 = r7 * 3
            int r7 = 16 - r7
            int r9 = r9 * 7
            int r9 = r9 + 99
            byte[] r0 = com.alipay.multimedia.adjuster.utils.Log.BuiltInFictitiousFunctionClassFactory
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            goto L35
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r9
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r7) goto L2b
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2b:
            r3 = r0[r8]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L35:
            int r10 = r10 + r7
            int r7 = r9 + 1
            int r9 = r10 + 2
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            r6 = r8
            r8 = r7
            r7 = r6
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.multimedia.adjuster.utils.Log.f(short, byte, short, java.lang.Object[]):void");
    }

    public static void setLogger(Logger logger) {
        f7337a = logger;
    }

    public static final Log getLogger(Class cls) {
        return getLogger(cls.getSimpleName());
    }

    public Log setModuleName(String str) {
        this.c = str;
        return this;
    }

    public Log openModuleTag(boolean z) {
        this.d = z;
        return this;
    }

    public static final Log getLogger(String str) {
        Log log = new Log();
        log.b = str;
        return log;
    }

    private static String a(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            try {
                str = String.format(str, objArr);
            } catch (Exception unused) {
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        try {
            byte b = (byte) (BuiltInFictitiousFunctionClassFactory[15] - 1);
            byte b2 = BuiltInFictitiousFunctionClassFactory[15];
            Object[] objArr2 = new Object[1];
            f(b, b2, b2, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            byte b3 = BuiltInFictitiousFunctionClassFactory[15];
            byte b4 = (byte) (b3 - 1);
            Object[] objArr3 = new Object[1];
            f(b3, b4, b4, objArr3);
            sb.append(((Thread) cls.getMethod((String) objArr3[0], null).invoke(null, null)).getName());
            sb.append("(");
            try {
                byte b5 = (byte) (BuiltInFictitiousFunctionClassFactory[15] - 1);
                byte b6 = BuiltInFictitiousFunctionClassFactory[15];
                Object[] objArr4 = new Object[1];
                f(b5, b6, b6, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                byte b7 = BuiltInFictitiousFunctionClassFactory[15];
                byte b8 = (byte) (b7 - 1);
                Object[] objArr5 = new Object[1];
                f(b7, b8, b8, objArr5);
                sb.append(((Thread) cls2.getMethod((String) objArr5[0], null).invoke(null, null)).getId());
                sb.append(")] ");
                sb.append(str);
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

    public static void V(String str, String str2, Object... objArr) {
        String a2 = a(str2, objArr);
        Logger logger = f7337a;
        if (logger != null) {
            logger.v(str, a2);
        } else {
            InstrumentInjector.log_v(str, a2);
        }
    }

    public static void D(String str, String str2, Object... objArr) {
        String a2 = a(str2, objArr);
        Logger logger = f7337a;
        if (logger != null) {
            logger.d(str, a2);
        } else {
            InstrumentInjector.log_i(str, a2);
        }
    }

    public static void I(String str, String str2, Object... objArr) {
        String a2 = a(str2, objArr);
        Logger logger = f7337a;
        if (logger != null) {
            logger.i(str, a2);
        } else {
            InstrumentInjector.log_i(str, a2);
        }
    }

    public static void W(String str, String str2, Object... objArr) {
        String a2 = a(str2, objArr);
        Logger logger = f7337a;
        if (logger != null) {
            logger.w(str, a2);
        } else {
            InstrumentInjector.log_w(str, a2);
        }
    }

    public static void P(String str, String str2, Object... objArr) {
        String a2 = a(str2, objArr);
        Logger logger = f7337a;
        if (logger != null) {
            logger.d(str, a2);
        } else {
            InstrumentInjector.log_v(str, a2);
        }
    }

    public static void E(String str, Throwable th, String str2, Object... objArr) {
        String a2 = a(str2, objArr);
        Logger logger = f7337a;
        if (logger != null) {
            logger.e(str, a2, th);
        } else {
            InstrumentInjector.log_e(str, a2, th);
        }
    }

    public static void E(String str, String str2, Throwable th, Object... objArr) {
        E(str, th, str2, objArr);
    }

    public static void E(String str, String str2, Object... objArr) {
        E(str, (Throwable) null, str2, objArr);
    }

    public void v(String str, Object... objArr) {
        V(a(), a(str), objArr);
    }

    public void d(String str, Object... objArr) {
        D(a(), a(str), objArr);
    }

    public void i(String str, Object... objArr) {
        I(a(), a(str), objArr);
    }

    public void w(String str, Object... objArr) {
        W(a(), a(str), objArr);
    }

    public void p(String str, Object... objArr) {
        P(a(), a(str), objArr);
    }

    public void e(Throwable th, String str, Object... objArr) {
        E(a(), th, a(str), objArr);
    }

    public void e(String str, Object... objArr) {
        E(a(), (Throwable) null, a(str), objArr);
    }

    private String a() {
        return (!this.d || TextUtils.isEmpty(this.c)) ? this.b : this.c;
    }

    private String a(String str) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.c)) {
            sb.append("[");
            sb.append(this.c);
            sb.append("]");
        }
        if (!TextUtils.isEmpty(this.b)) {
            sb.append("[");
            sb.append(this.b);
            sb.append("]");
        }
        sb.append(str);
        return sb.toString();
    }

    public static void TIME(String str, long j, Object... objArr) {
        if (j > 100) {
            D(COST_TIME_TAG, str, objArr);
        } else {
            P(COST_TIME_TAG, str, objArr);
        }
    }
}
