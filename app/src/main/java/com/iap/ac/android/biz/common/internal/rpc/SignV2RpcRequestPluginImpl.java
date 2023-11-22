package com.iap.ac.android.biz.common.internal.rpc;

import android.text.TextUtils;
import com.alibaba.griver.base.common.constants.SecurityConstants;
import com.alipay.plus.security.lite.ISecurityGuardLiteManager;
import com.alipay.plus.security.lite.SecurityGuardLiteManager;
import com.alipay.plus.security.lite.SecurityGuardLiteParamContext;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.biz.common.configcenter.ConfigUtils;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.RpcAppInfo;
import com.iap.ac.android.common.rpc.interfaces.SignV2RpcRequestPlugin;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class SignV2RpcRequestPluginImpl implements SignV2RpcRequestPlugin {
    public boolean mOldSecurityGuardExist = Utils.checkClassExist(SecurityConstants.SG_CLASS);
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

    @Override // com.iap.ac.android.common.rpc.interfaces.SignV2RpcRequestPlugin
    public String signV2Request(RpcAppInfo rpcAppInfo, String str, String str2, Map<String, String> map) {
        if (!this.mOldSecurityGuardExist || ConfigUtils.canUseTopWhiteList((JSONObject) ConfigCenter.INSTANCE.getKeyOrDefault("RPC_signV2_config_ac_region", new JSONObject()), str, false)) {
            if (TextUtils.isEmpty(str2)) {
                ACLog.w(Constants.TAG, "the content is empty, will not do signing.");
                ACLogEvent.crucialEvent("iapconnect_center", LogConstants.EVENT_ID_SIGN_FAIL, "the content is empty, will not do signing.");
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(getAppKey(rpcAppInfo));
            sb.append("_");
            sb.append(ACManager.getInstance().getCommonConfig().envType.toUpperCase());
            String obj = sb.toString();
            HashMap hashMap = new HashMap();
            SignConfig signConfig = this.mSignConfig;
            int i = signConfig == null ? 4 : signConfig.signAlgorithm;
            hashMap.put("INPUT", str2);
            SecurityGuardLiteParamContext securityGuardLiteParamContext = new SecurityGuardLiteParamContext();
            securityGuardLiteParamContext.paramMap = hashMap;
            securityGuardLiteParamContext.requestType = i;
            securityGuardLiteParamContext.appKey = obj;
            try {
                ISecurityGuardLiteManager securityGuardLiteManager = SecurityGuardLiteManager.getInstance(ACManager.getInstance().getContext(), "0a6a");
                if (securityGuardLiteManager == null) {
                    ACLog.e(Constants.TAG, "request data sign fail, sgMng is null");
                    return null;
                }
                return securityGuardLiteManager.signRequest(securityGuardLiteParamContext, "0a6a");
            } catch (Throwable th) {
                ACLog.e(Constants.TAG, String.format("Cannot sign request! appKey = %s, authCode = %s, requestType = %d, errorMessage = %s", obj, "0a6a", 4, Utils.formatSecurityGuardException(th)));
                return null;
            }
        }
        return null;
    }
}
