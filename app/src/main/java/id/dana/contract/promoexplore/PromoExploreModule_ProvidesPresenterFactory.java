package id.dana.contract.promoexplore;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.explore.presenter.PromoExplorePresenter;
import id.dana.explore.view.PromoExploreContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PromoExploreModule_ProvidesPresenterFactory implements Factory<PromoExploreContract.Presenter> {
    private final PromoExploreModule MyBillsEntityDataFactory;
    private final Provider<PromoExplorePresenter> getAuthRequestContext;

    private PromoExploreModule_ProvidesPresenterFactory(PromoExploreModule promoExploreModule, Provider<PromoExplorePresenter> provider) {
        this.MyBillsEntityDataFactory = promoExploreModule;
        this.getAuthRequestContext = provider;
    }

    public static PromoExploreModule_ProvidesPresenterFactory getAuthRequestContext(PromoExploreModule promoExploreModule, Provider<PromoExplorePresenter> provider) {
        return new PromoExploreModule_ProvidesPresenterFactory(promoExploreModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PromoExploreContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getAuthRequestContext(this.getAuthRequestContext.get()));
    }
}
