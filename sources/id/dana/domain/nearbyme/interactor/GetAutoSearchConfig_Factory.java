package id.dana.domain.nearbyme.interactor;

import dagger.internal.Factory;
import id.dana.domain.nearbyme.NearbyMeRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetAutoSearchConfig_Factory implements Factory<GetAutoSearchConfig> {
    private final Provider<NearbyMeRepository> repositoryProvider;

    public GetAutoSearchConfig_Factory(Provider<NearbyMeRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetAutoSearchConfig get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static GetAutoSearchConfig_Factory create(Provider<NearbyMeRepository> provider) {
        return new GetAutoSearchConfig_Factory(provider);
    }

    public static GetAutoSearchConfig newInstance(NearbyMeRepository nearbyMeRepository) {
        return new GetAutoSearchConfig(nearbyMeRepository);
    }
}
