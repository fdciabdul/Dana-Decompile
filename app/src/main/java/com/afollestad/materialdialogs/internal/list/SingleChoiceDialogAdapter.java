package com.afollestad.materialdialogs.internal.list;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.CompoundButtonCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.WhichButton;
import com.afollestad.materialdialogs.actions.DialogActionExtKt;
import com.afollestad.materialdialogs.list.DialogListExtKt;
import com.afollestad.materialdialogs.utils.ColorsKt;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b#\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012C\u0012\u0004\u0012\u00020\u0004\u00129\u00127\u0012\u000b\u0012\t\u0018\u00010\u0006¢\u0006\u0002\b\u0007\u0012\u000b\u0012\t\u0018\u00010\b¢\u0006\u0002\b\u0007\u0012\u000b\u0012\t\u0018\u00010\u0004¢\u0006\u0002\b\u0007\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0004\u0018\u0001`\n0\u0003B\u0084\u0001\u0012\u0006\u00106\u001a\u00020\u0006\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040(\u0012\b\u0010H\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010I\u001a\u00020\b\u0012\u0006\u0010F\u001a\u00020\u0015\u0012;\u0010?\u001a7\u0012\u000b\u0012\t\u0018\u00010\u0006¢\u0006\u0002\b\u0007\u0012\u000b\u0012\t\u0018\u00010\b¢\u0006\u0002\b\u0007\u0012\u000b\u0012\t\u0018\u00010\u0004¢\u0006\u0002\b\u0007\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0004\u0018\u0001`\n\u0012\u0006\u00101\u001a\u00020\b\u0012\u0006\u0010E\u001a\u00020\b¢\u0006\u0004\bJ\u0010KJ\u000f\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ-\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016¢\u0006\u0004\b\u001c\u0010!J\u001f\u0010%\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\bH\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\tH\u0016¢\u0006\u0004\b'\u0010\fJZ\u0010+\u001a\u00020\t2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040(2;\u0010*\u001a7\u0012\u000b\u0012\t\u0018\u00010\u0006¢\u0006\u0002\b\u0007\u0012\u000b\u0012\t\u0018\u00010\b¢\u0006\u0002\b\u0007\u0012\u000b\u0012\t\u0018\u00010\u0004¢\u0006\u0002\b\u0007\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0004\u0018\u0001`\nH\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\tH\u0016¢\u0006\u0004\b-\u0010\fJ\u0017\u0010.\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b.\u0010\u0010J\u000f\u0010/\u001a\u00020\tH\u0016¢\u0006\u0004\b/\u0010\fJ\u0017\u00100\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b0\u0010\u0010R\u0014\u00101\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R$\u00104\u001a\u00020\b2\u0006\u00103\u001a\u00020\b8\u0002@CX\u0082\u000e¢\u0006\f\n\u0004\b4\u00102\"\u0004\b5\u0010\u0019R\u0016\u00106\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b8\u00109R(\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040(8\u0001@\u0001X\u0081\u000e¢\u0006\u0012\n\u0004\b)\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>RW\u0010?\u001a7\u0012\u000b\u0012\t\u0018\u00010\u0006¢\u0006\u0002\b\u0007\u0012\u000b\u0012\t\u0018\u00010\b¢\u0006\u0002\b\u0007\u0012\u000b\u0012\t\u0018\u00010\u0004¢\u0006\u0002\b\u0007\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0004\u0018\u0001`\n8\u0001@\u0001X\u0081\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0014\u0010E\u001a\u00020\b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bE\u00102R\u0014\u0010F\u001a\u00020\u00158\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bF\u0010G"}, d2 = {"Lcom/afollestad/materialdialogs/internal/list/SingleChoiceDialogAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/afollestad/materialdialogs/internal/list/SingleChoiceViewHolder;", "Lcom/afollestad/materialdialogs/internal/list/DialogAdapter;", "", "Lkotlin/Function3;", "Lcom/afollestad/materialdialogs/MaterialDialog;", "Lkotlin/ParameterName;", "", "", "Lcom/afollestad/materialdialogs/list/SingleChoiceListener;", "checkAllItems", "()V", "", "indices", "checkItems", "([I)V", "disableItems", "getItemCount", "()I", "index", "", "isItemChecked", "(I)Z", "itemClicked$core", "(I)V", "holder", "position", "onBindViewHolder", "(Lcom/afollestad/materialdialogs/internal/list/SingleChoiceViewHolder;I)V", "", "", "payloads", "(Lcom/afollestad/materialdialogs/internal/list/SingleChoiceViewHolder;ILjava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/afollestad/materialdialogs/internal/list/SingleChoiceViewHolder;", "positiveButtonClicked", "", FirebaseAnalytics.Param.ITEMS, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "replaceItems", "(Ljava/util/List;Lkotlin/jvm/functions/Function3;)V", "toggleAllChecked", "toggleItems", "uncheckAllItems", "uncheckItems", "checkedColor", "I", "value", "currentSelection", "setCurrentSelection", "dialog", "Lcom/afollestad/materialdialogs/MaterialDialog;", "disabledIndices", "[I", "Ljava/util/List;", "getItems$core", "()Ljava/util/List;", "setItems$core", "(Ljava/util/List;)V", "selection", "Lkotlin/jvm/functions/Function3;", "getSelection$core", "()Lkotlin/jvm/functions/Function3;", "setSelection$core", "(Lkotlin/jvm/functions/Function3;)V", "uncheckedColor", "waitForActionButton", "Z", "disabledItems", "initialSelection", "<init>", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/util/List;[IIZLkotlin/jvm/functions/Function3;II)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class SingleChoiceDialogAdapter extends RecyclerView.Adapter<SingleChoiceViewHolder> implements DialogAdapter<CharSequence, Function3<? super MaterialDialog, ? super Integer, ? super CharSequence, ? extends Unit>> {
    private final int checkedColor;
    private int currentSelection;
    private MaterialDialog dialog;
    private int[] disabledIndices;
    private List<? extends CharSequence> items;
    private Function3<? super MaterialDialog, ? super Integer, ? super CharSequence, Unit> selection;
    private final int uncheckedColor;
    private final boolean waitForActionButton;

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public final void checkAllItems() {
    }

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public final void toggleAllChecked() {
    }

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public final void uncheckAllItems() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(SingleChoiceViewHolder singleChoiceViewHolder, int i, List list) {
        onBindViewHolder2(singleChoiceViewHolder, i, (List<Object>) list);
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

    public SingleChoiceDialogAdapter(MaterialDialog materialDialog, List<? extends CharSequence> list, int[] iArr, int i, boolean z, Function3<? super MaterialDialog, ? super Integer, ? super CharSequence, Unit> function3, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        Intrinsics.checkParameterIsNotNull(list, "");
        this.dialog = materialDialog;
        this.items = list;
        this.waitForActionButton = z;
        this.selection = function3;
        this.checkedColor = i2;
        this.uncheckedColor = i3;
        this.currentSelection = i;
        this.disabledIndices = iArr == null ? new int[0] : iArr;
    }

    @JvmName(name = "setCurrentSelection")
    private final void setCurrentSelection(int i) {
        int i2 = this.currentSelection;
        if (i == i2) {
            return;
        }
        this.currentSelection = i;
        notifyItemChanged(i2, UncheckPayload.INSTANCE);
        notifyItemChanged(i, CheckPayload.INSTANCE);
    }

    public final void itemClicked$core(int index) {
        setCurrentSelection(index);
        if (this.waitForActionButton && DialogActionExtKt.hasActionButtons(this.dialog)) {
            DialogActionExtKt.setActionButtonEnabled(this.dialog, WhichButton.POSITIVE, true);
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
    public final SingleChoiceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkParameterIsNotNull(parent, "");
        SingleChoiceViewHolder singleChoiceViewHolder = new SingleChoiceViewHolder(MDUtil.INSTANCE.inflate(parent, this.dialog.getWindowContext(), R.layout.md_listitem_singlechoice), this);
        MDUtil.maybeSetTextColor$default(MDUtil.INSTANCE, singleChoiceViewHolder.getTitleView(), this.dialog.getWindowContext(), Integer.valueOf(R.attr.md_color_content), null, 4, null);
        int[] resolveColors$default = ColorsKt.resolveColors$default(this.dialog, new int[]{R.attr.md_color_widget, R.attr.md_color_widget_unchecked}, null, 2, null);
        AppCompatRadioButton controlView = singleChoiceViewHolder.getControlView();
        MDUtil mDUtil = MDUtil.INSTANCE;
        Context windowContext = this.dialog.getWindowContext();
        int i = this.checkedColor;
        if (i == -1) {
            i = resolveColors$default[0];
        }
        int i2 = this.uncheckedColor;
        if (i2 == -1) {
            i2 = resolveColors$default[1];
        }
        CompoundButtonCompat.KClassImpl$Data$declaredNonStaticMembers$2(controlView, mDUtil.createColorSelector(windowContext, i2, i));
        return singleChoiceViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(SingleChoiceViewHolder holder, int position) {
        Intrinsics.checkParameterIsNotNull(holder, "");
        holder.setEnabled(!ArraysKt.contains(this.disabledIndices, position));
        holder.getControlView().setChecked(this.currentSelection == position);
        holder.getTitleView().setText(this.items.get(position));
        View view = holder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "");
        view.setBackground(DialogListExtKt.getItemSelector(this.dialog));
        if (this.dialog.getBodyFont() != null) {
            holder.getTitleView().setTypeface(this.dialog.getBodyFont());
        }
    }

    /* renamed from: onBindViewHolder  reason: avoid collision after fix types in other method */
    public final void onBindViewHolder2(SingleChoiceViewHolder holder, int position, List<Object> payloads) {
        Intrinsics.checkParameterIsNotNull(holder, "");
        Intrinsics.checkParameterIsNotNull(payloads, "");
        Object firstOrNull = CollectionsKt.firstOrNull((List<? extends Object>) payloads);
        if (Intrinsics.areEqual(firstOrNull, CheckPayload.INSTANCE)) {
            holder.getControlView().setChecked(true);
        } else if (Intrinsics.areEqual(firstOrNull, UncheckPayload.INSTANCE)) {
            holder.getControlView().setChecked(false);
        } else {
            super.onBindViewHolder((SingleChoiceDialogAdapter) holder, position, payloads);
        }
    }

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public final void positiveButtonClicked() {
        Function3<? super MaterialDialog, ? super Integer, ? super CharSequence, Unit> function3;
        int i = this.currentSelection;
        if (i < 0 || (function3 = this.selection) == null) {
            return;
        }
        function3.invoke(this.dialog, Integer.valueOf(i), this.items.get(this.currentSelection));
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

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public final void checkItems(int[] indices) {
        Intrinsics.checkParameterIsNotNull(indices, "");
        boolean z = false;
        int i = (indices.length == 0) ^ true ? indices[0] : -1;
        if (i >= 0 && i < this.items.size()) {
            z = true;
        }
        if (!z) {
            StringBuilder sb = new StringBuilder();
            sb.append("Index ");
            sb.append(i);
            sb.append(" is out of range for this adapter of ");
            sb.append(this.items.size());
            sb.append(" items.");
            throw new IllegalStateException(sb.toString().toString());
        } else if (ArraysKt.contains(this.disabledIndices, i)) {
        } else {
            setCurrentSelection(i);
        }
    }

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public final void uncheckItems(int[] indices) {
        Intrinsics.checkParameterIsNotNull(indices, "");
        boolean z = false;
        int i = (indices.length == 0) ^ true ? indices[0] : -1;
        if (i >= 0 && i < this.items.size()) {
            z = true;
        }
        if (!z) {
            StringBuilder sb = new StringBuilder();
            sb.append("Index ");
            sb.append(i);
            sb.append(" is out of range for this adapter of ");
            sb.append(this.items.size());
            sb.append(" items.");
            throw new IllegalStateException(sb.toString().toString());
        } else if (ArraysKt.contains(this.disabledIndices, i)) {
        } else {
            setCurrentSelection(-1);
        }
    }

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public final void toggleItems(int[] indices) {
        Intrinsics.checkParameterIsNotNull(indices, "");
        int i = (indices.length == 0) ^ true ? indices[0] : -1;
        if (ArraysKt.contains(this.disabledIndices, i)) {
            return;
        }
        if ((indices.length == 0) || this.currentSelection == i) {
            setCurrentSelection(-1);
        } else {
            setCurrentSelection(i);
        }
    }

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public final boolean isItemChecked(int index) {
        return this.currentSelection == index;
    }
}
