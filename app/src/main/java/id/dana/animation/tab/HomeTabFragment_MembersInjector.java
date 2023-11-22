package id.dana.animation.tab;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.animation.tracker.HomeTrackerImpl;
import id.dana.cashier.CashierEventHandler;
import id.dana.connectivity.ConnectivityMonitorContract;
import id.dana.contract.account.FirstTimeContract;
import id.dana.contract.deeplink.DeepLinkContract;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.contract.homeinfo.HomeInfoContract;
import id.dana.contract.homeinfo.HomeRevampContract;
import id.dana.contract.notification.PushNotificationContract;
import id.dana.contract.paylater.PayLaterContract;
import id.dana.contract.promotion.InterstitialPromotionBannerContract;
import id.dana.contract.shortener.RestoreUrlContract;
import id.dana.contract.staticqr.ScanQrContract;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.domain.featureconfig.StartupConfigEntityData;
import id.dana.h5event.CheckoutH5EventContract;
import id.dana.playstorereview.PlayStoreReviewContract;
import id.dana.qriscrossborder.QrisCrossBorderContract;

/* loaded from: classes5.dex */
public final class HomeTabFragment_MembersInjector implements MembersInjector<HomeTabFragment> {
    public static void BuiltInFictitiousFunctionClassFactory(HomeTabFragment homeTabFragment, Lazy<CashierEventHandler> lazy) {
        homeTabFragment.cashierEventHandler = lazy;
    }

    public static void MyBillsEntityDataFactory(HomeTabFragment homeTabFragment, Lazy<DeepLinkContract.Presenter> lazy) {
        homeTabFragment.deepLinkPresenter = lazy;
    }

    public static void getAuthRequestContext(HomeTabFragment homeTabFragment, Lazy<DynamicUrlWrapper> lazy) {
        homeTabFragment.dynamicUrlWrapper = lazy;
    }

    public static void PlaceComponentResult(HomeTabFragment homeTabFragment, Lazy<FeatureContract.Presenter> lazy) {
        homeTabFragment.featurePresenter = lazy;
    }

    public static void NetworkUserEntityData$$ExternalSyntheticLambda0(HomeTabFragment homeTabFragment, Lazy<FirstTimeContract.Presenter> lazy) {
        homeTabFragment.firstTimePresenter = lazy;
    }

    public static void scheduleImpl(HomeTabFragment homeTabFragment, Lazy<CheckoutH5EventContract.Presenter> lazy) {
        homeTabFragment.h5EventPresenter = lazy;
    }

    public static void lookAheadTest(HomeTabFragment homeTabFragment, Lazy<HomeInfoContract.Presenter> lazy) {
        homeTabFragment.homePresenter = lazy;
    }

    public static void moveToNextValue(HomeTabFragment homeTabFragment, Lazy<HomeRevampContract.Presenter> lazy) {
        homeTabFragment.homeRevampPresenter = lazy;
    }

    public static void DatabaseTableConfigUtil(HomeTabFragment homeTabFragment, Lazy<InterstitialPromotionBannerContract.Presenter> lazy) {
        homeTabFragment.interstitialPresenter = lazy;
    }

    public static void NetworkUserEntityData$$ExternalSyntheticLambda2(HomeTabFragment homeTabFragment, Lazy<PlayStoreReviewContract.Presenter> lazy) {
        homeTabFragment.playStoreReviewPresenter = lazy;
    }

    public static void initRecordTimeStamp(HomeTabFragment homeTabFragment, Lazy<PushNotificationContract.Presenter> lazy) {
        homeTabFragment.pushNotificationPresenter = lazy;
    }

    public static void GetContactSyncConfig(HomeTabFragment homeTabFragment, Lazy<QrisCrossBorderContract.Presenter> lazy) {
        homeTabFragment.qrisCrossBorderPresenter = lazy;
    }

    public static void newProxyInstance(HomeTabFragment homeTabFragment, Lazy<ReadLinkPropertiesContract.Presenter> lazy) {
        homeTabFragment.readDeepLinkPropertiesPresenter = lazy;
    }

    public static void NetworkUserEntityData$$ExternalSyntheticLambda8(HomeTabFragment homeTabFragment, Lazy<RestoreUrlContract.Presenter> lazy) {
        homeTabFragment.restoreUrlPresenter = lazy;
    }

    public static void NetworkUserEntityData$$ExternalSyntheticLambda7(HomeTabFragment homeTabFragment, Lazy<ScanQrContract.Presenter> lazy) {
        homeTabFragment.scanQrPresenter = lazy;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(HomeTabFragment homeTabFragment, Lazy<ConnectivityMonitorContract.Presenter> lazy) {
        homeTabFragment.connectivityMonitorPresenter = lazy;
    }

    public static void NetworkUserEntityData$$ExternalSyntheticLambda1(HomeTabFragment homeTabFragment, Lazy<PayLaterContract.Presenter> lazy) {
        homeTabFragment.payLaterPresenter = lazy;
    }

    public static void getErrorConfigVersion(HomeTabFragment homeTabFragment, Lazy<HomeTrackerImpl> lazy) {
        homeTabFragment.homeTracker = lazy;
    }

    public static void PrepareContext(HomeTabFragment homeTabFragment, Lazy<StartupConfigEntityData> lazy) {
        homeTabFragment.sharedPrefStartupConfig = lazy;
    }
}
