package id.dana.domain.services.interactor;

import dagger.internal.Factory;
import id.dana.domain.services.ServicesRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetDefaultServiceWithCategory_Factory implements Factory<GetDefaultServiceWithCategory> {
    private final Provider<ServicesRepository> servicesRepositoryProvider;

    public GetDefaultServiceWithCategory_Factory(Provider<ServicesRepository> provider) {
        this.servicesRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetDefaultServiceWithCategory get() {
        return newInstance(this.servicesRepositoryProvider.get());
    }

    public static GetDefaultServiceWithCategory_Factory create(Provider<ServicesRepository> provider) {
        return new GetDefaultServiceWithCategory_Factory(provider);
    }

    public static GetDefaultServiceWithCategory newInstance(ServicesRepository servicesRepository) {
        return new GetDefaultServiceWithCategory(servicesRepository);
    }
}
