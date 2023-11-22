package id.dana.domain.nearbyme.interactor.merchantreview;

import dagger.internal.Factory;
import id.dana.domain.nearbyme.MerchantReviewFormRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveDismissedMerchantReviewForm_Factory implements Factory<SaveDismissedMerchantReviewForm> {
    private final Provider<MerchantReviewFormRepository> merchantReviewFormRepositoryProvider;

    public SaveDismissedMerchantReviewForm_Factory(Provider<MerchantReviewFormRepository> provider) {
        this.merchantReviewFormRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveDismissedMerchantReviewForm get() {
        return newInstance(this.merchantReviewFormRepositoryProvider.get());
    }

    public static SaveDismissedMerchantReviewForm_Factory create(Provider<MerchantReviewFormRepository> provider) {
        return new SaveDismissedMerchantReviewForm_Factory(provider);
    }

    public static SaveDismissedMerchantReviewForm newInstance(MerchantReviewFormRepository merchantReviewFormRepository) {
        return new SaveDismissedMerchantReviewForm(merchantReviewFormRepository);
    }
}
