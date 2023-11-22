package id.dana.domain.recentrecipient.interactor;

import dagger.internal.Factory;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetMaxFavoriteAccount_Factory implements Factory<GetMaxFavoriteAccount> {
    private final Provider<RecentRecipientRepository> recentRecipientRepositoryProvider;

    public GetMaxFavoriteAccount_Factory(Provider<RecentRecipientRepository> provider) {
        this.recentRecipientRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetMaxFavoriteAccount get() {
        return newInstance(this.recentRecipientRepositoryProvider.get());
    }

    public static GetMaxFavoriteAccount_Factory create(Provider<RecentRecipientRepository> provider) {
        return new GetMaxFavoriteAccount_Factory(provider);
    }

    public static GetMaxFavoriteAccount newInstance(RecentRecipientRepository recentRecipientRepository) {
        return new GetMaxFavoriteAccount(recentRecipientRepository);
    }
}
