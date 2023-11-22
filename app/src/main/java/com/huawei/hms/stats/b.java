package com.huawei.hms.stats;

import android.content.Context;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hms.utils.HMSBIInitializer;
import java.util.LinkedHashMap;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static HiAnalyticsInstance f7484a;

    public static HiAnalyticsInstance a(Context context) {
        HiAnalyticsInstance analyticsInstance = HMSBIInitializer.getInstance(context).getAnalyticsInstance();
        f7484a = analyticsInstance;
        return analyticsInstance;
    }

    public static void a(Context context, String str, String str2) {
        if (a(context) != null) {
            f7484a.onEvent(context, str, str2);
        }
    }

    public static void a(Context context, int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (a(context) != null) {
            f7484a.onEvent(i, str, linkedHashMap);
        }
    }

    public static void a(Context context, int i) {
        if (a(context) != null) {
            f7484a.onReport(i);
        }
    }
}
