package com.afollestad.materialdialogs.internal.list;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0017\u0010\f\u001a\u00020\u000b8\u0007¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f"}, d2 = {"Lcom/afollestad/materialdialogs/internal/list/PlainListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "view", "", "onClick", "(Landroid/view/View;)V", "Lcom/afollestad/materialdialogs/internal/list/PlainListDialogAdapter;", "adapter", "Lcom/afollestad/materialdialogs/internal/list/PlainListDialogAdapter;", "Landroid/widget/TextView;", "titleView", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "itemView", "<init>", "(Landroid/view/View;Lcom/afollestad/materialdialogs/internal/list/PlainListDialogAdapter;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class PlainListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final PlainListDialogAdapter adapter;
    private final TextView titleView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlainListViewHolder(View view, PlainListDialogAdapter plainListDialogAdapter) {
        super(view);
        Intrinsics.checkParameterIsNotNull(view, "");
        Intrinsics.checkParameterIsNotNull(plainListDialogAdapter, "");
        this.adapter = plainListDialogAdapter;
        view.setOnClickListener(this);
        View childAt = ((ViewGroup) view).getChildAt(0);
        if (childAt == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        }
        this.titleView = (TextView) childAt;
    }

    @JvmName(name = "getTitleView")
    public final TextView getTitleView() {
        return this.titleView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Intrinsics.checkParameterIsNotNull(view, "");
        this.adapter.itemClicked(getAdapterPosition());
    }
}
