package id.dana.notification;

import dagger.MembersInjector;
import id.dana.cashier.CashierEventHandler;
import id.dana.contract.deeplink.DeepLinkContract;
import id.dana.contract.shortener.RestoreUrlContract;
import id.dana.contract.staticqr.ScanQrContract;

/* loaded from: classes5.dex */
public final class NotificationActivity_MembersInjector implements MembersInjector<NotificationActivity> {
    public static void MyBillsEntityDataFactory(NotificationActivity notificationActivity, DeepLinkContract.Presenter presenter) {
        notificationActivity.sessionDeepLinkPresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(NotificationActivity notificationActivity, RestoreUrlContract.Presenter presenter) {
        notificationActivity.restoreUrlPresenter = presenter;
    }

    public static void MyBillsEntityDataFactory(NotificationActivity notificationActivity, ScanQrContract.Presenter presenter) {
        notificationActivity.scanQrPresenter = presenter;
    }

    public static void getAuthRequestContext(NotificationActivity notificationActivity, CashierEventHandler cashierEventHandler) {
        notificationActivity.cashierEventHandler = cashierEventHandler;
    }
}
