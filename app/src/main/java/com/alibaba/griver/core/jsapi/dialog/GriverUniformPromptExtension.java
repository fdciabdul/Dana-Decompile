package com.alibaba.griver.core.jsapi.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.api.ui.dialog.GriverCreatePromptParam;
import com.alibaba.griver.api.ui.dialog.GriverPromptExtension;
import com.alibaba.griver.core.R;
import com.alibaba.griver.core.ui.dialog.GriverDialog;
import id.dana.mybills.ui.constant.MyBillsPurposeAction;

/* loaded from: classes6.dex */
public class GriverUniformPromptExtension implements GriverPromptExtension {
    @Override // com.alibaba.griver.api.ui.dialog.GriverPromptExtension
    public void applyShow(Dialog dialog, GriverCreatePromptParam griverCreatePromptParam) {
    }

    @Override // com.alibaba.griver.api.ui.dialog.GriverPromptExtension
    public Dialog createDialog(final Activity activity, final GriverCreatePromptParam griverCreatePromptParam) {
        GriverDialog.Builder builder = new GriverDialog.Builder(activity);
        View inflate = LayoutInflater.from(activity).inflate(R.layout.griver_core_edit_layout, (ViewGroup) null);
        final EditText editText = (EditText) inflate.findViewById(R.id.edit);
        editText.setMaxLines(1);
        editText.setSingleLine();
        if (!TextUtils.isEmpty(griverCreatePromptParam.getPlaceHolder())) {
            editText.setHint(griverCreatePromptParam.getPlaceHolder());
        }
        builder.align(griverCreatePromptParam.getAlign());
        builder.view(inflate);
        if (!TextUtils.isEmpty(griverCreatePromptParam.getTitle())) {
            builder.title(griverCreatePromptParam.getTitle());
        }
        if (!TextUtils.isEmpty(griverCreatePromptParam.getMessage())) {
            builder.message(griverCreatePromptParam.getMessage());
        }
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.alibaba.griver.core.jsapi.dialog.GriverUniformPromptExtension.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                GriverUniformPromptExtension griverUniformPromptExtension = GriverUniformPromptExtension.this;
                Activity activity2 = activity;
                griverUniformPromptExtension.a(activity2, activity2.getWindow().getDecorView());
                if (griverCreatePromptParam.positiveListener != null) {
                    griverCreatePromptParam.positiveListener.onClick(dialogInterface, editText.getText().toString());
                }
            }
        };
        String positiveString = griverCreatePromptParam.getPositiveString();
        if (TextUtils.isEmpty(positiveString)) {
            positiveString = "Confirm";
        }
        builder.positiveString(positiveString).positiveTextColor(griverCreatePromptParam.positiveTextColor).positiveListener(onClickListener);
        DialogInterface.OnClickListener onClickListener2 = new DialogInterface.OnClickListener() { // from class: com.alibaba.griver.core.jsapi.dialog.GriverUniformPromptExtension.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                GriverUniformPromptExtension griverUniformPromptExtension = GriverUniformPromptExtension.this;
                Activity activity2 = activity;
                griverUniformPromptExtension.a(activity2, activity2.getWindow().getDecorView());
                if (griverCreatePromptParam.negativeListener != null) {
                    griverCreatePromptParam.negativeListener.onClick(dialogInterface, i);
                }
            }
        };
        String negativeString = griverCreatePromptParam.getNegativeString();
        if (TextUtils.isEmpty(negativeString)) {
            negativeString = MyBillsPurposeAction.CANCEL;
        }
        builder.negativeString(negativeString).negativeTextColor(griverCreatePromptParam.negativeTextColor).negativeListener(onClickListener2);
        builder.cancelable(griverCreatePromptParam.cancelable);
        builder.cancelListener(new DialogInterface.OnCancelListener() { // from class: com.alibaba.griver.core.jsapi.dialog.GriverUniformPromptExtension.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                GriverUniformPromptExtension griverUniformPromptExtension = GriverUniformPromptExtension.this;
                Activity activity2 = activity;
                griverUniformPromptExtension.a(activity2, activity2.getWindow().getDecorView());
                if (griverCreatePromptParam.cancelListener != null) {
                    griverCreatePromptParam.cancelListener.onCancel(dialogInterface);
                }
            }
        });
        return builder.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, View view) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        } catch (Throwable th) {
            RVLogger.e("GriverUniformPromptExtension", "hideKeyboard exception!", th);
        }
    }
}
