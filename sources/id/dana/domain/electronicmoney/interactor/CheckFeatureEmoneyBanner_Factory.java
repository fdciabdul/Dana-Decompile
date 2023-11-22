package id.dana.domain.electronicmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class CheckFeatureEmoneyBanner_Factory implements Factory<CheckFeatureEmoneyBanner> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public CheckFeatureEmoneyBanner_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckFeatureEmoneyBanner get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static CheckFeatureEmoneyBanner_Factory create(Provider<FeatureConfigRepository> provider) {
        return new CheckFeatureEmoneyBanner_Factory(provider);
    }

    public static CheckFeatureEmoneyBanner newInstance(FeatureConfigRepository featureConfigRepository) {
        return new CheckFeatureEmoneyBanner(featureConfigRepository);
    }
}
