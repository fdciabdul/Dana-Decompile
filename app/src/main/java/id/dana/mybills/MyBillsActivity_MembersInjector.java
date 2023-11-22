package id.dana.mybills;

import dagger.MembersInjector;
import id.dana.cashier.CashierEventHandler;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.contract.services.ServicesContract;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.globalnetwork.currency.GlobalNetworkContract;
import id.dana.h5event.CheckoutH5EventContract;
import id.dana.mybills.di.MyBillsContract;
import id.dana.playstorereview.PlayStoreReviewContract;
import id.dana.usereducation.BottomSheetOnBoardingContract;

/* loaded from: classes5.dex */
public final class MyBillsActivity_MembersInjector implements MembersInjector<MyBillsActivity> {
    public static void BuiltInFictitiousFunctionClassFactory(MyBillsActivity myBillsActivity, MyBillsContract.Presenter presenter) {
        myBillsActivity.presenter = presenter;
    }

    public static void MyBillsEntityDataFactory(MyBillsActivity myBillsActivity, ServicesContract.Presenter presenter) {
        myBillsActivity.servicesPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(MyBillsActivity myBillsActivity, ReadLinkPropertiesContract.Presenter presenter) {
        myBillsActivity.readLinkPropertiesPresenter = presenter;
    }

    public static void getAuthRequestContext(MyBillsActivity myBillsActivity, CheckoutH5EventContract.Presenter presenter) {
        myBillsActivity.h5EventPresenter = presenter;
    }

    public static void MyBillsEntityDataFactory(MyBillsActivity myBillsActivity, BottomSheetOnBoardingContract.Presenter presenter) {
        myBillsActivity.onBoardingServicePresenter = presenter;
    }

    public static void MyBillsEntityDataFactory(MyBillsActivity myBillsActivity, GlobalNetworkContract.Presenter presenter) {
        myBillsActivity.globalNetworkPresenter = presenter;
    }

    public static void PlaceComponentResult(MyBillsActivity myBillsActivity, DeviceInformationProvider deviceInformationProvider) {
        myBillsActivity.deviceInformationProvider = deviceInformationProvider;
    }

    public static void getAuthRequestContext(MyBillsActivity myBillsActivity, PlayStoreReviewContract.Presenter presenter) {
        myBillsActivity.playStoreReviewPresenter = presenter;
    }

    public static void PlaceComponentResult(MyBillsActivity myBillsActivity, DynamicUrlWrapper dynamicUrlWrapper) {
        myBillsActivity.dynamicUrlWrapper = dynamicUrlWrapper;
    }

    public static void BuiltInFictitiousFunctionClassFactory(MyBillsActivity myBillsActivity, CashierEventHandler cashierEventHandler) {
        myBillsActivity.cashierEventHandler = cashierEventHandler;
    }

    public static void PlaceComponentResult(MyBillsActivity myBillsActivity, FeatureContract.Presenter presenter) {
        myBillsActivity.featurePresenter = presenter;
    }
}
