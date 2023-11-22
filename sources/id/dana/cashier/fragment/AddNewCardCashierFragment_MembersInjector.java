package id.dana.cashier.fragment;

import dagger.MembersInjector;
import id.dana.cashier.CashierAddOnContract;
import id.dana.cashier.CashierContract;
import id.dana.cashier.presenter.CashierCardBindingPresenter;
import id.dana.cashier.presenter.CashierRiskChallengePresenter;
import id.dana.cashier.tracker.CashierAnalyticTracker;

/* loaded from: classes4.dex */
public final class AddNewCardCashierFragment_MembersInjector implements MembersInjector<AddNewCardCashierFragment> {
    public static void MyBillsEntityDataFactory(AddNewCardCashierFragment addNewCardCashierFragment, CashierContract.Presenter presenter) {
        addNewCardCashierFragment.cashierPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(AddNewCardCashierFragment addNewCardCashierFragment, CashierRiskChallengePresenter cashierRiskChallengePresenter) {
        addNewCardCashierFragment.cashierRiskChallengePresenter = cashierRiskChallengePresenter;
    }

    public static void MyBillsEntityDataFactory(AddNewCardCashierFragment addNewCardCashierFragment, CashierCardBindingPresenter cashierCardBindingPresenter) {
        addNewCardCashierFragment.cashierCardBindingPresenter = cashierCardBindingPresenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(AddNewCardCashierFragment addNewCardCashierFragment, CashierAnalyticTracker cashierAnalyticTracker) {
        addNewCardCashierFragment.cashierAnalyticTracker = cashierAnalyticTracker;
    }

    public static void getAuthRequestContext(AddNewCardCashierFragment addNewCardCashierFragment, CashierAddOnContract.Presenter presenter) {
        addNewCardCashierFragment.cashierAddOnPresenter = presenter;
    }
}
