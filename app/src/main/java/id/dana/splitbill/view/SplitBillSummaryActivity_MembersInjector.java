package id.dana.splitbill.view;

import dagger.MembersInjector;
import id.dana.splitbill.SplitBillContract;
import id.dana.splitbill.SplitBillDetailContract;
import id.dana.splitbill.tracker.SplitBillAnalyticTracker;

/* loaded from: classes5.dex */
public final class SplitBillSummaryActivity_MembersInjector implements MembersInjector<SplitBillSummaryActivity> {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(SplitBillSummaryActivity splitBillSummaryActivity, SplitBillContract.Presenter presenter) {
        splitBillSummaryActivity.splitBillPresenter = presenter;
    }

    public static void PlaceComponentResult(SplitBillSummaryActivity splitBillSummaryActivity, SplitBillDetailContract.Presenter presenter) {
        splitBillSummaryActivity.splitBillDetailPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(SplitBillSummaryActivity splitBillSummaryActivity, SplitBillAnalyticTracker splitBillAnalyticTracker) {
        splitBillSummaryActivity.splitBillAnalyticTracker = splitBillAnalyticTracker;
    }
}
