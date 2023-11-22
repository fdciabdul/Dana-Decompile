package id.dana.data.citcall.mapper;

import id.dana.data.citcall.source.network.request.MiscallRequest;
import id.dana.domain.citcall.model.MiscallConsult;
import id.dana.domain.citcall.model.MiscallResponse;
import id.dana.network.response.citcall.MiscallResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/domain/citcall/model/MiscallConsult;", "Lid/dana/data/citcall/source/network/request/MiscallRequest;", "toMiscallRequest", "(Lid/dana/domain/citcall/model/MiscallConsult;)Lid/dana/data/citcall/source/network/request/MiscallRequest;", "Lid/dana/network/response/citcall/MiscallResult;", "Lid/dana/domain/citcall/model/MiscallResponse;", "toMiscallResponse", "(Lid/dana/network/response/citcall/MiscallResult;)Lid/dana/domain/citcall/model/MiscallResponse;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CitcallMapperKt {
    public static final MiscallRequest toMiscallRequest(MiscallConsult miscallConsult) {
        Intrinsics.checkNotNullParameter(miscallConsult, "");
        return new MiscallRequest(miscallConsult.getLoginId(), miscallConsult.getLoginIdType(), miscallConsult.getUseCase(), miscallConsult.getBizId());
    }

    public static final MiscallResponse toMiscallResponse(MiscallResult miscallResult) {
        Intrinsics.checkNotNullParameter(miscallResult, "");
        MiscallResponse miscallResponse = new MiscallResponse(miscallResult.getPrefix(), miscallResult.getCurrentAttempts(), miscallResult.getRemainingAttempts(), miscallResult.getTimeUntilNextAttempt(), miscallResult.getLastRequestTime());
        miscallResponse.setErrorMsg(miscallResult.getErrorMsg());
        return miscallResponse;
    }
}
