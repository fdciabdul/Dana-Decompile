package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class CheckCashierDeeplinkKybFeature_Factory implements Factory<CheckCashierDeeplinkKybFeature> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public CheckCashierDeeplinkKybFeature_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckCashierDeeplinkKybFeature get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static CheckCashierDeeplinkKybFeature_Factory create(Provider<FeatureConfigRepository> provider) {
        return new CheckCashierDeeplinkKybFeature_Factory(provider);
    }

    public static CheckCashierDeeplinkKybFeature newInstance(FeatureConfigRepository featureConfigRepository) {
        return new CheckCashierDeeplinkKybFeature(featureConfigRepository);
    }
}
