package id.dana.di.modules;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.geofence.GeofenceManager;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GeofenceModule_ProvideGeofenceManager$app_productionReleaseFactory implements Factory<GeofenceManager> {
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private final GeofenceModule MyBillsEntityDataFactory;

    private GeofenceModule_ProvideGeofenceManager$app_productionReleaseFactory(GeofenceModule geofenceModule, Provider<Context> provider) {
        this.MyBillsEntityDataFactory = geofenceModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static GeofenceModule_ProvideGeofenceManager$app_productionReleaseFactory MyBillsEntityDataFactory(GeofenceModule geofenceModule, Provider<Context> provider) {
        return new GeofenceModule_ProvideGeofenceManager$app_productionReleaseFactory(geofenceModule, provider);
    }

    public static GeofenceManager BuiltInFictitiousFunctionClassFactory(GeofenceModule geofenceModule, Context context) {
        return (GeofenceManager) Preconditions.BuiltInFictitiousFunctionClassFactory(geofenceModule.BuiltInFictitiousFunctionClassFactory(context));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GeofenceManager) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
