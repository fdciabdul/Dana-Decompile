package id.dana.mybills.ui.v2.dashboard;

import dagger.MembersInjector;
import id.dana.mybills.di.module.ViewModelFactory;
import id.dana.mybills.tracker.MyBillsAnalyticTracker;

/* loaded from: classes5.dex */
public final class MyBillsDashboardFragment_MembersInjector implements MembersInjector<MyBillsDashboardFragment> {
    public static void MyBillsEntityDataFactory(MyBillsDashboardFragment myBillsDashboardFragment, ViewModelFactory viewModelFactory) {
        myBillsDashboardFragment.viewModelFactory = viewModelFactory;
    }

    public static void BuiltInFictitiousFunctionClassFactory(MyBillsDashboardFragment myBillsDashboardFragment, MyBillsAnalyticTracker myBillsAnalyticTracker) {
        myBillsDashboardFragment.myBillsAnalyticTracker = myBillsAnalyticTracker;
    }
}
