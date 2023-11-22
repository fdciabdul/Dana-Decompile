package com.iap.ac.android.acs.plugin.ui.view;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.widget.TextView;
import com.iap.ac.android.acs.plugin.ui.utils.UIUtils;
import com.iap.ac.android.acs.transition.R;
import com.iap.ac.android.common.log.ACLog;

/* loaded from: classes8.dex */
public class ACPluginLoadingDialog extends Dialog {
    public Activity mActivity;
    public TextView mDescText;
    public ACPluginLoadingView mLoadingView;

    public ACPluginLoadingDialog(Activity activity) {
        super(activity, R.style.ACPlugin_Style_LoadingDialog);
        this.mActivity = activity;
        setContentView(R.layout.acplugin_layout_loading_dialog);
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        this.mLoadingView = (ACPluginLoadingView) findViewById(R.id.loading_view);
        this.mDescText = (TextView) findViewById(R.id.desc_text);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.mLoadingView != null) {
            ACLog.d("IAPConnectPlugin", "ACPluginLoadingDialog#dismiss, stop loading animation");
            this.mLoadingView.stop();
        }
        if (UIUtils.isActivityDisabled(this.mActivity)) {
            return;
        }
        super.dismiss();
    }

    public void setText(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.mDescText.setText(charSequence);
            this.mDescText.setVisibility(0);
            return;
        }
        this.mDescText.setVisibility(8);
    }

    @Override // android.app.Dialog
    public void show() {
        if (UIUtils.isActivityDisabled(this.mActivity)) {
            return;
        }
        super.show();
    }
}
