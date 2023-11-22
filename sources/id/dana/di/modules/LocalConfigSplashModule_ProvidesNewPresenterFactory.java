package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.onboarding.splash.LocalConfigSplashContract;
import id.dana.onboarding.splash.LocalConfigSplashPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class LocalConfigSplashModule_ProvidesNewPresenterFactory implements Factory<LocalConfigSplashContract.Presenter> {
    private final Provider<LocalConfigSplashPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final LocalConfigSplashModule getAuthRequestContext;

    private LocalConfigSplashModule_ProvidesNewPresenterFactory(LocalConfigSplashModule localConfigSplashModule, Provider<LocalConfigSplashPresenter> provider) {
        this.getAuthRequestContext = localConfigSplashModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static LocalConfigSplashModule_ProvidesNewPresenterFactory MyBillsEntityDataFactory(LocalConfigSplashModule localConfigSplashModule, Provider<LocalConfigSplashPresenter> provider) {
        return new LocalConfigSplashModule_ProvidesNewPresenterFactory(localConfigSplashModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (LocalConfigSplashContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
