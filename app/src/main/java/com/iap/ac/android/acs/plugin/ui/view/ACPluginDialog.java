package com.iap.ac.android.acs.plugin.ui.view;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.TextView;
import com.iap.ac.android.acs.plugin.ui.utils.UIUtils;
import com.iap.ac.android.acs.transition.R;
import com.iap.ac.android.common.log.ACLog;

/* loaded from: classes8.dex */
public class ACPluginDialog extends Dialog implements View.OnClickListener {
    public Activity mActivity;
    public OnCancelListener mOnCancelListener;
    public OnConfirmListener mOnConfirmListener;

    /* loaded from: classes8.dex */
    public interface OnCancelListener {
        void onCancel();
    }

    /* loaded from: classes8.dex */
    public interface OnConfirmListener {
        void onConfirm();
    }

    public ACPluginDialog(Activity activity, String str, String str2, String str3) {
        super(activity, R.style.ACPlugin_Style_Dialog);
        this.mActivity = activity;
        setContentView(R.layout.acplugin_layout_dialog);
        ((TextView) findViewById(R.id.desc_text)).setText(str);
        TextView textView = (TextView) findViewById(R.id.cancel_text);
        textView.setText(str2);
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(R.id.confirm_text);
        textView2.setText(str3);
        textView2.setOnClickListener(this);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (UIUtils.isActivityDisabled(this.mActivity)) {
            return;
        }
        super.dismiss();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (UIUtils.isActivityDisabled(this.mActivity)) {
            ACLog.d("IAPConnectPlugin", "ACPluginDialog#onClick, activity is disabled");
        } else if (view.getId() == R.id.cancel_text) {
            ACLog.d("IAPConnectPlugin", "ACPluginDialog#onClick, click cancel button");
            OnCancelListener onCancelListener = this.mOnCancelListener;
            if (onCancelListener != null) {
                onCancelListener.onCancel();
            }
            dismiss();
        } else if (view.getId() == R.id.confirm_text) {
            ACLog.d("IAPConnectPlugin", "ACPluginDialog#onClick, click confirm button");
            OnConfirmListener onConfirmListener = this.mOnConfirmListener;
            if (onConfirmListener != null) {
                onConfirmListener.onConfirm();
            }
            dismiss();
        }
    }

    public void setCancelListener(OnCancelListener onCancelListener) {
        this.mOnCancelListener = onCancelListener;
    }

    public void setConfirmListener(OnConfirmListener onConfirmListener) {
        this.mOnConfirmListener = onConfirmListener;
    }

    @Override // android.app.Dialog
    public void show() {
        if (UIUtils.isActivityDisabled(this.mActivity)) {
            return;
        }
        super.show();
    }
}
