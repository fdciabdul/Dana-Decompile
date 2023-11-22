package id.dana.familyaccount.view.dashboard;

import dagger.MembersInjector;
import id.dana.familyaccount.contract.FamilyDashboardContract;
import id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker;
import id.dana.usereducation.BottomSheetOnBoardingContract;

/* loaded from: classes5.dex */
public final class OrganizerDashboardActivity_MembersInjector implements MembersInjector<OrganizerDashboardActivity> {
    public static void getAuthRequestContext(OrganizerDashboardActivity organizerDashboardActivity, BottomSheetOnBoardingContract.Presenter presenter) {
        organizerDashboardActivity.onBoardingServicePresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(OrganizerDashboardActivity organizerDashboardActivity, FamilyDashboardContract.Presenter presenter) {
        organizerDashboardActivity.familyDashboardPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(OrganizerDashboardActivity organizerDashboardActivity, FamilyAccountAnalyticalTracker familyAccountAnalyticalTracker) {
        organizerDashboardActivity.familyAccountAnalyticalTracker = familyAccountAnalyticalTracker;
    }
}
