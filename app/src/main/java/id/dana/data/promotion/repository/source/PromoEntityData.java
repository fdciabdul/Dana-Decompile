package id.dana.data.promotion.repository.source;

import io.reactivex.Completable;
import io.reactivex.Single;

/* loaded from: classes2.dex */
public interface PromoEntityData {
    Completable decrementFreeTransferCount(String str);

    Single<Integer> getFreeTransferCountFromLocal(String str);

    Single<Integer> getMonthOfFetchFreeTransfer();

    Completable saveMonthOfFetchFreeTransfer(Integer num);

    Completable setFreeTransferCount(String str, int i);
}
