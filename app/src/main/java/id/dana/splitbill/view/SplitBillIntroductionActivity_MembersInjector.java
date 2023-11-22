package id.dana.splitbill.view;

import dagger.MembersInjector;
import id.dana.splitbill.SplitBillIntroductionContract;
import id.dana.splitbill.tracker.SplitBillAnalyticTracker;
import id.dana.usereducation.BottomSheetOnBoardingContract;

/* loaded from: classes5.dex */
public final class SplitBillIntroductionActivity_MembersInjector implements MembersInjector<SplitBillIntroductionActivity> {
    public static void PlaceComponentResult(SplitBillIntroductionActivity splitBillIntroductionActivity, SplitBillIntroductionContract.Presenter presenter) {
        splitBillIntroductionActivity.presenter = presenter;
    }

    public static void MyBillsEntityDataFactory(SplitBillIntroductionActivity splitBillIntroductionActivity, BottomSheetOnBoardingContract.Presenter presenter) {
        splitBillIntroductionActivity.onBoardingPresenter = presenter;
    }

    public static void MyBillsEntityDataFactory(SplitBillIntroductionActivity splitBillIntroductionActivity, SplitBillAnalyticTracker splitBillAnalyticTracker) {
        splitBillIntroductionActivity.splitBillAnalyticTracker = splitBillAnalyticTracker;
    }
}
