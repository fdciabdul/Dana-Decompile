package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.nearbyplaces.repository.NearbyPlaceEntityRepository;
import id.dana.domain.nearbyplaces.NearbyPlaceRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideNearbyPlaceRepositoryFactory implements Factory<NearbyPlaceRepository> {
    private final ApplicationModule PlaceComponentResult;
    private final Provider<NearbyPlaceEntityRepository> getAuthRequestContext;

    private ApplicationModule_ProvideNearbyPlaceRepositoryFactory(ApplicationModule applicationModule, Provider<NearbyPlaceEntityRepository> provider) {
        this.PlaceComponentResult = applicationModule;
        this.getAuthRequestContext = provider;
    }

    public static ApplicationModule_ProvideNearbyPlaceRepositoryFactory BuiltInFictitiousFunctionClassFactory(ApplicationModule applicationModule, Provider<NearbyPlaceEntityRepository> provider) {
        return new ApplicationModule_ProvideNearbyPlaceRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (NearbyPlaceRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getAuthRequestContext(this.getAuthRequestContext.get()));
    }
}
