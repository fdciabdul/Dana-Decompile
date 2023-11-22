package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.geofence.GeoFencePresenter;
import id.dana.geofence.GeofenceContract;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GeofenceModule_ProvidePresenter$app_productionReleaseFactory implements Factory<GeofenceContract.Presenter> {
    private final GeofenceModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<GeoFencePresenter> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GeofenceContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
