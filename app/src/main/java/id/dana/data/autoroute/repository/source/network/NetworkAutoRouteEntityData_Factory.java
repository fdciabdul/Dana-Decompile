package id.dana.data.autoroute.repository.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkAutoRouteEntityData_Factory implements Factory<NetworkAutoRouteEntityData> {
    private final Provider<ApSecurityFacade> apSecurityFacadeProvider;
    private final Provider<Context> contextProvider;
    private final Provider<RpcConnector> rpcConnectorProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public NetworkAutoRouteEntityData_Factory(Provider<Context> provider, Provider<RpcConnector> provider2, Provider<ThreadExecutor> provider3, Provider<ApSecurityFacade> provider4) {
        this.contextProvider = provider;
        this.rpcConnectorProvider = provider2;
        this.threadExecutorProvider = provider3;
        this.apSecurityFacadeProvider = provider4;
    }

    @Override // javax.inject.Provider
    public final NetworkAutoRouteEntityData get() {
        return newInstance(this.contextProvider.get(), this.rpcConnectorProvider.get(), this.threadExecutorProvider.get(), this.apSecurityFacadeProvider.get());
    }

    public static NetworkAutoRouteEntityData_Factory create(Provider<Context> provider, Provider<RpcConnector> provider2, Provider<ThreadExecutor> provider3, Provider<ApSecurityFacade> provider4) {
        return new NetworkAutoRouteEntityData_Factory(provider, provider2, provider3, provider4);
    }

    public static NetworkAutoRouteEntityData newInstance(Context context, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade) {
        return new NetworkAutoRouteEntityData(context, rpcConnector, threadExecutor, apSecurityFacade);
    }
}
