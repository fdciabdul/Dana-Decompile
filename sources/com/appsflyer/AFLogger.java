package com.appsflyer;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.appsflyer.internal.ae;
import com.appsflyer.internal.aj;
import com.appsflyer.internal.at;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import id.dana.sendmoney.summary.SummaryActivity;

/* loaded from: classes.dex */
public final class AFLogger {
    public static final byte[] PlaceComponentResult = {110, -41, 63, 58, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 161;
    private static final long values = System.currentTimeMillis();

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r7, byte r8, int r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 3
            int r7 = r7 + 13
            int r8 = r8 * 12
            int r8 = r8 + 4
            int r9 = r9 * 7
            int r9 = 106 - r9
            byte[] r0 = com.appsflyer.AFLogger.PlaceComponentResult
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r9
            r5 = 0
            r9 = r7
            goto L30
        L17:
            r3 = 0
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r6
        L1c:
            byte r4 = (byte) r7
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r8) goto L2b
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2b:
            r3 = r0[r9]
            r6 = r9
            r9 = r8
            r8 = r6
        L30:
            int r3 = -r3
            int r7 = r7 + r3
            int r7 = r7 + 2
            int r8 = r8 + 1
            r3 = r5
            r6 = r9
            r9 = r8
            r8 = r6
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AFLogger.a(byte, byte, int, java.lang.Object[]):void");
    }

    public static void AFInAppEventType(String str, boolean z) {
        if (AFInAppEventType(LogLevel.INFO)) {
            InstrumentInjector.log_i("AppsFlyer_6.3.2", AFInAppEventParameterName(str, false));
        }
        if (z) {
            aj.valueOf().AFInAppEventType(null, "I", AFInAppEventParameterName(str, true));
        }
    }

    private static String AFInAppEventParameterName(String str, boolean z) {
        if (str == null) {
            str = "null";
        }
        if (z || LogLevel.VERBOSE.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel())) {
            StringBuilder sb = new StringBuilder("(");
            sb.append(System.currentTimeMillis() - values);
            sb.append(") [");
            try {
                byte b = (byte) (-PlaceComponentResult[15]);
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, (byte) (b2 - 1), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (PlaceComponentResult[15] + 1);
                Object[] objArr2 = new Object[1];
                a(b3, b3, (byte) (-PlaceComponentResult[15]), objArr2);
                sb.append(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName());
                sb.append("] ");
                sb.append(str);
                return sb.toString();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
        return str;
    }

    private static void AFKeystoreWrapper(String str, Throwable th, boolean z, boolean z2) {
        if (AFInAppEventType(LogLevel.ERROR)) {
            if (str == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(th.getClass().getSimpleName());
                sb.append(" at ");
                sb.append(th.getStackTrace()[0].toString());
                str = sb.toString();
            }
            String AFInAppEventParameterName = AFInAppEventParameterName(str, false);
            if (z2) {
                InstrumentInjector.log_e("AppsFlyer_6.3.2", AFInAppEventParameterName, th);
            } else if (z) {
                InstrumentInjector.log_d("AppsFlyer_6.3.2", AFInAppEventParameterName);
            }
        }
        aj valueOf = aj.valueOf();
        Throwable cause = th.getCause();
        valueOf.AFInAppEventType("exception", th.getClass().getSimpleName(), aj.AFInAppEventType(cause == null ? th.getMessage() : cause.getMessage(), cause == null ? th.getStackTrace() : cause.getStackTrace()));
        if (at.AFInAppEventParameterName != null) {
            ae.values(at.AFInAppEventParameterName).edit().putLong("exception_number", (at.AFInAppEventParameterName == null ? -1L : ae.values(at.AFInAppEventParameterName).getLong("exception_number", 0L)) + 1).apply();
        }
    }

    public static void valueOf(String str) {
        if (AFInAppEventType(LogLevel.WARNING)) {
            InstrumentInjector.log_w("AppsFlyer_6.3.2", AFInAppEventParameterName(str, false));
        }
        aj.valueOf().AFInAppEventType(null, "W", AFInAppEventParameterName(str, true));
    }

    public static void AFInAppEventParameterName(String str) {
        if (AFInAppEventType(LogLevel.VERBOSE)) {
            InstrumentInjector.log_v("AppsFlyer_6.3.2", AFInAppEventParameterName(str, false));
        }
        aj.valueOf().AFInAppEventType(null, "V", AFInAppEventParameterName(str, true));
    }

    private static boolean AFInAppEventType(LogLevel logLevel) {
        return logLevel.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel());
    }

    public static void AFInAppEventType(String str) {
        if (!valueOf()) {
            InstrumentInjector.log_d("AppsFlyer_6.3.2", AFInAppEventParameterName(str, false));
        }
        aj.valueOf().AFInAppEventType(null, LogConstants.RESULT_FALSE, str);
    }

    private static boolean valueOf() {
        return AppsFlyerProperties.getInstance().isLogsDisabledCompletely();
    }

    public static void AFKeystoreWrapper(String str) {
        AFInAppEventType(str, true);
    }

    public static void AFInAppEventType(String str, Throwable th) {
        AFKeystoreWrapper(str, th, true, false);
    }

    public static void AFInAppEventParameterName(String str, Throwable th) {
        AFKeystoreWrapper(str, th, true, true);
    }

    public static void values(Throwable th) {
        AFKeystoreWrapper(null, th, false, false);
    }

    public static void init(String str) {
        valueOf(str);
    }

    /* loaded from: classes.dex */
    public enum LogLevel {
        NONE(0),
        ERROR(1),
        WARNING(2),
        INFO(3),
        DEBUG(4),
        VERBOSE(5);

        private int AFInAppEventParameterName;

        LogLevel(int i) {
            this.AFInAppEventParameterName = i;
        }

        public final int getLevel() {
            return this.AFInAppEventParameterName;
        }
    }

    public static void values(String str) {
        if (AFInAppEventType(LogLevel.DEBUG)) {
            InstrumentInjector.log_d("AppsFlyer_6.3.2", AFInAppEventParameterName(str, false));
        }
        aj.valueOf().AFInAppEventType(null, SummaryActivity.DAYS, AFInAppEventParameterName(str, true));
    }
}
