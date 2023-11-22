package id.dana.playstorereview;

import dagger.MembersInjector;
import id.dana.playstorereview.PlayStoreReviewContract;

/* loaded from: classes9.dex */
public final class PlayStoreReviewActivity_MembersInjector implements MembersInjector<PlayStoreReviewActivity> {
    public static void MyBillsEntityDataFactory(PlayStoreReviewActivity playStoreReviewActivity, PlayStoreReviewContract.Presenter presenter) {
        playStoreReviewActivity.presenter = presenter;
    }
}
