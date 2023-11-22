package com.appsflyer.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.appsflyer.AFLogger;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class w {
    w() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, String> AFInAppEventParameterName(Context context) {
        HashMap hashMap = new HashMap();
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i = context.getResources().getConfiguration().screenLayout;
            hashMap.put("x_px", String.valueOf(displayMetrics.widthPixels));
            hashMap.put("y_px", String.valueOf(displayMetrics.heightPixels));
            hashMap.put("d_dpi", String.valueOf(displayMetrics.densityDpi));
            hashMap.put(GriverMonitorConstants.KEY_SIZE, String.valueOf(i & 15));
            hashMap.put("xdp", String.valueOf(displayMetrics.xdpi));
            hashMap.put("ydp", String.valueOf(displayMetrics.ydpi));
        } catch (Throwable th) {
            AFLogger.AFInAppEventType("Couldn't aggregate screen stats: ", th);
        }
        return hashMap;
    }
}
