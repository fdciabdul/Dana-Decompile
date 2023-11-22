package com.iap.ac.android.acs.operation.interceptor;

import android.os.Bundle;
import com.iap.ac.android.acs.operation.biz.region.operation.RegionOperationProvider;
import com.iap.ac.android.acs.operation.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.operation.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.operation.utils.CallbackUtil;
import com.iap.ac.android.acs.operation.utils.Constants;
import com.iap.ac.android.acs.operation.utils.ErrorCodeConvertUtil;
import com.iap.ac.android.acs.operation.utils.ParameterCheckUtil;
import com.iap.ac.android.common.container.callback.Callback;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.task.async.IAPAsyncTask;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Interceptor4regionSearchAppByKeyWords extends BaseInterceptor {
    public static final String KEY_KEYWORDS = "keywords";
    public static final String KEY_QUERYSIZE = "querySize";
    public static final String KEY_QUERYSTARTINDEX = "queryStartIndex";
    public static final String TAG = "IAPConnectPlugin";

    @Override // com.iap.ac.android.acs.operation.interceptor.BaseInterceptor
    public void handle(IAPConnectPluginContext iAPConnectPluginContext, final IAPConnectPluginCallback iAPConnectPluginCallback) {
        JSONObject jSONObject = iAPConnectPluginContext.jsParameters;
        if (jSONObject == null) {
            ACLog.e("IAPConnectPlugin", "Interceptor4regionSearchAppByKeyWords#handle, jsParameters is null");
            iAPConnectPluginCallback.onResult(CallbackUtil.getInvalidParamError(Constants.JS_API_REGION_SEARCH_APPS_BY_KEYWORDS, "jsParameters is null"));
            return;
        }
        final String optString = jSONObject.optString("keywords");
        String optString2 = jSONObject.optString("queryStartIndex");
        String optString3 = jSONObject.optString("querySize");
        if (!ParameterCheckUtil.intInvalid(optString2, true) && !ParameterCheckUtil.intInvalid(optString3, false) && !ParameterCheckUtil.stringInvalid(optString)) {
            final int convert2IntValue = ParameterCheckUtil.convert2IntValue(optString2);
            final int convert2IntValue2 = ParameterCheckUtil.convert2IntValue(optString3);
            IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.acs.operation.interceptor.Interceptor4regionSearchAppByKeyWords.1
                @Override // java.lang.Runnable
                public void run() {
                    new RegionOperationProvider().regionSearchAppsByKeywords((String) optString, convert2IntValue, convert2IntValue2, new Callback<Bundle>() { // from class: com.iap.ac.android.acs.operation.interceptor.Interceptor4regionSearchAppByKeyWords.1.1
                        @Override // com.iap.ac.android.common.container.callback.Callback
                        public void onResultFailed(int i, String str) {
                            ErrorCodeConvertUtil.callback2Failure(i, str, iAPConnectPluginCallback);
                        }

                        @Override // com.iap.ac.android.common.container.callback.Callback
                        public void onResultSuccess(Bundle bundle) {
                            String string = bundle.getString("result");
                            ACLog.e("IAPConnectPlugin", string);
                            iAPConnectPluginCallback.onResult((JSONObject) JsonUtils.fromJson(string, JSONObject.class));
                        }
                    });
                }
            });
            return;
        }
        ErrorCodeConvertUtil.callback2Failure(10102, "Parameters is invalid", iAPConnectPluginCallback);
    }
}
