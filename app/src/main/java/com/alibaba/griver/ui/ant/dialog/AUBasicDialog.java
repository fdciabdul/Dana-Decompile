package com.alibaba.griver.ui.ant.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.ui.ant.api.AUPopSupportPreemption;
import com.alibaba.griver.ui.ant.dialog.PopManager;
import com.alibaba.griver.ui.ant.utils.ViewUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes6.dex */
public class AUBasicDialog extends Dialog implements AUPopSupportPreemption {
    public static final int PRIORITY_BELOW_CDP = 40;
    public static final int PRIORITY_BETWEEN_CDP_SHARE_TOKEN = 55;
    public static final int PRIORITY_BIZ = 100;
    public static final int PRIORITY_CDP = 50;
    public static final int PRIORITY_SHARE_TOKEN = 60;
    public static final int PRIORITY_UNDEFINED = 0;

    /* renamed from: a  reason: collision with root package name */
    private Handler f6674a;
    private DialogInterface.OnDismissListener b;
    private DialogInterface.OnCancelListener c;
    private int d;
    private boolean e;
    protected Context mContext;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Priority {
    }

    public AUBasicDialog(Context context) {
        super(context);
        this.f6674a = new Handler(Looper.getMainLooper());
        this.b = null;
        this.c = null;
        this.d = 100;
        this.e = Looper.myLooper() == Looper.getMainLooper();
        this.mContext = context;
    }

    public AUBasicDialog(Context context, int i) {
        super(context, i);
        this.f6674a = new Handler(Looper.getMainLooper());
        this.b = null;
        this.c = null;
        this.d = 100;
        this.e = Looper.myLooper() == Looper.getMainLooper();
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AUBasicDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        this.f6674a = new Handler(Looper.getMainLooper());
        this.b = null;
        this.c = null;
        this.d = 100;
        this.e = Looper.myLooper() == Looper.getMainLooper();
        this.mContext = context;
    }

    public void show(int i) {
        this.d = i;
        show();
    }

    @Override // android.app.Dialog
    public void show() {
        if (!a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Activity is finish:");
            sb.append(this);
            GriverLogger.d("AUBasicDialog", sb.toString());
        } else if (!PopManager.isOpen()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("direct show:");
            sb2.append(this.mContext);
            sb2.append(",");
            sb2.append(this);
            GriverLogger.d("AUBasicDialog", sb2.toString());
            super.show();
        } else {
            PopManager.PopBean findPop = PopManager.findPop(this);
            if (findPop != null && findPop.isRegister) {
                if (findPop.isQueue) {
                    return;
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("show:");
                sb3.append(this.mContext);
                sb3.append(",");
                sb3.append(this);
                GriverLogger.d("AUBasicDialog", sb3.toString());
                super.show();
                return;
            }
            PopManager.show(this);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            PopManager.dismiss(this);
        } else {
            this.f6674a.post(new Runnable() { // from class: com.alibaba.griver.ui.ant.dialog.AUBasicDialog.1
                @Override // java.lang.Runnable
                public void run() {
                    PopManager.dismiss(AUBasicDialog.this);
                }
            });
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        StringBuilder sb = new StringBuilder();
        sb.append("onDetachedFromWindow:");
        sb.append(this.mContext);
        sb.append(",");
        sb.append(this);
        GriverLogger.d("AUBasicDialog", sb.toString());
        PopManager.dismiss(this);
    }

    private boolean a() {
        Activity activityByContext;
        Context context = this.mContext;
        if (context == null || (activityByContext = ViewUtils.getActivityByContext(context)) == null) {
            return false;
        }
        if (activityByContext.isFinishing() || activityByContext.isDestroyed()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Activity is finish,name=");
            sb.append(activityByContext.getClass().getName());
            GriverLogger.d("AUDialog", sb.toString());
            return false;
        }
        return true;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        LocalBroadcastManager.getInstance(getContext()).sendBroadcast(new Intent("com.alipay.mobile.antui.basic.AUBasicDialog"));
    }

    @Override // com.alibaba.griver.ui.ant.api.AUPop
    public Activity getPopActivity() {
        return ViewUtils.getActivityByContext(getContext());
    }

    @Override // com.alibaba.griver.ui.ant.api.AUPop
    public void showPop() {
        show();
    }

    @Override // com.alibaba.griver.ui.ant.api.AUPop
    public int getPriority() {
        return this.d;
    }

    public void setPriority(int i) {
        this.d = i;
    }

    @Override // com.alibaba.griver.ui.ant.api.AUPopSupportPreemption
    public void onPreemption() {
        StringBuilder sb = new StringBuilder();
        sb.append("onPreemption:");
        sb.append(this);
        GriverLogger.d("AUBasicDialog", sb.toString());
        super.setOnCancelListener(null);
        super.setOnDismissListener(null);
        dismissPop();
        super.setOnCancelListener(this.c);
        super.setOnDismissListener(this.b);
    }

    @Override // com.alibaba.griver.ui.ant.api.AUPop
    public void dismissPop() {
        if (Looper.myLooper() != Looper.getMainLooper() && !a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Activity is finish:");
            sb.append(this);
            GriverLogger.d("AUBasicDialog", sb.toString());
        } else if (isShowing()) {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("isShowing() == true, dismiss:");
                sb2.append(this);
                GriverLogger.d("AUBasicDialog", sb2.toString());
                super.dismiss();
            } catch (IllegalArgumentException e) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("IllegalArgumentException: e");
                sb3.append(e);
                GriverLogger.e("AUBasicDialog", sb3.toString());
            }
        }
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        if (view == null) {
            return;
        }
        super.setContentView(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setWindowMaxWidth(int i) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        getWindow().setAttributes(attributes);
        View decorView = getWindow().getDecorView();
        if (decorView != null) {
            decorView.setPadding(i, 0, i, 0);
        }
    }

    public boolean isCreateInUIThread() {
        return this.e;
    }

    @Override // android.app.Dialog
    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.c = onCancelListener;
        super.setOnCancelListener(onCancelListener);
    }

    @Override // android.app.Dialog
    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.b = onDismissListener;
        super.setOnDismissListener(onDismissListener);
    }
}
