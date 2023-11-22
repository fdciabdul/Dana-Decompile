package id.dana.data.verifytoken.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.data.verifytoken.repository.source.network.request.VerifyTokenRequest;
import id.dana.data.verifytoken.repository.source.network.result.VerifyTokenResult;

/* loaded from: classes4.dex */
public interface VerifyTokenFacade {
    @OperationType("alipayplus.mobilewallet.risk.getverifytoken")
    @SignCheck
    VerifyTokenResult getVerifyToken(VerifyTokenRequest verifyTokenRequest);
}
