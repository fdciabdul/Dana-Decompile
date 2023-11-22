package id.dana.danapoly.ui.cards.viewmodel;

import dagger.internal.Factory;
import id.dana.danapoly.domain.rewards.interactor.GetRewardList;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DanapolyCardsViewModel_Factory implements Factory<DanapolyCardsViewModel> {
    private final Provider<GetRewardList> PlaceComponentResult;

    private DanapolyCardsViewModel_Factory(Provider<GetRewardList> provider) {
        this.PlaceComponentResult = provider;
    }

    public static DanapolyCardsViewModel_Factory PlaceComponentResult(Provider<GetRewardList> provider) {
        return new DanapolyCardsViewModel_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanapolyCardsViewModel(this.PlaceComponentResult.get());
    }
}
