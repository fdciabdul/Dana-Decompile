package id.dana.domain.recentrecipient.interactor;

import dagger.internal.Factory;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetLeastTransactionFavoriteAccount_Factory implements Factory<GetLeastTransactionFavoriteAccount> {
    private final Provider<RecentRecipientRepository> recentRecipientRepositoryProvider;

    public GetLeastTransactionFavoriteAccount_Factory(Provider<RecentRecipientRepository> provider) {
        this.recentRecipientRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetLeastTransactionFavoriteAccount get() {
        return newInstance(this.recentRecipientRepositoryProvider.get());
    }

    public static GetLeastTransactionFavoriteAccount_Factory create(Provider<RecentRecipientRepository> provider) {
        return new GetLeastTransactionFavoriteAccount_Factory(provider);
    }

    public static GetLeastTransactionFavoriteAccount newInstance(RecentRecipientRepository recentRecipientRepository) {
        return new GetLeastTransactionFavoriteAccount(recentRecipientRepository);
    }
}
