package id.dana.data.homeinfo.repository.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.feeds.repository.source.FeedsEntityDataFactory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.notificationcenter.repository.source.NotificationCenterEntityDataFactory;
import id.dana.domain.promotion.repository.PromotionRepository;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkHomeEntityData_Factory implements Factory<NetworkHomeEntityData> {
    private final Provider<Context> contextProvider;
    private final Provider<ThreadExecutor> executorProvider;
    private final Provider<FeedsEntityDataFactory> feedsEntityDataFactoryProvider;
    private final Provider<NotificationCenterEntityDataFactory> notificationCenterEntityDataFactoryProvider;
    private final Provider<PromotionRepository> promotionRepositoryProvider;
    private final Provider<RpcConnector> rpcConnectorProvider;
    private final Provider<ApSecurityFacade> securityFacadeProvider;

    public NetworkHomeEntityData_Factory(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4, Provider<FeedsEntityDataFactory> provider5, Provider<PromotionRepository> provider6, Provider<NotificationCenterEntityDataFactory> provider7) {
        this.rpcConnectorProvider = provider;
        this.executorProvider = provider2;
        this.securityFacadeProvider = provider3;
        this.contextProvider = provider4;
        this.feedsEntityDataFactoryProvider = provider5;
        this.promotionRepositoryProvider = provider6;
        this.notificationCenterEntityDataFactoryProvider = provider7;
    }

    @Override // javax.inject.Provider
    public final NetworkHomeEntityData get() {
        return newInstance(this.rpcConnectorProvider.get(), this.executorProvider.get(), this.securityFacadeProvider.get(), this.contextProvider.get(), this.feedsEntityDataFactoryProvider.get(), this.promotionRepositoryProvider.get(), this.notificationCenterEntityDataFactoryProvider.get());
    }

    public static NetworkHomeEntityData_Factory create(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4, Provider<FeedsEntityDataFactory> provider5, Provider<PromotionRepository> provider6, Provider<NotificationCenterEntityDataFactory> provider7) {
        return new NetworkHomeEntityData_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static NetworkHomeEntityData newInstance(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context, FeedsEntityDataFactory feedsEntityDataFactory, PromotionRepository promotionRepository, NotificationCenterEntityDataFactory notificationCenterEntityDataFactory) {
        return new NetworkHomeEntityData(rpcConnector, threadExecutor, apSecurityFacade, context, feedsEntityDataFactory, promotionRepository, notificationCenterEntityDataFactory);
    }
}
