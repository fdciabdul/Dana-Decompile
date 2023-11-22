package id.dana.nearbyme.merchantreview;

import dagger.MembersInjector;
import id.dana.domain.nearbyme.interactor.merchantreview.CreateMerchantReview;

/* loaded from: classes2.dex */
public final class CreateReviewWorker_MembersInjector implements MembersInjector<CreateReviewWorker> {
    public static void getAuthRequestContext(CreateReviewWorker createReviewWorker, CreateMerchantReview createMerchantReview) {
        createReviewWorker.createReview = createMerchantReview;
    }
}
