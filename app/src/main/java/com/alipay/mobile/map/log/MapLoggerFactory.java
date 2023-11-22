package com.alipay.mobile.map.log;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes6.dex */
public class MapLoggerFactory {
    public static final String TAG = "MapLoggerFactory";

    public static MapBusinessLogger getBusinessLogger() {
        return MapBusinessLogger.INSTANCE;
    }

    public static MapPerformanceLogger getPerformanceLogger() {
        return MapPerformanceLogger.INSTANCE;
    }

    public static void expose(Context context, String str, Map<String, String> map) {
        if (context != null) {
            TextUtils.isEmpty(str);
        }
    }
}
