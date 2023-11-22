package com.iap.ac.android.rpc;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.mobile.framework.service.annotation.OperationType;
import com.iap.ac.android.common.rpc.RPCProxyHost;
import com.iap.ac.android.common.rpc.RpcAppInfo;
import com.iap.ac.android.common.rpc.http.HttpTransportFactory;
import com.iap.ac.android.common.rpc.interfaces.AbstractHttpTransport;
import com.iap.ac.android.common.rpc.interfaces.FacadeInvoker;
import com.iap.ac.android.common.rpc.interfaces.RpcInterceptor;
import com.iap.ac.android.common.rpc.interfaces.SignRpcRequestPlugin;
import com.iap.ac.android.common.rpc.interfaces.SignV2RpcRequestPlugin;
import com.iap.ac.android.common.rpc.interfaces.SslPinningPlugin;
import com.iap.ac.android.rpc.http.impl.HttpUrlTransport;
import com.iap.ac.android.rpc.utils.RpcUtils;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class RpcProxyImpl implements RPCProxyHost.IRPCProxy {
    public static final RpcProxyImpl INSTANCE = new RpcProxyImpl("");
    public static final String TAG = RpcUtils.logTag("RpcProxyImpl");
    public static final Map<String, RpcProxyImpl> instanceMap = new HashMap();
    public String bizCode;
    public Context mContext;
    public FacadeInvoker mDefaultFacadeInvoker;
    public SignRpcRequestPlugin mRpcSignPlugin;
    public SignV2RpcRequestPlugin mRpcSignV2Plugin;
    public SslPinningPlugin mSslPinningPlugin;
    public final Map<String, FacadeInvoker> mFacadeInvokerMap = new HashMap();
    public final CopyOnWriteArrayList<RpcInterceptor> mRpcInterceptors = new CopyOnWriteArrayList<>();
    public RpcAppInfo mRpcAppInfo = new RpcAppInfo();
    public boolean mCanMonit = true;

    public RpcProxyImpl(String str) {
        this.bizCode = "";
        this.bizCode = str;
        this.mDefaultFacadeInvoker = new BaseRpcFacadeInvoker(this, str);
    }

    public static RpcProxyImpl getInstance(String str) {
        if (TextUtils.isEmpty(str)) {
            return getInstance();
        }
        Map<String, RpcProxyImpl> map = instanceMap;
        RpcProxyImpl rpcProxyImpl = map.get(str);
        if (rpcProxyImpl == null) {
            RpcProxyImpl rpcProxyImpl2 = new RpcProxyImpl(str);
            map.put(str, rpcProxyImpl2);
            return rpcProxyImpl2;
        }
        return rpcProxyImpl;
    }

    public static String getRpcOperationType(Method method) {
        OperationType operationType = (OperationType) method.getAnnotation(OperationType.class);
        if (operationType != null) {
            return operationType.value();
        }
        return null;
    }

    @Override // com.iap.ac.android.common.rpc.RPCProxyHost.IRPCProxy
    public void addRpcInterceptor(RpcInterceptor rpcInterceptor) {
        this.mRpcInterceptors.add(rpcInterceptor);
    }

    @Override // com.iap.ac.android.common.rpc.RPCProxyHost.IRPCProxy
    public void clearRpcInterceptors() {
        this.mRpcInterceptors.clear();
    }

    public void customizeRpcFacadeInvoker(String str, FacadeInvoker facadeInvoker) {
        this.mFacadeInvokerMap.put(str, facadeInvoker);
    }

    public Context getApplicationContext() {
        return this.mContext;
    }

    @Override // com.iap.ac.android.common.rpc.RPCProxyHost.IRPCProxy
    public <T> T getInterfaceProxy(Class<T> cls) {
        T t = (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new RpcInvocationHandler(this.bizCode));
        if (cls.isInstance(t)) {
            return t;
        }
        return null;
    }

    public RpcAppInfo getRpcAppInfo() {
        return this.mRpcAppInfo;
    }

    public FacadeInvoker getRpcFacadeInvoker(String str) {
        FacadeInvoker facadeInvoker = this.mFacadeInvokerMap.get(str);
        return facadeInvoker == null ? this.mDefaultFacadeInvoker : facadeInvoker;
    }

    public List<RpcInterceptor> getRpcInterceptors() {
        return this.mRpcInterceptors;
    }

    public SslPinningPlugin getSslPinningPlugin() {
        return this.mSslPinningPlugin;
    }

    public void initialize(Context context, RpcAppInfo rpcAppInfo) {
        this.mContext = context.getApplicationContext();
        this.mRpcAppInfo = rpcAppInfo;
        if (HttpTransportFactory.getCreater() == null) {
            HttpTransportFactory.setCreater(new HttpTransportFactory.Creater() { // from class: com.iap.ac.android.rpc.RpcProxyImpl.1
                @Override // com.iap.ac.android.common.rpc.http.HttpTransportFactory.Creater
                public AbstractHttpTransport createHttpTransport(Context context2) throws Exception {
                    return new HttpUrlTransport(false, context2);
                }
            });
        }
    }

    public boolean isCanMonit() {
        return this.mCanMonit;
    }

    @Override // com.iap.ac.android.common.rpc.RPCProxyHost.IRPCProxy
    public void removeRpcInterceptor(RpcInterceptor rpcInterceptor) {
        this.mRpcInterceptors.remove(rpcInterceptor);
    }

    public void setCanMonit(boolean z) {
        this.mCanMonit = z;
    }

    @Override // com.iap.ac.android.common.rpc.RPCProxyHost.IRPCProxy
    public void setSignRequest(SignRpcRequestPlugin signRpcRequestPlugin) {
        this.mRpcSignPlugin = signRpcRequestPlugin;
    }

    @Override // com.iap.ac.android.common.rpc.RPCProxyHost.IRPCProxy
    public void setSignV2Request(SignV2RpcRequestPlugin signV2RpcRequestPlugin) {
        this.mRpcSignV2Plugin = signV2RpcRequestPlugin;
    }

    @Override // com.iap.ac.android.common.rpc.RPCProxyHost.IRPCProxy
    public void setSslPinningPlugin(SslPinningPlugin sslPinningPlugin) {
        this.mSslPinningPlugin = sslPinningPlugin;
    }

    public String signRequest(RpcAppInfo rpcAppInfo, String str, Map<String, String> map) {
        SignRpcRequestPlugin signRpcRequestPlugin = this.mRpcSignPlugin;
        if (signRpcRequestPlugin == null) {
            return null;
        }
        return signRpcRequestPlugin.signRequest(rpcAppInfo, str, map);
    }

    public String signV2Request(RpcAppInfo rpcAppInfo, String str, String str2, Map<String, String> map) {
        SignV2RpcRequestPlugin signV2RpcRequestPlugin = this.mRpcSignV2Plugin;
        if (signV2RpcRequestPlugin == null) {
            return null;
        }
        return signV2RpcRequestPlugin.signV2Request(rpcAppInfo, str, str2, map);
    }

    @Override // com.iap.ac.android.common.rpc.RPCProxyHost.IRPCProxy
    public <T> T getInterfaceProxy(Class<T> cls, RPCProxyHost.RpcInvocationHandlerListener rpcInvocationHandlerListener) {
        T t = (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new RpcInvocationHandler(this.bizCode, rpcInvocationHandlerListener));
        if (cls.isInstance(t)) {
            return t;
        }
        return null;
    }

    public static RpcProxyImpl getInstance() {
        return INSTANCE;
    }
}
