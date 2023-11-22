package id.dana.domain.requestmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.requestmoney.RequestMoneyRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetTopFeaturedBanks_Factory implements Factory<GetTopFeaturedBanks> {
    private final Provider<RequestMoneyRepository> requestMoneyRepositoryProvider;

    public GetTopFeaturedBanks_Factory(Provider<RequestMoneyRepository> provider) {
        this.requestMoneyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetTopFeaturedBanks get() {
        return newInstance(this.requestMoneyRepositoryProvider.get());
    }

    public static GetTopFeaturedBanks_Factory create(Provider<RequestMoneyRepository> provider) {
        return new GetTopFeaturedBanks_Factory(provider);
    }

    public static GetTopFeaturedBanks newInstance(RequestMoneyRepository requestMoneyRepository) {
        return new GetTopFeaturedBanks(requestMoneyRepository);
    }
}
