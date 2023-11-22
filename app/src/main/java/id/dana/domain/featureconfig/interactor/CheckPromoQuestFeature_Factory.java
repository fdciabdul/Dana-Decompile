package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class CheckPromoQuestFeature_Factory implements Factory<CheckPromoQuestFeature> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public CheckPromoQuestFeature_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckPromoQuestFeature get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static CheckPromoQuestFeature_Factory create(Provider<FeatureConfigRepository> provider) {
        return new CheckPromoQuestFeature_Factory(provider);
    }

    public static CheckPromoQuestFeature newInstance(FeatureConfigRepository featureConfigRepository) {
        return new CheckPromoQuestFeature(featureConfigRepository);
    }
}
