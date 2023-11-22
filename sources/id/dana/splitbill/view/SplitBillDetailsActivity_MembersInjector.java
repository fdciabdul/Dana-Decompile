package id.dana.splitbill.view;

import dagger.MembersInjector;
import id.dana.splitbill.tracker.SplitBillAnalyticTracker;

/* loaded from: classes5.dex */
public final class SplitBillDetailsActivity_MembersInjector implements MembersInjector<SplitBillDetailsActivity> {
    public static void PlaceComponentResult(SplitBillDetailsActivity splitBillDetailsActivity, SplitBillAnalyticTracker splitBillAnalyticTracker) {
        splitBillDetailsActivity.splitBillAnalyticTracker = splitBillAnalyticTracker;
    }
}
