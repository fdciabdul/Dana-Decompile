package id.dana.domain.nearbyme.interactor;

import dagger.internal.Factory;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetReviewCoachmark_Factory implements Factory<GetReviewCoachmark> {
    private final Provider<MerchantInfoRepository> merchantInfoRepositoryProvider;

    public GetReviewCoachmark_Factory(Provider<MerchantInfoRepository> provider) {
        this.merchantInfoRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetReviewCoachmark get() {
        return newInstance(this.merchantInfoRepositoryProvider.get());
    }

    public static GetReviewCoachmark_Factory create(Provider<MerchantInfoRepository> provider) {
        return new GetReviewCoachmark_Factory(provider);
    }

    public static GetReviewCoachmark newInstance(MerchantInfoRepository merchantInfoRepository) {
        return new GetReviewCoachmark(merchantInfoRepository);
    }
}
