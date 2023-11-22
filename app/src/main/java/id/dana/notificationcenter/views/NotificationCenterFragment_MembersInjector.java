package id.dana.notificationcenter.views;

import dagger.MembersInjector;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.contract.shortener.RestoreUrlContract;
import id.dana.contract.staticqr.ScanQrContract;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.h5event.CheckoutH5EventContract;
import id.dana.playstorereview.PlayStoreReviewContract;

/* loaded from: classes5.dex */
public final class NotificationCenterFragment_MembersInjector implements MembersInjector<NotificationCenterFragment> {
    public static void getAuthRequestContext(NotificationCenterFragment notificationCenterFragment, CheckoutH5EventContract.Presenter presenter) {
        notificationCenterFragment.checkoutH5EventPresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(NotificationCenterFragment notificationCenterFragment, PlayStoreReviewContract.Presenter presenter) {
        notificationCenterFragment.playStoreReviewPresenter = presenter;
    }

    public static void MyBillsEntityDataFactory(NotificationCenterFragment notificationCenterFragment, DynamicUrlWrapper dynamicUrlWrapper) {
        notificationCenterFragment.dynamicUrlWrapper = dynamicUrlWrapper;
    }

    public static void MyBillsEntityDataFactory(NotificationCenterFragment notificationCenterFragment, ReadLinkPropertiesContract.Presenter presenter) {
        notificationCenterFragment.readDeepLinkPropertiesPresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(NotificationCenterFragment notificationCenterFragment, RestoreUrlContract.Presenter presenter) {
        notificationCenterFragment.restoreUrlPresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(NotificationCenterFragment notificationCenterFragment, ScanQrContract.Presenter presenter) {
        notificationCenterFragment.scanQrPresenter = presenter;
    }

    public static void getAuthRequestContext(NotificationCenterFragment notificationCenterFragment, FeatureContract.Presenter presenter) {
        notificationCenterFragment.featurePresenter = presenter;
    }
}
