package id.dana.cashier.fragment;

import dagger.MembersInjector;
import id.dana.cashier.presenter.CashierRiskChallengePresenter;

/* loaded from: classes4.dex */
public final class CashierVerifyElementsChallengeFragment_MembersInjector implements MembersInjector<CashierVerifyElementsChallengeFragment> {
    public static void getAuthRequestContext(CashierVerifyElementsChallengeFragment cashierVerifyElementsChallengeFragment, CashierRiskChallengePresenter cashierRiskChallengePresenter) {
        cashierVerifyElementsChallengeFragment.cashierRiskChallengePresenter = cashierRiskChallengePresenter;
    }
}
