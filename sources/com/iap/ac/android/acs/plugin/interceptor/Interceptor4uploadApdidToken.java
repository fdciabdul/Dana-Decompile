package com.iap.ac.android.acs.plugin.interceptor;

import com.iap.ac.android.acs.plugin.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.utils.CallbackUtil;
import com.iap.ac.android.acs.plugin.utils.Constants;
import com.iap.ac.android.biz.common.risk.RiskControlManager;
import com.iap.ac.android.common.log.ACLog;

/* loaded from: classes8.dex */
public class Interceptor4uploadApdidToken extends BaseInterceptor {
    @Override // com.iap.ac.android.acs.plugin.interceptor.BaseInterceptor
    public void handle(IAPConnectPluginContext iAPConnectPluginContext, IAPConnectPluginCallback iAPConnectPluginCallback) {
        ACLog.d("IAPConnectPlugin", "Interceptor4uploadApdidToken#handle");
        RiskControlManager.getInstance().reportApdidToken();
        iAPConnectPluginCallback.onResult(CallbackUtil.getSuccess(Constants.JS_API_UPLOAD_APDID_TOKEN));
    }
}
