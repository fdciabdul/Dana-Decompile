package id.dana.domain.recentrecipient.interactor;

import dagger.internal.Factory;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetFavoriteAccountCount_Factory implements Factory<GetFavoriteAccountCount> {
    private final Provider<RecentRecipientRepository> recentRecipientRepositoryProvider;

    public GetFavoriteAccountCount_Factory(Provider<RecentRecipientRepository> provider) {
        this.recentRecipientRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetFavoriteAccountCount get() {
        return newInstance(this.recentRecipientRepositoryProvider.get());
    }

    public static GetFavoriteAccountCount_Factory create(Provider<RecentRecipientRepository> provider) {
        return new GetFavoriteAccountCount_Factory(provider);
    }

    public static GetFavoriteAccountCount newInstance(RecentRecipientRepository recentRecipientRepository) {
        return new GetFavoriteAccountCount(recentRecipientRepository);
    }
}
