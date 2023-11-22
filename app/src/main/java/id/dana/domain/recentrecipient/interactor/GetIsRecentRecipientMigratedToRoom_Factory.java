package id.dana.domain.recentrecipient.interactor;

import dagger.internal.Factory;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetIsRecentRecipientMigratedToRoom_Factory implements Factory<GetIsRecentRecipientMigratedToRoom> {
    private final Provider<RecentRecipientRepository> recentRecipientRepositoryProvider;

    public GetIsRecentRecipientMigratedToRoom_Factory(Provider<RecentRecipientRepository> provider) {
        this.recentRecipientRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetIsRecentRecipientMigratedToRoom get() {
        return newInstance(this.recentRecipientRepositoryProvider.get());
    }

    public static GetIsRecentRecipientMigratedToRoom_Factory create(Provider<RecentRecipientRepository> provider) {
        return new GetIsRecentRecipientMigratedToRoom_Factory(provider);
    }

    public static GetIsRecentRecipientMigratedToRoom newInstance(RecentRecipientRepository recentRecipientRepository) {
        return new GetIsRecentRecipientMigratedToRoom(recentRecipientRepository);
    }
}
