package id.dana.familyaccount.view.memberlimit;

import dagger.MembersInjector;
import id.dana.familyaccount.contract.FamilyManageContract;

/* loaded from: classes5.dex */
public final class ManageMemberLimitActivity_MembersInjector implements MembersInjector<ManageMemberLimitActivity> {
    public static void getAuthRequestContext(ManageMemberLimitActivity manageMemberLimitActivity, FamilyManageContract.Presenter presenter) {
        manageMemberLimitActivity.familyManagePresenter = presenter;
    }
}
