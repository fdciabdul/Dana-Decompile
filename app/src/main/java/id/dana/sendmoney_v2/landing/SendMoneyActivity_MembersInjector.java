package id.dana.sendmoney_v2.landing;

import dagger.MembersInjector;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.sendmoney.RecipientContract;
import id.dana.contract.sendmoney.v2.BillerX2BContract;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.h5event.CheckoutH5EventContract;
import id.dana.playstorereview.PlayStoreReviewContract;
import id.dana.sendmoney_v2.landing.contract.KycAndDebitPayOptionContract;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.usereducation.BottomSheetOnBoardingContract;

/* loaded from: classes5.dex */
public final class SendMoneyActivity_MembersInjector implements MembersInjector<SendMoneyActivity> {
    public static void BuiltInFictitiousFunctionClassFactory(SendMoneyActivity sendMoneyActivity, RecipientContract.Presenter presenter) {
        sendMoneyActivity.recipientPresenter = presenter;
    }

    public static void getAuthRequestContext(SendMoneyActivity sendMoneyActivity, BillerX2BContract.Presenter presenter) {
        sendMoneyActivity.billerX2BPresenter = presenter;
    }

    public static void PlaceComponentResult(SendMoneyActivity sendMoneyActivity, BottomSheetOnBoardingContract.Presenter presenter) {
        sendMoneyActivity.bottomSheetOnBoardingPresenter = presenter;
    }

    public static void PlaceComponentResult(SendMoneyActivity sendMoneyActivity, ReadLinkPropertiesContract.Presenter presenter) {
        sendMoneyActivity.readDeepLinkPropertiesPresenter = presenter;
    }

    public static void PlaceComponentResult(SendMoneyActivity sendMoneyActivity, KycAndDebitPayOptionContract.Presenter presenter) {
        sendMoneyActivity.kycAndDebitPayOptionPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(SendMoneyActivity sendMoneyActivity, SendMoneyAnalyticTracker sendMoneyAnalyticTracker) {
        sendMoneyActivity.sendMoneyAnalyticTracker = sendMoneyAnalyticTracker;
    }

    public static void PlaceComponentResult(SendMoneyActivity sendMoneyActivity, DynamicUrlWrapper dynamicUrlWrapper) {
        sendMoneyActivity.dynamicUrlWrapper = dynamicUrlWrapper;
    }

    public static void BuiltInFictitiousFunctionClassFactory(SendMoneyActivity sendMoneyActivity, DeviceInformationProvider deviceInformationProvider) {
        sendMoneyActivity.deviceInformationProvider = deviceInformationProvider;
    }

    public static void BuiltInFictitiousFunctionClassFactory(SendMoneyActivity sendMoneyActivity, CheckoutH5EventContract.Presenter presenter) {
        sendMoneyActivity.h5EventPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(SendMoneyActivity sendMoneyActivity, PlayStoreReviewContract.Presenter presenter) {
        sendMoneyActivity.playStoreReviewPresenter = presenter;
    }
}
