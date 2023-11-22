package id.dana.domain.expresspurchase.interaction;

import dagger.internal.Factory;
import id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository;
import id.dana.domain.oauth.repository.OauthRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetQuickBuyGold_Factory implements Factory<GetQuickBuyGold> {
    private final Provider<ExpressPurchaseRepository> expressPurchaseRepositoryProvider;
    private final Provider<OauthRepository> oAuthRepositoryProvider;

    public GetQuickBuyGold_Factory(Provider<ExpressPurchaseRepository> provider, Provider<OauthRepository> provider2) {
        this.expressPurchaseRepositoryProvider = provider;
        this.oAuthRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final GetQuickBuyGold get() {
        return newInstance(this.expressPurchaseRepositoryProvider.get(), this.oAuthRepositoryProvider.get());
    }

    public static GetQuickBuyGold_Factory create(Provider<ExpressPurchaseRepository> provider, Provider<OauthRepository> provider2) {
        return new GetQuickBuyGold_Factory(provider, provider2);
    }

    public static GetQuickBuyGold newInstance(ExpressPurchaseRepository expressPurchaseRepository, OauthRepository oauthRepository) {
        return new GetQuickBuyGold(expressPurchaseRepository, oauthRepository);
    }
}
