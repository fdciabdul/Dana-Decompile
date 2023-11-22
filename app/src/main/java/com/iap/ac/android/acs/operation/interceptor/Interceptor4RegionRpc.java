package com.iap.ac.android.acs.operation.interceptor;

import android.text.TextUtils;
import com.alipay.mobile.common.rpc.RpcException;
import com.alipay.mobile.framework.service.ext.SimpleRpcService;
import com.iap.ac.android.acs.minioperation.a.a;
import com.iap.ac.android.acs.operation.biz.region.config.RegionRPCConfigCenter;
import com.iap.ac.android.acs.operation.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.operation.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.operation.utils.CallbackUtil;
import com.iap.ac.android.acs.operation.utils.Utils;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.common.container.WebContainer;
import com.iap.ac.android.common.instance.InstanceInfo;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.RPCProxyHost;
import com.iap.ac.android.common.rpc.RpcAppInfo;
import com.iap.ac.android.common.rpc.RpcRequest;
import com.iap.ac.android.common.rpc.http.HttpTransportFactory;
import com.iap.ac.android.common.task.async.IAPAsyncTask;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Interceptor4RegionRpc extends BaseInterceptor {
    public static final String ERROR_CODE = "10";
    public static final String ERROR_CODE_JSAPI_BANNED = "10100";
    public static final String ERROR_CODE_JSAPI_NOT_IMPLEMENTATION = "10103";
    public static final String ERROR_CODE_JSAPI_REFUSE = "10101";
    public static final String ERROR_CODE_JSAPI_SPI_BANNED = "10102";
    public static final String ERROR_CODE_NETWORK_ERROR = "10104";
    public static final String ERROR_CODE_PROXY_SERVER_ERROR = "10105";
    public static final String ERROR_MESSAGE = "Network error";
    public static final String ERROR_MESSAGE_BANNED = "Region rpc is banned";
    public static final String ERROR_MESSAGE_PSP_NETWORK_ERROR = "PSP server request error";
    public static final String ERROR_MESSAGE_REFUSE = "this app have no permission to use region rpc";
    public static final String ERROR_MESSAGE_SPI_ENABLE = "Common network proxy spi register is disable";
    public static final String ERROR_MESSAGE_SPI_NO_IMPLEMENTATION = "region network proxy spi haven't implementation";
    public static final String KEY_FOR_SERVER_TYPE = "serverType";
    public static final String PARAM_PACKAGE_GATEWAY = "gateway";
    public static final String PARAM_PACKAGE_HEADERS = "headers";
    public static final String PARAM_PACKAGE_OPERATION_TYPE = "operationType";
    public static final String PARAM_PACKAGE_REQUEST_DATA = "requestData";
    public static final String TAG = "IAPConnectPlugin";

    private boolean appIdInWhiteList(String str) {
        List regionMiniAppList = RegionRPCConfigCenter.INSTANCE.getRegionMiniAppList();
        if (regionMiniAppList == null) {
            return false;
        }
        Iterator it = regionMiniAppList.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    private String appendServerTypeToData(JSONArray jSONArray) {
        try {
            JSONObject jSONObject = jSONArray.getJSONObject(0);
            if (jSONObject != null) {
                jSONObject.put(KEY_FOR_SERVER_TYPE, 2);
            }
        } catch (JSONException e) {
            ACLog.w("IAPConnectPlugin", e);
        }
        return JsonUtils.toJson(jSONArray);
    }

    private JSONObject generateEnvInfo() {
        String instanceId = InstanceInfo.getInstanceId(ACManager.getInstance().getContext());
        JSONObject jSONObject = new JSONObject();
        try {
            HashMap<String, String> griverConfig = WebContainer.getInstance("ac_biz").getGriverConfig();
            String str = griverConfig != null ? griverConfig.get("language") : "";
            jSONObject.put("tokenId", instanceId);
            jSONObject.put("locale", str);
        } catch (JSONException e) {
            ACLog.e("IAPConnectPlugin", e.getMessage());
        }
        return jSONObject;
    }

    private void handleInternal(IAPConnectPluginContext iAPConnectPluginContext, final IAPConnectPluginCallback iAPConnectPluginCallback) {
        JSONObject jSONObject = iAPConnectPluginContext.jsParameters;
        if (jSONObject == null) {
            ACLog.e("IAPConnectPlugin", "Interceptor4rpc#handle, jsParameters is null");
            iAPConnectPluginCallback.onResult(CallbackUtil.getInvalidParamError("rpc", "parameter is null"));
            return;
        }
        final String optString = jSONObject.optString("operationType");
        if (TextUtils.isEmpty(optString)) {
            ACLog.e("IAPConnectPlugin", "Interceptor4rpc#handle, operationType is empty");
            iAPConnectPluginCallback.onResult(CallbackUtil.getInvalidParamError("rpc", "operationType is empty"));
            return;
        }
        final String requestData = getRequestData(jSONObject);
        final String optString2 = jSONObject.optString("gateway");
        final Map<String, String> json2StringMap = Utils.json2StringMap(jSONObject.optJSONObject("headers"));
        IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.acs.operation.interceptor.Interceptor4RegionRpc.1
            {
                Interceptor4RegionRpc.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptor4RegionRpc.this.invokeRpc(optString, requestData, optString2, json2StringMap, iAPConnectPluginCallback);
            }
        });
    }

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
            String executeRPC = ((SimpleRpcService) RPCProxyHost.getInterfaceProxy(SimpleRpcService.class, getBizId(), new RPCProxyHost.RpcInvocationHandlerListener() { // from class: com.iap.ac.android.acs.operation.interceptor.Interceptor4RegionRpc.2
                {
                    Interceptor4RegionRpc.this = this;
                }

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
            iAPConnectPluginCallback.onResult(CallbackUtil.getError("rpc", getNetworkErrorCode(th), getErrorMessage(th)));
        }
    }

    private boolean isDigital(String str) {
        if (str == null) {
            return false;
        }
        return Pattern.compile("^[-\\+]?[\\d]*$").matcher(str).matches();
    }

    private boolean isProxyError(Throwable th) {
        return (th instanceof RpcException) && ((RpcException) th).getCode() == 0;
    }

    private boolean isRegionNetworkProxyImplementation() {
        return HttpTransportFactory.getCreater("region_biz") != null;
    }

    public String getBizId() {
        return "region_biz";
    }

    public String getErrorMessage(Throwable th) {
        return isProxyError(th) ? ERROR_MESSAGE_PSP_NETWORK_ERROR : "Network error";
    }

    public String getNetworkErrorCode(Throwable th) {
        return isProxyError(th) ? ERROR_CODE_PROXY_SERVER_ERROR : ERROR_CODE_NETWORK_ERROR;
    }

    public String getRequestData(JSONObject jSONObject) {
        String optString = jSONObject.optString("requestData");
        if (TextUtils.isEmpty(optString)) {
            JSONArray optJSONArray = jSONObject.optJSONArray("requestData");
            return optJSONArray != null ? appendServerTypeToData(optJSONArray) : optString;
        }
        try {
            return appendServerTypeToData(new JSONArray(optString));
        } catch (JSONException e) {
            ACLog.w("IAPConnectPlugin", e);
            return optString;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x002f, code lost:
    
        if (isDigital(r0) == false) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0062  */
    @Override // com.iap.ac.android.acs.operation.interceptor.BaseInterceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handle(com.iap.ac.android.acs.operation.core.IAPConnectPluginContext r6, com.iap.ac.android.acs.operation.core.IAPConnectPluginCallback r7) {
        /*
            r5 = this;
            com.iap.ac.android.acs.operation.biz.region.config.RegionRPCConfigCenter r0 = com.iap.ac.android.acs.operation.biz.region.config.RegionRPCConfigCenter.INSTANCE
            boolean r0 = r0.regionRPCEnable()
            java.lang.String r1 = "IAPConnectPlugin"
            java.lang.String r2 = "APRegionRPC"
            if (r0 != 0) goto L1b
            java.lang.String r6 = "Region rpc is banned"
            java.lang.String r0 = "10100"
            org.json.JSONObject r0 = com.iap.ac.android.acs.operation.utils.CallbackUtil.getError(r2, r0, r6)
            r7.onResult(r0)
            com.iap.ac.android.common.log.ACLog.d(r1, r6)
            return
        L1b:
            java.lang.String r0 = r6.pluginId
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L33
            org.json.JSONObject r0 = r6.jsParameters     // Catch: org.json.JSONException -> L31
            java.lang.String r3 = "__appxDomain"
            java.lang.String r0 = r0.getString(r3)     // Catch: org.json.JSONException -> L31
            boolean r3 = r5.isDigital(r0)     // Catch: org.json.JSONException -> L31
            if (r3 != 0) goto L33
        L31:
            java.lang.String r0 = ""
        L33:
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L3c
            java.lang.String r3 = r6.miniProgramAppID
            goto L3d
        L3c:
            r3 = r0
        L3d:
            boolean r3 = r5.appIdInWhiteList(r3)
            java.lang.String r4 = "this app have no permission to use region rpc"
            if (r3 != 0) goto L62
            java.lang.String r6 = "10101"
            org.json.JSONObject r6 = com.iap.ac.android.acs.operation.utils.CallbackUtil.getError(r2, r6, r4)
            r7.onResult(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r4)
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            com.iap.ac.android.common.log.ACLog.d(r1, r6)
            return
        L62:
            com.iap.ac.android.acs.operation.biz.region.config.RegionRPCConfigCenter r0 = com.iap.ac.android.acs.operation.biz.region.config.RegionRPCConfigCenter.INSTANCE
            boolean r0 = r0.isRegionNetworkProxyEnable()
            if (r0 != 0) goto L79
            java.lang.String r6 = "10102"
            java.lang.String r0 = "Common network proxy spi register is disable"
            org.json.JSONObject r6 = com.iap.ac.android.acs.operation.utils.CallbackUtil.getError(r2, r6, r0)
            r7.onResult(r6)
            com.iap.ac.android.common.log.ACLog.d(r1, r4)
            return
        L79:
            boolean r0 = r5.isRegionNetworkProxyImplementation()
            if (r0 != 0) goto L8f
            java.lang.String r6 = "region network proxy spi haven't implementation"
            java.lang.String r0 = "10103"
            org.json.JSONObject r0 = com.iap.ac.android.acs.operation.utils.CallbackUtil.getError(r2, r0, r6)
            r7.onResult(r0)
            com.iap.ac.android.common.log.ACLog.d(r1, r6)
            return
        L8f:
            r5.handleInternal(r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.acs.operation.interceptor.Interceptor4RegionRpc.handle(com.iap.ac.android.acs.operation.core.IAPConnectPluginContext, com.iap.ac.android.acs.operation.core.IAPConnectPluginCallback):void");
    }
}
