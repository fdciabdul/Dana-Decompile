package id.dana.domain.oauth.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetGnBindingBenefits_Factory implements Factory<GetGnBindingBenefits> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetGnBindingBenefits_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetGnBindingBenefits get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetGnBindingBenefits_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetGnBindingBenefits_Factory(provider);
    }

    public static GetGnBindingBenefits newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetGnBindingBenefits(featureConfigRepository);
    }
}
