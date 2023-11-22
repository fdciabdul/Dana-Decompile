package id.dana.domain.nearbyme.interactor.merchantreview;

import dagger.internal.Factory;
import id.dana.domain.nearbyme.MerchantReviewRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class UploadMerchantReviewImage_Factory implements Factory<UploadMerchantReviewImage> {
    private final Provider<MerchantReviewRepository> merchantReviewRepositoryProvider;

    public UploadMerchantReviewImage_Factory(Provider<MerchantReviewRepository> provider) {
        this.merchantReviewRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final UploadMerchantReviewImage get() {
        return newInstance(this.merchantReviewRepositoryProvider.get());
    }

    public static UploadMerchantReviewImage_Factory create(Provider<MerchantReviewRepository> provider) {
        return new UploadMerchantReviewImage_Factory(provider);
    }

    public static UploadMerchantReviewImage newInstance(MerchantReviewRepository merchantReviewRepository) {
        return new UploadMerchantReviewImage(merchantReviewRepository);
    }
}
