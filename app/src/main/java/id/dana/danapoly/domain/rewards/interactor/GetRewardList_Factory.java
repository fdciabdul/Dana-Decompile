package id.dana.danapoly.domain.rewards.interactor;

import dagger.internal.Factory;
import id.dana.danapoly.domain.config.DanapolyConfigRepository;
import id.dana.danapoly.domain.rewards.DanapolyRewardsRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetRewardList_Factory implements Factory<GetRewardList> {
    private final Provider<DanapolyRewardsRepository> BuiltInFictitiousFunctionClassFactory;
    private final Provider<DanapolyConfigRepository> PlaceComponentResult;

    private GetRewardList_Factory(Provider<DanapolyConfigRepository> provider, Provider<DanapolyRewardsRepository> provider2) {
        this.PlaceComponentResult = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
    }

    public static GetRewardList_Factory BuiltInFictitiousFunctionClassFactory(Provider<DanapolyConfigRepository> provider, Provider<DanapolyRewardsRepository> provider2) {
        return new GetRewardList_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetRewardList(this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
