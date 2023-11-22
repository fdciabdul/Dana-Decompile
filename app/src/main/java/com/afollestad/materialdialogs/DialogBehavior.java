package com.afollestad.materialdialogs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import com.afollestad.materialdialogs.internal.main.DialogLayout;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.iap.ac.android.region.cdp.util.CdpConstants;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\nH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0011H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u001b\u0010\u001aJ'\u0010 \u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\b \u0010!J1\u0010%\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u000e2\b\u0010$\u001a\u0004\u0018\u00010\u0013H&¢\u0006\u0004\b%\u0010&"}, d2 = {"Lcom/afollestad/materialdialogs/DialogBehavior;", "", "Landroid/content/Context;", "creatingContext", "Landroid/view/Window;", "dialogWindow", "Landroid/view/LayoutInflater;", "layoutInflater", "Lcom/afollestad/materialdialogs/MaterialDialog;", "dialog", "Landroid/view/ViewGroup;", "createView", "(Landroid/content/Context;Landroid/view/Window;Landroid/view/LayoutInflater;Lcom/afollestad/materialdialogs/MaterialDialog;)Landroid/view/ViewGroup;", "root", "Lcom/afollestad/materialdialogs/internal/main/DialogLayout;", "getDialogLayout", "(Landroid/view/ViewGroup;)Lcom/afollestad/materialdialogs/internal/main/DialogLayout;", "", "isDark", "", "getThemeRes", "(Z)I", "onDismiss", "()Z", "", "onPostShow", "(Lcom/afollestad/materialdialogs/MaterialDialog;)V", "onPreShow", "view", "color", "", CdpConstants.CONTENT_CORNER_RADIUS, "setBackgroundColor", "(Lcom/afollestad/materialdialogs/internal/main/DialogLayout;IF)V", HummerConstants.CONTEXT, "window", "maxWidth", "setWindowConstraints", "(Landroid/content/Context;Landroid/view/Window;Lcom/afollestad/materialdialogs/internal/main/DialogLayout;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public interface DialogBehavior {
    ViewGroup createView(Context creatingContext, Window dialogWindow, LayoutInflater layoutInflater, MaterialDialog dialog);

    DialogLayout getDialogLayout(ViewGroup root);

    int getThemeRes(boolean isDark);

    boolean onDismiss();

    void onPostShow(MaterialDialog dialog);

    void onPreShow(MaterialDialog dialog);

    void setBackgroundColor(DialogLayout view, int color, float cornerRadius);

    void setWindowConstraints(Context context, Window window, DialogLayout view, Integer maxWidth);
}
