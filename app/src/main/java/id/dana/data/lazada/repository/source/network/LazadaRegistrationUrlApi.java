package id.dana.data.lazada.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.data.lazada.repository.source.network.request.LazadaRegistrationUrlRequest;
import id.dana.data.lazada.repository.source.network.response.LazadaRegistrationUrlResult;

/* loaded from: classes2.dex */
public interface LazadaRegistrationUrlApi {
    @OperationType("alipayplus.mobilewallet.ipg.register.url.consult")
    @SignCheck
    LazadaRegistrationUrlResult getRegistrationUrl(LazadaRegistrationUrlRequest lazadaRegistrationUrlRequest);
}
