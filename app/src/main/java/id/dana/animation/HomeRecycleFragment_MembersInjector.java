package id.dana.animation;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.animation.presenter.HomeTabContract;
import id.dana.animation.tracker.HomeTrackerImpl;
import id.dana.cashier.CashierEventHandler;
import id.dana.cashier.tracker.PaylaterAnalyticTracker;
import id.dana.challenge.pin.LogoutContract;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.contract.deeplink.tracker.DeeplinkTracker;
import id.dana.contract.globalsearch.GlobalSearchContract;
import id.dana.contract.homeinfo.HomeInfoContract;
import id.dana.contract.inbox.UnreadInboxContract;
import id.dana.contract.ott.OttVerifyContract;
import id.dana.contract.payasset.QueryPayMethodContract;
import id.dana.contract.paylater.PayLaterContract;
import id.dana.contract.permission.PermissionStateContract;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.user.GetBalanceContract;
import id.dana.contract.user.GetUserInfoContract;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.geofence.GeoFencePresenter;
import id.dana.geofence.GeofenceManager;
import id.dana.globalnetwork.currency.GlobalNetworkContract;
import id.dana.toggle.locationpermission.LocationPermissionSubject;
import id.dana.tracker.mixpanel.BiometricAnalyticTracker;
import id.dana.wallet_v3.WalletH5ServicesImplementation;

/* loaded from: classes5.dex */
public final class HomeRecycleFragment_MembersInjector implements MembersInjector<HomeRecycleFragment> {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(HomeRecycleFragment homeRecycleFragment, Lazy<DynamicUrlWrapper> lazy) {
        homeRecycleFragment.dynamicUrlWrapper = lazy;
    }

    public static void getAuthRequestContext(HomeRecycleFragment homeRecycleFragment, Lazy<GeofenceManager> lazy) {
        homeRecycleFragment.geoFenceManager = lazy;
    }

    public static void getErrorConfigVersion(HomeRecycleFragment homeRecycleFragment, Lazy<GeoFencePresenter> lazy) {
        homeRecycleFragment.geofencePresenter = lazy;
    }

    public static void scheduleImpl(HomeRecycleFragment homeRecycleFragment, Lazy<GetBalanceContract.Presenter> lazy) {
        homeRecycleFragment.getBalancePresenter = lazy;
    }

    public static void initRecordTimeStamp(HomeRecycleFragment homeRecycleFragment, Lazy<HomeInfoContract.Presenter> lazy) {
        homeRecycleFragment.homeInfoContractPresenter = lazy;
    }

    public static void GetContactSyncConfig(HomeRecycleFragment homeRecycleFragment, Lazy<LogoutContract.Presenter> lazy) {
        homeRecycleFragment.logoutPresenter = lazy;
    }

    public static void moveToNextValue(HomeRecycleFragment homeRecycleFragment, Lazy<GlobalSearchContract.Presenter> lazy) {
        homeRecycleFragment.globalSearchPresenter = lazy;
    }

    public static void lookAheadTest(HomeRecycleFragment homeRecycleFragment, Lazy<GetUserInfoContract.Presenter> lazy) {
        homeRecycleFragment.getUserInfoPresenter = lazy;
    }

    public static void PrepareContext(HomeRecycleFragment homeRecycleFragment, Lazy<QueryPayMethodContract.Presenter> lazy) {
        homeRecycleFragment.queryPayMethodPresenter = lazy;
    }

    public static void NetworkUserEntityData$$ExternalSyntheticLambda6(HomeRecycleFragment homeRecycleFragment, Lazy<UnreadInboxContract.Presenter> lazy) {
        homeRecycleFragment.unreadInboxPresenter = lazy;
    }

    public static void MyBillsEntityDataFactory(HomeRecycleFragment homeRecycleFragment, Lazy<CashierEventHandler> lazy) {
        homeRecycleFragment.cashierEventHandler = lazy;
    }

    public static void isLayoutRequested(HomeRecycleFragment homeRecycleFragment, Lazy<PermissionStateContract.Presenter> lazy) {
        homeRecycleFragment.permissionStatePresenter = lazy;
    }

    public static void newProxyInstance(HomeRecycleFragment homeRecycleFragment, Lazy<OttVerifyContract.Presenter> lazy) {
        homeRecycleFragment.ottVerifyPresenter = lazy;
    }

    public static void NetworkUserEntityData$$ExternalSyntheticLambda2(HomeRecycleFragment homeRecycleFragment, Lazy<LocationPermissionSubject> lazy) {
        homeRecycleFragment.locationPermissionSubject = lazy;
    }

    public static void NetworkUserEntityData$$ExternalSyntheticLambda0(HomeRecycleFragment homeRecycleFragment, Lazy<GlobalNetworkContract.Presenter> lazy) {
        homeRecycleFragment.globalNetworkPresenter = lazy;
    }

    public static void NetworkUserEntityData$$ExternalSyntheticLambda7(HomeRecycleFragment homeRecycleFragment, Lazy<PayLaterContract.Presenter> lazy) {
        homeRecycleFragment.payLaterPresenter = lazy;
    }

    public static void NetworkUserEntityData$$ExternalSyntheticLambda1(HomeRecycleFragment homeRecycleFragment, Lazy<HomeTabContract.Presenter> lazy) {
        homeRecycleFragment.homeTabPresenter = lazy;
    }

    public static void PlaceComponentResult(HomeRecycleFragment homeRecycleFragment, BiometricAnalyticTracker biometricAnalyticTracker) {
        homeRecycleFragment.biometricAnalyticTracker = biometricAnalyticTracker;
    }

    public static void DatabaseTableConfigUtil(HomeRecycleFragment homeRecycleFragment, Lazy<HomeTrackerImpl> lazy) {
        homeRecycleFragment.homeTracker = lazy;
    }

    public static void PlaceComponentResult(HomeRecycleFragment homeRecycleFragment, Lazy<DeeplinkTracker> lazy) {
        homeRecycleFragment.deeplinkTracker = lazy;
    }

    public static void NetworkUserEntityData$$ExternalSyntheticLambda5(HomeRecycleFragment homeRecycleFragment, Lazy<ServicesContract.Presenter> lazy) {
        homeRecycleFragment.servicePresenter = lazy;
    }

    public static void NetworkUserEntityData$$ExternalSyntheticLambda8(HomeRecycleFragment homeRecycleFragment, Lazy<ReadLinkPropertiesContract.Presenter> lazy) {
        homeRecycleFragment.readLinkPropertiesPresenter = lazy;
    }

    public static void NetworkUserEntityData$$ExternalSyntheticLambda4(HomeRecycleFragment homeRecycleFragment, Lazy<WalletH5ServicesImplementation> lazy) {
        homeRecycleFragment.walletH5ServicesImplementation = lazy;
    }

    public static void BuiltInFictitiousFunctionClassFactory(HomeRecycleFragment homeRecycleFragment, Lazy<DeviceInformationProvider> lazy) {
        homeRecycleFragment.deviceInformationProvider = lazy;
    }

    public static void PlaceComponentResult(HomeRecycleFragment homeRecycleFragment, PaylaterAnalyticTracker paylaterAnalyticTracker) {
        homeRecycleFragment.paylaterAnalyticTracker = paylaterAnalyticTracker;
    }

    public static void getAuthRequestContext(HomeRecycleFragment homeRecycleFragment, FeatureContract.Presenter presenter) {
        homeRecycleFragment.featurePresenter = presenter;
    }
}
