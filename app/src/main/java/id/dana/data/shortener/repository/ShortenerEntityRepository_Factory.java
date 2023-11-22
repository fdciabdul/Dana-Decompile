package id.dana.data.shortener.repository;

import dagger.internal.Factory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.shortener.repository.source.UrlShortenerEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ShortenerEntityRepository_Factory implements Factory<ShortenerEntityRepository> {
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<UrlShortenerEntityDataFactory> urlShortenerEntityDataFactoryProvider;

    public ShortenerEntityRepository_Factory(Provider<UrlShortenerEntityDataFactory> provider, Provider<HoldLoginV1EntityRepository> provider2) {
        this.urlShortenerEntityDataFactoryProvider = provider;
        this.holdLoginV1EntityRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final ShortenerEntityRepository get() {
        return newInstance(this.urlShortenerEntityDataFactoryProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static ShortenerEntityRepository_Factory create(Provider<UrlShortenerEntityDataFactory> provider, Provider<HoldLoginV1EntityRepository> provider2) {
        return new ShortenerEntityRepository_Factory(provider, provider2);
    }

    public static ShortenerEntityRepository newInstance(UrlShortenerEntityDataFactory urlShortenerEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new ShortenerEntityRepository(urlShortenerEntityDataFactory, holdLoginV1EntityRepository);
    }
}
