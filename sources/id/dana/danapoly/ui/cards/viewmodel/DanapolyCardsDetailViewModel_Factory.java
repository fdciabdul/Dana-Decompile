package id.dana.danapoly.ui.cards.viewmodel;

import dagger.internal.Factory;
import id.dana.danapoly.domain.rewards.interactor.GetRewardList;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DanapolyCardsDetailViewModel_Factory implements Factory<DanapolyCardsDetailViewModel> {
    private final Provider<GetRewardList> MyBillsEntityDataFactory;

    private DanapolyCardsDetailViewModel_Factory(Provider<GetRewardList> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static DanapolyCardsDetailViewModel_Factory BuiltInFictitiousFunctionClassFactory(Provider<GetRewardList> provider) {
        return new DanapolyCardsDetailViewModel_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanapolyCardsDetailViewModel(this.MyBillsEntityDataFactory.get());
    }
}
