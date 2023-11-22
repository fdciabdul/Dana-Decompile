package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckQrisCardPaymentTncFeature_Factory implements Factory<CheckQrisCardPaymentTncFeature> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public CheckQrisCardPaymentTncFeature_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckQrisCardPaymentTncFeature get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static CheckQrisCardPaymentTncFeature_Factory create(Provider<FeatureConfigRepository> provider) {
        return new CheckQrisCardPaymentTncFeature_Factory(provider);
    }

    public static CheckQrisCardPaymentTncFeature newInstance(FeatureConfigRepository featureConfigRepository) {
        return new CheckQrisCardPaymentTncFeature(featureConfigRepository);
    }
}
