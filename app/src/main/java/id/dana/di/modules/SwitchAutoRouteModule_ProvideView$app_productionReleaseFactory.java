package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.richview.profile.switchautoroute.SwitchAutoRouteContract;

/* loaded from: classes4.dex */
public final class SwitchAutoRouteModule_ProvideView$app_productionReleaseFactory implements Factory<SwitchAutoRouteContract.View> {
    private final SwitchAutoRouteModule BuiltInFictitiousFunctionClassFactory;

    private SwitchAutoRouteModule_ProvideView$app_productionReleaseFactory(SwitchAutoRouteModule switchAutoRouteModule) {
        this.BuiltInFictitiousFunctionClassFactory = switchAutoRouteModule;
    }

    public static SwitchAutoRouteModule_ProvideView$app_productionReleaseFactory MyBillsEntityDataFactory(SwitchAutoRouteModule switchAutoRouteModule) {
        return new SwitchAutoRouteModule_ProvideView$app_productionReleaseFactory(switchAutoRouteModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SwitchAutoRouteContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
