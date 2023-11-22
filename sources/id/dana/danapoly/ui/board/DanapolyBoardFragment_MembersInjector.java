package id.dana.danapoly.ui.board;

import dagger.MembersInjector;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.danapoly.ui.tracker.DanapolyAnalyticTracker;

/* loaded from: classes4.dex */
public final class DanapolyBoardFragment_MembersInjector implements MembersInjector<DanapolyBoardFragment> {
    public static void MyBillsEntityDataFactory(DanapolyBoardFragment danapolyBoardFragment, ViewModelFactory viewModelFactory) {
        danapolyBoardFragment.viewModelFactory = viewModelFactory;
    }

    public static void getAuthRequestContext(DanapolyBoardFragment danapolyBoardFragment, DanapolyAnalyticTracker danapolyAnalyticTracker) {
        danapolyBoardFragment.tracker = danapolyAnalyticTracker;
    }
}
