package id.dana.domain.oauth.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetAddingNameWhitelistedMerchantId_Factory implements Factory<GetAddingNameWhitelistedMerchantId> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetAddingNameWhitelistedMerchantId_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetAddingNameWhitelistedMerchantId get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetAddingNameWhitelistedMerchantId_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetAddingNameWhitelistedMerchantId_Factory(provider);
    }

    public static GetAddingNameWhitelistedMerchantId newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetAddingNameWhitelistedMerchantId(featureConfigRepository);
    }
}
