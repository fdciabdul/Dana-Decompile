package id.dana.contract.homeinfo;

import id.dana.base.AbstractContract;
import id.dana.domain.homeinfo.ProcessingTransactionModel;
import id.dana.domain.wallet_v3.model.SurveyInfoModel;
import id.dana.model.HomeDataModel;
import id.dana.model.HomeInfo;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewModel;
import id.dana.nearbyme.merchantreview.model.MerchantConsultReviewModel;
import id.dana.sync_engine.domain.model.ConfigRepeatBackgroundJob;
import id.dana.sync_engine.domain.model.SyncPermissionAndChangeConfig;

/* loaded from: classes4.dex */
public interface HomeInfoContract {

    /* loaded from: classes2.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(String str);

        void MyBillsEntityDataFactory();

        void PlaceComponentResult();

        void PlaceComponentResult(String str, String str2, boolean z);

        void getAuthRequestContext();

        void getAuthRequestContext(String str);

        void getErrorConfigVersion();

        void moveToNextValue();
    }

    /* loaded from: classes4.dex */
    public interface View extends AbstractContract.AbstractView {
        void onGetConfigSyncContact(ConfigRepeatBackgroundJob configRepeatBackgroundJob);

        void onGetHomeData(HomeDataModel homeDataModel);

        void onGetHomeInfo(HomeInfo homeInfo);

        void onGetIsSyncPermission();

        void onGetProcessingTransaction(ProcessingTransactionModel processingTransactionModel);

        void onGetSurveyInfo(SurveyInfoModel surveyInfoModel);

        void onGetSyncPermissionConfig(SyncPermissionAndChangeConfig syncPermissionAndChangeConfig);

        void onShouldShowMerchant(MerchantConsultReviewModel merchantConsultReviewModel, MerchantReviewModel merchantReviewModel);

        void onShowMerchantReviewCheckingError();

        void onShowTooltip(boolean z);
    }
}
