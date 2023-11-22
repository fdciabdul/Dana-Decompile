package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetFrozenAccountChatbotConfig_Factory implements Factory<GetFrozenAccountChatbotConfig> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetFrozenAccountChatbotConfig_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetFrozenAccountChatbotConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetFrozenAccountChatbotConfig_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetFrozenAccountChatbotConfig_Factory(provider);
    }

    public static GetFrozenAccountChatbotConfig newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetFrozenAccountChatbotConfig(featureConfigRepository);
    }
}
