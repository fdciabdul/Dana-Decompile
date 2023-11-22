package id.dana.cashier.topupandpay.fragment;

import dagger.MembersInjector;
import id.dana.cashier.presenter.CashierPresenter;
import id.dana.cashier.presenter.TopUpAndPayPresenter;
import id.dana.cashier.tracker.CashierAnalyticTracker;

/* loaded from: classes4.dex */
public final class TopUpAndPaySourceFragment_MembersInjector implements MembersInjector<TopUpAndPaySourceFragment> {
    public static void MyBillsEntityDataFactory(TopUpAndPaySourceFragment topUpAndPaySourceFragment, TopUpAndPayPresenter topUpAndPayPresenter) {
        topUpAndPaySourceFragment.topUpAndPayPresenter = topUpAndPayPresenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(TopUpAndPaySourceFragment topUpAndPaySourceFragment, CashierAnalyticTracker cashierAnalyticTracker) {
        topUpAndPaySourceFragment.cashierAnalyticTracker = cashierAnalyticTracker;
    }

    public static void PlaceComponentResult(TopUpAndPaySourceFragment topUpAndPaySourceFragment, CashierPresenter cashierPresenter) {
        topUpAndPaySourceFragment.cashierPresenter = cashierPresenter;
    }
}
