package com.alibaba.ariver.app.api;

import android.app.Activity;
import com.alibaba.ariver.app.api.permission.IPermissionRequestCallback;
import com.alibaba.ariver.app.api.permission.RVNativePermissionRequestProxy;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.exthub.common.ExtHubLogger;
import com.alibaba.fastjson.JSONObject;
import id.dana.sendmoney.summary.SummaryActivity;

/* loaded from: classes6.dex */
public class PermissionUtil {
    public static final String KEY_FORCE_CHECK_PERMISSION = "forceCheckPermission";

    public static void requestPermissions(Activity activity, String[] strArr, IPermissionRequestCallback iPermissionRequestCallback) {
        RVNativePermissionRequestProxy rVNativePermissionRequestProxy = (RVNativePermissionRequestProxy) RVProxy.get(RVNativePermissionRequestProxy.class);
        int requestCode = rVNativePermissionRequestProxy.getRequestCode();
        rVNativePermissionRequestProxy.addPermRequstCallback(requestCode, iPermissionRequestCallback);
        rVNativePermissionRequestProxy.requestPermissions(activity, strArr, requestCode);
    }

    public static boolean forceDomainCheck(String str) {
        String configWithProcessCache = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_forceDomainCheckList", "");
        if (JSONUtils.parseArray(configWithProcessCache) == null || !JSONUtils.parseArray(configWithProcessCache).contains(str)) {
            return false;
        }
        ExtHubLogger.d("Ariver:PermissionUtil", "isNoPermissionConfigAndAllow return false because of config");
        return true;
    }

    public static boolean forceInnerWebViewCheck() {
        return "yes".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_forceInnerWebviewCheck", "yes"));
    }

    public static boolean forceInnerPermissionCheck(JSONObject jSONObject) {
        return SummaryActivity.CHECKED.equalsIgnoreCase(JSONUtils.getString(jSONObject, KEY_FORCE_CHECK_PERMISSION, "false")) && "yes".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_tinyForcePermission", "no"));
    }
}
