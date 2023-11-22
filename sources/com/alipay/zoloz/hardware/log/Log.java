package com.alipay.zoloz.hardware.log;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;

/* loaded from: classes7.dex */
public final class Log {
    public static final String CONFIRM = "confirm";
    public static final String DIAGNOSE = "diagnose";
    private static final String TAG = "HD";
    private static final String TAG_PREFIX = "HD_";
    private static Logger sTargetLogger = new AndroidLogger();

    /* loaded from: classes7.dex */
    static final class AndroidLogger extends Logger {
        public static final byte[] BuiltInFictitiousFunctionClassFactory = {36, -25, -14, -85, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
        public static final int getAuthRequestContext = 89;

        /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0032). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(byte r6, short r7, int r8, java.lang.Object[] r9) {
            /*
                int r8 = r8 * 7
                int r8 = 106 - r8
                int r7 = r7 * 3
                int r7 = 16 - r7
                byte[] r0 = com.alipay.zoloz.hardware.log.Log.AndroidLogger.BuiltInFictitiousFunctionClassFactory
                int r6 = r6 * 12
                int r6 = 15 - r6
                byte[] r1 = new byte[r7]
                int r7 = r7 + (-1)
                r2 = 0
                if (r0 != 0) goto L1a
                r8 = r7
                r3 = r8
                r4 = 0
                r7 = r6
                goto L32
            L1a:
                r3 = 0
            L1b:
                int r6 = r6 + 1
                byte r4 = (byte) r8
                r1[r3] = r4
                int r4 = r3 + 1
                if (r3 != r7) goto L2c
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L2c:
                r3 = r0[r6]
                r5 = r7
                r7 = r6
                r6 = r8
                r8 = r5
            L32:
                int r3 = -r3
                int r6 = r6 + r3
                int r6 = r6 + 2
                r3 = r4
                r5 = r8
                r8 = r6
                r6 = r7
                r7 = r5
                goto L1b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alipay.zoloz.hardware.log.Log.AndroidLogger.a(byte, short, int, java.lang.Object[]):void");
        }

        private AndroidLogger() {
        }

        @Override // com.alipay.zoloz.hardware.log.Logger
        public final int verbose(String str, String str2) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            try {
                byte b = (byte) (BuiltInFictitiousFunctionClassFactory[15] + 1);
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (-BuiltInFictitiousFunctionClassFactory[15]);
                byte b4 = b3;
                Object[] objArr2 = new Object[1];
                a(b3, b4, b4, objArr2);
                sb.append(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName());
                sb.append("]");
                sb.append(str2);
                return InstrumentInjector.log_v(str, sb.toString());
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }

        @Override // com.alipay.zoloz.hardware.log.Logger
        public final int debug(String str, String str2) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            try {
                byte b = (byte) (BuiltInFictitiousFunctionClassFactory[15] + 1);
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (-BuiltInFictitiousFunctionClassFactory[15]);
                byte b4 = b3;
                Object[] objArr2 = new Object[1];
                a(b3, b4, b4, objArr2);
                sb.append(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName());
                sb.append("]");
                sb.append(str2);
                return InstrumentInjector.log_d(str, sb.toString());
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }

        @Override // com.alipay.zoloz.hardware.log.Logger
        public final int info(String str, String str2) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            try {
                byte b = (byte) (BuiltInFictitiousFunctionClassFactory[15] + 1);
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (-BuiltInFictitiousFunctionClassFactory[15]);
                byte b4 = b3;
                Object[] objArr2 = new Object[1];
                a(b3, b4, b4, objArr2);
                sb.append(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName());
                sb.append("]");
                sb.append(str2);
                return InstrumentInjector.log_i(str, sb.toString());
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }

        @Override // com.alipay.zoloz.hardware.log.Logger
        public final int warn(String str, String str2) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            try {
                byte b = (byte) (BuiltInFictitiousFunctionClassFactory[15] + 1);
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (-BuiltInFictitiousFunctionClassFactory[15]);
                byte b4 = b3;
                Object[] objArr2 = new Object[1];
                a(b3, b4, b4, objArr2);
                sb.append(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName());
                sb.append("]");
                sb.append(str2);
                return InstrumentInjector.log_w(str, sb.toString());
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }

        @Override // com.alipay.zoloz.hardware.log.Logger
        public final int error(String str, String str2) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            try {
                byte b = (byte) (BuiltInFictitiousFunctionClassFactory[15] + 1);
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (-BuiltInFictitiousFunctionClassFactory[15]);
                byte b4 = b3;
                Object[] objArr2 = new Object[1];
                a(b3, b4, b4, objArr2);
                sb.append(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName());
                sb.append("]");
                sb.append(str2);
                return InstrumentInjector.log_e(str, sb.toString());
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }

        @Override // com.alipay.zoloz.hardware.log.Logger
        protected final String getStackTraceString(Throwable th) {
            return android.util.Log.getStackTraceString(th);
        }
    }

    private Log() {
    }

    public static void setLogLevel(int i) {
        Logger logger = sTargetLogger;
        if (logger != null) {
            logger.setLogLevel(i);
        }
    }

    public static void setLogger(Logger logger) {
        sTargetLogger = logger;
    }

    public static void v(String str) {
        sTargetLogger.v(TAG, str);
    }

    public static void v(String str, String str2) {
        Logger logger = sTargetLogger;
        StringBuilder sb = new StringBuilder();
        sb.append(TAG_PREFIX);
        sb.append(str);
        logger.v(sb.toString(), str2);
    }

    public static void d(String str) {
        sTargetLogger.d(TAG, str);
    }

    public static void d(String str, String str2) {
        Logger logger = sTargetLogger;
        StringBuilder sb = new StringBuilder();
        sb.append(TAG_PREFIX);
        sb.append(str);
        logger.d(sb.toString(), str2);
    }

    public static void i(String str) {
        sTargetLogger.i(TAG, str);
    }

    public static void i(String str, String str2) {
        Logger logger = sTargetLogger;
        StringBuilder sb = new StringBuilder();
        sb.append(TAG_PREFIX);
        sb.append(str);
        logger.i(sb.toString(), str2);
    }

    public static void w(String str) {
        sTargetLogger.w(TAG, str);
    }

    public static void w(String str, String str2) {
        Logger logger = sTargetLogger;
        StringBuilder sb = new StringBuilder();
        sb.append(TAG_PREFIX);
        sb.append(str);
        logger.w(sb.toString(), str2);
    }

    public static void w(Throwable th) {
        sTargetLogger.w(TAG, th);
    }

    public static void w(String str, Throwable th) {
        Logger logger = sTargetLogger;
        StringBuilder sb = new StringBuilder();
        sb.append(TAG_PREFIX);
        sb.append(str);
        logger.w(sb.toString(), th);
    }

    public static void w(String str, String str2, Throwable th) {
        Logger logger = sTargetLogger;
        StringBuilder sb = new StringBuilder();
        sb.append(TAG_PREFIX);
        sb.append(str);
        logger.w(sb.toString(), str2, th);
    }

    public static void e(String str) {
        sTargetLogger.e(TAG, str);
    }

    public static void e(String str, String str2) {
        Logger logger = sTargetLogger;
        StringBuilder sb = new StringBuilder();
        sb.append(TAG_PREFIX);
        sb.append(str);
        logger.e(sb.toString(), str2);
    }

    public static void e(Throwable th) {
        sTargetLogger.e(TAG, th);
    }

    public static void e(String str, Throwable th) {
        Logger logger = sTargetLogger;
        StringBuilder sb = new StringBuilder();
        sb.append(TAG_PREFIX);
        sb.append(str);
        logger.e(sb.toString(), th);
    }

    public static void e(String str, String str2, Throwable th) {
        Logger logger = sTargetLogger;
        StringBuilder sb = new StringBuilder();
        sb.append(TAG_PREFIX);
        sb.append(str);
        logger.e(sb.toString(), str2, th);
    }
}
