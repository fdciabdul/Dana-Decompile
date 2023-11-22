package id.dana.domain.recentcontact.interactor;

import dagger.internal.Factory;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class RemoveRecentSavedContact_Factory implements Factory<RemoveRecentSavedContact> {
    private final Provider<RecentRecipientRepository> repositoryProvider;

    public RemoveRecentSavedContact_Factory(Provider<RecentRecipientRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final RemoveRecentSavedContact get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static RemoveRecentSavedContact_Factory create(Provider<RecentRecipientRepository> provider) {
        return new RemoveRecentSavedContact_Factory(provider);
    }

    public static RemoveRecentSavedContact newInstance(RecentRecipientRepository recentRecipientRepository) {
        return new RemoveRecentSavedContact(recentRecipientRepository);
    }
}
