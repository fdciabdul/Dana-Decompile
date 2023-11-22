package id.dana.domain.nearbyme.interactor.merchantreview;

import dagger.internal.Factory;
import id.dana.domain.nearbyme.MerchantReviewFormRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveLastTimeMerchantReviewFormShown_Factory implements Factory<SaveLastTimeMerchantReviewFormShown> {
    private final Provider<MerchantReviewFormRepository> merchantReviewFormRepositoryProvider;

    public SaveLastTimeMerchantReviewFormShown_Factory(Provider<MerchantReviewFormRepository> provider) {
        this.merchantReviewFormRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveLastTimeMerchantReviewFormShown get() {
        return newInstance(this.merchantReviewFormRepositoryProvider.get());
    }

    public static SaveLastTimeMerchantReviewFormShown_Factory create(Provider<MerchantReviewFormRepository> provider) {
        return new SaveLastTimeMerchantReviewFormShown_Factory(provider);
    }

    public static SaveLastTimeMerchantReviewFormShown newInstance(MerchantReviewFormRepository merchantReviewFormRepository) {
        return new SaveLastTimeMerchantReviewFormShown(merchantReviewFormRepository);
    }
}
