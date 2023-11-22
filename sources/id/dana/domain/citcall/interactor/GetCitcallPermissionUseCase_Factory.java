package id.dana.domain.citcall.interactor;

import dagger.internal.Factory;
import id.dana.domain.citcall.CitcallRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetCitcallPermissionUseCase_Factory implements Factory<GetCitcallPermissionUseCase> {
    private final Provider<CitcallRepository> citcallRepositoryProvider;

    public GetCitcallPermissionUseCase_Factory(Provider<CitcallRepository> provider) {
        this.citcallRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetCitcallPermissionUseCase get() {
        return newInstance(this.citcallRepositoryProvider.get());
    }

    public static GetCitcallPermissionUseCase_Factory create(Provider<CitcallRepository> provider) {
        return new GetCitcallPermissionUseCase_Factory(provider);
    }

    public static GetCitcallPermissionUseCase newInstance(CitcallRepository citcallRepository) {
        return new GetCitcallPermissionUseCase(citcallRepository);
    }
}
