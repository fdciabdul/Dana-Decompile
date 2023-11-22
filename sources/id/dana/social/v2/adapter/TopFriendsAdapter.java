package id.dana.social.v2.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.feeds.ui.model.FriendModel;
import id.dana.feeds.ui.model.MyFeedHeaderModel;
import id.dana.social.adapter.SocialFeedClickListener;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.v2.viewholder.TopFriendsSkeletonViewHolder;
import id.dana.social.v2.viewholder.TopFriendsViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0018\u0010\fJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0016"}, d2 = {"Lid/dana/social/v2/adapter/TopFriendsAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/model/FeedViewHolderModel;", "", "getItemCount", "()I", "p0", "getItemViewType", "(I)I", "", "MyBillsEntityDataFactory", "()V", "Lid/dana/feeds/ui/model/MyFeedHeaderModel;", "PlaceComponentResult", "Lid/dana/feeds/ui/model/MyFeedHeaderModel;", "Lid/dana/social/adapter/SocialFeedClickListener;", "getAuthRequestContext", "Lid/dana/social/adapter/SocialFeedClickListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "Lid/dana/feeds/ui/model/FriendModel;", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TopFriendsAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<FeedViewHolderModel>, FeedViewHolderModel> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public List<FriendModel> BuiltInFictitiousFunctionClassFactory = CollectionsKt.emptyList();

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public MyFeedHeaderModel MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public SocialFeedClickListener KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        TopFriendsSkeletonViewHolder topFriendsSkeletonViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 3) {
            topFriendsSkeletonViewHolder = new TopFriendsViewHolder(viewGroup, this.KClassImpl$Data$declaredNonStaticMembers$2);
        } else {
            topFriendsSkeletonViewHolder = new TopFriendsSkeletonViewHolder(viewGroup);
        }
        return topFriendsSkeletonViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        FeedViewHolderModel item = getItem(p0);
        if (item != null) {
            return item.getErrorConfigVersion;
        }
        return 0;
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        return getItems().size();
    }

    public final void MyBillsEntityDataFactory() {
        setItems(CollectionsKt.mutableListOf(new FeedViewHolderModel(0, null, null, null, null, false, 62, null)));
    }
}
