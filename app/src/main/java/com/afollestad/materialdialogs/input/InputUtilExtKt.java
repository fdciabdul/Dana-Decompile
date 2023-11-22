package com.afollestad.materialdialogs.input;

import android.text.Editable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.WhichButton;
import com.afollestad.materialdialogs.actions.DialogActionExtKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a;\u0010\u000b\u001a\u00020\u0001\"\b\b\u0000\u0010\u0007*\u00020\u0006*\u00028\u00002\u001b\b\u0004\u0010\n\u001a\u0015\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\u0002\b\tH\u0080\b¢\u0006\u0004\b\u000b\u0010\f\u001a\u0013\u0010\r\u001a\u00020\u0003*\u00020\u0000H\u0000¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Lcom/afollestad/materialdialogs/MaterialDialog;", "", "allowEmpty", "", "invalidateInputMaxLength", "(Lcom/afollestad/materialdialogs/MaterialDialog;Z)V", "Landroid/view/View;", "T", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "exec", "postRun", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)Z", "showKeyboardIfApplicable", "(Lcom/afollestad/materialdialogs/MaterialDialog;)V"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class InputUtilExtKt {
    public static final void invalidateInputMaxLength(MaterialDialog materialDialog, boolean z) {
        int counterMaxLength;
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        Editable text = DialogInputExtKt.getInputField(materialDialog).getText();
        int length = text != null ? text.length() : 0;
        if ((z || length != 0) && (counterMaxLength = DialogInputExtKt.getInputLayout(materialDialog).getCounterMaxLength()) > 0) {
            DialogActionExtKt.setActionButtonEnabled(materialDialog, WhichButton.POSITIVE, length <= counterMaxLength);
        }
    }

    public static final void showKeyboardIfApplicable(final MaterialDialog materialDialog) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        final EditText inputField = DialogInputExtKt.getInputField(materialDialog);
        inputField.post(new Runnable() { // from class: com.afollestad.materialdialogs.input.InputUtilExtKt$showKeyboardIfApplicable$$inlined$postRun$1
            @Override // java.lang.Runnable
            public final void run() {
                EditText editText = (EditText) inputField;
                editText.requestFocus();
                Object systemService = materialDialog.getWindowContext().getSystemService("input_method");
                if (systemService == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                }
                ((InputMethodManager) systemService).showSoftInput(editText, 1);
            }
        });
    }

    public static final <T extends View> boolean postRun(final T t, final Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(t, "");
        Intrinsics.checkParameterIsNotNull(function1, "");
        return t.post(new Runnable() { // from class: com.afollestad.materialdialogs.input.InputUtilExtKt$postRun$1
            @Override // java.lang.Runnable
            public final void run() {
                function1.invoke(t);
            }
        });
    }
}
