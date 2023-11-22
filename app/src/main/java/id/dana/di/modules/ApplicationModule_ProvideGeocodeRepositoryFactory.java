package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.geocode.repository.GeocodeEntityRepository;
import id.dana.domain.geocode.GeocodeRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideGeocodeRepositoryFactory implements Factory<GeocodeRepository> {
    private final ApplicationModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GeocodeEntityRepository> getAuthRequestContext;

    private ApplicationModule_ProvideGeocodeRepositoryFactory(ApplicationModule applicationModule, Provider<GeocodeEntityRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationModule;
        this.getAuthRequestContext = provider;
    }

    public static ApplicationModule_ProvideGeocodeRepositoryFactory PlaceComponentResult(ApplicationModule applicationModule, Provider<GeocodeEntityRepository> provider) {
        return new ApplicationModule_ProvideGeocodeRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GeocodeRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(this.getAuthRequestContext.get()));
    }
}
