package id.dana.cashier.fragment;

import dagger.MembersInjector;
import id.dana.cashier.CashierBannerContract;
import id.dana.cashier.CashierFeedContract;
import id.dana.cashier.CashierPayLaterContract;
import id.dana.cashier.CashierUserRelatedContract;
import id.dana.cashier.PayResultContract;
import id.dana.cashier.presenter.CashierCardBindingPresenter;
import id.dana.cashier.tracker.CashierAnalyticTracker;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.expresspurchase.presenter.ExpressPurchaseContract;
import id.dana.globalnetwork.currency.GlobalNetworkContract;

/* loaded from: classes4.dex */
public final class PaymentResultFragment_MembersInjector implements MembersInjector<PaymentResultFragment> {
    public static void MyBillsEntityDataFactory(PaymentResultFragment paymentResultFragment, ReadLinkPropertiesContract.Presenter presenter) {
        paymentResultFragment.readDeepLinkPropertiesPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(PaymentResultFragment paymentResultFragment, PayResultContract.Presenter presenter) {
        paymentResultFragment.payResultPresenter = presenter;
    }

    public static void MyBillsEntityDataFactory(PaymentResultFragment paymentResultFragment, ExpressPurchaseContract.Presenter presenter) {
        paymentResultFragment.expressPurchasePresenter = presenter;
    }

    public static void PlaceComponentResult(PaymentResultFragment paymentResultFragment, CashierAnalyticTracker cashierAnalyticTracker) {
        paymentResultFragment.cashierAnalyticTracker = cashierAnalyticTracker;
    }

    public static void MyBillsEntityDataFactory(PaymentResultFragment paymentResultFragment, GlobalNetworkContract.Presenter presenter) {
        paymentResultFragment.globalNetworkPresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(PaymentResultFragment paymentResultFragment, CashierCardBindingPresenter cashierCardBindingPresenter) {
        paymentResultFragment.cashierCardBindingPresenter = cashierCardBindingPresenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(PaymentResultFragment paymentResultFragment, CashierBannerContract.Presenter presenter) {
        paymentResultFragment.cashierBannerPresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(PaymentResultFragment paymentResultFragment, CashierFeedContract.Presenter presenter) {
        paymentResultFragment.cashierFeedPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(PaymentResultFragment paymentResultFragment, CashierUserRelatedContract.Presenter presenter) {
        paymentResultFragment.cashierUserRelatedPresenter = presenter;
    }

    public static void getAuthRequestContext(PaymentResultFragment paymentResultFragment, CashierPayLaterContract.Presenter presenter) {
        paymentResultFragment.cashierPayLaterPresenter = presenter;
    }
}
