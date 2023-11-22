package id.dana.familyaccount.view.managefamily;

import dagger.MembersInjector;
import id.dana.familyaccount.contract.FamilyManageContract;
import id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker;

/* loaded from: classes5.dex */
public final class ManageOrganizerActivity_MembersInjector implements MembersInjector<ManageOrganizerActivity> {
    public static void MyBillsEntityDataFactory(ManageOrganizerActivity manageOrganizerActivity, FamilyManageContract.Presenter presenter) {
        manageOrganizerActivity.familyManagePresenter = presenter;
    }

    public static void PlaceComponentResult(ManageOrganizerActivity manageOrganizerActivity, FamilyAccountAnalyticalTracker familyAccountAnalyticalTracker) {
        manageOrganizerActivity.familyAccountAnalyticalTracker = familyAccountAnalyticalTracker;
    }
}
