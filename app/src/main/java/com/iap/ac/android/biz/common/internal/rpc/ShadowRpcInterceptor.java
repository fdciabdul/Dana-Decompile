package com.iap.ac.android.biz.common.internal.rpc;

import android.text.TextUtils;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.internal.foundation.FoundationProxy;
import com.iap.ac.android.biz.common.model.WalletPostRequest;
import com.iap.ac.android.biz.common.model.remoteconfig.common.OAuthConfig;
import com.iap.ac.android.common.instance.InstanceInfo;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.RpcAppInfo;
import com.iap.ac.android.common.rpc.RpcRequest;
import com.iap.ac.android.common.rpc.interfaces.FacadeInvoker;
import com.iap.ac.android.common.rpc.interfaces.RpcInterceptor;
import com.iap.ac.android.common.rpc.model.RpcExceptionInterceptResult;
import com.iap.ac.android.gol.google.GolGoogleAuthActivity;
import com.iap.ac.android.rpc.RpcProxyImpl;
import com.iap.ac.android.rpccommon.model.facade.MobileEnvInfo;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ShadowRpcInterceptor implements RpcInterceptor {
    public static final String CODE_SCAN = "ac.simulation.wallet.code.scan";
    public static final String GOOGLE_SANDBOX_MERCHANT_ID = "2188110452441670";
    public static final String TAG = "ShadowRpcInterceptor";
    public static final String WALLET_POST = "ac.simulation.wallet.post";

    private MobileEnvInfo generateMobileEnvInfo(MobileEnvInfo mobileEnvInfo) {
        if (mobileEnvInfo == null) {
            mobileEnvInfo = new MobileEnvInfo();
        }
        mobileEnvInfo.extendInfo = new HashMap();
        mobileEnvInfo.extendInfo.put(FoundationProxy.COMPONENT_INSTANCE_ID, InstanceInfo.getInstanceId(ACManager.getInstance().getContext()));
        return mobileEnvInfo;
    }

    public static String getClientId() {
        OAuthConfig oAuthConfig = ACManager.getInstance().getOAuthConfig();
        if (oAuthConfig != null) {
            return oAuthConfig.clientId;
        }
        return null;
    }

    @Override // com.iap.ac.android.common.rpc.interfaces.RpcInterceptor
    public Object onAfterReceive(RpcRequest rpcRequest, Object obj, FacadeInvoker facadeInvoker, Method method) {
        return null;
    }

    @Override // com.iap.ac.android.common.rpc.interfaces.RpcInterceptor
    public void onBeforeSend(RpcRequest rpcRequest) {
        String json;
        if (rpcRequest.operationType.equals(CODE_SCAN)) {
            return;
        }
        if (!rpcRequest.operationType.equals(WALLET_POST)) {
            if (rpcRequest.operationType.startsWith("ap.mobileamcs")) {
                return;
            }
            RpcAppInfo rpcAppInfo = rpcRequest.getRpcAppInfo();
            if (rpcAppInfo == null) {
                rpcAppInfo = new RpcAppInfo(RpcProxyImpl.getInstance("ac_biz").getRpcAppInfo());
            }
            Object obj = rpcRequest.request;
            if (obj instanceof String) {
                json = (String) obj;
            } else {
                json = JsonUtils.toJson(obj);
            }
            WalletPostRequest walletPostRequest = new WalletPostRequest(ACManager.getInstance().getPspId(), rpcRequest.operationType, json);
            JSONObject jSONObject = null;
            walletPostRequest.envInfo = generateMobileEnvInfo(null);
            rpcAppInfo.appId = "SIMULATION_WALLET_AC";
            rpcAppInfo.appKey = "SIMULATION_WALLET_AC_ANDROID";
            rpcAppInfo.headers.put("load-test", "0A");
            rpcAppInfo.headers.put(RpcAccelerateUrlInterceptor.KEY_INNER_OPERATION, rpcRequest.operationType);
            if (Constants.OperationType.OAUTH_PREPARE.equals(rpcRequest.operationType) && !TextUtils.isEmpty(walletPostRequest.requestData) && walletPostRequest.requestData.contains(GolGoogleAuthActivity.GSP_AUTHENTICATION_REQUEST)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(walletPostRequest.requestData);
                    try {
                        jSONObject2.put("clientId", getClientId());
                        ACLog.e("Interceeptor:", getClientId());
                        JSONObject jSONObject3 = new JSONObject(jSONObject2.getString("content"));
                        if (jSONObject3.get("merchantId") != null) {
                            jSONObject3.put("merchantId", GOOGLE_SANDBOX_MERCHANT_ID);
                            jSONObject2.put("content", JsonUtils.toJson(jSONObject3));
                        }
                    } catch (Exception unused) {
                    }
                    jSONObject = jSONObject2;
                } catch (Exception unused2) {
                }
                ACLog.e("Interceeptor:", JsonUtils.toJson(jSONObject));
                walletPostRequest.requestData = JsonUtils.toJson(jSONObject);
            }
            rpcRequest.request = walletPostRequest;
            rpcRequest.operationType = WALLET_POST;
            rpcRequest.setRpcAppInfo(rpcAppInfo);
            return;
        }
        RpcAppInfo rpcAppInfo2 = rpcRequest.getRpcAppInfo();
        if (rpcAppInfo2 == null) {
            rpcAppInfo2 = RpcProxyImpl.getInstance("ac_biz").getRpcAppInfo();
        }
        rpcAppInfo2.headers.put(RpcAccelerateUrlInterceptor.KEY_INNER_OPERATION, rpcRequest.operationType);
        rpcRequest.setRpcAppInfo(rpcAppInfo2);
    }

    @Override // com.iap.ac.android.common.rpc.interfaces.RpcInterceptor
    public RpcExceptionInterceptResult onExceptionOccurred(RpcRequest rpcRequest, Throwable th, FacadeInvoker facadeInvoker, Method method) {
        return null;
    }
}
