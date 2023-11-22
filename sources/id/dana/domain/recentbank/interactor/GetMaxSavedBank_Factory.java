package id.dana.domain.recentbank.interactor;

import dagger.internal.Factory;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetMaxSavedBank_Factory implements Factory<GetMaxSavedBank> {
    private final Provider<RecentRecipientRepository> repositoryProvider;

    public GetMaxSavedBank_Factory(Provider<RecentRecipientRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetMaxSavedBank get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static GetMaxSavedBank_Factory create(Provider<RecentRecipientRepository> provider) {
        return new GetMaxSavedBank_Factory(provider);
    }

    public static GetMaxSavedBank newInstance(RecentRecipientRepository recentRecipientRepository) {
        return new GetMaxSavedBank(recentRecipientRepository);
    }
}
