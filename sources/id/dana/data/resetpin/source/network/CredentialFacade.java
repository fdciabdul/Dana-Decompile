package id.dana.data.resetpin.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.resetpin.model.ConsultForceDanaVizEnrollResult;
import id.dana.data.resetpin.model.CountPinChangeRequest;
import id.dana.data.resetpin.model.CountPinChangeResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u000e\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/resetpin/source/network/CredentialFacade;", "", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "request", "Lid/dana/data/resetpin/model/ConsultForceDanaVizEnrollResult;", "consultForceDanaVizEnroll", "(Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;)Lid/dana/data/resetpin/model/ConsultForceDanaVizEnrollResult;", "Lid/dana/data/resetpin/model/CountPinChangeRequest;", "Lid/dana/data/resetpin/model/CountPinChangeResult;", "countPinChange", "(Lid/dana/data/resetpin/model/CountPinChangeRequest;)Lid/dana/data/resetpin/model/CountPinChangeResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "finishForceDanaVizEnroll", "(Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;)Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "selfUnfreeze"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface CredentialFacade {
    @OperationType("id.dana.userprod.user.consult.force.face.auth")
    @SignCheck
    ConsultForceDanaVizEnrollResult consultForceDanaVizEnroll(BaseRpcRequest request);

    @OperationType("id.dana.userprod.user.count.pin.change")
    @SignCheck
    CountPinChangeResult countPinChange(CountPinChangeRequest request);

    @OperationType("id.dana.userprod.user.finish.force.face.auth")
    @SignCheck
    BaseRpcResult finishForceDanaVizEnroll(BaseRpcRequest request);

    @OperationType("id.dana.userprod.user.self.unfreeze")
    @SignCheck
    BaseRpcResult selfUnfreeze(BaseRpcRequest request);
}
