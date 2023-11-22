package id.dana.danapoly.domain.rewards.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/danapoly/domain/rewards/model/GetRewardResult;", "", "", "Lid/dana/danapoly/domain/rewards/model/RewardList;", "allRewards", "Ljava/util/List;", "getAllRewards", "()Ljava/util/List;", "Lid/dana/danapoly/domain/rewards/model/PaginatorInfo;", "rewardsPaginator", "Lid/dana/danapoly/domain/rewards/model/PaginatorInfo;", "getRewardsPaginator", "()Lid/dana/danapoly/domain/rewards/model/PaginatorInfo;", "<init>", "(Ljava/util/List;Lid/dana/danapoly/domain/rewards/model/PaginatorInfo;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetRewardResult {
    private final List<RewardList> allRewards;
    private final PaginatorInfo rewardsPaginator;

    public GetRewardResult(List<RewardList> list, PaginatorInfo paginatorInfo) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(paginatorInfo, "");
        this.allRewards = list;
        this.rewardsPaginator = paginatorInfo;
    }

    @JvmName(name = "getAllRewards")
    public final List<RewardList> getAllRewards() {
        return this.allRewards;
    }

    @JvmName(name = "getRewardsPaginator")
    public final PaginatorInfo getRewardsPaginator() {
        return this.rewardsPaginator;
    }
}
