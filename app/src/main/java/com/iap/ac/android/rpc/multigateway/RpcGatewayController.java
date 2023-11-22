package com.iap.ac.android.rpc.multigateway;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.multigateway.sdk.GatewayController;
import com.alipay.multigateway.sdk.decision.condition.Condition;
import com.iap.ac.android.common.rpc.RpcRequest;
import com.iap.ac.android.common.rpc.interfaces.FacadeInvoker;
import com.iap.ac.android.common.rpc.interfaces.RpcInterceptor;
import com.iap.ac.android.common.rpc.model.RpcExceptionInterceptResult;
import com.iap.ac.android.rpc.RpcProxyImpl;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class RpcGatewayController {
    public static final Map<String, GatewayController> CONTROLLER_MAP = new HashMap();

    public static GatewayController getGatewayController() {
        return getGatewayController("");
    }

    public static void initGatewayController(Context context) {
        initGatewayController(context, "");
    }

    public static GatewayController getGatewayController(String str) {
        Map<String, GatewayController> map = CONTROLLER_MAP;
        GatewayController gatewayController = map.get(str);
        if (gatewayController == null) {
            GatewayController gatewayController2 = new GatewayController();
            map.put(str, gatewayController2);
            return gatewayController2;
        }
        return gatewayController;
    }

    public static void initGatewayController(Context context, final String str) {
        RpcProxyImpl rpcProxyImpl;
        Map<String, GatewayController> map = CONTROLLER_MAP;
        GatewayController gatewayController = map.get(str);
        if (gatewayController == null) {
            gatewayController = new GatewayController();
            map.put(str, gatewayController);
        }
        gatewayController.init(context, new RpcGatewayDelegate());
        gatewayController.addValueGetter(Condition.TYPE_OPERATION_TYPE, new RpcOperationTypeGetter());
        if (TextUtils.isEmpty(str)) {
            rpcProxyImpl = RpcProxyImpl.getInstance();
        } else {
            rpcProxyImpl = RpcProxyImpl.getInstance(str);
        }
        rpcProxyImpl.addRpcInterceptor(new RpcInterceptor() { // from class: com.iap.ac.android.rpc.multigateway.RpcGatewayController.1
            @Override // com.iap.ac.android.common.rpc.interfaces.RpcInterceptor
            public final Object onAfterReceive(RpcRequest rpcRequest, Object obj, FacadeInvoker facadeInvoker, Method method) {
                return null;
            }

            @Override // com.iap.ac.android.common.rpc.interfaces.RpcInterceptor
            public final void onBeforeSend(RpcRequest rpcRequest) {
                GatewayController gatewayController2 = (GatewayController) RpcGatewayController.CONTROLLER_MAP.get(str);
                if (gatewayController2 != null) {
                    gatewayController2.processRequest(rpcRequest);
                }
            }

            @Override // com.iap.ac.android.common.rpc.interfaces.RpcInterceptor
            public final RpcExceptionInterceptResult onExceptionOccurred(RpcRequest rpcRequest, Throwable th, FacadeInvoker facadeInvoker, Method method) {
                return null;
            }
        });
    }
}
