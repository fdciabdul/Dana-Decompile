package com.afollestad.materialdialogs.input;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.WhichButton;
import com.afollestad.materialdialogs.actions.DialogActionExtKt;
import com.afollestad.materialdialogs.callbacks.DialogCallbackExtKt;
import com.afollestad.materialdialogs.customview.DialogCustomViewExtKt;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.alipay.mobile.verifyidentity.base.message.RequestConstants;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0004*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u008f\u0001\u0010\u0017\u001a\u00020\u0000*\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000e\u001a\u00020\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\"\b\u0002\u0010\u0016\u001a\u001c\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\u0004\u0018\u0001`\u0015¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0013\u0010\u0019\u001a\u00020\u0004*\u00020\u0000H\u0002¢\u0006\u0004\b\u0019\u0010\u0006\u001a/\u0010\u001a\u001a\u00020\u0014*\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a/\u0010\u001c\u001a\u00020\u0014*\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001c\u0010\u001d*2\u0010\u001e\"\u0016\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u0016\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013"}, d2 = {"Lcom/afollestad/materialdialogs/MaterialDialog;", "Landroid/widget/EditText;", "getInputField", "(Lcom/afollestad/materialdialogs/MaterialDialog;)Landroid/widget/EditText;", "Lcom/google/android/material/textfield/TextInputLayout;", "getInputLayout", "(Lcom/afollestad/materialdialogs/MaterialDialog;)Lcom/google/android/material/textfield/TextInputLayout;", "", "hint", "", "hintRes", "", "prefill", "prefillRes", RequestConstants.Pin.INPUTTYPE, SecurityConstants.KEY_MAXLENGTH, "", "waitForPositiveButton", "allowEmpty", "Lkotlin/Function2;", "", "Lcom/afollestad/materialdialogs/input/InputCallback;", "callback", "input", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/CharSequence;Ljava/lang/Integer;ILjava/lang/Integer;ZZLkotlin/jvm/functions/Function2;)Lcom/afollestad/materialdialogs/MaterialDialog;", "lookupInputLayout", "prefillInput", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/lang/CharSequence;Ljava/lang/Integer;Z)V", "styleInput", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/lang/String;Ljava/lang/Integer;I)V", "InputCallback"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class DialogInputExtKt {
    public static final TextInputLayout getInputLayout(MaterialDialog materialDialog) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        Object obj = materialDialog.getConfig().get("[custom_view_input_layout]");
        if (!(obj instanceof TextInputLayout)) {
            obj = null;
        }
        TextInputLayout textInputLayout = (TextInputLayout) obj;
        if (textInputLayout != null) {
            return textInputLayout;
        }
        TextInputLayout lookupInputLayout = lookupInputLayout(materialDialog);
        materialDialog.getConfig().put("[custom_view_input_layout]", lookupInputLayout);
        return lookupInputLayout;
    }

    private static final TextInputLayout lookupInputLayout(MaterialDialog materialDialog) {
        View findViewById = DialogCustomViewExtKt.getCustomView(materialDialog).findViewById(R.id.md_input_layout);
        if (!(findViewById instanceof TextInputLayout)) {
            findViewById = null;
        }
        TextInputLayout textInputLayout = (TextInputLayout) findViewById;
        if (textInputLayout != null) {
            return textInputLayout;
        }
        throw new IllegalStateException("You have not setup this dialog as an input dialog.");
    }

    public static final EditText getInputField(MaterialDialog materialDialog) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        EditText editText = getInputLayout(materialDialog).getEditText();
        if (editText != null) {
            return editText;
        }
        throw new IllegalStateException("You have not setup this dialog as an input dialog.");
    }

    public static /* synthetic */ MaterialDialog input$default(MaterialDialog materialDialog, String str, Integer num, CharSequence charSequence, Integer num2, int i, Integer num3, boolean z, boolean z2, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            charSequence = null;
        }
        if ((i2 & 8) != 0) {
            num2 = null;
        }
        if ((i2 & 16) != 0) {
            i = 1;
        }
        if ((i2 & 32) != 0) {
            num3 = null;
        }
        if ((i2 & 64) != 0) {
            z = true;
        }
        if ((i2 & 128) != 0) {
            z2 = false;
        }
        if ((i2 & 256) != 0) {
            function2 = null;
        }
        return input(materialDialog, str, num, charSequence, num2, i, num3, z, z2, function2);
    }

    public static final MaterialDialog input(final MaterialDialog materialDialog, String str, Integer num, CharSequence charSequence, Integer num2, int i, final Integer num3, final boolean z, final boolean z2, final Function2<? super MaterialDialog, ? super CharSequence, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        DialogCustomViewExtKt.customView$default(materialDialog, Integer.valueOf(R.layout.md_dialog_stub_input), null, false, false, false, false, 62, null);
        DialogCallbackExtKt.onPreShow(materialDialog, new Function1<MaterialDialog, Unit>() { // from class: com.afollestad.materialdialogs.input.DialogInputExtKt$input$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MaterialDialog materialDialog2) {
                invoke2(materialDialog2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MaterialDialog materialDialog2) {
                Intrinsics.checkParameterIsNotNull(materialDialog2, "");
                InputUtilExtKt.showKeyboardIfApplicable(MaterialDialog.this);
            }
        });
        if (!DialogActionExtKt.hasActionButtons(materialDialog)) {
            MaterialDialog.positiveButton$default(materialDialog, 17039370, null, null, 6, null);
        }
        if (function2 != null && z) {
            MaterialDialog.positiveButton$default(materialDialog, null, null, new Function1<MaterialDialog, Unit>() { // from class: com.afollestad.materialdialogs.input.DialogInputExtKt$input$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(MaterialDialog materialDialog2) {
                    invoke2(materialDialog2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(MaterialDialog materialDialog2) {
                    Intrinsics.checkParameterIsNotNull(materialDialog2, "");
                    Function2 function22 = function2;
                    MaterialDialog materialDialog3 = MaterialDialog.this;
                    Editable text = DialogInputExtKt.getInputField(materialDialog3).getText();
                    function22.invoke(materialDialog3, text != null ? text : "");
                }
            }, 3, null);
        }
        prefillInput(materialDialog, charSequence, num2, z2);
        styleInput(materialDialog, str, num, i);
        if (num3 != null) {
            TextInputLayout inputLayout = getInputLayout(materialDialog);
            inputLayout.setCounterEnabled(true);
            inputLayout.setCounterMaxLength(num3.intValue());
            InputUtilExtKt.invalidateInputMaxLength(materialDialog, z2);
        }
        MDUtil.INSTANCE.textChanged(getInputField(materialDialog), new Function1<CharSequence, Unit>() { // from class: com.afollestad.materialdialogs.input.DialogInputExtKt$input$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CharSequence charSequence2) {
                invoke2(charSequence2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CharSequence charSequence2) {
                Function2 function22;
                Intrinsics.checkParameterIsNotNull(charSequence2, "");
                if (!z2) {
                    DialogActionExtKt.setActionButtonEnabled(MaterialDialog.this, WhichButton.POSITIVE, charSequence2.length() > 0);
                }
                if (num3 != null) {
                    InputUtilExtKt.invalidateInputMaxLength(MaterialDialog.this, z2);
                }
                if (z || (function22 = function2) == null) {
                    return;
                }
                function22.invoke(MaterialDialog.this, charSequence2);
            }
        });
        return materialDialog;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0049, code lost:
    
        if ((r4.length() > 0) != false) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void prefillInput(com.afollestad.materialdialogs.MaterialDialog r3, final java.lang.CharSequence r4, java.lang.Integer r5, boolean r6) {
        /*
            android.content.Context r0 = r3.getWindowContext()
            android.content.res.Resources r0 = r0.getResources()
            android.widget.EditText r1 = getInputField(r3)
            if (r4 != 0) goto L22
            java.lang.String r4 = ""
            if (r5 == 0) goto L1b
            int r5 = r5.intValue()
            java.lang.String r5 = r0.getString(r5)
            goto L1c
        L1b:
            r5 = r4
        L1c:
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r4)
            r4 = r5
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
        L22:
            int r5 = r4.length()
            r0 = 0
            r2 = 1
            if (r5 <= 0) goto L2c
            r5 = 1
            goto L2d
        L2c:
            r5 = 0
        L2d:
            if (r5 == 0) goto L3c
            r1.setText(r4)
            com.afollestad.materialdialogs.input.DialogInputExtKt$prefillInput$1 r5 = new com.afollestad.materialdialogs.input.DialogInputExtKt$prefillInput$1
            r5.<init>()
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            com.afollestad.materialdialogs.callbacks.DialogCallbackExtKt.onShow(r3, r5)
        L3c:
            com.afollestad.materialdialogs.WhichButton r5 = com.afollestad.materialdialogs.WhichButton.POSITIVE
            if (r6 != 0) goto L4b
            int r4 = r4.length()
            if (r4 <= 0) goto L48
            r4 = 1
            goto L49
        L48:
            r4 = 0
        L49:
            if (r4 == 0) goto L4c
        L4b:
            r0 = 1
        L4c:
            com.afollestad.materialdialogs.actions.DialogActionExtKt.setActionButtonEnabled(r3, r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.input.DialogInputExtKt.prefillInput(com.afollestad.materialdialogs.MaterialDialog, java.lang.CharSequence, java.lang.Integer, boolean):void");
    }

    private static final void styleInput(MaterialDialog materialDialog, String str, Integer num, int i) {
        Resources resources = materialDialog.getWindowContext().getResources();
        EditText inputField = getInputField(materialDialog);
        TextInputLayout inputLayout = getInputLayout(materialDialog);
        if (str == null) {
            str = num != null ? resources.getString(num.intValue()) : null;
        }
        inputLayout.setHint(str);
        inputField.setInputType(i);
        MDUtil.INSTANCE.maybeSetTextColor(inputField, materialDialog.getWindowContext(), Integer.valueOf(R.attr.md_color_content), Integer.valueOf(R.attr.md_color_hint));
        Typeface bodyFont = materialDialog.getBodyFont();
        if (bodyFont != null) {
            inputField.setTypeface(bodyFont);
        }
    }
}
