package id.dana.danapoly.data.dailycheck.repository.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.foundation.facede.ApSecurity;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class NetworkDanapolyCheckInEntityData_Factory implements Factory<NetworkDanapolyCheckInEntityData> {
    private final Provider<ApSecurity> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<RpcConnector> PlaceComponentResult;
    private final Provider<Context> getAuthRequestContext;

    private NetworkDanapolyCheckInEntityData_Factory(Provider<RpcConnector> provider, Provider<ApSecurity> provider2, Provider<Context> provider3) {
        this.PlaceComponentResult = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.getAuthRequestContext = provider3;
    }

    public static NetworkDanapolyCheckInEntityData_Factory PlaceComponentResult(Provider<RpcConnector> provider, Provider<ApSecurity> provider2, Provider<Context> provider3) {
        return new NetworkDanapolyCheckInEntityData_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NetworkDanapolyCheckInEntityData(this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get());
    }
}
