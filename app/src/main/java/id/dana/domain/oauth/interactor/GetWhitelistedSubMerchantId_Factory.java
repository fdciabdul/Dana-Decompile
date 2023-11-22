package id.dana.domain.oauth.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetWhitelistedSubMerchantId_Factory implements Factory<GetWhitelistedSubMerchantId> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetWhitelistedSubMerchantId_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetWhitelistedSubMerchantId get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetWhitelistedSubMerchantId_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetWhitelistedSubMerchantId_Factory(provider);
    }

    public static GetWhitelistedSubMerchantId newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetWhitelistedSubMerchantId(featureConfigRepository);
    }
}
