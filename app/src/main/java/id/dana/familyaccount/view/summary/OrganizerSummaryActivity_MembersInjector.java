package id.dana.familyaccount.view.summary;

import dagger.MembersInjector;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.familyaccount.contract.OrganizerSummaryContract;
import id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker;

/* loaded from: classes5.dex */
public final class OrganizerSummaryActivity_MembersInjector implements MembersInjector<OrganizerSummaryActivity> {
    public static void BuiltInFictitiousFunctionClassFactory(OrganizerSummaryActivity organizerSummaryActivity, OrganizerSummaryContract.Presenter presenter) {
        organizerSummaryActivity.presenter = presenter;
    }

    public static void MyBillsEntityDataFactory(OrganizerSummaryActivity organizerSummaryActivity, FamilyAccountAnalyticalTracker familyAccountAnalyticalTracker) {
        organizerSummaryActivity.familyAccountAnalyticalTracker = familyAccountAnalyticalTracker;
    }

    public static void PlaceComponentResult(OrganizerSummaryActivity organizerSummaryActivity, DynamicUrlWrapper dynamicUrlWrapper) {
        organizerSummaryActivity.dynamicUrlWrapper = dynamicUrlWrapper;
    }
}
