package id.dana.domain.sendmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetRecentGroup_Factory implements Factory<GetRecentGroup> {
    private final Provider<RecentRecipientRepository> recentRecipientRepositoryProvider;

    public GetRecentGroup_Factory(Provider<RecentRecipientRepository> provider) {
        this.recentRecipientRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetRecentGroup get() {
        return newInstance(this.recentRecipientRepositoryProvider.get());
    }

    public static GetRecentGroup_Factory create(Provider<RecentRecipientRepository> provider) {
        return new GetRecentGroup_Factory(provider);
    }

    public static GetRecentGroup newInstance(RecentRecipientRepository recentRecipientRepository) {
        return new GetRecentGroup(recentRecipientRepository);
    }
}
