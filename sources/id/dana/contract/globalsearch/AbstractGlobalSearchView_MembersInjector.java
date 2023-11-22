package id.dana.contract.globalsearch;

import androidx.viewbinding.ViewBinding;
import dagger.MembersInjector;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.globalsearch.GlobalSearchContract;
import id.dana.contract.staticqr.ScanQrContract;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.h5event.CheckoutH5EventContract;
import id.dana.playstorereview.PlayStoreReviewContract;
import id.dana.usereducation.BottomSheetOnBoardingContract;

/* loaded from: classes4.dex */
public final class AbstractGlobalSearchView_MembersInjector<V extends ViewBinding> implements MembersInjector<AbstractGlobalSearchView<V>> {
    public static <V extends ViewBinding> void MyBillsEntityDataFactory(AbstractGlobalSearchView<V> abstractGlobalSearchView, GlobalSearchContract.Presenter presenter) {
        abstractGlobalSearchView.presenter = presenter;
    }

    public static <V extends ViewBinding> void getAuthRequestContext(AbstractGlobalSearchView<V> abstractGlobalSearchView, ScanQrContract.Presenter presenter) {
        abstractGlobalSearchView.qrPresenter = presenter;
    }

    public static <V extends ViewBinding> void BuiltInFictitiousFunctionClassFactory(AbstractGlobalSearchView<V> abstractGlobalSearchView, CheckoutH5EventContract.Presenter presenter) {
        abstractGlobalSearchView.h5EventPresenter = presenter;
    }

    public static <V extends ViewBinding> void KClassImpl$Data$declaredNonStaticMembers$2(AbstractGlobalSearchView<V> abstractGlobalSearchView, PlayStoreReviewContract.Presenter presenter) {
        abstractGlobalSearchView.playStoreReviewPresenter = presenter;
    }

    public static <V extends ViewBinding> void getAuthRequestContext(AbstractGlobalSearchView<V> abstractGlobalSearchView, ReadLinkPropertiesContract.Presenter presenter) {
        abstractGlobalSearchView.readLinkPropertiesPresenter = presenter;
    }

    public static <V extends ViewBinding> void MyBillsEntityDataFactory(AbstractGlobalSearchView<V> abstractGlobalSearchView, BottomSheetOnBoardingContract.Presenter presenter) {
        abstractGlobalSearchView.onBoardingServicePresenter = presenter;
    }

    public static <V extends ViewBinding> void getAuthRequestContext(AbstractGlobalSearchView<V> abstractGlobalSearchView, DeviceInformationProvider deviceInformationProvider) {
        abstractGlobalSearchView.deviceInformationProvider = deviceInformationProvider;
    }
}
