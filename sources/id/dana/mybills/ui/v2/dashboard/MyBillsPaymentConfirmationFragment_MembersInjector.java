package id.dana.mybills.ui.v2.dashboard;

import dagger.MembersInjector;
import id.dana.mybills.di.module.ViewModelFactory;
import id.dana.mybills.tracker.MyBillsAnalyticTracker;

/* loaded from: classes9.dex */
public final class MyBillsPaymentConfirmationFragment_MembersInjector implements MembersInjector<MyBillsPaymentConfirmationFragment> {
    public static void getAuthRequestContext(MyBillsPaymentConfirmationFragment myBillsPaymentConfirmationFragment, ViewModelFactory viewModelFactory) {
        myBillsPaymentConfirmationFragment.viewModelFactory = viewModelFactory;
    }

    public static void BuiltInFictitiousFunctionClassFactory(MyBillsPaymentConfirmationFragment myBillsPaymentConfirmationFragment, MyBillsAnalyticTracker myBillsAnalyticTracker) {
        myBillsPaymentConfirmationFragment.myBillsAnalyticTracker = myBillsAnalyticTracker;
    }
}
