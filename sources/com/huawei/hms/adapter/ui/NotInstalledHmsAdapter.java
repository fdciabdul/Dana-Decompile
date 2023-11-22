package com.huawei.hms.adapter.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.ui.NotInstalledHmsDialogHelper;

/* loaded from: classes7.dex */
public class NotInstalledHmsAdapter implements IBridgeActivityDelegate {
    public static final Object c = new Object();
    public static boolean d;

    /* renamed from: a  reason: collision with root package name */
    public Activity f7453a;
    public Dialog b;

    /* loaded from: classes7.dex */
    public static class a implements DialogInterface.OnCancelListener {

        /* renamed from: a  reason: collision with root package name */
        public final Activity f7454a;

        public a(Activity activity) {
            this.f7454a = activity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            HMSLog.i("NotInstalledHmsAdapter", "<Dialog onCancel>");
            SystemManager.getInstance().notifyUpdateResult(13);
            this.f7454a.finish();
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final Activity f7455a;

        public b(Activity activity) {
            this.f7455a = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            HMSLog.i("NotInstalledHmsAdapter", "<Dialog onClick>");
            SystemManager.getInstance().notifyUpdateResult(30);
            this.f7455a.finish();
        }
    }

    public static boolean getShowLock() {
        synchronized (c) {
            StringBuilder sb = new StringBuilder();
            sb.append("<canShowDialog> sIsShowingDialog: ");
            sb.append(d);
            HMSLog.i("NotInstalledHmsAdapter", sb.toString());
            if (d) {
                return false;
            }
            d = true;
            return true;
        }
    }

    public final void a(Activity activity) {
        Dialog dialog = this.b;
        if (dialog != null && dialog.isShowing()) {
            this.b.setOnCancelListener(null);
            this.b.cancel();
        }
        this.b = NotInstalledHmsDialogHelper.getDialogBuilder(activity).setPositiveButton(NotInstalledHmsDialogHelper.getConfirmResId(activity), new b(activity)).setOnCancelListener(new a(activity)).show();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        HMSLog.i("NotInstalledHmsAdapter", "<getRequestCode>");
        return 0;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        HMSLog.i("NotInstalledHmsAdapter", "<onBridgeActivityCreate>");
        if (activity != null && !activity.isFinishing()) {
            this.f7453a = activity;
            a(activity);
            return;
        }
        HMSLog.e("NotInstalledHmsAdapter", "<onBridgeActivityCreate> activity is null or finishing");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.i("NotInstalledHmsAdapter", "<onBridgeActivityDestroy>");
        synchronized (c) {
            d = false;
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i, int i2, Intent intent) {
        HMSLog.i("NotInstalledHmsAdapter", "<onBridgeActivityResult>");
        return false;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        HMSLog.i("NotInstalledHmsAdapter", "<onBridgeConfigurationChanged>");
        Activity activity = this.f7453a;
        if (activity != null && !activity.isFinishing()) {
            a(this.f7453a);
        } else {
            HMSLog.e("NotInstalledHmsAdapter", "<onBridgeConfigurationChanged> mActivity is null or finishing");
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i, KeyEvent keyEvent) {
        HMSLog.i("NotInstalledHmsAdapter", "<onKeyUp>");
    }
}
