package id.dana.data.danaprotection.repository.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkDanaProtectionInfoEntityData_Factory implements Factory<NetworkDanaProtectionInfoEntityData> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ThreadExecutor> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ApSecurityFacade> MyBillsEntityDataFactory;
    private final Provider<RpcConnector> PlaceComponentResult;

    private NetworkDanaProtectionInfoEntityData_Factory(Provider<Context> provider, Provider<RpcConnector> provider2, Provider<ThreadExecutor> provider3, Provider<ApSecurityFacade> provider4) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.PlaceComponentResult = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.MyBillsEntityDataFactory = provider4;
    }

    public static NetworkDanaProtectionInfoEntityData_Factory PlaceComponentResult(Provider<Context> provider, Provider<RpcConnector> provider2, Provider<ThreadExecutor> provider3, Provider<ApSecurityFacade> provider4) {
        return new NetworkDanaProtectionInfoEntityData_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NetworkDanaProtectionInfoEntityData(this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get());
    }
}
