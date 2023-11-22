package id.dana.data.card.repository.source.local;

import io.reactivex.Observable;

/* loaded from: classes4.dex */
public class LocalCardPreferencesData implements CardPreferencesData {
    private final CardPreferences cardPreferences;

    public LocalCardPreferencesData(CardPreferences cardPreferences) {
        this.cardPreferences = cardPreferences;
    }

    @Override // id.dana.data.card.repository.source.local.CardPreferencesData
    public Observable<Boolean> saveLastCardUsed(String str) {
        return Observable.just(this.cardPreferences.saveLastCardUsed(str));
    }

    @Override // id.dana.data.card.repository.source.local.CardPreferencesData
    public Observable<String> getDefaultCard() {
        return Observable.just(this.cardPreferences.getDefaultCard());
    }
}
