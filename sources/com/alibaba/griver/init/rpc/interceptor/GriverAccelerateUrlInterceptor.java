package com.alibaba.griver.init.rpc.interceptor;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.iap.ac.android.biz.common.internal.rpc.RpcAccelerateUrlInterceptor;
import com.iap.ac.android.common.rpc.RpcAppInfo;
import com.iap.ac.android.common.rpc.RpcRequest;
import com.iap.ac.android.common.rpc.interfaces.FacadeInvoker;
import com.iap.ac.android.common.rpc.interfaces.RpcInterceptor;
import com.iap.ac.android.common.rpc.model.RpcExceptionInterceptResult;
import com.iap.ac.android.rpc.RpcProxyImpl;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: classes3.dex */
public class GriverAccelerateUrlInterceptor implements RpcInterceptor {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6645a = "GriverAccelerateUrlInterceptor";

    @Override // com.iap.ac.android.common.rpc.interfaces.RpcInterceptor
    public Object onAfterReceive(RpcRequest rpcRequest, Object obj, FacadeInvoker facadeInvoker, Method method) {
        return null;
    }

    @Override // com.iap.ac.android.common.rpc.interfaces.RpcInterceptor
    public RpcExceptionInterceptResult onExceptionOccurred(RpcRequest rpcRequest, Throwable th, FacadeInvoker facadeInvoker, Method method) {
        return null;
    }

    @Override // com.iap.ac.android.common.rpc.interfaces.RpcInterceptor
    public void onBeforeSend(RpcRequest rpcRequest) {
        JSONObject configJSONObject;
        JSONArray jSONArray;
        if (rpcRequest == null || (configJSONObject = GriverInnerConfig.getConfigJSONObject(GriverConfigConstants.KEY_GRIVER_BIZ_REQUEST_URL_INTERCEPTOR_CONFIG)) == null || !JSONUtils.getBoolean(configJSONObject, "enabled", false)) {
            return;
        }
        RpcAppInfo rpcAppInfo = rpcRequest.getRpcAppInfo();
        if (rpcAppInfo == null) {
            rpcAppInfo = new RpcAppInfo(RpcProxyImpl.getInstance("GriverAppContainer").getRpcAppInfo());
            rpcRequest.setRpcAppInfo(rpcAppInfo);
        }
        String operationType = rpcRequest.getOperationType();
        Map<String, String> map = rpcAppInfo.headers;
        if (map != null && map.containsKey(RpcAccelerateUrlInterceptor.KEY_INNER_OPERATION)) {
            operationType = map.get(RpcAccelerateUrlInterceptor.KEY_INNER_OPERATION);
        }
        if (TextUtils.isEmpty(operationType) || TextUtils.isEmpty(rpcAppInfo.rpcGateWayUrl) || TextUtils.equals(operationType, "ap.mobileamcs.cloud.fetch.config")) {
            return;
        }
        GriverLogger.d(f6645a, String.format("operationType = %s, before replacing rpcGateway = %s", operationType, rpcAppInfo.rpcGateWayUrl));
        String string = JSONUtils.getString(configJSONObject, GriverConfigConstants.PARAM_OLD_GATEWAYURL);
        if (TextUtils.isEmpty(string) || !TextUtils.equals(string, rpcAppInfo.rpcGateWayUrl)) {
            return;
        }
        String string2 = JSONUtils.getString(configJSONObject, GriverConfigConstants.PARAM_NEW_GATEWAYURL);
        if (TextUtils.isEmpty(string2) || (jSONArray = JSONUtils.getJSONArray(configJSONObject, "operationTypeContainRules", null)) == null || jSONArray.isEmpty()) {
            return;
        }
        for (int i = 0; i < jSONArray.size(); i++) {
            String string3 = jSONArray.getString(i);
            if (!TextUtils.isEmpty(string3) && ("*".equals(string3) || operationType.contains(string3))) {
                rpcAppInfo.rpcGateWayUrl = string2;
                GriverLogger.d(f6645a, String.format("operationType = %s, after replacing rpcGateway = %s", operationType, rpcAppInfo.rpcGateWayUrl));
                return;
            }
        }
    }
}
