package id.dana.scanner;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.contract.deeplink.DeepLinkContract;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.contract.shortener.RestoreUrlContract;
import id.dana.contract.staticqr.DecodeQrImageContract;
import id.dana.contract.staticqr.ScanQrContract;
import id.dana.globalnetwork.currency.GlobalNetworkContract;
import id.dana.h5event.CheckoutH5EventContract;
import id.dana.playstorereview.PlayStoreReviewContract;
import id.dana.scanner.tracker.ScannerMixpanelTracker;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.utils.TimerUtil;

/* loaded from: classes5.dex */
public final class ScannerFragment_MembersInjector implements MembersInjector<ScannerFragment> {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(ScannerFragment scannerFragment, DecodeQrImageContract.Presenter presenter) {
        scannerFragment.decodePresenter = presenter;
    }

    public static void PlaceComponentResult(ScannerFragment scannerFragment, Lazy<CheckoutH5EventContract.Presenter> lazy) {
        scannerFragment.h5EventPresenter = lazy;
    }

    public static void moveToNextValue(ScannerFragment scannerFragment, Lazy<PlayStoreReviewContract.Presenter> lazy) {
        scannerFragment.playStoreReviewPresenter = lazy;
    }

    public static void scheduleImpl(ScannerFragment scannerFragment, Lazy<ScanQrContract.Presenter> lazy) {
        scannerFragment.presenter = lazy;
    }

    public static void MyBillsEntityDataFactory(ScannerFragment scannerFragment, Lazy<GlobalNetworkContract.Presenter> lazy) {
        scannerFragment.globalNetworkPresenter = lazy;
    }

    public static void getErrorConfigVersion(ScannerFragment scannerFragment, Lazy<ReadLinkPropertiesContract.Presenter> lazy) {
        scannerFragment.readDeepLinkPropertiesPresenter = lazy;
    }

    public static void BuiltInFictitiousFunctionClassFactory(ScannerFragment scannerFragment, Lazy<DeepLinkContract.Presenter> lazy) {
        scannerFragment.deepLinkPresenter = lazy;
    }

    public static void lookAheadTest(ScannerFragment scannerFragment, Lazy<RestoreUrlContract.Presenter> lazy) {
        scannerFragment.restoreUrlPresenter = lazy;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(ScannerFragment scannerFragment, Lazy<FeatureContract.Presenter> lazy) {
        scannerFragment.featurePresenter = lazy;
    }

    public static void NetworkUserEntityData$$ExternalSyntheticLambda0(ScannerFragment scannerFragment, Lazy<ScanQrContract.Presenter> lazy) {
        scannerFragment.scanQrPresenter = lazy;
    }

    public static void NetworkUserEntityData$$ExternalSyntheticLambda2(ScannerFragment scannerFragment, Lazy<TimerUtil> lazy) {
        scannerFragment.timerUtil = lazy;
    }

    public static void getAuthRequestContext(ScannerFragment scannerFragment, Lazy<BottomSheetOnBoardingContract.Presenter> lazy) {
        scannerFragment.bottomSheetOnBoardingPresenter = lazy;
    }

    public static void GetContactSyncConfig(ScannerFragment scannerFragment, Lazy<ScannerMixpanelTracker> lazy) {
        scannerFragment.scannerMixpanelTracker = lazy;
    }
}
