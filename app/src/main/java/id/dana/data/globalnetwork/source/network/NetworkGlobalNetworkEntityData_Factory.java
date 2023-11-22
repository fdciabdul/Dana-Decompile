package id.dana.data.globalnetwork.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class NetworkGlobalNetworkEntityData_Factory implements Factory<NetworkGlobalNetworkEntityData> {
    private final Provider<ApSecurityFacade> apSecurityFacadeProvider;
    private final Provider<Context> contextProvider;
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;
    private final Provider<RpcConnector> rpcConnectorProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public NetworkGlobalNetworkEntityData_Factory(Provider<Context> provider, Provider<FeatureConfigRepository> provider2, Provider<RpcConnector> provider3, Provider<ThreadExecutor> provider4, Provider<ApSecurityFacade> provider5) {
        this.contextProvider = provider;
        this.featureConfigRepositoryProvider = provider2;
        this.rpcConnectorProvider = provider3;
        this.threadExecutorProvider = provider4;
        this.apSecurityFacadeProvider = provider5;
    }

    @Override // javax.inject.Provider
    public final NetworkGlobalNetworkEntityData get() {
        return newInstance(this.contextProvider.get(), this.featureConfigRepositoryProvider.get(), this.rpcConnectorProvider.get(), this.threadExecutorProvider.get(), this.apSecurityFacadeProvider.get());
    }

    public static NetworkGlobalNetworkEntityData_Factory create(Provider<Context> provider, Provider<FeatureConfigRepository> provider2, Provider<RpcConnector> provider3, Provider<ThreadExecutor> provider4, Provider<ApSecurityFacade> provider5) {
        return new NetworkGlobalNetworkEntityData_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static NetworkGlobalNetworkEntityData newInstance(Context context, FeatureConfigRepository featureConfigRepository, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade) {
        return new NetworkGlobalNetworkEntityData(context, featureConfigRepository, rpcConnector, threadExecutor, apSecurityFacade);
    }
}
