package id.dana.familyaccount.view.managefamily;

import dagger.MembersInjector;
import id.dana.familyaccount.contract.FamilyManageContract;
import id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker;

/* loaded from: classes5.dex */
public final class ManageMemberActivity_MembersInjector implements MembersInjector<ManageMemberActivity> {
    public static void PlaceComponentResult(ManageMemberActivity manageMemberActivity, FamilyAccountAnalyticalTracker familyAccountAnalyticalTracker) {
        manageMemberActivity.familyAccountAnalyticalTracker = familyAccountAnalyticalTracker;
    }

    public static void BuiltInFictitiousFunctionClassFactory(ManageMemberActivity manageMemberActivity, FamilyManageContract.Presenter presenter) {
        manageMemberActivity.familyManagePresenter = presenter;
    }
}
