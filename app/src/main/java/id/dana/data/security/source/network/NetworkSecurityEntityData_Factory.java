package id.dana.data.security.source.network;

import dagger.internal.Factory;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkSecurityEntityData_Factory implements Factory<NetworkSecurityEntityData> {
    private final Provider<RpcConnector> rpcConnectorProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public NetworkSecurityEntityData_Factory(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2) {
        this.rpcConnectorProvider = provider;
        this.threadExecutorProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final NetworkSecurityEntityData get() {
        return newInstance(this.rpcConnectorProvider.get(), this.threadExecutorProvider.get());
    }

    public static NetworkSecurityEntityData_Factory create(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2) {
        return new NetworkSecurityEntityData_Factory(provider, provider2);
    }

    public static NetworkSecurityEntityData newInstance(RpcConnector rpcConnector, ThreadExecutor threadExecutor) {
        return new NetworkSecurityEntityData(rpcConnector, threadExecutor);
    }
}
