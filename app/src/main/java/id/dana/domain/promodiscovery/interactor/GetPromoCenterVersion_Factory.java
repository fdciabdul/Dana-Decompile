package id.dana.domain.promodiscovery.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetPromoCenterVersion_Factory implements Factory<GetPromoCenterVersion> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetPromoCenterVersion_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetPromoCenterVersion get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetPromoCenterVersion_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetPromoCenterVersion_Factory(provider);
    }

    public static GetPromoCenterVersion newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetPromoCenterVersion(featureConfigRepository);
    }
}
