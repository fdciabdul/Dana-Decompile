package id.dana.domain.citcall.interactor;

import dagger.internal.Factory;
import id.dana.domain.citcall.CitcallRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetCitcallOtp_Factory implements Factory<GetCitcallOtp> {
    private final Provider<CitcallRepository> citcallRepositoryProvider;

    public GetCitcallOtp_Factory(Provider<CitcallRepository> provider) {
        this.citcallRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetCitcallOtp get() {
        return newInstance(this.citcallRepositoryProvider.get());
    }

    public static GetCitcallOtp_Factory create(Provider<CitcallRepository> provider) {
        return new GetCitcallOtp_Factory(provider);
    }

    public static GetCitcallOtp newInstance(CitcallRepository citcallRepository) {
        return new GetCitcallOtp(citcallRepository);
    }
}
