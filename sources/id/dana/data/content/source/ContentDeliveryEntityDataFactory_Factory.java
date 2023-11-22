package id.dana.data.content.source;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.storage.Serializer;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ContentDeliveryEntityDataFactory_Factory implements Factory<ContentDeliveryEntityDataFactory> {
    private final Provider<ApSecurityFacade> apSecurityFacadeProvider;
    private final Provider<Context> contextProvider;
    private final Provider<ThreadExecutor> executorProvider;
    private final Provider<RpcConnector> rpcConnectorProvider;
    private final Provider<Serializer> serializerProvider;

    public ContentDeliveryEntityDataFactory_Factory(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4, Provider<Serializer> provider5) {
        this.rpcConnectorProvider = provider;
        this.executorProvider = provider2;
        this.apSecurityFacadeProvider = provider3;
        this.contextProvider = provider4;
        this.serializerProvider = provider5;
    }

    @Override // javax.inject.Provider
    public final ContentDeliveryEntityDataFactory get() {
        return newInstance(this.rpcConnectorProvider.get(), this.executorProvider.get(), this.apSecurityFacadeProvider.get(), this.contextProvider.get(), this.serializerProvider.get());
    }

    public static ContentDeliveryEntityDataFactory_Factory create(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4, Provider<Serializer> provider5) {
        return new ContentDeliveryEntityDataFactory_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static ContentDeliveryEntityDataFactory newInstance(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context, Serializer serializer) {
        return new ContentDeliveryEntityDataFactory(rpcConnector, threadExecutor, apSecurityFacade, context, serializer);
    }
}
