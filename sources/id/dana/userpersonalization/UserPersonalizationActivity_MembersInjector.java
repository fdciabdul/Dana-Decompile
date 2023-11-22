package id.dana.userpersonalization;

import dagger.MembersInjector;
import id.dana.contract.userpersonalization.UserPersonalizationContract;
import id.dana.userpersonalization.tracker.UserPersonalizationAnalyticTracker;

/* loaded from: classes5.dex */
public final class UserPersonalizationActivity_MembersInjector implements MembersInjector<UserPersonalizationActivity> {
    public static void getAuthRequestContext(UserPersonalizationActivity userPersonalizationActivity, UserPersonalizationContract.Presenter presenter) {
        userPersonalizationActivity.userPersonalizationPresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(UserPersonalizationActivity userPersonalizationActivity, UserPersonalizationAnalyticTracker userPersonalizationAnalyticTracker) {
        userPersonalizationActivity.userPersonalizationTracker = userPersonalizationAnalyticTracker;
    }
}
