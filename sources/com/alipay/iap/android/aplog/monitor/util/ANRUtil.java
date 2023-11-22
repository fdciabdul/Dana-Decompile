package com.alipay.iap.android.aplog.monitor.util;

import android.text.TextUtils;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.monitor.AnrTraceProcessor;

/* loaded from: classes6.dex */
public class ANRUtil {
    public static boolean a(int i, String str) {
        try {
        } catch (Throwable th) {
            LoggerFactory.getTraceLogger().warn("ANRUtil", th);
        }
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (i == 0) {
            if (!a(str)) {
                return false;
            }
        } else if (1 == i) {
            String a2 = AnrTraceProcessor.a(str);
            if (a2 != null && !TextUtils.isEmpty(a2)) {
                if (!a(a2)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    private static boolean a(String str) {
        return (str.contains("android.os.MessageQueue.nativePollOnce") || str.contains("android.hardware.Camera.open") || str.contains("android.location.LocationManager.requestLocationUpdates")) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00b1 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a() {
        /*
            java.lang.String r0 = "getThreadsStackTrace"
            java.lang.String r1 = "\n"
            java.lang.String r2 = "ANRUtil"
            com.alipay.iap.android.aplog.core.logger.TraceLogger r3 = com.alipay.iap.android.aplog.core.LoggerFactory.getTraceLogger()     // Catch: java.lang.Throwable -> La0
            java.lang.String r4 = "ANR thread dump start"
            r3.warn(r2, r4)     // Catch: java.lang.Throwable -> La0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La0
            r3.<init>()     // Catch: java.lang.Throwable -> La0
            java.util.Map r4 = java.lang.Thread.getAllStackTraces()     // Catch: java.lang.Throwable -> L6c
            java.util.Set r4 = r4.entrySet()     // Catch: java.lang.Throwable -> L6c
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> L6c
        L20:
            boolean r5 = r4.hasNext()     // Catch: java.lang.Throwable -> L6c
            if (r5 == 0) goto L74
            java.lang.Object r5 = r4.next()     // Catch: java.lang.Throwable -> L6c
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch: java.lang.Throwable -> L6c
            java.lang.Object r6 = r5.getKey()     // Catch: java.lang.Throwable -> L63
            java.lang.Thread r6 = (java.lang.Thread) r6     // Catch: java.lang.Throwable -> L63
            java.lang.Object r5 = r5.getValue()     // Catch: java.lang.Throwable -> L63
            java.lang.Object[] r5 = (java.lang.Object[]) r5     // Catch: java.lang.Throwable -> L63
            java.lang.String r6 = r6.getName()     // Catch: java.lang.Throwable -> L63
            r7 = 10
            r3.append(r7)     // Catch: java.lang.Throwable -> L63
            java.lang.String r7 = "ThreadName="
            r3.append(r7)     // Catch: java.lang.Throwable -> L63
            r3.append(r6)     // Catch: java.lang.Throwable -> L63
            r3.append(r1)     // Catch: java.lang.Throwable -> L63
            int r6 = r5.length     // Catch: java.lang.Throwable -> L63
            r7 = 0
        L4e:
            if (r7 >= r6) goto L5f
            r8 = r5[r7]     // Catch: java.lang.Throwable -> L63
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> L63
            r3.append(r8)     // Catch: java.lang.Throwable -> L63
            r3.append(r1)     // Catch: java.lang.Throwable -> L63
            int r7 = r7 + 1
            goto L4e
        L5f:
            r3.append(r1)     // Catch: java.lang.Throwable -> L63
            goto L20
        L63:
            r5 = move-exception
            com.alipay.iap.android.aplog.core.logger.TraceLogger r6 = com.alipay.iap.android.aplog.core.LoggerFactory.getTraceLogger()     // Catch: java.lang.Throwable -> L6c
            r6.warn(r2, r0, r5)     // Catch: java.lang.Throwable -> L6c
            goto L20
        L6c:
            r1 = move-exception
            com.alipay.iap.android.aplog.core.logger.TraceLogger r4 = com.alipay.iap.android.aplog.core.LoggerFactory.getTraceLogger()     // Catch: java.lang.Throwable -> La0
            r4.warn(r2, r0, r1)     // Catch: java.lang.Throwable -> La0
        L74:
            com.alipay.iap.android.aplog.core.logger.TraceLogger r0 = com.alipay.iap.android.aplog.core.LoggerFactory.getTraceLogger()     // Catch: java.lang.Throwable -> La0
            java.lang.String r1 = "ANR thread dump end"
            r0.warn(r2, r1)     // Catch: java.lang.Throwable -> La0
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> La0
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> La2
            if (r1 != 0) goto Lab
            com.alipay.iap.android.aplog.core.logger.TraceLogger r1 = com.alipay.iap.android.aplog.core.LoggerFactory.getInnerTraceLogger()     // Catch: java.lang.Throwable -> La2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La2
            r3.<init>()     // Catch: java.lang.Throwable -> La2
            java.lang.String r4 = "All Threads Traces: ###"
            r3.append(r4)     // Catch: java.lang.Throwable -> La2
            r3.append(r0)     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> La2
            r1.warn(r2, r3)     // Catch: java.lang.Throwable -> La2
            goto Lab
        La0:
            java.lang.String r0 = ""
        La2:
            com.alipay.iap.android.aplog.core.logger.TraceLogger r1 = com.alipay.iap.android.aplog.core.LoggerFactory.getTraceLogger()
            java.lang.String r3 = "ANR thread dump failed"
            r1.warn(r2, r3)
        Lab:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto Lb3
            java.lang.String r0 = "no threads trace"
        Lb3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.monitor.util.ANRUtil.a():java.lang.String");
    }
}
