package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.challenge.pin.LogoutContract;

/* loaded from: classes4.dex */
public final class LogoutModule_ProvideLogoutViewFactory implements Factory<LogoutContract.View> {
    private final LogoutModule getAuthRequestContext;

    private LogoutModule_ProvideLogoutViewFactory(LogoutModule logoutModule) {
        this.getAuthRequestContext = logoutModule;
    }

    public static LogoutModule_ProvideLogoutViewFactory getAuthRequestContext(LogoutModule logoutModule) {
        return new LogoutModule_ProvideLogoutViewFactory(logoutModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (LogoutContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2());
    }
}
