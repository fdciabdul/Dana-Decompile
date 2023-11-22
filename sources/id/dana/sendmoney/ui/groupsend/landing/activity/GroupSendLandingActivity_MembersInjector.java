package id.dana.sendmoney.ui.groupsend.landing.activity;

import dagger.MembersInjector;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.sendmoney.util.GroupSendTrackerHelper;

/* loaded from: classes5.dex */
public final class GroupSendLandingActivity_MembersInjector implements MembersInjector<GroupSendLandingActivity> {
    public static void MyBillsEntityDataFactory(GroupSendLandingActivity groupSendLandingActivity, ViewModelFactory viewModelFactory) {
        groupSendLandingActivity.viewModelFactory = viewModelFactory;
    }

    public static void PlaceComponentResult(GroupSendLandingActivity groupSendLandingActivity, GroupSendTrackerHelper groupSendTrackerHelper) {
        groupSendLandingActivity.groupSendTrackerHelper = groupSendTrackerHelper;
    }
}
