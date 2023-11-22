package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class IsFeaturePaylaterCicilScannerEnabled_Factory implements Factory<IsFeaturePaylaterCicilScannerEnabled> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public IsFeaturePaylaterCicilScannerEnabled_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final IsFeaturePaylaterCicilScannerEnabled get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static IsFeaturePaylaterCicilScannerEnabled_Factory create(Provider<FeatureConfigRepository> provider) {
        return new IsFeaturePaylaterCicilScannerEnabled_Factory(provider);
    }

    public static IsFeaturePaylaterCicilScannerEnabled newInstance(FeatureConfigRepository featureConfigRepository) {
        return new IsFeaturePaylaterCicilScannerEnabled(featureConfigRepository);
    }
}
