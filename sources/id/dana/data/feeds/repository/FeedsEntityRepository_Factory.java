package id.dana.data.feeds.repository;

import dagger.internal.Factory;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.feeds.mapper.DeleteFeedResultMapper;
import id.dana.data.feeds.mapper.FeedsResultMapper;
import id.dana.data.feeds.repository.source.FeedsEntityDataFactory;
import id.dana.data.feeds.repository.source.cache.FeedsCacheEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FeedsEntityRepository_Factory implements Factory<FeedsEntityRepository> {
    private final Provider<FeedsCacheEntityDataFactory> cacheFactoryProvider;
    private final Provider<ConfigEntityDataFactory> configEntityDataFactoryProvider;
    private final Provider<DeleteFeedResultMapper> deleteFeedResultMapperProvider;
    private final Provider<FeedsEntityDataFactory> factoryProvider;
    private final Provider<FeedsResultMapper> feedsResultMapperProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;

    public FeedsEntityRepository_Factory(Provider<DeleteFeedResultMapper> provider, Provider<FeedsEntityDataFactory> provider2, Provider<FeedsCacheEntityDataFactory> provider3, Provider<ConfigEntityDataFactory> provider4, Provider<FeedsResultMapper> provider5, Provider<HoldLoginV1EntityRepository> provider6) {
        this.deleteFeedResultMapperProvider = provider;
        this.factoryProvider = provider2;
        this.cacheFactoryProvider = provider3;
        this.configEntityDataFactoryProvider = provider4;
        this.feedsResultMapperProvider = provider5;
        this.holdLoginV1EntityRepositoryProvider = provider6;
    }

    @Override // javax.inject.Provider
    public final FeedsEntityRepository get() {
        return newInstance(this.deleteFeedResultMapperProvider.get(), this.factoryProvider.get(), this.cacheFactoryProvider.get(), this.configEntityDataFactoryProvider.get(), this.feedsResultMapperProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static FeedsEntityRepository_Factory create(Provider<DeleteFeedResultMapper> provider, Provider<FeedsEntityDataFactory> provider2, Provider<FeedsCacheEntityDataFactory> provider3, Provider<ConfigEntityDataFactory> provider4, Provider<FeedsResultMapper> provider5, Provider<HoldLoginV1EntityRepository> provider6) {
        return new FeedsEntityRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static FeedsEntityRepository newInstance(DeleteFeedResultMapper deleteFeedResultMapper, FeedsEntityDataFactory feedsEntityDataFactory, FeedsCacheEntityDataFactory feedsCacheEntityDataFactory, ConfigEntityDataFactory configEntityDataFactory, FeedsResultMapper feedsResultMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new FeedsEntityRepository(deleteFeedResultMapper, feedsEntityDataFactory, feedsCacheEntityDataFactory, configEntityDataFactory, feedsResultMapper, holdLoginV1EntityRepository);
    }
}
