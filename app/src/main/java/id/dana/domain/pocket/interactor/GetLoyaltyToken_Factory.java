package id.dana.domain.pocket.interactor;

import dagger.internal.Factory;
import id.dana.domain.pocket.PocketRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetLoyaltyToken_Factory implements Factory<GetLoyaltyToken> {
    private final Provider<PocketRepository> pocketRepositoryProvider;

    public GetLoyaltyToken_Factory(Provider<PocketRepository> provider) {
        this.pocketRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetLoyaltyToken get() {
        return newInstance(this.pocketRepositoryProvider.get());
    }

    public static GetLoyaltyToken_Factory create(Provider<PocketRepository> provider) {
        return new GetLoyaltyToken_Factory(provider);
    }

    public static GetLoyaltyToken newInstance(PocketRepository pocketRepository) {
        return new GetLoyaltyToken(pocketRepository);
    }
}
