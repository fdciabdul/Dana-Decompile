package id.dana.danapoly.data.mapper;

import id.dana.danapoly.data.rewards.model.response.PaginatorResponse;
import id.dana.danapoly.domain.rewards.model.PaginatorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/danapoly/data/rewards/model/response/PaginatorResponse;", "Lid/dana/danapoly/domain/rewards/model/PaginatorInfo;", "MyBillsEntityDataFactory", "(Lid/dana/danapoly/data/rewards/model/response/PaginatorResponse;)Lid/dana/danapoly/domain/rewards/model/PaginatorInfo;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaginatorResponseMapperKt {
    public static final PaginatorInfo MyBillsEntityDataFactory(PaginatorResponse paginatorResponse) {
        Intrinsics.checkNotNullParameter(paginatorResponse, "");
        Integer page = paginatorResponse.getPage();
        int intValue = page != null ? page.intValue() : 0;
        Integer size = paginatorResponse.getSize();
        int intValue2 = size != null ? size.intValue() : 0;
        Boolean hasMore = paginatorResponse.getHasMore();
        return new PaginatorInfo(intValue, intValue2, hasMore != null ? hasMore.booleanValue() : false);
    }
}
