package id.dana.data.homeinfo.repository.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkHomeOmniEntityData_Factory implements Factory<NetworkHomeOmniEntityData> {
    private final Provider<Context> contextProvider;
    private final Provider<RpcConnector> rpcConnectorProvider;
    private final Provider<ApSecurityFacade> securityFacadeProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public NetworkHomeOmniEntityData_Factory(Provider<Context> provider, Provider<RpcConnector> provider2, Provider<ThreadExecutor> provider3, Provider<ApSecurityFacade> provider4) {
        this.contextProvider = provider;
        this.rpcConnectorProvider = provider2;
        this.threadExecutorProvider = provider3;
        this.securityFacadeProvider = provider4;
    }

    @Override // javax.inject.Provider
    public final NetworkHomeOmniEntityData get() {
        return newInstance(this.contextProvider.get(), this.rpcConnectorProvider.get(), this.threadExecutorProvider.get(), this.securityFacadeProvider.get());
    }

    public static NetworkHomeOmniEntityData_Factory create(Provider<Context> provider, Provider<RpcConnector> provider2, Provider<ThreadExecutor> provider3, Provider<ApSecurityFacade> provider4) {
        return new NetworkHomeOmniEntityData_Factory(provider, provider2, provider3, provider4);
    }

    public static NetworkHomeOmniEntityData newInstance(Context context, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade) {
        return new NetworkHomeOmniEntityData(context, rpcConnector, threadExecutor, apSecurityFacade);
    }
}
