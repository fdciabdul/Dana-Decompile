package id.dana.domain.qriscrossborder.interactor;

import dagger.internal.Factory;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetQrisCountryCodeByLocation_Factory implements Factory<GetQrisCountryCodeByLocation> {
    private final Provider<GlobalNetworkRepository> globalNetworkRepositoryProvider;

    public GetQrisCountryCodeByLocation_Factory(Provider<GlobalNetworkRepository> provider) {
        this.globalNetworkRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetQrisCountryCodeByLocation get() {
        return newInstance(this.globalNetworkRepositoryProvider.get());
    }

    public static GetQrisCountryCodeByLocation_Factory create(Provider<GlobalNetworkRepository> provider) {
        return new GetQrisCountryCodeByLocation_Factory(provider);
    }

    public static GetQrisCountryCodeByLocation newInstance(GlobalNetworkRepository globalNetworkRepository) {
        return new GetQrisCountryCodeByLocation(globalNetworkRepository);
    }
}
