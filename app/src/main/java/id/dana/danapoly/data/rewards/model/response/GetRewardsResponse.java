package id.dana.danapoly.data.rewards.model.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\r\u0010\u000eR\u001f\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/danapoly/data/rewards/model/response/GetRewardsResponse;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "Lid/dana/danapoly/data/rewards/model/response/RewardResponse;", "rewards", "Ljava/util/List;", "getRewards", "()Ljava/util/List;", "Lid/dana/danapoly/data/rewards/model/response/PaginatorResponse;", "rewardsPaginator", "Lid/dana/danapoly/data/rewards/model/response/PaginatorResponse;", "getRewardsPaginator", "()Lid/dana/danapoly/data/rewards/model/response/PaginatorResponse;", "<init>", "(Ljava/util/List;Lid/dana/danapoly/data/rewards/model/response/PaginatorResponse;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetRewardsResponse extends BaseRpcResult {
    private final List<RewardResponse> rewards;
    private final PaginatorResponse rewardsPaginator;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker, id.dana.danapoly.data.rewards.model.response.PaginatorResponse] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public GetRewardsResponse() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danapoly.data.rewards.model.response.GetRewardsResponse.<init>():void");
    }

    public /* synthetic */ GetRewardsResponse(List list, PaginatorResponse paginatorResponse, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? new PaginatorResponse(null, null, null, 7, null) : paginatorResponse);
    }

    @JvmName(name = "getRewards")
    public final List<RewardResponse> getRewards() {
        return this.rewards;
    }

    @JvmName(name = "getRewardsPaginator")
    public final PaginatorResponse getRewardsPaginator() {
        return this.rewardsPaginator;
    }

    public GetRewardsResponse(List<RewardResponse> list, PaginatorResponse paginatorResponse) {
        this.rewards = list;
        this.rewardsPaginator = paginatorResponse;
    }
}
