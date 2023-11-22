package id.dana.sendmoney_v2.landing.view;

import dagger.MembersInjector;
import id.dana.contract.sendmoney.v2.BillerX2BContract;
import id.dana.sendmoney.recipient.recent.RecentRecipientContract;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.userconfig.UserConfigContract;

/* loaded from: classes5.dex */
public final class RecentTransactionView_MembersInjector implements MembersInjector<RecentTransactionView> {
    public static void PlaceComponentResult(RecentTransactionView recentTransactionView, RecentRecipientContract.Presenter presenter) {
        recentTransactionView.recentRecipientPresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(RecentTransactionView recentTransactionView, BillerX2BContract.Presenter presenter) {
        recentTransactionView.billerX2BPresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(RecentTransactionView recentTransactionView, UserConfigContract.Presenter presenter) {
        recentTransactionView.userConfigPresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(RecentTransactionView recentTransactionView, SendMoneyAnalyticTracker sendMoneyAnalyticTracker) {
        recentTransactionView.sendMoneyAnalyticTracker = sendMoneyAnalyticTracker;
    }
}
