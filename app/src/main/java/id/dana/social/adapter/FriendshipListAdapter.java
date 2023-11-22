package id.dana.social.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.feeds.ui.model.RelationshipItemModel;
import id.dana.social.view.FriendshipItemViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/social/adapter/FriendshipListAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/feeds/ui/model/RelationshipItemModel;", "Lid/dana/social/adapter/FriendshipListInteraction;", "PlaceComponentResult", "Lid/dana/social/adapter/FriendshipListInteraction;", "getAuthRequestContext", "p0", "<init>", "(Lid/dana/social/adapter/FriendshipListInteraction;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FriendshipListAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<RelationshipItemModel>, RelationshipItemModel> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final FriendshipListInteraction getAuthRequestContext;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new FriendshipItemViewHolder(viewGroup, this.getAuthRequestContext);
    }

    public FriendshipListAdapter(FriendshipListInteraction friendshipListInteraction) {
        Intrinsics.checkNotNullParameter(friendshipListInteraction, "");
        this.getAuthRequestContext = friendshipListInteraction;
    }
}
