package id.dana.danapoly.ui.leaderboard.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.core.ui.adapter.BaseRecyclerViewHolder;
import id.dana.danapoly.databinding.ItemLeaderboardBinding;
import id.dana.danapoly.databinding.ItemLeaderboardDividerBinding;
import id.dana.danapoly.databinding.ItemLeaderboardMyselfBinding;
import id.dana.danapoly.ui.model.leaderboard.LeaderboardModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 \u00102\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/danapoly/ui/leaderboard/adapter/LeaderboardAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lid/dana/core/ui/adapter/BaseRecyclerViewHolder;", "Lid/dana/danapoly/ui/model/leaderboard/LeaderboardModel;", "", "getItemCount", "()I", "p0", "getItemViewType", "(I)I", "", "getAuthRequestContext", "Ljava/util/List;", "MyBillsEntityDataFactory", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LeaderboardAdapter extends RecyclerView.Adapter<BaseRecyclerViewHolder<LeaderboardModel>> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public List<LeaderboardModel> MyBillsEntityDataFactory = CollectionsKt.emptyList();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(BaseRecyclerViewHolder<LeaderboardModel> baseRecyclerViewHolder, int i) {
        LeaderboardViewHolder leaderboardViewHolder;
        BaseRecyclerViewHolder<LeaderboardModel> baseRecyclerViewHolder2 = baseRecyclerViewHolder;
        Intrinsics.checkNotNullParameter(baseRecyclerViewHolder2, "");
        baseRecyclerViewHolder2.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory.get(i));
        if (((LeaderboardModel) CollectionsKt.last((List) this.MyBillsEntityDataFactory)).myselfNotBig10() && this.MyBillsEntityDataFactory.get(i).shouldShowBottomDivider()) {
            leaderboardViewHolder = baseRecyclerViewHolder2 instanceof LeaderboardViewHolder ? (LeaderboardViewHolder) baseRecyclerViewHolder2 : null;
            if (leaderboardViewHolder != null) {
                View view = leaderboardViewHolder.BuiltInFictitiousFunctionClassFactory.scheduleImpl;
                Intrinsics.checkNotNullExpressionValue(view, "");
                view.setVisibility(0);
                return;
            }
            return;
        }
        leaderboardViewHolder = baseRecyclerViewHolder2 instanceof LeaderboardViewHolder ? (LeaderboardViewHolder) baseRecyclerViewHolder2 : null;
        if (leaderboardViewHolder != null) {
            View view2 = leaderboardViewHolder.BuiltInFictitiousFunctionClassFactory.scheduleImpl;
            Intrinsics.checkNotNullExpressionValue(view2, "");
            view2.setVisibility(8);
        }
    }

    /* JADX WARN: Type inference failed for: r4v6, types: [androidx.recyclerview.widget.RecyclerView$ViewHolder, id.dana.core.ui.adapter.BaseRecyclerViewHolder<id.dana.danapoly.ui.model.leaderboard.LeaderboardModel>] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ BaseRecyclerViewHolder<LeaderboardModel> onCreateViewHolder(ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder viewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 0) {
            ItemLeaderboardBinding BuiltInFictitiousFunctionClassFactory = ItemLeaderboardBinding.BuiltInFictitiousFunctionClassFactory(LayoutInflater.from(viewGroup.getContext()), viewGroup);
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
            viewHolder = (BaseRecyclerViewHolder) new LeaderboardViewHolder(BuiltInFictitiousFunctionClassFactory);
        } else if (i == 2) {
            ItemLeaderboardMyselfBinding BuiltInFictitiousFunctionClassFactory2 = ItemLeaderboardMyselfBinding.BuiltInFictitiousFunctionClassFactory(LayoutInflater.from(viewGroup.getContext()), viewGroup);
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory2, "");
            viewHolder = (BaseRecyclerViewHolder) new LeaderboardMyselfViewHolder(BuiltInFictitiousFunctionClassFactory2);
        } else {
            ItemLeaderboardDividerBinding PlaceComponentResult = ItemLeaderboardDividerBinding.PlaceComponentResult(LayoutInflater.from(viewGroup.getContext()), viewGroup);
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
            viewHolder = (BaseRecyclerViewHolder) new LeaderboardDividerViewHolder(PlaceComponentResult);
        }
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return this.MyBillsEntityDataFactory.get(p0).getType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        return this.MyBillsEntityDataFactory.size();
    }
}
