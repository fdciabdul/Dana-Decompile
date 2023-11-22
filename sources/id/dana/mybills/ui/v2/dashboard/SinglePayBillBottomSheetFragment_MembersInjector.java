package id.dana.mybills.ui.v2.dashboard;

import dagger.MembersInjector;
import id.dana.mybills.di.module.ViewModelFactory;
import id.dana.mybills.tracker.MyBillsAnalyticTracker;
import id.dana.utils.danah5.DanaH5Facade;

/* loaded from: classes9.dex */
public final class SinglePayBillBottomSheetFragment_MembersInjector implements MembersInjector<SinglePayBillBottomSheetFragment> {
    public static void MyBillsEntityDataFactory(SinglePayBillBottomSheetFragment singlePayBillBottomSheetFragment, ViewModelFactory viewModelFactory) {
        singlePayBillBottomSheetFragment.viewModelFactory = viewModelFactory;
    }

    public static void BuiltInFictitiousFunctionClassFactory(SinglePayBillBottomSheetFragment singlePayBillBottomSheetFragment, DanaH5Facade danaH5Facade) {
        singlePayBillBottomSheetFragment.danaH5Facade = danaH5Facade;
    }

    public static void MyBillsEntityDataFactory(SinglePayBillBottomSheetFragment singlePayBillBottomSheetFragment, MyBillsAnalyticTracker myBillsAnalyticTracker) {
        singlePayBillBottomSheetFragment.myBillsAnalyticTracker = myBillsAnalyticTracker;
    }
}
