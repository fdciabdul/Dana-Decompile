package id.dana.wallet_v3.presenter;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.account.interactor.GetKycLevel;
import id.dana.domain.pocket.interactor.GetLoyaltyToken;
import id.dana.domain.usereducation.interactor.IsNeedToShowToolTip;
import id.dana.domain.usereducation.interactor.SaveShowToolTip;
import id.dana.domain.wallet_v3.interactor.GetIntervalTimeHitWalletApi;
import id.dana.domain.wallet_v3.interactor.GetPocketRedDotAsset;
import id.dana.domain.wallet_v3.interactor.GetTotalSectionQuery;
import id.dana.domain.wallet_v3.interactor.GetTotalUserPaymentAsset;
import id.dana.domain.wallet_v3.interactor.GetTotalUserPocketAsset;
import id.dana.domain.wallet_v3.interactor.GetUserPaymentWalletAsset;
import id.dana.domain.wallet_v3.interactor.GetUserPaymentWalletAssetLocal;
import id.dana.domain.wallet_v3.interactor.GetUserPocketWalletAsset;
import id.dana.domain.wallet_v3.interactor.GetUserPocketWalletAssetLocal;
import id.dana.domain.wallet_v3.interactor.GetVoucherAndTicketOrder;
import id.dana.domain.wallet_v3.interactor.GetWalletConfigFromLocal;
import id.dana.domain.wallet_v3.interactor.UpdateTotalSectionQuery;
import id.dana.wallet_v3.presenter.NewWalletContract;
import javax.inject.Provider;

/* loaded from: classes6.dex */
public final class NewWalletPresenter_Factory implements Factory<NewWalletPresenter> {
    private final Provider<GetIntervalTimeHitWalletApi> getIntervalTimeHitWalletApiProvider;
    private final Provider<GetUserPaymentWalletAssetLocal> getInvestmentAssetFromDatabaseProvider;
    private final Provider<GetKycLevel> getKycLevelProvider;
    private final Provider<GetLoyaltyToken> getLoyaltyAccessTokenProvider;
    private final Provider<GetUserPocketWalletAssetLocal> getLoyaltyAssetFromDatabaseProvider;
    private final Provider<GetUserPaymentWalletAssetLocal> getPaymentAssetFromDatabaseProvider;
    private final Provider<GetPocketRedDotAsset> getPocketRedDotAssetProvider;
    private final Provider<GetTotalSectionQuery> getTotalSectionQueryProvider;
    private final Provider<GetTotalUserPaymentAsset> getTotalUserPaymentAssetProvider;
    private final Provider<GetTotalUserPocketAsset> getTotalUserPocketAssetProvider;
    private final Provider<GetUserPaymentWalletAsset> getUserInvestmentWalletAssetProvider;
    private final Provider<GetUserPocketWalletAsset> getUserLoyaltyWalletAssetProvider;
    private final Provider<GetUserPaymentWalletAsset> getUserPaymentWalletAssetProvider;
    private final Provider<GetUserPocketWalletAsset> getUserPocketWalletAssetProvider;
    private final Provider<GetVoucherAndTicketOrder> getVoucherAndTicketOrderProvider;
    private final Provider<GetUserPocketWalletAssetLocal> getVoucherAssetFromDatabaseProvider;
    private final Provider<GetWalletConfigFromLocal> getWalletConfigFromLocalProvider;
    private final Provider<IsNeedToShowToolTip> isNeedToShowToolTipProvider;
    private final Provider<SaveShowToolTip> saveShowToolTipProvider;
    private final Provider<UpdateTotalSectionQuery> updateTotalSectionQueryProvider;
    private final Provider<NewWalletContract.View> viewProvider;

    public NewWalletPresenter_Factory(Provider<NewWalletContract.View> provider, Provider<GetUserPaymentWalletAsset> provider2, Provider<GetUserPaymentWalletAsset> provider3, Provider<GetUserPocketWalletAsset> provider4, Provider<GetUserPocketWalletAsset> provider5, Provider<GetWalletConfigFromLocal> provider6, Provider<GetKycLevel> provider7, Provider<GetLoyaltyToken> provider8, Provider<GetVoucherAndTicketOrder> provider9, Provider<IsNeedToShowToolTip> provider10, Provider<SaveShowToolTip> provider11, Provider<GetPocketRedDotAsset> provider12, Provider<GetTotalSectionQuery> provider13, Provider<UpdateTotalSectionQuery> provider14, Provider<GetTotalUserPaymentAsset> provider15, Provider<GetTotalUserPocketAsset> provider16, Provider<GetIntervalTimeHitWalletApi> provider17, Provider<GetUserPaymentWalletAssetLocal> provider18, Provider<GetUserPaymentWalletAssetLocal> provider19, Provider<GetUserPocketWalletAssetLocal> provider20, Provider<GetUserPocketWalletAssetLocal> provider21) {
        this.viewProvider = provider;
        this.getUserPaymentWalletAssetProvider = provider2;
        this.getUserInvestmentWalletAssetProvider = provider3;
        this.getUserPocketWalletAssetProvider = provider4;
        this.getUserLoyaltyWalletAssetProvider = provider5;
        this.getWalletConfigFromLocalProvider = provider6;
        this.getKycLevelProvider = provider7;
        this.getLoyaltyAccessTokenProvider = provider8;
        this.getVoucherAndTicketOrderProvider = provider9;
        this.isNeedToShowToolTipProvider = provider10;
        this.saveShowToolTipProvider = provider11;
        this.getPocketRedDotAssetProvider = provider12;
        this.getTotalSectionQueryProvider = provider13;
        this.updateTotalSectionQueryProvider = provider14;
        this.getTotalUserPaymentAssetProvider = provider15;
        this.getTotalUserPocketAssetProvider = provider16;
        this.getIntervalTimeHitWalletApiProvider = provider17;
        this.getPaymentAssetFromDatabaseProvider = provider18;
        this.getInvestmentAssetFromDatabaseProvider = provider19;
        this.getVoucherAssetFromDatabaseProvider = provider20;
        this.getLoyaltyAssetFromDatabaseProvider = provider21;
    }

    @Override // javax.inject.Provider
    public final NewWalletPresenter get() {
        return newInstance(DoubleCheck.MyBillsEntityDataFactory(this.viewProvider), this.getUserPaymentWalletAssetProvider.get(), this.getUserInvestmentWalletAssetProvider.get(), this.getUserPocketWalletAssetProvider.get(), this.getUserLoyaltyWalletAssetProvider.get(), this.getWalletConfigFromLocalProvider.get(), DoubleCheck.MyBillsEntityDataFactory(this.getKycLevelProvider), DoubleCheck.MyBillsEntityDataFactory(this.getLoyaltyAccessTokenProvider), DoubleCheck.MyBillsEntityDataFactory(this.getVoucherAndTicketOrderProvider), DoubleCheck.MyBillsEntityDataFactory(this.isNeedToShowToolTipProvider), DoubleCheck.MyBillsEntityDataFactory(this.saveShowToolTipProvider), DoubleCheck.MyBillsEntityDataFactory(this.getPocketRedDotAssetProvider), DoubleCheck.MyBillsEntityDataFactory(this.getTotalSectionQueryProvider), DoubleCheck.MyBillsEntityDataFactory(this.updateTotalSectionQueryProvider), DoubleCheck.MyBillsEntityDataFactory(this.getTotalUserPaymentAssetProvider), DoubleCheck.MyBillsEntityDataFactory(this.getTotalUserPocketAssetProvider), DoubleCheck.MyBillsEntityDataFactory(this.getIntervalTimeHitWalletApiProvider), DoubleCheck.MyBillsEntityDataFactory(this.getPaymentAssetFromDatabaseProvider), DoubleCheck.MyBillsEntityDataFactory(this.getInvestmentAssetFromDatabaseProvider), DoubleCheck.MyBillsEntityDataFactory(this.getVoucherAssetFromDatabaseProvider), DoubleCheck.MyBillsEntityDataFactory(this.getLoyaltyAssetFromDatabaseProvider));
    }

    public static NewWalletPresenter_Factory create(Provider<NewWalletContract.View> provider, Provider<GetUserPaymentWalletAsset> provider2, Provider<GetUserPaymentWalletAsset> provider3, Provider<GetUserPocketWalletAsset> provider4, Provider<GetUserPocketWalletAsset> provider5, Provider<GetWalletConfigFromLocal> provider6, Provider<GetKycLevel> provider7, Provider<GetLoyaltyToken> provider8, Provider<GetVoucherAndTicketOrder> provider9, Provider<IsNeedToShowToolTip> provider10, Provider<SaveShowToolTip> provider11, Provider<GetPocketRedDotAsset> provider12, Provider<GetTotalSectionQuery> provider13, Provider<UpdateTotalSectionQuery> provider14, Provider<GetTotalUserPaymentAsset> provider15, Provider<GetTotalUserPocketAsset> provider16, Provider<GetIntervalTimeHitWalletApi> provider17, Provider<GetUserPaymentWalletAssetLocal> provider18, Provider<GetUserPaymentWalletAssetLocal> provider19, Provider<GetUserPocketWalletAssetLocal> provider20, Provider<GetUserPocketWalletAssetLocal> provider21) {
        return new NewWalletPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21);
    }

    public static NewWalletPresenter newInstance(Lazy<NewWalletContract.View> lazy, GetUserPaymentWalletAsset getUserPaymentWalletAsset, GetUserPaymentWalletAsset getUserPaymentWalletAsset2, GetUserPocketWalletAsset getUserPocketWalletAsset, GetUserPocketWalletAsset getUserPocketWalletAsset2, GetWalletConfigFromLocal getWalletConfigFromLocal, Lazy<GetKycLevel> lazy2, Lazy<GetLoyaltyToken> lazy3, Lazy<GetVoucherAndTicketOrder> lazy4, Lazy<IsNeedToShowToolTip> lazy5, Lazy<SaveShowToolTip> lazy6, Lazy<GetPocketRedDotAsset> lazy7, Lazy<GetTotalSectionQuery> lazy8, Lazy<UpdateTotalSectionQuery> lazy9, Lazy<GetTotalUserPaymentAsset> lazy10, Lazy<GetTotalUserPocketAsset> lazy11, Lazy<GetIntervalTimeHitWalletApi> lazy12, Lazy<GetUserPaymentWalletAssetLocal> lazy13, Lazy<GetUserPaymentWalletAssetLocal> lazy14, Lazy<GetUserPocketWalletAssetLocal> lazy15, Lazy<GetUserPocketWalletAssetLocal> lazy16) {
        return new NewWalletPresenter(lazy, getUserPaymentWalletAsset, getUserPaymentWalletAsset2, getUserPocketWalletAsset, getUserPocketWalletAsset2, getWalletConfigFromLocal, lazy2, lazy3, lazy4, lazy5, lazy6, lazy7, lazy8, lazy9, lazy10, lazy11, lazy12, lazy13, lazy14, lazy15, lazy16);
    }
}
