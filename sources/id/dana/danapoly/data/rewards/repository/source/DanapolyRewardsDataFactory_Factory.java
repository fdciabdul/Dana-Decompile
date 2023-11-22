package id.dana.danapoly.data.rewards.repository.source;

import dagger.internal.Factory;
import id.dana.danapoly.data.rewards.repository.source.network.NetworkDanapolyRewardsData;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DanapolyRewardsDataFactory_Factory implements Factory<DanapolyRewardsDataFactory> {
    private final Provider<NetworkDanapolyRewardsData> PlaceComponentResult;

    private DanapolyRewardsDataFactory_Factory(Provider<NetworkDanapolyRewardsData> provider) {
        this.PlaceComponentResult = provider;
    }

    public static DanapolyRewardsDataFactory_Factory PlaceComponentResult(Provider<NetworkDanapolyRewardsData> provider) {
        return new DanapolyRewardsDataFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanapolyRewardsDataFactory(this.PlaceComponentResult.get());
    }
}
