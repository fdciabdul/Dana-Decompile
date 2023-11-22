package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.challenge.pin.LogoutContract;
import id.dana.challenge.pin.LogoutPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class LogoutModule_ProvideLogoutPresenterFactory implements Factory<LogoutContract.Presenter> {
    private final Provider<LogoutPresenter> BuiltInFictitiousFunctionClassFactory;
    private final LogoutModule KClassImpl$Data$declaredNonStaticMembers$2;

    private LogoutModule_ProvideLogoutPresenterFactory(LogoutModule logoutModule, Provider<LogoutPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = logoutModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static LogoutModule_ProvideLogoutPresenterFactory BuiltInFictitiousFunctionClassFactory(LogoutModule logoutModule, Provider<LogoutPresenter> provider) {
        return new LogoutModule_ProvideLogoutPresenterFactory(logoutModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (LogoutContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
