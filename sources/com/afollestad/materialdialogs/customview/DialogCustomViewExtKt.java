package com.afollestad.materialdialogs.customview;

import android.view.View;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.utils.MDUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u001aQ\u0010\n\u001a\u00020\u0000*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000b\u001a\u0011\u0010\f\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\f\u0010\r\"\u0014\u0010\u000f\u001a\u00020\u000e8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lcom/afollestad/materialdialogs/MaterialDialog;", "", "viewRes", "Landroid/view/View;", "view", "", "scrollable", "noVerticalPadding", "horizontalPadding", "dialogWrapContent", "customView", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/lang/Integer;Landroid/view/View;ZZZZ)Lcom/afollestad/materialdialogs/MaterialDialog;", "getCustomView", "(Lcom/afollestad/materialdialogs/MaterialDialog;)Landroid/view/View;", "", "CUSTOM_VIEW_NO_VERTICAL_PADDING", "Ljava/lang/String;"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class DialogCustomViewExtKt {
    public static final String CUSTOM_VIEW_NO_VERTICAL_PADDING = "md.custom_view_no_vertical_padding";

    public static final View getCustomView(MaterialDialog materialDialog) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        View customView = materialDialog.getView().getContentLayout().getCustomView();
        if (customView != null) {
            return customView;
        }
        throw new IllegalStateException("You have not setup this dialog as a customView dialog.".toString());
    }

    public static /* synthetic */ MaterialDialog customView$default(MaterialDialog materialDialog, Integer num, View view, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            view = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        if ((i & 16) != 0) {
            z3 = false;
        }
        if ((i & 32) != 0) {
            z4 = false;
        }
        return customView(materialDialog, num, view, z, z2, z3, z4);
    }

    public static final MaterialDialog customView(final MaterialDialog materialDialog, Integer num, View view, boolean z, boolean z2, boolean z3, final boolean z4) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        MDUtil.INSTANCE.assertOneSet("customView", view, num);
        materialDialog.getConfig().put(CUSTOM_VIEW_NO_VERTICAL_PADDING, Boolean.valueOf(z2));
        if (z4) {
            MaterialDialog.maxWidth$default(materialDialog, null, 0, 1, null);
        }
        View addCustomView = materialDialog.getView().getContentLayout().addCustomView(num, view, z, z2, z3);
        if (z4) {
            MDUtil.INSTANCE.waitForWidth(addCustomView, new Function1<View, Unit>() { // from class: com.afollestad.materialdialogs.customview.DialogCustomViewExtKt$customView$$inlined$also$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(View view2) {
                    invoke2(view2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(View view2) {
                    Intrinsics.checkParameterIsNotNull(view2, "");
                    MaterialDialog.maxWidth$default(MaterialDialog.this, null, Integer.valueOf(view2.getMeasuredWidth()), 1, null);
                }
            });
        }
        return materialDialog;
    }
}
