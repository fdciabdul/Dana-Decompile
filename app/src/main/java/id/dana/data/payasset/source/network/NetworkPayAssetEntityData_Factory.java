package id.dana.data.payasset.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.account.repository.source.SecuredAccountPreferences;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkPayAssetEntityData_Factory implements Factory<NetworkPayAssetEntityData> {
    private final Provider<SecuredAccountPreferences> accountPreferencesProvider;
    private final Provider<Context> contextProvider;
    private final Provider<RpcConnector> rpcConnectorProvider;
    private final Provider<ApSecurityFacade> securityFacadeProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public NetworkPayAssetEntityData_Factory(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4, Provider<SecuredAccountPreferences> provider5) {
        this.rpcConnectorProvider = provider;
        this.threadExecutorProvider = provider2;
        this.securityFacadeProvider = provider3;
        this.contextProvider = provider4;
        this.accountPreferencesProvider = provider5;
    }

    @Override // javax.inject.Provider
    public final NetworkPayAssetEntityData get() {
        return newInstance(this.rpcConnectorProvider.get(), this.threadExecutorProvider.get(), this.securityFacadeProvider.get(), this.contextProvider.get(), this.accountPreferencesProvider.get());
    }

    public static NetworkPayAssetEntityData_Factory create(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4, Provider<SecuredAccountPreferences> provider5) {
        return new NetworkPayAssetEntityData_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static NetworkPayAssetEntityData newInstance(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context, SecuredAccountPreferences securedAccountPreferences) {
        return new NetworkPayAssetEntityData(rpcConnector, threadExecutor, apSecurityFacade, context, securedAccountPreferences);
    }
}
