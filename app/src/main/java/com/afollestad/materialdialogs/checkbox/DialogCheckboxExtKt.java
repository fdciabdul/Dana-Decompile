package com.afollestad.materialdialogs.checkbox;

import android.graphics.Typeface;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.widget.CompoundButtonCompat;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.internal.button.DialogActionButtonLayout;
import com.afollestad.materialdialogs.utils.ColorsKt;
import com.afollestad.materialdialogs.utils.MDUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aM\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0004\u0018\u0001`\t¢\u0006\u0004\b\u000b\u0010\f\u001a\u0011\u0010\u000e\u001a\u00020\r*\u00020\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0011\u0010\u0010\u001a\u00020\u0005*\u00020\u0000¢\u0006\u0004\b\u0010\u0010\u0011*&\u0010\u0012\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007"}, d2 = {"Lcom/afollestad/materialdialogs/MaterialDialog;", "", "res", "", "text", "", "isCheckedDefault", "Lkotlin/Function1;", "", "Lcom/afollestad/materialdialogs/checkbox/BooleanCallback;", "onToggle", "checkBoxPrompt", "(Lcom/afollestad/materialdialogs/MaterialDialog;ILjava/lang/String;ZLkotlin/jvm/functions/Function1;)Lcom/afollestad/materialdialogs/MaterialDialog;", "Landroid/widget/CheckBox;", "getCheckBoxPrompt", "(Lcom/afollestad/materialdialogs/MaterialDialog;)Landroid/widget/CheckBox;", "isCheckPromptChecked", "(Lcom/afollestad/materialdialogs/MaterialDialog;)Z", "BooleanCallback"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class DialogCheckboxExtKt {
    public static final CheckBox getCheckBoxPrompt(MaterialDialog materialDialog) {
        AppCompatCheckBox checkBoxPrompt;
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        DialogActionButtonLayout buttonsLayout = materialDialog.getView().getButtonsLayout();
        if (buttonsLayout == null || (checkBoxPrompt = buttonsLayout.getCheckBoxPrompt()) == null) {
            throw new IllegalStateException("The dialog does not have an attached buttons layout.");
        }
        return checkBoxPrompt;
    }

    public static final boolean isCheckPromptChecked(MaterialDialog materialDialog) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        return getCheckBoxPrompt(materialDialog).isChecked();
    }

    public static /* synthetic */ MaterialDialog checkBoxPrompt$default(MaterialDialog materialDialog, int i, String str, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return checkBoxPrompt(materialDialog, i, str, z, function1);
    }

    public static final MaterialDialog checkBoxPrompt(final MaterialDialog materialDialog, final int i, final String str, final boolean z, final Function1<? super Boolean, Unit> function1) {
        AppCompatCheckBox checkBoxPrompt;
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        MDUtil.INSTANCE.assertOneSet("checkBoxPrompt", str, Integer.valueOf(i));
        DialogActionButtonLayout buttonsLayout = materialDialog.getView().getButtonsLayout();
        if (buttonsLayout != null && (checkBoxPrompt = buttonsLayout.getCheckBoxPrompt()) != null) {
            checkBoxPrompt.setVisibility(0);
            checkBoxPrompt.setText(str != null ? str : MDUtil.resolveString$default(MDUtil.INSTANCE, materialDialog, Integer.valueOf(i), (Integer) null, false, 12, (Object) null));
            checkBoxPrompt.setChecked(z);
            checkBoxPrompt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.afollestad.materialdialogs.checkbox.DialogCheckboxExtKt$checkBoxPrompt$$inlined$run$lambda$1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                    Function1 function12 = function1;
                    if (function12 != null) {
                        Unit unit = (Unit) function12.invoke(Boolean.valueOf(z2));
                    }
                }
            });
            MDUtil.maybeSetTextColor$default(MDUtil.INSTANCE, checkBoxPrompt, materialDialog.getWindowContext(), Integer.valueOf(R.attr.md_color_content), null, 4, null);
            Typeface bodyFont = materialDialog.getBodyFont();
            if (bodyFont != null) {
                checkBoxPrompt.setTypeface(bodyFont);
            }
            int[] resolveColors$default = ColorsKt.resolveColors$default(materialDialog, new int[]{R.attr.md_color_widget, R.attr.md_color_widget_unchecked}, null, 2, null);
            CompoundButtonCompat.KClassImpl$Data$declaredNonStaticMembers$2(checkBoxPrompt, MDUtil.INSTANCE.createColorSelector(materialDialog.getWindowContext(), resolveColors$default[1], resolveColors$default[0]));
        }
        return materialDialog;
    }
}
