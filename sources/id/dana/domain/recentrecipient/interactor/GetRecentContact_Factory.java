package id.dana.domain.recentrecipient.interactor;

import dagger.internal.Factory;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetRecentContact_Factory implements Factory<GetRecentContact> {
    private final Provider<RecentRecipientRepository> recentRecipientRepositoryProvider;

    public GetRecentContact_Factory(Provider<RecentRecipientRepository> provider) {
        this.recentRecipientRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetRecentContact get() {
        return newInstance(this.recentRecipientRepositoryProvider.get());
    }

    public static GetRecentContact_Factory create(Provider<RecentRecipientRepository> provider) {
        return new GetRecentContact_Factory(provider);
    }

    public static GetRecentContact newInstance(RecentRecipientRepository recentRecipientRepository) {
        return new GetRecentContact(recentRecipientRepository);
    }
}
