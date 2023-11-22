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
public class Interceptor4fetchRecentlyUsedApps extends BaseInterceptor {
    public static final String KEY_QUERY_SIZE = "querySize";
    public static final String KEY_QUERY_TIMESTAMP_CURSOR = "queryTimestampCursor";
    public static final int LIMIT_RECENT_USED = 20;
    public static final String TAG = "IAPConnectPlugin";

    @Override // com.iap.ac.android.acs.operation.interceptor.BaseInterceptor
    public void handle(IAPConnectPluginContext iAPConnectPluginContext, final IAPConnectPluginCallback iAPConnectPluginCallback) {
        if (!NetworkUtils.isNetworkAvailable(iAPConnectPluginContext.getContext().getApplicationContext())) {
            ACLog.e("IAPConnectPlugin", "Interceptor4fetchRecentlyUsedApps network error");
            ErrorCodeConvertUtil.callback2Failure(100, "Network error", iAPConnectPluginCallback);
            return;
        }
        JSONObject jSONObject = iAPConnectPluginContext.jsParameters;
        if (jSONObject == null) {
            ACLog.e("IAPConnectPlugin", "Interceptor4fetchRecentlyUsedApps#handle, jsParameters is null");
            ErrorCodeConvertUtil.callback2Failure(10102, "Parameters is invalid", iAPConnectPluginCallback);
            return;
        }
        final long optLong = jSONObject.optLong(KEY_QUERY_TIMESTAMP_CURSOR);
        Object opt = jSONObject.opt("querySize");
        if (optLong >= 0 && !ParameterCheckUtil.intInvalid(opt, false)) {
            final int convert2IntValue = ParameterCheckUtil.convert2IntValue(opt, 20);
            IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.acs.operation.interceptor.Interceptor4fetchRecentlyUsedApps.1
                @Override // java.lang.Runnable
                public void run() {
                    new RegionOperationProvider().fetchRecentlyUsedApps(optLong, convert2IntValue, new Callback<Bundle>() { // from class: com.iap.ac.android.acs.operation.interceptor.Interceptor4fetchRecentlyUsedApps.1.1
                        @Override // com.iap.ac.android.common.container.callback.Callback
                        public void onResultFailed(int i, String str) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Interceptor4fetchRecentlyUsedApps onResultFailed: error = ");
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
                            sb.append("Interceptor4fetchRecentlyUsedApps onResultSuccess: ");
                            sb.append(string);
                            ACLog.e("IAPConnectPlugin", sb.toString());
                            iAPConnectPluginCallback.onResult((JSONObject) JsonUtils.fromJson(string, JSONObject.class));
                        }
                    });
                }
            });
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Interceptor4fetchRecentlyUsedApps#handle,  queryTimestampCursor:");
        sb.append(optLong);
        sb.append(" querySize:");
        sb.append(opt);
        ACLog.e("IAPConnectPlugin", sb.toString());
        ErrorCodeConvertUtil.callback2Failure(2, "Parameters is invalid", iAPConnectPluginCallback);
    }
}
