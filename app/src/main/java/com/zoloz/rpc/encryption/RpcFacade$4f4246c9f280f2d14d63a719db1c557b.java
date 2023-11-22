package com.zoloz.rpc.encryption;

import com.alipay.mobile.framework.service.annotation.OperationType;

/* loaded from: classes8.dex */
public interface RpcFacade$4f4246c9f280f2d14d63a719db1c557b extends BaseEncryptionFacade {
    @Override // com.zoloz.rpc.encryption.BaseEncryptionFacade
    @OperationType("com.zoloz.zhub.factor.next.sec")
    EncryptionResponse execute(EncryptionRequest encryptionRequest);
}
