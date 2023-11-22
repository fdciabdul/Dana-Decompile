package id.dana.contract.sendmoney;

import id.dana.base.AbstractContract;
import id.dana.base.AbstractContractKt;
import id.dana.domain.sendmoney.model.SmartFrictionConfig;
import id.dana.sendmoney.model.RecentRecipientModel;

/* loaded from: classes4.dex */
public interface RecipientContract {

    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void KClassImpl$Data$declaredNonStaticMembers$2(boolean z, RecentRecipientModel recentRecipientModel, boolean z2);

        void MyBillsEntityDataFactory();

        void PlaceComponentResult();

        void getAuthRequestContext();
    }

    /* loaded from: classes4.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void onFinishCheckReferralSendMoney(boolean z, String str);

        void onGetFeatureBelowKitkatConfigSuccess(boolean z);

        void onGetSmartFrictionConfig(SmartFrictionConfig smartFrictionConfig);

        void onSuccessRemoveOldFavoriteState(boolean z);

        void onSuccessUpdateFavoriteState(boolean z, RecentRecipientModel recentRecipientModel);
    }
}
