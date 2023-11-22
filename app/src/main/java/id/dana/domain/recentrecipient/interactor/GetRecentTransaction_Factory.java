package id.dana.domain.recentrecipient.interactor;

import dagger.internal.Factory;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetRecentTransaction_Factory implements Factory<GetRecentTransaction> {
    private final Provider<RecentRecipientRepository> recentRecipientRepositoryProvider;

    public GetRecentTransaction_Factory(Provider<RecentRecipientRepository> provider) {
        this.recentRecipientRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetRecentTransaction get() {
        return newInstance(this.recentRecipientRepositoryProvider.get());
    }

    public static GetRecentTransaction_Factory create(Provider<RecentRecipientRepository> provider) {
        return new GetRecentTransaction_Factory(provider);
    }

    public static GetRecentTransaction newInstance(RecentRecipientRepository recentRecipientRepository) {
        return new GetRecentTransaction(recentRecipientRepository);
    }
}
