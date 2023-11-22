package com.afollestad.materialdialogs.files;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0017\u0010\f\u001a\u00020\u000b8\u0007¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014"}, d2 = {"Lcom/afollestad/materialdialogs/files/FileChooserViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "view", "", "onClick", "(Landroid/view/View;)V", "Lcom/afollestad/materialdialogs/files/FileChooserAdapter;", "adapter", "Lcom/afollestad/materialdialogs/files/FileChooserAdapter;", "Landroid/widget/ImageView;", "iconView", "Landroid/widget/ImageView;", "getIconView", "()Landroid/widget/ImageView;", "Landroid/widget/TextView;", "nameView", "Landroid/widget/TextView;", "getNameView", "()Landroid/widget/TextView;", "itemView", "<init>", "(Landroid/view/View;Lcom/afollestad/materialdialogs/files/FileChooserAdapter;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class FileChooserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final FileChooserAdapter adapter;
    private final ImageView iconView;
    private final TextView nameView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileChooserViewHolder(View view, FileChooserAdapter fileChooserAdapter) {
        super(view);
        Intrinsics.checkParameterIsNotNull(view, "");
        Intrinsics.checkParameterIsNotNull(fileChooserAdapter, "");
        this.adapter = fileChooserAdapter;
        view.setOnClickListener(this);
        View findViewById = view.findViewById(R.id.icon);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "");
        this.iconView = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.name);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "");
        this.nameView = (TextView) findViewById2;
    }

    @JvmName(name = "getIconView")
    public final ImageView getIconView() {
        return this.iconView;
    }

    @JvmName(name = "getNameView")
    public final TextView getNameView() {
        return this.nameView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Intrinsics.checkParameterIsNotNull(view, "");
        this.adapter.itemClicked(getAdapterPosition());
    }
}
