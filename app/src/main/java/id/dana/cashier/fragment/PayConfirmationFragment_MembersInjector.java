package id.dana.cashier.fragment;

import dagger.MembersInjector;
import id.dana.cashier.CashierAddOnContract;
import id.dana.cashier.CashierContract;
import id.dana.cashier.CashierPayLaterContract;
import id.dana.cashier.CashierUserRelatedContract;
import id.dana.cashier.TncCardPaymentEventHandler;
import id.dana.cashier.presenter.CashierHighlightPresenter;
import id.dana.cashier.presenter.CashierRiskChallengePresenter;
import id.dana.cashier.tracker.CashierAnalyticTracker;
import id.dana.cashier.tracker.PaylaterAnalyticTracker;

/* loaded from: classes4.dex */
public final class PayConfirmationFragment_MembersInjector implements MembersInjector<PayConfirmationFragment> {
    public static void MyBillsEntityDataFactory(PayConfirmationFragment payConfirmationFragment, CashierContract.Presenter presenter) {
        payConfirmationFragment.cashierPresenter = presenter;
    }

    public static void getAuthRequestContext(PayConfirmationFragment payConfirmationFragment, CashierPayLaterContract.Presenter presenter) {
        payConfirmationFragment.cashierPayLaterPresenter = presenter;
    }

    public static void PlaceComponentResult(PayConfirmationFragment payConfirmationFragment, CashierAnalyticTracker cashierAnalyticTracker) {
        payConfirmationFragment.cashierAnalyticTracker = cashierAnalyticTracker;
    }

    public static void MyBillsEntityDataFactory(PayConfirmationFragment payConfirmationFragment, PaylaterAnalyticTracker paylaterAnalyticTracker) {
        payConfirmationFragment.paylaterAnalyticTracker = paylaterAnalyticTracker;
    }

    public static void MyBillsEntityDataFactory(PayConfirmationFragment payConfirmationFragment, TncCardPaymentEventHandler tncCardPaymentEventHandler) {
        payConfirmationFragment.tncCardPaymentEventHandler = tncCardPaymentEventHandler;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(PayConfirmationFragment payConfirmationFragment, CashierAddOnContract.Presenter presenter) {
        payConfirmationFragment.cashierAddOnPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(PayConfirmationFragment payConfirmationFragment, CashierUserRelatedContract.Presenter presenter) {
        payConfirmationFragment.cashierUserRelatedPresenter = presenter;
    }

    public static void MyBillsEntityDataFactory(PayConfirmationFragment payConfirmationFragment, CashierRiskChallengePresenter cashierRiskChallengePresenter) {
        payConfirmationFragment.cashierRiskChallengePresenter = cashierRiskChallengePresenter;
    }

    public static void MyBillsEntityDataFactory(PayConfirmationFragment payConfirmationFragment, CashierHighlightPresenter cashierHighlightPresenter) {
        payConfirmationFragment.cashierHighlightPresenter = cashierHighlightPresenter;
    }
}
