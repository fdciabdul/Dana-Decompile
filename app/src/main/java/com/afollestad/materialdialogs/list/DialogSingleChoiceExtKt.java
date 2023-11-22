package com.afollestad.materialdialogs.list;

import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.WhichButton;
import com.afollestad.materialdialogs.actions.DialogActionExtKt;
import com.afollestad.materialdialogs.internal.list.DialogAdapter;
import com.afollestad.materialdialogs.internal.list.SingleChoiceDialogAdapter;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a¢\u0001\u0010\u0017\u001a\u00020\u0000*\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00012=\b\u0002\u0010\u0016\u001a7\u0012\u000b\u0012\t\u0018\u00010\u0000¢\u0006\u0002\b\u0014\u0012\u000b\u0012\t\u0018\u00010\u0001¢\u0006\u0002\b\u0014\u0012\u000b\u0012\t\u0018\u00010\u000b¢\u0006\u0002\b\u0014\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013j\u0004\u0018\u0001`\u0015¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0019\u0010\u0019\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0019\u0010\u0005\u001a\u0019\u0010\u001a\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u001a\u0010\u0005\u001az\u0010\u001b\u001a\u00020\u0000*\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2=\b\u0002\u0010\u0016\u001a7\u0012\u000b\u0012\t\u0018\u00010\u0000¢\u0006\u0002\b\u0014\u0012\u000b\u0012\t\u0018\u00010\u0001¢\u0006\u0002\b\u0014\u0012\u000b\u0012\t\u0018\u00010\u000b¢\u0006\u0002\b\u0014\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013j\u0004\u0018\u0001`\u0015¢\u0006\u0004\b\u001b\u0010\u001c"}, d2 = {"Lcom/afollestad/materialdialogs/MaterialDialog;", "", "index", "", "checkItem", "(Lcom/afollestad/materialdialogs/MaterialDialog;I)V", "", "isItemChecked", "(Lcom/afollestad/materialdialogs/MaterialDialog;I)Z", "res", "", "", FirebaseAnalytics.Param.ITEMS, "", "disabledIndices", "initialSelection", "waitForPositiveButton", "checkedColor", "uncheckedColor", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "Lcom/afollestad/materialdialogs/list/SingleChoiceListener;", "selection", "listItemsSingleChoice", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/lang/Integer;Ljava/util/List;[IIZIILkotlin/jvm/functions/Function3;)Lcom/afollestad/materialdialogs/MaterialDialog;", "toggleItemChecked", "uncheckItem", "updateListItemsSingleChoice", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/lang/Integer;Ljava/util/List;[ILkotlin/jvm/functions/Function3;)Lcom/afollestad/materialdialogs/MaterialDialog;"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class DialogSingleChoiceExtKt {
    public static /* synthetic */ MaterialDialog listItemsSingleChoice$default(MaterialDialog materialDialog, Integer num, List list, int[] iArr, int i, boolean z, int i2, int i3, Function3 function3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            num = null;
        }
        if ((i4 & 2) != 0) {
            list = null;
        }
        if ((i4 & 4) != 0) {
            iArr = null;
        }
        if ((i4 & 8) != 0) {
            i = -1;
        }
        if ((i4 & 16) != 0) {
            z = true;
        }
        if ((i4 & 32) != 0) {
            i2 = -1;
        }
        if ((i4 & 64) != 0) {
            i3 = -1;
        }
        if ((i4 & 128) != 0) {
            function3 = null;
        }
        return listItemsSingleChoice(materialDialog, num, list, iArr, i, z, i2, i3, function3);
    }

    public static final MaterialDialog listItemsSingleChoice(MaterialDialog materialDialog, Integer num, List<? extends CharSequence> list, int[] iArr, int i, boolean z, int i2, int i3, Function3<? super MaterialDialog, ? super Integer, ? super CharSequence, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        MDUtil.INSTANCE.assertOneSet("listItemsSingleChoice", list, num);
        List<? extends CharSequence> list2 = list != null ? list : ArraysKt.toList(MDUtil.INSTANCE.getStringArray(materialDialog.getWindowContext(), num));
        if (!(i >= -1 || i < list2.size())) {
            StringBuilder sb = new StringBuilder();
            sb.append("Initial selection ");
            sb.append(i);
            sb.append(" must be between -1 and ");
            sb.append("the size of your items array ");
            sb.append(list2.size());
            throw new IllegalArgumentException(sb.toString().toString());
        } else if (DialogListExtKt.getListAdapter(materialDialog) != null) {
            InstrumentInjector.log_w("MaterialDialogs", "Prefer calling updateListItemsSingleChoice(...) over listItemsSingleChoice(...) again.");
            return updateListItemsSingleChoice(materialDialog, num, list, iArr, function3);
        } else {
            DialogActionExtKt.setActionButtonEnabled(materialDialog, WhichButton.POSITIVE, i >= 0);
            return DialogListExtKt.customListAdapter$default(materialDialog, new SingleChoiceDialogAdapter(materialDialog, list2, iArr, i, z, function3, i2, i3), null, 2, null);
        }
    }

    public static /* synthetic */ MaterialDialog updateListItemsSingleChoice$default(MaterialDialog materialDialog, Integer num, List list, int[] iArr, Function3 function3, int i, Object obj) {
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
        return updateListItemsSingleChoice(materialDialog, num, list, iArr, function3);
    }

    public static final MaterialDialog updateListItemsSingleChoice(MaterialDialog materialDialog, Integer num, List<? extends CharSequence> list, int[] iArr, Function3<? super MaterialDialog, ? super Integer, ? super CharSequence, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        MDUtil.INSTANCE.assertOneSet("updateListItemsSingleChoice", list, num);
        if (list == null) {
            list = ArraysKt.toList(MDUtil.INSTANCE.getStringArray(materialDialog.getWindowContext(), num));
        }
        RecyclerView.Adapter<?> listAdapter = DialogListExtKt.getListAdapter(materialDialog);
        if (!(listAdapter instanceof SingleChoiceDialogAdapter)) {
            throw new IllegalStateException("updateListItemsSingleChoice(...) can't be used before you've created a single choice list dialog.".toString());
        }
        SingleChoiceDialogAdapter singleChoiceDialogAdapter = (SingleChoiceDialogAdapter) listAdapter;
        singleChoiceDialogAdapter.replaceItems2(list, function3);
        if (iArr != null) {
            singleChoiceDialogAdapter.disableItems(iArr);
        }
        return materialDialog;
    }

    public static final void checkItem(MaterialDialog materialDialog, int i) {
        String str;
        Class<?> cls;
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        RecyclerView.Adapter<?> listAdapter = DialogListExtKt.getListAdapter(materialDialog);
        if (listAdapter instanceof DialogAdapter) {
            ((DialogAdapter) listAdapter).checkItems(new int[]{i});
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't check item on adapter: ");
        if (listAdapter == null || (cls = listAdapter.getClass()) == null || (str = cls.getName()) == null) {
            str = "null";
        }
        sb.append(str);
        throw new UnsupportedOperationException(sb.toString());
    }

    public static final void uncheckItem(MaterialDialog materialDialog, int i) {
        String str;
        Class<?> cls;
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        RecyclerView.Adapter<?> listAdapter = DialogListExtKt.getListAdapter(materialDialog);
        if (listAdapter instanceof DialogAdapter) {
            ((DialogAdapter) listAdapter).uncheckItems(new int[]{i});
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't uncheck item on adapter: ");
        if (listAdapter == null || (cls = listAdapter.getClass()) == null || (str = cls.getName()) == null) {
            str = "null";
        }
        sb.append(str);
        throw new UnsupportedOperationException(sb.toString());
    }

    public static final void toggleItemChecked(MaterialDialog materialDialog, int i) {
        String str;
        Class<?> cls;
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        RecyclerView.Adapter<?> listAdapter = DialogListExtKt.getListAdapter(materialDialog);
        if (listAdapter instanceof DialogAdapter) {
            ((DialogAdapter) listAdapter).toggleItems(new int[]{i});
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't toggle checked item on adapter: ");
        if (listAdapter == null || (cls = listAdapter.getClass()) == null || (str = cls.getName()) == null) {
            str = "null";
        }
        sb.append(str);
        throw new UnsupportedOperationException(sb.toString());
    }

    public static final boolean isItemChecked(MaterialDialog materialDialog, int i) {
        String str;
        Class<?> cls;
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        RecyclerView.Adapter<?> listAdapter = DialogListExtKt.getListAdapter(materialDialog);
        if (listAdapter instanceof DialogAdapter) {
            return ((DialogAdapter) listAdapter).isItemChecked(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't check if item is checked on adapter: ");
        if (listAdapter == null || (cls = listAdapter.getClass()) == null || (str = cls.getName()) == null) {
            str = "null";
        }
        sb.append(str);
        throw new UnsupportedOperationException(sb.toString());
    }
}
