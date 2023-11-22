package com.afollestad.materialdialogs.actions;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.WhichButton;
import com.afollestad.materialdialogs.internal.button.DialogActionButton;
import com.afollestad.materialdialogs.internal.button.DialogActionButtonLayout;
import com.afollestad.materialdialogs.utils.ViewsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\t\u001a\u00020\u0006*\u00020\u0000¢\u0006\u0004\b\t\u0010\n\u001a!\u0010\r\u001a\u00020\f*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Lcom/afollestad/materialdialogs/MaterialDialog;", "Lcom/afollestad/materialdialogs/WhichButton;", "which", "Lcom/afollestad/materialdialogs/internal/button/DialogActionButton;", "getActionButton", "(Lcom/afollestad/materialdialogs/MaterialDialog;Lcom/afollestad/materialdialogs/WhichButton;)Lcom/afollestad/materialdialogs/internal/button/DialogActionButton;", "", "hasActionButton", "(Lcom/afollestad/materialdialogs/MaterialDialog;Lcom/afollestad/materialdialogs/WhichButton;)Z", "hasActionButtons", "(Lcom/afollestad/materialdialogs/MaterialDialog;)Z", "enabled", "", "setActionButtonEnabled", "(Lcom/afollestad/materialdialogs/MaterialDialog;Lcom/afollestad/materialdialogs/WhichButton;Z)V"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class DialogActionExtKt {
    public static final boolean hasActionButtons(MaterialDialog materialDialog) {
        DialogActionButton[] visibleButtons;
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        DialogActionButtonLayout buttonsLayout = materialDialog.getView().getButtonsLayout();
        if (buttonsLayout == null || (visibleButtons = buttonsLayout.getVisibleButtons()) == null) {
            return false;
        }
        return !(visibleButtons.length == 0);
    }

    public static final boolean hasActionButton(MaterialDialog materialDialog, WhichButton whichButton) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        Intrinsics.checkParameterIsNotNull(whichButton, "");
        return ViewsKt.isVisible(getActionButton(materialDialog, whichButton));
    }

    public static final DialogActionButton getActionButton(MaterialDialog materialDialog, WhichButton whichButton) {
        DialogActionButton[] actionButtons;
        DialogActionButton dialogActionButton;
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        Intrinsics.checkParameterIsNotNull(whichButton, "");
        DialogActionButtonLayout buttonsLayout = materialDialog.getView().getButtonsLayout();
        if (buttonsLayout == null || (actionButtons = buttonsLayout.getActionButtons()) == null || (dialogActionButton = actionButtons[whichButton.getIndex()]) == null) {
            throw new IllegalStateException("The dialog does not have an attached buttons layout.");
        }
        return dialogActionButton;
    }

    public static final void setActionButtonEnabled(MaterialDialog materialDialog, WhichButton whichButton, boolean z) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        Intrinsics.checkParameterIsNotNull(whichButton, "");
        getActionButton(materialDialog, whichButton).setEnabled(z);
    }
}
