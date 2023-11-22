package id.dana.danapoly.data.play.repository.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.foundation.facede.ApSecurity;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class NetworkDanapolyPlayEntityData_Factory implements Factory<NetworkDanapolyPlayEntityData> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ApSecurity> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<RpcConnector> getAuthRequestContext;

    private NetworkDanapolyPlayEntityData_Factory(Provider<RpcConnector> provider, Provider<ApSecurity> provider2, Provider<Context> provider3) {
        this.getAuthRequestContext = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
    }

    public static NetworkDanapolyPlayEntityData_Factory getAuthRequestContext(Provider<RpcConnector> provider, Provider<ApSecurity> provider2, Provider<Context> provider3) {
        return new NetworkDanapolyPlayEntityData_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NetworkDanapolyPlayEntityData(this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
