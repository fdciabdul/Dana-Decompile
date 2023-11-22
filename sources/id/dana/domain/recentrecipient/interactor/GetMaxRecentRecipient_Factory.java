package id.dana.domain.recentrecipient.interactor;

import dagger.internal.Factory;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetMaxRecentRecipient_Factory implements Factory<GetMaxRecentRecipient> {
    private final Provider<RecentRecipientRepository> recentRecipientRepositoryProvider;

    public GetMaxRecentRecipient_Factory(Provider<RecentRecipientRepository> provider) {
        this.recentRecipientRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetMaxRecentRecipient get() {
        return newInstance(this.recentRecipientRepositoryProvider.get());
    }

    public static GetMaxRecentRecipient_Factory create(Provider<RecentRecipientRepository> provider) {
        return new GetMaxRecentRecipient_Factory(provider);
    }

    public static GetMaxRecentRecipient newInstance(RecentRecipientRepository recentRecipientRepository) {
        return new GetMaxRecentRecipient(recentRecipientRepository);
    }
}
