package com.alibaba.griver.base.common.logger;

import android.text.TextUtils;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.api.common.logger.GriverLoggerProxy;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.iap.ac.android.diagnoselog.api.DiagnoseHelper;
import com.iap.ac.android.diagnoselog.api.DiagnoseLogHelper;
import com.iap.android.iaptinylog.IAPTinyLogger;
import com.iap.android.iaptinylog.data.IAPTinyLog;
import com.iap.android.iaptinylog.data.IAPTinyLogDiagnoseLevel;

/* loaded from: classes2.dex */
public class GriverLogger {
    public static final byte[] PlaceComponentResult = {114, -79, -70, 22, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 24;

    /* renamed from: a  reason: collision with root package name */
    private static GriverLoggerProxy f6294a = new GriverLogcatLogger();
    private static boolean b = diagnoseExist();
    private static boolean c = diagnoseV2Exist();

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void f(byte r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 12
            int r8 = 16 - r8
            int r6 = r6 * 3
            int r6 = r6 + 13
            int r7 = r7 * 7
            int r7 = 106 - r7
            byte[] r0 = com.alibaba.griver.base.common.logger.GriverLogger.PlaceComponentResult
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L38
        L1b:
            r3 = 0
        L1c:
            r5 = r8
            r8 = r7
            r7 = r5
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L2c
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2c:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L38:
            int r8 = r8 + 1
            int r7 = -r7
            int r9 = r9 + r7
            int r7 = r9 + 2
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.common.logger.GriverLogger.f(byte, int, short, java.lang.Object[]):void");
    }

    private static String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        try {
            byte b2 = (byte) (-PlaceComponentResult[15]);
            byte b3 = (byte) (b2 - 1);
            Object[] objArr = new Object[1];
            f(b2, b3, b3, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b4 = (byte) (PlaceComponentResult[15] + 1);
            byte b5 = (byte) (-PlaceComponentResult[15]);
            Object[] objArr2 = new Object[1];
            f(b4, b5, b5, objArr2);
            sb.append(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName());
            sb.append("-");
            try {
                byte b6 = (byte) (-PlaceComponentResult[15]);
                byte b7 = (byte) (b6 - 1);
                Object[] objArr3 = new Object[1];
                f(b6, b7, b7, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                byte b8 = (byte) (PlaceComponentResult[15] + 1);
                byte b9 = (byte) (-PlaceComponentResult[15]);
                Object[] objArr4 = new Object[1];
                f(b8, b9, b9, objArr4);
                sb.append(((Thread) cls2.getMethod((String) objArr4[0], null).invoke(null, null)).getId());
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
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 != null) {
                throw cause2;
            }
            throw th2;
        }
    }

    public static void debug(String str, String str2) {
        if (b(str2)) {
            if (IAPTinyLogger.KClassImpl$Data$declaredNonStaticMembers$2().size() != 0) {
                GriverEnv.getLogger();
                IAPTinyLogger.PlaceComponentResult(IAPTinyLog.diagnoseLog("GriverLogger", str2, IAPTinyLogDiagnoseLevel.IAPTinyLogDiagnoseLevelDebug));
            }
            String a2 = a(str2);
            if (b) {
                try {
                    if (c) {
                        DiagnoseHelper.d(str, a2, Boolean.valueOf(f6294a.isEnable()));
                        return;
                    } else {
                        DiagnoseLogHelper.d(str, a2);
                        return;
                    }
                } catch (Throwable unused) {
                }
            }
            f6294a.debug(str, a2);
        }
    }

    public static void d(String str, String str2) {
        if (b(str2)) {
            if (IAPTinyLogger.KClassImpl$Data$declaredNonStaticMembers$2().size() != 0) {
                GriverEnv.getLogger();
                IAPTinyLogger.PlaceComponentResult(IAPTinyLog.diagnoseLog("GriverLogger", str2, IAPTinyLogDiagnoseLevel.IAPTinyLogDiagnoseLevelDebug));
            }
            String a2 = a(str2);
            if (b) {
                try {
                    if (c) {
                        DiagnoseHelper.d(str, a2, Boolean.valueOf(f6294a.isEnable()));
                        return;
                    } else {
                        DiagnoseLogHelper.d(str, a2);
                        return;
                    }
                } catch (Throwable unused) {
                }
            }
            f6294a.d(str, a2);
        }
    }

    public static void w(String str, String str2) {
        if (b(str2)) {
            if (IAPTinyLogger.KClassImpl$Data$declaredNonStaticMembers$2().size() != 0) {
                GriverEnv.getLogger();
                IAPTinyLogger.PlaceComponentResult(IAPTinyLog.diagnoseLog("GriverLogger", str2, IAPTinyLogDiagnoseLevel.IAPTinyLogDiagnoseLevelWarn));
            }
            String a2 = a(str2);
            if (b) {
                try {
                    if (c) {
                        DiagnoseHelper.w(str, a2, Boolean.valueOf(f6294a.isEnable()));
                        return;
                    } else {
                        DiagnoseLogHelper.w(str, a2);
                        return;
                    }
                } catch (Throwable unused) {
                }
            }
            f6294a.w(str, a2);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (b(str2)) {
            if (IAPTinyLogger.KClassImpl$Data$declaredNonStaticMembers$2().size() != 0) {
                GriverEnv.getLogger();
                IAPTinyLogger.PlaceComponentResult(IAPTinyLog.diagnoseLog("GriverLogger", str2, IAPTinyLogDiagnoseLevel.IAPTinyLogDiagnoseLevelWarn));
            }
            String a2 = a(str2);
            if (b) {
                try {
                    if (c) {
                        DiagnoseHelper.w(str, a2, th, Boolean.valueOf(f6294a.isEnable()));
                        return;
                    } else {
                        DiagnoseLogHelper.w(str, a2, th);
                        return;
                    }
                } catch (Throwable unused) {
                }
            }
            f6294a.w(str, a2, th);
        }
    }

    public static void e(String str, String str2) {
        if (b(str2)) {
            if (IAPTinyLogger.KClassImpl$Data$declaredNonStaticMembers$2().size() != 0) {
                GriverEnv.getLogger();
                IAPTinyLogger.PlaceComponentResult(IAPTinyLog.diagnoseLog("GriverLogger", str2, IAPTinyLogDiagnoseLevel.IAPTinyLogDiagnoseLevelError));
            }
            String a2 = a(str2);
            if (b) {
                try {
                    if (c) {
                        DiagnoseHelper.e(str, a2, Boolean.valueOf(f6294a.isEnable()));
                        return;
                    } else {
                        DiagnoseLogHelper.e(str, a2);
                        return;
                    }
                } catch (Throwable unused) {
                }
            }
            f6294a.e(str, a2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        String str3;
        if (b(str2)) {
            if (IAPTinyLogger.KClassImpl$Data$declaredNonStaticMembers$2().size() != 0) {
                GriverEnv.getLogger();
                if (th == null || TextUtils.isEmpty(th.getMessage())) {
                    str3 = str2;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(":");
                    sb.append(th.getMessage());
                    str3 = sb.toString();
                }
                IAPTinyLogger.PlaceComponentResult(IAPTinyLog.diagnoseLog("GriverLogger", str3, IAPTinyLogDiagnoseLevel.IAPTinyLogDiagnoseLevelError));
            }
            String a2 = a(str2);
            if (b) {
                try {
                    if (c) {
                        DiagnoseHelper.e(str, a2, th, Boolean.valueOf(f6294a.isEnable()));
                        return;
                    } else {
                        DiagnoseLogHelper.e(str, a2, th);
                        return;
                    }
                } catch (Throwable unused) {
                }
            }
            f6294a.e(str, a2, th);
        }
    }

    public static void setLogger(GriverLoggerProxy griverLoggerProxy) {
        if (griverLoggerProxy != null) {
            f6294a = griverLoggerProxy;
        } else {
            InstrumentInjector.log_e("GriverLogger", "should not set null proxy to GriverLogger");
        }
    }

    public static boolean diagnoseExist() {
        try {
            Class.forName("com.iap.ac.android.diagnoselog.api.DiagnoseLogHelper");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean diagnoseV2Exist() {
        try {
            Class.forName("com.iap.ac.android.diagnoselog.api.DiagnoseHelper");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void setDiagnoseEnable(boolean z) {
        b = z && diagnoseExist();
    }

    private static boolean b(String str) {
        return !TextUtils.isEmpty(str);
    }
}
