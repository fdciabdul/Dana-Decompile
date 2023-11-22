package com.alibaba.ariver.kernel.common.utils;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.exthub.common.ExtHubLogger;
import com.alipay.mobile.rome.syncsdk.transport.connection.d;

/* loaded from: classes3.dex */
public class RVTraceUtils {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {41, -91, 83, 107, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int MyBillsEntityDataFactory = 144;
    public static boolean isOpenSystemTrace;
    public static boolean isPerfTestMode;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002e -> B:11:0x0039). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r5, int r6, short r7, java.lang.Object[] r8) {
        /*
            byte[] r0 = com.alibaba.ariver.kernel.common.utils.RVTraceUtils.BuiltInFictitiousFunctionClassFactory
            int r7 = r7 * 12
            int r7 = 16 - r7
            int r6 = r6 * 7
            int r6 = r6 + 99
            int r5 = r5 * 3
            int r5 = 16 - r5
            byte[] r1 = new byte[r5]
            r2 = -1
            int r5 = r5 + r2
            if (r0 != 0) goto L1b
            r6 = r5
            r2 = r1
            r3 = -1
            r1 = r0
            r0 = r8
            r8 = r7
            goto L39
        L1b:
            r4 = r7
            r7 = r6
        L1d:
            r6 = r4
            int r2 = r2 + 1
            byte r3 = (byte) r7
            r1[r2] = r3
            if (r2 != r5) goto L2e
            java.lang.String r5 = new java.lang.String
            r6 = 0
            r5.<init>(r1, r6)
            r8[r6] = r5
            return
        L2e:
            r3 = r0[r6]
            r4 = r6
            r6 = r5
            r5 = r3
            r3 = r2
            r2 = r1
            r1 = r0
            r0 = r8
            r8 = r7
            r7 = r4
        L39:
            int r7 = r7 + 1
            int r8 = r8 + r5
            int r5 = r8 + 2
            r8 = r0
            r0 = r1
            r1 = r2
            r2 = r3
            r4 = r7
            r7 = r5
            r5 = r6
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.common.utils.RVTraceUtils.c(short, int, short, java.lang.Object[]):void");
    }

    private static void a(String str, String str2) {
        if (!RVKernelUtils.isDebug() && isPerfTestMode) {
            b(str, str2);
        } else {
            ExtHubLogger.d(str, str2);
        }
    }

    private static void b(String str, String str2) {
        try {
            try {
                byte b = (byte) (BuiltInFictitiousFunctionClassFactory[15] - 1);
                byte b2 = BuiltInFictitiousFunctionClassFactory[15];
                Object[] objArr = new Object[1];
                c(b, b2, (byte) (b2 - 1), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = BuiltInFictitiousFunctionClassFactory[15];
                Object[] objArr2 = new Object[1];
                c(b3, (byte) (b3 - 1), BuiltInFictitiousFunctionClassFactory[15], objArr2);
                String name = ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName();
                StringBuilder sb = new StringBuilder(91);
                sb.append(name);
                sb.append(']');
                sb.append(str2);
                ReflectUtils.invokeStaticMethod(Log.class, d.f7256a, new Class[]{String.class, String.class}, new Object[]{str, sb.toString()});
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean a() {
        return RVKernelUtils.isDebug() || (isPerfTestMode && isOpenSystemTrace);
    }

    public static void traceBeginSection(String str) {
        if (a()) {
            try {
                if (Build.VERSION.SDK_INT >= 18) {
                    if (str.length() > 127) {
                        str = str.substring(0, 127);
                    }
                    Trace.beginSection(str);
                    StringBuilder sb = new StringBuilder();
                    sb.append("traceBeginSection: ");
                    sb.append(str);
                    a("RVTraceUtils", sb.toString());
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void traceEndSection(String str) {
        if (a()) {
            try {
                if (Build.VERSION.SDK_INT >= 18) {
                    Trace.endSection();
                    StringBuilder sb = new StringBuilder();
                    sb.append("traceEndSection: ");
                    sb.append(str);
                    a("RVTraceUtils", sb.toString());
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void asyncTraceBegin(RVTracePhase rVTracePhase) {
        try {
            RVPhaseRecorder rVPhaseRecorder = (RVPhaseRecorder) RVProxy.get(RVPhaseRecorder.class);
            if (rVPhaseRecorder != null) {
                rVPhaseRecorder.startPhase(rVTracePhase);
            }
        } catch (Throwable th) {
            ExtHubLogger.e("phase recorder start exception", th);
        }
        if (a()) {
            try {
                asyncTraceBegin(rVTracePhase.phaseName, rVTracePhase.cookie);
            } catch (Throwable th2) {
                a("RVTraceUtils", th2.toString());
            }
        }
    }

    public static void asyncTraceEnd(RVTracePhase rVTracePhase) {
        try {
            RVPhaseRecorder rVPhaseRecorder = (RVPhaseRecorder) RVProxy.get(RVPhaseRecorder.class);
            if (rVPhaseRecorder != null) {
                rVPhaseRecorder.stopPhase(rVTracePhase);
            }
        } catch (Throwable th) {
            ExtHubLogger.e("phase recorder start exception", th);
        }
        if (a()) {
            try {
                asyncTraceEnd(rVTracePhase.phaseName, rVTracePhase.cookie);
            } catch (Throwable th2) {
                a("RVTraceUtils", th2.toString());
            }
        }
    }

    public static void asyncTraceBegin(String str, int i) {
        if (a()) {
            try {
                if (Build.VERSION.SDK_INT >= 18) {
                    ReflectUtils.invokeStaticMethod(Trace.class, "asyncTraceBegin", new Class[]{Long.TYPE, String.class, Integer.TYPE}, new Object[]{4096L, str, Integer.valueOf(i)});
                    StringBuilder sb = new StringBuilder();
                    sb.append("asyncTraceBegin: ");
                    sb.append(str);
                    a("RVTraceUtils", sb.toString());
                }
            } catch (Exception e) {
                a("RVTraceUtils", e.toString());
            }
        }
    }

    public static void asyncTraceEnd(String str, int i) {
        if (a()) {
            try {
                if (Build.VERSION.SDK_INT >= 18) {
                    ReflectUtils.invokeStaticMethod(Trace.class, "asyncTraceEnd", new Class[]{Long.TYPE, String.class, Integer.TYPE}, new Object[]{4096L, str, Integer.valueOf(i)});
                    StringBuilder sb = new StringBuilder();
                    sb.append("asyncTraceEnd: ");
                    sb.append(str);
                    a("RVTraceUtils", sb.toString());
                }
            } catch (Exception e) {
                a("RVTraceUtils", e.toString());
            }
        }
    }
}
