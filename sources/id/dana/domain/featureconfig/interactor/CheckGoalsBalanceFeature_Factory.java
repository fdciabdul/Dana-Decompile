package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckGoalsBalanceFeature_Factory implements Factory<CheckGoalsBalanceFeature> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public CheckGoalsBalanceFeature_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckGoalsBalanceFeature get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static CheckGoalsBalanceFeature_Factory create(Provider<FeatureConfigRepository> provider) {
        return new CheckGoalsBalanceFeature_Factory(provider);
    }

    public static CheckGoalsBalanceFeature newInstance(FeatureConfigRepository featureConfigRepository) {
        return new CheckGoalsBalanceFeature(featureConfigRepository);
    }
}
