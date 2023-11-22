package id.dana.social.adapter.friendsheader;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.feeds.ui.model.FriendModel;
import id.dana.feeds.ui.model.RelationshipItemModel;
import id.dana.social.mapper.FriendModelMapperKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0017B#\u0012\u0006\u0010\u0007\u001a\u00020\u0013\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\u000e¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ%\u0010\f\u001a\u00020\u000b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rR \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0010\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0014"}, d2 = {"Lid/dana/social/adapter/friendsheader/FriendsFeedsHeaderAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/feeds/ui/model/FriendModel;", "", "getItemCount", "()I", "p0", "getItemViewType", "(I)I", "p1", "", "onBindViewHolder", "(Lid/dana/base/BaseRecyclerViewHolder;I)V", "Lkotlin/Function1;", "Lid/dana/feeds/ui/model/RelationshipItemModel;", "MyBillsEntityDataFactory", "Lkotlin/jvm/functions/Function1;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "<init>", "(Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;Lkotlin/jvm/functions/Function1;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FriendsFeedsHeaderAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<FriendModel>, FriendModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final BaseRecyclerViewHolder.OnItemClickListener MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Function1<RelationshipItemModel, Unit> BuiltInFictitiousFunctionClassFactory;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return p0 == 0 ? 0 : 1;
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((FriendsFeedsHeaderAdapter) ((BaseRecyclerViewHolder) viewHolder), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        FriendsFeedsHeaderViewHolder friendsFeedsHeaderViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 0) {
            friendsFeedsHeaderViewHolder = new SeeAllFriendsHeaderViewHolder(viewGroup, this.MyBillsEntityDataFactory);
        } else {
            friendsFeedsHeaderViewHolder = new FriendsFeedsHeaderViewHolder(viewGroup, new FriendsFeedsHeaderAdapter$onCreateViewHolder$1(this));
        }
        return friendsFeedsHeaderViewHolder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FriendsFeedsHeaderAdapter(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener, Function1<? super RelationshipItemModel, Unit> function1) {
        Intrinsics.checkNotNullParameter(onItemClickListener, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.MyBillsEntityDataFactory = onItemClickListener;
        this.BuiltInFictitiousFunctionClassFactory = function1;
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return super.getItemCount() + 1;
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public final void onBindViewHolder(BaseRecyclerViewHolder<FriendModel> p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (p1 == 0) {
            p0.bindData(new FriendModel(null, null, null, false, null, null, null, 0, false, 0L, false, 2047, null));
        } else {
            p0.bindData(getItem(p1 - 1));
        }
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(FriendsFeedsHeaderAdapter friendsFeedsHeaderAdapter, int i) {
        FriendModel friendModel;
        List<FriendModel> items = friendsFeedsHeaderAdapter.getItems();
        if (items == null || (friendModel = items.get(i)) == null) {
            return;
        }
        friendsFeedsHeaderAdapter.BuiltInFictitiousFunctionClassFactory.invoke(FriendModelMapperKt.PlaceComponentResult(friendModel));
        Unit unit = Unit.INSTANCE;
    }
}
