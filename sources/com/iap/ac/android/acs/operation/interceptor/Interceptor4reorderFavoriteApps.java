package com.iap.ac.android.acs.operation.interceptor;

import android.os.Bundle;
import com.iap.ac.android.acs.operation.biz.region.operation.RegionOperationProvider;
import com.iap.ac.android.acs.operation.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.operation.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.operation.utils.ErrorCodeConvertUtil;
import com.iap.ac.android.acs.operation.utils.Utils;
import com.iap.ac.android.common.container.callback.Callback;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.task.async.IAPAsyncTask;
import com.iap.ac.android.common.utils.NetworkUtils;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Interceptor4reorderFavoriteApps extends BaseInterceptor {
    public static final String KEY_APP_IDS = "appIds";
    public static final String TAG = "IAPConnectPlugin";

    @Override // com.iap.ac.android.acs.operation.interceptor.BaseInterceptor
    public void handle(IAPConnectPluginContext iAPConnectPluginContext, final IAPConnectPluginCallback iAPConnectPluginCallback) {
        if (!NetworkUtils.isNetworkAvailable(iAPConnectPluginContext.getContext().getApplicationContext())) {
            ACLog.e("IAPConnectPlugin", "Interceptor4reorderFavoriteApps network error");
            ErrorCodeConvertUtil.callback2Failure(100, "Network error", iAPConnectPluginCallback);
            return;
        }
        JSONObject jSONObject = iAPConnectPluginContext.jsParameters;
        if (jSONObject == null) {
            ACLog.e("IAPConnectPlugin", "Interceptor4reorderFavoriteApps#handle, jsParameters is null");
            ErrorCodeConvertUtil.callback2Failure(10102, "Parameters is invalid", iAPConnectPluginCallback);
            return;
        }
        final List<String> jsonArray2StringList = Utils.jsonArray2StringList(jSONObject.optJSONArray(KEY_APP_IDS));
        if (jsonArray2StringList.isEmpty()) {
            ACLog.e("IAPConnectPlugin", "Interceptor4reorderFavoriteApps appIds parameter is invalid");
            ErrorCodeConvertUtil.callback2Failure(2, "Parameters is invalid", iAPConnectPluginCallback);
            return;
        }
        IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.acs.operation.interceptor.Interceptor4reorderFavoriteApps.1
            @Override // java.lang.Runnable
            public void run() {
                new RegionOperationProvider().reorderFavoriteApps(jsonArray2StringList, new Callback<Bundle>() { // from class: com.iap.ac.android.acs.operation.interceptor.Interceptor4reorderFavoriteApps.1.1
                    @Override // com.iap.ac.android.common.container.callback.Callback
                    public void onResultFailed(int i, String str) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Interceptor4reorderFavoriteApps onResultFailed: error = ");
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
                        sb.append("Interceptor4reorderFavoriteApps onResultSuccess: ");
                        sb.append(string);
                        ACLog.e("IAPConnectPlugin", sb.toString());
                        iAPConnectPluginCallback.onResult((JSONObject) JsonUtils.fromJson(string, JSONObject.class));
                    }
                });
            }
        });
    }
}
