package id.dana.cashier.fragment;

import dagger.MembersInjector;
import id.dana.cashier.CashierContract;

/* loaded from: classes4.dex */
public final class CashierPromoSelectionFragment_MembersInjector implements MembersInjector<CashierPromoSelectionFragment> {
    public static void getAuthRequestContext(CashierPromoSelectionFragment cashierPromoSelectionFragment, CashierContract.Presenter presenter) {
        cashierPromoSelectionFragment.cashierPresenter = presenter;
    }
}
