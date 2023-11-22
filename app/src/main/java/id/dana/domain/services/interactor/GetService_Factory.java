package id.dana.domain.services.interactor;

import dagger.internal.Factory;
import id.dana.domain.services.ServicesRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetService_Factory implements Factory<GetService> {
    private final Provider<ServicesRepository> repositoryProvider;

    public GetService_Factory(Provider<ServicesRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetService get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static GetService_Factory create(Provider<ServicesRepository> provider) {
        return new GetService_Factory(provider);
    }

    public static GetService newInstance(ServicesRepository servicesRepository) {
        return new GetService(servicesRepository);
    }
}
