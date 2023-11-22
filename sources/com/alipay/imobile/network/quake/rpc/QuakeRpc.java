package com.alipay.imobile.network.quake.rpc;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.imobile.network.quake.IQuake;
import com.alipay.imobile.network.quake.Quake;
import com.alipay.imobile.network.quake.QuakeConfig;
import com.alipay.mobile.common.rpc.RpcException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class QuakeRpc implements IQuakeRpc {
    private static IQuakeRpc c;

    /* renamed from: a  reason: collision with root package name */
    private Map<String, RpcInterceptor> f7055a = new HashMap();
    private IQuake b;

    protected QuakeRpc(Context context) {
        this.b = Quake.createInstance(context);
    }

    private void a(String str, RpcInterceptor rpcInterceptor) throws IllegalArgumentException {
        RpcInterceptor rpcInterceptor2;
        synchronized (this) {
            if (!TextUtils.isEmpty(str) && rpcInterceptor != null) {
                if (this.f7055a.containsKey(str) && (rpcInterceptor2 = this.f7055a.get(str)) != null && !rpcInterceptor2.equals(rpcInterceptor)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("The RPC interceptor to be registered with the key: ");
                    sb.append(str);
                    sb.append(" has exist");
                    String obj = sb.toString();
                    LoggerWrapper.e(Quake.TAG, obj);
                    throw new IllegalArgumentException(obj);
                }
                this.f7055a.put(str, rpcInterceptor);
            } else {
                throw new IllegalArgumentException("the input parameter can not be null");
            }
        }
    }

    public static IQuakeRpc createInstance(Context context) {
        IQuakeRpc iQuakeRpc;
        synchronized (QuakeRpc.class) {
            if (c == null) {
                c = new QuakeRpc(context);
            }
            iQuakeRpc = c;
        }
        return iQuakeRpc;
    }

    public static IQuakeRpc instance() throws RpcException {
        IQuakeRpc iQuakeRpc;
        synchronized (QuakeRpc.class) {
            iQuakeRpc = c;
            if (iQuakeRpc == null) {
                throw new RpcException((Integer) 9, "IQuakeRpc has not been initialized by createInstance(Context).");
            }
        }
        return iQuakeRpc;
    }

    @Override // com.alipay.imobile.network.quake.rpc.IQuakeRpc
    public IQuake getQuake() {
        IQuake iQuake;
        synchronized (this) {
            iQuake = this.b;
        }
        return iQuake;
    }

    @Override // com.alipay.imobile.network.quake.rpc.IQuakeRpc
    public QuakeConfig getRpcConfig(Object obj) {
        try {
            return ((RpcInvocationHandler) Proxy.getInvocationHandler(obj)).a();
        } catch (Throwable th) {
            LoggerWrapper.e("QuakeRpc", "getRpcConfig failed.", th);
            return new QuakeConfig("", "");
        }
    }

    @Override // com.alipay.imobile.network.quake.rpc.IQuakeRpc
    public RpcInterceptor getRpcInterceptor(Class<? extends Annotation> cls) {
        synchronized (this) {
            if (cls == null) {
                return null;
            }
            String name = cls.getName();
            if (TextUtils.isEmpty(name)) {
                return null;
            }
            return this.f7055a.get(name);
        }
    }

    @Override // com.alipay.imobile.network.quake.rpc.IQuakeRpc
    public <T> T getRpcProxy(Class<T> cls) throws IllegalArgumentException {
        T t;
        synchronized (this) {
            if (cls != null) {
                t = (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new RpcInvocationHandler(instance(), cls));
            } else {
                throw new IllegalArgumentException("the input parameter can not be null");
            }
        }
        return t;
    }

    @Override // com.alipay.imobile.network.quake.rpc.IQuakeRpc
    public void registerRpcInterceptor(Class<? extends Annotation> cls, RpcInterceptor rpcInterceptor) throws IllegalArgumentException {
        synchronized (this) {
            if (cls != null) {
                if (!TextUtils.isEmpty(cls.getName()) && rpcInterceptor != null) {
                    a(cls.getName(), rpcInterceptor);
                }
            }
            throw new IllegalArgumentException("the input parameter can not be null");
        }
    }

    @Override // com.alipay.imobile.network.quake.rpc.IQuakeRpc
    public void release() {
        synchronized (this) {
            if (c == null) {
                return;
            }
            c = null;
            IQuake iQuake = this.b;
            if (iQuake != null) {
                iQuake.release();
                this.b = null;
            }
            Map<String, RpcInterceptor> map = this.f7055a;
            if (map != null) {
                map.clear();
                this.f7055a = null;
            }
        }
    }
}
