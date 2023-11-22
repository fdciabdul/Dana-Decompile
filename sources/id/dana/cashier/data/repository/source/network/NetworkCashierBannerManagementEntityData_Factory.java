package id.dana.cashier.data.repository.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class NetworkCashierBannerManagementEntityData_Factory implements Factory<NetworkCashierBannerManagementEntityData> {
    private final Provider<Context> contextProvider;
    private final Provider<RpcConnector> rpcConnectorProvider;
    private final Provider<ApSecurityFacade> securityFacadeProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public NetworkCashierBannerManagementEntityData_Factory(Provider<Context> provider, Provider<RpcConnector> provider2, Provider<ThreadExecutor> provider3, Provider<ApSecurityFacade> provider4) {
        this.contextProvider = provider;
        this.rpcConnectorProvider = provider2;
        this.threadExecutorProvider = provider3;
        this.securityFacadeProvider = provider4;
    }

    @Override // javax.inject.Provider
    public final NetworkCashierBannerManagementEntityData get() {
        return newInstance(this.contextProvider.get(), this.rpcConnectorProvider.get(), this.threadExecutorProvider.get(), this.securityFacadeProvider.get());
    }

    public static NetworkCashierBannerManagementEntityData_Factory create(Provider<Context> provider, Provider<RpcConnector> provider2, Provider<ThreadExecutor> provider3, Provider<ApSecurityFacade> provider4) {
        return new NetworkCashierBannerManagementEntityData_Factory(provider, provider2, provider3, provider4);
    }

    public static NetworkCashierBannerManagementEntityData newInstance(Context context, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade) {
        return new NetworkCashierBannerManagementEntityData(context, rpcConnector, threadExecutor, apSecurityFacade);
    }
}
