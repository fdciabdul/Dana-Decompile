package id.dana.danapoly.data.rewards.mapper;

import id.dana.danapoly.data.rewards.model.request.DanapolyPaginationInfoRequest;
import id.dana.danapoly.data.rewards.model.request.GetRewardsRequest;
import id.dana.danapoly.domain.rewards.model.GetRewardsParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003"}, d2 = {"Lid/dana/danapoly/domain/rewards/model/GetRewardsParams;", "Lid/dana/danapoly/data/rewards/model/request/GetRewardsRequest;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/danapoly/domain/rewards/model/GetRewardsParams;)Lid/dana/danapoly/data/rewards/model/request/GetRewardsRequest;", "PlaceComponentResult"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetRewardsRequestMapperKt {
    public static final GetRewardsRequest PlaceComponentResult(GetRewardsParams getRewardsParams) {
        Intrinsics.checkNotNullParameter(getRewardsParams, "");
        String eventId = getRewardsParams.getEventId();
        List<String> types = getRewardsParams.getTypes();
        if ((!types.isEmpty()) == false) {
            types = null;
        }
        List<String> statuses = getRewardsParams.getStatuses();
        List<String> list = !(statuses.isEmpty() ^ true) ? null : statuses;
        String sort = getRewardsParams.getSort();
        return new GetRewardsRequest(eventId, types, list, !(sort.length() > 0) ? null : sort, new DanapolyPaginationInfoRequest(1, 1), new DanapolyPaginationInfoRequest(getRewardsParams.getPageNum(), getRewardsParams.getPageSize()));
    }

    public static final GetRewardsRequest BuiltInFictitiousFunctionClassFactory(GetRewardsParams getRewardsParams) {
        Intrinsics.checkNotNullParameter(getRewardsParams, "");
        String eventId = getRewardsParams.getEventId();
        List<String> types = getRewardsParams.getTypes();
        if ((!types.isEmpty()) == false) {
            types = null;
        }
        List<String> statuses = getRewardsParams.getStatuses();
        List<String> list = !(statuses.isEmpty() ^ true) ? null : statuses;
        String sort = getRewardsParams.getSort();
        return new GetRewardsRequest(eventId, types, list, !(sort.length() > 0) ? null : sort, new DanapolyPaginationInfoRequest(getRewardsParams.getPageNum(), getRewardsParams.getPageSize()), new DanapolyPaginationInfoRequest(1, 10));
    }
}
