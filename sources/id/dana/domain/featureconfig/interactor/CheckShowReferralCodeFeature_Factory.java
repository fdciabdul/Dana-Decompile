package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckShowReferralCodeFeature_Factory implements Factory<CheckShowReferralCodeFeature> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public CheckShowReferralCodeFeature_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckShowReferralCodeFeature get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static CheckShowReferralCodeFeature_Factory create(Provider<FeatureConfigRepository> provider) {
        return new CheckShowReferralCodeFeature_Factory(provider);
    }

    public static CheckShowReferralCodeFeature newInstance(FeatureConfigRepository featureConfigRepository) {
        return new CheckShowReferralCodeFeature(featureConfigRepository);
    }
}
