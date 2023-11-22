package id.dana.domain.services.interactor;

import dagger.internal.Factory;
import id.dana.domain.services.ServicesRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetServicesWithCategory_Factory implements Factory<GetServicesWithCategory> {
    private final Provider<ServicesRepository> servicesRepositoryProvider;

    public GetServicesWithCategory_Factory(Provider<ServicesRepository> provider) {
        this.servicesRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetServicesWithCategory get() {
        return newInstance(this.servicesRepositoryProvider.get());
    }

    public static GetServicesWithCategory_Factory create(Provider<ServicesRepository> provider) {
        return new GetServicesWithCategory_Factory(provider);
    }

    public static GetServicesWithCategory newInstance(ServicesRepository servicesRepository) {
        return new GetServicesWithCategory(servicesRepository);
    }
}
