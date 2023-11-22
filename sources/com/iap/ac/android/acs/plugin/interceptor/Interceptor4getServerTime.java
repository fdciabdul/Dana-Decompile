package com.iap.ac.android.acs.plugin.interceptor;

import com.iap.ac.android.acs.plugin.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.utils.Constants;
import com.iap.ac.android.acs.plugin.utils.MonitorUtil;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.timesync.TimeSyncManager;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class Interceptor4getServerTime extends BaseInterceptor {
    public static final String TAG = "IAPConnectPlugin";

    @Override // com.iap.ac.android.acs.plugin.interceptor.BaseInterceptor
    public void handle(IAPConnectPluginContext iAPConnectPluginContext, IAPConnectPluginCallback iAPConnectPluginCallback) {
        ACLog.d("IAPConnectPlugin", "Interceptor4getServerTime#handle, start to get server time");
        long serverTime = TimeSyncManager.getInstance(iAPConnectPluginContext.getContext(), "ac_biz").getServerTime();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("time", serverTime);
            iAPConnectPluginCallback.onResult(jSONObject);
        } catch (JSONException e) {
            ACLog.e("IAPConnectPlugin", "Interceptor4getServerTime#handle, convert result to JSON error");
            MonitorUtil.monitorJSONError(Constants.JS_API_GET_SERVER_TIME, e);
        }
    }
}
