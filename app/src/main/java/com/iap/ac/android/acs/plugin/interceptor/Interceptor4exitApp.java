package com.iap.ac.android.acs.plugin.interceptor;

import android.text.TextUtils;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.utils.CallbackUtil;
import com.iap.ac.android.acs.plugin.utils.Constants;
import com.iap.ac.android.common.container.WebContainer;
import com.iap.ac.android.common.container.model.CloseAppParams;
import com.iap.ac.android.common.log.ACLog;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Interceptor4exitApp extends BaseInterceptor {
    public static final boolean DEFAULT_ANIMATED = true;
    public static final String DEFAULT_CLOSE_ACTION_TYPE = "exitSelf";
    public static final String ERROR_CODE_MISSING_APP_ID = "40001";
    public static final String ERROR_MESSAGE_MISSING_APP_ID = "missing app id";
    public static final String PARAM_ANIMATED = "animated";
    public static final String PARAM_CLOSE_ACTION_TYPE = "closeActionType";
    public static final String TAG = "IAPConnectPlugin";

    @Override // com.iap.ac.android.acs.plugin.interceptor.BaseInterceptor
    public void handle(IAPConnectPluginContext iAPConnectPluginContext, IAPConnectPluginCallback iAPConnectPluginCallback) {
        String str = iAPConnectPluginContext.miniProgramAppID;
        if (TextUtils.isEmpty(str)) {
            ACLog.e("IAPConnectPlugin", "Interceptor4exitApp#handle mini program app id is empty");
            iAPConnectPluginCallback.onResult(CallbackUtil.getError(Constants.JS_API_EXIT_APP, ERROR_CODE_MISSING_APP_ID, ERROR_MESSAGE_MISSING_APP_ID));
            return;
        }
        JSONObject jSONObject = iAPConnectPluginContext.jsParameters;
        String str2 = DEFAULT_CLOSE_ACTION_TYPE;
        boolean z = true;
        if (jSONObject != null) {
            str2 = jSONObject.optString(PARAM_CLOSE_ACTION_TYPE, DEFAULT_CLOSE_ACTION_TYPE);
            z = jSONObject.optBoolean(PARAM_ANIMATED, true);
        }
        CloseAppParams closeAppParams = new CloseAppParams();
        closeAppParams.appId = str;
        closeAppParams.closeActionType = str2;
        closeAppParams.animated = z;
        StringBuilder sb = new StringBuilder();
        sb.append("Interceptor4exitApp#handle, ");
        sb.append(closeAppParams.toString());
        ACLog.d("IAPConnectPlugin", sb.toString());
        WebContainer.getInstance("ac_biz").closeApp(closeAppParams);
        iAPConnectPluginCallback.onResult(CallbackUtil.getSuccess(Constants.JS_API_EXIT_APP));
    }
}
