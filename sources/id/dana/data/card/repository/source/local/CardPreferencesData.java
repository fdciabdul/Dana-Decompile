package id.dana.data.card.repository.source.local;

import io.reactivex.Observable;

/* loaded from: classes4.dex */
public interface CardPreferencesData {
    Observable<String> getDefaultCard();

    Observable<Boolean> saveLastCardUsed(String str);
}
