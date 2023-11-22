package id.dana.data.security.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.data.security.source.network.request.GetPublicKeyRpcRequest;
import id.dana.data.security.source.network.result.GetPublicKeyRpcResult;

/* loaded from: classes4.dex */
public interface GetPublicKeyRpcFacade {
    @OperationType("alipayplus.mobilewallet.security.get.publickey")
    @SignCheck
    GetPublicKeyRpcResult fetchPublicKey(GetPublicKeyRpcRequest getPublicKeyRpcRequest);
}
