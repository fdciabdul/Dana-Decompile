package id.dana.data.authcode.repository.source;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class AuthEntityDataFactory_Factory implements Factory<AuthEntityDataFactory> {
    private final Provider<ApSecurityFacade> apSecurityFacadeProvider;
    private final Provider<Context> contextProvider;
    private final Provider<ThreadExecutor> executorProvider;
    private final Provider<RpcConnector> rpcConnectorProvider;

    public AuthEntityDataFactory_Factory(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4) {
        this.rpcConnectorProvider = provider;
        this.executorProvider = provider2;
        this.apSecurityFacadeProvider = provider3;
        this.contextProvider = provider4;
    }

    @Override // javax.inject.Provider
    public final AuthEntityDataFactory get() {
        return newInstance(this.rpcConnectorProvider.get(), this.executorProvider.get(), this.apSecurityFacadeProvider.get(), this.contextProvider.get());
    }

    public static AuthEntityDataFactory_Factory create(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4) {
        return new AuthEntityDataFactory_Factory(provider, provider2, provider3, provider4);
    }

    public static AuthEntityDataFactory newInstance(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        return new AuthEntityDataFactory(rpcConnector, threadExecutor, apSecurityFacade, context);
    }
}
