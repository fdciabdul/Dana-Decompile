package id.dana.data.paylater.repository.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkPaylaterEntityData_Factory implements Factory<NetworkPaylaterEntityData> {
    private final Provider<Context> contextProvider;
    private final Provider<DeviceInformationProvider> deviceInformationProvider;
    private final Provider<RpcConnector> rpcConnectorProvider;
    private final Provider<ApSecurityFacade> securityFacadeProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public NetworkPaylaterEntityData_Factory(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4, Provider<DeviceInformationProvider> provider5) {
        this.rpcConnectorProvider = provider;
        this.threadExecutorProvider = provider2;
        this.securityFacadeProvider = provider3;
        this.contextProvider = provider4;
        this.deviceInformationProvider = provider5;
    }

    @Override // javax.inject.Provider
    public final NetworkPaylaterEntityData get() {
        return newInstance(this.rpcConnectorProvider.get(), this.threadExecutorProvider.get(), this.securityFacadeProvider.get(), this.contextProvider.get(), this.deviceInformationProvider.get());
    }

    public static NetworkPaylaterEntityData_Factory create(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4, Provider<DeviceInformationProvider> provider5) {
        return new NetworkPaylaterEntityData_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static NetworkPaylaterEntityData newInstance(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context, DeviceInformationProvider deviceInformationProvider) {
        return new NetworkPaylaterEntityData(rpcConnector, threadExecutor, apSecurityFacade, context, deviceInformationProvider);
    }
}
