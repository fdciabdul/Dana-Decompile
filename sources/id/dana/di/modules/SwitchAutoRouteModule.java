package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.richview.profile.switchautoroute.SwitchAutoRouteAnalyticsTracker;
import id.dana.richview.profile.switchautoroute.SwitchAutoRouteContract;
import id.dana.richview.profile.switchautoroute.SwitchAutoRoutePresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/di/modules/SwitchAutoRouteModule;", "", "Lid/dana/richview/profile/switchautoroute/SwitchAutoRouteAnalyticsTracker;", "p0", "Lid/dana/richview/profile/switchautoroute/SwitchAutoRouteContract$AnalyticsTracker;", "MyBillsEntityDataFactory", "(Lid/dana/richview/profile/switchautoroute/SwitchAutoRouteAnalyticsTracker;)Lid/dana/richview/profile/switchautoroute/SwitchAutoRouteContract$AnalyticsTracker;", "Lid/dana/richview/profile/switchautoroute/SwitchAutoRoutePresenter;", "Lid/dana/richview/profile/switchautoroute/SwitchAutoRouteContract$Presenter;", "getAuthRequestContext", "(Lid/dana/richview/profile/switchautoroute/SwitchAutoRoutePresenter;)Lid/dana/richview/profile/switchautoroute/SwitchAutoRouteContract$Presenter;", "Lid/dana/richview/profile/switchautoroute/SwitchAutoRouteContract$View;", "PlaceComponentResult", "()Lid/dana/richview/profile/switchautoroute/SwitchAutoRouteContract$View;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/richview/profile/switchautoroute/SwitchAutoRouteContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Lid/dana/richview/profile/switchautoroute/SwitchAutoRouteContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class SwitchAutoRouteModule {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final SwitchAutoRouteContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    public SwitchAutoRouteModule(SwitchAutoRouteContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
    }

    @Provides
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final SwitchAutoRouteContract.View getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Provides
    public final SwitchAutoRouteContract.Presenter getAuthRequestContext(SwitchAutoRoutePresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }

    @Provides
    public final SwitchAutoRouteContract.AnalyticsTracker MyBillsEntityDataFactory(SwitchAutoRouteAnalyticsTracker p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
