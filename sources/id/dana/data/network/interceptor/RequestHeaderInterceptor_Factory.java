package id.dana.data.network.interceptor;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.foundation.facade.SecurityGuardFacade;
import id.dana.data.globalnetwork.source.local.UserLocation;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class RequestHeaderInterceptor_Factory implements Factory<RequestHeaderInterceptor> {
    private final Provider<SecurityGuardFacade> BuiltInFictitiousFunctionClassFactory;
    private final Provider<AccountEntityDataFactory> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> MyBillsEntityDataFactory;
    private final Provider<UserLocation> PlaceComponentResult;
    private final Provider<ApSecurityFacade> getAuthRequestContext;

    private RequestHeaderInterceptor_Factory(Provider<SecurityGuardFacade> provider, Provider<ApSecurityFacade> provider2, Provider<Context> provider3, Provider<UserLocation> provider4, Provider<AccountEntityDataFactory> provider5) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.getAuthRequestContext = provider2;
        this.MyBillsEntityDataFactory = provider3;
        this.PlaceComponentResult = provider4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider5;
    }

    public static RequestHeaderInterceptor_Factory BuiltInFictitiousFunctionClassFactory(Provider<SecurityGuardFacade> provider, Provider<ApSecurityFacade> provider2, Provider<Context> provider3, Provider<UserLocation> provider4, Provider<AccountEntityDataFactory> provider5) {
        return new RequestHeaderInterceptor_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new RequestHeaderInterceptor(this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
