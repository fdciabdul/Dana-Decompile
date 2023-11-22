package id.dana.biometric.data.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class NetworkRiskTrackerEntityData_Factory implements Factory<NetworkRiskTrackerEntityData> {
    private final Provider<ApSecurityFacade> apSecurityFacadeProvider;
    private final Provider<Context> appContextProvider;
    private final Provider<RpcConnector> rpcConnectorProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public NetworkRiskTrackerEntityData_Factory(Provider<Context> provider, Provider<RpcConnector> provider2, Provider<ThreadExecutor> provider3, Provider<ApSecurityFacade> provider4) {
        this.appContextProvider = provider;
        this.rpcConnectorProvider = provider2;
        this.threadExecutorProvider = provider3;
        this.apSecurityFacadeProvider = provider4;
    }

    @Override // javax.inject.Provider
    public final NetworkRiskTrackerEntityData get() {
        return newInstance(this.appContextProvider.get(), this.rpcConnectorProvider.get(), this.threadExecutorProvider.get(), this.apSecurityFacadeProvider.get());
    }

    public static NetworkRiskTrackerEntityData_Factory create(Provider<Context> provider, Provider<RpcConnector> provider2, Provider<ThreadExecutor> provider3, Provider<ApSecurityFacade> provider4) {
        return new NetworkRiskTrackerEntityData_Factory(provider, provider2, provider3, provider4);
    }

    public static NetworkRiskTrackerEntityData newInstance(Context context, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade) {
        return new NetworkRiskTrackerEntityData(context, rpcConnector, threadExecutor, apSecurityFacade);
    }
}
