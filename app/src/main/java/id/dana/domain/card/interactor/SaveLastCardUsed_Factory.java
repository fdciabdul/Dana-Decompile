package id.dana.domain.card.interactor;

import dagger.internal.Factory;
import id.dana.domain.card.repository.CardRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveLastCardUsed_Factory implements Factory<SaveLastCardUsed> {
    private final Provider<CardRepository> cardRepositoryProvider;

    public SaveLastCardUsed_Factory(Provider<CardRepository> provider) {
        this.cardRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveLastCardUsed get() {
        return newInstance(this.cardRepositoryProvider.get());
    }

    public static SaveLastCardUsed_Factory create(Provider<CardRepository> provider) {
        return new SaveLastCardUsed_Factory(provider);
    }

    public static SaveLastCardUsed newInstance(CardRepository cardRepository) {
        return new SaveLastCardUsed(cardRepository);
    }
}
