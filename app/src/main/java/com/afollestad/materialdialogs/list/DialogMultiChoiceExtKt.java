package com.afollestad.materialdialogs.list;

import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.internal.list.DialogAdapter;
import com.afollestad.materialdialogs.internal.list.MultiChoiceDialogAdapter;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0006\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u009e\u0001\u0010\u0016\u001a\u00020\u0000*\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2C\b\u0002\u0010\u0015\u001a=\u0012\u000b\u0012\t\u0018\u00010\u0000¢\u0006\u0002\b\u0013\u0012\u000b\u0012\t\u0018\u00010\u0004¢\u0006\u0002\b\u0013\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\b\u0013\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012j\u0004\u0018\u0001`\u0014¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0011\u0010\u0018\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u0003\u001a\u0019\u0010\u0019\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u0007\u001a\u0011\u0010\u001a\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u001a\u0010\u0003\u001a\u0019\u0010\u001b\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u0007\u001a\u0080\u0001\u0010\u001c\u001a\u00020\u0000*\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042C\b\u0002\u0010\u0015\u001a=\u0012\u000b\u0012\t\u0018\u00010\u0000¢\u0006\u0002\b\u0013\u0012\u000b\u0012\t\u0018\u00010\u0004¢\u0006\u0002\b\u0013\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\b\u0013\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012j\u0004\u0018\u0001`\u0014¢\u0006\u0004\b\u001c\u0010\u001d"}, d2 = {"Lcom/afollestad/materialdialogs/MaterialDialog;", "", "checkAllItems", "(Lcom/afollestad/materialdialogs/MaterialDialog;)V", "", "indices", "checkItems", "(Lcom/afollestad/materialdialogs/MaterialDialog;[I)V", "", "res", "", "", FirebaseAnalytics.Param.ITEMS, "disabledIndices", "initialSelection", "", "waitForPositiveButton", "allowEmptySelection", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "Lcom/afollestad/materialdialogs/list/MultiChoiceListener;", "selection", "listItemsMultiChoice", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/lang/Integer;Ljava/util/List;[I[IZZLkotlin/jvm/functions/Function3;)Lcom/afollestad/materialdialogs/MaterialDialog;", "toggleAllItemsChecked", "toggleItemsChecked", "uncheckAllItems", "uncheckItems", "updateListItemsMultiChoice", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/lang/Integer;Ljava/util/List;[ILkotlin/jvm/functions/Function3;)Lcom/afollestad/materialdialogs/MaterialDialog;"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class DialogMultiChoiceExtKt {
    public static /* synthetic */ MaterialDialog listItemsMultiChoice$default(MaterialDialog materialDialog, Integer num, List list, int[] iArr, int[] iArr2, boolean z, boolean z2, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            list = null;
        }
        if ((i & 4) != 0) {
            iArr = null;
        }
        if ((i & 8) != 0) {
            iArr2 = new int[0];
        }
        if ((i & 16) != 0) {
            z = true;
        }
        if ((i & 32) != 0) {
            z2 = false;
        }
        if ((i & 64) != 0) {
            function3 = null;
        }
        return listItemsMultiChoice(materialDialog, num, list, iArr, iArr2, z, z2, function3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004a, code lost:
    
        if ((!(r14.length == 0)) != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final com.afollestad.materialdialogs.MaterialDialog listItemsMultiChoice(com.afollestad.materialdialogs.MaterialDialog r10, java.lang.Integer r11, java.util.List<? extends java.lang.CharSequence> r12, int[] r13, int[] r14, boolean r15, boolean r16, kotlin.jvm.functions.Function3<? super com.afollestad.materialdialogs.MaterialDialog, ? super int[], ? super java.util.List<? extends java.lang.CharSequence>, kotlin.Unit> r17) {
        /*
            r8 = r10
            r0 = r11
            r1 = r12
            r4 = r14
            java.lang.String r2 = ""
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r10, r2)
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r14, r2)
            com.afollestad.materialdialogs.utils.MDUtil r2 = com.afollestad.materialdialogs.utils.MDUtil.INSTANCE
            java.lang.String r3 = "listItemsMultiChoice"
            r2.assertOneSet(r3, r12, r11)
            if (r1 == 0) goto L17
            r2 = r1
            goto L25
        L17:
            com.afollestad.materialdialogs.utils.MDUtil r2 = com.afollestad.materialdialogs.utils.MDUtil.INSTANCE
            android.content.Context r3 = r10.getWindowContext()
            java.lang.String[] r2 = r2.getStringArray(r3, r11)
            java.util.List r2 = kotlin.collections.ArraysKt.toList(r2)
        L25:
            androidx.recyclerview.widget.RecyclerView$Adapter r3 = com.afollestad.materialdialogs.list.DialogListExtKt.getListAdapter(r10)
            if (r3 == 0) goto L3a
            java.lang.String r2 = "MaterialDialogs"
            java.lang.String r3 = "Prefer calling updateListItemsMultiChoice(...) over listItemsMultiChoice(...) again."
            com.fullstory.instrumentation.InstrumentInjector.log_w(r2, r3)
            r3 = r13
            r7 = r17
            com.afollestad.materialdialogs.MaterialDialog r0 = updateListItemsMultiChoice(r10, r11, r12, r13, r7)
            return r0
        L3a:
            r3 = r13
            r7 = r17
            com.afollestad.materialdialogs.WhichButton r0 = com.afollestad.materialdialogs.WhichButton.POSITIVE
            r1 = 0
            r5 = 1
            if (r16 != 0) goto L4c
            int r6 = r4.length
            if (r6 != 0) goto L48
            r6 = 1
            goto L49
        L48:
            r6 = 0
        L49:
            r6 = r6 ^ r5
            if (r6 == 0) goto L4d
        L4c:
            r1 = 1
        L4d:
            com.afollestad.materialdialogs.actions.DialogActionExtKt.setActionButtonEnabled(r10, r0, r1)
            com.afollestad.materialdialogs.internal.list.MultiChoiceDialogAdapter r9 = new com.afollestad.materialdialogs.internal.list.MultiChoiceDialogAdapter
            r0 = r9
            r1 = r10
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            androidx.recyclerview.widget.RecyclerView$Adapter r9 = (androidx.recyclerview.widget.RecyclerView.Adapter) r9
            r0 = 2
            r1 = 0
            com.afollestad.materialdialogs.MaterialDialog r0 = com.afollestad.materialdialogs.list.DialogListExtKt.customListAdapter$default(r10, r9, r1, r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.list.DialogMultiChoiceExtKt.listItemsMultiChoice(com.afollestad.materialdialogs.MaterialDialog, java.lang.Integer, java.util.List, int[], int[], boolean, boolean, kotlin.jvm.functions.Function3):com.afollestad.materialdialogs.MaterialDialog");
    }

    public static /* synthetic */ MaterialDialog updateListItemsMultiChoice$default(MaterialDialog materialDialog, Integer num, List list, int[] iArr, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            list = null;
        }
        if ((i & 4) != 0) {
            iArr = null;
        }
        if ((i & 8) != 0) {
            function3 = null;
        }
        return updateListItemsMultiChoice(materialDialog, num, list, iArr, function3);
    }

    public static final MaterialDialog updateListItemsMultiChoice(MaterialDialog materialDialog, Integer num, List<? extends CharSequence> list, int[] iArr, Function3<? super MaterialDialog, ? super int[], ? super List<? extends CharSequence>, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        MDUtil.INSTANCE.assertOneSet("updateListItemsMultiChoice", list, num);
        if (list == null) {
            list = ArraysKt.toList(MDUtil.INSTANCE.getStringArray(materialDialog.getWindowContext(), num));
        }
        RecyclerView.Adapter<?> listAdapter = DialogListExtKt.getListAdapter(materialDialog);
        if (!(listAdapter instanceof MultiChoiceDialogAdapter)) {
            throw new IllegalStateException("updateListItemsMultiChoice(...) can't be used before you've created a multiple choice list dialog.".toString());
        }
        MultiChoiceDialogAdapter multiChoiceDialogAdapter = (MultiChoiceDialogAdapter) listAdapter;
        multiChoiceDialogAdapter.replaceItems2(list, function3);
        if (iArr != null) {
            multiChoiceDialogAdapter.disableItems(iArr);
        }
        return materialDialog;
    }

    public static final void checkItems(MaterialDialog materialDialog, int[] iArr) {
        String str;
        Class<?> cls;
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        Intrinsics.checkParameterIsNotNull(iArr, "");
        RecyclerView.Adapter<?> listAdapter = DialogListExtKt.getListAdapter(materialDialog);
        if (listAdapter instanceof DialogAdapter) {
            ((DialogAdapter) listAdapter).checkItems(iArr);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't check items on adapter: ");
        if (listAdapter == null || (cls = listAdapter.getClass()) == null || (str = cls.getName()) == null) {
            str = "null";
        }
        sb.append(str);
        throw new UnsupportedOperationException(sb.toString());
    }

    public static final void uncheckItems(MaterialDialog materialDialog, int[] iArr) {
        String str;
        Class<?> cls;
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        Intrinsics.checkParameterIsNotNull(iArr, "");
        RecyclerView.Adapter<?> listAdapter = DialogListExtKt.getListAdapter(materialDialog);
        if (listAdapter instanceof DialogAdapter) {
            ((DialogAdapter) listAdapter).uncheckItems(iArr);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't uncheck items on adapter: ");
        if (listAdapter == null || (cls = listAdapter.getClass()) == null || (str = cls.getName()) == null) {
            str = "null";
        }
        sb.append(str);
        throw new UnsupportedOperationException(sb.toString());
    }

    public static final void toggleItemsChecked(MaterialDialog materialDialog, int[] iArr) {
        String str;
        Class<?> cls;
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        Intrinsics.checkParameterIsNotNull(iArr, "");
        RecyclerView.Adapter<?> listAdapter = DialogListExtKt.getListAdapter(materialDialog);
        if (listAdapter instanceof DialogAdapter) {
            ((DialogAdapter) listAdapter).toggleItems(iArr);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't toggle checked items on adapter: ");
        if (listAdapter == null || (cls = listAdapter.getClass()) == null || (str = cls.getName()) == null) {
            str = "null";
        }
        sb.append(str);
        throw new UnsupportedOperationException(sb.toString());
    }

    public static final void checkAllItems(MaterialDialog materialDialog) {
        String str;
        Class<?> cls;
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        RecyclerView.Adapter<?> listAdapter = DialogListExtKt.getListAdapter(materialDialog);
        if (listAdapter instanceof DialogAdapter) {
            ((DialogAdapter) listAdapter).checkAllItems();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't check all items on adapter: ");
        if (listAdapter == null || (cls = listAdapter.getClass()) == null || (str = cls.getName()) == null) {
            str = "null";
        }
        sb.append(str);
        throw new UnsupportedOperationException(sb.toString());
    }

    public static final void uncheckAllItems(MaterialDialog materialDialog) {
        String str;
        Class<?> cls;
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        RecyclerView.Adapter<?> listAdapter = DialogListExtKt.getListAdapter(materialDialog);
        if (listAdapter instanceof DialogAdapter) {
            ((DialogAdapter) listAdapter).uncheckAllItems();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't uncheck all items on adapter: ");
        if (listAdapter == null || (cls = listAdapter.getClass()) == null || (str = cls.getName()) == null) {
            str = "null";
        }
        sb.append(str);
        throw new UnsupportedOperationException(sb.toString());
    }

    public static final void toggleAllItemsChecked(MaterialDialog materialDialog) {
        String str;
        Class<?> cls;
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        RecyclerView.Adapter<?> listAdapter = DialogListExtKt.getListAdapter(materialDialog);
        if (listAdapter instanceof DialogAdapter) {
            ((DialogAdapter) listAdapter).toggleAllChecked();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't uncheck all items on adapter: ");
        if (listAdapter == null || (cls = listAdapter.getClass()) == null || (str = cls.getName()) == null) {
            str = "null";
        }
        sb.append(str);
        throw new UnsupportedOperationException(sb.toString());
    }
}
