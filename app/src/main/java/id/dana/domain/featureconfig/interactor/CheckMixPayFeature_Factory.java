package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckMixPayFeature_Factory implements Factory<CheckMixPayFeature> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public CheckMixPayFeature_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckMixPayFeature get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static CheckMixPayFeature_Factory create(Provider<FeatureConfigRepository> provider) {
        return new CheckMixPayFeature_Factory(provider);
    }

    public static CheckMixPayFeature newInstance(FeatureConfigRepository featureConfigRepository) {
        return new CheckMixPayFeature(featureConfigRepository);
    }
}
