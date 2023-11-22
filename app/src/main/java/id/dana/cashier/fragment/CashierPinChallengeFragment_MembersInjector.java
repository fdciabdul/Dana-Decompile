package id.dana.cashier.fragment;

import dagger.MembersInjector;
import id.dana.cashier.CashierContract;
import id.dana.cashier.TopUpAndPayContract;
import id.dana.cashier.tracker.CashierAnalyticTracker;

/* loaded from: classes4.dex */
public final class CashierPinChallengeFragment_MembersInjector implements MembersInjector<CashierPinChallengeFragment> {
    public static void PlaceComponentResult(CashierPinChallengeFragment cashierPinChallengeFragment, CashierAnalyticTracker cashierAnalyticTracker) {
        cashierPinChallengeFragment.cashierAnalyticTracker = cashierAnalyticTracker;
    }

    public static void getAuthRequestContext(CashierPinChallengeFragment cashierPinChallengeFragment, CashierContract.Presenter presenter) {
        cashierPinChallengeFragment.cashierPresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(CashierPinChallengeFragment cashierPinChallengeFragment, TopUpAndPayContract.Presenter presenter) {
        cashierPinChallengeFragment.topUpAndPayPresenter = presenter;
    }
}
