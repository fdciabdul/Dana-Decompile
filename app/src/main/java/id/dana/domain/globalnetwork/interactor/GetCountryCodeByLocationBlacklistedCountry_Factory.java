package id.dana.domain.globalnetwork.interactor;

import dagger.internal.Factory;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetCountryCodeByLocationBlacklistedCountry_Factory implements Factory<GetCountryCodeByLocationBlacklistedCountry> {
    private final Provider<GlobalNetworkRepository> globalNetworkRepositoryProvider;

    public GetCountryCodeByLocationBlacklistedCountry_Factory(Provider<GlobalNetworkRepository> provider) {
        this.globalNetworkRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetCountryCodeByLocationBlacklistedCountry get() {
        return newInstance(this.globalNetworkRepositoryProvider.get());
    }

    public static GetCountryCodeByLocationBlacklistedCountry_Factory create(Provider<GlobalNetworkRepository> provider) {
        return new GetCountryCodeByLocationBlacklistedCountry_Factory(provider);
    }

    public static GetCountryCodeByLocationBlacklistedCountry newInstance(GlobalNetworkRepository globalNetworkRepository) {
        return new GetCountryCodeByLocationBlacklistedCountry(globalNetworkRepository);
    }
}
