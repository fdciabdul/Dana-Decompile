package id.dana.social.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.feeds.ui.reaction.model.ReactionModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B0\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u0019\u0010\f\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0003¢\u0006\u0002\b\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\r\u0010\u000eR'\u0010\t\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0003¢\u0006\u0002\b\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/social/adapter/ReactionListAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/feeds/ui/reaction/model/ReactionModel;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "", "PlaceComponentResult", "Lkotlin/jvm/functions/Function1;", "getAuthRequestContext", "", "p0", "p1", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReactionListAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<ReactionModel>, ReactionModel> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Function1<ReactionModel, Unit> getAuthRequestContext;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new ReactionListViewHolder(viewGroup, this.getAuthRequestContext);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ReactionListAdapter(List<ReactionModel> list, Function1<? super ReactionModel, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.getAuthRequestContext = function1;
        setItems(list);
    }
}
