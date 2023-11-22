package com.iap.ac.android.acs.plugin.interceptor;

import android.os.SystemClock;
import android.text.TextUtils;
import com.iap.ac.android.acs.plugin.a.a;
import com.iap.ac.android.acs.plugin.biz.auth.AuthResultObserver;
import com.iap.ac.android.acs.plugin.biz.auth.AuthResultObserverManager;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.rpc.paysigncenter.PaySignCenterFacade;
import com.iap.ac.android.acs.plugin.rpc.paysigncenter.request.AuthApplyRequest;
import com.iap.ac.android.acs.plugin.rpc.paysigncenter.request.AuthPrepareRequest;
import com.iap.ac.android.acs.plugin.rpc.paysigncenter.result.AuthPrepareResult;
import com.iap.ac.android.acs.plugin.utils.AclAPIContextUtils;
import com.iap.ac.android.acs.plugin.utils.MonitorUtil;
import com.iap.ac.android.biz.common.callback.IAuthCallback;
import com.iap.ac.android.biz.common.model.AuthResult;
import com.iap.ac.android.biz.common.model.acl.AclAPIContext;
import com.iap.ac.android.biz.common.spi.SPIManager;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.RPCProxyHost;
import com.iap.ac.android.common.task.async.IAPAsyncTask;
import com.iap.ac.android.rpccommon.model.domain.result.BaseRpcResult;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class Interceptor4paySignCenter extends BaseInterceptor {
    public static final String PARAM_PARAM = "param";
    public static final String PARAM_SIGN_PARAMS = "sign_params";
    public static final String RESULT_STATUS_FAIL = "7002";
    public static final String RESULT_STATUS_SUCCESS = "7000";
    public static final String TAG = "IAPConnectPlugin";
    public AuthResultObserver authCodeObserver;

    /* JADX INFO: Access modifiers changed from: private */
    public void authApply(AuthResult authResult, final IAPConnectPluginCallback iAPConnectPluginCallback) {
        if (authResult == null) {
            ACLog.e("IAPConnectPlugin", "Interceptor4paySignCenter#authApply, authResult is null");
            iAPConnectPluginCallback.onResult(convertResult(null, false));
        } else if (TextUtils.isEmpty(authResult.authCode)) {
            ACLog.e("IAPConnectPlugin", "Interceptor4paySignCenter#authApply, authCode is empty");
            iAPConnectPluginCallback.onResult(convertResult(null, false));
        } else {
            final String str = authResult.authCode;
            final String str2 = authResult.authState;
            StringBuilder sb = new StringBuilder();
            sb.append("Interceptor4paySignCenter#authApply, authCode: ");
            sb.append(str);
            sb.append(", authState: ");
            sb.append(str2);
            ACLog.d("IAPConnectPlugin", sb.toString());
            IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.acs.plugin.interceptor.Interceptor4paySignCenter.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Interceptor4paySignCenter.this.convertAuthResult(Interceptor4paySignCenter.this.sendAuthApplyRpc(str, str2), iAPConnectPluginCallback);
                    } catch (Throwable th) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Interceptor4paySignCenter#authApply, rpc error: ");
                        sb2.append(th);
                        ACLog.e("IAPConnectPlugin", sb2.toString());
                        iAPConnectPluginCallback.onResult(Interceptor4paySignCenter.this.convertResult(null, false));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void convertAuthResult(BaseRpcResult baseRpcResult, IAPConnectPluginCallback iAPConnectPluginCallback) {
        if (baseRpcResult == null) {
            ACLog.e("IAPConnectPlugin", "Interceptor4paySignCenter#convertAuthResult, result is null");
            iAPConnectPluginCallback.onResult(convertResult(null, false));
            return;
        }
        StringBuilder a2 = a.a("Interceptor4paySignCenter#convertAuthResult, success: ");
        a2.append(baseRpcResult.success);
        ACLog.d("IAPConnectPlugin", a2.toString());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("success", baseRpcResult.success);
        } catch (JSONException e) {
            ACLog.e("IAPConnectPlugin", "Interceptor4paySignCenter#convertAuthResult, JSONException");
            MonitorUtil.monitorJSONError("paySignCenter", e);
        }
        iAPConnectPluginCallback.onResult(convertResult(jSONObject, true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject convertResult(JSONObject jSONObject, boolean z) {
        String str;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("resultStatus", z ? RESULT_STATUS_SUCCESS : "7002");
            if (jSONObject != null) {
                jSONObject2.put("result", jSONObject);
                str = jSONObject.toString();
            } else {
                str = "";
            }
            if (!z) {
                MonitorUtil.monitorError("paySignCenter", "7002", str);
            }
        } catch (JSONException e) {
            ACLog.e("IAPConnectPlugin", "Interceptor4paySignCenter#getResult, JSONException");
            MonitorUtil.monitorJSONError("paySignCenter", e);
        }
        return jSONObject2;
    }

    private String getSignStr(JSONObject jSONObject, IAPConnectPluginCallback iAPConnectPluginCallback) {
        if (jSONObject == null) {
            a.a("IAPConnectPlugin", "Interceptor4paySignCenter#getSignStr, jsParameters is null", "paySignCenter", "parameter is null", iAPConnectPluginCallback);
            return "";
        }
        String optString = jSONObject.optString("param");
        if (TextUtils.isEmpty(optString)) {
            a.a("IAPConnectPlugin", "Interceptor4paySignCenter#getSignStr, param in jsParameters is empty", "paySignCenter", "param in parameter is empty", iAPConnectPluginCallback);
            return "";
        }
        try {
            String optString2 = new JSONObject(optString).optString(PARAM_SIGN_PARAMS);
            if (TextUtils.isEmpty(optString2)) {
                a.a("IAPConnectPlugin", "Interceptor4paySignCenter#getSignStr, sign_params is empty", "paySignCenter", "sign_params is empty", iAPConnectPluginCallback);
                return "";
            }
            return optString2;
        } catch (JSONException unused) {
            a.a("IAPConnectPlugin", "Interceptor4paySignCenter#getSignStr, param in jsParameters is not json", "paySignCenter", "param in parameter is not json", iAPConnectPluginCallback);
            return "";
        }
    }

    private boolean isAuthPrepareResultInvalid(AuthPrepareResult authPrepareResult, IAPConnectPluginCallback iAPConnectPluginCallback) {
        if (authPrepareResult == null) {
            ACLog.e("IAPConnectPlugin", "Interceptor4paySignCenter#isAuthPrepareResultInvalid, result is null");
            iAPConnectPluginCallback.onResult(convertResult(null, false));
            return true;
        } else if (!authPrepareResult.success) {
            ACLog.e("IAPConnectPlugin", "Interceptor4paySignCenter#isAuthPrepareResultInvalid, result is not success");
            iAPConnectPluginCallback.onResult(convertResult(null, false));
            return true;
        } else if (TextUtils.isEmpty(authPrepareResult.authUrl)) {
            ACLog.e("IAPConnectPlugin", "Interceptor4paySignCenter#isAuthPrepareResultInvalid, authUrl is empty");
            iAPConnectPluginCallback.onResult(convertResult(null, false));
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void paySignCenter(String str, String str2, AclAPIContext aclAPIContext, final IAPConnectPluginCallback iAPConnectPluginCallback) {
        StringBuilder sb = new StringBuilder();
        sb.append("Interceptor4paySignCenter#paySignCenter, appId: ");
        sb.append(str);
        sb.append(", signStr: ");
        sb.append(str2);
        ACLog.d("IAPConnectPlugin", sb.toString());
        try {
            AuthPrepareResult sendAuthPrepareRPC = sendAuthPrepareRPC(str, str2);
            if (isAuthPrepareResultInvalid(sendAuthPrepareRPC, iAPConnectPluginCallback)) {
                return;
            }
            StringBuilder a2 = a.a("Interceptor4paySignCenter#paySignCenter, authUrl: ");
            a2.append(sendAuthPrepareRPC.authUrl);
            ACLog.d("IAPConnectPlugin", a2.toString());
            SPIManager.getInstance().getAuthCode(sendAuthPrepareRPC.authUrl, aclAPIContext, new IAuthCallback() { // from class: com.iap.ac.android.acs.plugin.interceptor.Interceptor4paySignCenter.3
                @Override // com.iap.ac.android.biz.common.callback.IAuthCallback
                public void onResult(AuthResult authResult) {
                    ACLog.d("IAPConnectPlugin", "Interceptor4paySignCenter#paySignCenter, get auth result from callback");
                    Interceptor4paySignCenter.this.authApply(authResult, iAPConnectPluginCallback);
                    AuthResultObserverManager.unregisterObserver(2, Interceptor4paySignCenter.this.authCodeObserver);
                }
            });
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Interceptor4paySignCenter#paySignCenter, rpc error: ");
            sb2.append(th);
            ACLog.e("IAPConnectPlugin", sb2.toString());
            iAPConnectPluginCallback.onResult(convertResult(null, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BaseRpcResult sendAuthApplyRpc(String str, String str2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        PaySignCenterFacade paySignCenterFacade = (PaySignCenterFacade) RPCProxyHost.getInterfaceProxy(PaySignCenterFacade.class, "ac_biz");
        AuthApplyRequest authApplyRequest = new AuthApplyRequest();
        authApplyRequest.authCode = str;
        authApplyRequest.state = str2;
        BaseRpcResult authApply = paySignCenterFacade.authApply(authApplyRequest);
        MonitorUtil.monitorRPC("ac.mobilepayment.agreement.oauth.apply", SystemClock.elapsedRealtime() - elapsedRealtime, authApply);
        return authApply;
    }

    private AuthPrepareResult sendAuthPrepareRPC(String str, String str2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        PaySignCenterFacade paySignCenterFacade = (PaySignCenterFacade) RPCProxyHost.getInterfaceProxy(PaySignCenterFacade.class, "ac_biz");
        AuthPrepareRequest authPrepareRequest = new AuthPrepareRequest();
        authPrepareRequest.appId = str;
        authPrepareRequest.signStr = str2;
        AuthPrepareResult authPrepare = paySignCenterFacade.authPrepare(authPrepareRequest);
        MonitorUtil.monitorRPC("ac.mobilepayment.agreement.oauth.prepare", SystemClock.elapsedRealtime() - elapsedRealtime, authPrepare);
        return authPrepare;
    }

    @Override // com.iap.ac.android.acs.plugin.interceptor.BaseInterceptor
    public void handle(IAPConnectPluginContext iAPConnectPluginContext, final IAPConnectPluginCallback iAPConnectPluginCallback) {
        final String signStr = getSignStr(iAPConnectPluginContext.jsParameters, iAPConnectPluginCallback);
        if (TextUtils.isEmpty(signStr)) {
            ACLog.e("IAPConnectPlugin", "Interceptor4paySignCenter#handle, signStr is empty");
            return;
        }
        AuthResultObserver authResultObserver = new AuthResultObserver() { // from class: com.iap.ac.android.acs.plugin.interceptor.Interceptor4paySignCenter.1
            @Override // com.iap.ac.android.acs.plugin.biz.auth.AuthResultObserver
            public void onGetAuthResult(AuthResult authResult) {
                ACLog.d("IAPConnectPlugin", "Interceptor4paySignCenter#observer, get auth result from ac sdk");
                Interceptor4paySignCenter.this.authApply(authResult, iAPConnectPluginCallback);
                AuthResultObserverManager.unregisterObserver(2, Interceptor4paySignCenter.this.authCodeObserver);
            }
        };
        this.authCodeObserver = authResultObserver;
        AuthResultObserverManager.registerObserver(2, authResultObserver);
        ACLog.d("IAPConnectPlugin", "Interceptor4paySignCenter#handle, start to pay sign center");
        final String str = iAPConnectPluginContext.miniProgramAppID;
        final AclAPIContext createAclAPIContext = AclAPIContextUtils.createAclAPIContext(iAPConnectPluginContext);
        IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.acs.plugin.interceptor.Interceptor4paySignCenter.2
            @Override // java.lang.Runnable
            public void run() {
                Interceptor4paySignCenter.this.paySignCenter(str, signStr, createAclAPIContext, iAPConnectPluginCallback);
            }
        });
    }
}
