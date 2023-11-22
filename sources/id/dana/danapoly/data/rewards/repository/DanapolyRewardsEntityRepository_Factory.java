package id.dana.danapoly.data.rewards.repository;

import dagger.internal.Factory;
import id.dana.danapoly.data.rewards.repository.source.DanapolyRewardsDataFactory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DanapolyRewardsEntityRepository_Factory implements Factory<DanapolyRewardsEntityRepository> {
    private final Provider<DanapolyRewardsDataFactory> MyBillsEntityDataFactory;

    private DanapolyRewardsEntityRepository_Factory(Provider<DanapolyRewardsDataFactory> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static DanapolyRewardsEntityRepository_Factory PlaceComponentResult(Provider<DanapolyRewardsDataFactory> provider) {
        return new DanapolyRewardsEntityRepository_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanapolyRewardsEntityRepository(this.MyBillsEntityDataFactory.get());
    }
}
