package id.dana.social.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.feeds.ui.model.RelationshipItemModel;
import id.dana.social.view.RestrictedContactItemViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/social/adapter/RestrictedContactAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/feeds/ui/model/RelationshipItemModel;", "Lid/dana/social/adapter/FriendshipListInteraction;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/social/adapter/FriendshipListInteraction;", "p0", "<init>", "(Lid/dana/social/adapter/FriendshipListInteraction;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RestrictedContactAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<RelationshipItemModel>, RelationshipItemModel> {
    private final FriendshipListInteraction KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new RestrictedContactItemViewHolder(viewGroup, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public RestrictedContactAdapter(FriendshipListInteraction friendshipListInteraction) {
        Intrinsics.checkNotNullParameter(friendshipListInteraction, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = friendshipListInteraction;
    }
}
