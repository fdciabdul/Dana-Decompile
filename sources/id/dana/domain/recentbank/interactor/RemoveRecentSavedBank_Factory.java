package id.dana.domain.recentbank.interactor;

import dagger.internal.Factory;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class RemoveRecentSavedBank_Factory implements Factory<RemoveRecentSavedBank> {
    private final Provider<RecentRecipientRepository> repositoryProvider;

    public RemoveRecentSavedBank_Factory(Provider<RecentRecipientRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final RemoveRecentSavedBank get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static RemoveRecentSavedBank_Factory create(Provider<RecentRecipientRepository> provider) {
        return new RemoveRecentSavedBank_Factory(provider);
    }

    public static RemoveRecentSavedBank newInstance(RecentRecipientRepository recentRecipientRepository) {
        return new RemoveRecentSavedBank(recentRecipientRepository);
    }
}
