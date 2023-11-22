package com.zoloz.rpc.encryption;

import com.alipay.mobile.framework.service.annotation.OperationType;

/* loaded from: classes8.dex */
public interface RpcFacade$f60fd6a58d1add367082dd7569a2be55 extends BaseEncryptionFacade {
    @Override // com.zoloz.rpc.encryption.BaseEncryptionFacade
    @OperationType("com.zoloz.zhub.zim.init.pb.v2.sec")
    EncryptionResponse execute(EncryptionRequest encryptionRequest);
}
