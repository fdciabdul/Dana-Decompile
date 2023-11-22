package id.dana.domain.nearbyme.interactor.merchantreview;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import id.dana.domain.nearbyme.MerchantReviewFormRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetReviewableMerchantForm_Factory implements Factory<GetReviewableMerchantForm> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;
    private final Provider<MerchantInfoRepository> merchantInfoRepositoryProvider;
    private final Provider<MerchantReviewFormRepository> merchantReviewFormRepositoryProvider;

    public GetReviewableMerchantForm_Factory(Provider<MerchantReviewFormRepository> provider, Provider<MerchantInfoRepository> provider2, Provider<FeatureConfigRepository> provider3) {
        this.merchantReviewFormRepositoryProvider = provider;
        this.merchantInfoRepositoryProvider = provider2;
        this.featureConfigRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetReviewableMerchantForm get() {
        return newInstance(this.merchantReviewFormRepositoryProvider.get(), this.merchantInfoRepositoryProvider.get(), this.featureConfigRepositoryProvider.get());
    }

    public static GetReviewableMerchantForm_Factory create(Provider<MerchantReviewFormRepository> provider, Provider<MerchantInfoRepository> provider2, Provider<FeatureConfigRepository> provider3) {
        return new GetReviewableMerchantForm_Factory(provider, provider2, provider3);
    }

    public static GetReviewableMerchantForm newInstance(MerchantReviewFormRepository merchantReviewFormRepository, MerchantInfoRepository merchantInfoRepository, FeatureConfigRepository featureConfigRepository) {
        return new GetReviewableMerchantForm(merchantReviewFormRepository, merchantInfoRepository, featureConfigRepository);
    }
}
