package id.dana.sendmoney.ui.groupsend.summary.activity;

import dagger.MembersInjector;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.sendmoney.ui.groupsend.summary.factory.GroupSendSummaryFactory;
import id.dana.sendmoney.util.GroupSendTrackerHelper;

/* loaded from: classes5.dex */
public final class GroupSendSummaryActivity_MembersInjector implements MembersInjector<GroupSendSummaryActivity> {
    public static void getAuthRequestContext(GroupSendSummaryActivity groupSendSummaryActivity, ViewModelFactory viewModelFactory) {
        groupSendSummaryActivity.viewModelFactory = viewModelFactory;
    }

    public static void MyBillsEntityDataFactory(GroupSendSummaryActivity groupSendSummaryActivity, GroupSendSummaryFactory groupSendSummaryFactory) {
        groupSendSummaryActivity.groupSendSummaryFactory = groupSendSummaryFactory;
    }

    public static void getAuthRequestContext(GroupSendSummaryActivity groupSendSummaryActivity, GroupSendTrackerHelper groupSendTrackerHelper) {
        groupSendSummaryActivity.groupSendTrackerHelper = groupSendTrackerHelper;
    }
}
