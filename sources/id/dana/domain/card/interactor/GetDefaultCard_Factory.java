package id.dana.domain.card.interactor;

import dagger.internal.Factory;
import id.dana.domain.card.repository.CardRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetDefaultCard_Factory implements Factory<GetDefaultCard> {
    private final Provider<CardRepository> cardRepositoryProvider;

    public GetDefaultCard_Factory(Provider<CardRepository> provider) {
        this.cardRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetDefaultCard get() {
        return newInstance(this.cardRepositoryProvider.get());
    }

    public static GetDefaultCard_Factory create(Provider<CardRepository> provider) {
        return new GetDefaultCard_Factory(provider);
    }

    public static GetDefaultCard newInstance(CardRepository cardRepository) {
        return new GetDefaultCard(cardRepository);
    }
}
