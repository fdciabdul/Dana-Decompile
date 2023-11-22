package com.afollestad.materialdialogs.internal.button;

import com.afollestad.materialdialogs.utils.ViewsKt;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/afollestad/materialdialogs/internal/button/DialogActionButtonLayout;", "", "shouldBeVisible", "(Lcom/afollestad/materialdialogs/internal/button/DialogActionButtonLayout;)Z"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class DialogActionButtonLayoutKt {
    public static final boolean shouldBeVisible(DialogActionButtonLayout dialogActionButtonLayout) {
        if (dialogActionButtonLayout == null) {
            return false;
        }
        return ((dialogActionButtonLayout.getVisibleButtons().length == 0) ^ true) || ViewsKt.isVisible(dialogActionButtonLayout.getCheckBoxPrompt());
    }
}
