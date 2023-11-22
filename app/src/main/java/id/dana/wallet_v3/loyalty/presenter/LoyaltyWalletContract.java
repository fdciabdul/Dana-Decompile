package id.dana.wallet_v3.loyalty.presenter;

import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import id.dana.base.AbstractContractKt;
import id.dana.contract.payasset.SceneType;
import id.dana.wallet_v3.constant.WalletConstant;
import id.dana.wallet_v3.model.LoyaltyCardModel;
import id.dana.wallet_v3.model.NewPocketQueryListModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/wallet_v3/loyalty/presenter/LoyaltyWalletContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface LoyaltyWalletContract {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/wallet_v3/loyalty/presenter/LoyaltyWalletContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "", "fetchLoyaltyAccessTokenAndKycLevel", "()V", "", "isNeedResetPagination", "getLoyaltyCardAssets", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void fetchLoyaltyAccessTokenAndKycLevel();

        void getLoyaltyCardAssets(boolean isNeedResetPagination);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J\u0019\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u0004J%\u0010\u0014\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/wallet_v3/loyalty/presenter/LoyaltyWalletContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "onDismissLoadingGetLoyaltyAsset", "()V", "onErrorGetLoyaltyAccessToken", "onErrorGetLoyaltyAsset", "onErrorKycLevel", "", WalletConstant.KYC_LEVEL, "onGetKycLevel", "(Ljava/lang/String;)V", "token", "onGetLoyaltyAccessToken", "onLoadingGetLoyaltyAsset", "Lid/dana/wallet_v3/model/NewPocketQueryListModel;", "Lid/dana/wallet_v3/model/LoyaltyCardModel;", SceneType.ASSETS, "", ZdocRecordService.PAGE_NUMBER, "onSuccessGetLoyaltyAsset", "(Lid/dana/wallet_v3/model/NewPocketQueryListModel;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void onDismissLoadingGetLoyaltyAsset();

        void onErrorGetLoyaltyAccessToken();

        void onErrorGetLoyaltyAsset();

        void onErrorKycLevel();

        void onGetKycLevel(String kycLevel);

        void onGetLoyaltyAccessToken(String token);

        void onLoadingGetLoyaltyAsset();

        void onSuccessGetLoyaltyAsset(NewPocketQueryListModel<LoyaltyCardModel> assets, int pageNumber);
    }
}
