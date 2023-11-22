package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.geofence.repository.source.GeoFenceEntityRepository;
import id.dana.domain.geofence.GeoFenceRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideGeofenceRepositoryFactory implements Factory<GeoFenceRepository> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<GeoFenceEntityRepository> PlaceComponentResult;

    private ApplicationModule_ProvideGeofenceRepositoryFactory(ApplicationModule applicationModule, Provider<GeoFenceEntityRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
        this.PlaceComponentResult = provider;
    }

    public static ApplicationModule_ProvideGeofenceRepositoryFactory PlaceComponentResult(ApplicationModule applicationModule, Provider<GeoFenceEntityRepository> provider) {
        return new ApplicationModule_ProvideGeofenceRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GeoFenceRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(this.PlaceComponentResult.get()));
    }
}
