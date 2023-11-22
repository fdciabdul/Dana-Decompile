package id.dana.domain.homeinfo.interactor;

import dagger.internal.Factory;
import id.dana.domain.homeinfo.repository.HomeConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetVoiceAssistantConfig_Factory implements Factory<GetVoiceAssistantConfig> {
    private final Provider<HomeConfigRepository> homeConfigRepositoryProvider;

    public GetVoiceAssistantConfig_Factory(Provider<HomeConfigRepository> provider) {
        this.homeConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetVoiceAssistantConfig get() {
        return newInstance(this.homeConfigRepositoryProvider.get());
    }

    public static GetVoiceAssistantConfig_Factory create(Provider<HomeConfigRepository> provider) {
        return new GetVoiceAssistantConfig_Factory(provider);
    }

    public static GetVoiceAssistantConfig newInstance(HomeConfigRepository homeConfigRepository) {
        return new GetVoiceAssistantConfig(homeConfigRepository);
    }
}
