package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetAuthenticationTypeFeature_Factory implements Factory<GetAuthenticationTypeFeature> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetAuthenticationTypeFeature_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetAuthenticationTypeFeature get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetAuthenticationTypeFeature_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetAuthenticationTypeFeature_Factory(provider);
    }

    public static GetAuthenticationTypeFeature newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetAuthenticationTypeFeature(featureConfigRepository);
    }
}
