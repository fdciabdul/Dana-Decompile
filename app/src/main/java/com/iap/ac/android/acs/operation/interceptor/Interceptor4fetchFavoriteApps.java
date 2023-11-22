package com.iap.ac.android.acs.operation.interceptor;

import android.os.Bundle;
import com.iap.ac.android.acs.operation.biz.region.operation.RegionOperationProvider;
import com.iap.ac.android.acs.operation.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.operation.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.operation.utils.ErrorCodeConvertUtil;
import com.iap.ac.android.common.container.callback.Callback;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.task.async.IAPAsyncTask;
import com.iap.ac.android.common.utils.NetworkUtils;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Interceptor4fetchFavoriteApps extends BaseInterceptor {
    public static final String KEY_APP_ID = "appId";
    public static final String TAG = "IAPConnectPlugin";

    @Override // com.iap.ac.android.acs.operation.interceptor.BaseInterceptor
    public void handle(IAPConnectPluginContext iAPConnectPluginContext, final IAPConnectPluginCallback iAPConnectPluginCallback) {
        if (!NetworkUtils.isNetworkAvailable(iAPConnectPluginContext.getContext().getApplicationContext())) {
            ACLog.e("IAPConnectPlugin", "Interceptor4fetchFavoriteApps network error");
            ErrorCodeConvertUtil.callback2Failure(100, "Network error", iAPConnectPluginCallback);
            return;
        }
        IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.acs.operation.interceptor.Interceptor4fetchFavoriteApps.1
            @Override // java.lang.Runnable
            public void run() {
                new RegionOperationProvider().fetchFavoriteApps(new Callback<Bundle>() { // from class: com.iap.ac.android.acs.operation.interceptor.Interceptor4fetchFavoriteApps.1.1
                    @Override // com.iap.ac.android.common.container.callback.Callback
                    public void onResultFailed(int i, String str) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Interceptor4fetchFavoriteApps onResultFailed: error = ");
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
                        sb.append("Interceptor4fetchFavoriteApps onResultSuccess: ");
                        sb.append(string);
                        ACLog.e("IAPConnectPlugin", sb.toString());
                        iAPConnectPluginCallback.onResult((JSONObject) JsonUtils.fromJson(string, JSONObject.class));
                    }
                });
            }
        });
    }
}
