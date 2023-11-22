package id.dana.social.adapter.friendsheader;

import android.view.ViewGroup;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.feeds.ui.model.FriendModel;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.view.FriendsFeedsHeaderView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B2\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0019\u0010\f\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\t¢\u0006\u0002\b\n\u0012\u0004\u0012\u00020\u000b0\b\u0012\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/social/adapter/friendsheader/TopFriendViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/model/FeedViewHolderModel;", "Landroid/view/ViewGroup;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/ViewGroup;", "BuiltInFictitiousFunctionClassFactory", "p0", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "", "p1", "p2", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TopFriendViewHolder extends BaseRecyclerViewHolder<FeedViewHolderModel> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final ViewGroup BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(FeedViewHolderModel feedViewHolderModel) {
        List<FriendModel> list;
        FeedViewHolderModel feedViewHolderModel2 = feedViewHolderModel;
        if (feedViewHolderModel2 == null || (list = feedViewHolderModel2.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
            return;
        }
        ((FriendsFeedsHeaderView) this.itemView.findViewById(R.id.view_friends_feeds_header)).setItems(list);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopFriendViewHolder(ViewGroup viewGroup, Function1<? super Boolean, Unit> function1, boolean z) {
        super(viewGroup.getContext(), R.layout.viewholder_top_friends, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.BuiltInFictitiousFunctionClassFactory = viewGroup;
        FriendsFeedsHeaderView friendsFeedsHeaderView = (FriendsFeedsHeaderView) this.itemView.findViewById(R.id.view_friends_feeds_header);
        if (friendsFeedsHeaderView != null) {
            friendsFeedsHeaderView.setSetEnableRefresh(function1);
        }
        FriendsFeedsHeaderView friendsFeedsHeaderView2 = (FriendsFeedsHeaderView) this.itemView.findViewById(R.id.view_friends_feeds_header);
        if (friendsFeedsHeaderView2 != null) {
            friendsFeedsHeaderView2.setShowReciprocalRelationship(z);
        }
    }
}
