package com.huawei.hms.stats;

import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes8.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f7485a = new Object();
    public static boolean b;
    public static boolean c;

    public static boolean a() {
        boolean z;
        synchronized (f7485a) {
            if (!b) {
                boolean z2 = false;
                try {
                    Class.forName("com.huawei.hianalytics.process.HiAnalyticsInstance");
                    z = true;
                } catch (ClassNotFoundException unused) {
                    HMSLog.i("HianalyticsExist", "In isHianalyticsExist, Failed to find class HiAnalyticsConfig.");
                    z = false;
                }
                try {
                    Class.forName("com.huawei.hms.hatool.HmsHiAnalyticsUtils");
                    z2 = true;
                } catch (ClassNotFoundException unused2) {
                    HMSLog.i("HianalyticsExist", "In isHianalyticsExist, Failed to find class HmsHiAnalyticsUtils.");
                }
                if (z && !z2) {
                    c = true;
                }
                b = true;
                StringBuilder sb = new StringBuilder();
                sb.append("hianalytics exist: ");
                sb.append(c);
                HMSLog.i("HianalyticsExist", sb.toString());
            }
        }
        return c;
    }
}
