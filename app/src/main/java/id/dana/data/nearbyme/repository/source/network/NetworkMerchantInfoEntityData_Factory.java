package id.dana.data.nearbyme.repository.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkMerchantInfoEntityData_Factory implements Factory<NetworkMerchantInfoEntityData> {
    private final Provider<ApSecurityFacade> apSecurityFacadeProvider;
    private final Provider<Context> contextProvider;
    private final Provider<RpcConnector> rpcConnectorProvider;

    public NetworkMerchantInfoEntityData_Factory(Provider<RpcConnector> provider, Provider<ApSecurityFacade> provider2, Provider<Context> provider3) {
        this.rpcConnectorProvider = provider;
        this.apSecurityFacadeProvider = provider2;
        this.contextProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final NetworkMerchantInfoEntityData get() {
        return newInstance(this.rpcConnectorProvider.get(), this.apSecurityFacadeProvider.get(), this.contextProvider.get());
    }

    public static NetworkMerchantInfoEntityData_Factory create(Provider<RpcConnector> provider, Provider<ApSecurityFacade> provider2, Provider<Context> provider3) {
        return new NetworkMerchantInfoEntityData_Factory(provider, provider2, provider3);
    }

    public static NetworkMerchantInfoEntityData newInstance(RpcConnector rpcConnector, ApSecurityFacade apSecurityFacade, Context context) {
        return new NetworkMerchantInfoEntityData(rpcConnector, apSecurityFacade, context);
    }
}
