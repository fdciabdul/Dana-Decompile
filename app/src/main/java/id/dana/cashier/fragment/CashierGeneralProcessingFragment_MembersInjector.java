package id.dana.cashier.fragment;

import dagger.MembersInjector;
import id.dana.cashier.CashierContract;
import id.dana.cashier.presenter.CashierRiskChallengePresenter;
import id.dana.cashier.tracker.CashierAnalyticTracker;

/* loaded from: classes4.dex */
public final class CashierGeneralProcessingFragment_MembersInjector implements MembersInjector<CashierGeneralProcessingFragment> {
    public static void PlaceComponentResult(CashierGeneralProcessingFragment cashierGeneralProcessingFragment, CashierContract.Presenter presenter) {
        cashierGeneralProcessingFragment.cashierPresenter = presenter;
    }

    public static void getAuthRequestContext(CashierGeneralProcessingFragment cashierGeneralProcessingFragment, CashierAnalyticTracker cashierAnalyticTracker) {
        cashierGeneralProcessingFragment.cashierAnalyticTracker = cashierAnalyticTracker;
    }

    public static void MyBillsEntityDataFactory(CashierGeneralProcessingFragment cashierGeneralProcessingFragment, CashierRiskChallengePresenter cashierRiskChallengePresenter) {
        cashierGeneralProcessingFragment.cashierRiskChallengePresenter = cashierRiskChallengePresenter;
    }
}
