package id.dana.danapoly.ui.board;

import dagger.MembersInjector;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.danapoly.ui.tracker.DanapolyMixpanelTracker;

/* loaded from: classes4.dex */
public final class DanapolyBoardTabActivity_MembersInjector implements MembersInjector<DanapolyBoardTabActivity> {
    public static void getAuthRequestContext(DanapolyBoardTabActivity danapolyBoardTabActivity, DanapolyMixpanelTracker danapolyMixpanelTracker) {
        danapolyBoardTabActivity.tracker = danapolyMixpanelTracker;
    }

    public static void getAuthRequestContext(DanapolyBoardTabActivity danapolyBoardTabActivity, ViewModelFactory viewModelFactory) {
        danapolyBoardTabActivity.viewModelFactory = viewModelFactory;
    }
}
