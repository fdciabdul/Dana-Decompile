package id.dana.domain.services.interactor;

import dagger.internal.Factory;
import id.dana.domain.services.ServicesRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetFavoriteServiceWithCacheFirst_Factory implements Factory<GetFavoriteServiceWithCacheFirst> {
    private final Provider<ServicesRepository> servicesRepositoryProvider;

    public GetFavoriteServiceWithCacheFirst_Factory(Provider<ServicesRepository> provider) {
        this.servicesRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetFavoriteServiceWithCacheFirst get() {
        return newInstance(this.servicesRepositoryProvider.get());
    }

    public static GetFavoriteServiceWithCacheFirst_Factory create(Provider<ServicesRepository> provider) {
        return new GetFavoriteServiceWithCacheFirst_Factory(provider);
    }

    public static GetFavoriteServiceWithCacheFirst newInstance(ServicesRepository servicesRepository) {
        return new GetFavoriteServiceWithCacheFirst(servicesRepository);
    }
}
