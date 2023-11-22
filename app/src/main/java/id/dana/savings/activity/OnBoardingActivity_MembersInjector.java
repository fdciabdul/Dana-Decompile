package id.dana.savings.activity;

import dagger.MembersInjector;
import id.dana.usereducation.BottomSheetOnBoardingContract;

/* loaded from: classes5.dex */
public final class OnBoardingActivity_MembersInjector implements MembersInjector<OnBoardingActivity> {
    public static void getAuthRequestContext(OnBoardingActivity onBoardingActivity, BottomSheetOnBoardingContract.Presenter presenter) {
        onBoardingActivity.onBoardingPresenter = presenter;
    }
}
