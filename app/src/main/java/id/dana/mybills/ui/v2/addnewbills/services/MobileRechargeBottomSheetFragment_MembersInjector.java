package id.dana.mybills.ui.v2.addnewbills.services;

import dagger.MembersInjector;
import id.dana.mybills.di.module.ViewModelFactory;
import id.dana.mybills.tracker.MyBillsAnalyticTracker;

/* loaded from: classes9.dex */
public final class MobileRechargeBottomSheetFragment_MembersInjector implements MembersInjector<MobileRechargeBottomSheetFragment> {
    public static void BuiltInFictitiousFunctionClassFactory(MobileRechargeBottomSheetFragment mobileRechargeBottomSheetFragment, ViewModelFactory viewModelFactory) {
        mobileRechargeBottomSheetFragment.viewModelFactory = viewModelFactory;
    }

    public static void MyBillsEntityDataFactory(MobileRechargeBottomSheetFragment mobileRechargeBottomSheetFragment, MyBillsAnalyticTracker myBillsAnalyticTracker) {
        mobileRechargeBottomSheetFragment.myBillsAnalyticTracker = myBillsAnalyticTracker;
    }
}
