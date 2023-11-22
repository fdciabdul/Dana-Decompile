package id.dana.animation.view;

import dagger.MembersInjector;
import id.dana.AppLifeCycleObserver;
import id.dana.contract.payqr.OfflinePayContract;
import id.dana.contract.payqr.PayQrContract;

/* loaded from: classes5.dex */
public final class ZoomDialog_MembersInjector implements MembersInjector<ZoomDialog> {
    public static void MyBillsEntityDataFactory(ZoomDialog zoomDialog, AppLifeCycleObserver appLifeCycleObserver) {
        zoomDialog.appLifeCycleObserver = appLifeCycleObserver;
    }

    public static void BuiltInFictitiousFunctionClassFactory(ZoomDialog zoomDialog, OfflinePayContract.Presenter presenter) {
        zoomDialog.offlinePayPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(ZoomDialog zoomDialog, PayQrContract.Presenter presenter) {
        zoomDialog.payQrPresenter = presenter;
    }
}
