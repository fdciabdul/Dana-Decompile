package id.dana.riskChallenges.data.danaprotection.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class NetworkDanaProtectionEntityData_Factory implements Factory<NetworkDanaProtectionEntityData> {
    private final Provider<ApSecurityFacade> BuiltInFictitiousFunctionClassFactory;
    private final Provider<RpcConnector> MyBillsEntityDataFactory;
    private final Provider<Context> PlaceComponentResult;
    private final Provider<ThreadExecutor> getAuthRequestContext;

    private NetworkDanaProtectionEntityData_Factory(Provider<Context> provider, Provider<RpcConnector> provider2, Provider<ThreadExecutor> provider3, Provider<ApSecurityFacade> provider4) {
        this.PlaceComponentResult = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.getAuthRequestContext = provider3;
        this.BuiltInFictitiousFunctionClassFactory = provider4;
    }

    public static NetworkDanaProtectionEntityData_Factory PlaceComponentResult(Provider<Context> provider, Provider<RpcConnector> provider2, Provider<ThreadExecutor> provider3, Provider<ApSecurityFacade> provider4) {
        return new NetworkDanaProtectionEntityData_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NetworkDanaProtectionEntityData(this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
