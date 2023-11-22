package com.alipay.iap.android.common.rpcintegration;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.imobile.network.quake.IQuake;
import com.alipay.imobile.network.quake.QuakeConfig;
import com.alipay.imobile.network.quake.exception.ReinitializationException;
import com.alipay.imobile.network.quake.rpc.QuakeRpc;
import com.alipay.imobile.network.quake.rpc.RpcInterceptor;
import com.alipay.mobile.common.rpc.RpcException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class RPCProxyHost {
    private static Map<String, Object> hostMap = new HashMap();
    private static IRPCProxy rpcOuterImplement = null;

    /* loaded from: classes3.dex */
    public interface IRPCProxy {
        <T> T getInterfaceProxy(Class<T> cls);
    }

    public static <T> T getInterfaceProxy(Class<T> cls) {
        if (hostMap.containsKey(cls.getName())) {
            return (T) hostMap.get(cls.getName());
        }
        IRPCProxy iRPCProxy = rpcOuterImplement;
        if (iRPCProxy == null) {
            return null;
        }
        T t = (T) iRPCProxy.getInterfaceProxy(cls);
        hostMap.put(cls.getName(), t);
        return t;
    }

    public static void setRPCImplement(IRPCProxy iRPCProxy) {
        rpcOuterImplement = iRPCProxy;
    }

    private static boolean checkQuakeExist() throws ClassNotFoundException {
        try {
            return Class.forName("com.alipay.imobile.network.quake.rpc.IQuakeRpc") != null;
        } catch (ClassNotFoundException unused) {
            LoggerWrapper.w(com.iap.ac.android.common.rpc.RPCProxyHost.TAG, "Quake not in application package.");
            if (rpcOuterImplement != null) {
                return false;
            }
            throw new ClassNotFoundException("Neither IAPNetworkKit in this package nor another RPC implementation is set to RPCHost, network will not be available");
        }
    }

    public static void initRPC(Context context, String str, String str2, String str3) throws ReinitializationException, IllegalArgumentException, ClassNotFoundException {
        if (checkQuakeExist()) {
            IQuake quake = QuakeRpc.createInstance(context).getQuake();
            if (TextUtils.isEmpty(str2)) {
                LoggerWrapper.i(com.iap.ac.android.common.rpc.RPCProxyHost.TAG, "the appKey for security guard is empty");
            }
            if (TextUtils.isEmpty(str3)) {
                throw new IllegalArgumentException("the url of gate way is empty");
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[Use user-passed configuration] configuration:appkey=");
            sb.append(str2);
            sb.append(", gwurl=");
            sb.append(str3);
            LoggerWrapper.i(com.iap.ac.android.common.rpc.RPCProxyHost.TAG, sb.toString());
            quake.config(new QuakeConfig(str, str2, str3));
            setRPCImplement(new IRPCProxy() { // from class: com.alipay.iap.android.common.rpcintegration.RPCProxyHost.1
                @Override // com.alipay.iap.android.common.rpcintegration.RPCProxyHost.IRPCProxy
                public final <T> T getInterfaceProxy(Class<T> cls) {
                    return (T) QuakeRpc.instance().getRpcProxy(cls);
                }
            });
        }
    }

    public static void initRPC(Context context, String str, String str2) throws ReinitializationException, IllegalArgumentException, ClassNotFoundException {
        if (checkQuakeExist()) {
            IQuake quake = QuakeRpc.createInstance(context).getQuake();
            if (TextUtils.isEmpty(str)) {
                LoggerWrapper.i(com.iap.ac.android.common.rpc.RPCProxyHost.TAG, "the appKey for security guard is empty");
            }
            if (TextUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("the url of gate way is empty");
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[Use user-passed configuration] configuration:appkey=");
            sb.append(str);
            sb.append(", gwurl=");
            sb.append(str2);
            LoggerWrapper.i(com.iap.ac.android.common.rpc.RPCProxyHost.TAG, sb.toString());
            quake.config(new QuakeConfig(str, str, str2));
            setRPCImplement(new IRPCProxy() { // from class: com.alipay.iap.android.common.rpcintegration.RPCProxyHost.2
                @Override // com.alipay.iap.android.common.rpcintegration.RPCProxyHost.IRPCProxy
                public final <T> T getInterfaceProxy(Class<T> cls) {
                    return (T) QuakeRpc.instance().getRpcProxy(cls);
                }
            });
        }
    }

    public static void registerRpcInterceptor(Context context, Class<? extends Annotation> cls, final RpcInterceptorHost rpcInterceptorHost) throws IllegalArgumentException, ClassNotFoundException {
        if (context == null || cls == null || rpcInterceptorHost == null) {
            throw new IllegalArgumentException("the arguments is illegal");
        }
        if (checkQuakeExist()) {
            QuakeRpc.createInstance(context).registerRpcInterceptor(cls, new RpcInterceptor() { // from class: com.alipay.iap.android.common.rpcintegration.RPCProxyHost.3
                @Override // com.alipay.imobile.network.quake.rpc.RpcInterceptor
                public final boolean preHandle(Object obj, ThreadLocal<Object> threadLocal, byte[] bArr, Class<?> cls2, Method method, Object[] objArr, String str, ThreadLocal<Map<String, Object>> threadLocal2) throws RpcException {
                    return RpcInterceptorHost.this.preHandle(obj, threadLocal, bArr, cls2, method, objArr, str, threadLocal2);
                }

                @Override // com.alipay.imobile.network.quake.rpc.RpcInterceptor
                public final boolean postHandle(Object obj, ThreadLocal<Object> threadLocal, byte[] bArr, Class<?> cls2, Method method, Object[] objArr, String str) throws RpcException {
                    return RpcInterceptorHost.this.postHandle(obj, threadLocal, bArr, cls2, method, objArr, str);
                }

                @Override // com.alipay.imobile.network.quake.rpc.RpcInterceptor
                public final boolean exceptionHandle(Object obj, ThreadLocal<Object> threadLocal, byte[] bArr, Class<?> cls2, Method method, Object[] objArr, RpcException rpcException, String str) throws RpcException {
                    return RpcInterceptorHost.this.exceptionHandle(obj, threadLocal, bArr, cls2, method, objArr, rpcException, str);
                }
            });
        }
    }
}
