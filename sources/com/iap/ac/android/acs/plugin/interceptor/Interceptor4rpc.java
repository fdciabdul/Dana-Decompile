package com.iap.ac.android.acs.plugin.interceptor;

import android.text.TextUtils;
import com.alipay.mobile.common.rpc.RpcException;
import com.alipay.mobile.framework.service.ext.SimpleRpcService;
import com.iap.ac.android.acs.plugin.a.a;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.utils.CallbackUtil;
import com.iap.ac.android.acs.plugin.utils.Utils;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.RPCProxyHost;
import com.iap.ac.android.common.rpc.RpcAppInfo;
import com.iap.ac.android.common.rpc.RpcRequest;
import com.iap.ac.android.common.task.async.IAPAsyncTask;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class Interceptor4rpc extends BaseInterceptor {
    public static final String ERROR_CODE = "10";
    public static final String ERROR_MESSAGE = "Network error";
    public static final String PARAM_PACKAGE_GATEWAY = "gateway";
    public static final String PARAM_PACKAGE_HEADERS = "headers";
    public static final String PARAM_PACKAGE_OPERATION_TYPE = "operationType";
    public static final String PARAM_PACKAGE_REQUEST_DATA = "requestData";
    public static final String TAG = "IAPConnectPlugin";

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeRpc(String str, String str2, final String str3, final Map<String, String> map, IAPConnectPluginCallback iAPConnectPluginCallback) {
        StringBuilder sb = new StringBuilder();
        sb.append("Interceptor4rpc#invokeRpc, start to send RPC request, operationType: ");
        sb.append(str);
        sb.append(", requestData: ");
        sb.append(str2);
        sb.append(", gateway: ");
        sb.append(str3);
        sb.append(", headers: ");
        sb.append(map);
        ACLog.d("IAPConnectPlugin", sb.toString());
        try {
            String executeRPC = ((SimpleRpcService) RPCProxyHost.getInterfaceProxy(SimpleRpcService.class, getBizId(), new RPCProxyHost.RpcInvocationHandlerListener() { // from class: com.iap.ac.android.acs.plugin.interceptor.Interceptor4rpc.2
                @Override // com.iap.ac.android.common.rpc.RPCProxyHost.RpcInvocationHandlerListener
                public void onBeforeSend(RpcRequest rpcRequest) {
                    if (TextUtils.isEmpty(str3) || map.isEmpty()) {
                        return;
                    }
                    ACLog.d("IAPConnectPlugin", "Interceptor4rpc#invokeRpc, set gateway and headers to RPC");
                    RpcAppInfo rpcAppInfo = new RpcAppInfo();
                    rpcAppInfo.rpcGateWayUrl = str3;
                    rpcAppInfo.headers = map;
                    rpcRequest.setRpcAppInfo(rpcAppInfo);
                }
            })).executeRPC(str, str2);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Interceptor4rpc#invokeRpc, result: ");
            sb2.append(executeRPC);
            ACLog.d("IAPConnectPlugin", sb2.toString());
            iAPConnectPluginCallback.onResult(new JSONObject(executeRPC));
        } catch (Throwable th) {
            StringBuilder a2 = a.a("Interceptor4rpc#invokeRpc, error: ");
            a2.append(th.getMessage());
            ACLog.e("IAPConnectPlugin", a2.toString());
            if (th instanceof RpcException) {
                RpcException rpcException = th;
                iAPConnectPluginCallback.onResult(CallbackUtil.getError("rpc", String.valueOf(rpcException.getCode()), rpcException.getMsg()));
                return;
            }
            iAPConnectPluginCallback.onResult(CallbackUtil.getError("rpc", getNetworkErrorCode(th), getErrorMessage(th)));
        }
    }

    public String getBizId() {
        return "ac_biz";
    }

    public String getErrorMessage(Throwable th) {
        return "Network error";
    }

    public String getNetworkErrorCode(Throwable th) {
        return "10";
    }

    public String getRequestData(JSONObject jSONObject) {
        JSONArray optJSONArray;
        String optString = jSONObject.optString("requestData");
        return (!TextUtils.isEmpty(optString) || (optJSONArray = jSONObject.optJSONArray("requestData")) == null) ? optString : JsonUtils.toJson(optJSONArray);
    }

    @Override // com.iap.ac.android.acs.plugin.interceptor.BaseInterceptor
    public void handle(IAPConnectPluginContext iAPConnectPluginContext, final IAPConnectPluginCallback iAPConnectPluginCallback) {
        JSONObject jSONObject = iAPConnectPluginContext.jsParameters;
        if (jSONObject == null) {
            a.a("IAPConnectPlugin", "Interceptor4rpc#handle, jsParameters is null", "rpc", "parameter is null", iAPConnectPluginCallback);
            return;
        }
        final String optString = jSONObject.optString("operationType");
        if (TextUtils.isEmpty(optString)) {
            a.a("IAPConnectPlugin", "Interceptor4rpc#handle, operationType is empty", "rpc", "operationType is empty", iAPConnectPluginCallback);
            return;
        }
        final String requestData = getRequestData(jSONObject);
        final String optString2 = jSONObject.optString("gateway");
        final Map<String, String> json2StringMap = Utils.json2StringMap(jSONObject.optJSONObject("headers"));
        IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.acs.plugin.interceptor.Interceptor4rpc.1
            @Override // java.lang.Runnable
            public void run() {
                Interceptor4rpc.this.invokeRpc(optString, requestData, optString2, json2StringMap, iAPConnectPluginCallback);
            }
        });
    }
}
