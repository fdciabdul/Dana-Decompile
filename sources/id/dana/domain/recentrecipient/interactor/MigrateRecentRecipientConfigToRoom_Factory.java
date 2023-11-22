package id.dana.domain.recentrecipient.interactor;

import dagger.internal.Factory;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class MigrateRecentRecipientConfigToRoom_Factory implements Factory<MigrateRecentRecipientConfigToRoom> {
    private final Provider<RecentRecipientRepository> recentRecipientRepositoryProvider;

    public MigrateRecentRecipientConfigToRoom_Factory(Provider<RecentRecipientRepository> provider) {
        this.recentRecipientRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final MigrateRecentRecipientConfigToRoom get() {
        return newInstance(this.recentRecipientRepositoryProvider.get());
    }

    public static MigrateRecentRecipientConfigToRoom_Factory create(Provider<RecentRecipientRepository> provider) {
        return new MigrateRecentRecipientConfigToRoom_Factory(provider);
    }

    public static MigrateRecentRecipientConfigToRoom newInstance(RecentRecipientRepository recentRecipientRepository) {
        return new MigrateRecentRecipientConfigToRoom(recentRecipientRepository);
    }
}
