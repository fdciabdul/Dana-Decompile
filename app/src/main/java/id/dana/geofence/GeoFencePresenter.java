package id.dana.geofence;

import dagger.Lazy;
import id.dana.di.PerActivity;
import id.dana.domain.featureconfig.interactor.GetCurrentPOICacheTime;
import id.dana.domain.featureconfig.interactor.GetGeoFenceConfig;
import id.dana.domain.featureconfig.interactor.SetRetryIntervalGeoFence;
import id.dana.domain.featureconfig.model.GeofenceConfig;
import id.dana.domain.geofence.interactor.GetListPoi;
import id.dana.domain.geofence.interactor.PoiNotify;
import id.dana.geofence.GeofenceContract;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B]\b\u0007\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\t\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\t\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\t\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\t\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00140\t¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000e0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\fR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00120\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\fR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00130\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\fR\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\f"}, d2 = {"Lid/dana/geofence/GeoFencePresenter;", "Lid/dana/geofence/GeofenceContract$Presenter;", "", "onDestroy", "()V", "Lid/dana/domain/featureconfig/model/GeofenceConfig;", "getAuthRequestContext", "Lid/dana/domain/featureconfig/model/GeofenceConfig;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ldagger/Lazy;", "Lid/dana/domain/featureconfig/interactor/GetGeoFenceConfig;", "BuiltInFictitiousFunctionClassFactory", "Ldagger/Lazy;", "PlaceComponentResult", "Lid/dana/domain/featureconfig/interactor/GetCurrentPOICacheTime;", "getErrorConfigVersion", "Lid/dana/domain/geofence/interactor/GetListPoi;", "MyBillsEntityDataFactory", "Lid/dana/domain/geofence/interactor/PoiNotify;", "Lid/dana/domain/featureconfig/interactor/SetRetryIntervalGeoFence;", "Lid/dana/geofence/GeofenceContract$View;", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda0", "p0", "p1", "p2", "p3", "p4", "p5", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes5.dex */
public final class GeoFencePresenter implements GeofenceContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Lazy<GetGeoFenceConfig> PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final Lazy<PoiNotify> BuiltInFictitiousFunctionClassFactory;
    final Lazy<GetListPoi> MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final Lazy<SetRetryIntervalGeoFence> getErrorConfigVersion;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    GeofenceConfig KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy<GetCurrentPOICacheTime> getAuthRequestContext;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final Lazy<GeofenceContract.View> NetworkUserEntityData$$ExternalSyntheticLambda0;

    @Inject
    public GeoFencePresenter(Lazy<PoiNotify> lazy, Lazy<GetListPoi> lazy2, Lazy<GetGeoFenceConfig> lazy3, Lazy<GetCurrentPOICacheTime> lazy4, Lazy<SetRetryIntervalGeoFence> lazy5, Lazy<GeofenceContract.View> lazy6) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        Intrinsics.checkNotNullParameter(lazy5, "");
        Intrinsics.checkNotNullParameter(lazy6, "");
        this.BuiltInFictitiousFunctionClassFactory = lazy;
        this.MyBillsEntityDataFactory = lazy2;
        this.PlaceComponentResult = lazy3;
        this.getAuthRequestContext = lazy4;
        this.getErrorConfigVersion = lazy5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = lazy6;
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.get().dispose();
        this.MyBillsEntityDataFactory.get().dispose();
        this.PlaceComponentResult.get().dispose();
        this.getErrorConfigVersion.get().dispose();
    }
}
