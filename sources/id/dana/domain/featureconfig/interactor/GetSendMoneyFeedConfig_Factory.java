package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetSendMoneyFeedConfig_Factory implements Factory<GetSendMoneyFeedConfig> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetSendMoneyFeedConfig_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetSendMoneyFeedConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetSendMoneyFeedConfig_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetSendMoneyFeedConfig_Factory(provider);
    }

    public static GetSendMoneyFeedConfig newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetSendMoneyFeedConfig(featureConfigRepository);
    }
}
