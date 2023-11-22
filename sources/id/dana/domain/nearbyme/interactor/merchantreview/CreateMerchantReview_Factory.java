package id.dana.domain.nearbyme.interactor.merchantreview;

import dagger.internal.Factory;
import id.dana.domain.nearbyme.MerchantReviewRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class CreateMerchantReview_Factory implements Factory<CreateMerchantReview> {
    private final Provider<MerchantReviewRepository> merchantReviewRepositoryProvider;

    public CreateMerchantReview_Factory(Provider<MerchantReviewRepository> provider) {
        this.merchantReviewRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CreateMerchantReview get() {
        return newInstance(this.merchantReviewRepositoryProvider.get());
    }

    public static CreateMerchantReview_Factory create(Provider<MerchantReviewRepository> provider) {
        return new CreateMerchantReview_Factory(provider);
    }

    public static CreateMerchantReview newInstance(MerchantReviewRepository merchantReviewRepository) {
        return new CreateMerchantReview(merchantReviewRepository);
    }
}
