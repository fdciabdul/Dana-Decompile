package id.dana.domain.nearbyme.interactor.merchantreview;

import dagger.internal.Factory;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetReviewedMerchantsList_Factory implements Factory<GetReviewedMerchantsList> {
    private final Provider<MerchantInfoRepository> merchantInfoRepositoryProvider;

    public GetReviewedMerchantsList_Factory(Provider<MerchantInfoRepository> provider) {
        this.merchantInfoRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetReviewedMerchantsList get() {
        return newInstance(this.merchantInfoRepositoryProvider.get());
    }

    public static GetReviewedMerchantsList_Factory create(Provider<MerchantInfoRepository> provider) {
        return new GetReviewedMerchantsList_Factory(provider);
    }

    public static GetReviewedMerchantsList newInstance(MerchantInfoRepository merchantInfoRepository) {
        return new GetReviewedMerchantsList(merchantInfoRepository);
    }
}
