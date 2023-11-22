package id.dana.familyaccount.view.invite;

import dagger.MembersInjector;
import id.dana.familyaccount.contract.FamilyInvitationContract;

/* loaded from: classes5.dex */
public final class FamilyInviteMemberActivity_MembersInjector implements MembersInjector<FamilyInviteMemberActivity> {
    public static void getAuthRequestContext(FamilyInviteMemberActivity familyInviteMemberActivity, FamilyInvitationContract.Presenter presenter) {
        familyInviteMemberActivity.presenter = presenter;
    }
}
