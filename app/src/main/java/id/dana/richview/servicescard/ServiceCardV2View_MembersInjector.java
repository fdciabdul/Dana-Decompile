package id.dana.richview.servicescard;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.animation.tracker.HomeTrackerImpl;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.contract.paylater.PayLaterContract;
import id.dana.contract.services.ServicesContract;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.config.source.HomeWidgetEntityData;
import id.dana.globalnetwork.currency.GlobalNetworkContract;
import id.dana.h5event.CheckoutH5EventContract;
import id.dana.playstorereview.PlayStoreReviewContract;
import id.dana.usereducation.BottomSheetOnBoardingContract;

/* loaded from: classes5.dex */
public final class ServiceCardV2View_MembersInjector implements MembersInjector<ServiceCardV2View> {
    public static void BuiltInFictitiousFunctionClassFactory(ServiceCardV2View serviceCardV2View, Lazy<DeviceInformationProvider> lazy) {
        serviceCardV2View.deviceInformationProvider = lazy;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(ServiceCardV2View serviceCardV2View, Lazy<GlobalNetworkContract.Presenter> lazy) {
        serviceCardV2View.globalNetworkPresenter = lazy;
    }

    public static void getAuthRequestContext(ServiceCardV2View serviceCardV2View, Lazy<CheckoutH5EventContract.Presenter> lazy) {
        serviceCardV2View.h5EventPresenter = lazy;
    }

    public static void scheduleImpl(ServiceCardV2View serviceCardV2View, Lazy<BottomSheetOnBoardingContract.Presenter> lazy) {
        serviceCardV2View.onBoardingServicePresenter = lazy;
    }

    public static void getErrorConfigVersion(ServiceCardV2View serviceCardV2View, Lazy<PlayStoreReviewContract.Presenter> lazy) {
        serviceCardV2View.playStoreReviewPresenter = lazy;
    }

    public static void NetworkUserEntityData$$ExternalSyntheticLambda0(ServiceCardV2View serviceCardV2View, Lazy<ServicesContract.Presenter> lazy) {
        serviceCardV2View.presenter = lazy;
    }

    public static void initRecordTimeStamp(ServiceCardV2View serviceCardV2View, Lazy<ReadLinkPropertiesContract.Presenter> lazy) {
        serviceCardV2View.readLinkPropertiesPresenter = lazy;
    }

    public static void moveToNextValue(ServiceCardV2View serviceCardV2View, Lazy<PayLaterContract.Presenter> lazy) {
        serviceCardV2View.payLaterPresenter = lazy;
    }

    public static void lookAheadTest(ServiceCardV2View serviceCardV2View, Lazy<HomeWidgetEntityData> lazy) {
        serviceCardV2View.homeWidgetCache = lazy;
    }

    public static void MyBillsEntityDataFactory(ServiceCardV2View serviceCardV2View, Lazy<FeatureContract.Presenter> lazy) {
        serviceCardV2View.featurePresenter = lazy;
    }

    public static void PlaceComponentResult(ServiceCardV2View serviceCardV2View, Lazy<HomeTrackerImpl> lazy) {
        serviceCardV2View.homeTrackerImpl = lazy;
    }
}
