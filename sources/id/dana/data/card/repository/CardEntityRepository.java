package id.dana.data.card.repository;

import id.dana.data.card.repository.source.local.CardPreferencesData;
import id.dana.data.card.repository.source.local.CardPreferencesDataFactory;
import id.dana.domain.card.repository.CardRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class CardEntityRepository implements CardRepository {
    private final CardPreferencesDataFactory cardPreferencesDataFactory;

    @Inject
    public CardEntityRepository(CardPreferencesDataFactory cardPreferencesDataFactory) {
        this.cardPreferencesDataFactory = cardPreferencesDataFactory;
    }

    private CardPreferencesData createCardPreferencesData() {
        return this.cardPreferencesDataFactory.createData("local");
    }

    @Override // id.dana.domain.card.repository.CardRepository
    public Observable<Boolean> saveLastCardUsed(String str) {
        return createCardPreferencesData().saveLastCardUsed(str);
    }

    @Override // id.dana.domain.card.repository.CardRepository
    public Observable<String> getDefaultCard() {
        return createCardPreferencesData().getDefaultCard();
    }
}
