package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.animation.presenter.HomeTabContract;

/* loaded from: classes4.dex */
public final class HomeTabModules_ProvideView$app_productionReleaseFactory implements Factory<HomeTabContract.View> {
    private final HomeTabModules PlaceComponentResult;

    private HomeTabModules_ProvideView$app_productionReleaseFactory(HomeTabModules homeTabModules) {
        this.PlaceComponentResult = homeTabModules;
    }

    public static HomeTabModules_ProvideView$app_productionReleaseFactory BuiltInFictitiousFunctionClassFactory(HomeTabModules homeTabModules) {
        return new HomeTabModules_ProvideView$app_productionReleaseFactory(homeTabModules);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (HomeTabContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
