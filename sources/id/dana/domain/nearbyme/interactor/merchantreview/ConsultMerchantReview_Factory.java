package id.dana.domain.nearbyme.interactor.merchantreview;

import dagger.internal.Factory;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ConsultMerchantReview_Factory implements Factory<ConsultMerchantReview> {
    private final Provider<MerchantInfoRepository> merchantInfoRepositoryProvider;

    public ConsultMerchantReview_Factory(Provider<MerchantInfoRepository> provider) {
        this.merchantInfoRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ConsultMerchantReview get() {
        return newInstance(this.merchantInfoRepositoryProvider.get());
    }

    public static ConsultMerchantReview_Factory create(Provider<MerchantInfoRepository> provider) {
        return new ConsultMerchantReview_Factory(provider);
    }

    public static ConsultMerchantReview newInstance(MerchantInfoRepository merchantInfoRepository) {
        return new ConsultMerchantReview(merchantInfoRepository);
    }
}
