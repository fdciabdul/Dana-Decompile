package com.afollestad.materialdialogs;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.afollestad.materialdialogs.actions.DialogActionExtKt;
import com.afollestad.materialdialogs.internal.button.DialogActionButton;
import com.afollestad.materialdialogs.internal.main.DialogLayout;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.afollestad.materialdialogs.utils.ViewsKt;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.iap.ac.android.region.cdp.util.CdpConstants;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b'\u0010(J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001b\u0010\u001aJ'\u0010 \u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J1\u0010%\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u000e2\b\u0010$\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b%\u0010&"}, d2 = {"Lcom/afollestad/materialdialogs/ModalDialog;", "Lcom/afollestad/materialdialogs/DialogBehavior;", "Landroid/content/Context;", "creatingContext", "Landroid/view/Window;", "dialogWindow", "Landroid/view/LayoutInflater;", "layoutInflater", "Lcom/afollestad/materialdialogs/MaterialDialog;", "dialog", "Landroid/view/ViewGroup;", "createView", "(Landroid/content/Context;Landroid/view/Window;Landroid/view/LayoutInflater;Lcom/afollestad/materialdialogs/MaterialDialog;)Landroid/view/ViewGroup;", "root", "Lcom/afollestad/materialdialogs/internal/main/DialogLayout;", "getDialogLayout", "(Landroid/view/ViewGroup;)Lcom/afollestad/materialdialogs/internal/main/DialogLayout;", "", "isDark", "", "getThemeRes", "(Z)I", "onDismiss", "()Z", "", "onPostShow", "(Lcom/afollestad/materialdialogs/MaterialDialog;)V", "onPreShow", "view", "color", "", CdpConstants.CONTENT_CORNER_RADIUS, "setBackgroundColor", "(Lcom/afollestad/materialdialogs/internal/main/DialogLayout;IF)V", HummerConstants.CONTEXT, "window", "maxWidth", "setWindowConstraints", "(Landroid/content/Context;Landroid/view/Window;Lcom/afollestad/materialdialogs/internal/main/DialogLayout;Ljava/lang/Integer;)V", "<init>", "()V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class ModalDialog implements DialogBehavior {
    public static final ModalDialog INSTANCE = new ModalDialog();

    @Override // com.afollestad.materialdialogs.DialogBehavior
    public final boolean onDismiss() {
        return false;
    }

    @Override // com.afollestad.materialdialogs.DialogBehavior
    public final void onPreShow(MaterialDialog dialog) {
        Intrinsics.checkParameterIsNotNull(dialog, "");
    }

    private ModalDialog() {
    }

    @Override // com.afollestad.materialdialogs.DialogBehavior
    public final int getThemeRes(boolean isDark) {
        if (isDark) {
            return R.style.MD_Dark;
        }
        return R.style.MD_Light;
    }

    @Override // com.afollestad.materialdialogs.DialogBehavior
    public final ViewGroup createView(Context creatingContext, Window dialogWindow, LayoutInflater layoutInflater, MaterialDialog dialog) {
        Intrinsics.checkParameterIsNotNull(creatingContext, "");
        Intrinsics.checkParameterIsNotNull(dialogWindow, "");
        Intrinsics.checkParameterIsNotNull(layoutInflater, "");
        Intrinsics.checkParameterIsNotNull(dialog, "");
        View inflate = layoutInflater.inflate(R.layout.md_dialog_base, (ViewGroup) null, false);
        if (inflate != null) {
            return (ViewGroup) inflate;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    @Override // com.afollestad.materialdialogs.DialogBehavior
    public final DialogLayout getDialogLayout(ViewGroup root) {
        Intrinsics.checkParameterIsNotNull(root, "");
        return (DialogLayout) root;
    }

    @Override // com.afollestad.materialdialogs.DialogBehavior
    public final void setWindowConstraints(Context r4, Window window, DialogLayout view, Integer maxWidth) {
        Intrinsics.checkParameterIsNotNull(r4, "");
        Intrinsics.checkParameterIsNotNull(window, "");
        Intrinsics.checkParameterIsNotNull(view, "");
        if (maxWidth == null || maxWidth.intValue() != 0) {
            window.setSoftInputMode(16);
            WindowManager windowManager = window.getWindowManager();
            if (windowManager != null) {
                Resources resources = r4.getResources();
                Pair<Integer, Integer> widthAndHeight = MDUtil.INSTANCE.getWidthAndHeight(windowManager);
                int intValue = widthAndHeight.component1().intValue();
                view.setMaxHeight(widthAndHeight.component2().intValue() - (resources.getDimensionPixelSize(R.dimen.md_dialog_vertical_margin) * 2));
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                layoutParams.copyFrom(window.getAttributes());
                layoutParams.width = Math.min(maxWidth != null ? maxWidth.intValue() : resources.getDimensionPixelSize(R.dimen.md_dialog_max_width), intValue - (resources.getDimensionPixelSize(R.dimen.md_dialog_horizontal_margin) * 2));
                window.setAttributes(layoutParams);
            }
        }
    }

    @Override // com.afollestad.materialdialogs.DialogBehavior
    public final void setBackgroundColor(DialogLayout view, int color, float r6) {
        Intrinsics.checkParameterIsNotNull(view, "");
        view.setCornerRadii(new float[]{r6, r6, r6, r6, 0.0f, 0.0f, 0.0f, 0.0f});
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(r6);
        gradientDrawable.setColor(color);
        view.setBackground(gradientDrawable);
    }

    @Override // com.afollestad.materialdialogs.DialogBehavior
    public final void onPostShow(MaterialDialog dialog) {
        Intrinsics.checkParameterIsNotNull(dialog, "");
        final DialogActionButton actionButton = DialogActionExtKt.getActionButton(dialog, WhichButton.NEGATIVE);
        if (ViewsKt.isVisible(actionButton)) {
            actionButton.post(new Runnable() { // from class: com.afollestad.materialdialogs.ModalDialog$onPostShow$1
                @Override // java.lang.Runnable
                public final void run() {
                    DialogActionButton.this.requestFocus();
                }
            });
            return;
        }
        final DialogActionButton actionButton2 = DialogActionExtKt.getActionButton(dialog, WhichButton.POSITIVE);
        if (ViewsKt.isVisible(actionButton2)) {
            actionButton2.post(new Runnable() { // from class: com.afollestad.materialdialogs.ModalDialog$onPostShow$2
                @Override // java.lang.Runnable
                public final void run() {
                    DialogActionButton.this.requestFocus();
                }
            });
        }
    }
}
