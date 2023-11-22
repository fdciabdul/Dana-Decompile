package id.dana.danapoly.data.rewards.repository.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class NetworkDanapolyRewardsData_Factory implements Factory<NetworkDanapolyRewardsData> {
    private final Provider<RpcConnector> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> MyBillsEntityDataFactory;
    private final Provider<ApSecurityFacade> PlaceComponentResult;

    private NetworkDanapolyRewardsData_Factory(Provider<Context> provider, Provider<RpcConnector> provider2, Provider<ApSecurityFacade> provider3) {
        this.MyBillsEntityDataFactory = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.PlaceComponentResult = provider3;
    }

    public static NetworkDanapolyRewardsData_Factory BuiltInFictitiousFunctionClassFactory(Provider<Context> provider, Provider<RpcConnector> provider2, Provider<ApSecurityFacade> provider3) {
        return new NetworkDanapolyRewardsData_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NetworkDanapolyRewardsData(this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get());
    }
}
