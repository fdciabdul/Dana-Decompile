package id.dana.data.merchantmanagement;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import id.dana.data.merchantmanagement.repository.source.network.request.UnbindMerchantRequest;
import id.dana.data.merchantmanagement.repository.source.network.result.BoundMerchantResult;
import id.dana.data.merchantmanagement.repository.source.network.result.UnbindConsultResult;
import id.dana.data.merchantmanagement.repository.source.network.result.UnbindEligibilityCheckResult;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J/\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0010\u0010\tJ\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0014\u0010\u0015ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/merchantmanagement/MerchantManagementEntityData;", "", "", "clientId", "merchantId", "divisionId", "Lio/reactivex/Observable;", "Lid/dana/data/merchantmanagement/repository/source/network/result/UnbindEligibilityCheckResult;", "checkUnbindEligibility", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "", ZdocRecordService.PAGE_NUMBER, "Lid/dana/data/merchantmanagement/repository/source/network/result/BoundMerchantResult;", "getLinkedMerchants", "(I)Lio/reactivex/Observable;", "Lid/dana/data/merchantmanagement/repository/source/network/result/UnbindConsultResult;", "unbindConsult", "Lid/dana/data/merchantmanagement/repository/source/network/request/UnbindMerchantRequest;", "unbindMerchantRequest", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "unbindMerchant", "(Lid/dana/data/merchantmanagement/repository/source/network/request/UnbindMerchantRequest;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface MerchantManagementEntityData {
    Observable<UnbindEligibilityCheckResult> checkUnbindEligibility(String clientId, String merchantId, String divisionId);

    Observable<BoundMerchantResult> getLinkedMerchants(int r1);

    Observable<UnbindConsultResult> unbindConsult(String clientId, String merchantId, String divisionId);

    Observable<BaseRpcResult> unbindMerchant(UnbindMerchantRequest unbindMerchantRequest);
}
