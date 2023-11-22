package com.afollestad.materialdialogs.internal.list;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.R;
import com.google.firebase.perf.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0017\u0010\f\u001a\u00020\u000b8\u0007¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00108G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u00168\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a"}, d2 = {"Lcom/afollestad/materialdialogs/internal/list/MultiChoiceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "view", "", "onClick", "(Landroid/view/View;)V", "Lcom/afollestad/materialdialogs/internal/list/MultiChoiceDialogAdapter;", "adapter", "Lcom/afollestad/materialdialogs/internal/list/MultiChoiceDialogAdapter;", "Landroidx/appcompat/widget/AppCompatCheckBox;", "controlView", "Landroidx/appcompat/widget/AppCompatCheckBox;", "getControlView", "()Landroidx/appcompat/widget/AppCompatCheckBox;", "", "value", Constants.ENABLE_DISABLE, "()Z", "setEnabled", "(Z)V", "Landroid/widget/TextView;", "titleView", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "itemView", "<init>", "(Landroid/view/View;Lcom/afollestad/materialdialogs/internal/list/MultiChoiceDialogAdapter;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class MultiChoiceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final MultiChoiceDialogAdapter adapter;
    private final AppCompatCheckBox controlView;
    private final TextView titleView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiChoiceViewHolder(View view, MultiChoiceDialogAdapter multiChoiceDialogAdapter) {
        super(view);
        Intrinsics.checkParameterIsNotNull(view, "");
        Intrinsics.checkParameterIsNotNull(multiChoiceDialogAdapter, "");
        this.adapter = multiChoiceDialogAdapter;
        view.setOnClickListener(this);
        View findViewById = view.findViewById(R.id.md_control);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "");
        this.controlView = (AppCompatCheckBox) findViewById;
        View findViewById2 = view.findViewById(R.id.md_title);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "");
        this.titleView = (TextView) findViewById2;
    }

    @JvmName(name = "getControlView")
    public final AppCompatCheckBox getControlView() {
        return this.controlView;
    }

    @JvmName(name = "getTitleView")
    public final TextView getTitleView() {
        return this.titleView;
    }

    @JvmName(name = Constants.ENABLE_DISABLE)
    public final boolean isEnabled() {
        View view = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "");
        return view.isEnabled();
    }

    @JvmName(name = "setEnabled")
    public final void setEnabled(boolean z) {
        View view = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "");
        view.setEnabled(z);
        this.controlView.setEnabled(z);
        this.titleView.setEnabled(z);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Intrinsics.checkParameterIsNotNull(view, "");
        if (getAdapterPosition() < 0) {
            return;
        }
        this.adapter.itemClicked$core(getAdapterPosition());
    }
}
