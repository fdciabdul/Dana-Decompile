package id.dana.familyaccount.view.invite;

import dagger.MembersInjector;
import id.dana.familyaccount.contract.FamilyInvitationContract;
import id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker;

/* loaded from: classes5.dex */
public final class FamilyTncConsentActivity_MembersInjector implements MembersInjector<FamilyTncConsentActivity> {
    public static void PlaceComponentResult(FamilyTncConsentActivity familyTncConsentActivity, FamilyInvitationContract.Presenter presenter) {
        familyTncConsentActivity.presenter = presenter;
    }

    public static void getAuthRequestContext(FamilyTncConsentActivity familyTncConsentActivity, FamilyAccountAnalyticalTracker familyAccountAnalyticalTracker) {
        familyTncConsentActivity.familyAccountAnalyticalTracker = familyAccountAnalyticalTracker;
    }
}
