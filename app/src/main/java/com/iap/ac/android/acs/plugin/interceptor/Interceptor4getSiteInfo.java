package com.iap.ac.android.acs.plugin.interceptor;

import com.iap.ac.android.acs.plugin.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.utils.Constants;
import com.iap.ac.android.acs.plugin.utils.MonitorUtil;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.model.CommonConfig;
import com.iap.ac.android.common.log.ACLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class Interceptor4getSiteInfo extends BaseInterceptor {
    public static final String TAG = "IAPConnectPlugin";

    @Override // com.iap.ac.android.acs.plugin.interceptor.BaseInterceptor
    public void handle(IAPConnectPluginContext iAPConnectPluginContext, IAPConnectPluginCallback iAPConnectPluginCallback) {
        ACLog.d("IAPConnectPlugin", "Interceptor4getSiteInfo#handle, start to get site info");
        CommonConfig commonConfig = ACManager.getInstance().getCommonConfig();
        String str = commonConfig != null ? commonConfig.siteName : "";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("siteName", str);
            iAPConnectPluginCallback.onResult(jSONObject);
        } catch (JSONException e) {
            ACLog.e("IAPConnectPlugin", "Interceptor4getSiteInfo#handle, convert result to JSON error");
            MonitorUtil.monitorJSONError(Constants.JS_API_GET_SITE_INFO, e);
        }
    }
}
