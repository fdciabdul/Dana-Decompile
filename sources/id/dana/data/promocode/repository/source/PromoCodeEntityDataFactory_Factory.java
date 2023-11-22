package id.dana.data.promocode.repository.source;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PromoCodeEntityDataFactory_Factory implements Factory<PromoCodeEntityDataFactory> {
    private final Provider<ApSecurityFacade> apSecurityFacadeProvider;
    private final Provider<Context> contextProvider;
    private final Provider<ThreadExecutor> executorProvider;
    private final Provider<RpcConnector> rpcConnectorProvider;

    public PromoCodeEntityDataFactory_Factory(Provider<Context> provider, Provider<ApSecurityFacade> provider2, Provider<ThreadExecutor> provider3, Provider<RpcConnector> provider4) {
        this.contextProvider = provider;
        this.apSecurityFacadeProvider = provider2;
        this.executorProvider = provider3;
        this.rpcConnectorProvider = provider4;
    }

    @Override // javax.inject.Provider
    public final PromoCodeEntityDataFactory get() {
        return newInstance(this.contextProvider.get(), this.apSecurityFacadeProvider.get(), this.executorProvider.get(), this.rpcConnectorProvider.get());
    }

    public static PromoCodeEntityDataFactory_Factory create(Provider<Context> provider, Provider<ApSecurityFacade> provider2, Provider<ThreadExecutor> provider3, Provider<RpcConnector> provider4) {
        return new PromoCodeEntityDataFactory_Factory(provider, provider2, provider3, provider4);
    }

    public static PromoCodeEntityDataFactory newInstance(Context context, ApSecurityFacade apSecurityFacade, ThreadExecutor threadExecutor, RpcConnector rpcConnector) {
        return new PromoCodeEntityDataFactory(context, apSecurityFacade, threadExecutor, rpcConnector);
    }
}
