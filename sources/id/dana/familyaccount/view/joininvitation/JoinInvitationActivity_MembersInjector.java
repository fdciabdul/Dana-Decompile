package id.dana.familyaccount.view.joininvitation;

import dagger.MembersInjector;
import id.dana.familyaccount.contract.FamilyJoinInvitationContract;
import id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker;

/* loaded from: classes5.dex */
public final class JoinInvitationActivity_MembersInjector implements MembersInjector<JoinInvitationActivity> {
    public static void BuiltInFictitiousFunctionClassFactory(JoinInvitationActivity joinInvitationActivity, FamilyJoinInvitationContract.Presenter presenter) {
        joinInvitationActivity.joinInvitationPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(JoinInvitationActivity joinInvitationActivity, FamilyAccountAnalyticalTracker familyAccountAnalyticalTracker) {
        joinInvitationActivity.familyAccountAnalyticalTracker = familyAccountAnalyticalTracker;
    }
}
