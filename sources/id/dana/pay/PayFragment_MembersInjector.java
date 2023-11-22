package id.dana.pay;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.AppLifeCycleObserver;
import id.dana.contract.deeplink.path.FeatureCardBinding;
import id.dana.contract.payasset.QueryPayMethodContract;
import id.dana.contract.payqr.GetPaymentResultContract;
import id.dana.contract.payqr.OfflinePayContract;
import id.dana.contract.payqr.PayQrContract;
import id.dana.playstorereview.PlayStoreReviewContract;

/* loaded from: classes5.dex */
public final class PayFragment_MembersInjector implements MembersInjector<PayFragment> {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(PayFragment payFragment, Lazy<AppLifeCycleObserver> lazy) {
        payFragment.appLifeCycleObserver = lazy;
    }

    public static void PlaceComponentResult(PayFragment payFragment, Lazy<GetPaymentResultContract.Presenter> lazy) {
        payFragment.getPaymentResultPresenter = lazy;
    }

    public static void getAuthRequestContext(PayFragment payFragment, Lazy<OfflinePayContract.Presenter> lazy) {
        payFragment.offlinePresenter = lazy;
    }

    public static void BuiltInFictitiousFunctionClassFactory(PayFragment payFragment, Lazy<PayQrContract.Presenter> lazy) {
        payFragment.payQrPresenter = lazy;
    }

    public static void moveToNextValue(PayFragment payFragment, Lazy<PlayStoreReviewContract.Presenter> lazy) {
        payFragment.playStoreReviewPresenter = lazy;
    }

    public static void lookAheadTest(PayFragment payFragment, Lazy<QueryPayMethodContract.Presenter> lazy) {
        payFragment.queryPayMethodPresenter = lazy;
    }

    public static void MyBillsEntityDataFactory(PayFragment payFragment, Lazy<FeatureCardBinding> lazy) {
        payFragment.featureCardBinding = lazy;
    }
}
