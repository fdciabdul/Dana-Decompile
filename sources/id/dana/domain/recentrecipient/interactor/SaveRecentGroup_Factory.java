package id.dana.domain.recentrecipient.interactor;

import dagger.internal.Factory;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveRecentGroup_Factory implements Factory<SaveRecentGroup> {
    private final Provider<RecentRecipientRepository> recentRecipientRepositoryProvider;

    public SaveRecentGroup_Factory(Provider<RecentRecipientRepository> provider) {
        this.recentRecipientRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveRecentGroup get() {
        return newInstance(this.recentRecipientRepositoryProvider.get());
    }

    public static SaveRecentGroup_Factory create(Provider<RecentRecipientRepository> provider) {
        return new SaveRecentGroup_Factory(provider);
    }

    public static SaveRecentGroup newInstance(RecentRecipientRepository recentRecipientRepository) {
        return new SaveRecentGroup(recentRecipientRepository);
    }
}
