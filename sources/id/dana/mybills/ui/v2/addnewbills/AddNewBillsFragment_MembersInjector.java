package id.dana.mybills.ui.v2.addnewbills;

import dagger.MembersInjector;
import id.dana.mybills.tracker.MyBillsAnalyticTracker;
import id.dana.utils.danah5.DanaH5Facade;

/* loaded from: classes9.dex */
public final class AddNewBillsFragment_MembersInjector implements MembersInjector<AddNewBillsFragment> {
    public static void getAuthRequestContext(AddNewBillsFragment addNewBillsFragment, DanaH5Facade danaH5Facade) {
        addNewBillsFragment.danaH5Facade = danaH5Facade;
    }

    public static void PlaceComponentResult(AddNewBillsFragment addNewBillsFragment, MyBillsAnalyticTracker myBillsAnalyticTracker) {
        addNewBillsFragment.myBillsAnalyticTracker = myBillsAnalyticTracker;
    }
}
