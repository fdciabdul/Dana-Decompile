package id.dana.data.playstorereview;

import id.dana.data.playstorereview.model.PlayStoreReviewEntity;
import io.reactivex.Observable;

/* loaded from: classes4.dex */
public interface PlayStoreReviewEntityData {
    Observable<PlayStoreReviewEntity> getLastPlayStoreReviewShow();

    Observable<Integer> getTransactionSuccessCount();

    Observable<Boolean> saveLastPlayStoreReviewShow(String str, long j, long j2);

    Observable<Boolean> saveSuccessTransaction(int i);
}
