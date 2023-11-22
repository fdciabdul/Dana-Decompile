package id.dana.data.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.foundation.facade.SecurityGuardFacade;
import id.dana.data.foundation.toolbox.HttpTransportFactory;
import id.dana.data.globalnetwork.source.local.UserLocation;
import id.dana.data.network.interceptor.HttpSessionInterceptor;
import id.dana.utils.holdlogin.v2.HoldLoginConfig;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class RpcProxy_Factory implements Factory<RpcProxy> {
    private final Provider<AccountEntityDataFactory> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<HttpSessionInterceptor> MyBillsEntityDataFactory;
    private final Provider<SecurityGuardFacade> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<HoldLoginConfig> PlaceComponentResult;
    private final Provider<ApSecurityFacade> getAuthRequestContext;
    private final Provider<HttpTransportFactory> getErrorConfigVersion;
    private final Provider<UserLocation> lookAheadTest;

    private RpcProxy_Factory(Provider<Context> provider, Provider<ApSecurityFacade> provider2, Provider<SecurityGuardFacade> provider3, Provider<HttpTransportFactory> provider4, Provider<HttpSessionInterceptor> provider5, Provider<UserLocation> provider6, Provider<HoldLoginConfig> provider7, Provider<AccountEntityDataFactory> provider8) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.getAuthRequestContext = provider2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider3;
        this.getErrorConfigVersion = provider4;
        this.MyBillsEntityDataFactory = provider5;
        this.lookAheadTest = provider6;
        this.PlaceComponentResult = provider7;
        this.BuiltInFictitiousFunctionClassFactory = provider8;
    }

    public static RpcProxy_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<Context> provider, Provider<ApSecurityFacade> provider2, Provider<SecurityGuardFacade> provider3, Provider<HttpTransportFactory> provider4, Provider<HttpSessionInterceptor> provider5, Provider<UserLocation> provider6, Provider<HoldLoginConfig> provider7, Provider<AccountEntityDataFactory> provider8) {
        return new RpcProxy_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new RpcProxy(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.getErrorConfigVersion.get(), this.MyBillsEntityDataFactory.get(), this.lookAheadTest.get(), this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
