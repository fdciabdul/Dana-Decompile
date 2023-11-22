package id.dana.danapoly.domain.rewards.interactor;

import id.dana.danapoly.domain.config.DanapolyConfigRepository;
import id.dana.danapoly.domain.rewards.DanapolyRewardsRepository;
import id.dana.danapoly.domain.rewards.model.GetRewardResult;
import id.dana.danapoly.domain.rewards.model.GetRewardsParams;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/danapoly/domain/rewards/interactor/GetRewardList;", "Lid/dana/domain/core/usecase/BaseFlowUseCase;", "Lid/dana/danapoly/domain/rewards/model/GetRewardsParams;", "Lid/dana/danapoly/domain/rewards/model/GetRewardResult;", "Lid/dana/danapoly/domain/config/DanapolyConfigRepository;", "MyBillsEntityDataFactory", "Lid/dana/danapoly/domain/config/DanapolyConfigRepository;", "Lid/dana/danapoly/domain/rewards/DanapolyRewardsRepository;", "getAuthRequestContext", "Lid/dana/danapoly/domain/rewards/DanapolyRewardsRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "<init>", "(Lid/dana/danapoly/domain/config/DanapolyConfigRepository;Lid/dana/danapoly/domain/rewards/DanapolyRewardsRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetRewardList extends BaseFlowUseCase<GetRewardsParams, GetRewardResult> {
    private final DanapolyConfigRepository MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final DanapolyRewardsRepository KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.domain.core.usecase.BaseFlowUseCase
    public final /* synthetic */ Flow<GetRewardResult> buildUseCase(GetRewardsParams getRewardsParams) {
        GetRewardsParams getRewardsParams2 = getRewardsParams;
        Intrinsics.checkNotNullParameter(getRewardsParams2, "");
        return FlowKt.transformLatest(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(), new GetRewardList$buildUseCase$$inlined$flatMapLatest$1(null, getRewardsParams2, this));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineDispatcher] */
    @javax.inject.Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public GetRewardList(id.dana.danapoly.domain.config.DanapolyConfigRepository r3, id.dana.danapoly.domain.rewards.DanapolyRewardsRepository r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            r2.MyBillsEntityDataFactory = r3
            r2.KClassImpl$Data$declaredNonStaticMembers$2 = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danapoly.domain.rewards.interactor.GetRewardList.<init>(id.dana.danapoly.domain.config.DanapolyConfigRepository, id.dana.danapoly.domain.rewards.DanapolyRewardsRepository):void");
    }
}
