package com.iap.ac.android.acs.plugin.interceptor;

import android.text.TextUtils;
import com.iap.ac.android.acs.plugin.a.a;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.downgrade.utils.DisableJSAPIManager;
import com.iap.ac.android.acs.plugin.utils.CallbackUtil;
import com.iap.ac.android.acs.plugin.utils.MonitorUtil;
import com.iap.ac.android.common.log.ACLog;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class Interceptor4apDisableJSAPI extends BaseInterceptor {
    public static final String PARAMS_API_ARRAY = "apiArray";
    public static final String TAG = "IAPConnectPlugin";

    @Override // com.iap.ac.android.acs.plugin.interceptor.BaseInterceptor
    public void handle(IAPConnectPluginContext iAPConnectPluginContext, IAPConnectPluginCallback iAPConnectPluginCallback) {
        JSONObject jSONObject = iAPConnectPluginContext.jsParameters;
        if (jSONObject == null) {
            a.a("IAPConnectPlugin", "Interceptor4apDisableJSAPI#handle, jsParameters is null", "apDisableJSAPI", "parameter is null", iAPConnectPluginCallback);
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(PARAMS_API_ARRAY);
        if (optJSONArray == null) {
            a.a("IAPConnectPlugin", "Interceptor4apDisableJSAPI#handle, jsParameters is null", "apDisableJSAPI", "parameter is null", iAPConnectPluginCallback);
            return;
        }
        String str = iAPConnectPluginContext.miniProgramAppID;
        if (TextUtils.isEmpty(str)) {
            a.a("IAPConnectPlugin", "Interceptor4apDisableJSAPI#handle, jsParameters is null", "apDisableJSAPI", "appId is null", iAPConnectPluginCallback);
            return;
        }
        HashSet hashSet = new HashSet();
        for (int i = 0; i < optJSONArray.length(); i++) {
            try {
                Object obj = optJSONArray.get(i);
                if (obj instanceof String) {
                    hashSet.add((String) obj);
                }
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("Interceptor4apDisableJSAPI#handle, jsParameters is error");
                sb.append(th);
                ACLog.e("IAPConnectPlugin", sb.toString());
                iAPConnectPluginCallback.onResult(CallbackUtil.getInvalidParamError("apDisableJSAPI", "parameter is error"));
                return;
            }
        }
        if (hashSet.contains("apDisableJSAPI")) {
            ACLog.e("IAPConnectPlugin", "Interceptor4apDisableJSAPI#handle, jsParameters is null");
            iAPConnectPluginCallback.onResult(CallbackUtil.getInvalidParamError("apDisableJSAPI", "parameter is error"));
            return;
        }
        DisableJSAPIManager.getInstance().putDisableJSAPI(str, hashSet);
        MonitorUtil.monitorDisabledJSAPI(str, hashSet);
        iAPConnectPluginCallback.onResult(CallbackUtil.getSuccess("apDisableJSAPI"));
    }
}
