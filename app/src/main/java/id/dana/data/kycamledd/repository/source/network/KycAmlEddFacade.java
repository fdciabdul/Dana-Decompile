package id.dana.data.kycamledd.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.kycamledd.repository.source.network.request.EddInfoRequest;
import id.dana.data.kycamledd.repository.source.network.response.EddConsultResponse;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/kycamledd/repository/source/network/KycAmlEddFacade;", "", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "request", "Lid/dana/data/kycamledd/repository/source/network/response/EddConsultResponse;", "consultEdd", "(Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;)Lid/dana/data/kycamledd/repository/source/network/response/EddConsultResponse;", "Lid/dana/data/kycamledd/repository/source/network/request/EddInfoRequest;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "submitEdd", "(Lid/dana/data/kycamledd/repository/source/network/request/EddInfoRequest;)Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface KycAmlEddFacade {
    @OperationType("alipayplus.mobilewallet.user.edd.consult")
    @SignCheck
    EddConsultResponse consultEdd(BaseRpcRequest request);

    @OperationType("alipayplus.mobilewallet.user.edd.submit")
    @SignCheck
    BaseRpcResult submitEdd(EddInfoRequest request);
}
