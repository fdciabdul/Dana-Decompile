package id.dana.domain.services.interactor;

import dagger.internal.Factory;
import id.dana.domain.services.ServicesRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetFavoriteServiceRemote_Factory implements Factory<GetFavoriteServiceRemote> {
    private final Provider<ServicesRepository> servicesRepositoryProvider;

    public GetFavoriteServiceRemote_Factory(Provider<ServicesRepository> provider) {
        this.servicesRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetFavoriteServiceRemote get() {
        return newInstance(this.servicesRepositoryProvider.get());
    }

    public static GetFavoriteServiceRemote_Factory create(Provider<ServicesRepository> provider) {
        return new GetFavoriteServiceRemote_Factory(provider);
    }

    public static GetFavoriteServiceRemote newInstance(ServicesRepository servicesRepository) {
        return new GetFavoriteServiceRemote(servicesRepository);
    }
}
