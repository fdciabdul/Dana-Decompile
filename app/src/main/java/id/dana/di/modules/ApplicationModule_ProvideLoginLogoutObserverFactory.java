package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.login.LoginLogoutSubject;
import id.dana.toggle.userloginlogout.LoginLogoutObserver;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideLoginLogoutObserverFactory implements Factory<LoginLogoutObserver> {
    private final Provider<LoginLogoutSubject> BuiltInFictitiousFunctionClassFactory;
    private final ApplicationModule MyBillsEntityDataFactory;

    private ApplicationModule_ProvideLoginLogoutObserverFactory(ApplicationModule applicationModule, Provider<LoginLogoutSubject> provider) {
        this.MyBillsEntityDataFactory = applicationModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ApplicationModule_ProvideLoginLogoutObserverFactory getAuthRequestContext(ApplicationModule applicationModule, Provider<LoginLogoutSubject> provider) {
        return new ApplicationModule_ProvideLoginLogoutObserverFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (LoginLogoutObserver) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
