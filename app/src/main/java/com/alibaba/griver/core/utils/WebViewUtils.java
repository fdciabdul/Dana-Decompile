package com.alibaba.griver.core.utils;

import android.app.Activity;
import android.os.Bundle;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.griver.base.common.config.GriverConfig;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.core.GriverParam;
import com.zoloz.builder.service.WebServiceProxy;
import id.dana.danah5.DanaH5Key;

/* loaded from: classes3.dex */
public class WebViewUtils {
    public static boolean useSW(Bundle bundle) {
        return BundleUtils.getBoolean(bundle, RVParams.isTinyApp, false) || "yes".equalsIgnoreCase(BundleUtils.getString(bundle, GriverParam.USE_SW));
    }

    public static void setWindowSoftInputMode(Activity activity, Bundle bundle, boolean z) {
        String string = BundleUtils.getString(bundle, DanaH5Key.Param.ADJUSTRESIZE);
        if ("yes".equalsIgnoreCase(GriverConfig.getConfigWithProcessCache(WebServiceProxy.ADJUST_RESIZE, "")) || !"yes".equalsIgnoreCase(string)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("useResize ");
        sb.append(string);
        GriverLogger.d("WebViewUtils", sb.toString());
        GriverLogger.d("WebViewUtils", " AndroidBug5497Workaround ");
        AndroidBug5497Workaround.assistActivity(activity, z);
    }
}
