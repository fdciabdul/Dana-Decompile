package id.dana.data.cancelsurvey.repository.source.network.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/data/cancelsurvey/repository/source/network/response/SurveyCancelReasonConsultResponse;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "Lid/dana/data/cancelsurvey/repository/source/network/response/SurveyCancelReasonDTOResponse;", "cancelReasons", "Ljava/util/List;", "getCancelReasons", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SurveyCancelReasonConsultResponse extends BaseRpcResult {
    private final List<SurveyCancelReasonDTOResponse> cancelReasons;

    @JvmName(name = "getCancelReasons")
    public final List<SurveyCancelReasonDTOResponse> getCancelReasons() {
        return this.cancelReasons;
    }

    public SurveyCancelReasonConsultResponse(List<SurveyCancelReasonDTOResponse> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.cancelReasons = list;
    }
}
