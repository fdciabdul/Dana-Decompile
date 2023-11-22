package id.dana.data.network.interceptor;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.foundation.facade.SecurityGuardFacade;
import id.dana.data.globalnetwork.source.local.UserLocation;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class RequestHeaderWithLocationCheckInterceptor_Factory implements Factory<RequestHeaderWithLocationCheckInterceptor> {
    private final Provider<UserLocation> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ApSecurityFacade> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> MyBillsEntityDataFactory;
    private final Provider<SecurityGuardFacade> PlaceComponentResult;
    private final Provider<AccountEntityDataFactory> getAuthRequestContext;

    private RequestHeaderWithLocationCheckInterceptor_Factory(Provider<SecurityGuardFacade> provider, Provider<ApSecurityFacade> provider2, Provider<Context> provider3, Provider<UserLocation> provider4, Provider<AccountEntityDataFactory> provider5) {
        this.PlaceComponentResult = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.MyBillsEntityDataFactory = provider3;
        this.BuiltInFictitiousFunctionClassFactory = provider4;
        this.getAuthRequestContext = provider5;
    }

    public static RequestHeaderWithLocationCheckInterceptor_Factory getAuthRequestContext(Provider<SecurityGuardFacade> provider, Provider<ApSecurityFacade> provider2, Provider<Context> provider3, Provider<UserLocation> provider4, Provider<AccountEntityDataFactory> provider5) {
        return new RequestHeaderWithLocationCheckInterceptor_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new RequestHeaderWithLocationCheckInterceptor(this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get());
    }
}
