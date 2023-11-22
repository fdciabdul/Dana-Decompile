package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.promodiscovery.repository.PromoDiscoveryEntityRepository;
import id.dana.domain.promodiscovery.repository.PromoDiscoveryRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvidePromoDiscoveryEntityRepositoryFactory implements Factory<PromoDiscoveryRepository> {
    private final ApplicationModule MyBillsEntityDataFactory;
    private final Provider<PromoDiscoveryEntityRepository> PlaceComponentResult;

    private ApplicationModule_ProvidePromoDiscoveryEntityRepositoryFactory(ApplicationModule applicationModule, Provider<PromoDiscoveryEntityRepository> provider) {
        this.MyBillsEntityDataFactory = applicationModule;
        this.PlaceComponentResult = provider;
    }

    public static ApplicationModule_ProvidePromoDiscoveryEntityRepositoryFactory PlaceComponentResult(ApplicationModule applicationModule, Provider<PromoDiscoveryEntityRepository> provider) {
        return new ApplicationModule_ProvidePromoDiscoveryEntityRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PromoDiscoveryRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getAuthRequestContext(this.PlaceComponentResult.get()));
    }
}
