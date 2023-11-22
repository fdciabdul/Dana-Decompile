package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetReferralMessageTemplate_Factory implements Factory<GetReferralMessageTemplate> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetReferralMessageTemplate_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetReferralMessageTemplate get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetReferralMessageTemplate_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetReferralMessageTemplate_Factory(provider);
    }

    public static GetReferralMessageTemplate newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetReferralMessageTemplate(featureConfigRepository);
    }
}
