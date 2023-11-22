package id.dana.cashier.fragment;

import dagger.MembersInjector;
import id.dana.cashier.presenter.CashierRiskChallengePresenter;

/* loaded from: classes4.dex */
public final class CashierPhoneChallengeFragment_MembersInjector implements MembersInjector<CashierPhoneChallengeFragment> {
    public static void getAuthRequestContext(CashierPhoneChallengeFragment cashierPhoneChallengeFragment, CashierRiskChallengePresenter cashierRiskChallengePresenter) {
        cashierPhoneChallengeFragment.cashierRiskChallengePresenter = cashierRiskChallengePresenter;
    }
}
