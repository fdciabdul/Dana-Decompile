package id.dana.domain.here.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class InitHereConfig_Factory implements Factory<InitHereConfig> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public InitHereConfig_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final InitHereConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static InitHereConfig_Factory create(Provider<FeatureConfigRepository> provider) {
        return new InitHereConfig_Factory(provider);
    }

    public static InitHereConfig newInstance(FeatureConfigRepository featureConfigRepository) {
        return new InitHereConfig(featureConfigRepository);
    }
}
