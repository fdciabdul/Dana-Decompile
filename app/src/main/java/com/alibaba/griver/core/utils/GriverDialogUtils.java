package com.alibaba.griver.core.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.alibaba.griver.core.R;

/* loaded from: classes6.dex */
public class GriverDialogUtils {
    public static Dialog createBottomDialog(Context context, int i) {
        return createDialog(context, i, 80);
    }

    public static Dialog createDialog(Context context, int i, int i2) {
        return createDialog(context, i, -1, -2, i2);
    }

    public static Dialog createDialog(Context context, int i, int i2, int i3, int i4) {
        Dialog dialog = new Dialog(context, R.style.griver_customized_dialog);
        dialog.setContentView(i);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        Window window = dialog.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = i2;
        attributes.height = i3;
        attributes.gravity = i4;
        window.setAttributes(attributes);
        return dialog;
    }

    public static void showMessageBox(Context context, String str, String str2, final View.OnClickListener onClickListener) {
        final Dialog createDialog = createDialog(context, R.layout.griver_core_ui_message_box, 17);
        TextView textView = (TextView) createDialog.findViewById(R.id.message);
        TextView textView2 = (TextView) createDialog.findViewById(R.id.left_btn);
        ((TextView) createDialog.findViewById(R.id.right_btn)).setVisibility(8);
        createDialog.findViewById(R.id.vert_line).setVisibility(8);
        textView.setText(str);
        textView2.setText(str2);
        textView2.setBackgroundResource(R.drawable.griver_message_box_one);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.core.utils.GriverDialogUtils.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                createDialog.dismiss();
                View.OnClickListener onClickListener2 = onClickListener;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(view);
                }
            }
        });
        createDialog.show();
    }

    public static void showMessageBox(Context context, String str, String str2, String str3, final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2) {
        final Dialog createDialog = createDialog(context, R.layout.griver_core_ui_message_box, 17);
        TextView textView = (TextView) createDialog.findViewById(R.id.message);
        TextView textView2 = (TextView) createDialog.findViewById(R.id.left_btn);
        TextView textView3 = (TextView) createDialog.findViewById(R.id.right_btn);
        textView.setText(str);
        textView2.setText(str2);
        textView3.setText(str3);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.core.utils.GriverDialogUtils.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                createDialog.dismiss();
                View.OnClickListener onClickListener3 = onClickListener;
                if (onClickListener3 != null) {
                    onClickListener3.onClick(view);
                }
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.core.utils.GriverDialogUtils.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                createDialog.dismiss();
                View.OnClickListener onClickListener3 = onClickListener2;
                if (onClickListener3 != null) {
                    onClickListener3.onClick(view);
                }
            }
        });
        createDialog.show();
    }
}
