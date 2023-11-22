package id.dana.cashier.fragment;

import dagger.MembersInjector;
import id.dana.cashier.CashierContract;

/* loaded from: classes4.dex */
public final class CashierCvvChallengeFragment_MembersInjector implements MembersInjector<CashierCvvChallengeFragment> {
    public static void MyBillsEntityDataFactory(CashierCvvChallengeFragment cashierCvvChallengeFragment, CashierContract.Presenter presenter) {
        cashierCvvChallengeFragment.cashierPresenter = presenter;
    }
}
