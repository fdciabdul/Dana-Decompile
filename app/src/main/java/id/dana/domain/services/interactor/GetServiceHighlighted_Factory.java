package id.dana.domain.services.interactor;

import dagger.internal.Factory;
import id.dana.domain.services.ServicesRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetServiceHighlighted_Factory implements Factory<GetServiceHighlighted> {
    private final Provider<ServicesRepository> servicesRepositoryProvider;

    public GetServiceHighlighted_Factory(Provider<ServicesRepository> provider) {
        this.servicesRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetServiceHighlighted get() {
        return newInstance(this.servicesRepositoryProvider.get());
    }

    public static GetServiceHighlighted_Factory create(Provider<ServicesRepository> provider) {
        return new GetServiceHighlighted_Factory(provider);
    }

    public static GetServiceHighlighted newInstance(ServicesRepository servicesRepository) {
        return new GetServiceHighlighted(servicesRepository);
    }
}
