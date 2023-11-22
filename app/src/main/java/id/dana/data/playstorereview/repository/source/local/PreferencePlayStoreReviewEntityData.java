package id.dana.data.playstorereview.repository.source.local;

import id.dana.data.playstorereview.PlayStoreReviewEntityData;
import id.dana.data.playstorereview.model.PlayStoreReviewEntity;
import io.reactivex.Observable;

/* loaded from: classes4.dex */
public class PreferencePlayStoreReviewEntityData implements PlayStoreReviewEntityData {
    private final PlayStoreReviewPreference playStoreReviewPreference;

    public PreferencePlayStoreReviewEntityData(PlayStoreReviewPreference playStoreReviewPreference) {
        this.playStoreReviewPreference = playStoreReviewPreference;
    }

    @Override // id.dana.data.playstorereview.PlayStoreReviewEntityData
    public Observable<Boolean> saveLastPlayStoreReviewShow(String str, long j, long j2) {
        return Observable.just(Boolean.valueOf(this.playStoreReviewPreference.saveLastPlayStoreReviewShow(new PlayStoreReviewEntity(str, String.valueOf(j), String.valueOf(j2)))));
    }

    @Override // id.dana.data.playstorereview.PlayStoreReviewEntityData
    public Observable<PlayStoreReviewEntity> getLastPlayStoreReviewShow() {
        return Observable.just(this.playStoreReviewPreference.getLastPlayStoreReviewShow());
    }

    @Override // id.dana.data.playstorereview.PlayStoreReviewEntityData
    public Observable<Integer> getTransactionSuccessCount() {
        return Observable.just(Integer.valueOf(this.playStoreReviewPreference.getTransactionSuccessCount()));
    }

    @Override // id.dana.data.playstorereview.PlayStoreReviewEntityData
    public Observable<Boolean> saveSuccessTransaction(int i) {
        return Observable.just(Boolean.valueOf(this.playStoreReviewPreference.saveFirstSuccessTransactionResult(i)));
    }
}
