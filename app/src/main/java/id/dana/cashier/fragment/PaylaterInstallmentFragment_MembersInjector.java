package id.dana.cashier.fragment;

import dagger.MembersInjector;
import id.dana.cashier.CashierContract;
import id.dana.cashier.presenter.CashierRiskChallengePresenter;
import id.dana.cashier.tracker.CashierAnalyticTracker;
import id.dana.cashier.tracker.PaylaterAnalyticTracker;

/* loaded from: classes4.dex */
public final class PaylaterInstallmentFragment_MembersInjector implements MembersInjector<PaylaterInstallmentFragment> {
    public static void MyBillsEntityDataFactory(PaylaterInstallmentFragment paylaterInstallmentFragment, CashierContract.Presenter presenter) {
        paylaterInstallmentFragment.cashierPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(PaylaterInstallmentFragment paylaterInstallmentFragment, CashierAnalyticTracker cashierAnalyticTracker) {
        paylaterInstallmentFragment.cashierAnalyticTracker = cashierAnalyticTracker;
    }

    public static void BuiltInFictitiousFunctionClassFactory(PaylaterInstallmentFragment paylaterInstallmentFragment, PaylaterAnalyticTracker paylaterAnalyticTracker) {
        paylaterInstallmentFragment.paylaterAnalyticTracker = paylaterAnalyticTracker;
    }

    public static void getAuthRequestContext(PaylaterInstallmentFragment paylaterInstallmentFragment, CashierRiskChallengePresenter cashierRiskChallengePresenter) {
        paylaterInstallmentFragment.cashierRiskChallengePresenter = cashierRiskChallengePresenter;
    }
}
