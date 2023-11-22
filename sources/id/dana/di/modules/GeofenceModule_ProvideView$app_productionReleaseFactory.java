package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.geofence.GeofenceContract;

/* loaded from: classes4.dex */
public final class GeofenceModule_ProvideView$app_productionReleaseFactory implements Factory<GeofenceContract.View> {
    private final GeofenceModule KClassImpl$Data$declaredNonStaticMembers$2;

    private GeofenceModule_ProvideView$app_productionReleaseFactory(GeofenceModule geofenceModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = geofenceModule;
    }

    public static GeofenceModule_ProvideView$app_productionReleaseFactory PlaceComponentResult(GeofenceModule geofenceModule) {
        return new GeofenceModule_ProvideView$app_productionReleaseFactory(geofenceModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GeofenceContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
