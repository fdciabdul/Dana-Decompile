package id.dana.domain.investment.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckFeatureInvestment_Factory implements Factory<CheckFeatureInvestment> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public CheckFeatureInvestment_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckFeatureInvestment get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static CheckFeatureInvestment_Factory create(Provider<FeatureConfigRepository> provider) {
        return new CheckFeatureInvestment_Factory(provider);
    }

    public static CheckFeatureInvestment newInstance(FeatureConfigRepository featureConfigRepository) {
        return new CheckFeatureInvestment(featureConfigRepository);
    }
}
