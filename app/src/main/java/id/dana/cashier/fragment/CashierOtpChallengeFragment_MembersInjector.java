package id.dana.cashier.fragment;

import dagger.MembersInjector;
import id.dana.cashier.TopUpAndPayContract;
import id.dana.cashier.presenter.CashierPresenter;
import id.dana.cashier.presenter.CashierRiskChallengePresenter;
import id.dana.cashier.tracker.CashierAnalyticTracker;

/* loaded from: classes4.dex */
public final class CashierOtpChallengeFragment_MembersInjector implements MembersInjector<CashierOtpChallengeFragment> {
    public static void PlaceComponentResult(CashierOtpChallengeFragment cashierOtpChallengeFragment, CashierRiskChallengePresenter cashierRiskChallengePresenter) {
        cashierOtpChallengeFragment.cashierRiskChallengePresenter = cashierRiskChallengePresenter;
    }

    public static void getAuthRequestContext(CashierOtpChallengeFragment cashierOtpChallengeFragment, CashierPresenter cashierPresenter) {
        cashierOtpChallengeFragment.cashierPresenter = cashierPresenter;
    }

    public static void getAuthRequestContext(CashierOtpChallengeFragment cashierOtpChallengeFragment, CashierAnalyticTracker cashierAnalyticTracker) {
        cashierOtpChallengeFragment.cashierAnalyticTracker = cashierAnalyticTracker;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(CashierOtpChallengeFragment cashierOtpChallengeFragment, TopUpAndPayContract.Presenter presenter) {
        cashierOtpChallengeFragment.topUpAndPayPresenter = presenter;
    }
}
