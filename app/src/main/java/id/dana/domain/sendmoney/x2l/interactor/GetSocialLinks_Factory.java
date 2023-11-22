package id.dana.domain.sendmoney.x2l.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetSocialLinks_Factory implements Factory<GetSocialLinks> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetSocialLinks_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetSocialLinks get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetSocialLinks_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetSocialLinks_Factory(provider);
    }

    public static GetSocialLinks newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetSocialLinks(featureConfigRepository);
    }
}
