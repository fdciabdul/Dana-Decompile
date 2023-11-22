package id.dana.wallet_v3.presenter;

import id.dana.animation.HomeTabActivity;
import id.dana.base.AbstractContractKt;
import id.dana.contract.payasset.SceneType;
import id.dana.domain.wallet_v3.model.WalletV3Config;
import id.dana.wallet_v3.constant.WalletConstant;
import id.dana.wallet_v3.model.InvestmentCardModel;
import id.dana.wallet_v3.model.LoyaltyCardModel;
import id.dana.wallet_v3.model.NewPocketQueryListModel;
import id.dana.wallet_v3.model.PaymentCardModel;
import id.dana.wallet_v3.model.VoucherAndTicketCardModel;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/wallet_v3/presenter/NewWalletContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface NewWalletContract {

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u0011\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u0012\u0010\u000fJ\u000f\u0010\u0013\u001a\u00020\u0002H&¢\u0006\u0004\b\u0013\u0010\u0004J#\u0010\u0016\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\fH&¢\u0006\u0004\b\u0019\u0010\u000fJ\u0017\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001e\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001f\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b \u0010\u001dJ\u0017\u0010#\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!H&¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0002H&¢\u0006\u0004\b%\u0010\u0004J\u000f\u0010&\u001a\u00020\u0002H&¢\u0006\u0004\b&\u0010\u0004J\u000f\u0010'\u001a\u00020\u0002H&¢\u0006\u0004\b'\u0010\u0004J\u000f\u0010(\u001a\u00020\u0002H&¢\u0006\u0004\b(\u0010\u0004J\u000f\u0010)\u001a\u00020\u0002H&¢\u0006\u0004\b)\u0010\u0004J\u000f\u0010*\u001a\u00020\u0002H&¢\u0006\u0004\b*\u0010\u0004J\u000f\u0010+\u001a\u00020\u0002H&¢\u0006\u0004\b+\u0010\u0004J\u000f\u0010,\u001a\u00020\u0002H&¢\u0006\u0004\b,\u0010\u0004J\u001f\u00100\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\f2\u0006\u0010/\u001a\u00020.H&¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\fH&¢\u0006\u0004\b2\u0010\u000fJ\u001d\u00106\u001a\u00020\u00022\f\u00105\u001a\b\u0012\u0004\u0012\u00020403H&¢\u0006\u0004\b6\u00107J\u001d\u0010:\u001a\u00020\u00022\f\u00105\u001a\b\u0012\u0004\u0012\u00020908H&¢\u0006\u0004\b:\u0010;J\u001d\u0010=\u001a\u00020\u00022\f\u00105\u001a\b\u0012\u0004\u0012\u00020<03H&¢\u0006\u0004\b=\u00107J\u001d\u0010?\u001a\u00020\u00022\f\u00105\u001a\b\u0012\u0004\u0012\u00020>08H&¢\u0006\u0004\b?\u0010;J\u0017\u0010B\u001a\u00020\u00022\u0006\u0010A\u001a\u00020@H&¢\u0006\u0004\bB\u0010Cø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/wallet_v3/presenter/NewWalletContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "onDismissLoadingGetInvestmentCardAssets", "()V", "onDismissLoadingGetLoyaltyAssets", "onDismissLoadingGetPaymentCardAssets", "onDismissLoadingGetVoucherAndTicketAssets", "onEmptyGetInvestmentCardAssets", "onEmptyGetLoyaltyAssets", "onEmptyGetPaymentCardAssets", "onEmptyGetVoucherAndTicketAssets", "", "errorCode", "onErrorGetInvestmentCardAssets", "(Ljava/lang/String;)V", "onErrorGetLoyaltyAssets", "onErrorGetPaymentCardAssets", "onErrorGetVoucherAndTicketAssets", "onFetchLoyaltyAccessTokenAndKycLevelError", "accessToken", WalletConstant.KYC_LEVEL, "onFetchLoyaltyAccessTokenAndKycLevelSuccess", "(Ljava/lang/String;Ljava/lang/String;)V", "sectionType", "onGetEmptyAssetFromDatabase", "", "millis", "onGetFinancialReloadIntervalTime", "(J)V", "onGetLoyaltyReloadIntervalTime", "onGetPaymentReloadIntervalTime", "onGetVoucherAndTicketReloadIntervalTime", "Lid/dana/domain/wallet_v3/model/WalletV3Config;", "walletConfig", "onGetWalletV3Config", "(Lid/dana/domain/wallet_v3/model/WalletV3Config;)V", "onHideIdentitySection", "onHideInvestmentSection", "onHideLoyaltySection", "onHideVoucherSection", "onLoadingGetInvestmentCardAssets", "onLoadingGetLoyaltyAssets", "onLoadingGetPaymentCardAssets", "onLoadingGetVoucherAndTicketAssets", "scenario", "", "isShowToolTip", "onShowTooltip", "(Ljava/lang/String;Z)V", "onSuccessGetAssetFromDatabase", "", "Lid/dana/wallet_v3/model/InvestmentCardModel;", SceneType.ASSETS, "onSuccessGetInvestmentCardAssets", "(Ljava/util/List;)V", "Lid/dana/wallet_v3/model/NewPocketQueryListModel;", "Lid/dana/wallet_v3/model/LoyaltyCardModel;", "onSuccessGetLoyaltyAssets", "(Lid/dana/wallet_v3/model/NewPocketQueryListModel;)V", "Lid/dana/wallet_v3/model/PaymentCardModel;", "onSuccessGetPaymentCardAssets", "Lid/dana/wallet_v3/model/VoucherAndTicketCardModel;", "onSuccessGetVoucherAndTicketAssets", "", "totalCount", "onSuccessGetVoucherAndTicketRedDotTotalCount", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void onDismissLoadingGetInvestmentCardAssets();

        void onDismissLoadingGetLoyaltyAssets();

        void onDismissLoadingGetPaymentCardAssets();

        void onDismissLoadingGetVoucherAndTicketAssets();

        void onEmptyGetInvestmentCardAssets();

        void onEmptyGetLoyaltyAssets();

        void onEmptyGetPaymentCardAssets();

        void onEmptyGetVoucherAndTicketAssets();

        void onErrorGetInvestmentCardAssets(String errorCode);

        void onErrorGetLoyaltyAssets(String errorCode);

        void onErrorGetPaymentCardAssets(String errorCode);

        void onErrorGetVoucherAndTicketAssets(String errorCode);

        void onFetchLoyaltyAccessTokenAndKycLevelError();

        void onFetchLoyaltyAccessTokenAndKycLevelSuccess(String accessToken, String kycLevel);

        void onGetEmptyAssetFromDatabase(String sectionType);

        void onGetFinancialReloadIntervalTime(long millis);

        void onGetLoyaltyReloadIntervalTime(long millis);

        void onGetPaymentReloadIntervalTime(long millis);

        void onGetVoucherAndTicketReloadIntervalTime(long millis);

        void onGetWalletV3Config(WalletV3Config walletConfig);

        void onHideIdentitySection();

        void onHideInvestmentSection();

        void onHideLoyaltySection();

        void onHideVoucherSection();

        void onLoadingGetInvestmentCardAssets();

        void onLoadingGetLoyaltyAssets();

        void onLoadingGetPaymentCardAssets();

        void onLoadingGetVoucherAndTicketAssets();

        void onShowTooltip(String scenario, boolean isShowToolTip);

        void onSuccessGetAssetFromDatabase(String sectionType);

        void onSuccessGetInvestmentCardAssets(List<? extends InvestmentCardModel> assets);

        void onSuccessGetLoyaltyAssets(NewPocketQueryListModel<LoyaltyCardModel> assets);

        void onSuccessGetPaymentCardAssets(List<? extends PaymentCardModel> assets);

        void onSuccessGetVoucherAndTicketAssets(NewPocketQueryListModel<VoucherAndTicketCardModel> assets);

        void onSuccessGetVoucherAndTicketRedDotTotalCount(int totalCount);
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH&J\u0012\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0011H&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH&J\u0012\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0011H&J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH&J\u0012\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0011H&J\u001e\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00062\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u001e\u0010\u0019\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u001a2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J(\u0010\u001b\u001a\u00020\u00032\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u001d\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u0011H&J \u0010\u001e\u001a\u00020\u00032\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u0011H&J&\u0010\u001f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\b\u0010 \u001a\u00020\u0003H&J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0006H&J\u0018\u0010\"\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u0011H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006$À\u0006\u0001"}, d2 = {"Lid/dana/wallet_v3/presenter/NewWalletContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "checkIsNeedToShowTooltip", "", "scenario", "", "", "fetchLoyaltyAccessTokenAndKycLevel", "getAssetReloadIntervalTime", HomeTabActivity.WALLET_SECTION, "errorCode", "getInvestmentAssetFromDatabase", "cacheDuration", "", "currentTimestamp", "getInvestmentCardAssets", "isShowShimmer", "", "getLoyaltyAssetFromDatabase", "getLoyaltyCardAssets", "getPaymentAssetFromDatabase", "getPaymentCardAssets", "getPocketRedDotTotalCount", "sectionType", "assetTypes", "getTotalSectionQuery", "", "getVoucherAndTicketAssets", "assetType", "order", "getVoucherAndTicketOrder", "getVoucherAssetFromDatabase", "getWalletV3ConfigFromLocal", "saveTooltipShown", "updateTotalSectionQuery", "isReset", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void checkIsNeedToShowTooltip(List<String> scenario);

        void fetchLoyaltyAccessTokenAndKycLevel();

        void getAssetReloadIntervalTime(String section, String errorCode);

        void getInvestmentAssetFromDatabase(long cacheDuration, long currentTimestamp);

        void getInvestmentCardAssets(boolean isShowShimmer);

        void getLoyaltyAssetFromDatabase(long cacheDuration, long currentTimestamp);

        void getLoyaltyCardAssets(boolean isShowShimmer);

        void getPaymentAssetFromDatabase(long cacheDuration, long currentTimestamp);

        void getPaymentCardAssets(boolean isShowShimmer);

        void getPocketRedDotTotalCount(String sectionType, List<String> assetTypes);

        void getTotalSectionQuery(int section, List<String> assetTypes);

        void getVoucherAndTicketAssets(List<String> assetType, String order, boolean isShowShimmer);

        void getVoucherAndTicketOrder(List<String> assetType, boolean isShowShimmer);

        void getVoucherAssetFromDatabase(long cacheDuration, long currentTimestamp, List<String> assetTypes);

        void getWalletV3ConfigFromLocal();

        void saveTooltipShown(String scenario);

        void updateTotalSectionQuery(int section, boolean isReset);

        /* renamed from: id.dana.wallet_v3.presenter.NewWalletContract$Presenter$-CC  reason: invalid class name */
        /* loaded from: classes6.dex */
        public final /* synthetic */ class CC {
            public static /* synthetic */ void getPaymentCardAssets$default(Presenter presenter, boolean z, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPaymentCardAssets");
                }
                if ((i & 1) != 0) {
                    z = true;
                }
                presenter.getPaymentCardAssets(z);
            }

            public static /* synthetic */ void getInvestmentCardAssets$default(Presenter presenter, boolean z, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getInvestmentCardAssets");
                }
                if ((i & 1) != 0) {
                    z = true;
                }
                presenter.getInvestmentCardAssets(z);
            }

            public static /* synthetic */ void getVoucherAndTicketOrder$default(Presenter presenter, List list, boolean z, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getVoucherAndTicketOrder");
                }
                if ((i & 2) != 0) {
                    z = true;
                }
                presenter.getVoucherAndTicketOrder(list, z);
            }

            public static /* synthetic */ void getVoucherAndTicketAssets$default(Presenter presenter, List list, String str, boolean z, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getVoucherAndTicketAssets");
                }
                if ((i & 4) != 0) {
                    z = true;
                }
                presenter.getVoucherAndTicketAssets(list, str, z);
            }

            public static /* synthetic */ void getLoyaltyCardAssets$default(Presenter presenter, boolean z, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLoyaltyCardAssets");
                }
                if ((i & 1) != 0) {
                    z = true;
                }
                presenter.getLoyaltyCardAssets(z);
            }
        }
    }
}
