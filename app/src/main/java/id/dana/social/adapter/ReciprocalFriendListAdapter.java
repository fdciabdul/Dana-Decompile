package id.dana.social.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.feeds.ui.model.RelationshipItemModel;
import id.dana.social.adapter.viewholder.FeedsSectionTitleViewHolder;
import id.dana.social.adapter.viewholder.FeedsSimpleShimmerViewHolder;
import id.dana.social.adapter.viewholder.FriendListEmptyViewHolder;
import id.dana.social.adapter.viewholder.ReciprocalFriendListViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0006\u0010\r\u001a\u00020\u000eJ\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0006\u0010\u0013\u001a\u00020\bJ\u0010\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\u000eJ\u0016\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lid/dana/social/adapter/ReciprocalFriendListAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/feeds/ui/model/RelationshipItemModel;", "interaction", "Lid/dana/social/adapter/FriendshipListInteraction;", "(Lid/dana/social/adapter/FriendshipListInteraction;)V", "createShimmer", "", "shimmerCount", "", "getItemViewType", "position", "hasTitleSection", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeTitleSection", "setInitialItem", "withSectionTitle", "updateRelationshipStatus", "relationshipItemModel", "newStatus", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReciprocalFriendListAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<RelationshipItemModel>, RelationshipItemModel> {
    private final FriendshipListInteraction BuiltInFictitiousFunctionClassFactory;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        FeedsSectionTitleViewHolder feedsSectionTitleViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 1) {
            String string = viewGroup.getContext().getString(R.string.all_friend_list_section_title);
            Intrinsics.checkNotNullExpressionValue(string, "");
            feedsSectionTitleViewHolder = new FeedsSectionTitleViewHolder(viewGroup, string, null, 4, null);
        } else if (i == 2) {
            feedsSectionTitleViewHolder = new FriendListEmptyViewHolder(viewGroup);
        } else if (i == 3) {
            feedsSectionTitleViewHolder = new FeedsSimpleShimmerViewHolder(viewGroup, R.layout.viewholder_friend_request_skeleton);
        } else {
            feedsSectionTitleViewHolder = new ReciprocalFriendListViewHolder(viewGroup, this.BuiltInFictitiousFunctionClassFactory, new Function1<Integer, RelationshipItemModel>() { // from class: id.dana.social.adapter.ReciprocalFriendListAdapter$onCreateViewHolder$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final RelationshipItemModel invoke(int i2) {
                    RelationshipItemModel item = ReciprocalFriendListAdapter.this.getItem(i2);
                    Intrinsics.checkNotNullExpressionValue(item, "");
                    return item;
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ RelationshipItemModel invoke(Integer num) {
                    return invoke(num.intValue());
                }
            });
        }
        return feedsSectionTitleViewHolder;
    }

    public ReciprocalFriendListAdapter(FriendshipListInteraction friendshipListInteraction) {
        Intrinsics.checkNotNullParameter(friendshipListInteraction, "");
        this.BuiltInFictitiousFunctionClassFactory = friendshipListInteraction;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int position) {
        return getItems().get(position).NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        Intrinsics.checkNotNullExpressionValue(getItems(), "");
        if ((!r0.isEmpty()) != false) {
            List<RelationshipItemModel> items = getItems();
            Intrinsics.checkNotNullExpressionValue(items, "");
            if (((RelationshipItemModel) CollectionsKt.first((List) items)).NetworkUserEntityData$$ExternalSyntheticLambda2 == 1) {
                return true;
            }
        }
        return false;
    }

    public final void MyBillsEntityDataFactory(RelationshipItemModel relationshipItemModel, String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(relationshipItemModel, "");
        Intrinsics.checkNotNullParameter(str, "");
        List items = getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        Iterator it = items.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((RelationshipItemModel) obj, relationshipItemModel)) {
                break;
            }
        }
        RelationshipItemModel relationshipItemModel2 = (RelationshipItemModel) obj;
        if (relationshipItemModel2 != null) {
            Intrinsics.checkNotNullParameter(str, "");
            relationshipItemModel2.getErrorConfigVersion = str;
            if (Intrinsics.areEqual(str, "BLOCKING")) {
                removeItemEquals(relationshipItemModel);
                notifyDataSetChanged();
                return;
            }
            notifyItemChanged(getItems().indexOf(relationshipItemModel), relationshipItemModel2);
        }
    }

    public final void PlaceComponentResult(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add(new RelationshipItemModel(null, null, null, null, null, null, false, 0, null, false, 1, false, false, 7167, null));
        }
        arrayList.add(new RelationshipItemModel(null, null, null, null, null, null, false, 0, null, false, 2, false, false, 7167, null));
        setItems(arrayList);
    }

    public final void PlaceComponentResult() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            arrayList.add(new RelationshipItemModel(null, null, null, null, null, null, false, 0, null, false, 3, false, false, 7167, null));
        }
        setItems(arrayList);
    }
}
