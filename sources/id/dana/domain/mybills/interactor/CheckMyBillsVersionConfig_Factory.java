package id.dana.domain.mybills.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckMyBillsVersionConfig_Factory implements Factory<CheckMyBillsVersionConfig> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public CheckMyBillsVersionConfig_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckMyBillsVersionConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static CheckMyBillsVersionConfig_Factory create(Provider<FeatureConfigRepository> provider) {
        return new CheckMyBillsVersionConfig_Factory(provider);
    }

    public static CheckMyBillsVersionConfig newInstance(FeatureConfigRepository featureConfigRepository) {
        return new CheckMyBillsVersionConfig(featureConfigRepository);
    }
}
