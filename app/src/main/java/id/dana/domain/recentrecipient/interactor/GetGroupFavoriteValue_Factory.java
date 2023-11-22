package id.dana.domain.recentrecipient.interactor;

import dagger.internal.Factory;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetGroupFavoriteValue_Factory implements Factory<GetGroupFavoriteValue> {
    private final Provider<RecentRecipientRepository> recentRecipientRepositoryProvider;

    public GetGroupFavoriteValue_Factory(Provider<RecentRecipientRepository> provider) {
        this.recentRecipientRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetGroupFavoriteValue get() {
        return newInstance(this.recentRecipientRepositoryProvider.get());
    }

    public static GetGroupFavoriteValue_Factory create(Provider<RecentRecipientRepository> provider) {
        return new GetGroupFavoriteValue_Factory(provider);
    }

    public static GetGroupFavoriteValue newInstance(RecentRecipientRepository recentRecipientRepository) {
        return new GetGroupFavoriteValue(recentRecipientRepository);
    }
}
