package id.dana.familyaccount.view.dashboard;

import dagger.MembersInjector;
import id.dana.familyaccount.contract.FamilyDashboardContract;

/* loaded from: classes5.dex */
public final class MemberDashboardActivity_MembersInjector implements MembersInjector<MemberDashboardActivity> {
    public static void MyBillsEntityDataFactory(MemberDashboardActivity memberDashboardActivity, FamilyDashboardContract.Presenter presenter) {
        memberDashboardActivity.familyDashboardPresenter = presenter;
    }
}
