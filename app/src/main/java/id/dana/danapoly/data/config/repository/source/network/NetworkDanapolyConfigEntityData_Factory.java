package id.dana.danapoly.data.config.repository.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.foundation.facede.ApSecurity;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class NetworkDanapolyConfigEntityData_Factory implements Factory<NetworkDanapolyConfigEntityData> {
    private final Provider<Context> MyBillsEntityDataFactory;
    private final Provider<RpcConnector> PlaceComponentResult;
    private final Provider<ApSecurity> getAuthRequestContext;

    private NetworkDanapolyConfigEntityData_Factory(Provider<RpcConnector> provider, Provider<ApSecurity> provider2, Provider<Context> provider3) {
        this.PlaceComponentResult = provider;
        this.getAuthRequestContext = provider2;
        this.MyBillsEntityDataFactory = provider3;
    }

    public static NetworkDanapolyConfigEntityData_Factory MyBillsEntityDataFactory(Provider<RpcConnector> provider, Provider<ApSecurity> provider2, Provider<Context> provider3) {
        return new NetworkDanapolyConfigEntityData_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NetworkDanapolyConfigEntityData(this.PlaceComponentResult.get(), this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get());
    }
}
