package id.dana.service;

import dagger.MembersInjector;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.contract.paylater.PayLaterContract;
import id.dana.contract.services.ServicesContract;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.h5event.CheckoutH5EventContract;
import id.dana.playstorereview.PlayStoreReviewContract;
import id.dana.usereducation.BottomSheetOnBoardingContract;

/* loaded from: classes5.dex */
public final class ServicesActivity_MembersInjector implements MembersInjector<ServicesActivity> {
    public static void MyBillsEntityDataFactory(ServicesActivity servicesActivity, DeviceInformationProvider deviceInformationProvider) {
        servicesActivity.deviceInformationProvider = deviceInformationProvider;
    }

    public static void BuiltInFictitiousFunctionClassFactory(ServicesActivity servicesActivity, CheckoutH5EventContract.Presenter presenter) {
        servicesActivity.h5EventPresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(ServicesActivity servicesActivity, PlayStoreReviewContract.Presenter presenter) {
        servicesActivity.playStoreReviewPresenter = presenter;
    }

    public static void MyBillsEntityDataFactory(ServicesActivity servicesActivity, ServicesContract.Presenter presenter) {
        servicesActivity.presenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(ServicesActivity servicesActivity, ReadLinkPropertiesContract.Presenter presenter) {
        servicesActivity.readLinkPropertiesPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(ServicesActivity servicesActivity, BottomSheetOnBoardingContract.Presenter presenter) {
        servicesActivity.onBoardingServicePresenter = presenter;
    }

    public static void PlaceComponentResult(ServicesActivity servicesActivity, PayLaterContract.Presenter presenter) {
        servicesActivity.payLaterPresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(ServicesActivity servicesActivity, FeatureContract.Presenter presenter) {
        servicesActivity.featurePresenter = presenter;
    }
}
