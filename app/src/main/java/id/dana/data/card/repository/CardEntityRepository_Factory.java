package id.dana.data.card.repository;

import dagger.internal.Factory;
import id.dana.data.card.repository.source.local.CardPreferencesDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class CardEntityRepository_Factory implements Factory<CardEntityRepository> {
    private final Provider<CardPreferencesDataFactory> cardPreferencesDataFactoryProvider;

    public CardEntityRepository_Factory(Provider<CardPreferencesDataFactory> provider) {
        this.cardPreferencesDataFactoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CardEntityRepository get() {
        return newInstance(this.cardPreferencesDataFactoryProvider.get());
    }

    public static CardEntityRepository_Factory create(Provider<CardPreferencesDataFactory> provider) {
        return new CardEntityRepository_Factory(provider);
    }

    public static CardEntityRepository newInstance(CardPreferencesDataFactory cardPreferencesDataFactory) {
        return new CardEntityRepository(cardPreferencesDataFactory);
    }
}
