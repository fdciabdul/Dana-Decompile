package com.alibaba.griver.init.rpc;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.rpc.GriverRpcExtension;
import com.alipay.mobile.common.rpc.RpcException;
import com.alipay.mobile.framework.service.ext.SimpleRpcService;
import com.iap.ac.android.acs.plugin.utils.ErrorCode;
import com.iap.ac.android.common.rpc.RPCProxyHost;
import com.iap.ac.android.common.rpc.RpcAppInfo;
import com.iap.ac.android.common.rpc.RpcRequest;
import java.util.Map;

/* loaded from: classes3.dex */
public class GriverRpcExtensionImpl implements GriverRpcExtension {

    /* renamed from: a  reason: collision with root package name */
    private String f6643a;

    public GriverRpcExtensionImpl(String str) {
        this.f6643a = str;
    }

    @Override // com.alibaba.griver.base.common.rpc.GriverRpcExtension
    public <T> T getFacade(Class<T> cls) {
        if (!TextUtils.isEmpty(this.f6643a)) {
            return (T) RPCProxyHost.getInterfaceProxy(cls, this.f6643a);
        }
        return (T) RPCProxyHost.getInterfaceProxy(cls, "GriverAppContainer");
    }

    @Override // com.alibaba.griver.base.common.rpc.GriverRpcExtension
    public JSONObject invokeRpc(String str, String str2, final String str3, final Map<String, String> map) {
        SimpleRpcService simpleRpcService = (SimpleRpcService) RPCProxyHost.getInterfaceProxy(SimpleRpcService.class, "GriverAppContainer", new RPCProxyHost.RpcInvocationHandlerListener() { // from class: com.alibaba.griver.init.rpc.GriverRpcExtensionImpl.1
            @Override // com.iap.ac.android.common.rpc.RPCProxyHost.RpcInvocationHandlerListener
            public void onBeforeSend(RpcRequest rpcRequest) {
                if (TextUtils.isEmpty(str3) || map.isEmpty()) {
                    return;
                }
                RpcAppInfo rpcAppInfo = new RpcAppInfo();
                rpcAppInfo.rpcGateWayUrl = str3;
                rpcAppInfo.headers = map;
                rpcRequest.setRpcAppInfo(rpcAppInfo);
            }
        });
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("success", (Object) simpleRpcService.executeRPC(str, str2));
            return jSONObject;
        } catch (RpcException e) {
            jSONObject.put("fail", (Object) e.getMessage());
            return jSONObject;
        } catch (Throwable unused) {
            GriverLogger.d("GriverRpcExtensionImpl", "rpc request fail");
            jSONObject.put("fail", (Object) ErrorCode.ERROR_UNKNOWN_ERROR_MESSAGE);
            return jSONObject;
        }
    }

    @Override // com.alibaba.griver.base.common.rpc.GriverRpcExtension
    public JSONObject invokeACRpc(String str, String str2, final String str3, final Map<String, String> map) {
        SimpleRpcService simpleRpcService = (SimpleRpcService) RPCProxyHost.getInterfaceProxy(SimpleRpcService.class, "ac_biz", new RPCProxyHost.RpcInvocationHandlerListener() { // from class: com.alibaba.griver.init.rpc.GriverRpcExtensionImpl.2
            @Override // com.iap.ac.android.common.rpc.RPCProxyHost.RpcInvocationHandlerListener
            public void onBeforeSend(RpcRequest rpcRequest) {
                if (TextUtils.isEmpty(str3) || map.isEmpty()) {
                    return;
                }
                RpcAppInfo rpcAppInfo = new RpcAppInfo();
                rpcAppInfo.rpcGateWayUrl = str3;
                rpcAppInfo.headers = map;
                rpcRequest.setRpcAppInfo(rpcAppInfo);
            }
        });
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("success", (Object) simpleRpcService.executeRPC(str, str2));
            return jSONObject;
        } catch (RpcException e) {
            jSONObject.put("fail", (Object) e.getMessage());
            return jSONObject;
        } catch (Throwable unused) {
            GriverLogger.d("GriverRpcExtensionImpl", "rpc request fail");
            jSONObject.put("fail", (Object) ErrorCode.ERROR_UNKNOWN_ERROR_MESSAGE);
            return jSONObject;
        }
    }
}
