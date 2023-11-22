package id.dana.data.merchantmanagement.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.merchantmanagement.repository.source.network.request.BoundMerchantRequest;
import id.dana.data.merchantmanagement.repository.source.network.request.UnbindConsultRequest;
import id.dana.data.merchantmanagement.repository.source.network.request.UnbindEligibilityCheckRequest;
import id.dana.data.merchantmanagement.repository.source.network.request.UnbindMerchantRequest;
import id.dana.data.merchantmanagement.repository.source.network.result.BoundMerchantResult;
import id.dana.data.merchantmanagement.repository.source.network.result.UnbindConsultResult;
import id.dana.data.merchantmanagement.repository.source.network.result.UnbindEligibilityCheckResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/merchantmanagement/repository/source/network/MerchantManagementFacade;", "", "Lid/dana/data/merchantmanagement/repository/source/network/request/UnbindEligibilityCheckRequest;", "unbindEligibilityCheckRequest", "Lid/dana/data/merchantmanagement/repository/source/network/result/UnbindEligibilityCheckResult;", "checkUnbindEligibility", "(Lid/dana/data/merchantmanagement/repository/source/network/request/UnbindEligibilityCheckRequest;)Lid/dana/data/merchantmanagement/repository/source/network/result/UnbindEligibilityCheckResult;", "Lid/dana/data/merchantmanagement/repository/source/network/request/BoundMerchantRequest;", "boundMerchantRequest", "Lid/dana/data/merchantmanagement/repository/source/network/result/BoundMerchantResult;", "getLinkedMerchants", "(Lid/dana/data/merchantmanagement/repository/source/network/request/BoundMerchantRequest;)Lid/dana/data/merchantmanagement/repository/source/network/result/BoundMerchantResult;", "Lid/dana/data/merchantmanagement/repository/source/network/request/UnbindConsultRequest;", "unbindConsultRequest", "Lid/dana/data/merchantmanagement/repository/source/network/result/UnbindConsultResult;", "unbindConsult", "(Lid/dana/data/merchantmanagement/repository/source/network/request/UnbindConsultRequest;)Lid/dana/data/merchantmanagement/repository/source/network/result/UnbindConsultResult;", "Lid/dana/data/merchantmanagement/repository/source/network/request/UnbindMerchantRequest;", "unbindMerchantRequest", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "unbindMerchant", "(Lid/dana/data/merchantmanagement/repository/source/network/request/UnbindMerchantRequest;)Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface MerchantManagementFacade {
    @OperationType("alipayplus.mobilewallet.user.merchant.unbind.checkEligibility")
    @SignCheck
    UnbindEligibilityCheckResult checkUnbindEligibility(UnbindEligibilityCheckRequest unbindEligibilityCheckRequest);

    @OperationType("alipayplus.mobilewallet.user.merchant.list")
    @SignCheck
    BoundMerchantResult getLinkedMerchants(BoundMerchantRequest boundMerchantRequest);

    @OperationType("alipayplus.mobilewallet.user.merchant.unbind.consult")
    @SignCheck
    UnbindConsultResult unbindConsult(UnbindConsultRequest unbindConsultRequest);

    @OperationType("alipayplus.mobilewallet.user.merchant.unbind")
    @SignCheck
    BaseRpcResult unbindMerchant(UnbindMerchantRequest unbindMerchantRequest);
}
