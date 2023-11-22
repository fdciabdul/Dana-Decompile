package id.dana.domain.playstorereview.repository;

import id.dana.domain.playstorereview.model.AppReviewInfo;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface PlayStoreReviewRepository {
    Observable<AppReviewInfo> isNeedToShowPlayStoreReview();

    Observable<Boolean> saveLastPlayStoreReviewShow(String str, long j, long j2);
}
