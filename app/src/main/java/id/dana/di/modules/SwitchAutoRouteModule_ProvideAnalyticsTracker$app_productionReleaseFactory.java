package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.richview.profile.switchautoroute.SwitchAutoRouteAnalyticsTracker;
import id.dana.richview.profile.switchautoroute.SwitchAutoRouteContract;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class SwitchAutoRouteModule_ProvideAnalyticsTracker$app_productionReleaseFactory implements Factory<SwitchAutoRouteContract.AnalyticsTracker> {
    private final Provider<SwitchAutoRouteAnalyticsTracker> KClassImpl$Data$declaredNonStaticMembers$2;
    private final SwitchAutoRouteModule MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SwitchAutoRouteContract.AnalyticsTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
