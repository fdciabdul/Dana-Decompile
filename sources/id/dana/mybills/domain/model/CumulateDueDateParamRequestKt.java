package id.dana.mybills.domain.model;

import id.dana.mybills.data.model.request.CumulateDueDatePaylaterRequest;
import id.dana.mybills.data.model.request.PagingInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/domain/model/CumulateDueDateParamRequest;", "Lid/dana/mybills/data/model/request/CumulateDueDatePaylaterRequest;", "toCumulateDueDatePaylaterRequest", "(Lid/dana/mybills/domain/model/CumulateDueDateParamRequest;)Lid/dana/mybills/data/model/request/CumulateDueDatePaylaterRequest;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CumulateDueDateParamRequestKt {
    public static final CumulateDueDatePaylaterRequest toCumulateDueDatePaylaterRequest(CumulateDueDateParamRequest cumulateDueDateParamRequest) {
        Intrinsics.checkNotNullParameter(cumulateDueDateParamRequest, "");
        return new CumulateDueDatePaylaterRequest(cumulateDueDateParamRequest.getCumulateDueDateType(), new PagingInfo(cumulateDueDateParamRequest.getPageNumber(), cumulateDueDateParamRequest.getPageSize()));
    }
}
