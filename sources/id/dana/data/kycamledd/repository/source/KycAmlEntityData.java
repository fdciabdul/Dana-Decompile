package id.dana.data.kycamledd.repository.source;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.kycamledd.repository.source.network.request.EddInfoRequest;
import id.dana.data.kycamledd.repository.source.network.response.EddConsultResponse;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/kycamledd/repository/source/KycAmlEntityData;", "", "Lio/reactivex/Observable;", "Lid/dana/data/kycamledd/repository/source/network/response/EddConsultResponse;", "getAmlEddConsult", "()Lio/reactivex/Observable;", "Lid/dana/data/kycamledd/repository/source/network/request/EddInfoRequest;", "eddInfoRequest", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "submitAmlEdd", "(Lid/dana/data/kycamledd/repository/source/network/request/EddInfoRequest;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface KycAmlEntityData {
    Observable<EddConsultResponse> getAmlEddConsult();

    Observable<BaseRpcResult> submitAmlEdd(EddInfoRequest eddInfoRequest);
}
