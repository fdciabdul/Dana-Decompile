package com.iap.ac.android.biz.common.internal.rpc;

import android.text.TextUtils;
import com.alibaba.griver.base.common.constants.SecurityConstants;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.RpcAppInfo;
import com.iap.ac.android.common.rpc.interfaces.SignRpcRequestPlugin;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class SignRpcRequestPluginImpl implements SignRpcRequestPlugin {
    public SignConfig mSignConfig;

    private String getAppKey(RpcAppInfo rpcAppInfo) {
        SignConfig signConfig = this.mSignConfig;
        if (signConfig != null && !TextUtils.isEmpty(signConfig.appKey)) {
            return this.mSignConfig.appKey;
        }
        return rpcAppInfo.appKey;
    }

    private String getAuthCode(RpcAppInfo rpcAppInfo) {
        String str;
        SignConfig signConfig = this.mSignConfig;
        return (signConfig == null || (str = signConfig.authCode) == null) ? rpcAppInfo.authCode : str;
    }

    public SignConfig getSignConfig() {
        return this.mSignConfig;
    }

    public void setSignConfig(SignConfig signConfig) {
        this.mSignConfig = signConfig;
    }

    @Override // com.iap.ac.android.common.rpc.interfaces.SignRpcRequestPlugin
    public String signRequest(RpcAppInfo rpcAppInfo, String str, Map<String, String> map) {
        if (!Utils.checkClassExist(SecurityConstants.SG_CLASS)) {
            ACLog.w(Constants.TAG, "check security guard not exist");
            return null;
        } else if (TextUtils.isEmpty(str)) {
            ACLog.w(Constants.TAG, "the content is empty, will not do signing.");
            ACLogEvent.crucialEvent("iapconnect_center", LogConstants.EVENT_ID_SIGN_FAIL, "the content is empty, will not do signing.");
            return null;
        } else {
            String appKey = getAppKey(rpcAppInfo);
            SignConfig signConfig = this.mSignConfig;
            int i = signConfig == null ? 4 : signConfig.signAlgorithm;
            String authCode = getAuthCode(rpcAppInfo);
            HashMap hashMap = new HashMap();
            hashMap.put("INPUT", str);
            SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
            securityGuardParamContext.paramMap = hashMap;
            securityGuardParamContext.requestType = i;
            securityGuardParamContext.appKey = appKey;
            try {
                SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(ACManager.getInstance().getContext());
                if (securityGuardManager == null) {
                    ACLog.e(Constants.TAG, "request data sign fail, sgMng is null");
                    ACLogEvent.crucialEvent("iapconnect_center", LogConstants.EVENT_ID_SIGN_FAIL, "request data sign fail, sgMng is null");
                    return null;
                }
                ISecureSignatureComponent secureSignatureComp = securityGuardManager.getSecureSignatureComp();
                if (secureSignatureComp == null) {
                    ACLog.e(Constants.TAG, "request data sign fail, ssComp is null");
                    ACLogEvent.crucialEvent("iapconnect_center", LogConstants.EVENT_ID_SIGN_FAIL, "request data sign fail, ssComp is null");
                    return null;
                }
                String signRequest = secureSignatureComp.signRequest(securityGuardParamContext, authCode);
                ACLog.i(Constants.TAG, String.format("Sign success: appKey = %s, authCode = %s, requestType = %d, sign = %s, content = %s", appKey, authCode, Integer.valueOf(i), signRequest, str));
                return signRequest;
            } catch (Throwable th) {
                String format = String.format("Cannot sign request! appKey = %s, authCode = %s, requestType = %d, errorMessage = %s", appKey, authCode, Integer.valueOf(i), Utils.formatSecurityGuardException(th));
                ACLog.e(Constants.TAG, format);
                ACLogEvent.crucialEvent("iapconnect_center", LogConstants.EVENT_ID_SIGN_FAIL, format);
                return null;
            }
        }
    }
}
