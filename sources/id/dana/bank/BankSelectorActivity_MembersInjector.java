package id.dana.bank;

import dagger.MembersInjector;
import id.dana.bank.contract.BankSelectorContract;
import id.dana.contract.sendmoney.v2.BillerX2BContract;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;

/* loaded from: classes4.dex */
public final class BankSelectorActivity_MembersInjector implements MembersInjector<BankSelectorActivity> {
    public static void BuiltInFictitiousFunctionClassFactory(BankSelectorActivity bankSelectorActivity, BankSelectorContract.Presenter presenter) {
        bankSelectorActivity.presenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(BankSelectorActivity bankSelectorActivity, BillerX2BContract.Presenter presenter) {
        bankSelectorActivity.billerX2BPresenter = presenter;
    }

    public static void getAuthRequestContext(BankSelectorActivity bankSelectorActivity, SendMoneyAnalyticTracker sendMoneyAnalyticTracker) {
        bankSelectorActivity.sendMoneyAnalyticalTracker = sendMoneyAnalyticTracker;
    }
}
