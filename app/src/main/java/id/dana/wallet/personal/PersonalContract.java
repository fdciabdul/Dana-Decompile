package id.dana.wallet.personal;

import id.dana.base.AbstractContractKt;
import id.dana.pocket.model.PocketQueryListModel;
import id.dana.wallet_v3.model.InsuranceAssetModel;
import id.dana.wallet_v3.model.KtpInfoModel;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/wallet/personal/PersonalContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface PersonalContract {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/wallet/personal/PersonalContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "", "checkKtpPopUp", "()V", "consultAgreementCenter", "", "errorCode", "getAssetReloadIntervalTime", "(Ljava/lang/String;)V", "", "userAgreement", "userIsKyc", "recordAgreement", "(ZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void checkKtpPopUp();

        void consultAgreementCenter();

        void getAssetReloadIntervalTime(String errorCode);

        void recordAgreement(boolean userAgreement, boolean userIsKyc);
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\u001e\u0010\u000b\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0003H&J\u001e\u0010\u0012\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00130\r2\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0014\u001a\u00020\u0003H&J\u001c\u0010\u0015\u001a\u00020\u00032\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0017H&J\b\u0010\u0018\u001a\u00020\u0003H&J\u0012\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u0010H&J\b\u0010\u001b\u001a\u00020\u0003H&J\b\u0010\u001c\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001dÀ\u0006\u0001"}, d2 = {"Lid/dana/wallet/personal/PersonalContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "onCheckKtpPopUpError", "", "errorCode", "", "onConsultAgreementCenterError", "onGetIdentityReloadIntervalTime", "millis", "", "onGetInsuranceQueryListError", "onGetInsuranceQueryListSuccess", "pocketQueryList", "Lid/dana/pocket/model/PocketQueryListModel;", "Lid/dana/wallet_v3/model/InsuranceAssetModel;", "isNeedToReset", "", "onGetKtpInfoQueryError", "onGetKtpInfoQuerySuccess", "Lid/dana/wallet_v3/model/KtpInfoModel;", "onGetUserKYCStatusError", "onGetUserKYCStatusSuccess", "extendInfo", "", "onKtpNotSaved", "onKtpSaved", "isShowKtp", "onSaveKtpError", "onSaveKtpSuccess", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void onCheckKtpPopUpError(String errorCode);

        void onConsultAgreementCenterError();

        void onGetIdentityReloadIntervalTime(long millis);

        void onGetInsuranceQueryListError();

        void onGetInsuranceQueryListSuccess(PocketQueryListModel<InsuranceAssetModel> pocketQueryList, boolean isNeedToReset);

        void onGetKtpInfoQueryError();

        void onGetKtpInfoQuerySuccess(PocketQueryListModel<KtpInfoModel> pocketQueryList, boolean isNeedToReset);

        void onGetUserKYCStatusError();

        void onGetUserKYCStatusSuccess(Map<String, String> extendInfo);

        void onKtpNotSaved();

        void onKtpSaved(boolean isShowKtp);

        void onSaveKtpError();

        void onSaveKtpSuccess();
    }
}
