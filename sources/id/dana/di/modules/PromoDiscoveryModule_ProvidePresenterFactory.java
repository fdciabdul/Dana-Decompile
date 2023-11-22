package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.promodiscovery.PromoDiscoveryContract;
import id.dana.contract.promodiscovery.PromoDiscoveryPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PromoDiscoveryModule_ProvidePresenterFactory implements Factory<PromoDiscoveryContract.Presenter> {
    private final Provider<PromoDiscoveryPresenter> MyBillsEntityDataFactory;
    private final PromoDiscoveryModule getAuthRequestContext;

    private PromoDiscoveryModule_ProvidePresenterFactory(PromoDiscoveryModule promoDiscoveryModule, Provider<PromoDiscoveryPresenter> provider) {
        this.getAuthRequestContext = promoDiscoveryModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static PromoDiscoveryModule_ProvidePresenterFactory PlaceComponentResult(PromoDiscoveryModule promoDiscoveryModule, Provider<PromoDiscoveryPresenter> provider) {
        return new PromoDiscoveryModule_ProvidePresenterFactory(promoDiscoveryModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PromoDiscoveryContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.PlaceComponentResult(this.MyBillsEntityDataFactory.get()));
    }
}
