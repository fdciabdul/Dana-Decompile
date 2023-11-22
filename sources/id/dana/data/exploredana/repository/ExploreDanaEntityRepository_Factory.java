package id.dana.data.exploredana.repository;

import dagger.internal.Factory;
import id.dana.data.content.mapper.SpaceResultMapper;
import id.dana.data.content.source.ContentDeliveryEntityDataFactory;
import id.dana.data.content.source.cache.ContentDeliveryCacheEntityDataFactory;
import id.dana.data.exploredana.repository.source.local.ExploreDanaPreferencesDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ExploreDanaEntityRepository_Factory implements Factory<ExploreDanaEntityRepository> {
    private final Provider<ContentDeliveryCacheEntityDataFactory> contentDeliveryCacheEntityDataFactoryProvider;
    private final Provider<ContentDeliveryEntityDataFactory> contentDeliveryEntityDataFactoryProvider;
    private final Provider<ExploreDanaPreferencesDataFactory> exploreDanaPreferencesDataFactoryProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<SpaceResultMapper> spaceResultMapperProvider;

    public ExploreDanaEntityRepository_Factory(Provider<ContentDeliveryEntityDataFactory> provider, Provider<ExploreDanaPreferencesDataFactory> provider2, Provider<ContentDeliveryCacheEntityDataFactory> provider3, Provider<SpaceResultMapper> provider4, Provider<HoldLoginV1EntityRepository> provider5) {
        this.contentDeliveryEntityDataFactoryProvider = provider;
        this.exploreDanaPreferencesDataFactoryProvider = provider2;
        this.contentDeliveryCacheEntityDataFactoryProvider = provider3;
        this.spaceResultMapperProvider = provider4;
        this.holdLoginV1EntityRepositoryProvider = provider5;
    }

    @Override // javax.inject.Provider
    public final ExploreDanaEntityRepository get() {
        return newInstance(this.contentDeliveryEntityDataFactoryProvider.get(), this.exploreDanaPreferencesDataFactoryProvider.get(), this.contentDeliveryCacheEntityDataFactoryProvider.get(), this.spaceResultMapperProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static ExploreDanaEntityRepository_Factory create(Provider<ContentDeliveryEntityDataFactory> provider, Provider<ExploreDanaPreferencesDataFactory> provider2, Provider<ContentDeliveryCacheEntityDataFactory> provider3, Provider<SpaceResultMapper> provider4, Provider<HoldLoginV1EntityRepository> provider5) {
        return new ExploreDanaEntityRepository_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static ExploreDanaEntityRepository newInstance(ContentDeliveryEntityDataFactory contentDeliveryEntityDataFactory, ExploreDanaPreferencesDataFactory exploreDanaPreferencesDataFactory, ContentDeliveryCacheEntityDataFactory contentDeliveryCacheEntityDataFactory, SpaceResultMapper spaceResultMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new ExploreDanaEntityRepository(contentDeliveryEntityDataFactory, exploreDanaPreferencesDataFactory, contentDeliveryCacheEntityDataFactory, spaceResultMapper, holdLoginV1EntityRepository);
    }
}
