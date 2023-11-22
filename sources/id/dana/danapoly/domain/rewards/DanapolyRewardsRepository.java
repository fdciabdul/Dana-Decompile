package id.dana.danapoly.domain.rewards;

import id.dana.danapoly.domain.rewards.model.GetRewardResult;
import id.dana.danapoly.domain.rewards.model.GetRewardsParams;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/danapoly/domain/rewards/DanapolyRewardsRepository;", "", "Lid/dana/danapoly/domain/rewards/model/GetRewardsParams;", "p0", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/danapoly/domain/rewards/model/GetRewardResult;", "MyBillsEntityDataFactory", "(Lid/dana/danapoly/domain/rewards/model/GetRewardsParams;)Lkotlinx/coroutines/flow/Flow;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface DanapolyRewardsRepository {
    Flow<GetRewardResult> MyBillsEntityDataFactory(GetRewardsParams p0);
}
