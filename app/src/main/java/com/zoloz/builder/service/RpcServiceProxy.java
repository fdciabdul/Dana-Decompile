package com.zoloz.builder.service;

import android.text.TextUtils;
import com.alipay.mobile.security.bio.service.BioServiceManager;
import com.alipay.zoloz.config.ConfigCenter;
import com.fullstory.instrumentation.InstrumentInjector;
import com.zoloz.builder.buildconfig.AppUtils;
import com.zoloz.rpc.RpcConfig;
import com.zoloz.rpc.RpcProxyUtil;
import com.zoloz.rpc.encryption.EncryptionRPCService;
import com.zoloz.rpc.pb.PbInvocationHandler;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class RpcServiceProxy extends EncryptionRPCService {
    public static final String TAG = "RpcServiceProxy";
    private static Map<String, Object> config = new HashMap();
    private static String mRemoteUrl;
    private String customGW = null;

    @Override // com.alipay.mobile.security.bio.service.local.LocalService, com.alipay.mobile.security.bio.service.BioService
    public void onCreate(BioServiceManager bioServiceManager) {
        super.onCreate(bioServiceManager);
        InstrumentInjector.log_i(TAG, "onCreate");
        String remoteUrl = RpcConfig.getInstance().getRemoteUrl();
        this.customGW = remoteUrl;
        if (!TextUtils.isEmpty(remoteUrl)) {
            mRemoteUrl = this.customGW;
        }
        RpcConfig.getInstance().setConnectTimeout(10000);
        RpcConfig.getInstance().setReadTimeout(30000);
        RpcConfig.getInstance().setWorkspaceId((String) config.get("WORKSPACE_ID"));
        RpcConfig.getInstance().setAppId((String) config.get("APP_ID"));
        if (bioServiceManager == null || !AppUtils.isDebug(bioServiceManager.getBioApplicationContext())) {
            return;
        }
        RpcConfig.needCatchRpc = true;
    }

    @Override // com.zoloz.rpc.encryption.EncryptionRPCService
    public <T> T getEncryptionRpcProxy(Class<T> cls) {
        RpcConfig.getInstance().setWorkspaceId((String) config.get("WORKSPACE_ID"));
        RpcConfig.getInstance().setAppId((String) config.get("APP_ID"));
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new PbInvocationHandler());
    }

    @Override // com.zoloz.rpc.encryption.EncryptionRPCService, com.alipay.mobile.security.bio.service.local.rpc.BioRPCService
    public <T> T getRpcProxy(Class<T> cls) {
        RpcConfig.getInstance().setWorkspaceId((String) config.get("WORKSPACE_ID"));
        RpcConfig.getInstance().setAppId((String) config.get("APP_ID"));
        if (cls.getName().equals("com.zoloz.zhub.common.factor.facade.HummerH5Facade")) {
            return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, buildRpcImpl(cls));
        }
        return (T) super.getRpcProxy(cls);
    }

    @Override // com.zoloz.rpc.encryption.EncryptionRPCService
    public String getPublicKey() {
        return ConfigCenter.getInstance().getRSAPublicKey();
    }

    @Override // com.zoloz.rpc.encryption.EncryptionRPCService
    public String getMid() {
        Object frameworkValue = ConfigCenter.getInstance().getFrameworkValue("merchantId");
        return frameworkValue == null ? "" : String.valueOf(frameworkValue);
    }

    @Override // com.alipay.mobile.security.bio.service.local.rpc.BioRPCService
    public void setRemoteUrl(String str) {
        String str2 = this.customGW;
        if (str2 == null || str2.startsWith(SemanticAttributes.FaasTriggerValues.HTTP)) {
            RpcConfig.getInstance().setRemoteUrl(str);
        } else if (str != null) {
            try {
                str = str.replace(new URL(str).getHost(), this.customGW);
            } catch (MalformedURLException unused) {
            }
            RpcConfig.getInstance().setRemoteUrl(str);
        } else {
            RpcConfig.getInstance().setRemoteUrl(mRemoteUrl);
        }
    }

    @Override // com.alipay.mobile.security.bio.service.local.rpc.BioRPCService
    public void setExtProperties(Map<String, Object> map) {
        config.putAll(map);
    }

    private InvocationHandler buildRpcImpl(Class cls) {
        return new RpcProxyUtil().buildProxyObj(cls, this.mContext);
    }
}
