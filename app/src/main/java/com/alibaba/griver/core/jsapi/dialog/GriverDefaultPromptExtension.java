package com.alibaba.griver.core.jsapi.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.alibaba.ariver.app.api.point.dialog.CreateDialogParam;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.DimensionUtil;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.api.ui.dialog.GriverCreatePromptParam;
import com.alibaba.griver.api.ui.dialog.GriverDialogExtension;
import com.alibaba.griver.api.ui.dialog.GriverPromptExtension;
import com.alipay.mobile.zebra.data.TextData;
import id.dana.mybills.ui.constant.MyBillsPurposeAction;

/* loaded from: classes6.dex */
public class GriverDefaultPromptExtension implements GriverPromptExtension {
    @Override // com.alibaba.griver.api.ui.dialog.GriverPromptExtension
    public Dialog createDialog(final Activity activity, final GriverCreatePromptParam griverCreatePromptParam) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        final EditText editText = new EditText(activity);
        if (!TextUtils.isEmpty(griverCreatePromptParam.getPlaceHolder())) {
            editText.setHint(griverCreatePromptParam.getPlaceHolder());
        }
        String align = griverCreatePromptParam.getAlign();
        if (!TextUtils.isEmpty(align)) {
            align.hashCode();
            char c = 65535;
            int hashCode = align.hashCode();
            if (hashCode != -1364013995) {
                if (hashCode != 3317767) {
                    if (hashCode == 108511772 && align.equals("right")) {
                        c = 2;
                    }
                } else if (align.equals("left")) {
                    c = 1;
                }
            } else if (align.equals(TextData.ALIGN_CENTER)) {
                c = 0;
            }
            if (c == 0) {
                editText.setGravity(17);
            } else if (c == 1) {
                editText.setGravity(8388611);
            } else if (c == 2) {
                editText.setGravity(8388613);
            }
        }
        if (!TextUtils.isEmpty(griverCreatePromptParam.getTitle())) {
            builder.setTitle(griverCreatePromptParam.getTitle());
        }
        if (!TextUtils.isEmpty(griverCreatePromptParam.getMessage())) {
            builder.setMessage(griverCreatePromptParam.getMessage());
        }
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.alibaba.griver.core.jsapi.dialog.GriverDefaultPromptExtension.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                GriverDefaultPromptExtension griverDefaultPromptExtension = GriverDefaultPromptExtension.this;
                Activity activity2 = activity;
                griverDefaultPromptExtension.a(activity2, activity2.getWindow().getDecorView());
                if (griverCreatePromptParam.positiveListener != null) {
                    griverCreatePromptParam.positiveListener.onClick(dialogInterface, editText.getText().toString());
                }
            }
        };
        String positiveString = griverCreatePromptParam.getPositiveString();
        if (TextUtils.isEmpty(positiveString)) {
            positiveString = "Confirm";
        }
        builder.setPositiveButton(positiveString, onClickListener);
        DialogInterface.OnClickListener onClickListener2 = new DialogInterface.OnClickListener() { // from class: com.alibaba.griver.core.jsapi.dialog.GriverDefaultPromptExtension.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                GriverDefaultPromptExtension griverDefaultPromptExtension = GriverDefaultPromptExtension.this;
                Activity activity2 = activity;
                griverDefaultPromptExtension.a(activity2, activity2.getWindow().getDecorView());
                if (griverCreatePromptParam.negativeListener != null) {
                    griverCreatePromptParam.negativeListener.onClick(dialogInterface, i);
                }
            }
        };
        String negativeString = griverCreatePromptParam.getNegativeString();
        if (TextUtils.isEmpty(negativeString)) {
            negativeString = MyBillsPurposeAction.CANCEL;
        }
        builder.setNegativeButton(negativeString, onClickListener2);
        builder.setCancelable(griverCreatePromptParam.cancelable);
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.alibaba.griver.core.jsapi.dialog.GriverDefaultPromptExtension.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                GriverDefaultPromptExtension griverDefaultPromptExtension = GriverDefaultPromptExtension.this;
                Activity activity2 = activity;
                griverDefaultPromptExtension.a(activity2, activity2.getWindow().getDecorView());
                if (griverCreatePromptParam.cancelListener != null) {
                    griverCreatePromptParam.cancelListener.onCancel(dialogInterface);
                }
            }
        });
        AlertDialog create = builder.create();
        create.setView(editText, DimensionUtil.dip2px(activity, 15.0f), 0, DimensionUtil.dip2px(activity, 15.0f), 0);
        return create;
    }

    @Override // com.alibaba.griver.api.ui.dialog.GriverPromptExtension
    public void applyShow(Dialog dialog, GriverCreatePromptParam griverCreatePromptParam) {
        if (dialog instanceof AlertDialog) {
            CreateDialogParam createDialogParam = null;
            if (griverCreatePromptParam != null) {
                createDialogParam = new CreateDialogParam(griverCreatePromptParam.getTitle(), griverCreatePromptParam.getMessage(), griverCreatePromptParam.getPositiveString(), griverCreatePromptParam.getNegativeString(), griverCreatePromptParam.getAlign());
                createDialogParam.positiveTextColor = griverCreatePromptParam.positiveTextColor;
                createDialogParam.negativeTextColor = griverCreatePromptParam.negativeTextColor;
            }
            ((GriverDialogExtension) RVProxy.get(GriverDialogExtension.class)).applyShow(dialog, createDialogParam);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, View view) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        } catch (Throwable th) {
            RVLogger.e("GriverDefaultPromptExtension", "hideKeyboard exception!", th);
        }
    }
}
