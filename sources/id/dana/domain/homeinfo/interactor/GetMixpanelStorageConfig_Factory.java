package id.dana.domain.homeinfo.interactor;

import dagger.internal.Factory;
import id.dana.domain.homeinfo.repository.HomeConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetMixpanelStorageConfig_Factory implements Factory<GetMixpanelStorageConfig> {
    private final Provider<HomeConfigRepository> homeConfigRepositoryProvider;

    public GetMixpanelStorageConfig_Factory(Provider<HomeConfigRepository> provider) {
        this.homeConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetMixpanelStorageConfig get() {
        return newInstance(this.homeConfigRepositoryProvider.get());
    }

    public static GetMixpanelStorageConfig_Factory create(Provider<HomeConfigRepository> provider) {
        return new GetMixpanelStorageConfig_Factory(provider);
    }

    public static GetMixpanelStorageConfig newInstance(HomeConfigRepository homeConfigRepository) {
        return new GetMixpanelStorageConfig(homeConfigRepository);
    }
}
