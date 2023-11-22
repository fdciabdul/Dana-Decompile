package com.afollestad.materialdialogs.internal.list;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.WhichButton;
import com.afollestad.materialdialogs.actions.DialogActionExtKt;
import com.afollestad.materialdialogs.list.DialogListExtKt;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u001c\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012C\u0012\u0004\u0012\u00020\u0004\u00129\u00127\u0012\u000b\u0012\t\u0018\u00010\u0006¢\u0006\u0002\b\u0007\u0012\u000b\u0012\t\u0018\u00010\b¢\u0006\u0002\b\u0007\u0012\u000b\u0012\t\u0018\u00010\u0004¢\u0006\u0002\b\u0007\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0004\u0018\u0001`\n0\u0003Bl\u0012\u0006\u0010-\u001a\u00020\u0006\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040$\u0012\b\u0010>\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010<\u001a\u00020\u0015\u0012;\u00106\u001a7\u0012\u000b\u0012\t\u0018\u00010\u0006¢\u0006\u0002\b\u0007\u0012\u000b\u0012\t\u0018\u00010\b¢\u0006\u0002\b\u0007\u0012\u000b\u0012\t\u0018\u00010\u0004¢\u0006\u0002\b\u0007\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0004\u0018\u0001`\n¢\u0006\u0004\b?\u0010@J\u000f\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010!\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\bH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\tH\u0016¢\u0006\u0004\b#\u0010\fJZ\u0010'\u001a\u00020\t2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040$2;\u0010&\u001a7\u0012\u000b\u0012\t\u0018\u00010\u0006¢\u0006\u0002\b\u0007\u0012\u000b\u0012\t\u0018\u00010\b¢\u0006\u0002\b\u0007\u0012\u000b\u0012\t\u0018\u00010\u0004¢\u0006\u0002\b\u0007\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0004\u0018\u0001`\nH\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\tH\u0016¢\u0006\u0004\b)\u0010\fJ\u0017\u0010*\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b*\u0010\u0010J\u000f\u0010+\u001a\u00020\tH\u0016¢\u0006\u0004\b+\u0010\fJ\u0017\u0010,\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b,\u0010\u0010R\u0016\u0010-\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R(\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040$8\u0001@\u0001X\u0080\u000e¢\u0006\u0012\n\u0004\b%\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105RW\u00106\u001a7\u0012\u000b\u0012\t\u0018\u00010\u0006¢\u0006\u0002\b\u0007\u0012\u000b\u0012\t\u0018\u00010\b¢\u0006\u0002\b\u0007\u0012\u000b\u0012\t\u0018\u00010\u0004¢\u0006\u0002\b\u0007\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0004\u0018\u0001`\n8\u0001@\u0001X\u0081\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b<\u0010="}, d2 = {"Lcom/afollestad/materialdialogs/internal/list/PlainListDialogAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/afollestad/materialdialogs/internal/list/PlainListViewHolder;", "Lcom/afollestad/materialdialogs/internal/list/DialogAdapter;", "", "Lkotlin/Function3;", "Lcom/afollestad/materialdialogs/MaterialDialog;", "Lkotlin/ParameterName;", "", "", "Lcom/afollestad/materialdialogs/list/ItemListener;", "checkAllItems", "()V", "", "indices", "checkItems", "([I)V", "disableItems", "getItemCount", "()I", "index", "", "isItemChecked", "(I)Z", "itemClicked", "(I)V", "holder", "position", "onBindViewHolder", "(Lcom/afollestad/materialdialogs/internal/list/PlainListViewHolder;I)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/afollestad/materialdialogs/internal/list/PlainListViewHolder;", "positiveButtonClicked", "", FirebaseAnalytics.Param.ITEMS, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "replaceItems", "(Ljava/util/List;Lkotlin/jvm/functions/Function3;)V", "toggleAllChecked", "toggleItems", "uncheckAllItems", "uncheckItems", "dialog", "Lcom/afollestad/materialdialogs/MaterialDialog;", "disabledIndices", "[I", "Ljava/util/List;", "getItems$core", "()Ljava/util/List;", "setItems$core", "(Ljava/util/List;)V", "selection", "Lkotlin/jvm/functions/Function3;", "getSelection$core", "()Lkotlin/jvm/functions/Function3;", "setSelection$core", "(Lkotlin/jvm/functions/Function3;)V", "waitForPositiveButton", "Z", "disabledItems", "<init>", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/util/List;[IZLkotlin/jvm/functions/Function3;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class PlainListDialogAdapter extends RecyclerView.Adapter<PlainListViewHolder> implements DialogAdapter<CharSequence, Function3<? super MaterialDialog, ? super Integer, ? super CharSequence, ? extends Unit>> {
    private MaterialDialog dialog;
    private int[] disabledIndices;
    private List<? extends CharSequence> items;
    private Function3<? super MaterialDialog, ? super Integer, ? super CharSequence, Unit> selection;
    private boolean waitForPositiveButton;

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public final void checkAllItems() {
    }

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public final void checkItems(int[] indices) {
        Intrinsics.checkParameterIsNotNull(indices, "");
    }

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public final boolean isItemChecked(int index) {
        return false;
    }

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public final void toggleAllChecked() {
    }

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public final void toggleItems(int[] indices) {
        Intrinsics.checkParameterIsNotNull(indices, "");
    }

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public final void uncheckAllItems() {
    }

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public final void uncheckItems(int[] indices) {
        Intrinsics.checkParameterIsNotNull(indices, "");
    }

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public final /* bridge */ /* synthetic */ void replaceItems(List<? extends CharSequence> list, Function3<? super MaterialDialog, ? super Integer, ? super CharSequence, ? extends Unit> function3) {
        replaceItems2(list, (Function3<? super MaterialDialog, ? super Integer, ? super CharSequence, Unit>) function3);
    }

    @JvmName(name = "getItems$core")
    public final List<CharSequence> getItems$core() {
        return this.items;
    }

    @JvmName(name = "setItems$core")
    public final void setItems$core(List<? extends CharSequence> list) {
        Intrinsics.checkParameterIsNotNull(list, "");
        this.items = list;
    }

    @JvmName(name = "getSelection$core")
    public final Function3<MaterialDialog, Integer, CharSequence, Unit> getSelection$core() {
        return this.selection;
    }

    @JvmName(name = "setSelection$core")
    public final void setSelection$core(Function3<? super MaterialDialog, ? super Integer, ? super CharSequence, Unit> function3) {
        this.selection = function3;
    }

    public PlainListDialogAdapter(MaterialDialog materialDialog, List<? extends CharSequence> list, int[] iArr, boolean z, Function3<? super MaterialDialog, ? super Integer, ? super CharSequence, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        Intrinsics.checkParameterIsNotNull(list, "");
        this.dialog = materialDialog;
        this.items = list;
        this.waitForPositiveButton = z;
        this.selection = function3;
        this.disabledIndices = iArr == null ? new int[0] : iArr;
    }

    public final void itemClicked(int index) {
        if (this.waitForPositiveButton && DialogActionExtKt.hasActionButton(this.dialog, WhichButton.POSITIVE)) {
            Object obj = this.dialog.getConfig().get("activated_index");
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            this.dialog.getConfig().put("activated_index", Integer.valueOf(index));
            if (num != null) {
                notifyItemChanged(num.intValue());
            }
            notifyItemChanged(index);
            return;
        }
        Function3<? super MaterialDialog, ? super Integer, ? super CharSequence, Unit> function3 = this.selection;
        if (function3 != null) {
            function3.invoke(this.dialog, Integer.valueOf(index), this.items.get(index));
        }
        if (!this.dialog.getAutoDismissEnabled() || DialogActionExtKt.hasActionButtons(this.dialog)) {
            return;
        }
        this.dialog.dismiss();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final PlainListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkParameterIsNotNull(parent, "");
        PlainListViewHolder plainListViewHolder = new PlainListViewHolder(MDUtil.INSTANCE.inflate(parent, this.dialog.getWindowContext(), R.layout.md_listitem), this);
        MDUtil.maybeSetTextColor$default(MDUtil.INSTANCE, plainListViewHolder.getTitleView(), this.dialog.getWindowContext(), Integer.valueOf(R.attr.md_color_content), null, 4, null);
        return plainListViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getGetAuthRequestContext() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(PlainListViewHolder holder, int position) {
        Intrinsics.checkParameterIsNotNull(holder, "");
        View view = holder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "");
        view.setEnabled(!ArraysKt.contains(this.disabledIndices, position));
        holder.getTitleView().setText(this.items.get(position));
        View view2 = holder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view2, "");
        view2.setBackground(DialogListExtKt.getItemSelector(this.dialog));
        Object obj = this.dialog.getConfig().get("activated_index");
        if (!(obj instanceof Integer)) {
            obj = null;
        }
        Integer num = (Integer) obj;
        View view3 = holder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view3, "");
        view3.setActivated(num != null && num.intValue() == position);
        if (this.dialog.getBodyFont() != null) {
            holder.getTitleView().setTypeface(this.dialog.getBodyFont());
        }
    }

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public final void positiveButtonClicked() {
        Object obj = this.dialog.getConfig().get("activated_index");
        if (!(obj instanceof Integer)) {
            obj = null;
        }
        Integer num = (Integer) obj;
        if (num != null) {
            Function3<? super MaterialDialog, ? super Integer, ? super CharSequence, Unit> function3 = this.selection;
            if (function3 != null) {
                function3.invoke(this.dialog, num, this.items.get(num.intValue()));
            }
            this.dialog.getConfig().remove("activated_index");
        }
    }

    /* renamed from: replaceItems  reason: avoid collision after fix types in other method */
    public final void replaceItems2(List<? extends CharSequence> items, Function3<? super MaterialDialog, ? super Integer, ? super CharSequence, Unit> listener) {
        Intrinsics.checkParameterIsNotNull(items, "");
        this.items = items;
        if (listener != null) {
            this.selection = listener;
        }
        notifyDataSetChanged();
    }

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public final void disableItems(int[] indices) {
        Intrinsics.checkParameterIsNotNull(indices, "");
        this.disabledIndices = indices;
        notifyDataSetChanged();
    }
}
