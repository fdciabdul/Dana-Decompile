package id.dana.wallet_v3.loyalty.presenter;

import dagger.internal.Factory;
import id.dana.domain.account.interactor.GetKycLevel;
import id.dana.domain.pocket.interactor.GetLoyaltyToken;
import id.dana.domain.wallet_v3.interactor.GetUserPocketWalletAsset;
import id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class LoyaltyWalletPresenter_Factory implements Factory<LoyaltyWalletPresenter> {
    private final Provider<GetKycLevel> getKycLevelProvider;
    private final Provider<GetLoyaltyToken> getLoyaltyAccessTokenProvider;
    private final Provider<GetUserPocketWalletAsset> getLoyaltyAssetListProvider;
    private final Provider<LoyaltyWalletContract.View> viewProvider;

    public LoyaltyWalletPresenter_Factory(Provider<GetKycLevel> provider, Provider<GetLoyaltyToken> provider2, Provider<GetUserPocketWalletAsset> provider3, Provider<LoyaltyWalletContract.View> provider4) {
        this.getKycLevelProvider = provider;
        this.getLoyaltyAccessTokenProvider = provider2;
        this.getLoyaltyAssetListProvider = provider3;
        this.viewProvider = provider4;
    }

    @Override // javax.inject.Provider
    public final LoyaltyWalletPresenter get() {
        return newInstance(this.getKycLevelProvider.get(), this.getLoyaltyAccessTokenProvider.get(), this.getLoyaltyAssetListProvider.get(), this.viewProvider.get());
    }

    public static LoyaltyWalletPresenter_Factory create(Provider<GetKycLevel> provider, Provider<GetLoyaltyToken> provider2, Provider<GetUserPocketWalletAsset> provider3, Provider<LoyaltyWalletContract.View> provider4) {
        return new LoyaltyWalletPresenter_Factory(provider, provider2, provider3, provider4);
    }

    public static LoyaltyWalletPresenter newInstance(GetKycLevel getKycLevel, GetLoyaltyToken getLoyaltyToken, GetUserPocketWalletAsset getUserPocketWalletAsset, LoyaltyWalletContract.View view) {
        return new LoyaltyWalletPresenter(getKycLevel, getLoyaltyToken, getUserPocketWalletAsset, view);
    }
}
