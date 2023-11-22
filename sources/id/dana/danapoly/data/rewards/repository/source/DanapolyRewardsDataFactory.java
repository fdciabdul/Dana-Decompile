package id.dana.danapoly.data.rewards.repository.source;

import id.dana.danapoly.data.rewards.repository.source.network.NetworkDanapolyRewardsData;
import id.dana.data.AbstractEntityDataFactory;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/danapoly/data/rewards/repository/source/DanapolyRewardsDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/danapoly/data/rewards/repository/source/DanapolyRewardsData;", "Lid/dana/danapoly/data/rewards/repository/source/network/NetworkDanapolyRewardsData;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/danapoly/data/rewards/repository/source/network/NetworkDanapolyRewardsData;", "getAuthRequestContext", "p0", "<init>", "(Lid/dana/danapoly/data/rewards/repository/source/network/NetworkDanapolyRewardsData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanapolyRewardsDataFactory extends AbstractEntityDataFactory<DanapolyRewardsData> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final NetworkDanapolyRewardsData getAuthRequestContext;

    @Inject
    public DanapolyRewardsDataFactory(NetworkDanapolyRewardsData networkDanapolyRewardsData) {
        Intrinsics.checkNotNullParameter(networkDanapolyRewardsData, "");
        this.getAuthRequestContext = networkDanapolyRewardsData;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final /* bridge */ /* synthetic */ DanapolyRewardsData createData2(String str) {
        return this.getAuthRequestContext;
    }
}
