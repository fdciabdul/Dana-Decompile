package id.dana.data.login.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.holdlogin.v2.HoldLoginConfig;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkHoldLoginEntityData_Factory implements Factory<NetworkHoldLoginEntityData> {
    private final Provider<Context> contextProvider;
    private final Provider<HoldLoginConfig> holdLoginConfigProvider;
    private final Provider<RpcConnector> rpcConnectorProvider;
    private final Provider<ApSecurityFacade> securityFacadeProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public NetworkHoldLoginEntityData_Factory(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4, Provider<HoldLoginConfig> provider5) {
        this.rpcConnectorProvider = provider;
        this.threadExecutorProvider = provider2;
        this.securityFacadeProvider = provider3;
        this.contextProvider = provider4;
        this.holdLoginConfigProvider = provider5;
    }

    @Override // javax.inject.Provider
    public final NetworkHoldLoginEntityData get() {
        return newInstance(this.rpcConnectorProvider.get(), this.threadExecutorProvider.get(), this.securityFacadeProvider.get(), this.contextProvider.get(), this.holdLoginConfigProvider.get());
    }

    public static NetworkHoldLoginEntityData_Factory create(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4, Provider<HoldLoginConfig> provider5) {
        return new NetworkHoldLoginEntityData_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static NetworkHoldLoginEntityData newInstance(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context, HoldLoginConfig holdLoginConfig) {
        return new NetworkHoldLoginEntityData(rpcConnector, threadExecutor, apSecurityFacade, context, holdLoginConfig);
    }
}
