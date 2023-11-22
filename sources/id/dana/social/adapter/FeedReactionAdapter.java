package id.dana.social.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.social.adapter.viewholder.ReactionCountV2ViewHolder;
import id.dana.social.model.ReactionCountModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001eB+\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J&\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0007H\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J \u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00102\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001dR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lid/dana/social/adapter/FeedReactionAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/social/adapter/BaseReactionCountViewHolder;", "Lid/dana/social/model/ReactionCountModel;", "socialFeedClickListener", "Lid/dana/social/adapter/SocialFeedClickListener;", "reactions", "", "feedReactionClickListener", "Lid/dana/social/adapter/FeedReactionClickListener;", "isFeedRevamp", "", "(Lid/dana/social/adapter/SocialFeedClickListener;Ljava/util/List;Lid/dana/social/adapter/FeedReactionClickListener;Z)V", "getItemId", "", "position", "", "onBindViewHolder", "", "holder", "payloads", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "toggleReactionSelectedStatus", "itemPos", "nonFirstReactionModifiedCallback", "Lkotlin/Function0;", "Companion", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedReactionAdapter extends BaseRecyclerViewAdapter<BaseReactionCountViewHolder, ReactionCountModel> {
    public static final Companion BuiltInFictitiousFunctionClassFactory = new Companion(null);
    private final FeedReactionClickListener MyBillsEntityDataFactory;
    private final boolean PlaceComponentResult;
    private final SocialFeedClickListener getAuthRequestContext;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        BaseReactionCountViewHolder baseReactionCountViewHolder = (BaseReactionCountViewHolder) viewHolder;
        Intrinsics.checkNotNullParameter(baseReactionCountViewHolder, "");
        Intrinsics.checkNotNullParameter(list, "");
        if (list.isEmpty()) {
            super.onBindViewHolder(baseReactionCountViewHolder, i, list);
            return;
        }
        ReactionCountModel reactionCountModel = getItems().get(i);
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((Integer) it.next()).intValue()));
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (((Number) it2.next()).intValue() == 1) {
                baseReactionCountViewHolder.PlaceComponentResult().setReactionActive(reactionCountModel.getKClassImpl$Data$declaredNonStaticMembers$2());
                baseReactionCountViewHolder.PlaceComponentResult().setReactionCount(Integer.valueOf(reactionCountModel.getAuthRequestContext));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        ReactionCountV2ViewHolder reactionCountV2ViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (!this.PlaceComponentResult) {
            reactionCountV2ViewHolder = new ReactionCountViewHolder(viewGroup, this.getAuthRequestContext, this.MyBillsEntityDataFactory, this.PlaceComponentResult);
        } else {
            reactionCountV2ViewHolder = new ReactionCountV2ViewHolder(viewGroup, this.getAuthRequestContext, this.MyBillsEntityDataFactory, this.PlaceComponentResult);
        }
        return reactionCountV2ViewHolder;
    }

    public FeedReactionAdapter(SocialFeedClickListener socialFeedClickListener, List<ReactionCountModel> list, FeedReactionClickListener feedReactionClickListener, boolean z) {
        Intrinsics.checkNotNullParameter(socialFeedClickListener, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(feedReactionClickListener, "");
        this.getAuthRequestContext = socialFeedClickListener;
        this.MyBillsEntityDataFactory = feedReactionClickListener;
        this.PlaceComponentResult = z;
        setItems(list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int position) {
        return Integer.parseInt(getItems().get(position).PlaceComponentResult, 16);
    }

    public final void PlaceComponentResult(int i, Function0<Unit> function0) {
        if (i < 0 || i >= getItems().size()) {
            return;
        }
        boolean kClassImpl$Data$declaredNonStaticMembers$2 = getItems().get(i).getKClassImpl$Data$declaredNonStaticMembers$2();
        getItems().get(i).getAuthRequestContext += kClassImpl$Data$declaredNonStaticMembers$2 ? -1 : 1;
        getItems().get(i).KClassImpl$Data$declaredNonStaticMembers$2 = !kClassImpl$Data$declaredNonStaticMembers$2;
        if (getItems().get(i).getAuthRequestContext <= 0) {
            getItems().remove(i);
            notifyItemRemoved(i);
            return;
        }
        if (function0 != null) {
            function0.invoke();
        }
        if (function0 == null) {
            notifyItemChanged(i, 1);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/social/adapter/FeedReactionAdapter$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
