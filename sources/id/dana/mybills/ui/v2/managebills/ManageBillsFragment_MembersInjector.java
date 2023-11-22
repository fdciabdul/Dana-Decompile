package id.dana.mybills.ui.v2.managebills;

import dagger.MembersInjector;
import id.dana.mybills.tracker.MyBillsAnalyticTracker;

/* loaded from: classes9.dex */
public final class ManageBillsFragment_MembersInjector implements MembersInjector<ManageBillsFragment> {
    public static void MyBillsEntityDataFactory(ManageBillsFragment manageBillsFragment, MyBillsAnalyticTracker myBillsAnalyticTracker) {
        manageBillsFragment.myBillsAnalyticTracker = myBillsAnalyticTracker;
    }
}
