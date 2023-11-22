package com.afollestad.materialdialogs.internal.list;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.CompoundButtonCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.WhichButton;
import com.afollestad.materialdialogs.actions.DialogActionExtKt;
import com.afollestad.materialdialogs.list.DialogListExtKt;
import com.afollestad.materialdialogs.utils.ColorsKt;
import com.afollestad.materialdialogs.utils.IntArraysKt;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b&\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012I\u0012\u0004\u0012\u00020\u0004\u0012?\u0012=\u0012\u000b\u0012\t\u0018\u00010\u0006¢\u0006\u0002\b\u0007\u0012\u000b\u0012\t\u0018\u00010\b¢\u0006\u0002\b\u0007\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t¢\u0006\u0002\b\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000b0\u0003B\u0082\u0001\u0012\u0006\u00107\u001a\u00020\u0006\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040\t\u0012\b\u0010F\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010G\u001a\u00020\b\u0012\u0006\u0010E\u001a\u00020\u0016\u0012\u0006\u00101\u001a\u00020\u0016\u0012A\u0010?\u001a=\u0012\u000b\u0012\t\u0018\u00010\u0006¢\u0006\u0002\b\u0007\u0012\u000b\u0012\t\u0018\u00010\b¢\u0006\u0002\b\u0007\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t¢\u0006\u0002\b\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000b¢\u0006\u0004\bH\u0010IJ\u000f\u0010\f\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ-\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00122\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016¢\u0006\u0004\b\u001d\u0010\"J\u001f\u0010&\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0012H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\nH\u0016¢\u0006\u0004\b(\u0010\rJ`\u0010+\u001a\u00020\n2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040\t2A\u0010*\u001a=\u0012\u000b\u0012\t\u0018\u00010\u0006¢\u0006\u0002\b\u0007\u0012\u000b\u0012\t\u0018\u00010\b¢\u0006\u0002\b\u0007\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t¢\u0006\u0002\b\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bH\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\nH\u0016¢\u0006\u0004\b-\u0010\rJ\u0017\u0010.\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b.\u0010\u0010J\u000f\u0010/\u001a\u00020\nH\u0016¢\u0006\u0004\b/\u0010\rJ\u0017\u00100\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b0\u0010\u0010R\u0014\u00101\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R$\u00104\u001a\u00020\b2\u0006\u00103\u001a\u00020\b8\u0002@CX\u0082\u000e¢\u0006\f\n\u0004\b4\u00105\"\u0004\b6\u0010\u0010R\u0016\u00107\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b9\u00105R(\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0001@\u0001X\u0081\u000e¢\u0006\u0012\n\u0004\b)\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R]\u0010?\u001a=\u0012\u000b\u0012\t\u0018\u00010\u0006¢\u0006\u0002\b\u0007\u0012\u000b\u0012\t\u0018\u00010\b¢\u0006\u0002\b\u0007\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t¢\u0006\u0002\b\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000b8\u0001@\u0001X\u0081\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0014\u0010E\u001a\u00020\u00168\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bE\u00102"}, d2 = {"Lcom/afollestad/materialdialogs/internal/list/MultiChoiceDialogAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/afollestad/materialdialogs/internal/list/MultiChoiceViewHolder;", "Lcom/afollestad/materialdialogs/internal/list/DialogAdapter;", "", "Lkotlin/Function3;", "Lcom/afollestad/materialdialogs/MaterialDialog;", "Lkotlin/ParameterName;", "", "", "", "Lcom/afollestad/materialdialogs/list/MultiChoiceListener;", "checkAllItems", "()V", "indices", "checkItems", "([I)V", "disableItems", "", "getItemCount", "()I", "index", "", "isItemChecked", "(I)Z", "itemClicked$core", "(I)V", "holder", "position", "onBindViewHolder", "(Lcom/afollestad/materialdialogs/internal/list/MultiChoiceViewHolder;I)V", "", "", "payloads", "(Lcom/afollestad/materialdialogs/internal/list/MultiChoiceViewHolder;ILjava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/afollestad/materialdialogs/internal/list/MultiChoiceViewHolder;", "positiveButtonClicked", FirebaseAnalytics.Param.ITEMS, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "replaceItems", "(Ljava/util/List;Lkotlin/jvm/functions/Function3;)V", "toggleAllChecked", "toggleItems", "uncheckAllItems", "uncheckItems", "allowEmptySelection", "Z", "value", "currentSelection", "[I", "setCurrentSelection", "dialog", "Lcom/afollestad/materialdialogs/MaterialDialog;", "disabledIndices", "Ljava/util/List;", "getItems$core", "()Ljava/util/List;", "setItems$core", "(Ljava/util/List;)V", "selection", "Lkotlin/jvm/functions/Function3;", "getSelection$core", "()Lkotlin/jvm/functions/Function3;", "setSelection$core", "(Lkotlin/jvm/functions/Function3;)V", "waitForActionButton", "disabledItems", "initialSelection", "<init>", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/util/List;[I[IZZLkotlin/jvm/functions/Function3;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class MultiChoiceDialogAdapter extends RecyclerView.Adapter<MultiChoiceViewHolder> implements DialogAdapter<CharSequence, Function3<? super MaterialDialog, ? super int[], ? super List<? extends CharSequence>, ? extends Unit>> {
    private final boolean allowEmptySelection;
    private int[] currentSelection;
    private MaterialDialog dialog;
    private int[] disabledIndices;
    private List<? extends CharSequence> items;
    private Function3<? super MaterialDialog, ? super int[], ? super List<? extends CharSequence>, Unit> selection;
    private final boolean waitForActionButton;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(MultiChoiceViewHolder multiChoiceViewHolder, int i, List list) {
        onBindViewHolder2(multiChoiceViewHolder, i, (List<Object>) list);
    }

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public final /* bridge */ /* synthetic */ void replaceItems(List<? extends CharSequence> list, Function3<? super MaterialDialog, ? super int[], ? super List<? extends CharSequence>, ? extends Unit> function3) {
        replaceItems2(list, (Function3<? super MaterialDialog, ? super int[], ? super List<? extends CharSequence>, Unit>) function3);
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
    public final Function3<MaterialDialog, int[], List<? extends CharSequence>, Unit> getSelection$core() {
        return this.selection;
    }

    @JvmName(name = "setSelection$core")
    public final void setSelection$core(Function3<? super MaterialDialog, ? super int[], ? super List<? extends CharSequence>, Unit> function3) {
        this.selection = function3;
    }

    public MultiChoiceDialogAdapter(MaterialDialog materialDialog, List<? extends CharSequence> list, int[] iArr, int[] iArr2, boolean z, boolean z2, Function3<? super MaterialDialog, ? super int[], ? super List<? extends CharSequence>, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        Intrinsics.checkParameterIsNotNull(list, "");
        Intrinsics.checkParameterIsNotNull(iArr2, "");
        this.dialog = materialDialog;
        this.items = list;
        this.waitForActionButton = z;
        this.allowEmptySelection = z2;
        this.selection = function3;
        this.currentSelection = iArr2;
        this.disabledIndices = iArr == null ? new int[0] : iArr;
    }

    @JvmName(name = "setCurrentSelection")
    private final void setCurrentSelection(int[] iArr) {
        int[] iArr2 = this.currentSelection;
        this.currentSelection = iArr;
        for (int i : iArr2) {
            if (!ArraysKt.contains(iArr, i)) {
                notifyItemChanged(i, UncheckPayload.INSTANCE);
            }
        }
        for (int i2 : iArr) {
            if (!ArraysKt.contains(iArr2, i2)) {
                notifyItemChanged(i2, CheckPayload.INSTANCE);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0047, code lost:
    
        if ((!(r5.currentSelection.length == 0)) != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void itemClicked$core(int r6) {
        /*
            r5 = this;
            int[] r0 = r5.currentSelection
            java.util.List r0 = kotlin.collections.ArraysKt.toMutableList(r0)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
            boolean r1 = r0.contains(r1)
            if (r1 == 0) goto L18
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r0.remove(r6)
            goto L1f
        L18:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r0.add(r6)
        L1f:
            java.util.Collection r0 = (java.util.Collection) r0
            int[] r6 = kotlin.collections.CollectionsKt.toIntArray(r0)
            r5.setCurrentSelection(r6)
            boolean r6 = r5.waitForActionButton
            r0 = 0
            if (r6 == 0) goto L4e
            com.afollestad.materialdialogs.MaterialDialog r6 = r5.dialog
            boolean r6 = com.afollestad.materialdialogs.actions.DialogActionExtKt.hasActionButtons(r6)
            if (r6 == 0) goto L4e
            com.afollestad.materialdialogs.MaterialDialog r6 = r5.dialog
            com.afollestad.materialdialogs.WhichButton r1 = com.afollestad.materialdialogs.WhichButton.POSITIVE
            boolean r2 = r5.allowEmptySelection
            r3 = 1
            if (r2 != 0) goto L49
            int[] r2 = r5.currentSelection
            int r2 = r2.length
            if (r2 != 0) goto L45
            r2 = 1
            goto L46
        L45:
            r2 = 0
        L46:
            r2 = r2 ^ r3
            if (r2 == 0) goto L4a
        L49:
            r0 = 1
        L4a:
            com.afollestad.materialdialogs.actions.DialogActionExtKt.setActionButtonEnabled(r6, r1, r0)
            return
        L4e:
            java.util.List<? extends java.lang.CharSequence> r6 = r5.items
            int[] r1 = r5.currentSelection
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.List r2 = (java.util.List) r2
            int r3 = r1.length
        L5a:
            if (r0 >= r3) goto L68
            r4 = r1[r0]
            java.lang.Object r4 = r6.get(r4)
            r2.add(r4)
            int r0 = r0 + 1
            goto L5a
        L68:
            kotlin.jvm.functions.Function3<? super com.afollestad.materialdialogs.MaterialDialog, ? super int[], ? super java.util.List<? extends java.lang.CharSequence>, kotlin.Unit> r6 = r5.selection
            if (r6 == 0) goto L76
            com.afollestad.materialdialogs.MaterialDialog r0 = r5.dialog
            int[] r1 = r5.currentSelection
            java.lang.Object r6 = r6.invoke(r0, r1, r2)
            kotlin.Unit r6 = (kotlin.Unit) r6
        L76:
            com.afollestad.materialdialogs.MaterialDialog r6 = r5.dialog
            boolean r6 = r6.getAutoDismissEnabled()
            if (r6 == 0) goto L8b
            com.afollestad.materialdialogs.MaterialDialog r6 = r5.dialog
            boolean r6 = com.afollestad.materialdialogs.actions.DialogActionExtKt.hasActionButtons(r6)
            if (r6 != 0) goto L8b
            com.afollestad.materialdialogs.MaterialDialog r6 = r5.dialog
            r6.dismiss()
        L8b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.internal.list.MultiChoiceDialogAdapter.itemClicked$core(int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final MultiChoiceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkParameterIsNotNull(parent, "");
        MultiChoiceViewHolder multiChoiceViewHolder = new MultiChoiceViewHolder(MDUtil.INSTANCE.inflate(parent, this.dialog.getWindowContext(), R.layout.md_listitem_multichoice), this);
        MDUtil.maybeSetTextColor$default(MDUtil.INSTANCE, multiChoiceViewHolder.getTitleView(), this.dialog.getWindowContext(), Integer.valueOf(R.attr.md_color_content), null, 4, null);
        int[] resolveColors$default = ColorsKt.resolveColors$default(this.dialog, new int[]{R.attr.md_color_widget, R.attr.md_color_widget_unchecked}, null, 2, null);
        CompoundButtonCompat.KClassImpl$Data$declaredNonStaticMembers$2(multiChoiceViewHolder.getControlView(), MDUtil.INSTANCE.createColorSelector(this.dialog.getWindowContext(), resolveColors$default[1], resolveColors$default[0]));
        return multiChoiceViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(MultiChoiceViewHolder holder, int position) {
        Intrinsics.checkParameterIsNotNull(holder, "");
        holder.setEnabled(!ArraysKt.contains(this.disabledIndices, position));
        holder.getControlView().setChecked(ArraysKt.contains(this.currentSelection, position));
        holder.getTitleView().setText(this.items.get(position));
        View view = holder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "");
        view.setBackground(DialogListExtKt.getItemSelector(this.dialog));
        if (this.dialog.getBodyFont() != null) {
            holder.getTitleView().setTypeface(this.dialog.getBodyFont());
        }
    }

    /* renamed from: onBindViewHolder  reason: avoid collision after fix types in other method */
    public final void onBindViewHolder2(MultiChoiceViewHolder holder, int position, List<Object> payloads) {
        Intrinsics.checkParameterIsNotNull(holder, "");
        Intrinsics.checkParameterIsNotNull(payloads, "");
        Object firstOrNull = CollectionsKt.firstOrNull((List<? extends Object>) payloads);
        if (Intrinsics.areEqual(firstOrNull, CheckPayload.INSTANCE)) {
            holder.getControlView().setChecked(true);
        } else if (Intrinsics.areEqual(firstOrNull, UncheckPayload.INSTANCE)) {
            holder.getControlView().setChecked(false);
        } else {
            MultiChoiceViewHolder multiChoiceViewHolder = holder;
            super.onBindViewHolder((MultiChoiceDialogAdapter) multiChoiceViewHolder, position, payloads);
            super.onBindViewHolder((MultiChoiceDialogAdapter) multiChoiceViewHolder, position, payloads);
        }
    }

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public final void positiveButtonClicked() {
        if (!this.allowEmptySelection) {
            if ((!(this.currentSelection.length == 0)) == false) {
                return;
            }
        }
        List<? extends CharSequence> list = this.items;
        int[] iArr = this.currentSelection;
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            arrayList.add(list.get(i));
        }
        Function3<? super MaterialDialog, ? super int[], ? super List<? extends CharSequence>, Unit> function3 = this.selection;
        if (function3 != null) {
            function3.invoke(this.dialog, this.currentSelection, arrayList);
        }
    }

    /* renamed from: replaceItems  reason: avoid collision after fix types in other method */
    public final void replaceItems2(List<? extends CharSequence> items, Function3<? super MaterialDialog, ? super int[], ? super List<? extends CharSequence>, Unit> listener) {
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
        int[] iArr = this.currentSelection;
        ArrayList arrayList = new ArrayList();
        int length = indices.length;
        for (int i = 0; i < length; i++) {
            int i2 = indices[i];
            if (!(i2 >= 0 && i2 < this.items.size())) {
                StringBuilder sb = new StringBuilder();
                sb.append("Index ");
                sb.append(i2);
                sb.append(" is out of range for this adapter of ");
                sb.append(this.items.size());
                sb.append(" items.");
                throw new IllegalStateException(sb.toString().toString());
            }
            if (true ^ ArraysKt.contains(iArr, i2)) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        setCurrentSelection(IntArraysKt.appendAll(this.currentSelection, arrayList));
        if (iArr.length == 0) {
            DialogActionExtKt.setActionButtonEnabled(this.dialog, WhichButton.POSITIVE, true);
        }
    }

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public final void uncheckItems(int[] indices) {
        Intrinsics.checkParameterIsNotNull(indices, "");
        int[] iArr = this.currentSelection;
        ArrayList arrayList = new ArrayList();
        int length = indices.length;
        int i = 0;
        while (true) {
            if (i < length) {
                int i2 = indices[i];
                if (!(i2 >= 0 && i2 < this.items.size())) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Index ");
                    sb.append(i2);
                    sb.append(" is out of range for this adapter of ");
                    sb.append(this.items.size());
                    sb.append(" items.");
                    throw new IllegalStateException(sb.toString().toString());
                }
                if (ArraysKt.contains(iArr, i2)) {
                    arrayList.add(Integer.valueOf(i2));
                }
                i++;
            } else {
                int[] removeAll = IntArraysKt.removeAll(this.currentSelection, arrayList);
                if (removeAll.length == 0) {
                    DialogActionExtKt.setActionButtonEnabled(this.dialog, WhichButton.POSITIVE, this.allowEmptySelection);
                }
                setCurrentSelection(removeAll);
                return;
            }
        }
    }

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public final void toggleItems(int[] indices) {
        Intrinsics.checkParameterIsNotNull(indices, "");
        List<Integer> mutableList = ArraysKt.toMutableList(this.currentSelection);
        for (int i : indices) {
            if (!ArraysKt.contains(this.disabledIndices, i)) {
                if (mutableList.contains(Integer.valueOf(i))) {
                    mutableList.remove(Integer.valueOf(i));
                } else {
                    mutableList.add(Integer.valueOf(i));
                }
            }
        }
        int[] intArray = CollectionsKt.toIntArray(mutableList);
        DialogActionExtKt.setActionButtonEnabled(this.dialog, WhichButton.POSITIVE, intArray.length == 0 ? this.allowEmptySelection : true);
        setCurrentSelection(intArray);
    }

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public final void checkAllItems() {
        int[] iArr = this.currentSelection;
        int placeComponentResult = getPlaceComponentResult();
        int[] iArr2 = new int[placeComponentResult];
        for (int i = 0; i < placeComponentResult; i++) {
            iArr2[i] = i;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < placeComponentResult; i2++) {
            int i3 = iArr2[i2];
            if (true ^ ArraysKt.contains(iArr, i3)) {
                arrayList.add(Integer.valueOf(i3));
            }
        }
        setCurrentSelection(IntArraysKt.appendAll(this.currentSelection, arrayList));
        if (iArr.length == 0) {
            DialogActionExtKt.setActionButtonEnabled(this.dialog, WhichButton.POSITIVE, true);
        }
    }

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public final void uncheckAllItems() {
        setCurrentSelection(new int[0]);
        DialogActionExtKt.setActionButtonEnabled(this.dialog, WhichButton.POSITIVE, this.allowEmptySelection);
    }

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public final void toggleAllChecked() {
        if (this.currentSelection.length == 0) {
            checkAllItems();
        } else {
            uncheckAllItems();
        }
    }

    @Override // com.afollestad.materialdialogs.internal.list.DialogAdapter
    public final boolean isItemChecked(int index) {
        return ArraysKt.contains(this.currentSelection, index);
    }
}
