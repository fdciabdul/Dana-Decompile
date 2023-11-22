package id.dana.data.globalnetwork.source;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.globalnetwork.source.local.GlobalNetworkPreference;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GlobalNetworkDataFactory_Factory implements Factory<GlobalNetworkDataFactory> {
    private final Provider<ApSecurityFacade> apSecurityFacadeProvider;
    private final Provider<Context> contextProvider;
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;
    private final Provider<GlobalNetworkPreference> globalNetworkPreferenceProvider;
    private final Provider<RpcConnector> rpcConnectorProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GlobalNetworkDataFactory_Factory(Provider<Context> provider, Provider<GlobalNetworkPreference> provider2, Provider<FeatureConfigRepository> provider3, Provider<RpcConnector> provider4, Provider<ThreadExecutor> provider5, Provider<ApSecurityFacade> provider6) {
        this.contextProvider = provider;
        this.globalNetworkPreferenceProvider = provider2;
        this.featureConfigRepositoryProvider = provider3;
        this.rpcConnectorProvider = provider4;
        this.threadExecutorProvider = provider5;
        this.apSecurityFacadeProvider = provider6;
    }

    @Override // javax.inject.Provider
    public final GlobalNetworkDataFactory get() {
        return newInstance(this.contextProvider.get(), this.globalNetworkPreferenceProvider.get(), this.featureConfigRepositoryProvider.get(), this.rpcConnectorProvider.get(), this.threadExecutorProvider.get(), this.apSecurityFacadeProvider.get());
    }

    public static GlobalNetworkDataFactory_Factory create(Provider<Context> provider, Provider<GlobalNetworkPreference> provider2, Provider<FeatureConfigRepository> provider3, Provider<RpcConnector> provider4, Provider<ThreadExecutor> provider5, Provider<ApSecurityFacade> provider6) {
        return new GlobalNetworkDataFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static GlobalNetworkDataFactory newInstance(Context context, GlobalNetworkPreference globalNetworkPreference, FeatureConfigRepository featureConfigRepository, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade) {
        return new GlobalNetworkDataFactory(context, globalNetworkPreference, featureConfigRepository, rpcConnector, threadExecutor, apSecurityFacade);
    }
}
