package id.dana.wallet_v3.view.addasset.presenter;

import id.dana.animation.HomeTabActivity;
import id.dana.base.AbstractContractKt;
import id.dana.model.ThirdPartyService;
import id.dana.wallet_v3.constant.WalletConstant;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/wallet_v3/view/addasset/presenter/BottomSheetAddAssetContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface BottomSheetAddAssetContract {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/wallet_v3/view/addasset/presenter/BottomSheetAddAssetContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "Lid/dana/model/ThirdPartyService;", "thirdPartyService", "", "doAction", "(Lid/dana/model/ThirdPartyService;)V", "fetchLoyaltyAccessTokenAndKycLevel", "()V", "", HomeTabActivity.WALLET_SECTION, "getBottomSheetServices", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void doAction(ThirdPartyService thirdPartyService);

        void fetchLoyaltyAccessTokenAndKycLevel();

        void getBottomSheetServices(int section);
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ!\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\u0010JU\u0010\u0017\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u001a\u0010\u0006J\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0002H&¢\u0006\u0004\b\u001c\u0010\u0006J%\u0010 \u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H&¢\u0006\u0004\b \u0010!ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/wallet_v3/view/addasset/presenter/BottomSheetAddAssetContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "message", "", "onActionFailed", "(Ljava/lang/String;)V", "Lid/dana/model/ThirdPartyService;", "thirdPartyService", "onActionGet", "(Lid/dana/model/ThirdPartyService;)V", "authCode", "onActionPost", "(Lid/dana/model/ThirdPartyService;Ljava/lang/String;)V", "onDirectOpen", "onErrorGetServicesList", "()V", "", "paymentServices", "financialServices", "voucherServices", "loyaltyServices", "identityServices", "onGetAllThirdPartyServices", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", WalletConstant.KYC_LEVEL, "onGetKycLevel", "token", "onGetLoyaltyAccessToken", "", HomeTabActivity.WALLET_SECTION, "thirdPartyServices", "onGetThirdPartyServices", "(ILjava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void onActionFailed(String message);

        void onActionGet(ThirdPartyService thirdPartyService);

        void onActionPost(ThirdPartyService thirdPartyService, String authCode);

        void onDirectOpen(ThirdPartyService thirdPartyService);

        void onErrorGetServicesList();

        void onGetAllThirdPartyServices(List<ThirdPartyService> paymentServices, List<ThirdPartyService> financialServices, List<ThirdPartyService> voucherServices, List<ThirdPartyService> loyaltyServices, List<ThirdPartyService> identityServices);

        void onGetKycLevel(String kycLevel);

        void onGetLoyaltyAccessToken(String token);

        void onGetThirdPartyServices(int section, List<ThirdPartyService> thirdPartyServices);
    }
}
