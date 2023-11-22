package id.dana.social.v2.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.social.adapter.BaseSocialFeedInteraction;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.v2.viewholder.FeedActivityViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/social/v2/adapter/FeedActivityAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/social/v2/viewholder/FeedActivityViewHolder;", "Lid/dana/social/model/FeedViewHolderModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedActivityAdapter extends BaseRecyclerViewAdapter<FeedActivityViewHolder, FeedViewHolderModel> {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new FeedActivityViewHolder(viewGroup, new BaseSocialFeedInteraction() { // from class: id.dana.social.v2.adapter.FeedActivityAdapter$onCreateViewHolder$1
        });
    }
}
