package id.dana.familyaccount.view.intro;

import dagger.MembersInjector;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.familyaccount.contract.FamilyActivationContract;
import id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker;

/* loaded from: classes5.dex */
public final class FamilyAccountIntroActivity_MembersInjector implements MembersInjector<FamilyAccountIntroActivity> {
    public static void PlaceComponentResult(FamilyAccountIntroActivity familyAccountIntroActivity, FamilyActivationContract.Presenter presenter) {
        familyAccountIntroActivity.presenter = presenter;
    }

    public static void getAuthRequestContext(FamilyAccountIntroActivity familyAccountIntroActivity, FamilyAccountAnalyticalTracker familyAccountAnalyticalTracker) {
        familyAccountIntroActivity.familyAccountAnalyticalTracker = familyAccountAnalyticalTracker;
    }

    public static void BuiltInFictitiousFunctionClassFactory(FamilyAccountIntroActivity familyAccountIntroActivity, DynamicUrlWrapper dynamicUrlWrapper) {
        familyAccountIntroActivity.dynamicUrlWrapper = dynamicUrlWrapper;
    }
}
