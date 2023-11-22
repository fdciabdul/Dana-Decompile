package com.iap.ac.android.acs.operation.biz.region;

import android.text.TextUtils;
import com.alibaba.griver.base.common.constants.SecurityConstants;
import com.alipay.plus.security.lite.ISecurityGuardLiteManager;
import com.alipay.plus.security.lite.SecurityGuardLiteManager;
import com.alipay.plus.security.lite.SecurityGuardLiteParamContext;
import com.iap.ac.android.acs.operation.biz.region.config.ConfigUtils;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.RpcAppInfo;
import com.iap.ac.android.common.rpc.interfaces.SignV2RpcRequestPlugin;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class SignV2RpcRequestPluginImpl implements SignV2RpcRequestPlugin {
    public boolean mOldSecurityGuardExist = Utils.checkClassExist(SecurityConstants.SG_CLASS);

    private String getAppKey(RpcAppInfo rpcAppInfo) {
        return rpcAppInfo.appKey;
    }

    private String getAuthCode(RpcAppInfo rpcAppInfo) {
        return rpcAppInfo.authCode;
    }

    @Override // com.iap.ac.android.common.rpc.interfaces.SignV2RpcRequestPlugin
    public String signV2Request(RpcAppInfo rpcAppInfo, String str, String str2, Map<String, String> map) {
        if ((!this.mOldSecurityGuardExist || ConfigUtils.canUseTopWhiteList((JSONObject) ConfigCenter.INSTANCE.getKeyOrDefault("RPC_signV2_config_ac_region", new JSONObject()), str, false)) && !TextUtils.isEmpty(str2) && getAuthCode(rpcAppInfo).split("_").length == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append(getAppKey(rpcAppInfo));
            sb.append("_");
            sb.append(RegionManager.getInstance().getInitConfig().envType.toUpperCase());
            String obj = sb.toString();
            HashMap hashMap = new HashMap();
            hashMap.put("INPUT", str2);
            SecurityGuardLiteParamContext securityGuardLiteParamContext = new SecurityGuardLiteParamContext();
            securityGuardLiteParamContext.paramMap = hashMap;
            securityGuardLiteParamContext.requestType = 4;
            securityGuardLiteParamContext.appKey = obj;
            try {
                ISecurityGuardLiteManager securityGuardLiteManager = SecurityGuardLiteManager.getInstance(RegionManager.getInstance().getContext(), "0a6a");
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
