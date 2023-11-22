package com.iap.ac.android.common.rpc;

import android.text.TextUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.log.ACMonitor;
import com.iap.ac.android.common.log.event.LogEvent;
import com.iap.ac.android.common.log.event.LogEventType;
import com.iap.ac.android.common.rpc.interfaces.RpcInterceptor;
import com.iap.ac.android.common.rpc.interfaces.SignRpcRequestPlugin;
import com.iap.ac.android.common.rpc.interfaces.SignV2RpcRequestPlugin;
import com.iap.ac.android.common.rpc.interfaces.SslPinningPlugin;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class RPCProxyHost {
    public static final String EVENT_GET_DEFAULT_IMPL = "ac_common_get_rpc_defalut_impl";
    public static final String EVENT_GET_IMPL_ERROR = "ac_common_get_rpc_impl_error";
    public static final String TAG = "RPCProxyHost";
    public static final Map<String, IRPCProxy> rpcProxyMap = new HashMap();
    public static IRPCProxy defaultProxy = new IRPCProxy() { // from class: com.iap.ac.android.common.rpc.RPCProxyHost.1
        @Override // com.iap.ac.android.common.rpc.RPCProxyHost.IRPCProxy
        public final void addRpcInterceptor(RpcInterceptor rpcInterceptor) {
            RPCProxyHost.noImplementationError();
        }

        @Override // com.iap.ac.android.common.rpc.RPCProxyHost.IRPCProxy
        public final void clearRpcInterceptors() {
            RPCProxyHost.noImplementationError();
        }

        @Override // com.iap.ac.android.common.rpc.RPCProxyHost.IRPCProxy
        public final <T> T getInterfaceProxy(Class<T> cls) {
            RPCProxyHost.noImplementationError();
            return null;
        }

        @Override // com.iap.ac.android.common.rpc.RPCProxyHost.IRPCProxy
        public final void removeRpcInterceptor(RpcInterceptor rpcInterceptor) {
            RPCProxyHost.noImplementationError();
        }

        @Override // com.iap.ac.android.common.rpc.RPCProxyHost.IRPCProxy
        public final void setSignRequest(SignRpcRequestPlugin signRpcRequestPlugin) {
            RPCProxyHost.noImplementationError();
        }

        @Override // com.iap.ac.android.common.rpc.RPCProxyHost.IRPCProxy
        public final void setSignV2Request(SignV2RpcRequestPlugin signV2RpcRequestPlugin) {
            RPCProxyHost.noImplementationError();
        }

        @Override // com.iap.ac.android.common.rpc.RPCProxyHost.IRPCProxy
        public final void setSslPinningPlugin(SslPinningPlugin sslPinningPlugin) {
            RPCProxyHost.noImplementationError();
        }

        @Override // com.iap.ac.android.common.rpc.RPCProxyHost.IRPCProxy
        public final <T> T getInterfaceProxy(Class<T> cls, RpcInvocationHandlerListener rpcInvocationHandlerListener) {
            RPCProxyHost.noImplementationError();
            return null;
        }
    };
    public static IRPCProxy irpcProxy = null;

    /* loaded from: classes.dex */
    public interface IRPCProxy {
        void addRpcInterceptor(RpcInterceptor rpcInterceptor);

        void clearRpcInterceptors();

        <T> T getInterfaceProxy(Class<T> cls);

        <T> T getInterfaceProxy(Class<T> cls, RpcInvocationHandlerListener rpcInvocationHandlerListener);

        void removeRpcInterceptor(RpcInterceptor rpcInterceptor);

        void setSignRequest(SignRpcRequestPlugin signRpcRequestPlugin);

        void setSignV2Request(SignV2RpcRequestPlugin signV2RpcRequestPlugin);

        void setSslPinningPlugin(SslPinningPlugin sslPinningPlugin);
    }

    /* loaded from: classes3.dex */
    public interface RpcInvocationHandlerListener {
        void onBeforeSend(RpcRequest rpcRequest);
    }

    public static void addRpcInterceptor(RpcInterceptor rpcInterceptor) {
        IRPCProxy iRPCProxy = irpcProxy;
        if (iRPCProxy == null) {
            noImplementationError();
        } else {
            iRPCProxy.addRpcInterceptor(rpcInterceptor);
        }
    }

    public static void clearRpcInterceptors() {
        IRPCProxy iRPCProxy = irpcProxy;
        if (iRPCProxy == null) {
            noImplementationError();
        } else {
            iRPCProxy.clearRpcInterceptors();
        }
    }

    public static IRPCProxy getInstance(String str) {
        if (TextUtils.isEmpty(str)) {
            return getInstance();
        }
        IRPCProxy iRPCProxy = rpcProxyMap.get(str);
        if (iRPCProxy == null && (iRPCProxy = irpcProxy) != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("bizCode", str);
            hashMap.put("msg", "Cannot find the implemetation for this bizCode. Using default instead.");
            LogEvent logEvent = new LogEvent(EVENT_GET_DEFAULT_IMPL, hashMap);
            logEvent.bizCode = str;
            ACMonitor.getInstance(str).logEvent(logEvent);
        }
        if (iRPCProxy == null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("bizCode", str);
            hashMap2.put("errorMsg", "Cannot find the implemetation for this bizCode.");
            LogEvent logEvent2 = new LogEvent(EVENT_GET_IMPL_ERROR, hashMap2);
            logEvent2.bizCode = str;
            logEvent2.eventType = LogEventType.CRUCIAL_LOG;
            ACMonitor.getInstance(str).logEvent(logEvent2);
            return defaultProxy;
        }
        return iRPCProxy;
    }

    public static <T> T getInterfaceProxy(Class<T> cls) {
        IRPCProxy iRPCProxy = irpcProxy;
        if (iRPCProxy == null) {
            return null;
        }
        return (T) iRPCProxy.getInterfaceProxy(cls);
    }

    public static boolean isRpcProxyExist() {
        return irpcProxy != null;
    }

    public static void noImplementationError() {
        ACLog.e(TAG, "There is no implementation of Rpc. Please setRpcProxy before using it.");
    }

    public static void removeRpcInterceptor(RpcInterceptor rpcInterceptor) {
        IRPCProxy iRPCProxy = irpcProxy;
        if (iRPCProxy == null) {
            noImplementationError();
        } else {
            iRPCProxy.removeRpcInterceptor(rpcInterceptor);
        }
    }

    public static void setRpcProxy(IRPCProxy iRPCProxy) {
        irpcProxy = iRPCProxy;
    }

    public static void setSignRequest(SignRpcRequestPlugin signRpcRequestPlugin) {
        IRPCProxy iRPCProxy = irpcProxy;
        if (iRPCProxy != null) {
            iRPCProxy.setSignRequest(signRpcRequestPlugin);
        }
    }

    public static void setSslPinningPlugin(SslPinningPlugin sslPinningPlugin) {
        IRPCProxy iRPCProxy = irpcProxy;
        if (iRPCProxy == null) {
            noImplementationError();
        } else {
            iRPCProxy.setSslPinningPlugin(sslPinningPlugin);
        }
    }

    public static boolean isRpcProxyExist(String str) {
        return rpcProxyMap.get(str) != null;
    }

    public static void setRpcProxy(IRPCProxy iRPCProxy, String str) {
        rpcProxyMap.put(str, iRPCProxy);
    }

    public static <T> T getInterfaceProxy(Class<T> cls, String str) {
        return (T) getInterfaceProxy(cls, str, null);
    }

    public static <T> T getInterfaceProxy(Class<T> cls, String str, RpcInvocationHandlerListener rpcInvocationHandlerListener) {
        return (T) getInstance(str).getInterfaceProxy(cls, rpcInvocationHandlerListener);
    }

    public static IRPCProxy getInstance() {
        IRPCProxy iRPCProxy = irpcProxy;
        return iRPCProxy != null ? iRPCProxy : defaultProxy;
    }
}
