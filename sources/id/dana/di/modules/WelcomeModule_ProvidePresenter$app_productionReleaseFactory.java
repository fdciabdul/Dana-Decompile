package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.onboarding.welcome.WelcomeContract;
import id.dana.onboarding.welcome.WelcomePresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class WelcomeModule_ProvidePresenter$app_productionReleaseFactory implements Factory<WelcomeContract.Presenter> {
    private final WelcomeModule MyBillsEntityDataFactory;
    private final Provider<WelcomePresenter> getAuthRequestContext;

    public static WelcomeContract.Presenter getAuthRequestContext(WelcomeModule welcomeModule, WelcomePresenter welcomePresenter) {
        return (WelcomeContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(welcomeModule.KClassImpl$Data$declaredNonStaticMembers$2(welcomePresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (WelcomeContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.get()));
    }
}
