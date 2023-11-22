package id.dana.data.network.interceptor;

import dagger.internal.Factory;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.foundation.facade.SecurityGuardFacade;
import id.dana.data.login.LoginLogoutSubject;
import id.dana.data.login.source.LoginEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class HttpSessionInterceptor_Factory implements Factory<HttpSessionInterceptor> {
    private final Provider<LoginEntityDataFactory> BuiltInFictitiousFunctionClassFactory;
    private final Provider<LoginLogoutSubject> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<SecurityGuardFacade> MyBillsEntityDataFactory;
    private final Provider<AccountEntityDataFactory> getAuthRequestContext;

    private HttpSessionInterceptor_Factory(Provider<LoginEntityDataFactory> provider, Provider<SecurityGuardFacade> provider2, Provider<LoginLogoutSubject> provider3, Provider<AccountEntityDataFactory> provider4) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.getAuthRequestContext = provider4;
    }

    public static HttpSessionInterceptor_Factory PlaceComponentResult(Provider<LoginEntityDataFactory> provider, Provider<SecurityGuardFacade> provider2, Provider<LoginLogoutSubject> provider3, Provider<AccountEntityDataFactory> provider4) {
        return new HttpSessionInterceptor_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new HttpSessionInterceptor(this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get());
    }
}
