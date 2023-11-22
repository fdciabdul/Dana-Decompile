package id.dana.data.card.repository.source.local;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class CardPreferencesDataFactory_Factory implements Factory<CardPreferencesDataFactory> {
    private final Provider<CardPreferences> cardPreferencesProvider;

    public CardPreferencesDataFactory_Factory(Provider<CardPreferences> provider) {
        this.cardPreferencesProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CardPreferencesDataFactory get() {
        return newInstance(this.cardPreferencesProvider.get());
    }

    public static CardPreferencesDataFactory_Factory create(Provider<CardPreferences> provider) {
        return new CardPreferencesDataFactory_Factory(provider);
    }

    public static CardPreferencesDataFactory newInstance(CardPreferences cardPreferences) {
        return new CardPreferencesDataFactory(cardPreferences);
    }
}
