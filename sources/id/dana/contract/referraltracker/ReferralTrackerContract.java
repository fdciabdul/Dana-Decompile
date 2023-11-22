package id.dana.contract.referraltracker;

import id.dana.base.AbstractContract;
import id.dana.domain.deeplink.model.DeepLink;
import id.dana.domain.featureconfig.model.ReferralMessageTemplateConfig;
import id.dana.model.ReferralWidgetModel;
import id.dana.referral.model.MyReferralConsult;
import id.dana.referral.model.ReferralBannerContent;
import id.dana.referral.referraltracker.model.ReferralTrackerModel;
import java.util.List;

/* loaded from: classes4.dex */
public interface ReferralTrackerContract {

    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(String str);

        void BuiltInFictitiousFunctionClassFactory(String str, String str2);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(MyReferralConsult myReferralConsult);

        void PlaceComponentResult();

        void getAuthRequestContext();

        void scheduleImpl();
    }

    /* loaded from: classes4.dex */
    public interface View extends AbstractContract.AbstractView {
        void onCheckRegisteredUser(boolean z, String str);

        void onFinishCheckLatestReferralCampaign(MyReferralConsult myReferralConsult);

        void onGetDeeplinkReferralSuccess(DeepLink deepLink);

        void onGetMessageTemplateError();

        void onGetMessageTemplateSuccess(ReferralMessageTemplateConfig referralMessageTemplateConfig);

        void onGetReferralBannerError();

        void onGetReferralBannerSuccess(List<ReferralBannerContent> list);

        void onGetReferralConsultSuccess(MyReferralConsult myReferralConsult);

        void onGetReferralTrackerError();

        void onGetReferralTrackerSuccess(ReferralTrackerModel referralTrackerModel);

        void setReferralWidgetFeatureValue(List<ReferralWidgetModel> list);
    }
}
