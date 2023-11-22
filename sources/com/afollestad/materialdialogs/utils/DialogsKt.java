package com.afollestad.materialdialogs.utils;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.callbacks.DialogCallbackExtKt;
import com.afollestad.materialdialogs.checkbox.DialogCheckboxExtKt;
import com.afollestad.materialdialogs.customview.DialogCustomViewExtKt;
import com.afollestad.materialdialogs.internal.main.DialogLayout;
import com.afollestad.materialdialogs.internal.message.DialogContentLayout;
import com.iap.ac.android.region.cdp.util.CdpConstants;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a!\u0010\u0007\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a/\u0010\u000f\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001aS\u0010\u001a\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0013\u0010\u001c\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u001c\u0010\u0003"}, d2 = {"Lcom/afollestad/materialdialogs/MaterialDialog;", "", "hideKeyboard", "(Lcom/afollestad/materialdialogs/MaterialDialog;)V", "", "showTop", "showBottom", "invalidateDividers", "(Lcom/afollestad/materialdialogs/MaterialDialog;ZZ)V", "Landroid/widget/ImageView;", "imageView", "", "iconRes", "Landroid/graphics/drawable/Drawable;", "icon", "populateIcon", "(Lcom/afollestad/materialdialogs/MaterialDialog;Landroid/widget/ImageView;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;)V", "Landroid/widget/TextView;", "textView", "textRes", "", "text", "fallback", "Landroid/graphics/Typeface;", "typeface", CdpConstants.CONTENT_TEXT_COLOR, "populateText", "(Lcom/afollestad/materialdialogs/MaterialDialog;Landroid/widget/TextView;Ljava/lang/Integer;Ljava/lang/CharSequence;ILandroid/graphics/Typeface;Ljava/lang/Integer;)V", "preShow"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class DialogsKt {
    public static final void invalidateDividers(MaterialDialog materialDialog, boolean z, boolean z2) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        materialDialog.getView().invalidateDividers(z, z2);
    }

    public static final void preShow(MaterialDialog materialDialog) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        Object obj = materialDialog.getConfig().get(DialogCustomViewExtKt.CUSTOM_VIEW_NO_VERTICAL_PADDING);
        if (!(obj instanceof Boolean)) {
            obj = null;
        }
        boolean areEqual = Intrinsics.areEqual((Boolean) obj, Boolean.TRUE);
        DialogCallbackExtKt.invokeAll(materialDialog.getPreShowListeners$core(), materialDialog);
        DialogLayout view = materialDialog.getView();
        if (view.getTitleLayout().shouldNotBeVisible() && !areEqual) {
            view.getContentLayout().modifyFirstAndLastPadding(view.getFrameMarginVertical(), view.getFrameMarginVertical());
        }
        if (ViewsKt.isVisible(DialogCheckboxExtKt.getCheckBoxPrompt(materialDialog))) {
            DialogContentLayout.modifyFirstAndLastPadding$default(view.getContentLayout(), 0, 0, 1, null);
        } else if (view.getContentLayout().haveMoreThanOneChild()) {
            DialogContentLayout.modifyScrollViewPadding$default(view.getContentLayout(), 0, view.getFrameMarginVerticalLess(), 1, null);
        }
    }

    public static final void populateIcon(MaterialDialog materialDialog, ImageView imageView, Integer num, Drawable drawable) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        Intrinsics.checkParameterIsNotNull(imageView, "");
        Drawable resolveDrawable$default = MDUtil.resolveDrawable$default(MDUtil.INSTANCE, materialDialog.getWindowContext(), num, null, drawable, 4, null);
        if (resolveDrawable$default != null) {
            ViewParent parent = imageView.getParent();
            if (parent == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.view.View");
            }
            ((View) parent).setVisibility(0);
            imageView.setVisibility(0);
            imageView.setImageDrawable(resolveDrawable$default);
            return;
        }
        imageView.setVisibility(8);
    }

    public static final void populateText(MaterialDialog materialDialog, TextView textView, Integer num, CharSequence charSequence, int i, Typeface typeface, Integer num2) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        Intrinsics.checkParameterIsNotNull(textView, "");
        if (charSequence == null) {
            charSequence = MDUtil.resolveString$default(MDUtil.INSTANCE, materialDialog, num, Integer.valueOf(i), false, 8, (Object) null);
        }
        if (charSequence != null) {
            ViewParent parent = textView.getParent();
            if (parent == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.view.View");
            }
            ((View) parent).setVisibility(0);
            textView.setVisibility(0);
            textView.setText(charSequence);
            if (typeface != null) {
                textView.setTypeface(typeface);
            }
            MDUtil.maybeSetTextColor$default(MDUtil.INSTANCE, textView, materialDialog.getWindowContext(), num2, null, 4, null);
            return;
        }
        textView.setVisibility(8);
    }

    public static final void hideKeyboard(MaterialDialog materialDialog) {
        IBinder windowToken;
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        Object systemService = materialDialog.getWindowContext().getSystemService("input_method");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        View currentFocus = materialDialog.getCurrentFocus();
        if (currentFocus != null) {
            windowToken = currentFocus.getWindowToken();
        } else {
            windowToken = materialDialog.getView().getWindowToken();
        }
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
    }
}
