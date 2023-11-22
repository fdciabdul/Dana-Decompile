package id.dana.wallet_v3.view.search.adapter;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.core.ui.extension.ViewExtKt;
import id.dana.wallet_v3.view.search.viewholder.AssetSearchRecommendationViewHolder;
import id.dana.wallet_v3.view.search.viewholder.NoResultViewHolder;
import id.dana.wallet_v3.view.search.viewholder.TitleViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/wallet_v3/view/search/adapter/WalletVerticalSpaceItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WalletVerticalSpaceItemDecoration extends RecyclerView.ItemDecoration {
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(outRect, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(parent, "");
        Intrinsics.checkNotNullParameter(state, "");
        RecyclerView.ViewHolder childViewHolder = parent.getChildViewHolder(view);
        if (childViewHolder instanceof AssetSearchRecommendationViewHolder) {
            outRect.bottom = ViewExtKt.getAuthRequestContext(8.0f);
        } else if (childViewHolder instanceof NoResultViewHolder) {
            outRect.top = ViewExtKt.getAuthRequestContext(8.0f);
        } else if (childViewHolder instanceof TitleViewHolder) {
            outRect.top = ViewExtKt.getAuthRequestContext(8.0f);
            outRect.bottom = ViewExtKt.getAuthRequestContext(8.0f);
        } else {
            outRect.bottom = ViewExtKt.getAuthRequestContext(12.0f);
        }
    }
}
