package com.afollestad.materialdialogs.list;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.internal.list.DialogRecyclerView;
import com.afollestad.materialdialogs.internal.list.PlainListDialogAdapter;
import com.afollestad.materialdialogs.utils.ColorsKt;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a)\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0017\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0011\u0010\r\u001a\u00020\f*\u00020\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0084\u0001\u0010\u001d\u001a\u00020\u0000*\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00162=\b\u0002\u0010\u001c\u001a7\u0012\u000b\u0012\t\u0018\u00010\u0000¢\u0006\u0002\b\u0019\u0012\u000b\u0012\t\u0018\u00010\u000f¢\u0006\u0002\b\u0019\u0012\u000b\u0012\t\u0018\u00010\u0012¢\u0006\u0002\b\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0018j\u0004\u0018\u0001`\u001b¢\u0006\u0004\b\u001d\u0010\u001e\u001az\u0010\u001f\u001a\u00020\u0000*\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142=\b\u0002\u0010\u001c\u001a7\u0012\u000b\u0012\t\u0018\u00010\u0000¢\u0006\u0002\b\u0019\u0012\u000b\u0012\t\u0018\u00010\u000f¢\u0006\u0002\b\u0019\u0012\u000b\u0012\t\u0018\u00010\u0012¢\u0006\u0002\b\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0018j\u0004\u0018\u0001`\u001b¢\u0006\u0004\b\u001f\u0010 "}, d2 = {"Lcom/afollestad/materialdialogs/MaterialDialog;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "layoutManager", "customListAdapter", "(Lcom/afollestad/materialdialogs/MaterialDialog;Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)Lcom/afollestad/materialdialogs/MaterialDialog;", "Landroid/graphics/drawable/Drawable;", "getItemSelector", "(Lcom/afollestad/materialdialogs/MaterialDialog;)Landroid/graphics/drawable/Drawable;", "getListAdapter", "(Lcom/afollestad/materialdialogs/MaterialDialog;)Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "(Lcom/afollestad/materialdialogs/MaterialDialog;)Landroidx/recyclerview/widget/RecyclerView;", "", "res", "", "", FirebaseAnalytics.Param.ITEMS, "", "disabledIndices", "", "waitForPositiveButton", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "", "Lcom/afollestad/materialdialogs/list/ItemListener;", "selection", "listItems", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/lang/Integer;Ljava/util/List;[IZLkotlin/jvm/functions/Function3;)Lcom/afollestad/materialdialogs/MaterialDialog;", "updateListItems", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/lang/Integer;Ljava/util/List;[ILkotlin/jvm/functions/Function3;)Lcom/afollestad/materialdialogs/MaterialDialog;"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class DialogListExtKt {
    public static final RecyclerView getRecyclerView(MaterialDialog materialDialog) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        DialogRecyclerView recyclerView = materialDialog.getView().getContentLayout().getRecyclerView();
        if (recyclerView != null) {
            return recyclerView;
        }
        throw new IllegalStateException("This dialog is not a list dialog.");
    }

    public static final RecyclerView.Adapter<?> getListAdapter(MaterialDialog materialDialog) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        DialogRecyclerView recyclerView = materialDialog.getView().getContentLayout().getRecyclerView();
        if (recyclerView != null) {
            return recyclerView.getAdapter();
        }
        return null;
    }

    public static /* synthetic */ MaterialDialog customListAdapter$default(MaterialDialog materialDialog, RecyclerView.Adapter adapter, RecyclerView.LayoutManager layoutManager, int i, Object obj) {
        if ((i & 2) != 0) {
            layoutManager = null;
        }
        return customListAdapter(materialDialog, adapter, layoutManager);
    }

    public static final MaterialDialog customListAdapter(MaterialDialog materialDialog, RecyclerView.Adapter<?> adapter, RecyclerView.LayoutManager layoutManager) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        Intrinsics.checkParameterIsNotNull(adapter, "");
        materialDialog.getView().getContentLayout().addRecyclerView(materialDialog, adapter, layoutManager);
        return materialDialog;
    }

    public static /* synthetic */ MaterialDialog listItems$default(MaterialDialog materialDialog, Integer num, List list, int[] iArr, boolean z, Function3 function3, int i, Object obj) {
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
            z = true;
        }
        if ((i & 16) != 0) {
            function3 = null;
        }
        return listItems(materialDialog, num, list, iArr, z, function3);
    }

    public static final MaterialDialog listItems(MaterialDialog materialDialog, Integer num, List<? extends CharSequence> list, int[] iArr, boolean z, Function3<? super MaterialDialog, ? super Integer, ? super CharSequence, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        MDUtil.INSTANCE.assertOneSet("listItems", list, num);
        List<? extends CharSequence> list2 = list != null ? list : ArraysKt.toList(MDUtil.INSTANCE.getStringArray(materialDialog.getWindowContext(), num));
        if (getListAdapter(materialDialog) != null) {
            InstrumentInjector.log_w("MaterialDialogs", "Prefer calling updateListItems(...) over listItems(...) again.");
            return updateListItems(materialDialog, num, list, iArr, function3);
        }
        return customListAdapter$default(materialDialog, new PlainListDialogAdapter(materialDialog, list2, iArr, z, function3), null, 2, null);
    }

    public static /* synthetic */ MaterialDialog updateListItems$default(MaterialDialog materialDialog, Integer num, List list, int[] iArr, Function3 function3, int i, Object obj) {
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
        return updateListItems(materialDialog, num, list, iArr, function3);
    }

    public static final MaterialDialog updateListItems(MaterialDialog materialDialog, Integer num, List<? extends CharSequence> list, int[] iArr, Function3<? super MaterialDialog, ? super Integer, ? super CharSequence, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        MDUtil.INSTANCE.assertOneSet("updateListItems", list, num);
        if (list == null) {
            list = ArraysKt.toList(MDUtil.INSTANCE.getStringArray(materialDialog.getWindowContext(), num));
        }
        RecyclerView.Adapter<?> listAdapter = getListAdapter(materialDialog);
        if (!(listAdapter instanceof PlainListDialogAdapter)) {
            throw new IllegalStateException("updateListItems(...) can't be used before you've created a plain list dialog.".toString());
        }
        PlainListDialogAdapter plainListDialogAdapter = (PlainListDialogAdapter) listAdapter;
        plainListDialogAdapter.replaceItems2(list, function3);
        if (iArr != null) {
            plainListDialogAdapter.disableItems(iArr);
        }
        return materialDialog;
    }

    public static final Drawable getItemSelector(MaterialDialog materialDialog) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        MDUtil mDUtil = MDUtil.INSTANCE;
        Context context = materialDialog.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "");
        Drawable resolveDrawable$default = MDUtil.resolveDrawable$default(mDUtil, context, null, Integer.valueOf(R.attr.md_item_selector), null, 10, null);
        if (Build.VERSION.SDK_INT >= 21 && (resolveDrawable$default instanceof RippleDrawable)) {
            MDUtil mDUtil2 = MDUtil.INSTANCE;
            int resolveColor$default = ColorsKt.resolveColor$default(materialDialog, null, Integer.valueOf(R.attr.md_ripple_color), null, 5, null);
            if (resolveColor$default != 0) {
                ((RippleDrawable) resolveDrawable$default).setColor(ColorStateList.valueOf(resolveColor$default));
            }
        }
        return resolveDrawable$default;
    }
}
