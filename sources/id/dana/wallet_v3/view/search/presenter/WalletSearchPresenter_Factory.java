package id.dana.wallet_v3.view.search.presenter;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.wallet_v3.interactor.CheckKtpIsSaved;
import id.dana.domain.wallet_v3.interactor.GetDefaultRecommendation;
import id.dana.domain.wallet_v3.interactor.GetDynamicRecommendation;
import id.dana.domain.wallet_v3.interactor.GetUserAllAssetLocal;
import id.dana.domain.wallet_v3.interactor.GetUserPaymentWalletAssetLocal;
import id.dana.domain.wallet_v3.interactor.GetUserPocketWalletAssetLocal;
import id.dana.domain.wallet_v3.interactor.GetWalletSearchCategory;
import id.dana.mapper.ThirdPartyServicesMapper;
import id.dana.wallet_v3.view.search.presenter.WalletSearchContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class WalletSearchPresenter_Factory implements Factory<WalletSearchPresenter> {
    private final Provider<CheckKtpIsSaved> checkKtpIsSavedProvider;
    private final Provider<GetDefaultRecommendation> getDefaultRecommendationProvider;
    private final Provider<GetDynamicRecommendation> getDynamicRecommendationProvider;
    private final Provider<GetUserAllAssetLocal> getUserAllAssetLocalProvider;
    private final Provider<GetUserPaymentWalletAssetLocal> getUserPaymentWalletAssetLocalProvider;
    private final Provider<GetUserPocketWalletAssetLocal> getUserPocketWalletAssetLocalProvider;
    private final Provider<GetWalletSearchCategory> getWalletSearchCategoryProvider;
    private final Provider<ThirdPartyServicesMapper> thirdPartyServicesMapperProvider;
    private final Provider<WalletSearchContract.View> viewProvider;

    public WalletSearchPresenter_Factory(Provider<WalletSearchContract.View> provider, Provider<GetWalletSearchCategory> provider2, Provider<GetUserPaymentWalletAssetLocal> provider3, Provider<GetUserPocketWalletAssetLocal> provider4, Provider<GetUserAllAssetLocal> provider5, Provider<CheckKtpIsSaved> provider6, Provider<GetDefaultRecommendation> provider7, Provider<GetDynamicRecommendation> provider8, Provider<ThirdPartyServicesMapper> provider9) {
        this.viewProvider = provider;
        this.getWalletSearchCategoryProvider = provider2;
        this.getUserPaymentWalletAssetLocalProvider = provider3;
        this.getUserPocketWalletAssetLocalProvider = provider4;
        this.getUserAllAssetLocalProvider = provider5;
        this.checkKtpIsSavedProvider = provider6;
        this.getDefaultRecommendationProvider = provider7;
        this.getDynamicRecommendationProvider = provider8;
        this.thirdPartyServicesMapperProvider = provider9;
    }

    @Override // javax.inject.Provider
    public final WalletSearchPresenter get() {
        return newInstance(DoubleCheck.MyBillsEntityDataFactory(this.viewProvider), DoubleCheck.MyBillsEntityDataFactory(this.getWalletSearchCategoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.getUserPaymentWalletAssetLocalProvider), DoubleCheck.MyBillsEntityDataFactory(this.getUserPocketWalletAssetLocalProvider), DoubleCheck.MyBillsEntityDataFactory(this.getUserAllAssetLocalProvider), DoubleCheck.MyBillsEntityDataFactory(this.checkKtpIsSavedProvider), DoubleCheck.MyBillsEntityDataFactory(this.getDefaultRecommendationProvider), DoubleCheck.MyBillsEntityDataFactory(this.getDynamicRecommendationProvider), DoubleCheck.MyBillsEntityDataFactory(this.thirdPartyServicesMapperProvider));
    }

    public static WalletSearchPresenter_Factory create(Provider<WalletSearchContract.View> provider, Provider<GetWalletSearchCategory> provider2, Provider<GetUserPaymentWalletAssetLocal> provider3, Provider<GetUserPocketWalletAssetLocal> provider4, Provider<GetUserAllAssetLocal> provider5, Provider<CheckKtpIsSaved> provider6, Provider<GetDefaultRecommendation> provider7, Provider<GetDynamicRecommendation> provider8, Provider<ThirdPartyServicesMapper> provider9) {
        return new WalletSearchPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static WalletSearchPresenter newInstance(Lazy<WalletSearchContract.View> lazy, Lazy<GetWalletSearchCategory> lazy2, Lazy<GetUserPaymentWalletAssetLocal> lazy3, Lazy<GetUserPocketWalletAssetLocal> lazy4, Lazy<GetUserAllAssetLocal> lazy5, Lazy<CheckKtpIsSaved> lazy6, Lazy<GetDefaultRecommendation> lazy7, Lazy<GetDynamicRecommendation> lazy8, Lazy<ThirdPartyServicesMapper> lazy9) {
        return new WalletSearchPresenter(lazy, lazy2, lazy3, lazy4, lazy5, lazy6, lazy7, lazy8, lazy9);
    }
}
