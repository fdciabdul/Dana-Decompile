package id.dana.di.modules;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import id.dana.geofence.GeoFencePresenter;
import id.dana.geofence.GeofenceContract;
import id.dana.geofence.GeofenceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\t\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\t\u0010\fR\u0014\u0010\t\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/di/modules/GeofenceModule;", "", "Landroid/content/Context;", "p0", "Lid/dana/geofence/GeofenceManager;", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;)Lid/dana/geofence/GeofenceManager;", "Lid/dana/geofence/GeoFencePresenter;", "Lid/dana/geofence/GeofenceContract$Presenter;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/geofence/GeoFencePresenter;)Lid/dana/geofence/GeofenceContract$Presenter;", "Lid/dana/geofence/GeofenceContract$View;", "()Lid/dana/geofence/GeofenceContract$View;", "MyBillsEntityDataFactory", "Lid/dana/geofence/GeofenceContract$View;", "<init>", "(Lid/dana/geofence/GeofenceContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class GeofenceModule {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final GeofenceContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    public GeofenceModule(GeofenceContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
    }

    @Provides
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final GeofenceContract.View getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Provides
    public final GeofenceContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(GeoFencePresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }

    @Provides
    public final GeofenceManager BuiltInFictitiousFunctionClassFactory(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return new GeofenceManager(p0);
    }
}
