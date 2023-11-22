package id.dana.data.familyaccount.repository.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkFamilyAccountEntityData_Factory implements Factory<NetworkFamilyAccountEntityData> {
    private final Provider<ApSecurityFacade> apSecurityFacadeProvider;
    private final Provider<Context> contextProvider;
    private final Provider<RpcConnector> rpcConnectorProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public NetworkFamilyAccountEntityData_Factory(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4) {
        this.rpcConnectorProvider = provider;
        this.threadExecutorProvider = provider2;
        this.apSecurityFacadeProvider = provider3;
        this.contextProvider = provider4;
    }

    @Override // javax.inject.Provider
    public final NetworkFamilyAccountEntityData get() {
        return newInstance(this.rpcConnectorProvider.get(), this.threadExecutorProvider.get(), this.apSecurityFacadeProvider.get(), this.contextProvider.get());
    }

    public static NetworkFamilyAccountEntityData_Factory create(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4) {
        return new NetworkFamilyAccountEntityData_Factory(provider, provider2, provider3, provider4);
    }

    public static NetworkFamilyAccountEntityData newInstance(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        return new NetworkFamilyAccountEntityData(rpcConnector, threadExecutor, apSecurityFacade, context);
    }
}
