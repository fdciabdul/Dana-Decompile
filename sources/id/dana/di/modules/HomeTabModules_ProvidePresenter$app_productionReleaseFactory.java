package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.animation.presenter.HomeTabContract;
import id.dana.animation.presenter.HomeTabPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class HomeTabModules_ProvidePresenter$app_productionReleaseFactory implements Factory<HomeTabContract.Presenter> {
    private final HomeTabModules MyBillsEntityDataFactory;
    private final Provider<HomeTabPresenter> PlaceComponentResult;

    private HomeTabModules_ProvidePresenter$app_productionReleaseFactory(HomeTabModules homeTabModules, Provider<HomeTabPresenter> provider) {
        this.MyBillsEntityDataFactory = homeTabModules;
        this.PlaceComponentResult = provider;
    }

    public static HomeTabModules_ProvidePresenter$app_productionReleaseFactory MyBillsEntityDataFactory(HomeTabModules homeTabModules, Provider<HomeTabPresenter> provider) {
        return new HomeTabModules_ProvidePresenter$app_productionReleaseFactory(homeTabModules, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (HomeTabContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult.get()));
    }
}
