package com.alipay.mobile.verifyidentity.uitools.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.alipay.mobile.verifyidentity.uitools.R;

/* loaded from: classes3.dex */
public class SubmittingDialog extends Dialog {
    private final float HEIGHT;
    private final float WIDTH;
    private Activity mActivity;
    private Context mContext;
    View root;

    public SubmittingDialog(Context context) {
        super(context, R.style.submitting_dialog);
        this.WIDTH = 88.0f;
        this.HEIGHT = 88.0f;
        init(context);
    }

    public SubmittingDialog(Context context, int i) {
        super(context, i);
        this.WIDTH = 88.0f;
        this.HEIGHT = 88.0f;
        init(context);
    }

    protected SubmittingDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        this.WIDTH = 88.0f;
        this.HEIGHT = 88.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        if (context instanceof Activity) {
            this.mActivity = (Activity) context;
        }
        this.root = LayoutInflater.from(context).inflate(R.layout.submitting_dialog, (ViewGroup) null);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.mActivity == null) {
            return;
        }
        super.show();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.height = (int) (this.mContext.getResources().getDisplayMetrics().density * 88.0f);
        attributes.width = (int) (this.mContext.getResources().getDisplayMetrics().density * 88.0f);
        getWindow().setAttributes(attributes);
        setContentView(this.root);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.mActivity == null) {
            super.hide();
        } else {
            super.dismiss();
        }
    }
}
