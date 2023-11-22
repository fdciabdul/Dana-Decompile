package id.dana.domain.services.interactor;

import dagger.internal.Factory;
import id.dana.domain.services.ServicesRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class UpdateServiceHighlighted_Factory implements Factory<UpdateServiceHighlighted> {
    private final Provider<ServicesRepository> servicesRepositoryProvider;

    public UpdateServiceHighlighted_Factory(Provider<ServicesRepository> provider) {
        this.servicesRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final UpdateServiceHighlighted get() {
        return newInstance(this.servicesRepositoryProvider.get());
    }

    public static UpdateServiceHighlighted_Factory create(Provider<ServicesRepository> provider) {
        return new UpdateServiceHighlighted_Factory(provider);
    }

    public static UpdateServiceHighlighted newInstance(ServicesRepository servicesRepository) {
        return new UpdateServiceHighlighted(servicesRepository);
    }
}
