package id.dana.sendmoney.summary.view;

import dagger.MembersInjector;
import id.dana.contract.sendmoney.SendMoneyContract;
import id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;

/* loaded from: classes5.dex */
public final class SummaryView_MembersInjector implements MembersInjector<SummaryView> {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(SummaryView summaryView, SendMoneyContract.Presenter presenter) {
        summaryView.presenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(SummaryView summaryView, SendMoneyCoreContract.Presenter presenter) {
        summaryView.sendMoneyCorePresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(SummaryView summaryView, SendMoneyAnalyticTracker sendMoneyAnalyticTracker) {
        summaryView.sendMoneyAnalyticalTracker = sendMoneyAnalyticTracker;
    }
}
