package com.alibaba.griver.core.jsapi.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.Button;
import com.alibaba.ariver.app.api.point.dialog.CreateDialogParam;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.api.ui.dialog.GriverCreateDialogParam;
import com.alibaba.griver.api.ui.dialog.GriverDialogExtension;
import com.alibaba.griver.base.common.logger.GriverLogger;

/* loaded from: classes6.dex */
public class GriverDefaultDialogExtension implements GriverDialogExtension {
    @Override // com.alibaba.griver.api.ui.dialog.GriverDialogExtension
    public Dialog createDialog(Activity activity, CreateDialogParam createDialogParam) {
        if (TextUtils.isEmpty(createDialogParam.getTitle()) && TextUtils.isEmpty(createDialogParam.getMessage())) {
            RVLogger.w("GriverDefaultDialogExtension", "empty title and message");
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        if (!TextUtils.isEmpty(createDialogParam.getTitle())) {
            builder.setTitle(createDialogParam.getTitle());
        }
        if (!TextUtils.isEmpty(createDialogParam.getMessage())) {
            builder.setMessage(createDialogParam.getMessage());
        }
        if (!TextUtils.isEmpty(createDialogParam.getPositiveString())) {
            builder.setPositiveButton(createDialogParam.getPositiveString(), createDialogParam.positiveListener);
        }
        if (!TextUtils.isEmpty(createDialogParam.getNegativeString())) {
            builder.setNegativeButton(createDialogParam.getNegativeString(), createDialogParam.negativeListener);
        }
        builder.setCancelable(createDialogParam.cancelable);
        builder.setOnCancelListener(createDialogParam.cancelListener);
        AlertDialog create = builder.create();
        if (createDialogParam instanceof GriverCreateDialogParam) {
            create.setView(((GriverCreateDialogParam) createDialogParam).customView);
        }
        return create;
    }

    @Override // com.alibaba.griver.api.ui.dialog.GriverDialogExtension
    public void applyShow(Dialog dialog, CreateDialogParam createDialogParam) {
        if (dialog instanceof AlertDialog) {
            AlertDialog alertDialog = (AlertDialog) dialog;
            Button button = alertDialog.getButton(-1);
            Button button2 = alertDialog.getButton(-2);
            a(button, createDialogParam == null ? null : createDialogParam.positiveTextColor);
            a(button2, createDialogParam != null ? createDialogParam.negativeTextColor : null);
        }
    }

    private void a(Button button, String str) {
        if (button == null) {
            return;
        }
        button.setAllCaps(false);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            button.setTextColor(Color.parseColor(str));
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("parse color failed: ");
            sb.append(str);
            GriverLogger.e("GriverDefaultDialogExtension", sb.toString(), e);
        }
    }
}
