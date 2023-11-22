package id.dana.domain.nearbyme.interactor;

import dagger.internal.Factory;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetMerchantReviewSummary_Factory implements Factory<GetMerchantReviewSummary> {
    private final Provider<MerchantInfoRepository> merchantInfoRepositoryProvider;

    public GetMerchantReviewSummary_Factory(Provider<MerchantInfoRepository> provider) {
        this.merchantInfoRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetMerchantReviewSummary get() {
        return newInstance(this.merchantInfoRepositoryProvider.get());
    }

    public static GetMerchantReviewSummary_Factory create(Provider<MerchantInfoRepository> provider) {
        return new GetMerchantReviewSummary_Factory(provider);
    }

    public static GetMerchantReviewSummary newInstance(MerchantInfoRepository merchantInfoRepository) {
        return new GetMerchantReviewSummary(merchantInfoRepository);
    }
}
