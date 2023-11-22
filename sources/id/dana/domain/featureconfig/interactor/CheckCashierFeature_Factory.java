package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckCashierFeature_Factory implements Factory<CheckCashierFeature> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public CheckCashierFeature_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckCashierFeature get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static CheckCashierFeature_Factory create(Provider<FeatureConfigRepository> provider) {
        return new CheckCashierFeature_Factory(provider);
    }

    public static CheckCashierFeature newInstance(FeatureConfigRepository featureConfigRepository) {
        return new CheckCashierFeature(featureConfigRepository);
    }
}
