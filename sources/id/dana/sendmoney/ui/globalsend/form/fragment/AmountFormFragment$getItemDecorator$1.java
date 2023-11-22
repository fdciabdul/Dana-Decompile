package id.dana.sendmoney.ui.globalsend.form.fragment;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.core.ui.extension.ViewExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/fragment/AmountFormFragment$getItemDecorator$1;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "p0", "Landroid/view/View;", "p1", "Landroidx/recyclerview/widget/RecyclerView;", "p2", "Landroidx/recyclerview/widget/RecyclerView$State;", "p3", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AmountFormFragment$getItemDecorator$1 extends RecyclerView.ItemDecoration {
    AmountFormFragment$getItemDecorator$1() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect p0, View p1, RecyclerView p2, RecyclerView.State p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        int authRequestContext = ViewExtKt.getAuthRequestContext(16.0f);
        if (p2.getChildAdapterPosition(p1) == 0) {
            p0.top = authRequestContext;
        }
        p0.bottom = authRequestContext;
    }
}
