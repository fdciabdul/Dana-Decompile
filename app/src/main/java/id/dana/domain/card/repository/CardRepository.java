package id.dana.domain.card.repository;

import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface CardRepository {
    Observable<String> getDefaultCard();

    Observable<Boolean> saveLastCardUsed(String str);
}
