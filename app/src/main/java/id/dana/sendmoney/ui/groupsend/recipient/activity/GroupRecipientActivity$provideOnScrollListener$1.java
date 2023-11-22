package id.dana.sendmoney.ui.groupsend.recipient.activity;

import android.os.Handler;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/activity/GroupRecipientActivity$provideOnScrollListener$1;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "p0", "", "p1", "", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GroupRecipientActivity$provideOnScrollListener$1 extends RecyclerView.OnScrollListener {
    final /* synthetic */ GroupRecipientActivity KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GroupRecipientActivity$provideOnScrollListener$1(GroupRecipientActivity groupRecipientActivity) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = groupRecipientActivity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (p1 != 0) {
            if (p1 == 1) {
                GroupRecipientActivity.access$getHandler(this.KClassImpl$Data$declaredNonStaticMembers$2).removeCallbacksAndMessages(null);
                return;
            }
            return;
        }
        Handler access$getHandler = GroupRecipientActivity.access$getHandler(this.KClassImpl$Data$declaredNonStaticMembers$2);
        final GroupRecipientActivity groupRecipientActivity = this.KClassImpl$Data$declaredNonStaticMembers$2;
        access$getHandler.postDelayed(new Runnable() { // from class: id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity$provideOnScrollListener$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                GroupRecipientActivity$provideOnScrollListener$1.PlaceComponentResult(GroupRecipientActivity.this);
            }
        }, 1500L);
    }

    public static /* synthetic */ void PlaceComponentResult(GroupRecipientActivity groupRecipientActivity) {
        Intrinsics.checkNotNullParameter(groupRecipientActivity, "");
        GroupRecipientActivity.access$slideUpBottomViewButton(groupRecipientActivity);
    }
}
