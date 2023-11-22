package id.dana.domain.services.interactor;

import dagger.internal.Factory;
import id.dana.domain.services.ServicesRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetRawServices_Factory implements Factory<GetRawServices> {
    private final Provider<ServicesRepository> repositoryProvider;

    public GetRawServices_Factory(Provider<ServicesRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetRawServices get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static GetRawServices_Factory create(Provider<ServicesRepository> provider) {
        return new GetRawServices_Factory(provider);
    }

    public static GetRawServices newInstance(ServicesRepository servicesRepository) {
        return new GetRawServices(servicesRepository);
    }
}
