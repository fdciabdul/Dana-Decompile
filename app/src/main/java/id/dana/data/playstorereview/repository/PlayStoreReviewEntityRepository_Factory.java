package id.dana.data.playstorereview.repository;

import dagger.internal.Factory;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.playstorereview.mapper.PlayStoreReviewEntityMapper;
import id.dana.data.playstorereview.repository.source.PlayStoreReviewDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PlayStoreReviewEntityRepository_Factory implements Factory<PlayStoreReviewEntityRepository> {
    private final Provider<ConfigEntityDataFactory> configEntityDataFactoryProvider;
    private final Provider<PlayStoreReviewDataFactory> playStoreReviewDataFactoryProvider;
    private final Provider<PlayStoreReviewEntityMapper> playStoreReviewEntityMapperProvider;

    public PlayStoreReviewEntityRepository_Factory(Provider<PlayStoreReviewDataFactory> provider, Provider<ConfigEntityDataFactory> provider2, Provider<PlayStoreReviewEntityMapper> provider3) {
        this.playStoreReviewDataFactoryProvider = provider;
        this.configEntityDataFactoryProvider = provider2;
        this.playStoreReviewEntityMapperProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final PlayStoreReviewEntityRepository get() {
        return newInstance(this.playStoreReviewDataFactoryProvider.get(), this.configEntityDataFactoryProvider.get(), this.playStoreReviewEntityMapperProvider.get());
    }

    public static PlayStoreReviewEntityRepository_Factory create(Provider<PlayStoreReviewDataFactory> provider, Provider<ConfigEntityDataFactory> provider2, Provider<PlayStoreReviewEntityMapper> provider3) {
        return new PlayStoreReviewEntityRepository_Factory(provider, provider2, provider3);
    }

    public static PlayStoreReviewEntityRepository newInstance(PlayStoreReviewDataFactory playStoreReviewDataFactory, ConfigEntityDataFactory configEntityDataFactory, PlayStoreReviewEntityMapper playStoreReviewEntityMapper) {
        return new PlayStoreReviewEntityRepository(playStoreReviewDataFactory, configEntityDataFactory, playStoreReviewEntityMapper);
    }
}
