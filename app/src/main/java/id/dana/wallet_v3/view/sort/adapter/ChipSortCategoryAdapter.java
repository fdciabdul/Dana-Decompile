package id.dana.wallet_v3.view.sort.adapter;

import android.view.ViewGroup;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.wallet_v3.view.sort.model.SortCategoryModel;
import id.dana.wallet_v3.view.sort.viewholder.ChipSortCategoryViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B%\u0012\u001c\b\u0002\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u0013¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ%\u0010\u000e\u001a\u00020\r2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012R(\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/wallet_v3/view/sort/adapter/ChipSortCategoryAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/wallet_v3/view/sort/model/SortCategoryModel;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lid/dana/base/BaseRecyclerViewHolder;", "", "categories", "currentPosition", "", "refreshView", "(Ljava/util/List;I)V", "position", "setSelected", "(I)V", "Lkotlin/Function2;", "onClickListener", "Lkotlin/jvm/functions/Function2;", "previousPosition", "I", "<init>", "(Lkotlin/jvm/functions/Function2;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ChipSortCategoryAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<SortCategoryModel>, SortCategoryModel> {
    private final Function2<SortCategoryModel, Integer, Unit> onClickListener;
    private int previousPosition;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.jvm.functions.Function2] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ChipSortCategoryAdapter() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.sort.adapter.ChipSortCategoryAdapter.<init>():void");
    }

    public /* synthetic */ ChipSortCategoryAdapter(Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChipSortCategoryAdapter(Function2<? super SortCategoryModel, ? super Integer, Unit> function2) {
        this.onClickListener = function2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final BaseRecyclerViewHolder<SortCategoryModel> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "");
        return new ChipSortCategoryViewHolder(parent, this.onClickListener);
    }

    public final void setSelected(int position) {
        List<SortCategoryModel> items = getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        items.get(this.previousPosition).setSelected(false);
        items.get(position).setSelected(true);
        refreshView(items, position);
        this.previousPosition = position;
    }

    private final void refreshView(List<SortCategoryModel> categories, int currentPosition) {
        setItems(categories);
        notifyItemChanged(this.previousPosition);
        notifyItemChanged(currentPosition);
    }
}
