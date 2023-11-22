package id.dana.domain.services.interactor;

import dagger.internal.Factory;
import id.dana.domain.services.ServicesRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ClearCacheFavoriteServices_Factory implements Factory<ClearCacheFavoriteServices> {
    private final Provider<ServicesRepository> servicesRepositoryProvider;

    public ClearCacheFavoriteServices_Factory(Provider<ServicesRepository> provider) {
        this.servicesRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ClearCacheFavoriteServices get() {
        return newInstance(this.servicesRepositoryProvider.get());
    }

    public static ClearCacheFavoriteServices_Factory create(Provider<ServicesRepository> provider) {
        return new ClearCacheFavoriteServices_Factory(provider);
    }

    public static ClearCacheFavoriteServices newInstance(ServicesRepository servicesRepository) {
        return new ClearCacheFavoriteServices(servicesRepository);
    }
}
