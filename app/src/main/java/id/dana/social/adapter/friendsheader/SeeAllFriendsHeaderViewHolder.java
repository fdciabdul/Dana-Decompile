package id.dana.social.adapter.friendsheader;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.feeds.ui.model.FriendModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/social/adapter/friendsheader/SeeAllFriendsHeaderViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/feeds/ui/model/FriendModel;", "Landroid/view/ViewGroup;", "getAuthRequestContext", "Landroid/view/ViewGroup;", "MyBillsEntityDataFactory", "p0", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SeeAllFriendsHeaderViewHolder extends BaseRecyclerViewHolder<FriendModel> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final ViewGroup MyBillsEntityDataFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(FriendModel friendModel) {
        Intrinsics.checkNotNullParameter(friendModel, "");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SeeAllFriendsHeaderViewHolder(ViewGroup viewGroup, final BaseRecyclerViewHolder.OnItemClickListener onItemClickListener) {
        super(viewGroup.getContext(), R.layout.viewholder_see_all_header, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(onItemClickListener, "");
        this.MyBillsEntityDataFactory = viewGroup;
        ConstraintLayout constraintLayout = (ConstraintLayout) this.itemView.findViewById(R.id.vg_see_all_header_root);
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.adapter.friendsheader.SeeAllFriendsHeaderViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SeeAllFriendsHeaderViewHolder.PlaceComponentResult(BaseRecyclerViewHolder.OnItemClickListener.this, this);
                }
            });
        }
    }

    public static /* synthetic */ void PlaceComponentResult(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener, SeeAllFriendsHeaderViewHolder seeAllFriendsHeaderViewHolder) {
        Intrinsics.checkNotNullParameter(onItemClickListener, "");
        Intrinsics.checkNotNullParameter(seeAllFriendsHeaderViewHolder, "");
        onItemClickListener.onItemClick(seeAllFriendsHeaderViewHolder.getAbsoluteAdapterPosition());
    }
}
