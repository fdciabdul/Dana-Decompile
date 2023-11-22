package id.dana.network.rpc;

import dagger.MembersInjector;
import id.dana.utils.config.entity.NetworkLoggingConfiguration;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class RpcConnector_MembersInjector implements MembersInjector<RpcConnector> {
    private final Provider<NetworkLoggingConfiguration> networkLoggingConfigurationProvider;

    public RpcConnector_MembersInjector(Provider<NetworkLoggingConfiguration> provider) {
        this.networkLoggingConfigurationProvider = provider;
    }

    public static MembersInjector<RpcConnector> create(Provider<NetworkLoggingConfiguration> provider) {
        return new RpcConnector_MembersInjector(provider);
    }

    public final void injectMembers(RpcConnector rpcConnector) {
        injectNetworkLoggingConfiguration(rpcConnector, this.networkLoggingConfigurationProvider.get());
    }

    public static void injectNetworkLoggingConfiguration(RpcConnector rpcConnector, NetworkLoggingConfiguration networkLoggingConfiguration) {
        rpcConnector.networkLoggingConfiguration = networkLoggingConfiguration;
    }
}
