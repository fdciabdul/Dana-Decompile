package com.iap.ac.android.acs.plugin.a;

import com.iap.ac.android.acs.plugin.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.plugin.utils.CallbackUtil;
import com.iap.ac.android.common.log.ACLog;

/* loaded from: classes8.dex */
public class a {
    public static StringBuilder a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static void a(String str, String str2, String str3, String str4, IAPConnectPluginCallback iAPConnectPluginCallback) {
        ACLog.e(str, str2);
        iAPConnectPluginCallback.onResult(CallbackUtil.getInvalidParamError(str3, str4));
    }
}
