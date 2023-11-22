package com.iap.ac.android.acs.operation.interceptor;

import android.os.Bundle;
import com.iap.ac.android.acs.operation.biz.region.operation.RegionOperationProvider;
import com.iap.ac.android.acs.operation.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.operation.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.operation.utils.ErrorCodeConvertUtil;
import com.iap.ac.android.acs.operation.utils.ParameterCheckUtil;
import com.iap.ac.android.common.container.callback.Callback;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.task.async.IAPAsyncTask;
import com.iap.ac.android.common.utils.NetworkUtils;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Interceptor4unfavoriteApp extends BaseInterceptor {
    public static final String KEY_APP_ID = "appId";
    public static final String TAG = "IAPConnectPlugin";

    @Override // com.iap.ac.android.acs.operation.interceptor.BaseInterceptor
    public void handle(IAPConnectPluginContext iAPConnectPluginContext, final IAPConnectPluginCallback iAPConnectPluginCallback) {
        JSONObject jSONObject = iAPConnectPluginContext.jsParameters;
        if (jSONObject == null) {
            ACLog.e("IAPConnectPlugin", "Interceptor4unfavoriteApp#handle, jsParameters is null");
            ErrorCodeConvertUtil.callback2Failure(10102, "Parameters is invalid", iAPConnectPluginCallback);
            return;
        }
        final String optString = jSONObject.optString("appId");
        if (!NetworkUtils.isNetworkAvailable(iAPConnectPluginContext.getContext().getApplicationContext())) {
            ACLog.e("IAPConnectPlugin", "Interceptor4unfavoriteApp network error");
            ErrorCodeConvertUtil.callback2Failure(100, "Network error", iAPConnectPluginCallback);
        } else if (ParameterCheckUtil.stringInvalid(optString)) {
            ACLog.e("IAPConnectPlugin", "Interceptor4unfavoriteApp appId is null");
            ErrorCodeConvertUtil.callback2Failure(2, "Parameters is invalid", iAPConnectPluginCallback);
        } else {
            IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.acs.operation.interceptor.Interceptor4unfavoriteApp.1
                @Override // java.lang.Runnable
                public void run() {
                    new RegionOperationProvider().unfavoriteApp(optString, new Callback<Bundle>() { // from class: com.iap.ac.android.acs.operation.interceptor.Interceptor4unfavoriteApp.1.1
                        @Override // com.iap.ac.android.common.container.callback.Callback
                        public void onResultFailed(int i, String str) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Interceptor4unfavoriteApp onResultFailed: error = ");
                            sb.append(i);
                            sb.append(", errorMessage = ");
                            sb.append(str);
                            ACLog.e("IAPConnectPlugin", sb.toString());
                            ErrorCodeConvertUtil.callback2Failure(i, str, iAPConnectPluginCallback);
                        }

                        @Override // com.iap.ac.android.common.container.callback.Callback
                        public void onResultSuccess(Bundle bundle) {
                            String string = bundle.getString("result");
                            StringBuilder sb = new StringBuilder();
                            sb.append("Interceptor4unfavoriteApp onResultSuccess: ");
                            sb.append(string);
                            ACLog.e("IAPConnectPlugin", sb.toString());
                            iAPConnectPluginCallback.onResult((JSONObject) JsonUtils.fromJson(string, JSONObject.class));
                        }
                    });
                }
            });
        }
    }
}
