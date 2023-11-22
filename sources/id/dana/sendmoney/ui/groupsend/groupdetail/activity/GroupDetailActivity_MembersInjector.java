package id.dana.sendmoney.ui.groupsend.groupdetail.activity;

import dagger.MembersInjector;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.sendmoney.util.GroupSendTrackerHelper;

/* loaded from: classes5.dex */
public final class GroupDetailActivity_MembersInjector implements MembersInjector<GroupDetailActivity> {
    public static void BuiltInFictitiousFunctionClassFactory(GroupDetailActivity groupDetailActivity, ViewModelFactory viewModelFactory) {
        groupDetailActivity.viewModelFactory = viewModelFactory;
    }

    public static void PlaceComponentResult(GroupDetailActivity groupDetailActivity, GroupSendTrackerHelper groupSendTrackerHelper) {
        groupDetailActivity.groupSendTrackerHelper = groupSendTrackerHelper;
    }
}
