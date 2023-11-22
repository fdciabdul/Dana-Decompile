package id.dana.domain.homeinfo.interactor;

import dagger.internal.Factory;
import id.dana.domain.homeinfo.repository.HomeConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetFeatureHoldLoginConfig_Factory implements Factory<GetFeatureHoldLoginConfig> {
    private final Provider<HomeConfigRepository> homeConfigRepositoryProvider;

    public GetFeatureHoldLoginConfig_Factory(Provider<HomeConfigRepository> provider) {
        this.homeConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetFeatureHoldLoginConfig get() {
        return newInstance(this.homeConfigRepositoryProvider.get());
    }

    public static GetFeatureHoldLoginConfig_Factory create(Provider<HomeConfigRepository> provider) {
        return new GetFeatureHoldLoginConfig_Factory(provider);
    }

    public static GetFeatureHoldLoginConfig newInstance(HomeConfigRepository homeConfigRepository) {
        return new GetFeatureHoldLoginConfig(homeConfigRepository);
    }
}
