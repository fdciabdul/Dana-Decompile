package com.iap.ac.android.acs.plugin.interceptor;

import android.text.TextUtils;
import com.iap.ac.android.acs.plugin.a.a;
import com.iap.ac.android.acs.plugin.biz.auth.AuthResultObserver;
import com.iap.ac.android.acs.plugin.biz.auth.AuthResultObserverManager;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.utils.AclAPIContextUtils;
import com.iap.ac.android.acs.plugin.utils.CallbackUtil;
import com.iap.ac.android.acs.plugin.utils.Constants;
import com.iap.ac.android.acs.plugin.utils.MonitorUtil;
import com.iap.ac.android.biz.common.callback.IAuthCallback;
import com.iap.ac.android.biz.common.model.AuthResult;
import com.iap.ac.android.biz.common.model.acl.AclAPIContext;
import com.iap.ac.android.biz.common.spi.SPIManager;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.task.async.IAPAsyncTask;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class Interceptor4signContract extends BaseInterceptor {
    public static final String ERROR_CODE = "7002";
    public static final String ERROR_MESSAGE = "Empty authCode";
    public static final String PARAM_SIGN_STR = "signStr";
    public static final String TAG = "IAPConnectPlugin";
    public AuthResultObserver authCodeObserver;

    private void convertAuthResult(AuthResult authResult, IAPConnectPluginCallback iAPConnectPluginCallback) {
        StringBuilder a2 = a.a("Interceptor4signContract#convertAuthResult, authCode: ");
        a2.append(authResult.authCode);
        a2.append(", authState: ");
        a2.append(authResult.authState);
        ACLog.d("IAPConnectPlugin", a2.toString());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("authCode", authResult.authCode);
            jSONObject.put("authState", authResult.authState);
            iAPConnectPluginCallback.onResult(jSONObject);
        } catch (JSONException e) {
            ACLog.e("IAPConnectPlugin", "Interceptor4signContract#convertAuthResult, convert result to JSON error");
            MonitorUtil.monitorJSONError(Constants.JS_API_SIGN_CONTRACT, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void convertResult(AuthResult authResult, IAPConnectPluginCallback iAPConnectPluginCallback) {
        if (authResult == null) {
            ACLog.d("IAPConnectPlugin", "Interceptor4signContract#convertResult, authResult is null");
            iAPConnectPluginCallback.onResult(CallbackUtil.getError(Constants.JS_API_SIGN_CONTRACT, "7002", "Empty authCode"));
        } else if (TextUtils.isEmpty(authResult.authCode)) {
            ACLog.d("IAPConnectPlugin", "Interceptor4signContract#convertResult, authCode is empty");
            iAPConnectPluginCallback.onResult(CallbackUtil.getError(Constants.JS_API_SIGN_CONTRACT, authResult.errorCode, authResult.errorMessage));
        } else {
            convertAuthResult(authResult, iAPConnectPluginCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void signContract(String str, AclAPIContext aclAPIContext, final IAPConnectPluginCallback iAPConnectPluginCallback) {
        StringBuilder sb = new StringBuilder();
        sb.append("Interceptor4signContract#signContract, signStr: ");
        sb.append(str);
        ACLog.d("IAPConnectPlugin", sb.toString());
        SPIManager.getInstance().getAuthCode(str, aclAPIContext, new IAuthCallback() { // from class: com.iap.ac.android.acs.plugin.interceptor.Interceptor4signContract.3
            @Override // com.iap.ac.android.biz.common.callback.IAuthCallback
            public void onResult(AuthResult authResult) {
                ACLog.d("IAPConnectPlugin", "Interceptor4signContract#signContract, get auth result from callback");
                Interceptor4signContract.this.convertResult(authResult, iAPConnectPluginCallback);
                AuthResultObserverManager.unregisterObserver(1, Interceptor4signContract.this.authCodeObserver);
            }
        });
    }

    @Override // com.iap.ac.android.acs.plugin.interceptor.BaseInterceptor
    public void handle(IAPConnectPluginContext iAPConnectPluginContext, final IAPConnectPluginCallback iAPConnectPluginCallback) {
        JSONObject jSONObject = iAPConnectPluginContext.jsParameters;
        if (jSONObject == null) {
            a.a("IAPConnectPlugin", "Interceptor4signContract#handle, jsParameters is null", Constants.JS_API_SIGN_CONTRACT, "parameter is null", iAPConnectPluginCallback);
            return;
        }
        final String optString = jSONObject.optString(PARAM_SIGN_STR);
        if (TextUtils.isEmpty(optString)) {
            a.a("IAPConnectPlugin", "Interceptor4signContract#handle, signStr is empty", Constants.JS_API_SIGN_CONTRACT, "signStr is empty", iAPConnectPluginCallback);
            return;
        }
        AuthResultObserver authResultObserver = new AuthResultObserver() { // from class: com.iap.ac.android.acs.plugin.interceptor.Interceptor4signContract.1
            @Override // com.iap.ac.android.acs.plugin.biz.auth.AuthResultObserver
            public void onGetAuthResult(AuthResult authResult) {
                ACLog.d("IAPConnectPlugin", "Interceptor4signContract#observer, get auth result from ac sdk");
                Interceptor4signContract.this.convertResult(authResult, iAPConnectPluginCallback);
                AuthResultObserverManager.unregisterObserver(1, Interceptor4signContract.this.authCodeObserver);
            }
        };
        this.authCodeObserver = authResultObserver;
        AuthResultObserverManager.registerObserver(1, authResultObserver);
        ACLog.d("IAPConnectPlugin", "Interceptor4signContract#handle, start to sign contract");
        final AclAPIContext createAclAPIContext = AclAPIContextUtils.createAclAPIContext(iAPConnectPluginContext);
        IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.acs.plugin.interceptor.Interceptor4signContract.2
            @Override // java.lang.Runnable
            public void run() {
                Interceptor4signContract.this.signContract(optString, createAclAPIContext, iAPConnectPluginCallback);
            }
        });
    }
}
