package id.dana.animation;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.animation.presenter.HomeTabContract;
import id.dana.animation.tracker.HomeTrackerImpl;
import id.dana.contract.contact.DanaContactContract;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.globalnetwork.currency.GlobalNetworkContract;
import id.dana.globalnetwork.tracker.GlobalNetworkTracker;
import id.dana.kycamledd.KycAmlEddPresenter;
import id.dana.kycrenewal.KycRenewalPresenter;
import id.dana.onboarding.referral.ReferralDialogContract;
import id.dana.paymentsetting.PaymentSettingContract;
import id.dana.playstorereview.PlayStoreReviewContract;
import id.dana.social.utils.FeedsContentAction;
import id.dana.tncsummary.TncSummaryContract;
import id.dana.userconfig.UserConfigContract;

/* loaded from: classes5.dex */
public final class HomeTabActivity_MembersInjector implements MembersInjector<HomeTabActivity> {
    public static void moveToNextValue(HomeTabActivity homeTabActivity, Lazy<PlayStoreReviewContract.Presenter> lazy) {
        homeTabActivity.playStoreReviewPresenter = lazy;
    }

    public static void getAuthRequestContext(HomeTabActivity homeTabActivity, Lazy<DanaContactContract.Presenter> lazy) {
        homeTabActivity.danaContactPresenter = lazy;
    }

    public static void GetContactSyncConfig(HomeTabActivity homeTabActivity, Lazy<TncSummaryContract.Presenter> lazy) {
        homeTabActivity.tncSummaryPresenter = lazy;
    }

    public static void getErrorConfigVersion(HomeTabActivity homeTabActivity, Lazy<PaymentSettingContract.Presenter> lazy) {
        homeTabActivity.paymentSettingPresenter = lazy;
    }

    public static void scheduleImpl(HomeTabActivity homeTabActivity, Lazy<KycRenewalPresenter> lazy) {
        homeTabActivity.kycRenewalPresenter = lazy;
    }

    public static void lookAheadTest(HomeTabActivity homeTabActivity, Lazy<KycAmlEddPresenter> lazy) {
        homeTabActivity.kycAmlEddPresenter = lazy;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(HomeTabActivity homeTabActivity, Lazy<GlobalNetworkContract.Presenter> lazy) {
        homeTabActivity.globalNetworkPresenter = lazy;
    }

    public static void DatabaseTableConfigUtil(HomeTabActivity homeTabActivity, Lazy<UserConfigContract.Presenter> lazy) {
        homeTabActivity.userConfigPresenter = lazy;
    }

    public static void NetworkUserEntityData$$ExternalSyntheticLambda0(HomeTabActivity homeTabActivity, Lazy<HomeTabContract.Presenter> lazy) {
        homeTabActivity.homeTabPresenter = lazy;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(HomeTabActivity homeTabActivity, FeedsContentAction feedsContentAction) {
        homeTabActivity.feedsContentAction = feedsContentAction;
    }

    public static void NetworkUserEntityData$$ExternalSyntheticLambda1(HomeTabActivity homeTabActivity, Lazy<ReferralDialogContract.Presenter> lazy) {
        homeTabActivity.referralDialogPresenter = lazy;
    }

    public static void MyBillsEntityDataFactory(HomeTabActivity homeTabActivity, Lazy<ReadLinkPropertiesContract.Presenter> lazy) {
        homeTabActivity.deeplinkReader = lazy;
    }

    public static void PlaceComponentResult(HomeTabActivity homeTabActivity, Lazy<DynamicUrlWrapper> lazy) {
        homeTabActivity.dynamicUrlWrapper = lazy;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(HomeTabActivity homeTabActivity, HomeTrackerImpl homeTrackerImpl) {
        homeTabActivity.homeTrackerImpl = homeTrackerImpl;
    }

    public static void BuiltInFictitiousFunctionClassFactory(HomeTabActivity homeTabActivity, Lazy<GlobalNetworkTracker> lazy) {
        homeTabActivity.globalNetworkTracker = lazy;
    }
}
