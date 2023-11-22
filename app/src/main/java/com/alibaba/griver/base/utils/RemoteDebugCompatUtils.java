package com.alibaba.griver.base.utils;

import android.os.Bundle;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.remotedebug.utils.RemoteDebugUtils;
import com.alibaba.griver.base.common.logger.GriverLogger;

/* loaded from: classes2.dex */
public class RemoteDebugCompatUtils {
    public static boolean isInDebugMode(App app) {
        if (isDebugModeWithAppx1(app)) {
            GriverLogger.d("RemoteDebugCompatUtils", "RemoteDebugCompatUtils#isInDebugMode current is in appx 1.0 debug.");
            return true;
        } else if (isDebugModeWithAppx2(app)) {
            GriverLogger.d("RemoteDebugCompatUtils", "RemoteDebugCompatUtils#isInDebugMode current is in appx 2.0 debug.");
            return true;
        } else {
            return false;
        }
    }

    public static boolean isInDebugMode(String str, Bundle bundle) {
        if (a(str, bundle)) {
            GriverLogger.d("RemoteDebugCompatUtils", "RemoteDebugCompatUtils#isInDebugMode current is in appx 1.0 debug.");
            return true;
        } else if (b(str, bundle)) {
            GriverLogger.d("RemoteDebugCompatUtils", "RemoteDebugCompatUtils#isInDebugMode current is in appx 2.0 debug.");
            return true;
        } else {
            return false;
        }
    }

    private static boolean a(String str, Bundle bundle) {
        return RemoteDebugUtils.isRemoteDebugMode(bundle) && RemoteDebugUtils.supportRemoteDebugMode(str);
    }

    private static boolean b(String str, Bundle bundle) {
        return BundleUtils.getBoolean(bundle, "isRemoteX", false) && RemoteDebugUtils.supportRemoteDebugMode(str);
    }

    public static boolean isDebugModeWithAppx1(App app) {
        return RemoteDebugUtils.isRemoteDebugMode(app.getStartParams()) && RemoteDebugUtils.supportRemoteDebugMode(app.getAppId());
    }

    public static boolean isDebugModeWithAppx2(App app) {
        return BundleUtils.getBoolean(app.getStartParams(), "isRemoteX", false) && RemoteDebugUtils.supportRemoteDebugMode(app.getAppId());
    }
}
