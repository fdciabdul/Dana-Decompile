package id.dana.data.promocenter.repository.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkPromoCenterEntityData_Factory implements Factory<NetworkPromoCenterEntityData> {
    private final Provider<Context> contextProvider;
    private final Provider<RpcConnector> rpcConnectorProvider;
    private final Provider<ApSecurityFacade> securityFacadeProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public NetworkPromoCenterEntityData_Factory(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4) {
        this.rpcConnectorProvider = provider;
        this.threadExecutorProvider = provider2;
        this.securityFacadeProvider = provider3;
        this.contextProvider = provider4;
    }

    @Override // javax.inject.Provider
    public final NetworkPromoCenterEntityData get() {
        return newInstance(this.rpcConnectorProvider.get(), this.threadExecutorProvider.get(), this.securityFacadeProvider.get(), this.contextProvider.get());
    }

    public static NetworkPromoCenterEntityData_Factory create(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4) {
        return new NetworkPromoCenterEntityData_Factory(provider, provider2, provider3, provider4);
    }

    public static NetworkPromoCenterEntityData newInstance(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        return new NetworkPromoCenterEntityData(rpcConnector, threadExecutor, apSecurityFacade, context);
    }
}
