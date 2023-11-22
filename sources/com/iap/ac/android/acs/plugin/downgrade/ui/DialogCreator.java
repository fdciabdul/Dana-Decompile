package com.iap.ac.android.acs.plugin.downgrade.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.iap.ac.android.acs.transition.R;

/* loaded from: classes3.dex */
public class DialogCreator {
    public static Dialog createDialog(Context context, String str, boolean z, String str2, String str3, final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2) {
        final Dialog dialog = new Dialog(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.acplugin_layout_confirm_view, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_message);
        TextView textView2 = (TextView) inflate.findViewById(R.id.btn_confirm);
        TextView textView3 = (TextView) inflate.findViewById(R.id.btn_cancel);
        textView.setText(str);
        textView2.setText(str2);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.iap.ac.android.acs.plugin.downgrade.ui.DialogCreator.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                View.OnClickListener onClickListener3 = onClickListener;
                if (onClickListener3 != null) {
                    onClickListener3.onClick(view);
                }
                dialog.dismiss();
            }
        });
        if (z) {
            textView3.setText(str3);
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.iap.ac.android.acs.plugin.downgrade.ui.DialogCreator.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    View.OnClickListener onClickListener3 = onClickListener2;
                    if (onClickListener3 != null) {
                        onClickListener3.onClick(view);
                    }
                    dialog.dismiss();
                }
            });
        } else {
            textView3.setVisibility(8);
        }
        dialog.setContentView(inflate);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setLayout(-1, -2);
        }
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        return dialog;
    }
}
