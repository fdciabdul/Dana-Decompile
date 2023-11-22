package com.iap.ac.android.acs.operation.interceptor;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.griver.core.vo.FetchAppRequestVO;
import com.iap.ac.android.acs.operation.biz.region.operation.RegionOperationProvider;
import com.iap.ac.android.acs.operation.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.operation.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.operation.utils.ErrorCodeConvertUtil;
import com.iap.ac.android.acs.operation.utils.ParameterCheckUtil;
import com.iap.ac.android.common.container.callback.Callback;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.task.async.IAPAsyncTask;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Interceptor4regionFetchAllApps extends BaseInterceptor {
    public static final String KEY_ASCENDING = "ascending";
    public static final String KEY_QUERYSIZE = "querySize";
    public static final String KEY_QUERYSTARTINDEX = "queryStartIndex";
    public static final String KEY_SORTDESCRIPTOR = "sortDescriptor";
    public static final String KEY_SOURCE_STAGE_CODE = "sourceStageCode";
    public static final String TAG = "IAPConnectPlugin";
    public String KEY_APP_CATEGORY = "category";
    public String KEY_APP_ID = "APP_ID";
    public String KEY_PUBLISH_TIME = FetchAppRequestVO.PUBLISH_TIME;
    public String KEY_APP_NAME = "APP_NAME";
    public String KEY_APP_DESC = FetchAppRequestVO.APP_DESC;
    public String KEY_APP_CREATE_TIME = FetchAppRequestVO.APP_CREATE_TIME;
    public final String KEY_UNKNOW_PARAMETER = "UNKNOW_PARAMETER";
    public final String KEY_DEFAULT_PARAMETER = "DEFAULT_PARAMETER";
    public String KEY_ASC = "ASC";
    public String KEY_DESC = "DESC";

    private String convertSortKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return "UNKNOW_PARAMETER";
        }
        if (TextUtils.equals("DEFAULT_PARAMETER", str)) {
            return "DEFAULT_PARAMETER";
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1894363394:
                if (str.equals("lastReleaseTime")) {
                    c = 0;
                    break;
                }
                break;
            case 3373707:
                if (str.equals("name")) {
                    c = 1;
                    break;
                }
                break;
            case 93028124:
                if (str.equals("appId")) {
                    c = 2;
                    break;
                }
                break;
            case 1369213417:
                if (str.equals("createTime")) {
                    c = 3;
                    break;
                }
                break;
            case 1539594266:
                if (str.equals("introduction")) {
                    c = 4;
                    break;
                }
                break;
        }
        if (c != 0) {
            if (c != 1) {
                if (c != 2) {
                    if (c != 3) {
                        return c != 4 ? "UNKNOW_PARAMETER" : this.KEY_APP_DESC;
                    }
                    return this.KEY_APP_CREATE_TIME;
                }
                return this.KEY_APP_ID;
            }
            return this.KEY_APP_NAME;
        }
        return this.KEY_PUBLISH_TIME;
    }

    @Override // com.iap.ac.android.acs.operation.interceptor.BaseInterceptor
    public void handle(IAPConnectPluginContext iAPConnectPluginContext, final IAPConnectPluginCallback iAPConnectPluginCallback) {
        JSONObject jSONObject = iAPConnectPluginContext.jsParameters;
        if (jSONObject == null) {
            ACLog.e("IAPConnectPlugin", "Interceptor4regionFetchAllApps#handle, jsParameters is null");
            ErrorCodeConvertUtil.callback2Failure(10102, "Parameters is invalid", iAPConnectPluginCallback);
            return;
        }
        Object opt = jSONObject.opt("queryStartIndex");
        Object opt2 = jSONObject.opt("querySize");
        String optString = jSONObject.optString(KEY_SORTDESCRIPTOR);
        boolean optBoolean = jSONObject.optBoolean(KEY_ASCENDING);
        final String optString2 = jSONObject.optString(this.KEY_APP_CATEGORY);
        final String optString3 = jSONObject.optString(KEY_SOURCE_STAGE_CODE);
        String convertSortKey = convertSortKey(optString);
        final int convert2IntValue = ParameterCheckUtil.convert2IntValue(opt);
        final int convert2IntValue2 = ParameterCheckUtil.convert2IntValue(opt2);
        String str = "DEFAULT_PARAMETER".equals(convertSortKey) ? null : convertSortKey;
        final String str2 = optBoolean ? this.KEY_ASC : this.KEY_DESC;
        if (!ParameterCheckUtil.intInvalid(opt, true) && !ParameterCheckUtil.intInvalid(opt2, false) && !"UNKNOW_PARAMETER".equals(convertSortKey)) {
            final String str3 = str;
            IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.acs.operation.interceptor.Interceptor4regionFetchAllApps.1
                @Override // java.lang.Runnable
                public void run() {
                    new RegionOperationProvider().regionFetchAllApps(optString2, convert2IntValue, convert2IntValue2, str3, str2, optString3, new Callback<Bundle>() { // from class: com.iap.ac.android.acs.operation.interceptor.Interceptor4regionFetchAllApps.1.1
                        @Override // com.iap.ac.android.common.container.callback.Callback
                        public void onResultFailed(int i, String str4) {
                            ErrorCodeConvertUtil.callback2Failure(i, str4, iAPConnectPluginCallback);
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
