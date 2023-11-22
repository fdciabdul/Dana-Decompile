package com.zoloz.rpc.encryption;

import com.alipay.mobile.security.bio.service.local.rpc.BioRPCService;
import java.lang.reflect.Proxy;

/* loaded from: classes8.dex */
public abstract class EncryptionRPCService extends BioRPCService {
    public abstract <T> T getEncryptionRpcProxy(Class<T> cls);

    /* JADX INFO: Access modifiers changed from: protected */
    public String getMid() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String getPublicKey();

    protected boolean isUseEncryption() {
        return true;
    }

    protected EncryptionRequest modifyRequest(EncryptionRequest encryptionRequest) {
        return encryptionRequest;
    }

    @Override // com.alipay.mobile.security.bio.service.local.rpc.BioRPCService
    public <T> T getRpcProxy(Class<T> cls) {
        if (isUseEncryption()) {
            return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new EncryptionProxyInvocationHandler(this, cls));
        }
        return (T) getEncryptionRpcProxy(cls);
    }
}
