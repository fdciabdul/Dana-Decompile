package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.onboarding.splash.LocalConfigSplashContract;

/* loaded from: classes4.dex */
public final class LocalConfigSplashModule_ProvidesViewFactory implements Factory<LocalConfigSplashContract.View> {
    private final LocalConfigSplashModule BuiltInFictitiousFunctionClassFactory;

    private LocalConfigSplashModule_ProvidesViewFactory(LocalConfigSplashModule localConfigSplashModule) {
        this.BuiltInFictitiousFunctionClassFactory = localConfigSplashModule;
    }

    public static LocalConfigSplashModule_ProvidesViewFactory getAuthRequestContext(LocalConfigSplashModule localConfigSplashModule) {
        return new LocalConfigSplashModule_ProvidesViewFactory(localConfigSplashModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (LocalConfigSplashContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getMyBillsEntityDataFactory());
    }
}
