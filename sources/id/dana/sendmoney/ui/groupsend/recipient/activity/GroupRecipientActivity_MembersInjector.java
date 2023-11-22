package id.dana.sendmoney.ui.groupsend.recipient.activity;

import dagger.MembersInjector;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.sendmoney.util.GroupSendTrackerHelper;

/* loaded from: classes5.dex */
public final class GroupRecipientActivity_MembersInjector implements MembersInjector<GroupRecipientActivity> {
    public static void PlaceComponentResult(GroupRecipientActivity groupRecipientActivity, ViewModelFactory viewModelFactory) {
        groupRecipientActivity.viewModelFactory = viewModelFactory;
    }

    public static void PlaceComponentResult(GroupRecipientActivity groupRecipientActivity, GroupSendTrackerHelper groupSendTrackerHelper) {
        groupRecipientActivity.groupSendTrackerHelper = groupSendTrackerHelper;
    }
}
