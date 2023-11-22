package id.dana.domain.globalnetwork.interactor;

import dagger.internal.Factory;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetGnCScanBBlacklistedCountry_Factory implements Factory<GetGnCScanBBlacklistedCountry> {
    private final Provider<GlobalNetworkRepository> globalNetworkRepositoryProvider;

    public GetGnCScanBBlacklistedCountry_Factory(Provider<GlobalNetworkRepository> provider) {
        this.globalNetworkRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetGnCScanBBlacklistedCountry get() {
        return newInstance(this.globalNetworkRepositoryProvider.get());
    }

    public static GetGnCScanBBlacklistedCountry_Factory create(Provider<GlobalNetworkRepository> provider) {
        return new GetGnCScanBBlacklistedCountry_Factory(provider);
    }

    public static GetGnCScanBBlacklistedCountry newInstance(GlobalNetworkRepository globalNetworkRepository) {
        return new GetGnCScanBBlacklistedCountry(globalNetworkRepository);
    }
}
