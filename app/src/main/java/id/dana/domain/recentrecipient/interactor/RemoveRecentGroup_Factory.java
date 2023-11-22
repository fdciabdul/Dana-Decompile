package id.dana.domain.recentrecipient.interactor;

import dagger.internal.Factory;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class RemoveRecentGroup_Factory implements Factory<RemoveRecentGroup> {
    private final Provider<RecentRecipientRepository> recentRecipientRepositoryProvider;

    public RemoveRecentGroup_Factory(Provider<RecentRecipientRepository> provider) {
        this.recentRecipientRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final RemoveRecentGroup get() {
        return newInstance(this.recentRecipientRepositoryProvider.get());
    }

    public static RemoveRecentGroup_Factory create(Provider<RecentRecipientRepository> provider) {
        return new RemoveRecentGroup_Factory(provider);
    }

    public static RemoveRecentGroup newInstance(RecentRecipientRepository recentRecipientRepository) {
        return new RemoveRecentGroup(recentRecipientRepository);
    }
}
