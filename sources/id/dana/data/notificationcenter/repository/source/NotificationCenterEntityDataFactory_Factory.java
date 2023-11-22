package id.dana.data.notificationcenter.repository.source;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NotificationCenterEntityDataFactory_Factory implements Factory<NotificationCenterEntityDataFactory> {
    private final Provider<ApSecurityFacade> apSecurityFacadeProvider;
    private final Provider<Context> contextProvider;
    private final Provider<RpcConnector> rpcConnectorProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public NotificationCenterEntityDataFactory_Factory(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4) {
        this.rpcConnectorProvider = provider;
        this.threadExecutorProvider = provider2;
        this.apSecurityFacadeProvider = provider3;
        this.contextProvider = provider4;
    }

    @Override // javax.inject.Provider
    public final NotificationCenterEntityDataFactory get() {
        return newInstance(this.rpcConnectorProvider.get(), this.threadExecutorProvider.get(), this.apSecurityFacadeProvider.get(), this.contextProvider.get());
    }

    public static NotificationCenterEntityDataFactory_Factory create(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4) {
        return new NotificationCenterEntityDataFactory_Factory(provider, provider2, provider3, provider4);
    }

    public static NotificationCenterEntityDataFactory newInstance(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        return new NotificationCenterEntityDataFactory(rpcConnector, threadExecutor, apSecurityFacade, context);
    }
}
