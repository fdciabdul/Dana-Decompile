package id.dana.data.kycrenewal.repository.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkKycRenewalEntityData_Factory implements Factory<NetworkKycRenewalEntityData> {
    private final Provider<ApSecurityFacade> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ThreadExecutor> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> PlaceComponentResult;
    private final Provider<RpcConnector> getAuthRequestContext;

    private NetworkKycRenewalEntityData_Factory(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4) {
        this.getAuthRequestContext = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
        this.PlaceComponentResult = provider4;
    }

    public static NetworkKycRenewalEntityData_Factory getAuthRequestContext(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4) {
        return new NetworkKycRenewalEntityData_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NetworkKycRenewalEntityData(this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get());
    }
}
