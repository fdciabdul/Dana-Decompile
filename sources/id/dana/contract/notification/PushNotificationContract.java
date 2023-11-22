package id.dana.contract.notification;

import id.dana.base.AbstractContract;

/* loaded from: classes4.dex */
public interface PushNotificationContract {

    /* loaded from: classes2.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void PlaceComponentResult();
    }

    /* loaded from: classes4.dex */
    public interface View extends AbstractContract.AbstractView {
        void onCheckPushNotifDiagnosticFeatureeSuccess(boolean z);

        void onReportDeviceFailed();

        void onReportDeviceSuccess();
    }
}
