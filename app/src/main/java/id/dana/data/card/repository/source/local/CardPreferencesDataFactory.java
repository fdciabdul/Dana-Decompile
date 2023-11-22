package id.dana.data.card.repository.source.local;

import id.dana.data.AbstractEntityDataFactory;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class CardPreferencesDataFactory extends AbstractEntityDataFactory<CardPreferencesData> {
    private final CardPreferences cardPreferences;

    @Inject
    public CardPreferencesDataFactory(CardPreferences cardPreferences) {
        this.cardPreferences = cardPreferences;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    public CardPreferencesData createData(String str) {
        return new LocalCardPreferencesData(this.cardPreferences);
    }
}
