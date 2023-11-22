package id.dana.geofence;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.featureconfig.interactor.GetCurrentPOICacheTime;
import id.dana.domain.featureconfig.interactor.GetGeoFenceConfig;
import id.dana.domain.featureconfig.interactor.SetRetryIntervalGeoFence;
import id.dana.domain.geofence.interactor.GetListPoi;
import id.dana.domain.geofence.interactor.PoiNotify;
import id.dana.geofence.GeofenceContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GeoFencePresenter_Factory implements Factory<GeoFencePresenter> {
    private final Provider<GetGeoFenceConfig> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetCurrentPOICacheTime> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<SetRetryIntervalGeoFence> MyBillsEntityDataFactory;
    private final Provider<GetListPoi> PlaceComponentResult;
    private final Provider<PoiNotify> getAuthRequestContext;
    private final Provider<GeofenceContract.View> lookAheadTest;

    private GeoFencePresenter_Factory(Provider<PoiNotify> provider, Provider<GetListPoi> provider2, Provider<GetGeoFenceConfig> provider3, Provider<GetCurrentPOICacheTime> provider4, Provider<SetRetryIntervalGeoFence> provider5, Provider<GeofenceContract.View> provider6) {
        this.getAuthRequestContext = provider;
        this.PlaceComponentResult = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.MyBillsEntityDataFactory = provider5;
        this.lookAheadTest = provider6;
    }

    public static GeoFencePresenter_Factory MyBillsEntityDataFactory(Provider<PoiNotify> provider, Provider<GetListPoi> provider2, Provider<GetGeoFenceConfig> provider3, Provider<GetCurrentPOICacheTime> provider4, Provider<SetRetryIntervalGeoFence> provider5, Provider<GeofenceContract.View> provider6) {
        return new GeoFencePresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GeoFencePresenter(DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest));
    }
}
