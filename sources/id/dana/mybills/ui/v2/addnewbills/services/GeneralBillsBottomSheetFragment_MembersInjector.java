package id.dana.mybills.ui.v2.addnewbills.services;

import dagger.MembersInjector;
import id.dana.mybills.di.module.ViewModelFactory;
import id.dana.mybills.tracker.MyBillsAnalyticTracker;

/* loaded from: classes9.dex */
public final class GeneralBillsBottomSheetFragment_MembersInjector implements MembersInjector<GeneralBillsBottomSheetFragment> {
    public static void getAuthRequestContext(GeneralBillsBottomSheetFragment generalBillsBottomSheetFragment, ViewModelFactory viewModelFactory) {
        generalBillsBottomSheetFragment.viewModelFactory = viewModelFactory;
    }

    public static void PlaceComponentResult(GeneralBillsBottomSheetFragment generalBillsBottomSheetFragment, MyBillsAnalyticTracker myBillsAnalyticTracker) {
        generalBillsBottomSheetFragment.myBillsAnalyticTracker = myBillsAnalyticTracker;
    }
}
